Feature: Login Functionality


  Scenario: Verify User can log in
    Given user in home page
    When user clicks login
    When user enters credentials
    And press Login
    Then return to home page
    And user adds item to cart