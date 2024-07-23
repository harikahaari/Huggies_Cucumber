package Stepsdefination;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageobjects.Homepage;
import pageobjects.Signinpage;

public class Loginstep {
	public WebDriver driver;
	public Homepage hm;
	public Signinpage sn;
	public Properties p;

	@Given("navigate to signin page")
	public void navigate_to_signin_page() {
		hm=new Homepage(BaseClass.getwebdriver());
		hm.opensignin();
	    
	}

	@When("give the valid email and password")
	public void give_the_valid_email_and_password() throws IOException, InterruptedException {
		sn= new Signinpage(BaseClass.getwebdriver());
		p=  BaseClass.getproperties();
		Thread.sleep(2000);
		sn.setsigninemail(p.getProperty("email"));
		sn.setsigninpassword(p.getProperty("password"));
	    
	}

	@When("click the submit button")
	public void click_the_submit_button() {
		sn.clicksigninbutton();
	   
	}

	@SuppressWarnings("deprecation")
	@Then("the user should see a Hello text along with his firstname")
	public void the_user_should_see_a_hello_text_along_with_his_firstname() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(sn.successsignin());
	    
	}

}
