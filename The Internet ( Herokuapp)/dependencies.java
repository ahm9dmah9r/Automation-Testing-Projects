package TestNg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class dependencies {

    private SoftAssert softAssert;

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void registertc () {
        System.out.println("register");

    }


    @Test(dependsOnMethods = "registertc")
    public void logintc()
    {
        System.out.println("login");

    }


    @AfterMethod
    public void quit() {
        driver.quit();

    }
}