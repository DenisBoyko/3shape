package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends NavigationMenu {
        public SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@class='c-search__filter is-active'][contains(text(),'All')]")
    public WebElement searchFilterAll;

    @FindBy (xpath = "//*[@class='c-search__filter'][contains(text(),'Brochures')]")
    public WebElement searchFilterBrochures;

    @FindBy (xpath = "//*[@class='c-search__filter'][contains(text(),'Business Cases')]")
    public WebElement searchFilterBuisness;

    @FindBy (xpath = "//*[@class='c-search__filter'][contains(text(),'Catalogs')]")
    public WebElement searchFilterCatalogs;

    @FindBy (xpath = "//*[@class='c-search__filter c-search__filter--more '][contains(text(),'More')]")
    public WebElement searchFilterMore;

}
