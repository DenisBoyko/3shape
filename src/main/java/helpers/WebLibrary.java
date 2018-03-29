package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebLibrary {
    WebDriver driver;


    public static boolean isElementPresent(WebElement element) throws Exception {
        try {
            element.getText();
        } catch (NoSuchElementException e) {
            return false;

        } catch (Exception exception) {
            throw new Exception("Unexpected exception. " + exception.getClass() + exception.getMessage());
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
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public static void waitIfElementClickable(int seconds, WebElement element, WebDriver driver) {
        WebDriverWait waitIfElementClickable = new WebDriverWait(driver, seconds);
        waitIfElementClickable.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitImplicitly(int seconds, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);

    }


    public static void waitFoo(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, SECONDS)
                .pollingEvery(20, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("[href='/en/product-releases']"));
            }
        });

    }
}
