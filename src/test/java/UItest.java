import helpers.WebLibrary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GeneralPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class UItest {
    WebDriver driver;


    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://partner.3shape.com/en/login");
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
        GeneralPage generalPage = new GeneralPage(driver);

        loginPage.loginField.sendKeys("3shape.partnerportal.dental.fullaccess");
        loginPage.passwordField.sendKeys("123456");//
        loginPage.submitButton.click();

        Thread.sleep(3000);
        generalPage.resellerToolBoxButton.click();




    }


}
