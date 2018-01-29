package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.GenericUtils;
import util.LocatorType;

import java.util.concurrent.TimeUnit;

public class KeyPressEvents {

    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;
    private GenericUtils genericUtils;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        baseUrl = "https://letskodeit.teachable.com/p/practice";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        genericUtils = GenericUtils.getInstance(driver);
    }


    @Test
    public void test() {
        genericUtils.startBrowser(baseUrl);
        genericUtils.getElement(LocatorType.XPATH, "//div[@id=\"navbar\"]//a[@href='/sign_in' and contains(text(), 'Login')]").click();

        genericUtils.getElement(LocatorType.ID, "user_email").sendKeys("test@email.com");
        genericUtils.delay(2000);

        genericUtils.getElement(LocatorType.ID, "user_email").sendKeys(Keys.TAB);
        genericUtils.delay(1000);

        genericUtils.getElement(LocatorType.ID, "user_password").sendKeys("112321");
        genericUtils.delay(2000);

        genericUtils.getElement(LocatorType.NAME, "commit").sendKeys(Keys.ENTER);

    }

    @Test
    public void test2() {
        genericUtils.startBrowser(baseUrl);
        genericUtils.getElement(LocatorType.ID, "openwindow").sendKeys(Keys.CONTROL + "a");
        genericUtils.delay(2000);

        genericUtils.getElement(LocatorType.ID, "openwindow").sendKeys(Keys.chord(Keys.CONTROL, "a"));

    }

    @Test
    public void test3() {
        genericUtils.startBrowser(baseUrl);
        genericUtils.delay(2000);

        genericUtils.getActions().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    }


    @AfterMethod
    public void tearDown() {
        genericUtils.delay(3000);
        driver.quit();
    }

}
