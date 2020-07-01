import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendLetterPage extends  BasePage {

    private static final String Inbox = "llc__item";

    private static final String Errortext = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[2]/div[4]/div/div[1]";

    private static final String ErrortextTwo = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[3]/span[1]/span";

    private static final String Themed = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[1]/span";


    private static final String Empty = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/span/span";



    @FindBy(className = "compose-button__wrapper")
    private WebElement sendLetter;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")
    private WebElement eladdress;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")
    private WebElement theme;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[2]")
    private WebElement text;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span")
    private WebElement button;
    @FindBy(className = "layer__link")
    private WebElement sent;
    @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]/span")
    private WebElement crest;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[2]/span")
    private WebElement buttonSave;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[2]/div/div/button[2]")
    private WebElement exit;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/nav/a[5]/div/div[1]")
    private WebElement draft;
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[3]/button/div/span[2]")
    private WebElement check;
    @FindBy (xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/span[2]/div[1]/span/span")
    private WebElement delete;
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[2]/span")
    private WebElement SaveButton;
    @FindBy(xpath = "/html/body/div[16]/div/div/div[2]/button[1]")
    private WebElement sendbutton;


    public SendLetterPage sendLetter() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(sendLetter));
        sendLetter.click();
        return this;
    }

    public SendLetterPage withAddress(String address) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(eladdress));
        this.eladdress.sendKeys(address);
        return this;
    }

    public SendLetterPage withTheme(String theme) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(this.theme));
        if (theme!=null) {
            this.theme.sendKeys(theme);
        }
        return this;
    }

    public SendLetterPage sendMessage() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        return this;
    }

    public SendLetterPage withText(String text) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(this.text));
        if(text!=null) {
            this.text.sendKeys(text);
        }
        return this;
    }

    public SendLetterPage crestClick() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(crest));
        crest.click();
        return this;
    }

    public String Inbox() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className(Inbox))));
        return driver.findElement(By.className(Inbox)).getText();
    }

    public String Error() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Errortext))));
        return driver.findElement(By.xpath(Errortext)).getText();
    }

    public String ErrorTwo() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Errortext))));
        return driver.findElement(By.xpath(ErrortextTwo)).getText();
    }

    public void cresd() {
        try {
            Thread.sleep(5000);
            driver.findElement(By.className("ico_16-close ico_size_s")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void buttonSave() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(buttonSave));
        buttonSave.click();
    }

    public String Themed() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Themed))));
        return driver.findElement(By.xpath(Themed)).getText();
    }


    public void draft() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(draft));
        draft.click();
    }

    public void check() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(check));
        check.click();
    }
    public void delete() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(delete));
        delete.click();
    }
    public void exit() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(exit));
        exit.click();
    }
    public String Empty() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Empty))));
        return driver.findElement(By.xpath(Empty)).getText();
    }

    public void SaveButton() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        SaveButton.click();
    }

    public void Sendbutton(){
        defaultWait.until(ExpectedConditions.elementToBeClickable(sendbutton));
        sendbutton.click();
    }
}
