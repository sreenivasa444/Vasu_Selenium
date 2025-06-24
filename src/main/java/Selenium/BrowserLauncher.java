package Selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BrowserLauncher extends BrowserFactory {

    public void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();            
    }

    @Test
    public void launch() {
        driver = getDriver("chrome");          
        if (driver != null) {
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);
            driver.close();
        } else {
            System.out.println("Driver initialization failed.");
        }
    }
}
