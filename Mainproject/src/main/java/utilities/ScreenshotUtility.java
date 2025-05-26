package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	 public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException { 
	 		TakesScreenshot scrShot = (TakesScreenshot) driver;  //Takescreenshot interface. created obj  
	 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//captured screenshot saved to a temporary path      
	 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());   
	 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //to create folder in maven project.getProperty used to give path of project  
	 		if (!f1.exists()) { // if folder is not exist
	 			f1.mkdirs();    //mkdir --> will create folder using java 
	 		} 
	 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp 
	 				+ ".png"; //timestamp to get time of screenshot taken
	 		File finalDestination = new File(destination);// variable destination is taken to finalDestination
	 		FileHandler.copy(screenShot, finalDestination);//copy screenshot to finalDestination
	 		

	 }
}
