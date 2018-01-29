package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.GenericUtils;
import util.LocatorType;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindowAndIFrame {

    private WebDriver driver;
    private String baseUrl;
    private GenericUtils genericUtils;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice/";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        genericUtils = GenericUtils.getInstance(driver);
        driver.get(baseUrl);

    }

    @Test
    public void test() throws InterruptedException {

        //Get the handle

        String parentHandle = driver.getWindowHandle();

        // find open window button
        WebElement openWindow = genericUtils.getElement(LocatorType.ID, "openwindow");
        openWindow.click();

        //Get all handles
        Set<String> handles = driver.getWindowHandles();

        handles.stream().filter(s -> !s.equals(parentHandle)).findFirst().ifPresent(s ->
                {
                    driver.switchTo().window(s);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("TITLE: " + driver.getTitle());
                    WebElement searchBox = genericUtils.getElement(LocatorType.ID, "search-courses");
                    searchBox.sendKeys("python");
                    driver.close();
                }
        );

        driver.switchTo().window(parentHandle);

        Thread.sleep(2000);

        genericUtils.getElement(LocatorType.ID, "bmwradio").click();


    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(2000);

        driver.switchTo().frame("courses-iframe");
        //driver.switchTo().frame("iframe-name");

        WebElement element = genericUtils.getElement(LocatorType.ID, "search-courses");
        element.sendKeys("python");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        Thread.sleep(2000);

        genericUtils.getElement(LocatorType.ID, "bmwradio").click();


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        genericUtils.closeBrowserAfterDelay(2000);
    }


}
