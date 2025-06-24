package testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

     public class Simplify {

	  public static void main(String[] args) {
	 
      System.setProperty("webdriver.chrome.driver","C:\\eclipseework\\eclipse\\testNG\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();  
      driver.get("http://164.52.221.185:9080");      
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("INDUKURIADMIN");
      driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("#V@su(27)");
      driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();
		
		
		
		
		
		
		
	}

}
