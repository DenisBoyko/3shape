package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ImageBankPage extends NavigationMenu {
        public ImageBankPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//*[contains(text(), 'Image bank')]")
    public WebElement imageBunkTitle;

    @FindBy (xpath = "//*[@class='c-filter__list-item'][1]")
    public WebElement productFilter;

    @FindBy (xpath = "//*[@for='0F847891FF9843E0BBB7C606560B491C']")
    public WebElement scanBodiesCheckBox;

    @FindBy (xpath = "//*[contains(text(),'Apply')]")
    public WebElement applyButton;


    public char[] quantityOfElementsInFilter(WebDriver driver) {
        String quantityOfElements = scanBodiesCheckBox.getText();
        char[] Str2 = new char[2];
        quantityOfElements.getChars(20, 22, Str2, 0);
        return Str2;
    }



    public int quantityOfElementsInDom(WebDriver driver){
        List<WebElement> list = driver.findElements(By.cssSelector("[class='c-result c-result__card']"));
        int quantity = list.size();
        return quantity;
    }




}
