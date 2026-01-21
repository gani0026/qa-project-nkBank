package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    // Logger instance
    private static final Logger logger = LogManager.getLogger(MyTestListener.class);

    // ExtentReports instances
    private static ExtentReports extent;
    private static ExtentTest test;

    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports/extent-report.html");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Optional system info
        extent.setSystemInfo("NK Bank", "NK Bank Automation");
        extent.setSystemInfo("Tester", "M.Ganesh Manidhar");
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onStart(ITestContext context) {
        String msg = "🚀 Test Suite Started: " + context.getName();
        logger.info(msg);
        // You can add info to report as system info or a test if needed, here skipping.
    }

    @Override
    public void onFinish(ITestContext context) {
        String msg = "🏁 Test Suite Finished: " + context.getName();
        logger.info(msg);
        extent.flush(); // Write everything to the report
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String msg = "🟢 Test Started: " + methodName;

        logger.info(msg);
        test = extent.createTest(methodName); // Create test entry in report
        test.info(msg); // Log start to report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        Object strAttr = result.getAttribute("str");String strMessage="";
        if (strAttr != null) {
             strMessage = strAttr.toString();
           
        }
        
        String msg = "✅ Test Passed: " + methodName+"  "+strMessage;

        logger.info(msg);
        test.pass(msg);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String reason = result.getThrowable() != null ? result.getThrowable().getMessage() : "No exception message";

        logger.error("❌ Test Failed: {}", methodName);
        logger.error("Reason: {}", reason);

        test.fail("❌ Test Failed: " + methodName);
        test.fail("Reason: " + reason);

        // Attach stack trace for detailed debugging
        if (result.getThrowable() != null) {
            test.fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String reason = result.getThrowable() != null ? result.getThrowable().getMessage() : "No skip reason";

        logger.warn("⚠️ Test Skipped: {}", methodName);
        test.skip("⚠️ Test Skipped: " + methodName);

        if (result.getThrowable() != null) {
            test.skip("Reason: " + reason);
        }
    }
}
