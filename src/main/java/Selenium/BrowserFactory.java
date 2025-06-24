package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class  BrowserFactory {	
    public static WebDriver driver;	    

	  public static WebDriver getDriver(String browserName) {
	        WebDriver driver = null;

	        if (browserName.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            System.out.println("Launched Chrome browser");
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            System.out.println("Launched Firefox browser");
	        } else if (browserName.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            System.out.println("Launched Edge browser");
	        } else {
	            System.out.println("Invalid browser name. Please use Chrome, Firefox, or Edge.");
	        }

	        if (driver != null) {
	            driver.manage().window().maximize();
	        }

	        return driver;
	    }
	}