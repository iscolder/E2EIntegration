package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class GenericUtils {

    private WebDriver driver;
    private Actions actions;

    private GenericUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    private static GenericUtils instance;

    public static GenericUtils getInstance(WebDriver driver) {
        if (instance == null) {
            synchronized (GenericUtils.class) {
                if (instance == null) {
                    instance = new GenericUtils(driver);
                }
            }
        }
        return instance;
    }

    public WebElement getElement(LocatorType type, String locator) {
        return WebElementsFactory.getSingle().get(type).apply(driver, locator);
    }

    public List<WebElement> getElements(LocatorType type, String locator) {
        return WebElementsFactory.getMultiple().get(type).apply(driver, locator);
    }

    public boolean elementExists(LocatorType type, String locator) {
        return getElements(type, locator).size() > 0;
    }

    public WebElement waitForElement(By locator, int timeout) {
        try {
            return new WebDriverWait(driver, timeout)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot locate the element");
        }
    }

    public void clickWhenReady(By locator, int timeout) {
        try {
            new WebDriverWait(driver, timeout)
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot locate the element");
        }
    }

    public void generateScreenShot(String destinationDirectory) throws IOException {
        FileUtils.copyFile(
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
                new File(destinationDirectory + "/" + String.valueOf(new Date().getTime()) + ".png"));
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void clickElement(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void performDragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target);

    }

    public void startBrowser(String url) {
        driver.get(url);
    }

    public void closeBrowserAfterDelay(long milliseconds) {
        delay(milliseconds);
        driver.quit();
    }

    public void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    public Actions getActions() {
        return actions;
    }
}
