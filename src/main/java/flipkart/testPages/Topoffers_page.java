package flipkart.testPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.testBase.TestBase;

public class Topoffers_page extends TestBase {
	
	

	public Topoffers_page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='Electronics']")
	WebElement ElectronicsBTN;
	
	@FindBy(xpath = "//a[text()='Power Banks']")
	WebElement PowerbankBTN;
	
	@FindBy(xpath = "//h1[text()='Power Banks']")
	WebElement VisibleTXT;
	
	@FindBy(xpath = "//h2[text()='Deals of the Day']")
	WebElement verifyTXT;
	
	public void electronics() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",ElectronicsBTN);
	}
	
	public void powerbank() {
		PowerbankBTN.click();
	}
	
	public String verifytext() {
		return VisibleTXT.getText();
	}

	public String verifyDealspage() {
		return verifyTXT.getText();
		
	}
	
	
	
	
}
