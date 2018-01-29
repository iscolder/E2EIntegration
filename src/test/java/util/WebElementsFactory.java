package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class WebElementsFactory {

    private static Map<LocatorType, BiFunction<WebDriver, String, WebElement>> findSingleElement = new HashMap<>();
    private static Map<LocatorType, BiFunction<WebDriver, String, List<WebElement>>> findMultipleElements = new HashMap<>();

    static {
        findSingleElement.put(LocatorType.ID, (WebDriver driver, String locator) -> driver.findElement(By.id(locator)));
        findSingleElement.put(LocatorType.XPATH, (WebDriver driver, String locator) -> driver.findElement(By.xpath(locator)));
        findSingleElement.put(LocatorType.LINK_TEXT, (WebDriver driver, String locator) -> driver.findElement(By.linkText(locator)));
        findSingleElement.put(LocatorType.CLASS_NAME, (WebDriver driver, String locator) -> driver.findElement(By.className(locator)));
        findSingleElement.put(LocatorType.CSS_SELECTOR, (WebDriver driver, String locator) -> driver.findElement(By.cssSelector(locator)));
        findSingleElement.put(LocatorType.PARTIAL_LINK_TEXT, (WebDriver driver, String locator) -> driver.findElement(By.partialLinkText(locator)));
        findSingleElement.put(LocatorType.TAG_NAME, (WebDriver driver, String locator) -> driver.findElement(By.tagName(locator)));
        findSingleElement.put(LocatorType.NAME, (WebDriver driver, String locator) -> driver.findElement(By.name(locator)));
    }

    static {
        findMultipleElements.put(LocatorType.ID, (WebDriver driver, String locator) -> driver.findElements(By.id(locator)));
        findMultipleElements.put(LocatorType.XPATH, (WebDriver driver, String locator) -> driver.findElements(By.xpath(locator)));
        findMultipleElements.put(LocatorType.LINK_TEXT, (WebDriver driver, String locator) -> driver.findElements(By.linkText(locator)));
        findMultipleElements.put(LocatorType.CLASS_NAME, (WebDriver driver, String locator) -> driver.findElements(By.className(locator)));
        findMultipleElements.put(LocatorType.CSS_SELECTOR, (WebDriver driver, String locator) -> driver.findElements(By.cssSelector(locator)));
        findMultipleElements.put(LocatorType.PARTIAL_LINK_TEXT, (WebDriver driver, String locator) -> driver.findElements(By.partialLinkText(locator)));
        findMultipleElements.put(LocatorType.TAG_NAME, (WebDriver driver, String locator) -> driver.findElements(By.tagName(locator)));
        findMultipleElements.put(LocatorType.NAME, (WebDriver driver, String locator) -> driver.findElements(By.name(locator)));
    }

    public static Map<LocatorType, BiFunction<WebDriver, String, WebElement>> getSingle() {
        return findSingleElement;
    }

    public static Map<LocatorType, BiFunction<WebDriver, String, List<WebElement>>> getMultiple() {
        return findMultipleElements;
    }

}
