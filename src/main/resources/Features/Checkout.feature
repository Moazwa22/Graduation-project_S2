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

#  Scenario: Required field validation messages appear if mandatory fields are empty
#    Given user in checkout page
#    When user selects 'I want to enter a new address'
#    Then the user leaves all required fields empty
#    And user presses continue button
#    Then validation error messages should be shown for all required fields

  Scenario Outline: Required field validation when one field is missing
    Given user in checkout page
    When user selects 'I want to enter a new address'
    And the user enters the following address data:
      | firstName   | lastName   | address1   | city     | postcode   | country   | region   | shipping    | payment   |
      | <firstName> | <lastName> | <address1> | <city>   | <postcode> | <country> | <region> | <shipping>  | <payment> |
    And user presses continue button
    Then a validation message should appear for "<case>"

    Examples:
      | case | firstName | lastName | address1        | city   | postcode | country | region        | shipping           | payment          |
      |1     |           | Tester   | 12 Test Street  | Cairo  | 12345    | Egypt   | Cairo Region  | Free Shipping Rate | Cash on delivery |
      |2     | Tebry     |          | 12 Test Street  | Cairo  | 12345    | Egypt   | Cairo Region  | Free Shipping Rate | Cash on delivery |
      |3     | Tebry     | Tester   |                 | Cairo  | 12345    | Egypt   | Cairo Region  | Free Shipping Rate | Cash on delivery |
      |4     | Tebry     | Tester   | 12 Test Street  |        | 12345    | Egypt   | Cairo Region  | Free Shipping Rate | Cash on delivery |
      |5     | Tebry     | Tester   | 12 Test Street  | Cairo  |          | Egypt   | Cairo Region  | Free Shipping Rate | Cash on delivery |
      |6     | Tebry     | Tester   | 12 Test Street  | Cairo  | 12345    |         | Cairo Region  | Free Shipping Rate | Cash on delivery |
      |7     | Tebry     | Tester   | 12 Test Street  | Cairo  | 12345    | Egypt   |               | Free Shipping Rate | Cash on delivery |
      |8     | Tebry     | Tester   | 12 Test Street  | Cairo  | 12345    | Egypt   | Cairo Region  |                    | Cash on delivery |
      |1     |           | Tester   | 12 Test Street  | Cairo  | 12345    | Egypt   | Cairo Region  | Flat Shipping Rate | Cash on delivery |
      |2     | Tebry     |          | 12 Test Street  | Cairo  | 12345    | Egypt   | Cairo Region  | Flat Shipping Rate | Cash on delivery |
      |3     | Tebry     | Tester   |                 | Cairo  | 12345    | Egypt   | Cairo Region  | Flat Shipping Rate | Cash on delivery |
      |4     | Tebry     | Tester   | 12 Test Street  |        | 12345    | Egypt   | Cairo Region  | Flat Shipping Rate | Cash on delivery |
      |5     | Tebry     | Tester   | 12 Test Street  | Cairo  |          | Egypt   | Cairo Region  | Flat Shipping Rate | Cash on delivery |
      |6     | Tebry     | Tester   | 12 Test Street  | Cairo  | 12345    |         | Cairo Region  | Flat Shipping Rate | Cash on delivery |
      |7     | Tebry     | Tester   | 12 Test Street  | Cairo  | 12345    | Egypt   |               | Flat Shipping Rate | Cash on delivery |
      |8     | Tebry     | Tester   | 12 Test Street  | Cairo  | 12345    | Egypt   | Cairo Region  |                    | Cash on delivery |

