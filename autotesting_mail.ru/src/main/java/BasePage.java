import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait defaultWait;

    public BasePage() {
        this.driver = WrappedDriver.getInstanse();
        PageFactory.initElements(driver, this);
        defaultWait = new WebDriverWait(driver, 5);
    }
}
