import data.DataForTests3Shape;
import helpers.LoginFormMethod;
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
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        LoginFormMethod loginFormMethod = new LoginFormMethod(driver);

        loginFormMethod.loginValidDataLoginPage
                (dataForTests3Shape.validLoginFullAccess,dataForTests3Shape.validPasswordFullAccess, driver);
    }

    @Test
    public void InValidLoginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        LoginFormMethod loginFormMethod = new LoginFormMethod(driver);

        loginFormMethod.loginValidDataLoginPage
                (dataForTests3Shape.InValidLoginFullAccess,dataForTests3Shape.InValidPassword, driver);
    }

    @Test
    public void fullAccessPagesTest() throws Exception {
        //Login with Full access user.
        //All tabs should be available for this user

        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        MainPage mainPage = new MainPage(driver);
        LoginFormMethod loginFormMethod = new LoginFormMethod(driver);
//
        loginFormMethod.loginValidDataLoginPage
                (dataForTests3Shape.validLoginFullAccess,dataForTests3Shape.validPasswordFullAccess, driver);
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
        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        SoftwareUpgradesPage softwareUpgradesPage = new SoftwareUpgradesPage(driver);
        MainPage mainPage = new MainPage(driver);
        LoginFormMethod loginFormMethod = new LoginFormMethod(driver);

        loginFormMethod.loginValidDataLoginPage
                (dataForTests3Shape.validLoginFullAccess,dataForTests3Shape.validPasswordFullAccess, driver);
        WebLibrary.waitIfElementVisible(10,mainPage.mainPageTitle,driver);
        mainPage.softwareButton.click();
        WebLibrary.waitIfElementVisible(10,mainPage.implantStudioButton,driver);
        mainPage.implantStudioButton.click();

        WebLibrary.waitIfElementVisible(10,mainPage.softwareUpgradeButton,driver);
        mainPage.softwareUpgradeButton.click();
        Assert.assertEquals(dataForTests3Shape.latestVersionImplantStudio, softwareUpgradesPage.latestVersionImplantStudio.getText());
    }


    @Test
    public void imageBankFilterCheckTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        DataForTests3Shape dataForTests3Shape = new DataForTests3Shape();
        MainPage mainPage = new MainPage(driver);
        ImageBankPage imageBankPage = new ImageBankPage(driver);
        LoginFormMethod loginFormMethod = new LoginFormMethod(driver);

        loginFormMethod.loginValidDataLoginPage
                (dataForTests3Shape.validLoginFullAccess,dataForTests3Shape.validPasswordFullAccess,driver);
        WebLibrary.waitIfElementVisible(10,mainPage.mainPageTitle,driver);
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
        Assert.assertEquals(dataForTests3Shape.quntatyElementsinFilter,imageBankPage.quantityOfElementsInDom(driver));


    }




}
