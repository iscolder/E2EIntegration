package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageFactory {

    private WebDriver driver;

    @FindBy(id = "tab-flight-tab-hp")
    WebElement flightsTab;

    @FindBy(id = "flight-origin-hp-flight")
    WebElement originCity;

    @FindBy(id = "flight-destination-hp-flight")
    WebElement destinationCity;

    @FindBy(id = "flight-departing-hp-flight")
    WebElement departureDate;

    @FindBy(id = "flight-returning-hp-flight")
    WebElement returningDate;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]//span[text()='Search']/parent::button")
    WebElement searchButton;

    public SearchPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFlightsTab() {
        flightsTab.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void setOriginCity(String origin) {
        originCity.sendKeys(origin);
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity.sendKeys(destinationCity);
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate.sendKeys(departureDate);
    }

    public void setReturningDate(String returningDate) {
        this.returningDate.sendKeys(returningDate);
    }

}
