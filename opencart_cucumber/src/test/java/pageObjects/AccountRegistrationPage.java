package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void scrollToElement(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    try {
	        // Scroll to top first (if needed)
	      //  js.executeScript("window.scrollTo(0, 0);");
	        Thread.sleep(1000);  // Optional: wait for the scroll to complete

	        // Scroll to the desired element
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        Thread.sleep(1000);  // Optional: wait for the scroll to complete
	    } catch (Exception e) {
	        System.out.println("Error while scrolling: " + e.getMessage());
	    }
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	
	@FindBy(name = "telephone")	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(name = "confirm") WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	//@FindBy(name = "agree") WebElement chkdPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement btnContinue;
	//@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
		


	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);

	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);

	}

	public void setPrivacyPolicy() {
		
		scrollToElement(chkdPolicy);
		chkdPolicy.click();
		
	}

	public void clickContinue() throws InterruptedException {
		Thread.sleep(3000);
		scrollToElement(btnContinue);
		btnContinue.click();
		Thread.sleep(5000);

	}

	public String getConfirmationMsg() 
	{
		try
		{
		return(msgConfirmation.getText());
		}
		catch(Exception e) 
		{
			return(e.getMessage());
		}
	}
	
			
}
