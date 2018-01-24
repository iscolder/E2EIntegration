package testcases;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.PostGenerator;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class TC_007 {

    @BeforeMethod
    public void before() {

    }

    @Test
    public void testCasePostRequest() {

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"id\": 4,\n" +
                        "\"title\": \"test 2\",\n" +
                        "\"author\": \"test 2\"\n" +
                        "}")
        .when()
                .post("http://localhost:3000/posts")

        .then()
                .statusCode(201)
                .contentType(ContentType.JSON);
    }


    @Test
    public void testCasePostWithJsonObject() {
        PostGenerator postGenerator = new PostGenerator();
        postGenerator.setId(5);
        postGenerator.setTitle("ABCD");
        postGenerator.setAuthor("Author 1");

        given()
                .contentType(ContentType.JSON)
                .body(postGenerator)
        .when()
                .post("http://localhost:3000/posts")
        .then()
                .contentType(ContentType.JSON)
                .statusCode(201);

    }




    @AfterMethod
    public void after() {

    }


}
