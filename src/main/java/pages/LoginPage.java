package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#email")
    public WebElement loginField;

    @FindBy (css = "#password")
    public WebElement passwordField;

    @FindBy (xpath= "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy (css = "[class='field-validation-error alert alert-danger column']")
    public WebElement errorAuthorizationMessege;

    @FindBy (css = "[class = '_3ixn']")
    public WebElement fail;

}
