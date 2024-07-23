package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import factory.BaseClass;

public class Homepage extends BaseObjects{
	
	public Homepage(WebDriver driver ){
		super(driver);
		
	}
    @FindBy(xpath="//a[@class='nav-link'][normalize-space()='Register']")
    WebElement Registerlink;
    @FindBy(xpath="//a[contains(@class,'nav-link')][normalize-space()='Sign In']") WebElement signIn;
    @FindBy(xpath="//a[@class='nav-link user-logged-in']") WebElement Myaccountlink;
    @FindBy(xpath="//ul[@class='login-account-tooltip show']//a[@class='nav-link'][normalize-space()='Sign Out']") WebElement logout;
  
    public void openregistrationform(){
    	Registerlink.click();
    }

	/*public void openregistrationform() {
		Registerlink.click();
		
	}*/
	public void opensignin() {
		
		signIn.click();
		
	}
	public void logout() {
		Myaccountlink.click();
		logout.click();
	}
}
