import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage  extends BasePage{
    private static final  String URL = "https://mail.ru/";
    private static final String  USER_X_PH_BUTTON_TEXT = "x-ph__menu__button__text";
    private static final String  LOGIN_ERROR_MASSAGE = "mailbox:error";

    @FindBy (id = "mailbox:login")
    private WebElement login;

    @FindBy (id = "mailbox:domain")
    private WebElement domain;

    @FindBy (css = "input[type=\"submit\"]")
    private WebElement  clickpassword;

    @FindBy (id ="mailbox:password")
    private WebElement mypassword;

    @FindBy(id = "mailbox:saveauth")
    private WebElement checkbox;

    public LoginPage() {
    }

    public LoginPage load(){
        driver.get(URL);
        return this;
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
        defaultWait.until(ExpectedConditions.elementToBeClickable(By.id("PH_user-email")));
        driver.findElement(By.id("PH_user-email")).click();
        defaultWait.until(ExpectedConditions.elementToBeClickable(By.className("x-ph__button__fake")));
        driver.findElement(By.className("x-ph__button__fake")).click();
    }

    public String getErrorMassage () {
        defaultWait.until(ExpectedConditions.elementToBeClickable(By.id(LOGIN_ERROR_MASSAGE)));
        return driver.findElement(By.id(LOGIN_ERROR_MASSAGE)).getText();
    }
}
