package SearchHolidayHomes;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ExcelOutput.ExcelOutput;
import ExtentReports.ReportMethods;

public class ResultList {
	static WebDriver driver=null;
	public static String name,price,finalprice,total,finaltotal;
	
	public ResultList(WebDriver driver)
	{
		ResultList.driver=driver;
	}
	public void Results() throws IOException{
		String[] HolidayHome= new String[3];
		String[] Pricepernight = new String[3];
		String[] TotalPrice = new String[3];
		int i=0;
		try{
			//To Store Hotel Name 
			List<WebElement> HotelList=driver.findElements(By.className("vr-srp-propertyCard-pieces-PropertyTitleSection__propertyTitle--351Sr"));
			
			//To Store Price List per Night
			List<WebElement> PriceList=driver.findElements(By.className("vr-srp-propertyCard-pieces-Commerce__priceNumber--2DK7w"));
			
			//To Store Total Price 
			List<WebElement> TotalPriceList=driver.findElements(By.className("vr-srp-propertyCard-pieces-Commerce__priceTotalText--xPZvz"));
		
			while(i<3)
			{
				name=HotelList.get(i).getText();
				HolidayHome[i]=name;
				
				price=PriceList.get(i).getText();
				finalprice="Rs."+price.substring(1);
				Pricepernight[i]=finalprice;
				
				total=TotalPriceList.get(i).getText();
				int pos = total.indexOf('/');
				finaltotal="Rs."+total.substring(1,pos);
				TotalPrice[i]=finaltotal;
				i++;
			}
			
			System.out.println("");
			for (i = 0; i < 3; i++){
			      System.out.println(HolidayHome[i]+" "+Pricepernight[i]+" "+TotalPrice[i]); //To Print result on console
			}
			ExcelOutput.writeInExcel(HolidayHome,Pricepernight,TotalPrice);
		}
		catch(Exception e){
			ReportMethods.reportFail(e.getMessage());
		}
	}
}
