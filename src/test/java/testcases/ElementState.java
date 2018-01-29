package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.GenericUtils;
import util.LocatorType;

import java.util.concurrent.TimeUnit;

public class ElementState {

    WebDriver driver;
    String baseUrl = "http://www.google.com";
    GenericUtils genericUtils;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        genericUtils = GenericUtils.getInstance(driver);
    }

    @Test
    public void test() throws InterruptedException {

        driver.get(baseUrl);

        WebElement webElement1 = driver.findElement(By.id("lst-ib"));
        System.out.println("Element is enabled?: " + webElement1.isEnabled());

        WebElement webElement2 = driver.findElement(By.id("gs_taif0"));
        System.out.println("Element is enabled?: " + webElement2.isEnabled());


        WebElement webElement3 = driver.findElement(By.id("gs_htif0"));
        System.out.println("Element is enabled?: " + webElement3.isEnabled());

        webElement1.sendKeys("letskodeit");

        Thread.sleep(5000);
    }

    @Test
    public void test2() {
        driver.get(baseUrl);
        WebElement webElement = genericUtils.getElement(LocatorType.ID,"lst-ib");
        webElement.sendKeys("something");

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }



}
