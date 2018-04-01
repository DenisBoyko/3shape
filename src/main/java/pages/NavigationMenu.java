package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
    WebDriver driver;

    public NavigationMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".icon-home")
    public WebElement homeButton;

    @FindBy (css = "[href='#'] .icon-search")
    public WebElement searchButton;

    @FindBy (css = "[href='/en/product-releases']")
    public WebElement productReleasesButton;

    @FindBy (css = ".icon-docs")
    public WebElement softwareButton;

    @FindBy (css = "[href='/en/reseller-toolbox']")
    public WebElement resellerToolBoxButton;

    @FindBy (css = ".icon-media")
    public WebElement marketingLibraryButton;

    @FindBy (css = ".icon-tool")
    public WebElement supportButton;

    @FindBy (css = ".icon-ribbon")
    public WebElement academyButton;

    @FindBy (css = ".icon-speak")
    public WebElement contactButton;

    @FindBy (css = ".icon-lock")
    public WebElement loguotButton;

    @FindBy (xpath = "//*[@href='/'][contains(text(),'Implant Studio ')]")
    public WebElement implantStudioButton;

    @FindBy (css = "[href='/en/software-and-docs/implant-studio/software-upgrades']")
    public WebElement softwareUpgradeButton;

    @FindBy (css = "[href='/en/marketing-library/image-bank']")
    public WebElement imageBankButton;


}
