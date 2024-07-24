package Stepsdefination;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageobjects.*;

public class Accountlockstep {
	WebDriver driver;
	Properties p;
	Homepage hm;
	Signinpage sn;
	@Given("navigate to signin form page")
	public void navigate_to_signin_form_page() {
		hm= new Homepage(BaseClass.getwebdriver());
		hm.opensignin();
	}

	@When("Give the valid email,invalid password and submit")
	public void give_the_valid_email_invalid_password_and_submit() throws IOException, InterruptedException {
		sn= new Signinpage(BaseClass.getwebdriver());
		p=new Properties(BaseClass.getproperties());
		Thread.sleep(2000);
		sn.setsigninemail(p.getProperty("email"));
		sn.setsigninpassword(p.getProperty("invalidpassword"));
		sn.clicksigninbutton();
	    
	}

	@When("Give the invalid password four times and submit the form")
	public void give_the_invalid_password_four_times_and_submit_the_form() throws InterruptedException {
	    
		for(int i=0;i<3;i++){
			sn.setsigninpassword(p.getProperty("invalidpassword"));
			sn.clicksigninbutton();
			Thread.sleep(2000);
			
		}
		
	}

	@When("Give the valid password for the 5th time and submit the form")
	public void give_the_valid_password_for_the_5th_time_and_submit_the_form() {
		sn.setsigninpassword(p.getProperty("password"));
		sn.clicksigninbutton();
	}

	@Then("verify the account lock message")
	public void verify_the_account_lock_message() {
	    Assert.assertTrue(sn.Accountlockmessage());
	}


}
