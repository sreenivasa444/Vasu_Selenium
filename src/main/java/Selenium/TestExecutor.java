package Selenium;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExecutor {

    WebDriver driver;

    // OrangeHRM login test
    public void loginTest() {
        System.out.println("✅ Running: loginTest");
        try {
            // Set path to your ChromeDriver executable
        	
            WebDriverManager.chromedriver().setup();

           // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Open OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Enter username
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

            Thread.sleep(5000);
            // Enter password
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");

            // Click login button
            driver.findElement(By.id("btnLogin")).click();

            // Simple wait for login (better to use WebDriverWait in real tests)
            Thread.sleep(3000);

            // Verify login success (by checking presence of dashboard element)
            boolean loggedIn = driver.findElements(By.id("welcome")).size() > 0;
            if (loggedIn) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // OrangeHRM logout test
    public void logoutTest() {
        System.out.println("✅ Running: logoutTest");
        try {
            if (driver == null) {
                System.out.println("❌ Driver not initialized. Run loginTest first.");
                return;
            }

            // Click welcome menu to open dropdown
            driver.findElement(By.id("welcome")).click();
            Thread.sleep(2000);

            // Click Logout link
            driver.findElement(By.linkText("Logout")).click();

            Thread.sleep(3000);

            System.out.println("Logout successful!");

            // Close browser
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Schedule method
    public static void scheduleTestExecution(final String testCaseName, String runAt) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date scheduledDate = sdf.parse(runAt);

            Date now = new Date();
            System.out.println("Current PC time: " + now);
            System.out.println("Scheduled time: " + scheduledDate);

            long delay = scheduledDate.getTime() - now.getTime();

            if (delay <= 0) {
                System.out.println("❌ Scheduled time is in the past! Please provide a future time.");
                return;
            }

            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("⏰ Executing test at: " + new Date());
                    runTestCaseByName(testCaseName);
                }
            };

            Timer timer = new Timer();
            timer.schedule(task, scheduledDate);

            System.out.println("📅 Scheduled '" + testCaseName + "' for: " + scheduledDate);

            // Keep program alive until task runs
            Thread.sleep(delay + 2000);

            System.out.println("⏳ Finished waiting. Program will exit now.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Reflection to run test by method name
    public static void runTestCaseByName(String testCaseName) {
        try {
            TestExecutor testInstance = new TestExecutor();
            Method method = TestExecutor.class.getMethod(testCaseName);
            method.invoke(testInstance);
        } catch (NoSuchMethodException e) {
            System.out.println("❌ Test case not found: " + testCaseName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        String testCaseName = "loginTest";  // or "logoutTest"
        String runAt = "09-06-2025 14:17:00";  // set your future time

        scheduleTestExecution(testCaseName, runAt);
    }
}
