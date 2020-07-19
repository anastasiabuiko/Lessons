import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Browser {

    public static final int DEFAULT_TIMEOUT = 20;

    private WebDriver driver;
    private static Browser browser;

    private Browser() {
        System.setProperty("webdriver.chrome.driver",
                "/home/n/Lessons/mail_advanced/src/test/java/resources/chromedriver");
        driver = new ChromeDriver();
    }
    public void switchToTab(String nameOfTab) {
        System.out.println(String.format("Switch to tab [%s]", nameOfTab));
        driver.switchTo().window(nameOfTab);
    }

    public static Browser getInstance() {
        if (browser == null) {
            return browser = new Browser();
        } else {
            return browser;
        }
    }

    public void closeBrowser() {
        driver.quit();
        browser = null;
    }

    public void getUrl(String url){
        System.out.println(String.format("Open page by URL: [%s]", url));
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickElement(By by){
        System.out.println(String.format("Click element located: [%s]", by));
        driver.findElement(by).click();
    }

    public void typeTo(By by, String value){
        System.out.println(String.format("Type [%s] to element located: [%s]", value, by));
        driver.findElement(by).sendKeys(value);
    }

    public boolean isDisplayed(By by){
        System.out.println(String.format("Check that element located [%s] is displayed", by));
        return driver.findElement(by).isDisplayed();
    }

    public String getTextFrom(By by){
        String text = driver.findElement(by).getText();
        System.out.println(String.format("Found [%s] on element located [%s]", text, by));
        return text;
    }

    public void waitForPresence(By by, int seconds){
        System.out.println(String.format("Wait for presence of element located [%s] for [%s] seconds",
                by, seconds));
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public Set<String> getWindowHandles(){
        System.out.println("Find all open tabs in browser");
        return driver.getWindowHandles();
    }
}
