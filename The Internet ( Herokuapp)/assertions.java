package TestNg1;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
@Listeners(ITestListener.class)
public class assertions {
    private SoftAssert softAssert ;

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(groups = {"regression"})
    public void hardassertvalidlogintestcase()
    {

     driver.findElement(By.id("inpiutUsername")).sendKeys("admin");
     driver.findElement(By.id("inputPassword")).sendKeys("admin");
     driver.findElement(By.id("loginButton")).click();
     driver.switchTo().alert().accept();
     Assert.assertEquals(driver.getCurrentUrl(),"https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");

    }
    @Test(groups = {"regression"})
    public void hardassertinvalidlogintestcase()
    {

        driver.findElement(By.id("inpiutUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("ahmed");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(),"https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");

    }
    @Test
    public void softassertvalidlogintestcase() {

        driver.findElement(By.id("inpiutUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.id("loginButton")).click();
        SoftAssert softassert = new SoftAssert();
        boolean exepected = driver.getCurrentUrl().equals("https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://asraaf7.github.io/AA-Practice-Test-Automation/indexhtml");
        softassert.assertFalse(exepected);
        softassert.assertAll();
    }

        @AfterMethod(alwaysRun = true)
    public void quit()
    {
    driver.quit();

    }

}

