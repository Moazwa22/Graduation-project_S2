Feature: Checkout Functionality

  Background:
    Given user in home page
    When user clicks login
    When user enters credentials
    And press Login
    Then user adds item to cart

  Scenario: Verify user can checkout
    When user in checkout page
    Then user selects 'I want to enter a new address'
    And enters all information correctly
    When user presses continue button
    Then a successful alert message should appear