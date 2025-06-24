package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import java.util.Set;


	public class CookieDemo {

	    public static void main(String[] args) throws InterruptedException {

	        // Set the path to ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        Thread.sleep(3000);

	        driver.findElement(By.name("username")).sendKeys("Admin");
	        driver.findElement(By.name("password")).sendKeys("admin123");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Thread.sleep(3000);

	        Cookie ck = new Cookie("dummy", "value123");
	        driver.manage().addCookie(ck);
	        System.out.println("Added cookie: " + driver.manage().getCookieNamed("dummy"));

	        Set<Cookie> allCookies = driver.manage().getCookies();
	        System.out.println("Total cookies: " + allCookies.size());
	        for (Cookie cookie : allCookies) {
	            System.out.println(cookie.getName() + " = " + cookie.getValue());
	        }

	        Cookie specificCookie = driver.manage().getCookieNamed("OrangeHRM");
	        System.out.println("Specific Cookie (OrangeHRM): " + specificCookie);

	        Cookie customCookie = new Cookie("Vasu", "123456");
	        driver.manage().addCookie(customCookie);
	        System.out.println("Custom cookie added: " + driver.manage().getCookieNamed("Vasu"));

	        driver.manage().deleteCookie(customCookie);
	        System.out.println("Custom cookie deleted.");

	        driver.manage().addCookie(new Cookie("Vasu", "9154"));
	        driver.manage().deleteCookieNamed("Vasu");
	        System.out.println("Cookie 'Vasu' deleted by name.");

	        Cookie notFoundCookie = driver.manage().getCookieNamed("orangehrm");
	        System.out.println("Specific Cookie (orangehrm): " + notFoundCookie);

	        driver.manage().deleteAllCookies();
	        System.out.println("All cookies deleted.");

	        Thread.sleep(2000);
	        driver.quit();
	    }
	}