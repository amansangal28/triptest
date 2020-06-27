package SignIn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ExtentReports.ReportMethods;
import SearchHolidayHomes.SearchHolidayHomes;

public class ValidCredentials {
	WebDriver driver =null;
	
	public ValidCredentials(WebDriver driver) {
		this.driver=driver;
	}
	
	public SearchHolidayHomes Login() throws IOException{
		/*try{
			//To click on SignIn Button
			WebElement login1=driver.findElement(By.xpath("/html/body/div/header/div/nav/a/span"));
			login1.click();
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			//To click on Login By Email Button
			WebElement loginbyemail=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/span[1]"));
			loginbyemail.click();
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			//To get Username and Password from config.properties
			Properties prop= new Properties();
			FileInputStream file;
			file = new FileInputStream("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\src\\main\\java\\DriverSetup\\config.properties");
			prop.load(file);
			String username= prop.getProperty("email");
			String password= prop.getProperty("password");
			driver.findElement(By.id("regSignIn.email")).sendKeys(username);        //Input Valid Email I'd
		    driver.findElement(By.id("regSignIn.password")).sendKeys(password);     //Input Valid Password
		    WebElement login=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[2]/div[2]']"));
		    login.click();				
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);//Click on Log In Button
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}*/
		return PageFactory.initElements(driver, SearchHolidayHomes.class);
	}
}
