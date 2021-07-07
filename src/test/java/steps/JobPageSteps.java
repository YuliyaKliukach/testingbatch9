package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.JobPage;
import utils.CommonMethods;
import utils.DBUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

import static utils.PageManager.dashboardPage;
import static utils.PageManager.jobPage;

public class JobPageSteps extends CommonMethods {

    @When("user click on Admin button")
    public void user_click_on_admin_button() {
        DashboardPage dashboardPage=new DashboardPage();
        click(dashboardPage.adminMenu);
    }

    @When("user clicks on Job Title button  from Job menu")
    public void user_clicks_on_job_title_button_from_job_menu() {
        JobPage jobPage=new JobPage();
        moveToElement(jobPage.jobAdminButton);
        click(jobPage.jobTitleList);
    }

    @When("user clicks on Add job button")
    public void user_clicks_on_add_job_button() {
        JobPage jobPage=new JobPage();
        click(jobPage.jobAddBtn);
    }

    @When("user enters new job title {string} and click on save job button")
    public void user_enters_new_job_title_and_click_on_save_job_button(String jobTitle) {
        JobPage jobPage=new JobPage();
        sendText(jobPage.jobTitleField, jobTitle);
        click(jobPage.jobSaveBtn);
        GlobalVariables.jobTitle=jobTitle;
    }

    @Then("user verifies job added from backend")
    public void user_verifies_job_added_from_backend() {
        String query="select job_title from ohrm_job_title where job_title='Math Teacher';";
        DBUtils.getConnection();
        List<Map<String,String>> tableDataAsList= DBUtils.getTableDataAsList(query);
        GlobalVariables.dbJobTitle=tableDataAsList.get(0).get("job_title");

        Assert.assertEquals(GlobalVariables.jobTitle, GlobalVariables.dbJobTitle);
    }
}
