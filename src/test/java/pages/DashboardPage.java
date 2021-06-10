package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashboardPage extends CommonMethods {


    @FindBy(id="welcome")
    public WebElement welcomemessage;


    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployee;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    public List<WebElement> dashboardtabs;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
