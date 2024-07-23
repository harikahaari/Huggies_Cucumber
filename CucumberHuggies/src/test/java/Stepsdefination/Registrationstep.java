package Stepsdefination;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageobjects.Homepage;
import pageobjects.Registrationpage;

public class Registrationstep extends BaseClass{
	public Homepage hm;
	public Registrationpage rp;
	public Properties p;
	
	@Given("navigate to registration page")
	public void navigate_to_registration_page() {
	    hm= new Homepage(BaseClass.getwebdriver());
	    hm.openregistrationform();
	}

	@When("give the below valid details")
	public void give_the_below_valid_details(io.cucumber.datatable.DataTable dataTable) throws IOException {
		p=BaseClass.getproperties();
	    Map<String,String> datamap= dataTable.asMap(String.class,String.class);
	    rp= new Registrationpage(BaseClass.getwebdriver());
	    rp.setfirstname(datamap.get("firstname"));
	    rp.setlastname(datamap.get("lastname"));
	    rp.setemail(p.getProperty("email"));
	    rp.setpassword(datamap.get("password"));
	    
	}

	@When("give the baby birthdetilas")
	public void give_the_baby_birthdetilas() {
	    rp.setdate();
	    rp.setmonth();
	    rp.setyear();
	}

	@When("Check the {int}  checkboxes")
	public void check_the_checkboxes(Integer int1) {
	    rp.checkcheckbox1();
	    rp.checkcheckbox2();
	}

	@When("Submit the registration form")
	public void submit_the_registration_form() {
	    rp.clicksubmitbutton();
	}

	@SuppressWarnings("deprecation")
	@Then("Verify user is registerted Successfully")
	public void verify_user_is_registerted_successfully() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(rp.verifysuccessmsg(), "You have successfully created your account.");
	   
	}




}
