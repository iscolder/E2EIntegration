package testcases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.GenericUtils;
import util.LocatorType;

public class SearchPage {

    public static WebElement element = null;

    private GenericUtils gu;

    public SearchPage(WebDriver driver, String baseUrl) {
        gu = GenericUtils.getInstance(driver);
        gu.startBrowser(baseUrl);
    }

    public WebElement originTextBox(String value) {
        element = gu.getElement(LocatorType.ID, "package-origin-hp-package");
        element.sendKeys(value);
        return element;
    }

    public WebElement destinationTextBox(String value) {
        element = gu.getElement(LocatorType.ID, "package-destination-hp-package");
        element.sendKeys(value);
        return element;
    }

    public WebElement departureDateTextBox(String value) {
        element = gu.getElement(LocatorType.ID, "package-departing-hp-package");
        element.sendKeys(value);
        return element;
    }

    public WebElement returnDateTextBox(String value) {
        element = gu.getElement(LocatorType.ID, "package-returning-hp-package");
        element.sendKeys(value);
        return element;
    }

    public WebElement searchButton() {
        element = gu.getElement(LocatorType.ID, "search-button-hp-package");
        return element;
    }

    public void clickOnSearchButton() {
        element = searchButton();
        element.click();
    }

    public void navigateToFlightsTab() {
        //gu.getElement(LocatorType.ID, "header-history").click();
        element = gu.getElement(LocatorType.ID, "tab-flight-tab");
        element.click();
    }

    public void closeBrowser(long milliseconds) {
        gu.closeBrowserAfterDelay(milliseconds);
    }

    public void delay(long milliseconds) {
        gu.delay(milliseconds);
    }

}
