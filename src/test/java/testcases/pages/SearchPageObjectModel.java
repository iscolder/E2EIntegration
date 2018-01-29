package testcases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchPageObjectModel {
    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        searchPage = new SearchPage(driver, "https://www.expedia.com/");
        searchPage.originTextBox("New York");
        searchPage.destinationTextBox("Chicago");
        searchPage.departureDateTextBox("12/12/2018");
        searchPage.returnDateTextBox("12/23/2018");
        searchPage.clickOnSearchButton();
    }

    @AfterMethod
    public void tearDown() {
        searchPage.closeBrowser(4000);
    }


}
