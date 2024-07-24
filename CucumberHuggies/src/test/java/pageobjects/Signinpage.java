package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signinpage extends BaseObjects {
	public Signinpage(WebDriver driver){
		super(driver);
	}
	
	
	
	

@FindBy(xpath="//input[@id='consumer_email']") WebElement Email;
@FindBy(xpath="//input[@id='consumer_password']")  WebElement Password;

@FindBy(xpath="//button[@id='consumer-signin-button']") WebElement sIGNIN; //button[@id='consumer-signin-button']
@FindBy(xpath="//a[@class='nav-link user-logged-in']") WebElement signinsuccess;
@FindBy(xpath="//div[@class='error-msg-text-wrap']")   WebElement yourAccountIsLockedmessage;

public void setsigninemail(String email){
	Email.sendKeys(email);
}
	public void setsigninpassword(String password){
		Password.sendKeys(password);
	}
	public void clicksigninbutton(){
	sIGNIN.click();
  }
public void emailclear(){
	Email.clear();
}
/*public boolean successsignin() {

	
   
	   if(signinsuccess.getText().contains("Hello")){
		   return true;
	   }
	   else{
		       return false;
	   
	  
	 //return signinsuccess.isDisplayed();
      }*/
public boolean successsignin()   // MyAccount Page heading display status
{
	try {
		return (signinsuccess.isDisplayed());
	} catch (Exception e) {
		return (false);
	}

}
public boolean Accountlockmessage(){
	if(yourAccountIsLockedmessage.getText().equalsIgnoreCase("Your account is locked. Please reset your password to unlock it.")){
		return true;
	}
	else
	{
		return false;
	}
}

}
