package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import utils.CommonMethods;
import utils.apiConstants;

public class GenerateTokenSteps extends CommonMethods {

    static String token;

    @Given("a token is generated")
    public void a_token_is_generated() {
        RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"yuliya1@gmail.com\",\n" +
                        "  \"password\": \"Synatx123!\"\n" +
                        "}");

        Response generateTokenResponse = generateTokenRequest.when().post(apiConstants.GENERATE_TOKEN_URI);
        generateTokenResponse.prettyPrint();

        token="Bearer "+generateTokenResponse.jsonPath().getString("token");
    }
}
