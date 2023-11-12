package automationrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import freemarker.log.Logger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com/features", glue = { "com.definitions" })
public class FeatureRunner extends AbstractTestNGCucumberTests {
	
	private static WebDriver driver;

	
	
	}


