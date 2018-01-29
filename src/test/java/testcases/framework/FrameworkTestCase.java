package testcases.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameworkTestCase {

    private WebDriver driver;
    private SearchPageFactory searchPageFactory;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPageFactory = new SearchPageFactory(driver, "https://www.expedia.com/");
    }

    @Test
    public void test() {
        searchPageFactory.clickFlightsTab();
        searchPageFactory.setOriginCity("New York");
        searchPageFactory.setDestinationCity("Chicago");
        searchPageFactory.setDepartureDate("10/28/2018");
        searchPageFactory.setReturningDate("11/31/2018");
        searchPageFactory.clickSearchButton();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        searchPageFactory.closeBrowserAfterDelay(3000);
    }
}
