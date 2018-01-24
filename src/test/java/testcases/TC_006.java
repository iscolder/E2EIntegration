package testcases;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class TC_006 {

    @BeforeMethod
    public void before() {

    }

    @Test
    public void testCase() {
        Response response = get("http://services.groupkt.com/country/get/iso2code/IN");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getContentType(), "application/json;charset=UTF-8");
    }

    @Test
    public void testCase2() {
        given()
                .param("userId", "1")
        .when().get("https://jsonplaceholder.typicode.com/posts")
        .then().statusCode(200);
    }


    @AfterMethod
    public void after() {

    }


}
