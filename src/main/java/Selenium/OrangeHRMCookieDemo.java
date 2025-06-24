package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

        public class OrangeHRMCookieDemo {

        public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();  
        Thread.sleep(1000);
        driver.manage().window().minimize(); 
        Thread.sleep(1000);
        driver.manage().window().maximize();      
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));  
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println("My Title: " + title);
        String expected = "OrangeHRM";
        if (title.equals(expected)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title Not Matched");
        }
        boolean b = driver.findElement(By.xpath("//h5[text()='Login']")).isDisplayed();
        System.out.println("Login text Present: " + b);    
        
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
        String hiddenText = (String) js.executeScript("return document.title");
        System.out.println("Title from JS: " + hiddenText);
        Actions actions = new Actions(driver);
        WebElement userDropdown = driver.findElement(By.className("oxd-userdropdown-tab"));
        actions.moveToElement(userDropdown).perform();
        Thread.sleep(2000);
        actions.contextClick(userDropdown).perform();
        Thread.sleep(1000);
        actions.doubleClick(userDropdown).perform();
        WebElement active = driver.switchTo().activeElement();
        System.out.println("Active Element Tag: " + active.getTagName());
        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        System.out.println("Dashboard Font: " + dashboard.getCssValue("font-family"));
        System.out.println("Dashboard Text: " + dashboard.getText());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src, new File("C:\\Users\\User.LAPTOP-C2RP2P0D\\Desktop\\New folder\\screenshot.png"));
            System.out.println("Screenshot captured successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot.");
        }
        Cookie ck = new Cookie("dummy", "value");
        driver.manage().addCookie(ck);
        System.out.println("Cookie added: " + driver.manage().getCookieNamed("dummy"));

        js.executeScript("window.open('https://www.google.com','_blank');");
        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            driver.switchTo().window(win);
            System.out.println("Switched to window: " + driver.getTitle());
        }
        driver.switchTo().window(allWindows.iterator().next()); 
        WebElement profile = driver.findElement(By.className("oxd-userdropdown-tab"));
        profile.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Total cookies: " + cookies.size());
        for (Cookie ck1 : cookies) {
            System.out.println(ck1.getName() + " = " + ck1.getValue());
        }
        Cookie specificCookie = driver.manage().getCookieNamed("OrangeHRM");
        System.out.println("Specific Cookie: " + specificCookie); 
        Cookie testCookie = new Cookie("Vasu", "123456");
        driver.manage().addCookie(testCookie);
        driver.manage().deleteCookie(testCookie);
        driver.manage().addCookie(new Cookie("Vasu", "9154"));
        driver.manage().deleteCookieNamed("Vasu");
        Cookie specificCookie1 = driver.manage().getCookieNamed("orangehrm");
        System.out.println("Specific Cookie: " + specificCookie1); // Wi
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.quit();
    }
}