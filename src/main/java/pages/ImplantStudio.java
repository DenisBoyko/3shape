package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImplantStudio {
    WebDriver driver;

    public ImplantStudio(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "[href='/en/software-and-docs/implant-studio/software-upgrades']")
    public WebElement softwareUpgradeButton;

    //*[contains(@href,"777bb000")]//*[@class='u-text-bold']


}
