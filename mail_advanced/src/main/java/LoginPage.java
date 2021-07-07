import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;

public class LoginPage extends BasePage{
    private static final  String URL = "https://cloud.mail.ru";
    private static final String  USER_X_PH_BUTTON_TEXT = "x-ph__menu__button__text";
    private static final String  USER_XXX_PH_BUTTON_TEXT = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/nav/a[4]";

    @FindBy(className= "js-signin")
    private WebElement clickLogin;

    @FindBy(className = "ag-popup__frame__layout__iframe")
    private WebElement frame;

   @FindBy (css = "input[type=\"text\"]")
    private WebElement login;

    @FindBy (id = "mailbox:domain")
    private WebElement domain;

    @FindBy (css = "button[type=\"submit\"]")
    private WebElement  clickpassword;

    @FindBy (css = "input[type=\"password\"]")
    private WebElement mypassword;

    @FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[5]/div/div[3]/div/div[2]/div")
    private WebElement checkbox;

    public LoginPage() {
    }

    public LoginPage load(){
        driver.get(URL);
        return this;
    }

    public LoginPage switchToFrame(){
        defaultWait.until(ExpectedConditions.elementToBeClickable(frame));
        driver.switchTo().frame(frame);
      return this;
    }

    public LoginPage clickLogin() throws InterruptedException {
        defaultWait.until(ExpectedConditions.elementToBeClickable(clickLogin));
        clickLogin.click();
        return  this;
    }

    public LoginPage UserName(String  name) throws InterruptedException   {
        defaultWait.until(ExpectedConditions.elementToBeClickable(login));
        login.sendKeys(name);
        WrappedDriver.highlightElement(login);
        return  this;
    }

    public LoginPage checkbox(){
        defaultWait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();
        return this;
    }

    public EmailMainPage clickLoginButton(){
        clickpassword.click();
        return new EmailMainPage();
    }

    public  LoginPage typePassword(String password) throws InterruptedException {
        defaultWait.until(ExpectedConditions.elementToBeClickable(mypassword));
        mypassword.sendKeys(password);
        WrappedDriver.highlightElement(mypassword);
        return  this;
    }

    public String getXPH(){
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(USER_X_PH_BUTTON_TEXT))));
        return driver.findElement(By.className(USER_X_PH_BUTTON_TEXT)).getText();
    }

    public void logOut(){
        defaultWait.until(ExpectedConditions.elementToBeClickable(By.id("PH_logoutLink")));
        driver.findElement(By.id("PH_logoutLink")).click();
    }

}
