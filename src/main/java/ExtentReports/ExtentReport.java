package ExtentReports;

import Utilities.TimeStamp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

// To Create And Designing HTML Report for Test Cases 
public class ExtentReport{
	public static ExtentReports report;

	public static ExtentReports getReportInstance(){
		if (report == null) {												//To Check Whether Report is Empty
			String ReportName = TimeStamp.getTimeStamps()+".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "//test-output//Reports//"+ReportName); //Set Location for HTML Report
			report = new ExtentReports();
			report.attachReporter(htmlReporter);				//Attaching HTML Reporter to Actual Report

			//Adding Info to Report
			report.setSystemInfo("OS", "Windows 10");						
			report.setSystemInfo("Browser", "Multi-Broswer");				
			report.setSystemInfo("Environment", "Testers");					
			report.setSystemInfo("Automation Tool", "Selenium Webdriver");	
			
			//Configuring the HTML Report Format
			htmlReporter.config().setDocumentTitle("Holiday Homes Search");	 
			htmlReporter.config().setReportName("Report to search holiday plan for a location using Trip Advisor");
			htmlReporter.config().setTimeStampFormat("yyyy-MM-dd*HH:mm:ss");		
		}
		return report;							// Returning Report
	}
}
