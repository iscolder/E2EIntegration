package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.GenericUtils;
import util.LocatorType;

import java.util.concurrent.TimeUnit;

public class MouseActions {

    private WebDriver driver;
    private String baseUrl = "https://letskodeit.teachable.com/pages/practice";
    private GenericUtils genericUtils;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        genericUtils = GenericUtils.getInstance(driver);

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(2000);

        WebElement mouseHover = genericUtils.getElement(LocatorType.ID, "mousehover");
        genericUtils.moveToElement(mouseHover);

        Thread.sleep(2000);

        WebElement subElement = genericUtils.getElement(LocatorType.XPATH, "//div[@class='mouse-hover']//a[text()='Top']");
        genericUtils.clickElement(subElement);

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        WebElement fromElement = genericUtils.getElement(LocatorType.ID, "draggable");
        WebElement toElement = genericUtils.getElement(LocatorType.ID, "droppable");

        //genericUtils.performDragAndDrop(fromElement, toElement);

        Actions actions = new Actions(driver);

        actions.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();


        Thread.sleep(2000);


    }


    @Test
    public void test3() throws InterruptedException {
        driver.get("https://jqueryui.com/slider/");
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        WebElement slider = genericUtils.getElement(LocatorType.XPATH, "//*[@id=\"slider\"]/span");

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(50, 0).build().perform();


        driver.switchTo().defaultContent();


    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
