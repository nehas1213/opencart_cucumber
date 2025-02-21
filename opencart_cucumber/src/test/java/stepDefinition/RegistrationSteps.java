package stepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountRegistrationPage regpage;
	
	@Given("user navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
	    hp = new HomePage(BaseClass.getDriver());
	    hp.clickMyAccount();
	    hp.clickRegister();
	    BaseClass.getLogger().info("user is on account registration page");
	}

	@When("the user enters details into below fields")
	public void the_user_enters_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);//converts datatable to hashmap
		
		regpage = new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("firstName"));
		BaseClass.getLogger().info("user firstName");
		regpage.setLastName(dataMap.get("lastname"));
		BaseClass.getLogger().info("user LastName ");
		regpage.setEmail(BaseClass.AlphaNumeric()+"@gmail.com");//randomly generating
		BaseClass.getLogger().info("user  entered email");
		regpage.setPassword(dataMap.get("password"));
		
		BaseClass.getLogger().info("user entered details till password");
		
	    
	}

	@When("then user selects privacy policy")
	public void then_user_selects_privacy_policy() {
		regpage.setPrivacyPolicy();
		BaseClass.getLogger().info("selected Privacy policy");
	   
	}

	@When("the user clicks on continue button")
	public void the_user_clicks_on_continue_button() throws InterruptedException {
		regpage.clickContinue();
		BaseClass.getLogger().info("selected continue");
	   
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
		BaseClass.getLogger().info("registration success page");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		
	   
	}

}
