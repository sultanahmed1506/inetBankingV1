/*
 * package com.inetbanking.utilities;
 * 
 * // Listener class to generate Extent reports
 * 
 * import java.io.File; import java.io.IOException; import
 * java.text.SimpleDateFormat; import java.util.Date;
 * 
 * import org.testng.ITestContext; import org.testng.ITestResult; import
 * org.testng.TestListenerAdapter;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.markuputils.ExtentColor; import
 * com.aventstack.extentreports.markuputils.MarkupHelper; import
 * com.aventstack.extentreports.reporter.ExtentHtmlReporter; import
 * com.aventstack.extentreports.reporter.configuration.ChartLocation; import
 * com.aventstack.extentreports.reporter.configuration.Theme;
 * 
 * public class Reporting2 extends TestListenerAdapter {
 * 
 * public ExtentHtmlReporter htmlReporter; public ExtentReports extent; public
 * ExtentTest logger;
 * 
 * public void onStart(ITestContext testContext) {
 * 
 * String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
 * Date()); // Timestamp String repName = "Test-Report-" + timeStamp + ".html";
 * System.out.println("File : " + repName); htmlReporter = new
 * ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" +
 * repName); // Specify // location
 * htmlReporter.loadXMLConfig(System.getProperty("user.dir") +
 * "/extent-config.xml");
 * 
 * htmlReporter.config().setDocumentTitle("Inetbanking Test Project"); // Title
 * // of the report
 * htmlReporter.config().setReportName("Functional Test Automation Report"); //
 * // Name of the report
 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // //
 * Location of the chart htmlReporter.config().setTheme(Theme.STANDARD);
 * 
 * extent = new ExtentReports();
 * 
 * extent.attachReporter(htmlReporter); extent.setSystemInfo("Host Name",
 * "localhost"); extent.setSystemInfo("Environment", "QA");
 * extent.setSystemInfo("User", "Sultan");
 * 
 * }
 * 
 * public void onTestSucess(ITestResult tr) { logger =
 * extent.createTest(tr.getName()); // Create new entry in the report
 * logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),
 * ExtentColor.GREEN)); // Send the passed // information }
 * 
 * public void onTestFailure(ITestResult tr) { logger =
 * extent.createTest(tr.getName()); // Create new entry in the report
 * logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),
 * ExtentColor.RED)); // Send the failed information
 * 
 * String screenshotPath = System.getProperty("user.dir") +
 * "\\Screenshots\\" + tr.getName() + ".png"; File f = new File(screenshotPath);
 * 
 * if (f.exists()) { try { logger.fail("Screenshot is below :" +
 * logger.addScreenCaptureFromPath(screenshotPath)); } catch (IOException e) {
 * e.printStackTrace(); }
 * 
 * }
 * 
 * }
 * 
 * public void onTestSkipped(ITestResult tr) { logger =
 * extent.createTest(tr.getName()); // Create new entry in the report
 * logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),
 * ExtentColor.ORANGE)); // Send the skipped // information }
 * 
 * public void onFinish(ITestResult testContext) { extent.flush();
 * 
 * } }
 */