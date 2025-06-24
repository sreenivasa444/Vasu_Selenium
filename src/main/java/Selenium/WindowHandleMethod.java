package Selenium;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleMethod {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();  
	        Thread.sleep(5000);
	        
	        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
	        Thread.sleep(5000);

	        driver.findElement(By.xpath("//button[text()='New Window']")).click();
	          
	        Thread.sleep(5000);
	    		String parentWindowID = driver.getWindowHandle();//parent window ID
	    		
	    		Set<String> totalWindows = driver.getWindowHandles();
	    		
	    		for(String individualWin : totalWindows) {
	    			if(individualWin.equalsIgnoreCase(parentWindowID)) {    				
	    				System.out.println("Parent Window ID : " + individualWin);
	    			}
	    			else {
	    				System.out.println("Child Window ID : " + individualWin);
	    				driver.switchTo().window(individualWin);
	    			}
	    		}
	    		
		        Thread.sleep(5000);

	        	Boolean B = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']")).isDisplayed();
	              	
	        	System.out.println(B);
	        	
	        	driver.quit();
	        	
	        }
		
	}


