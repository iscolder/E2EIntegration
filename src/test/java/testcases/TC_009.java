package testcases;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.when;

public class TC_009 extends GenericTest {

    protected TC_009(String url) {
        super("http://localhost:3000/posts");
    }

    @Test
    public void testCaseValidateJsonResponse() {

        String actualAuthor =

                when()
                        .get(url + "/" + 1)
                .then()
                        .contentType(ContentType.JSON)
                        .extract()
                        .path("author");

        Assert.assertEquals(actualAuthor, "Updated Author");

    }

    @Test
    public void testCaseValidateJsonResponse_2() {

        ValidatableResponse response =

                when()
                        .get(url + "/" + 1)
                        .then()
                        .contentType(ContentType.JSON);

        String title = response.extract().path("title");
        String author = response.extract().path("author");
        int id = response.extract().path("id");

        Assert.assertEquals(author, "Updated Author");
        Assert.assertEquals(id, 1);
        Assert.assertEquals(title, "test 2");


    }


}
