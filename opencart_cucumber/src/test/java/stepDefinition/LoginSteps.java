package stepDefinition;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
    List<HashMap<String, String>> datamap; //Data driven
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException 
	{
		BaseClass.getLogger().info("Go to my account: click on login");
		
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
		Thread.sleep(3000);		
	}
	
	
	@When("user enters email as {string} and password {string}")
	public void user_enters_email_as_and_password_(String email, String pwd) 
	{
		
		BaseClass.getLogger().info("Entering email and password...");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
		
	}
	
	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button()
	{
		lp.clickLogin();		
		BaseClass.getLogger().info("clicked on login button...");

	}
	
	@Then("user is redirected to the my account page")
	public void user_is_redirected_to_the_my_account_page()
	{
		BaseClass.getLogger().info("enter my account page...");
		macc = new MyAccountPage(BaseClass.getDriver());
		boolean targetPage=macc.isMyAccountPageExists();
		Assert.assertTrue(targetPage);

	}
	
	@Then("user clicks logout")
	public void user_clicks_logout() throws InterruptedException 
	{
		Thread.sleep(3000);
		macc.clickLogout();
		BaseClass.getLogger().info("clicked logout...");

	}
	
	//*******   Data Driven test **************

    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
        macc=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
            Thread.sleep(5000);
            BaseClass.getLogger().info("enter my account page...");
            if(exp_res.equalsIgnoreCase("valid"))
            {
                if(targetpage==true)
                {
                	MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                	Thread.sleep(3000);
                    myaccpage.clickLogout();
            		BaseClass.getLogger().info("clicked logout...");
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equalsIgnoreCase("Invalid"))
            {
                if(targetpage==true)
                {
                	BaseClass.getLogger().info("clicked logout...");
                	Thread.sleep(3000);
                    macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }
 

}
