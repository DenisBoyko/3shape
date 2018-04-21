import data.DataForTests3Shape;
import helpers.LoginPageMethod;
import helpers.WebLibrary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


public class SearchTest {
    WebDriver driver;

    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get(DataForTests3Shape.url3Shape);
        driver.manage().window().maximize();
        WebLibrary.waitImplicitly(10,driver);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void searchMenu() throws Exception {
        LoginPageMethod login = new LoginPageMethod(driver);
        login.loginPageMethod(DataForTests3Shape.validLoginFullAccess,DataForTests3Shape.validPasswordFullAccess);

        MainPage mainPage = new MainPage(driver);
        mainPage.searchButton.click();
        mainPage.searchField.sendKeys(DataForTests3Shape.searchWord);

        SearchPage searchPage = new SearchPage(driver);
        WebLibrary.isElementPresent(searchPage.searchFilterAll);
        WebLibrary.isElementPresent(searchPage.searchFilterBrochures);
        WebLibrary.isElementPresent(searchPage.searchFilterBuisness);
        WebLibrary.isElementPresent(searchPage.searchFilterMore);

        Thread.sleep(5000);


    }




}
