package DriverSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReports.ExtentReport;
import ExtentReports.ReportMethods;
import SignIn.InvalidCredentials;
import SignIn.ValidCredentials;
import Utilities.Screenshot;

public class DriverSetup {
	public static WebDriver driver;
	Properties prop;
	public ExtentReports report = ExtentReport.getReportInstance();
	public static ExtentTest logger;
	
	
	//Driver Initialization
	@Parameters("browser")
	public void driverinit(String browser) throws IOException{
		prop= new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\src\\main\\java\\DriverSetup\\config.properties");
			prop.load(file);
			String cpath= prop.getProperty("cpath");
			String fpath= prop.getProperty("fpath");
			String opath= prop.getProperty("opath");
			
			if(browser.equalsIgnoreCase("Chrome")){         // For Chrome
				File path= new File(cpath);
				System.setProperty("webdriver.chrome.driver",path.getAbsolutePath());
				driver= new ChromeDriver();
				logger.log(Status.INFO, "Opening the Chrome Browser");
			}
			
			else if(browser.equalsIgnoreCase("FF")){        // For Firefox
				File path= new File(fpath);
				System.setProperty("webdriver.gecko.driver",path.getAbsolutePath());
				driver= new FirefoxDriver();
				logger.log(Status.INFO, "Opening the Firefox Browser");
			}
			else if(browser.equalsIgnoreCase("opera")){      //For Opera
				File path= new File(opath);
				System.setProperty("webdriver.opera.driver",path.getAbsolutePath());
				driver= new OperaDriver();
				logger.log(Status.INFO, "Opening the Opera Browser");
			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Screenshot.TakeScreenshotOnFailure(driver);
		}
	}
	
	//Opening TripAdvisor.in Homepage
	public ValidCredentials OpenTripAdvisor() throws IOException{
		driver.get(prop.getProperty("url"));
		logger.log(Status.INFO, "Homepage of TripAdvisor.in is Opened");
		driver.manage().window().maximize();                 //To maximize window
		return PageFactory.initElements(driver, ValidCredentials.class);
	}
	
	//Opening TripAdvisor.in Homepage
	public InvalidCredentials OpenTripAdvisor1() throws IOException{
		driver.get(prop.getProperty("url"));
		logger.log(Status.INFO, "Homepage of TripAdvisor.in is Opened");
		driver.manage().window().maximize();                 //To maximize window
		return PageFactory.initElements(driver,InvalidCredentials.class);
	}
	
	@AfterTest
	public void closebrowser(){
		driver.close();
		ReportMethods.reportPass("Browser Successfull Closed");
		report.flush();	
	}
}

