import data.DataForTests3Shape;
import helpers.WebLibrary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


public class threeShapeTest {
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
    public void validLoginTest() throws Exception {
        // Validation login and transition to Main page

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();

        loginPage.loginField.sendKeys(dataForTests3Shape.validLoginFullAccess);
        loginPage.passwordField.sendKeys(dataForTests3Shape.validPasswordFullAccess);
        loginPage.submitButton.click();
        WebLibrary.isElementPresent(mainPage.productReleasesButton);
    }

    @Test
    public void InValidLoginTest(){
        //Input Invalid login and passwor, user should see Error Massage

        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();

        loginPage.loginField.sendKeys(dataForTests3Shape.InValidLoginFullAccess);
        loginPage.passwordField.sendKeys(dataForTests3Shape.InValidPassword);
        loginPage.submitButton.click();
        Assert.assertEquals(dataForTests3Shape.errorAuthorizationMessege,loginPage.errorAuthorizationMessege.getText());
    }

    @Test
    public void fullAccessPagesTest() throws Exception {
        //Login with Full access user.
        //All tabs should be available for this user

        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        MainPage mainPage = new MainPage(driver);

        loginPage.loginField.sendKeys(dataForTests3Shape.validLoginFullAccess);
        loginPage.passwordField.sendKeys(dataForTests3Shape.validPasswordFullAccess);
        loginPage.submitButton.click();
        WebLibrary.waitIfElementVisible(10,mainPage.mainPageTitle,driver);

        WebLibrary.isElementPresent(mainPage.searchButton);
        WebLibrary.isElementPresent(mainPage.productReleasesButton);
        WebLibrary.isElementPresent(mainPage.softwareButton);
        WebLibrary.isElementPresent(mainPage.resellerToolBoxButton);

        WebLibrary.isElementPresent(mainPage.marketingLibraryButton);
        WebLibrary.isElementPresent(mainPage.supportButton);
        WebLibrary.isElementPresent(mainPage.academyButton);
        WebLibrary.isElementPresent(mainPage.contactButton);
        WebLibrary.isElementPresent(mainPage.loguotButton);
    }

    @Test
    public void latestVersionChekTest() throws Exception {
        //Check that latest version of Implant Studio is 2.17.1.4 version.

        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        SoftwareUpgradesPage softwareUpgradesPage = new SoftwareUpgradesPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.loginField.sendKeys(dataForTests3Shape.validLoginFullAccess);
        loginPage.passwordField.sendKeys(dataForTests3Shape.validPasswordFullAccess);
        loginPage.submitButton.click();

        WebLibrary.waitIfElementVisible(10, mainPage.mainPageTitle,driver);
        mainPage.softwareButton.click();
        WebLibrary.waitIfElementVisible(10,mainPage.implantStudioButton,driver);
        mainPage.implantStudioButton.click();

        WebLibrary.waitIfElementVisible(10,mainPage.softwareUpgradeButton,driver);
        mainPage.softwareUpgradeButton.click();
        Assert.assertEquals(dataForTests3Shape.latestVersionImplantStudio, softwareUpgradesPage.latestVersionImplantStudio.getText());
    }


    @Test
    public void imageBankFilterCheckTest() throws Exception {
        // Check that quantity of elements in page equals 13
        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        MainPage mainPage = new MainPage(driver);
        ImageBankPage imageBankPage = new ImageBankPage(driver);

        loginPage.loginField.sendKeys(dataForTests3Shape.validLoginFullAccess);
        loginPage.passwordField.sendKeys(dataForTests3Shape.validPasswordFullAccess);
        loginPage.submitButton.click();
        WebLibrary.waitIfElementVisible(10, mainPage.mainPageTitle,driver);

        mainPage.marketingLibraryButton.click();
        WebLibrary.waitIfElementVisible(10,mainPage.imageBankButton,driver);
        mainPage.imageBankButton.click();
        WebLibrary.waitIfElementVisible(10,imageBankPage.imageBunkTitle,driver);

        imageBankPage.productFilter.click();
        imageBankPage.scanBodiesCheckBox.click();
        imageBankPage.applyButton.click();
        imageBankPage.quantityOfElementsInDom(driver);

        Thread.sleep(5000);
        Assert.assertEquals(dataForTests3Shape.quantityElementsFilter,imageBankPage.quantityOfElementsInDom(driver));




    }




}
