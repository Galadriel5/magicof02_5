package com.TestBase;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.module.Configuration;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.utilities.Screenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.it.Date;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Hooks1 {
	private static final Logger LOG = Logger.getLogger(Hooks1.class);
	
	public static RemoteWebDriver driver;
	public Configuration config;
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	public Properties prop;

	@Before
	public void setUp() throws IOException {
		// Configuration conf = new Configuration();
		// String browserName = "Chrome";
		prop = new Properties();
		File file = new File("src/main/resources/config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		String browserName = prop.getProperty("browserName");
		if (browserName == null)
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browserName.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		else {
		LOG.info("Invalid Browser selection, opening default Browser");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("app.url"));
	}

	
	@After
	public void captureScreenshot(Scenario scenario) throws IOException {
	    try {
	        if (scenario.isFailed()) {
	            String screenshotFileName = "FailedScreenshot";
	            AShot ashot = new AShot();
	            BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
	                    .takeScreenshot(Hooks1.getDriver()).getImage();
	            String baseDir = System.getProperty("user.dir");
	            ImageIO.write(img, "png", new File(baseDir + "/src/log/" + screenshotFileName + ".png"));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (Hooks1.getDriver() != null) {
	            Hooks1.getDriver().quit();
	        }
	    }
	}
}

	