package TestNg1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestWithLog4j{

    static Logger log = Logger.getLogger(LoginTestWithLog4j.class);

    @Test
    public void loginTest() {
        log.info("Starting Login Test...");

        WebDriver driver = new ChromeDriver();
        log.info("Chrome Browser launched");

        driver.get("https://the-internet.herokuapp.com/login");
        log.info("Opened Login Page");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        log.info("Entered Username");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        log.info("Entered Password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        log.info("Clicked Login Button");

        String msg = driver.findElement(By.cssSelector(".flash.success")).getText();
        log.info("Login Message: " + msg);

        driver.quit();
        log.info("Browser Closed – Test Done");
    }
}
