package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashboardPage dash = new DashboardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        DashboardPage dash = new DashboardPage();
        click(dash.addEmployee);
    }

    @When("user enters first name, middle name and lastname")
    public void user_enters_first_name_middle_name_and_lastname() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, "Yuliya555");
        sendText(add.middleName, "Mulia");
        sendText(add.lastName, "Klukach2003");
    }

    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters firstname {string} middle name as {string} and last name {string}")
    public void user_enters_firstname_middle_name_as_and_last_name(String firstName, String middleName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstName);
        sendText(add.middleName, middleName);
        sendText(add.lastName, lastName);
    }

    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, FirstName);
        sendText(add.middleName, MiddleName);
        sendText(add.lastName, LastName);
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for(Map<String, String> employeename: employeeNames){
            String firstnamevalue = employeename.get("FirstName");
            String middlenamevalue = employeename.get("MiddleName");
            String lastnamevalue = employeename.get("LastName");
            System.out.println(firstnamevalue+" "+middlenamevalue+" "+lastnamevalue);

            AddEmployeePage addEmployeePage=new AddEmployeePage();
            sendText(addEmployeePage.firstName, firstnamevalue);
            sendText(addEmployeePage.middleName, middlenamevalue);
            sendText(addEmployeePage.lastName, lastnamevalue);
            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);

            DashboardPage dash=new DashboardPage();
            click(dash.addEmployee);
            Thread.sleep(2000);
        }
    }



    @When("user adds multiple employees from excel file from {string} sheet and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_from_sheet_and_verify_they_are_added(String sheetname) {
        List<Map<String, String>> neweployees= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetname);
        DashboardPage dash =new DashboardPage();
        AddEmployeePage add =  new AddEmployeePage();
        Iterator<Map<String, String>> iterator= neweployees.iterator();
        while(iterator.hasNext()){
            Map<String ,String > mapNewEmp= iterator.next();
            sendText(add.firstName, mapNewEmp.get("FirstName"));
            sendText(add.middleName, mapNewEmp.get("MiddleName"));
            sendText(add.lastName, mapNewEmp.get("LastName"));
            click(add.saveBtn);
            //create assertion
        }
    }
}
