package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeserializerServiceTest {

    private static final String BASE_URL = "http://localhost:8080";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testDevowelizerService() {
        String input = "hello world";
        String expectedOutput = "hll wrld";

        Response response = given()
                .when()
                .get("/" + input)
                .then()
                .statusCode(200)
                .extract().response();

        String actualOutput = response.getBody().asString();

        System.out.println("Response from API: " + actualOutput);
        System.out.println("Status code is: " + response.statusCode());

        assertThat(actualOutput, equalTo(expectedOutput));
    }
}
