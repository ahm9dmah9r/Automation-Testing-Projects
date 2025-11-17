package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page02_HomePage {
    private WebDriver driver;
    private final By logoutButton = By.xpath("//button[Contains(@class,logout)]");

    public Page02_HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public Page01_LoginPage clickLogoutButton(){
        Utility.clickOnElement(driver,logoutButton);
        return new Page01_LoginPage(driver);

    }
}

