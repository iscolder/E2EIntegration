package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigatingBetweenPages {


    private WebDriver webDriver;

    private String baseUrl = "https://letskodeit.teachable.com/";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testCase1() throws InterruptedException {
        webDriver.get(baseUrl);
        String title = webDriver.getTitle();
        System.out.println("Title of the page is" + title);

        String currentUrl = webDriver.getCurrentUrl();

        Assert.assertEquals(currentUrl, baseUrl);

        System.out.println("Current URL is " + currentUrl);


        String navigateUrl = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";

        webDriver.navigate().to(navigateUrl);

        Thread.sleep(2000);

        webDriver.navigate().back();

        Thread.sleep(2000);

        webDriver.navigate().forward();

        Assert.assertEquals(webDriver.getCurrentUrl(), navigateUrl);

        Thread.sleep(2000);

        webDriver.navigate().refresh();

        Assert.assertEquals(webDriver.getCurrentUrl(), navigateUrl);

        System.out.println(webDriver.getPageSource());


    }


    @AfterMethod
    public void after() {
        webDriver.quit();
    }


}
