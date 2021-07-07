package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class JobPage extends CommonMethods {

    @FindBy (id = "menu_admin_Job")
    public WebElement jobAdminButton;

    @FindBy (id = "btnAdd")
    public WebElement jobAddBtn;

    @FindBy (id = "jobTitle_jobTitle")
    public WebElement jobTitleField;

    @FindBy (id = "btnSave")
    public WebElement jobSaveBtn;

    @FindBy (id = "menu_admin_viewJobTitleList")
    public WebElement jobTitleList;

    public JobPage(){
        PageFactory.initElements(driver, this);
    }
}
