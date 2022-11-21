package flipkart_Teststeps;

import org.testng.annotations.Test;

import flipkart.testBase.TestBase;
import flipkart.testPages.Home_page;
import flipkart.testPages.Login_page;
import flipkart.testUtils.Test_util;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Homepage_Test extends TestBase {

	Login_page login;
	Home_page homepage;
	Test_util util;

	public Homepage_Test() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {

		try {

			initialization();
			login=new Login_page(driver);
			login.username("7090214343");
			login.password("Shubh@m28");
			login.loginclick();
			homepage=new Home_page(driver);
			util=new Test_util();

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}
	}


	//verify pageTitle
	@Test
	public void verifypageTitle() throws IOException {
		try {
			homepage.verifyTitleofpage();
			util.screenShot();
			String verifyTitle=homepage.verifyTitleofpage();
			Assert.assertEquals(verifyTitle,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Page Title is not matched");
			System.out.println(" Home page title is matched--1");


		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}

	}


	//verify search for bags 
	@Test
	public void verifysearch() throws InterruptedException, IOException  {

		try {
			homepage.searchbar("bags");
			Thread.sleep(3000);
			String ActualText=homepage.verifybags();
			String ExpectedText = "Bags, Wallets & Belts";
			System.out.println("visible Text is ="+ActualText);
			Assert.assertEquals(ActualText,ExpectedText);
			util.screenShot();
			System.out.println("Expected Text is Displayed--2");


		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}
	}


	//verify That scroll till Visible Text
	@Test
	public void verifyVisibleTXT() throws IOException, InterruptedException {

		try {
			Thread.sleep(3000);
			homepage.scrolltillelement();
			String verifytxt=homepage.verifyText();
			System.out.println("Visible Text is  ="+verifytxt);
			Assert.assertEquals(verifytxt,"Baby and Kids","Visible Text is not matched");
			System.out.println("Visible Text is matched---3");
			util.screenShot();

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}
	}

	//verify That search mobile is visible oir not
	@Test
	public void verifyphone() throws IOException {

		try {
				homepage.searchbar("redmi note 10 prime");
				Thread.sleep(3000);
				homepage.clickonPhone();

				String verifytxt=homepage.verifyVisibleText();
				System.out.println("Visible Text is  ="+verifytxt);
				Assert.assertEquals(verifytxt,"redmi note 10 prime","Visible Text is not matched");
				System.out.println("Visible Text is matched--4");
				util.screenShot();
				

		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			util.screenShot();
		}
	}

	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException {
		Thread.sleep(5000);
//		driver.close();
	}

}
