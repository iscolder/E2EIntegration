package reporting.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumLoginTest {


    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;
    private ExtentReports report;
    private ExtentTest test;


    @BeforeMethod
    public void setUp() {

        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Welcome Text");
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();


        test.log(LogStatus.INFO, "Browser Started");


        baseUrl = "http://www.letskodeit.com/";
        js = (JavascriptExecutor) driver;




        driver.manage().window().maximize();

        test.log(LogStatus.INFO, "Browser Maximized");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        test.log(LogStatus.INFO, "Web application opened");
    }


    @Test
    public void test1_validLoginTest() throws InterruptedException {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();

        test.log(LogStatus.INFO, "Clicked on Signup Link");

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();

        test.log(LogStatus.INFO, "Clicked on login link");

        WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
        emailField.sendKeys("test@email.com");

        test.log(LogStatus.INFO, "Entered email");

        WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
        passwordField.sendKeys("abcabc");

        test.log(LogStatus.INFO, "Entered password");



        //WebElement goButton = driver.findElement(By.id("memberLoginDialogsubmitButton"));
        WebElement goButton = driver.findElement(By.xpath("//*[@id=\"memberLoginDialogokButton\"]"));

        goButton.click();

        test.log(LogStatus.INFO, "Clicked Go Button");

        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);

        test.log(LogStatus.PASS, "Verified Welcome Text");
    }

    @AfterMethod
    public void cleanUp(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.takeScreenshot(driver, result.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }

        driver.quit();

        report.endTest(test);

        report.flush();
        report.close();
    }

}
