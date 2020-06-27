package InvokingMethods;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DriverSetup.DriverSetup;
import SignIn.InvalidCredentials;

//To Run Invalid Login Test Case
public class InvokingMethodsForInvalidLogin extends DriverSetup {
	DriverSetup TripAdvisor;
	
	@Test
	public void InvalidCase() throws IOException{
		logger = report.createTest("TripAdvior.in Automation : SignIn using Invalid Credentials");
		TripAdvisor = new DriverSetup();
		TripAdvisor.driverinit("chrome");
		
		InvalidCredentials LoginPage = TripAdvisor.OpenTripAdvisor1();
		LoginPage.InvalidLogin();
		logger.log(Status.PASS, "SignIn is Unsuccessful");
	}
}
