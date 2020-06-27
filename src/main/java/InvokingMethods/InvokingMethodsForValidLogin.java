package InvokingMethods;

import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import DriverSetup.DriverSetup;
import ExcelInput.InputFromExcel;
import ExtentReports.ExtentReport;
import SearchHolidayHomes.Criteria;
import SearchHolidayHomes.ResultList;
import SearchHolidayHomes.SearchHolidayHomes;
import SignIn.ValidCredentials;

//To run all valid Login Test Cases
public class InvokingMethodsForValidLogin extends DriverSetup{
	DriverSetup TripAdvisor;
	
	@Test()
	public void ValidCase() throws Exception{
		logger = report.createTest("TripAdvior.in Automation : Category - Holiday Homes in Nairobi");
		TripAdvisor = new DriverSetup();
		TripAdvisor.driverinit("chrome");
		
		ValidCredentials LoginPage= TripAdvisor.OpenTripAdvisor();
		
		SearchHolidayHomes SearchPage = LoginPage.Login();
		//logger.log(Status.PASS, "SignIn is Successful");
		
		Criteria SetCriteria = SearchPage.Search();
		logger.log(Status.PASS, "Searched for Holiday Homes In Nairobi Successful");
		
		SetCriteria.CheckInDate();
		SetCriteria.CheckOutDate();
		logger.log(Status.PASS, "CheckIn and CheckOut Date Inserted Successfully");
		
		SetCriteria.NumberOfGuests();
		SetCriteria.Ratings();
		ResultList result = SetCriteria.Amenities();
		logger.log(Status.PASS, "All Other Conditions Inserted Successfully");
		
		result.Results();
		logger.log(Status.PASS, "Holiday Homes List Fetched Successfully");
	}
	
	@Test
	public void InvalidDate() throws Exception{
		ExtentReports report = ExtentReport.getReportInstance();
		logger = report.createTest("TripAdvior.in Automation : CheckIn Date Is smaller than Current Date");
		Date date=new Date();
		Date checkin= InputFromExcel.getCheckInDate("InvalidDate1");
		if(checkin.before(date)){
			logger.log(Status.INFO, "CheckIn Date must be greater than Current Date");
		}
	}
	
	@Test
	public void CheckInDateIsLarger() throws Exception{
		ExtentReports report = ExtentReport.getReportInstance();
		logger = report.createTest("TripAdvior.in Automation : CheckIn Date is greater than Current Date");
		Date checkin= InputFromExcel.getCheckInDate("InvalidDate2");
		Date checkout= InputFromExcel.getCheckOutDate("InvalidDate2");
		if(checkin.after(checkout)){
			logger.log(Status.INFO, "CheckIn Date must be smaller than CheckOut Date");
		}
	}
}
