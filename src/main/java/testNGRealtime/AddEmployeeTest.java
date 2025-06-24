package testNGRealtime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class AddEmployeeTest {

	         private WebDriver driver;

	        @BeforeClass
	         public void setUp() {
	        // Set up WebDriver and open OrangeHRM
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
	        }

	        @Test
	        public void testAddEmployee() {
	        // Perform employee addition
	        WebElement usernameInput = driver.findElement(By.id("txtUsername"));
	        usernameInput.sendKeys("admin");

	        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
	        passwordInput.sendKeys("admin123");

	        WebElement loginButton = driver.findElement(By.id("btnLogin"));
	        loginButton.click();

	        WebElement pimMenu = driver.findElement(By.id("menu_pim_viewPimModule"));
	        pimMenu.click();

	        WebElement addEmployeeButton = driver.findElement(By.id("btnAdd"));
	        addEmployeeButton.click();

	        WebElement firstNameInput = driver.findElement(By.id("firstName"));
	        firstNameInput.sendKeys("John");

	        WebElement lastNameInput = driver.findElement(By.id("lastName"));
	        lastNameInput.sendKeys("Doe");

	        WebElement saveButton = driver.findElement(By.id("btnSave"));
	        saveButton.click();

	        WebElement employeeDetails = driver.findElement(By.id("profile-pic"));
	        Assert.assertTrue(employeeDetails.isDisplayed(), "Employee addition failed");
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}

