package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SoftwareUpgradesPage extends NavigationMenu {
        public SoftwareUpgradesPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath= "//*[contains(@href,\"777bb000\")]//*[@class='u-text-bold']")
    public WebElement latestVersionImplantStudio;



}
