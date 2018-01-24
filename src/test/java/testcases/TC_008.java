package testcases;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import util.PostGenerator;


import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.post;

public class TC_008 extends GenericTest {


    protected TC_008(String url) {
        super("http://localhost:3000/posts");
    }

    @Test
    public void testCasePutRequest() {

        int id = 1;

        PostGenerator postGenerator = new PostGenerator();
        postGenerator.setId(id);
        postGenerator.setTitle("test 2");
        postGenerator.setAuthor("Updated Author");


        given()
                .contentType(ContentType.JSON)
                .body(postGenerator)
        .when()
                .put(this.url + "/" + id)
        .then()
                .contentType(ContentType.JSON)
                .statusCode(200);

    }

    @Test
    public void testCasePatchRequest() {

        int id = 4;
        PostGenerator postGenerator = new PostGenerator();
        postGenerator.setTitle("Updated Title");

        given()
                .contentType(ContentType.JSON)
                .body(postGenerator)
        .when()
                .patch(url + "/" + id)
        .then()
                .contentType(ContentType.JSON)
                .statusCode(200);

    }

    @Test
    public void testCaseDeleteRequest() {
        int id = 4;

        PostGenerator postGenerator = new PostGenerator();
        postGenerator.setId(id);
        postGenerator.setTitle("ABCD");
        postGenerator.setAuthor("Author 1");

        Response response = post(this.url);

        if (response.statusCode() == 201) {
            given()
                    .contentType(ContentType.JSON)
            .when()
                    .delete(url + "/" + id)
            .then()
                    .statusCode(200);
        }



    }



}
