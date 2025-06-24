package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

    
    public class Test {
    static WebDriver  driver;
	public static void launch(String url) {
	driver.get(url);
	}
	public static void login(String xpath,String id) {
	driver.findElement(By.xpath(xpath)).sendKeys(id);
	}
	public static void click(String xpath) {
    driver.findElement(By.xpath(xpath)).click();
	}
	public static void main(String[] args){
	driver = new FirefoxDriver();
	WebDriverManager.firefoxdriver().setup();
    launch("http://164.52.221.185:9080");
	login("//input[@id=\"txtUsername\"]","INDUKURIADMIN");
	login("//input[@id=\"txtPassword\"]","#V@su(27))");
	click("//input[@id=\"btnLogin\"]");
	
	
	}
}
