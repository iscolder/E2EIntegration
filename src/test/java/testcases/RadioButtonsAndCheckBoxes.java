package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsAndCheckBoxes {


    WebDriver driver;

    String baseUrl = "https://letskodeit.teachable.com/p/practice/";

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {



        WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
        bmwRadioBtn.click();

        Thread.sleep(2000);

        WebElement benzradioRadioBtn = driver.findElement(By.id("benzradio"));
        benzradioRadioBtn.click();

        Thread.sleep(2000);

        WebElement bmwcheckbox = driver.findElement(By.id("bmwcheck"));
        bmwcheckbox.click();

        WebElement benzcheckbox = driver.findElement(By.id("benzcheck"));
        benzcheckbox.click();


        System.out.println(bmwRadioBtn.isSelected());


    }

    @Test
    public void test2() {

        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@name='cars' and @type='radio']"));

        radioBtns.stream().forEach(radio -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!radio.isSelected())
                radio.click();
        });




    }


    @AfterMethod
    public void after() throws InterruptedException {


        Thread.sleep(2000);
        driver.quit();
    }



}
