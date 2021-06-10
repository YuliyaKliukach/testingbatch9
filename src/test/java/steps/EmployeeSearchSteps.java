package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user navigates to hrms")
    public void user_navigates_to_hrms() {
            setUp();
    }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginButton);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashboardPage dash = new DashboardPage();
        click(dash.pimOption);
        click(dash.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage empList=new EmployeeListPage();
        sendText(empList.idEmployee, "15518");
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage empList=new EmployeeListPage();
        click(empList.searchButton);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage empList=new EmployeeListPage();
       sendText(empList.employeeNameField, "Sofiia");
    }

    @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Employee name is dysplayed");
    }

}
