package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*; //manually ONLY added

public class HardCodedExample {
/*
    Given - Preparing the request

    When - making the request/the call
 */

    @Test
    public void sampleTest(){
        String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
        RequestSpecification preparedRequest=given().header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjYzMDUwODgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjM0ODI4OCwidXNlcklkIjoiMjg4OSJ9.Q0Maq6kkaPZHoIhrGwdnbaXbwyb0YaD25IAXedwrkSQ")
                .header("Content-Type", "application/json")
                .queryParam("employee_id", "14024");

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        System.out.println(response.asString());
    }
}
