package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebLibrary {


    public static boolean isElementPresent(WebElement element) throws Exception {
        try {
            element.getText();
        }
        catch (NoSuchElementException e){
            return false;

        } catch (Exception exception){
            throw new Exception("Unexpected exception. " + exception.getClass() + exception.getMessage());
        }
        return true;
    }


    public static boolean isChecked(WebElement checkbox){
        if(checkbox.isSelected()){
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
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

    }

}
