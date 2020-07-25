import jdk.internal.jline.internal.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static final int DEFAULT_TIMEOUT = 20;

    private WebDriver driver;
    private static Browser browser;

    private Browser() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\ITAcademy\\DEMO_REPO\\MAVEN_DEMO\\tat-examples\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
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
        Log.logDebug(String.format("Open page by URL: [%s]", url));
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickElement(By by){
        Log.logClick(by);
        driver.findElement(by).click();
    }

    public void typeTo(By by, String value){
        Log.logDebug(String.format("Type [%s] to element located: [%s]", value, by));
        driver.findElement(by).sendKeys(value);
    }

    public boolean isDisplayed(By by){
        Log.logDebug(String.format("Check that element located [%s] is displayed", by));
        return driver.findElement(by).isDisplayed();
    }

    public String getTextFrom(By by){
        String text = driver.findElement(by).getText();
        Log.logDebug(String.format("Found [%s] on element located [%s]", text, by));
        return text;
    }

    public void waitForPresence(By by, int seconds){
        Log.logDebug(String.format("Wait for presence of element located [%s] for [%s] seconds",
                by, seconds));
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
