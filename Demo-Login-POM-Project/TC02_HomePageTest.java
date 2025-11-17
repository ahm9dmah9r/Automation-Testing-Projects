import Pages.Page01_LoginPage;
import Utilities.DataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC02_HomePageTest{
        private WebDriver driver;

        @BeforeMethod
        public void setupDriver() throws IOException {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(DataUtil.getPropertiesData("environments", "Home_URL"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        }
        @Test
        public void validLoginTC() throws IOException {
            new Page01_LoginPage(driver).enterUserName("admin")
                    .enterPasswrod("admin")
                    .clickLoginbutton()
                    .clickLogoutButton();
            Assert.assertNotEquals(driver.getCurrentUrl(),DataUtil.getPropertiesData("environments", "Home_URL"));

        }
        @AfterMethod
        public void quit()
        {

            driver.quit();
        }
    }



