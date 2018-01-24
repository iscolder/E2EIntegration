package testcases;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.PostGenerator;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

public class TC_010 extends GenericTest {

    protected TC_010(String url) {
        super("http://localhost:3000/posts");
    }

    @Test
    public void testCase() {

        int id = 15;

        //Step 1 - Create new resource
        PostGenerator postGenerator = new PostGenerator();

        postGenerator.setId(id);
        postGenerator.setTitle("Test Title");
        postGenerator.setAuthor("Test Author");

        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .body(postGenerator)
        .when()
                .post(this.url)
        .then()
                .contentType(ContentType.JSON);

        int actualId = response.extract().path("id");
        int statusCode = response.extract().response().getStatusCode();

        Assert.assertEquals(actualId, actualId);
        Assert.assertEquals(statusCode, 201);

        //Step 2 - Validate resource

        ValidatableResponse responseNext =
                when()
                        .get(this.url + "/" + actualId)
                .then()
                        .contentType(ContentType.JSON);

        String actualTitle = responseNext.extract().path("title");
        String actualAuthor = responseNext.extract().path("author");

        Assert.assertEquals(actualTitle, "Test Title");
        Assert.assertEquals(actualAuthor, "Test Author");

        //Step 3 - update resource

        PostGenerator postGenerator1 = new PostGenerator();

        postGenerator1.setId(actualId);
        postGenerator1.setAuthor("Updated Author");
        postGenerator1.setTitle("Updated Title");

        ValidatableResponse validatableResponse =
                given()
                .contentType(ContentType.JSON)
                .body(postGenerator1)
        .when()
                .put(this.url + "/" + actualId)
        .then()
                .contentType(ContentType.JSON);

        String actualTitle1 = validatableResponse.extract().path("title");
        String actualAuthor1 = validatableResponse.extract().path("author");

        Assert.assertEquals(actualTitle1, "Updated Title");
        Assert.assertEquals(actualAuthor1, "Updated Author");


        when()
                .delete(this.url + "/" + actualId)
        .then()
                .statusCode(200);

    }




}
