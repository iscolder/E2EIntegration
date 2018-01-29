package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.GenericUtils;
import util.LocatorType;

import java.util.concurrent.TimeUnit;

public class SwitchAlert {

    private WebDriver driver;
    private String baseUrl = "https://letskodeit.teachable.com/p/practice/";
    private GenericUtils genericUtils;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        genericUtils = GenericUtils.getInstance(driver);
        driver.get(baseUrl);
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
        genericUtils.getElement(LocatorType.ID, "name").sendKeys("Kostya");
        genericUtils.getElement(LocatorType.ID, "alertbtn").click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(1000);
        genericUtils.getElement(LocatorType.ID, "name").sendKeys("Kostya");
        genericUtils.getElement(LocatorType.ID, "confirmbtn").click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
