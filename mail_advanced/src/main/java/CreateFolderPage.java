import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateFolderPage extends BasePage {

    private static final String  USER_XXX_PH_BUTTON_TEXT = "//*[@id=\"datalist\"]/div[4]/div/div/div[2]";


    @FindBy (xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div/span/a/span")
    private WebElement clickCloud;
    @FindBy(xpath = "//*[@id=\"datalist\"]/div[4]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div/div")
    private WebElement clickFolder;
    @FindBy(xpath = "//*[@id=\"dropdownList\"]/div[1]")
    private WebElement addFolder;
    @FindBy(xpath = "//*[@id=\"react-modals\"]/div/div/div[3]/div/div[1]/button")
    private WebElement createFolder;
    @FindBy(xpath = "/html/body/div[14]/div/div/div/div/div[4]/button")
    private WebElement buttonclose;
    @FindBy(xpath ="//*[@id=\"react-modals\"]/div")
    private WebElement frame;
    @FindBy(xpath = "//*[@id=\"react-modals\"]/div/div/svg")
    private WebElement close;


    public CreateFolderPage clickCloud() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(clickCloud));
        this.clickCloud.click();
        return  this;
    }
    public CreateFolderPage clickFolder() throws InterruptedException{
        defaultWait.until(ExpectedConditions.elementToBeClickable(clickFolder));
        this.clickFolder.click();
        return  this;
    }
    public CreateFolderPage addFolder() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(addFolder));
        this.addFolder.click();
        return  this;
    }
    public CreateFolderPage createFolder() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(createFolder));
        this.createFolder.click();
        return  this;
    }

    public CreateFolderPage close() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(close));
        this.close.click();
        return  this;

    }

    public CreateFolderPage frame(){

       // driver.findElement(By.xpath("/html/body/div[14]/div/div")
        driver.switchTo().frame(frame);
       // driver.findElement(By.xpath("/html/body/div[14]/div/div")).click();

        return this;
    }

    public String getXXX(){
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath((USER_XXX_PH_BUTTON_TEXT)))));
        return driver.findElement(By.xpath(USER_XXX_PH_BUTTON_TEXT)).getText();
    }

}


