package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TC_001 {

    //Firefox driver
    private WebDriver webDriver;

    @BeforeClass
    @Parameters({"browser", "platform"})
    public void setUp(String browser, String platform) {
        System.out.println("Browser is: " + browser);
        System.out.println("Platform is: " + platform);

        Reporter.log("Platform is " + platform, false);

    }


    @BeforeMethod(alwaysRun = true)
    public void before() {
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        webDriver = new FirefoxDriver();

        webDriver = new FirefoxDriver(GeckoDriverService.createDefaultService(), new FirefoxOptions());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(groups = {"google"})
    @Parameters({"response"})
    public void testCase(String response) {
//        webDriver.get("http://www.facebook.com");
//        webDriver.findElement(By.id("email")).sendKeys("Hello");
//        webDriver.findElement(By.id("pass")).sendKeys("Hello");

        System.out.println("Response is " + response);

        webDriver.get("http://www.google.com");
        webDriver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[3]/center/input[1]")).click();
        webDriver.findElement(By.xpath("/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/h3/a")).click();




    }
    @Test(groups = "google")
    public void testCase2() throws InterruptedException {

        webDriver.get("http://www.google.com");
        webDriver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
        webDriver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[3]/center/input[1]")).click();
        webDriver.findElement(By.linkText("Lets Kode it")).click();



    }

    @Test
    public void testCase3() throws InterruptedException {

        String baseUrl = "http://demostore.x-cart.com/";


        webDriver.get(baseUrl);

        webDriver.findElement(By.className("title")).click();

        Thread.sleep(3000);


    }


    @AfterMethod(alwaysRun = true)
    public void after() {
        webDriver.quit();
    }



}
