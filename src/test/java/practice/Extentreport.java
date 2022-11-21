package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import flipkart.testBase.TestBase;
import flipkart.testPages.Login_page;

public class Extentreport extends TestBase {
	
	@Test
	public void test() throws IOException {
		// start reporters
	    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//reports//"+System.currentTimeMillis() +".html");

	    // create ExtentReports and attach reporter(s)
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	    // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Flipkart.com","Testing the flipkart Web Applcation");
        
        
        // website launching
        initialization();
        test1.log(Status.INFO, "Website Launched successfully");
        
        Login_page login=new Login_page(driver);
        
       
        // enter the user name
        login.username("Shubham");
        test1.log(Status.PASS,"Username enterd Successfully");
        
        // enter the password
        login.password("Shubh@m28");
        test1.log(Status.PASS,"Password Enterd Successfully");
        
        // Click on login button
        login.loginclick();
        test1.log(Status.PASS,"Click on login");
        
        //verify page title
        String homePageTitle = login.verifyTitle();
		System.out.println("Visible Text is  ="+homePageTitle);
		Assert.assertEquals(homePageTitle,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Page Title is not matched");	
		System.out.println("Page title is matched--01");
		
		//Take a screen Shot
		String path = System.getProperty("user.dir")+ "//screenshots//" +System.currentTimeMillis() + ".png";
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File(path));
		test1.addScreenCaptureFromPath(path);
        
		test1.log(Status.INFO,"Test Completed...");
        
        // calling flush writes everything to the log file
        extent.flush();
    }
		
}
	
