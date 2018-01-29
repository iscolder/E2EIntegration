package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown {

    private WebDriver driver;
    private String baseUrl = "https://letskodeit.teachable.com/p/practice/";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseUrl);
    }

    @Test
    public void test() {

        Select dropdown = new Select(driver.findElement(By.id("carselect")));

        dropdown.selectByValue("honda");


        Select multipleDropdown = new Select(driver.findElement(By.id("multiple-select-example")));

        multipleDropdown.selectByValue("apple");
        multipleDropdown.selectByValue("orange");


        multipleDropdown.getOptions().stream().filter(webElement -> webElement.isSelected()).forEach(webElement -> {
            System.out.println(webElement.getText());
        });



    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



}
