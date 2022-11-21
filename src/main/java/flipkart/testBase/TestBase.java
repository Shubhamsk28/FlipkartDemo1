package flipkart.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import flipkart.testUtils.Test_util;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	protected ExtentReports extent;
	protected static ExtentTest test1;


	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("src/main/java/flipkart/properties/config/flipkart.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void extentreport() {
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//reports//"+System.currentTimeMillis() +".html");

	    // create ExtentReports and attach reporter(s)
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	    // creates a toggle for the given test, adds all log events under it    
        test1 = extent.createTest("Flipkart.com","Testing the flipkart Web Applcation");
	}


	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if (browserName.equals("gecko")) {
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}

	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//		driver.manage().timeouts().pageLoadTimeout(Test_util.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Test_util.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		

	}


}
