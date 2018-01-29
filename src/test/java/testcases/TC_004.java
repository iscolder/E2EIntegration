package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TC_004 {


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
    @Test
    public void testCase2() {
        fail("Fail");
    }



    @AfterMethod
    public void after(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Success method:  " + testResult.getMethod().getMethodName());
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failure method:  " + testResult.getName());
        }

        webDriver.quit();
    }



}
