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

import java.io.IOException;


public class ImplicitExplicitWaitDemo {

    private WebDriver driver;
    private String baseUrl;
    private GenericUtils genericUtils;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        genericUtils = GenericUtils.getInstance(driver);
    }

    @Test
    public void testMouseHoverActions() throws IOException {
        driver.get(baseUrl);
        genericUtils.getElement(LocatorType.XPATH, "//a[contains(text(), 'Login')]").click();

        WebElement emailField = genericUtils.waitForElement(By.id("user_email"), 3);
        emailField.sendKeys("test@test.com");

        genericUtils.clickWhenReady(By.name("commit"), 3);
        genericUtils.generateScreenShot("D:\\e2e\\E2EIntegration\\src\\test\\java\\testcases");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

}
