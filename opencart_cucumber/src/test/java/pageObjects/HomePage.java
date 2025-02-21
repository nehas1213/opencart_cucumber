package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	} 
	
	//Elements
	
	@FindBy(xpath="//span[text()='My Account']") WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	//@FindBy(linkText = "Register") WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement linkLogin;
	//FindBy(linkText = "Login") WebElement lnkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']") WebElement txtSearchbox;
	
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']") WebElement btnSearch;
	//FindBy(xpath="//div[@id='search']//button[@type='button']") WebElement btnSearch;
	
	// Action Methods
		public void clickMyAccount() {
			lnkMyaccount.click();
		}

		public void clickRegister() {
			lnkRegister.click();
		}
		
		public void clickLogin()    // added in step6
		{
			linkLogin.click();
		}
		
		public void enterProductName(String pName)   //For Search Product Test
		{
			txtSearchbox.sendKeys(pName);
		}
		
		public void clickSearch()  //For Search Product Test
		{
			btnSearch.click();
		}
		


}
