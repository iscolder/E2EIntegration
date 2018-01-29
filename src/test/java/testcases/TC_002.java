package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcases.data.TestData;

public class TC_002 {


    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test(groups = {"google"})
    public void testCase() {
        webDriver.get("http://www.facebook.com");

        webDriver.findElement(By.id("email")).sendKeys("Hello");
        webDriver.findElement(By.id("pass")).sendKeys("Hello");



    }

    @Test(dataProvider = "inputs", dataProviderClass = TestData.class)
    public void test2(String input1, String input2) {
        System.out.println(input1);
        System.out.println(input2);

    }

//    @DataProvider(name = "inputs")
//    public Object[][] getData() {
//        return new Object[][]{
//                {"bmw", "m3"},
//                {"audi", "a6"},
//                {"benz", "c300"}
//        };
//    }


    @AfterMethod(alwaysRun = true)
    public void after() {
        webDriver.quit();
    }



}
