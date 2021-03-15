import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrappedDriver {

    private static final long PAGE_TO_LOAD_TIMEOUT = 3;
    private static WebDriver driver;

    private WrappedDriver(){}

    public static WebDriver getInstanse(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver",
                    "/home/n/Lessons/autotesting_mail.ru/src/test/java/resources/chromedriver");
            return driver = new ChromeDriver();
        } else {
            return driver;
        }
    }

    public static void CloseDriver(){
        driver.close();
        driver.quit();
        driver = null;
    }

    public static WebDriverWait Wait() {
        return new WebDriverWait(driver, PAGE_TO_LOAD_TIMEOUT);
    }

    public static void highlightElement(WebElement element) throws InterruptedException {
        String bgColor = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
        Thread.sleep(5000);
        js.executeScript("arguments[0].style.backgroundColor = '" + bgColor +"'", element);
    }
}
