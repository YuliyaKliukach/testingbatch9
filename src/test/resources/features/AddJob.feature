Feature: Adding new job

  Scenario: Admin user is adding new job title and testing it from backend
    When user is logged in with valid admin credentials
    And user click on Admin button
    And user clicks on Job Title button  from Job menu
    And user clicks on Add job button
    And user enters new job title "Math Teacher" and click on save job button
    Then user verifies job added from backend