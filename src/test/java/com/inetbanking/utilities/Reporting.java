/*
 * package com.inetbanking.utilities;
 * 
 * import java.io.File; import java.io.IOException; import
 * java.text.SimpleDateFormat; import java.util.Date;
 * 
 * import org.apache.commons.io.FileUtils; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * import org.openqa.selenium.WebDriver; import org.testng.ITestResult; import
 * org.testng.annotations.BeforeTest;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.reporter.ExtentHtmlReporter; import
 * com.aventstack.extentreports.reporter.configuration.Theme; import
 * com.inetbanking.testCases.BaseClass;
 * 
 * public class Reporting extends BaseClass { WebDriver driver; public
 * ExtentHtmlReporter htmlReporter; public ExtentReports extent; public
 * ExtentTest test;
 * 
 * @BeforeTest public void onStart() {
 * 
 * String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
 * Date()); // Timestamp String repName = "Test-Report-" + timeStamp + ".html";
 * System.out.println("File : " + repName); htmlReporter = new
 * ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" +
 * repName); // Specify // location
 * 
 * htmlReporter.config().setDocumentTitle("Inetbanking Test Project"); // Title
 * of the report
 * htmlReporter.config().setReportName("Functional Test Automation Report"); //
 * htmlReporter.config().setTheme(Theme.STANDARD);
 * 
 * extent = new ExtentReports();
 * 
 * extent.attachReporter(htmlReporter); extent.setSystemInfo("Host Name",
 * "localhost"); extent.setSystemInfo("Environment", "QA");
 * extent.setSystemInfo("User", "Sultan"); }
 * 
 * public void tearDown(ITestResult result) throws IOException { if
 * (result.getStatus() == ITestResult.FAILURE) { test.log(Status.FAIL,
 * "TESTCASE FAILED IS " + result.getName()); test.log(Status.FAIL,
 * "TESTCASE FAILED IS " + result.getThrowable()); String screenshotPath =
 * Reporting.getScreenshot(driver, result.getName());
 * test.addScreenCaptureFromPath(screenshotPath); } extent.flush(); }
 * 
 * public static String getScreenshot(WebDriver driver, String screenshotName)
 * throws IOException { String dateName = new
 * SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); TakesScreenshot ts =
 * (TakesScreenshot) driver; File source = ts.getScreenshotAs(OutputType.FILE);
 * 
 * String destination = System.getProperty("user.dir") + "/Screenshots/" +
 * screenshotName + dateName + ".png"; File finalDestination = new
 * File(destination);
 * 
 * FileUtils.copyFile(source, finalDestination); return destination;
 * 
 * } }
 */
