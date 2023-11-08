package com.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks1 {
	public static RemoteWebDriver driver;
    Configuration
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	public Properties prop;

	@Before
	public void setUp() throws IOException {
		String browserName = "Chrome";
		prop = new Properties();
		File file = new File("src\\main\\resources\\Config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		if (browserName == null) {
			browserName = "Chrome";
		} else if (browserName.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (browserName.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		else {
			System.out.println("Invalid Browser selection, opening default Browser");
			driver = new ChromeDriver();
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.get(prop.getProperty("app.url"));
			
		}
	

	@After
	public void tearDown() {
		driver.quit();
	}
}
