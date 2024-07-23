package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseObjects {
	
	public WebDriver driver;
	
	public BaseObjects(WebDriver driver)
    {
	     this.driver=driver;
	     PageFactory.initElements(driver,this);
    }
}
