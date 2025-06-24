package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo {
 
	static WebDriver driver;
	
	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void cleartext(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public void Entertext(String xpath ,String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);		
	}
	
	public void gettext(String xpath) {   	
    String actualtext =driver.findElement(By.xpath(xpath)).getText();		
    System.out.println(actualtext);
	}
	    public static void main(String[] args) throws InterruptedException {
		Demo D = new Demo();	
        driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		D.Entertext("//input[@placeholder=\"Username\"]","Admin");
		Thread.sleep(3000);
		D.Entertext("//input[@placeholder=\"Password\"]", "admin123");
		Thread.sleep(3000);
		D.gettext("//button[text()=' Login ']");
		D.click("//button[text()=' Login ']");
		driver.close();
		
		
		
		


	}

}
