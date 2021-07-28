import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ActivityPatricipantsTest {
    private static Response response;


    // Positive tests

    @Test
    public void ActivityFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS);
        response.then().body("activity", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void typeFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS);
        response.then().body("type", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void participantsFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS);
        response.then().body("participants", equalTo(1));
        System.out.println(response.asString());

    }

    @Test
    public void priceFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS);
        response.then().body("price", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void keyFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS);
        response.then().body("key", notNullValue());
        System.out.println(response.asString());
    }

    @Test
    public void accessibilityFieldTest() {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS);
        response.then().body("accessibility", notNullValue());
        System.out.println(response.asString());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5 ,6, Integer.MAX_VALUE})
    public void ParticipantsTests(int number) {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS + number);
        response.then().body("participants", equalTo(number));
        System.out.println(response.asString());
    }

// Negative tests

    @ParameterizedTest
    @ValueSource(ints = {0,-3,-10,-100})
    public void incorrectParticipantsNumbersTests(int number) {
        response = given().get(Consts.URL + Consts.ACTIVITY_PARTICIPANTS + number);
        response.then().body("error", equalTo("No activity found with the specified parameters"));
        System.out.println(response.asString());
    }

}

