Feature: Checkout Functionality

  Background:
    Given user in home page
    When user clicks login
    When user enters credentials
    And press Login
    Then return to home page
    And user adds item to cart

  Scenario Outline: Verify user can checkout using a new address and flat shipping rate
    Given user in checkout page
    When user selects 'I want to enter a new address'
    Then enters all information correctly
    And user presses continue button
    Then a successful alert message should appear
    Then user should choose a "<shipping rate>"
    And a payment method
    And "comment" if user wants
    Then Confirm order
    Examples:
      | shipping rate      |
      | Flat Shipping Rate |
      | Free Shipping Rate |


  Scenario Outline: Verify user can checkout using old address
    Given user in checkout page
    When user selects 'I want to use an existing address'
    Then address is "<address>"
    Then a successful alert message should appear
    Then user should choose a "<shipping rate>"
    And a payment method
    And "comment" if user wants
    Then Confirm order
    Examples:
      | address | shipping rate |
      | abdo tebry, depi, nasr, Cairo, Asyut, Egypt | Flat Shipping Rate |
      | abdo tebry, depi, nasr, Cairo, Asyut, Egypt | Free Shipping Rate |

  Scenario: Required field validation messages appear if mandatory fields are empty
    Given user in checkout page
    When user selects 'I want to enter a new address'
    Then the user leaves all required fields empty
    And user presses continue button
    Then validation error messages should be shown for all required fields