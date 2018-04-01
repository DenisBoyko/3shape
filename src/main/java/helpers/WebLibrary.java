package helpers;

import com.sun.deploy.cache.Cache;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.pkcs11.wrapper.Constants;

import java.io.File;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebLibrary {
    WebDriver driver;


    public static boolean isElementPresent(WebElement element) throws Exception {
        try {
            element.isDisplayed();
        } catch (Exception exception) {
            throw new Exception("Element not found");
        }
        return true;
    }


    public static boolean isChecked(WebElement checkbox) {
        if (checkbox.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public static void waitAndClick(int seconds, WebElement element, WebDriver driver) {
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public static void waitIfElementVisible(int seconds, WebElement element, WebDriver driver) {
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitImplicitly(int seconds, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);

    }


    public static void getscreenshot(WebDriver driver) throws Exception
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Denys.b\\Desktop\\ScreenShots\\screenshot.png"));
    }
}
