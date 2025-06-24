package testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginTest {


		    private WebDriver driver;

		    @BeforeClass
		    public void setUp() {
		        System.setProperty("webdriver.chrome.driver", "C:\\eclipseework\\eclipse\\testNG\\chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		    }

		    @DataProvider(name = "loginData")
		    public Object[][] loginData() {
		        return new Object[][] {
		            {"validuser1", "password1"},
		            {"validuser2", "password2"},
		            {"invaliduser", "invalidpassword"}
		        };
		    }

		    @Test(dataProvider = "loginData")
		    public void loginTest(String username, String password) {
		        WebElement usernameField = driver.findElement(By.id("username"));
		        WebElement passwordField = driver.findElement(By.id("password"));
		        WebElement loginButton = driver.findElement(By.id("login-button"));

		        usernameField.clear();
		        usernameField.sendKeys(username);
		        passwordField.clear();
		        passwordField.sendKeys(password);
		        loginButton.click();

		        // Add assertions to validate login success or failure based on the test data
		        if (username.equals("validuser1") && password.equals("password1")) {
		            // Assert successful login
		        } else {
		            // Assert login failure
		        }
		    }

		    @AfterClass
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();
		        }
		    }
		}

	
