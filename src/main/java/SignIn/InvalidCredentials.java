package SignIn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ExtentReports.ReportMethods;

public class InvalidCredentials {
	WebDriver driver =null;
	
	public InvalidCredentials(WebDriver driver) {
		this.driver=driver;
	}
	
	public void InvalidLogin() throws IOException{
		try {
			//To click on SignIn Button
			WebElement login1=driver.findElement(By.xpath("/html/body/div/header/div/nav/a/span"));
			login1.click();
			
			//To click on Login By Email Button
			WebElement loginbyemail=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[1]/span"));
			loginbyemail.click();
				
			//To get Invalid Username and Invalid Password from config.properties
			Properties prop= new Properties();
			FileInputStream file;
			file = new FileInputStream("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\src\\main\\java\\DriverSetup\\config.properties");
			prop.load(file);
			String i_username= prop.getProperty("i_email");
			String i_password= prop.getProperty("i_password");
			driver.findElement(By.id("regSignIn.email")).sendKeys(i_username);                //Input Invalid Email I'd
		    driver.findElement(By.id("regSignIn.password")).sendKeys(i_password);             //Input Invalid Password
		    WebElement login=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[3]/div/div[2]/div[2]']"));
		    login.click();																	//Click on Log In Button
		    
		    //To check if it is displaying error message or not
		    String actualmsg=driver.findElement(By.id("regErrors")).getText();
		    String expectedmsg="Either your email or password was incorrect. Please try again or click the \"Forgot password?\" link below.";
	        if(actualmsg.equalsIgnoreCase(expectedmsg))
	        	ReportMethods.reportPass("SignIn Is Failed");
	        else
	        	ReportMethods.reportFail("SignIn Is Successful");
	    }
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
		driver.close();
	}

}
