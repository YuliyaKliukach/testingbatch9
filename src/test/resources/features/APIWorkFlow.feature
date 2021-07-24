#Author: Yuliya Syntax Student
Feature: Syntax HRMS API Workflow
  Description: This feature file test Syntax HRMS API Workflow

  Background:
    Given a token is generated

  @APIWorkflow
    Scenario: Creating Dynamic Employee
      Given a request is prepared to create an employee with dynamic data "Yuliya", "Kliukach", "Viktorovna", "F", "1987-03-20", "Employee", "Developer"

  @APIWorkflow
  Scenario: Creating an Employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employeeID "Employee.employee_id" is stored as a global variable to be used for other calls

  @APIWorkflow
  Scenario: Retrieving created employee
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for retrieving the created employee is 200
    And the retrieved employee ID "employee.employee_id" matches the globaly stored employee ID
    And the retrieved data at "employee" matches the data used to create an employee with employee ID "employee.employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_gender | emp_birthday | emp_job_title | emp_status |
      | Viktor        | Stepanovich     | Kliukach     | Male       | 1963-12-17   | Developer     | Employee   |


