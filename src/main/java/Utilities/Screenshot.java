package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.google.common.io.Files;

//To take screenshot on failure
public class Screenshot {
	public static void TakeScreenshotOnFailure(WebDriver driver) throws IOException{
		TakesScreenshot picture = (TakesScreenshot)driver;
		File actual =  picture.getScreenshotAs(OutputType.FILE);
		File Destination_File = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + TimeStamp.getTimeStamps() + ".png");
		Files.copy(actual, Destination_File);
		Reporter.log("Failure Screenshot is Captured and saved",true);
	}
}
