import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SanityTest {
    private static Response response;

    @BeforeAll
    public static void setup() {
        response = given().get(Consts.URL);
    }

    // Positive tests
    @Test
    public void responseCodeTest() {
  //      response = given().get(Consts.URL);
        response.then().statusCode(200);
    }

    // Negative tests
    @Test
    public void emptyEndPointTest() {
 //       response = given().get(Consts.URL);
        response.then().body("message", equalTo("Bored API"));
        System.out.println(response.asString());
    }

    @Test
    public void incorrecEndPointTest() {
        response = given().get(Consts.URL + "yjhjkh");
        response.then().body("error", equalTo("Endpoint not found"));
        System.out.println(response.asString());
    }
}