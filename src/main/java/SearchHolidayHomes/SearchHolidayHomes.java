package SearchHolidayHomes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ExcelInput.InputFromExcel;
import ExtentReports.ReportMethods;

public class SearchHolidayHomes {
	WebDriver driver =null;
	
	public SearchHolidayHomes(WebDriver driver) {
		this.driver=driver;
	}
	
	public Criteria Search() throws Exception{
		try{
		//To click on search tab
		driver.findElement(By.xpath("//input[@placeholder='Where to?']")).click();
				
		//To click holiday homes
		driver.findElement(By.linkText("Holiday homes")).click();
		Thread.sleep(4000);
				
		//To search nairobi
		String place = InputFromExcel.getSearchPlace("ValidDate");
		WebElement search = driver.findElement(By.className("typeahead_input"));
		search.sendKeys(place);
		Thread.sleep(900);
		
		//To click on search button
		driver.findElement(By.id("SUBMIT_VACATION_RENTALS")).click();
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
		return PageFactory.initElements(driver, Criteria.class);
	}
}
