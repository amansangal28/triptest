package SearchHolidayHomes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ExtentReports.ReportMethods;

public class Criteria {
	WebDriver driver =null;
	
	public Criteria(WebDriver driver) {
		this.driver=driver;
	}
	
	public void CheckInDate() throws IOException{
		try{
			//To Click On Check-In Date
			 driver.findElement(By.className("vr-traveler-input-picker-SearchDateInputContent__largeInputWrapperStart--DKRvL")).click();
			 
			 //Click Next Until December month
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
			 
			 //To Click on 15 Dec
			 driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[3]")).click();
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
	}
	
	public void CheckOutDate() throws IOException{
			//To Click Check-Out Date
			driver.findElement(By.className("vr-traveler-input-picker-SearchDateInputContent__largeInputWrapperEnd---gHA6")).click();
				 
			//To Click 20 Dec
			driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[4]/div[1]")).click();
	}
	
	public void NumberOfGuests() throws InterruptedException, IOException{
		try{
			//To Select Number Of Guest menu
			driver.findElement(By.xpath("//div[contains(text(),'Guests')]")).click();
			
			//To Select Number Of Guests
			driver.findElement(By.xpath("//div//div//div//div//div[2]//div[1]//div[2]//span[2]//span[1]")).click();
			driver.findElement(By.xpath("//div//div//div//div//div[2]//div[1]//div[2]//span[2]//span[1]")).click();
			driver.findElement(By.xpath("//div//div//div//div//div[2]//div[1]//div[2]//span[2]//span[1]")).click();
			driver.findElement(By.xpath("//div//div//div//div//div[2]//div[1]//div[2]//span[2]//span[1]")).click();
			
			//To click on Apply Button
			driver.findElement(By.xpath(" //button[contains(text(),'Apply')]")).click();
			Thread.sleep(3000);
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
	}
	
	public void Ratings() throws InterruptedException, IOException{
		try{
			//To select Drop Down Menu Of Ratings
			driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/span[1]")).click();
			
			//Select Traveller Rating
			driver.findElement(By.xpath("//span[contains(text(),'Traveller Rating')]")).click();
			Thread.sleep(500);
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
	}
	
	public ResultList Amenities() throws IOException{
		try{
			//To Select more
			driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div[12]/div[6]/span[1]")).click();
			
			//TO Select Elevator/Lift
			driver.findElement(By.xpath("//div[contains(text(),'Elevator')]")).click();
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
		return PageFactory.initElements(driver, ResultList.class);
	}
}
