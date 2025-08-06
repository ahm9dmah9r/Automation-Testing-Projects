package TestNg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class parametersparallelthreadlocal {
    private SoftAssert softassert ;

   // private WebDriver driver;
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setup()
    {
        driverThreadLocal.set(new EdgeDriver());
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameters(value = {"username,password"})
    @Test()
    public void validlogintestcase(@Optional("admin") String username,@Optional("admin") String password)
    {

        driverThreadLocal.get().findElement(By.id("inpiutUsername")).sendKeys(username);
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password);
        driverThreadLocal.get().findElement(By.id("loginButton")).click();
        driverThreadLocal.get().switchTo().alert().accept();
        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(),"https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");

    }

    @AfterMethod
    public void quit()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();

    }






}
