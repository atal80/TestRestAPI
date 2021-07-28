import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ActivityTypeTest {
    private static Response response;

    //Positive tests
    @Test
    public void activityFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE);
        response.then().body("activity", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void participantsFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE);
        response.then().body("participants", equalTo(1));
        System.out.println(response.asString());

    }

    @Test
    public void priceFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE);
        response.then().body("price", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void keyFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE);
        response.then().body("key", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void accessibilityFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE);
        response.then().body("accessibility", notNullValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music", "busywork"})
    public void getTypeActivityTests(String type) {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE + type);
        response.then().body("type", equalTo(type));
        System.out.println(response.asString());
    }

    // Negative tests

    @Test
    public void incorrectActivityTypeTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_TYPE + "chillout");
        response.then().body("error", equalTo("No activity found with the specified parameters"));
        System.out.println(response.asString());
    }
}