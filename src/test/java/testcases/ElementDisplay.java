package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ElementDisplay {

    private WebDriver driver;
    private String baseUrl = "https://letskodeit.teachable.com/p/practice/";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        Assert.assertEquals(true, textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));

        hideButton.click();

        Assert.assertEquals(true, !textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();

        Assert.assertEquals(true, textBox.isDisplayed());



    }

    @Test(priority = 1)
    public void test2() {
        baseUrl = "https://www.expedia.com/";
        driver.get(baseUrl);


        WebElement childDropdown = driver.findElement(By.id(""));


    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



}
