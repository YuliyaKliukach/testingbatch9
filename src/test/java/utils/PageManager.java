package utils;

import pages.*;

public class PageManager {


    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeListPage employeeListPage;
    public static JobPage jobPage;
    public static AddEmployeePage addEmployeePage;


    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        employeeListPage = new EmployeeListPage();
        jobPage =new JobPage();
        addEmployeePage=new AddEmployeePage();
    }
}
