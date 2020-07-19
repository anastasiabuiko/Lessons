import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.ArrayList;

public class DeleteFolderPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/nav/a[4]")
    private WebElement deleteFolder;
    @FindBy(className = "//div[@data-name='remove']")
    private WebElement delete;
    @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/span")
    private WebElement deletebutton;

    public DeleteFolderPage switchToTheSecondTab(){
        ArrayList<String> tabs = new ArrayList<String> (browser.getWindowHandles());
        browser.switchToTab(tabs.get(1));
        return this;
    }


    public DeleteFolderPage clickDeleteFolder() {
        Actions actions = new Actions(driver);
        actions.moveToElement(deleteFolder);
        actions.contextClick(deleteFolder).build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element= driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div/div[7]"));
        element.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element2= driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/span/span"));
        element2.click();
        return  this;
    }
    public DeleteFolderPage delete() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(delete));
        delete.click();
        return  this;
    }

    public DeleteFolderPage deletebutton() {
        defaultWait.until(ExpectedConditions.elementToBeClickable(deletebutton));
        deletebutton.click();
        return  this;
    }

    public boolean isFolderNoEcxict(){
       if (driver.findElements(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div[1]/nav/a[4]/div/div[2]")).size() ==0){
            return true;
       }
        return false;
    }
}
