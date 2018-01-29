package reporting.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {


    private WebDriver driver;
    private String baseUrl;
    private ExtentReports report;
    private ExtentTest test;
    private HomePage homePage;


    @BeforeMethod
    public void setUp() {

        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Welcome Text");
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();

        homePage = new HomePage(driver, test);
        test.log(LogStatus.INFO, "Browser Started");


        baseUrl = "http://www.letskodeit.com/";


        driver.manage().window().maximize();

        test.log(LogStatus.INFO, "Browser Maximized");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        test.log(LogStatus.INFO, "Web application opened");
    }


    @Test
    public void test1_validLoginTest() throws InterruptedException {


        homePage.login("test@email.com", "abcabc1");

        Thread.sleep(3000);

        Assert.assertTrue(homePage.isWelcomeTextPresent());

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
