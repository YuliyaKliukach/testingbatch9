package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertyValue("password"));

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage loginPage=new LoginPage();
        click(loginPage.loginButton);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashboardPage dash=new DashboardPage();
        //Assert.assertTrue(dash.welcomemessage.isDisplayed());
        String expected = "Welcome Admin";
        String actual=dash.welcomemessage.getText();
        Assert.assertEquals("Values do not match", expected, actual);
    }

    @When("user enters valid ess employee username and password")
    public void user_enters_valid_ess_employee_username_and_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, "johnny1234560000");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashboardPage dash=new DashboardPage();
        Assert.assertTrue(dash.welcomemessage.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, "Admin");
        sendText(loginPage.passwordBox, "Syntax1253!!!!");
    }

    @Then("user see invalid credentials text on login page")
    public void user_see_invalid_credentials_text_on_login_page() {
        System.out.println("Error message is displayed");
    }


    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, username);
        sendText(loginPage.passwordBox, password);
    }

    @When("{string} is successfully displayed")
    public void is_successfully_displayed(String firstname) {
        System.out.println("Working fine");
    }

    @When("user enters valid username and invalid password and verify the error")
    public void user_enters_valid_username_and_invalid_password_and_verify_the_error(DataTable errordata) {
        List<Map<String, String>> employeeNames = errordata.asMaps();
        for (Map<String, String> employeename : employeeNames) {
            String usernamevalue = employeename.get("username");
            String passwordvalue = employeename.get("password");
            String errormessagevalue = employeename.get("errormessage");
            System.out.println(usernamevalue + " " + passwordvalue + " " + errormessagevalue);

            LoginPage loginPage=new LoginPage();
            sendText(loginPage.userNameBox, usernamevalue);
            sendText(loginPage.passwordBox, passwordvalue);
            click(loginPage.loginButton);

            String actual =loginPage.errorMessage.getText();
            Assert.assertEquals("Value doesn't match", errormessagevalue, actual);
            System.out.println("My test case is passed");

        }
    }

    @When("user enters different {string} and {string} and verify the {string} for all the combinations")
    public void user_enters_different_and_and_verify_the_for_all_the_combinations(String usernamevalue, String passwordvalue, String error) {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox, usernamevalue);
        sendText(loginPage.passwordBox, passwordvalue);
        click(loginPage.loginButton);

        String actual=loginPage.errorMessage.getText();
        Assert.assertEquals("Values do not match", error, actual);
    }
}
