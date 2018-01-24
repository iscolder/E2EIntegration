package testcases;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_006 {

    @BeforeMethod
    public void before() {

    }

    @Test
    public void testCase() {
        Response response =  RestAssured.get("http://services.groupkt.com/country/get/iso2code/IN");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getContentType(), "application/json;charset=UTF-8");
    }

    @AfterMethod
    public void after() {

    }


}
