package Simplify3x;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Demo {

    

    // Initialize WebDriver
 static   WebDriver driver = new ChromeDriver();
 
 public static void dragAndDrop(String dragXPath, String dropXPath) {
     WebElement dragElement = driver.findElement(By.xpath(dragXPath));
     WebElement dropElement = driver.findElement(By.xpath(dropXPath));

     Actions actions = new Actions(driver);

     // Click and hold the draggable element, then move to the droppable element and release it
     actions.dragAndDrop(dragElement, dropElement).build().perform();
 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
		dragAndDrop("//h5[text()='High Tatras']", "//div[@id=\"trash\"]");
	}}