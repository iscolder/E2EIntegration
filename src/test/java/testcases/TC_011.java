package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_011 {


    private WebDriver webDriver;

    private String baseUrl;


    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        webDriver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/";
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCase1() {
        webDriver.get(baseUrl);
        webDriver.findElement(By.xpath("//*[@id=\"navbar\"]//a[@href='/sign_in']")).click();
        System.out.println("Clicked on login");

        System.out.println("Sending keys to username field");
        WebElement email = webDriver.findElement(By.id("user_email"));
        email.clear();
        email.sendKeys("test@email.com");

        System.out.println("Sending keys to password field");
        WebElement password = webDriver.findElement(By.id("user_password"));
        password.clear();
        password.sendKeys("test");
    }

    @Test
    public void testCase2() {

    }


    @AfterMethod
    public void after() {
        //webDriver.quit();
    }



}
