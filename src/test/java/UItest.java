import helpers.WebLibrary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GeneralPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class UItest {
    WebDriver driver;


    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://partner.3shape.com/en/login");
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
        loginPage.passwordField.sendKeys("123456");
        WebLibrary.waitAndClick(9,loginPage.submitButton,driver);

        WebDriverWait wait2 = new WebDriverWait(driver,10);


        WebElement button = driver.findElement(By.cssSelector("[role=button]"));

        System.out.print(button.getText());




        Thread.sleep(3000);



//        Assert.assertEquals(" Marketing library ",generalPage.marketingLibraryButton.getText());

//        Assert.assertTrue(WebLibrary.isElementPresent(generalPage.productReleasesButton));










    }


}
