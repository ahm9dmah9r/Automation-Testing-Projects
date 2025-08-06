import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Selenium {
   public static WebDriver Driver = new EdgeDriver();
   public static String firsttab;
   public static String secondtab;
    public static void main(String[] args) {
        OpenBrowser("https://the-internet.herokuapp.com/login");
        OpenBrowser("https://the-internet.herokuapp.com/dynamic_loading/1");
        OpenBrowser("https://the-internet.herokuapp.com/dynamic_loading/2");
        OpenBrowser("https://the-internet.herokuapp.com/windows");
        OpenBrowser("https://the-internet.herokuapp.com/javascript_alerts");
        OpenBrowser("https://the-internet.herokuapp.com/key_presses");
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //any method call it here
        By usernameinput = By.id("username");
        Driver.findElement(usernameinput).click();
        entertext("tomsmith","SuperSecretPassword!");
        clicking();
        Set<String> handles = openNewTab();
        for (String h : handles)
        {
            if (!h.equals(firsttab))
                secondtab = h;

        }
        System.out.println(firsttab);
        System.out.println(secondtab);
        System.out.println(Driver.getCurrentUrl());
        switchingTab(secondtab);
        System.out.println(Driver.getCurrentUrl());


    }
    public static WebElement bytowebelement(By locator){

        return   Driver.findElement(locator);

    }

    public static void OpenBrowser(String URL){
        Driver.get(URL);
    }
    public static void ManageWindow(){
        Driver.manage().window().maximize();

    }
    public static void entertext(String username,String password){
        By usernamelocator=By.id("username");
        By passwordlocator=By.id("password");
        Driver.findElement(usernamelocator).sendKeys(username);
        Driver.findElement(passwordlocator).sendKeys(password);



    }
    public static void clicking(){
        By loginbutton = By.className("radius");
        Driver.findElement(loginbutton).click();

    }


    public static void Navigation(String URL){
        Driver.navigate().forward();
        //refresh back next to

    }

    public static void GetCurrentUrl(){
        String URL = Driver.getCurrentUrl();
        System.out.println(URL);
    }
    public static void gettextfromfield(){
        By flashmessage = By.cssSelector("div#flash");
        String msg = Driver.findElement(flashmessage).getText();
        System.out.println(msg);
    }
    public static void cleartext(){
        By usernamelocator=By.id("username");
        Driver.findElement(usernamelocator).clear();


    }
    public static void gethelloworld(){

        By startbitton = By.tagName("button");
        By helloworldmsg = By.xpath("//div[@id='finish']//div");
        Driver.findElement(startbitton).click();
        explicitwait(helloworldmsg);
        Driver.findElement(helloworldmsg).getText();

    }
    public static void explicitwait(By locator){
        new WebDriverWait(Driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }
    public static void handlingdropdwon(){
        By dropdown = By.cssSelector("select#dropdown");
        new Select(bytowebelement(dropdown)).selectByIndex(1);
        //byvalue-byindex-byvisibletext

    }
    public static void hanldingcheckbox(){

        By checkbox = By.cssSelector("input[type='checkbox]:nth-of-type(1)");
        Driver.findElement(checkbox).click();

    }
    public static void hanldingradiobutton() {

        By radio = By.id("vfb-7-1");
        Driver.findElement(radio).click();
    }
    public static void checkboxIsselected(){
        By ahlycheckbox = By.id("Ahly");
        By zmalekcheckbox = By.id("Zamalek");
        System.out.println("First checkbox is selected" + Driver.findElement(ahlycheckbox).isSelected());


    }
    public static void diubleclick(){
        By checkboxbutton = By.xpath("//button[text()='show Checkbox']");
        By ahlycheckbox = By.id("Ahly");
        Driver.findElement(checkboxbutton).click();
        new Actions(Driver).doubleClick(bytowebelement(ahlycheckbox)).perform();
        //rightclick-drag and drop-click and hold - hovering


    }
    public static void switchingTab (String handle)
    {
     Driver.switchTo().window(handle);


    }
    public static Set<String> openNewTab()
    {

        By newtabbutton = By.cssSelector("a[href='/windows/new']");
        Driver.findElement(newtabbutton).click();
        Set<String> handles = Driver.getWindowHandles();
        return handles;
        /* can write with this shape
         return handles = Driver.getWindowHandles();*/


    }
    public static void iframe(){
        By textArea = By.cssSelector("body#tinymce p");
        Driver.switchTo().frame("mce_0_ifr");
        Driver.findElement(textArea).sendKeys("hello");
        Driver.switchTo().defaultContent();

    }
    public static void acceptallert()
    {
        Driver.findElement(By.cssSelector("[onClick='jsAlert()']")).click();
        Driver.switchTo().alert().accept();
        //dismiss prompt
    }
    public static void keyusingsendkeys(){
        Driver.findElement(By.id("target")).sendKeys(Keys.ARROW_RIGHT);

    }
    public static void keyusingactios(){
        new Actions(Driver).keyDown(Keys.SHIFT).perform();

    }
    public static void scrollingusingactios(){
        new Actions(Driver).scrollToElement(bytowebelement(By.id("scroll_text"))).perform();


    }
    public static void scrollingusingjsjs(){

        ((JavascriptExecutor)Driver).executeScript("arguments[0].srollintoview();",bytowebelement(By.id("scroll_text")));
        new WebDriverWait(Driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(bytowebelement(By.id("scroll_text")),"disabled")));
         Driver.findElement(By.id("scroll_text")).sendKeys("test");
         //adding wait
    }

    public static void takingscreenshot(String ImageName) throws IOException {
       String path = "D:\\Me\\SWT\\Test Automation Projects\\Selenium1\\src\\main\\resources\\";
       File src =  ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
       File target = new File(path+ImageName+".png");
        FileUtils.copyFile(src,target);
    }
    public static void uploadfileusingsendkeys(String path){

        Driver.findElement(By.id("file-upload")).sendKeys(path);

    }
    public static void uloadfineusingrobot(String path) throws AWTException {
        Driver.findElement(By.id("chooseFileBtn")).click();
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



    }
    public static void intializeDriver(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        Driver = new EdgeDriver(edgeOptions);

    }
    public static void checkbroken(List<WebElement> elements) throws IOException, URISyntaxException {
        for (WebElement element : elements)
        {
            URL url = new URI(element.getAttribute("src")).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection.getResponseMessage()+" "+httpURLConnection.getResponseCode());

        }




    }


}
