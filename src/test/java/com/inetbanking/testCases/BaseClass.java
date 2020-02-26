package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.inetbanking.utilities.Helper;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	public static Logger logger;
	public ExtentReports report;
	public ExtentTest logger1;
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	@BeforeSuite
	public void setUpSuite() {

		Reporter.log("Setting up reports and Test getting started ", true);
		// excel = new ExcelDataProvider();
		// config = new ConfigDataProvider();
		// Extent Report
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/inetBanking_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User", "Sultan");
		report.attachReporter(extent);

		Reporter.log("Setting done and Test can be started ", true);

	}

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult results) {
		Reporter.log("Test is about to end", true);
		if (results.getStatus() == ITestResult.FAILURE) {
			// Take screenshot
			Helper.captureScreenshots(driver);
			try {
				logger1.fail("Test Failed ",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to capture screenshot" + e.getMessage());
			}
		} else if (results.getStatus() == ITestResult.SUCCESS) {
			try {
				logger1.pass("Test Passed ",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to capture screenshot" + e.getMessage());
			}
		} else if (results.getStatus() == ITestResult.SKIP) {
			try {
				logger1.skip("Test Skipped ",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to capture screenshot" + e.getMessage());
			}
		}
		report.flush();
		Reporter.log("Test completed and Extent Reports generated", true);
	}

}
