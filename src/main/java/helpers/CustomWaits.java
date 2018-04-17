package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CustomWaits {
    WebDriver driver;


    public static void waitAndClick(int seconds, WebElement element, WebDriver driver) {
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public static void waitIfElementVisible(int seconds, WebElement element, WebDriver driver) {
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(element));
    }


    public static void implicitlyWait(int seconds, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);

    }

    public void fluentWait() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });
    }
}


