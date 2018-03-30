package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SoftwareUpgrades {
    WebDriver driver;

    public SoftwareUpgrades(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath= "//*[contains(@href,\"777bb000\")]//*[@class='u-text-bold']")
    public WebElement latestVersionImolantStudio;



}
