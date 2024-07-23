package factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	
	public static WebDriver initializebrowser() throws IOException{
		
		switch(getproperties().getProperty("browser").toLowerCase()) 
		{
		case "chrome":
	        driver=new ChromeDriver();
	        break;
	    case "edge":
	    	driver=new EdgeDriver();
	        break;
	    default:
	        System.out.println("No matching browser");
	        driver=null;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	 return driver;
	}
	
	public static Properties getproperties() throws IOException{
		p=new Properties();
		FileReader file= new FileReader(".\\src\\test\\resources\\config.properties");
		p.load(file);
		return p;
		
	}
	
  public static WebDriver getwebdriver(){
		return driver;
	}
	
	
	
}
