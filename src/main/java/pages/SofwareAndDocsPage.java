package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SofwareAndDocsPage {
    WebDriver driver;

    public SofwareAndDocsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@href='/'][contains(text(),'Implant Studio ')]")
    public WebElement implamtStudioButton;




}
