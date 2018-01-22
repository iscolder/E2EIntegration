package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_003 {


    private WebDriver webDriver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void testCase() {
        webDriver.get("http://www.facebook.com");
        webDriver.findElement(By.id("email")).sendKeys("Hello");
        webDriver.findElement(By.id("pass")).sendKeys("Hello");
    }


    @AfterMethod
    public void after() {
        webDriver.quit();
    }



}
