Feature: Login Functionality


  Scenario: Verify User can log in
    Given user in home page
    When user clicks login
    When user enters credentials
    And press Login
    And user adds item to cart