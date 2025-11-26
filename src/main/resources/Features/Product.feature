Feature: HTC Touch HD Product Page
  Verify product page details and Add to Cart functionality

  Scenario: Verify that the HTC Touch HD product page loads correctly
    Given the user is on the home page
    When the user searches for "HTC Touch HD"
    And the user opens the HTC Touch HD product page
    Then the product title should be displayed as "HTC Touch HD"
    And the product price should be visible
    And the Add to Cart button should be displayed

  Scenario: Verify that the product is added to the cart successfully
    Given the user is on the HTC Touch HD product page
    When the user clicks on the Add to Cart button
    Then the product should be added to the cart successfully
    And a success message should appear confirming the add to cart action
