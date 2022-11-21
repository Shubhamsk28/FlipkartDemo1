package flipkart.testPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import flipkart.testBase.TestBase;

public class Home_page extends TestBase {

	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement SearchTextBox;

	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg")
	WebElement Clickonsearch;
	
	@FindBy(xpath="//div[text()='Top Offers']")
	WebElement Topoffers;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[2]")
	WebElement Grocery;
	
	//Mobiles
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[3]/a/div[1]/div/img")
	WebElement Mobiles;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]")
	WebElement redmiPhone;
	
	@FindBy(xpath = "//span[text()='redmi note 10 prime']")
	WebElement verifyText;
	
	@FindBy(xpath = "//span[text()='REDMI 10 Prime (Phantom Black, 128 GB)']")
	WebElement verifyPhone;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[4]")
	WebElement FashionTab;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[5]")
	WebElement ElectronicsTab;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[6]")
	WebElement Home;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[7]")
	WebElement Appliances;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[8]")
	WebElement TravelTab;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[9]")
	WebElement Beauty_Toys;
	
	@FindBy(xpath="(//div[@class='xtXmba'])[10]")
	WebElement Two_wheelers;
	
	@FindBy(xpath = "//a[text()='Bags, Wallets & Belts']")
	WebElement bagstext;
	
	@FindBy(xpath = "//h2[text()='Baby and Kids']")
	WebElement VisibleTXT;
	
	//Actions
	public String verifyTitleofpage() {
		return driver.getTitle();
	}

	public void searchbar(String searchelement) {
		SearchTextBox.sendKeys(searchelement);
		SearchTextBox.sendKeys(Keys.ENTER);
	}
	
	public String verifyVisibleText() {
		return verifyText.getText();
	}
	
	public String verifySelectedPhone() {
		return verifySelectedPhone();
		
	}
	public void clickonsearch(){
		Clickonsearch.click();
	}
	
	public void clicktopoffers(){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Topoffers);
	}
	
	public void grocery(){
		Grocery.click();
	}
	
	public void mobiles(){
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",Mobiles);
	}
	
	public void clickonPhone() {
		redmiPhone.click();
	}
	
	public void fashionTab(){
		Actions A=new Actions(driver);
		A.moveToElement(FashionTab).perform();
	}
	
	public void electronics(){
		Actions A=new Actions(driver);
		A.moveToElement(ElectronicsTab).perform();
	}
	
	public void home(){
		Actions A=new Actions(driver);
		A.moveToElement(Home).perform();
	}
	
	public void appliances(){
		Appliances.click();
	}
	
	public void travelTab(){
		TravelTab.click();
	}
	
	public void beauty_Toys(){
		Actions A=new Actions(driver);
		A.moveToElement(Beauty_Toys).perform();
	}
	
	public void two_wheelers(){
		Two_wheelers.click();
	}
	
	public String verifybags() {
		return bagstext.getText();
	}

	public void scrolltillelement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",VisibleTXT);	
	}
	
	public String verifyText() {
		return VisibleTXT.getText();
		
	}

	

	
}
