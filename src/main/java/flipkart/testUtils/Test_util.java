package flipkart.testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import flipkart.testBase.TestBase;

public class Test_util extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static ExtentTest test;
	
	public void switchtoFrame() {
		driver.switchTo().frame(0);
	}
	
	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2250)", "");
	}
	
	public void takeScreenShot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);        
	    String homeDir = System.getProperty("user.dir");        
	    FileUtils.copyFile(scrFile, new File(homeDir + "/screenshots/" +System.currentTimeMillis() + ".png"));
	      
	}
	
	public void screenShot() throws IOException {
		//Take a screen Shot
		String path1 = System.getProperty("user.dir")+ "//screenshots//" +System.currentTimeMillis() + ".png";
		File screenshot1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1,new File(path1));
		test1.addScreenCaptureFromPath(path1);
		Reporter.log("<br><img src='"+path1+"'/><br>");
	}
	
	

}
