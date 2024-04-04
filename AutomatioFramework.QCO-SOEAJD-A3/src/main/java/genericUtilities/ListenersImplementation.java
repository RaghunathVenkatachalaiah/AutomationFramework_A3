package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implentation to ITestListener interface testNG
 * @author Raghunath
 * 
 */
public class ListenersImplementation implements ITestListener 
{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println(methodName+"----Test execution started-----");
		
		//Create a @test in extent Reports
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Pass-----");
		
		//Log the status as PASS in extent reports
		test.log(Status.PASS, methodName+"----Test PASS----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Fail-----");
		
		//Log the status as FAIL in extent reports
				test.log(Status.FAIL, methodName+"----Test FAIL----");
		
		// capture screen shot 
				SeleniumUtility s = new SeleniumUtility();
				JavaUtility j = new JavaUtility();
				
				String screenshotName = methodName+"-"+j.getDate();
				try {
				String path=s.captureScreenShot(BaseClass.sDriver, screenshotName);
					
					//attach the screen shot to extent reports
					test.addScreenCaptureFromPath(path);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		System.out.println(methodName+"----Test Skip-----");
		
		//Log the status as SKIP in extent reports
				test.log(Status.SKIP, methodName+"----Test SKIP----");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("----Suite execution started-----");
		
		//Configuration of extent reports
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("Vtiger Execution Report");
		rep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Raghunath");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		System.out.println("----Suit execution Finished-----");
		
		//Generate the exetent report
		report.flush();
	}

}
