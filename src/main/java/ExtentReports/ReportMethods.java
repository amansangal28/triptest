package ExtentReports;

import java.io.IOException;

import org.testng.Assert;

import Utilities.Screenshot;

import com.aventstack.extentreports.Status;

import DriverSetup.DriverSetup;

public class ReportMethods extends DriverSetup{
	public static void reportFail(String reportString) throws IOException {
		logger.log(Status.FAIL, reportString);
		Screenshot.TakeScreenshotOnFailure(driver);
		Assert.fail(reportString);
	}
	
	public static void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
}
