package testNGRealtime;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Testdemo {
	


	         private WebDriver driver;
  
	        @BeforeMethod
	        public void setUp() {
	        // Set the path to the chromedriver executable
	        WebDriverManager.firefoxdriver().setup();

	        // Create a new instance of the Chrome driver
	        driver = new FirefoxDriver();
	    }
	        

	        @Test
	        public void LoginTest() throws InterruptedException {
	        // Navigate to the login page
	        driver.get("https://sapnwg75q.mydrreddys.com:8443/sap/bc/ui2/flp");
            driver.manage().window().maximize();
	        // Find the username and password fields
	        WebElement usernameField = driver.findElement(By.xpath("//input[@id='USERNAME_FIELD-inner']"));
	        WebElement passwordField = driver.findElement(By.xpath("//input[@id='PASSWORD_FIELD-inner']"));

	        // Enter the username and password
	        usernameField.sendKeys("P00015508");
	        passwordField.sendKeys("PKPK@5121");
            Thread.sleep(2000);
	        // Click on the login button
	      //  WebElement loginButton = driver.findElement(By.xpath("//span[text()='Log On']/.."));
	    //    loginButton.click();
            Thread.sleep(5000);
       //     driver.findElement(By.xpath("//span[@class=\"sapMBtnContent sapMLabelBold sapUiSraDisplayBeforeLogin\"]")).click();
	        // Verify that the login is successful
	      
            JavascriptExecutor js = (JavascriptExecutor) driver;


            WebElement elementToClick = driver.findElement(By.xpath("//span[@class=\\\"sapMBtnContent sapMLabelBold sapUiSraDisplayBeforeLogin\\"));

            // Use JavascriptExecutor to click on the element
            js.executeScript("arguments[0].click();", elementToClick);
	        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[@class='sapUshellHeadTitle']"));
	        String actualMessage = welcomeMessage.getText();
	        String s = actualMessage;
	        System.out.println(s);
	        String expectedMessage = "Home";
	        Assert.assertEquals(actualMessage, expectedMessage);
	        }
	       @AfterMethod
	       public void tearDown() {
	       // Close the browser
	       driver.quit();
	       }
	       }


