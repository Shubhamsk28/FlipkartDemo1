package flipkart.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipkart.testBase.TestBase;

public class Login_page extends TestBase {
	
		public Login_page(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
	
	
		@FindBy(xpath="(//input[@type='text'])[2]")
		WebElement emailTextBox;
	
		@FindBy(xpath="(//input[@type='password'])")
		WebElement passwordTextBox;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		WebElement loginTextBox;
		
		@FindBy(xpath = "//span[text()='Please enter valid Email ID/Mobile number']")
		WebElement errormessage;
		
		
		public void username(String username) {
	       emailTextBox.sendKeys(username);
		}
		
		public void password(String password) {
			passwordTextBox.sendKeys(password);
		}
		
		public void loginclick(){
			loginTextBox.click();
		}
		
		public String verifyerrormsg() {
			return errormessage.getText();
			
		}
		
		public String verifyTitle() {
			return driver.getTitle();
			
		}
		
		

}
