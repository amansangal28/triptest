package ExcelInput;

import java.io.FileInputStream;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ExtentReports.ReportMethods;

//Taking Input From Excel Sheet
public class InputFromExcel {
	public static String searchPlace;
	public static Date CheckIn;
	public static Date CheckOut;
	
	//To get Place where HolidayHome is to be searched
	public static String getSearchPlace(String sheetname) throws Exception{
		FileInputStream file = new FileInputStream("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\InputFile.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetname);
		searchPlace = sh.getRow(0).getCell(0).getStringCellValue();  //To get Row[0]Column[0] element
		ReportMethods.reportPass("City Name extracted Successfully");
		System.out.println("Place is: "+searchPlace);
		return searchPlace;
	 }
	
	//To get CheckIn Date
	public static Date getCheckInDate(String sheetname) throws Exception{
		FileInputStream file = new FileInputStream("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\InputFile.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetname);
		CheckIn=sh.getRow(0).getCell(1).getDateCellValue();          //To get Row[0]Column[1] element
		ReportMethods.reportPass("CheckIn Date Extracted Successfully");
		//System.out.println("CheckIn Date is: "+CheckIn);
		return CheckIn;
	 }
	
	//To get CheckOut Date
	public static Date getCheckOutDate(String sheetname) throws Exception{
		FileInputStream file = new FileInputStream("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\InputFile.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetname);
		CheckOut=sh.getRow(0).getCell(2).getDateCellValue();        //To get Row[0]Column[2] element
		ReportMethods.reportPass("CheckOut Date Extracted Successfully");
		//System.out.println("CheckOut Date is: "+CheckOut);
		return CheckOut;
	 }
}

