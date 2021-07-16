package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*; //manually ONLY added
import static org.hamcrest.Matchers.*;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExample {
/*
    Given - Preparing the request

    When - making the request/the call
 */

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjYzOTE5NjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjQzNTE2MywidXNlcklkIjoiMjg4OSJ9.XYBrJAEwoya2_w60auf2jz0a_X7cqmMeWlRR0C1-G2Y";
    static String employee_id;

    // @Test
    public void sampleTest() {
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", "14024");

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        /*
        Printing response using asString() method to convert JSON object to String and printing using sout
         */
        System.out.println(response.asString());
    }

    @Test
    public void aPostCreateEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"emp_firstname\": \"Elena\",\n" +
                        "  \"emp_lastname\": \"K\",\n" +
                        "  \"emp_middle_name\": \"I\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1987-03-20\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"Developer\"\n" +
                        "}");//.log().all();

        /*
        log().all() will log and print all information being sent with the request
         */
        Response response=preparedRequest.when().post("/createEmployee.php");
        /*
        same as sout asString() in previous method
         */
       // response.prettyPrint();

        /**
         * jsonPat() allows us to retrieve specific data from a json object - just like an xpath in selenium
         */
        employee_id=response.jsonPath().getString("Employee.employee_id");
       // System.out.println(employee_id);

        /**
         * performing assertion
         */
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Elena"));

        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bGetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employee_id);

        Response response=preparedRequest.when().get("/getOneEmployee.php");
       // response.prettyPrint();

        String empID=response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpIDs=empID.contentEquals(employee_id);

        Assert.assertTrue(comparingEmpIDs);

        String firstName=response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstName.contentEquals("Elena"));

    }

    @Test
    public void cGetAllEmployees(){
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json");

        Response response=preparedRequest.when().get("/getAllEmployees.php");
        response.prettyPrint();

        JsonPath js=new JsonPath(response.asString());

        int count = js.getInt("Employees.size()");
        System.out.println(count);

        for (int i = 0; i < count; i++) {
            String employeeIDs=js.getString("Employees["+i+"].employee_id");
           // System.out.println(employeeIDs);

            if(employeeIDs.contentEquals(employee_id)){
                System.out.println("Employee ID "+employee_id+" is present in response body");

                String employeesNames=js.getString("Employees["+i+"].emp_firstname");
                System.out.println("Employee name is "+employeesNames);
                break;
            }
        }

    }
}
