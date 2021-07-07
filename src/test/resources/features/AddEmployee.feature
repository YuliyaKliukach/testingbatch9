Feature: Adding employees

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add employee button

  @smoke
  Scenario: Adding employee from add employee page
    And user enters first name, middle name and lastname
    And user clicks on save button option
    Then employee added successfully

  @smoke
  Scenario: Adding employee from add employee page
    And user enters firstname "Yuliya" middle name as "MS" and last name "Yuliya"
    And user clicks on save button option
    Then employee added successfully

    @example
    Scenario Outline: Adding employee from add employee page via feature file
      And user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the application
      And user clicks on save button option
      Then employee added successfully

    Examples:
      |FirstName|MiddleName|LastName|
      |TestQuest|Test      |TestBest|
      |Yuliya   |Ms        |Yuliya  |
      |Max      |Mr        |Max     |
      |Alex     |Mr        |Alex    |

  @datatablewithheader
  Scenario: Adding multiple employees in a single execution
    When add multiple employees and verify they are added successfully
    |FirstName|MiddleName|LastName|
    |Zanna    |MS        |Mimino  |
    |Michael  |Mr        |Jackson |
    |Mister   |MR        |Twister |

  @excel
  Scenario: Adding the employee from excel file
    When user adds multiple employees from excel file from "newdata" sheet and verify they are added

  @db
  Scenario: Add the employee and testing it from the backend
    When user enters firstname "Yuliya" middle name as "MS" and last name "Yuliya"
    And capture the employee id
    And user clicks on save button option
    Then query the HRMS database
    And verify the data from frontend and backend