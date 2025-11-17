package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page01_LoginPage {
    private WebDriver driver;

    private final By username = By.id("inputUsername");
    private final By password = By.id("inputPassword");
    private final By loginbutton = By.id("LoginButton");
    private final By rememberMe = By.cssSelector("input[type='checkbox'][value='remember-me']");
    private final By errorMessage = By.xpath("//*[contains(text(),'Please fill out this field')]");


    public Page01_LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Page01_LoginPage enterUserName(String usernametext)
    {
        Utility.sendData(driver,username,usernametext);
        return this;
    }
    public Page01_LoginPage enterPasswrod(String passwordtext)
    {
        driver.findElement(password).sendKeys(passwordtext);
        return this;
    }
    public boolean isRememberMeSelected() {
        return driver.findElement(rememberMe).isSelected();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginbutton).isEnabled();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    public Page02_HomePage clickLoginbutton()
    {
        Utility.clickOnElement(driver,loginbutton);
        return new Page02_HomePage(driver);
    }


}

