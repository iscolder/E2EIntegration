package testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class GenericTest {

    protected String url;

    protected GenericTest(String url) {
        this.url = url;
    }

    @BeforeMethod
    public void before() {

    }

    @AfterMethod
    public void after() {

    }




}
