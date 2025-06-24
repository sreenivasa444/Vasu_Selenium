package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.ITestResult;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginTest {
	  WebDriver driver;
	    WebDriverWait wait;

	    @Parameters("browser")
	    @BeforeMethod
	    public void setUp(String browser) {
	        driver = BrowserFactory.getDriver(browser);
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	    @Test(priority = 1)
	    public void loginTest() throws TimeoutException {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

//	        try {
//	            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
//	            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
//	            System.out.println("Alert found: " + alert.getText());
//	            alert.accept();
//	            System.out.println("Alert closed.");
//	        } catch (Exception e) {
//	            System.out.println("No alert appeared after login.");
//	        }

	        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
	        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard is not visible — Login may have failed.");
	        System.out.println("✅ Login successful");
	    }

	    @Test(priority = 2, dependsOnMethods = "loginTest")
	    public void addEmployee() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Employee']"))).click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys("John");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName"))).sendKeys("Doe");

	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	        // Assertion: Check if employee profile page appears or employee name is visible
	        WebElement employeeProfileHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Personal Details']")));
	        Assert.assertTrue(employeeProfileHeader.isDisplayed(), "Employee profile page is not visible after adding.");
	        System.out.println("✅ Employee added");
	    }

	    @Test(priority = 3, dependsOnMethods = "addEmployee")
	    public void editEmployee() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")))
	            .sendKeys("John");

	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='table']//div[contains(text(),'John')]"))).click();

	        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
	        lastNameField.clear();
	        lastNameField.sendKeys("Smith");

	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	        // Assertion: Verify last name changed
	        WebElement updatedLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
	        Assert.assertEquals(updatedLastName.getAttribute("value"), "Smith", "Last name was not updated.");
	        System.out.println("✅ Employee edited");
	    }

	    @Test(priority = 4, dependsOnMethods = "editEmployee")
	    public void deleteEmployee() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")))
	            .sendKeys("John");

	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//i[contains(@class,'bi-trash') or contains(@class,'oxd-icon bi-trash')]")));
	        deleteButton.click();

	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes, Delete']"))).click();

	        // Assertion: Confirm employee no longer in list
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']"))).clear();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']"))).sendKeys("John");
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
	        boolean isEmployeePresent = driver.findElements(By.xpath("//div[@role='table']//div[contains(text(),'John')]")).size() > 0;
	        Assert.assertFalse(isEmployeePresent, "Employee still present after deletion.");
	        System.out.println("✅ Employee deleted");
	    }

	    @Test(priority = 5, dependsOnMethods = "deleteEmployee")
	    public void logoutTest() {
	        wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-name"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();

	        WebElement loginBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	        Assert.assertTrue(loginBox.isDisplayed(), "Login box not visible after logout.");
	        System.out.println("✅ Logged out successfully");
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            System.out.println("❌ Test failed: " + result.getName());
	            System.out.println("Error: " + result.getThrowable());
	        }

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}	