package grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSuiteBase {

    protected WebDriver driver;
    protected SearchPageFactory search;

    /*
    *
    *  {
    *       "capabilities" : [
    *           {
    *               "browserName": "chrome",
    *               "maxInstances": 1
    *           },
    *           {
    *               "browserName": "firefox",
    *               "maxInstances": 1
     *          }
    *       ],
    *       "configuration" : {
    *           "port": 5555,
    *           "hubPort": 4444,
    *           "hubHost": "",
    *           "registerCycle": 10000,
    *           "timeout": 30000,
    *           "maxSession": 1
    *       }
    *  }
    *
    * */
    @Parameters({"platform", "browser", "version", "url"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String platform, String browser, String version, String url) throws MalformedURLException {
        driver = getDriverInstance(platform, browser, version, url);
        search = PageFactory.initElements(driver, SearchPageFactory.class);
    }

    private static WebDriver getDriverInstance(String platform, String browser, String version, String url) throws MalformedURLException {
        String nodeURL = "http://192.168.1.2:5555/wd/hub";
        WebDriver driver = null;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            desiredCapabilities = DesiredCapabilities.chrome();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            desiredCapabilities = DesiredCapabilities.firefox();
        }

        if (platform.equalsIgnoreCase("Windows")) {
            desiredCapabilities.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            desiredCapabilities.setPlatform(Platform.MAC);
        }

        desiredCapabilities.setVersion(version);
        driver = new RemoteWebDriver(new URL(nodeURL), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        return driver;
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }

}
