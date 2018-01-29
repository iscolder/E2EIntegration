package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.GenericUtils;
import util.LocatorType;

import java.util.concurrent.TimeUnit;

public class JavascriptExecution {

    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;
    private GenericUtils genericUtils;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        baseUrl = "https://letskodeit.teachable.com/pages/practice";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        genericUtils = GenericUtils.getInstance(driver);
    }

    @Test
    public void testJavascriptExecution() throws InterruptedException {
        //driver.get(baseUrl);
        js.executeScript("window.location='" + baseUrl + "';");
        WebElement textBox = genericUtils.getElement(LocatorType.ID, "name");
        textBox.sendKeys("test");
    }

    @Test
    public void testJavascriptExecution2() throws InterruptedException {
        //driver.get(baseUrl);
        js.executeScript("window.location='" + baseUrl + "';");

        long height = (long) js.executeScript("return window.innerHeight;");
        long width = (long) js.executeScript("return window.innerWidth;");

        System.out.println("Height is " + height);
        System.out.println("Width is " + width);


    }

    @Test
    public void testJavascriptExecution3() throws InterruptedException {
        //driver.get(baseUrl);
        js.executeScript("window.location='" + baseUrl + "';");
        Thread.sleep(2000);


        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);


        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        WebElement mouseOver = genericUtils.getElement(LocatorType.ID, "mousehover");
        js.executeScript("arguments[0].scrollIntoView(true);", mouseOver);

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");
    }

    @Test
    public void test4() {

        driver.get(baseUrl);
        js.executeScript("arguments[0].click();", genericUtils.getElement(LocatorType.ID, "bmwcheck"));


    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://www.retailmenot.com/");
        genericUtils.getElement(LocatorType.XPATH, "//*[@id=\"top\"]//div[contains(text(), 'Log In')]").click();
        //GenericUtils.getElement(driver, LocatorType.XPATH, "//label[@for='subscribe']").click();
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", genericUtils.getElement(LocatorType.XPATH, "//label[@for='subscribe']"));

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
