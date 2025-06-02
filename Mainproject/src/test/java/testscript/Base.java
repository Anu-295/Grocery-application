package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

public class Base {
	WaitUtilities implicitwait = new WaitUtilities();
	Properties prop;
	FileInputStream fs;
	WebDriver driver;

	@BeforeMethod(alwaysRun = true) // run in all the conditions
	@Parameters("browser") // giving parameterization
	public void InitialiseBrowser(String browser) throws Exception {
		Properties prop;
		FileInputStream fs;
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGFILE);// to read file from constant class
		prop.load(fs);// to load the file
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid browser");
		}

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
		implicitwait.implicitwait(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException // ITestResult is interface ittestresult is
																		// instance
	{
		if (itestresult.getStatus() == ITestResult.FAILURE)// if test result is failure
		{
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
		driver.quit();

	}

}
