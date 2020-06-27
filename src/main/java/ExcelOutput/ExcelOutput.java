package ExcelOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOutput {
	public static void writeInExcel(String[] HotelList, String[] Price, String[] TotalPrice) throws IOException{
		String name,price,ttl;
		File file = new File("C:\\Users\\Apoorv Sharma\\workspace\\cognizant\\TripAdvisorAutomation\\OutputFile.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook output= new XSSFWorkbook(inputStream);
		XSSFSheet sheet =output.getSheet("Sheet1");
		for(int i = 0; i < 3; i++){
			name=HotelList[i];
			price=Price[i];
			ttl=TotalPrice[i];
			Row newRow = sheet.createRow(i);
	        Cell cell = newRow.createCell(0);
	        cell.setCellValue(name);
	        Cell cell1 = newRow.createCell(1);
	        cell1.setCellValue(price);
	        Cell cell2 = newRow.createCell(2);
	        cell2.setCellValue(ttl);
	    }
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		output.write(outputStream);
		outputStream.close();
	}
}
