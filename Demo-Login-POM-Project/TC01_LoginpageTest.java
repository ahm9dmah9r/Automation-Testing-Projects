import Pages.Page01_LoginPage;
import Utilities.DataUtil;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginpageTest {
    private WebDriver driver;
    String USERNAME = new Faker().name().username();

    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtil.getPropertiesData("environments", "Login_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Description("This test case verify that user logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void validLoginTC() throws IOException {
        new Page01_LoginPage(driver).enterUserName(DataUtil.getJsonData("validlogindata","username"))
                .enterPasswrod(DataUtil.getJsonData("validlogindata","password")).clickLoginbutton();
        Assert.assertEquals(driver.getCurrentUrl(),DataUtil.getPropertiesData("environments", "Home_URL"));

    }
    @Test
    public void InvalidLoginTC() throws FileNotFoundException {
        Page01_LoginPage loginPage = new Page01_LoginPage(driver);
        new Page01_LoginPage(driver).enterUserName(DataUtil.getJsonData("validlogindata","username"))
                .enterPasswrod(USERNAME)
                .clickLoginbutton();
        Assert.assertTrue(loginPage.getErrorMessage().contains(" Please fill out this field"),
                "Error message not shown for invalid login");
    }
    @Test
    public void emptyUsernameTest() {
        Page01_LoginPage loginPage = new Page01_LoginPage(driver);
        new Page01_LoginPage(driver).enterUserName("")
        .enterPasswrod("Password123")
        .clickLoginbutton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"),
                "Error message not shown when username is empty");
    }

    @Test
    public void emptyPasswordTest() {
        Page01_LoginPage loginPage = new Page01_LoginPage(driver);
         new Page01_LoginPage(driver).enterUserName("student")
        .enterPasswrod("")
        .clickLoginbutton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"),
                "Error message not shown when password is empty");
    }

    @Test
    public void shortPasswordTest() {
        Page01_LoginPage loginPage = new Page01_LoginPage(driver);
         new Page01_LoginPage(driver).enterUserName("student")
                .enterPasswrod("12")
                .clickLoginbutton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"),
                "Error message not shown for short password");
    }

    @Test
    public void rememberMeTest() {
        Page01_LoginPage loginPage = new Page01_LoginPage(driver);
        driver.findElement(By.cssSelector("input[type='checkbox'][value='remember-me']")).click();
        Assert.assertTrue(loginPage.isRememberMeSelected(),
                "Remember Me checkbox not selected after clicking");
    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
