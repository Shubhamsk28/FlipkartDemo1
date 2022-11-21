package flipkart_Teststeps;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkart.testBase.TestBase;
import flipkart.testPages.Home_page;
import flipkart.testPages.Login_page;
import flipkart.testUtils.Test_util;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Login_Test extends TestBase {

	Login_page login;
	Home_page homepage;
	Test_util util;
	

	@BeforeMethod
	public void beforeMethod() {
		try {
			extentreport();
			initialization();
			test1.log(Status.INFO, "Website Launched successfully");
			login=new Login_page(driver);
			homepage=new Home_page(driver);
			util=new Test_util();
		

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	//verify Login page with valid data
	@Test
	public void veryficationLoginpagewithvalid() throws IOException {
		try {
			login.username("7090214343");
			test1.log(Status.PASS,"Username enterd Successfully");
			login.password("Shubh@m28");
			test1.log(Status.PASS,"Password Enterd Successfully");
			login.loginclick();
			test1.log(Status.PASS,"Click on login");
			
			String homePageTitle = homepage.verifyTitleofpage();
			System.out.println("Visible Text is  ="+homePageTitle);
			Assert.assertEquals(homePageTitle,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Page Title is not matched");
			util.screenShot();	
			System.out.println("Page title is matched--01");
	
			test1.log(Status.INFO,"Test Completed...");
			extent.flush();

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}
	}

	//verify the Login page with in valid data
	@Test
	public void veryficationLoginpage() throws IOException {
		try {
			login.username("Shubham");
			test1.log(Status.PASS,"Username enterd Successfully");
			login.password("Shubh@128");
			test1.log(Status.PASS,"Password Enterd Successfully");
			login.loginclick();
			test1.log(Status.PASS,"Click on login");
			String ActualerrorText=login.verifyerrormsg();
			String ExpectederrorText = "Please enter valid Email ID/Mobile number";
			System.out.println("visible Text is ="+ActualerrorText);
			Assert.assertEquals(ActualerrorText,ExpectederrorText);
			util.screenShot();
			System.out.println("Expected error message is Displayed--02");
			test1.log(Status.INFO,"Test Completed...");
			extent.flush();

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
//		driver.close();
	}

}
