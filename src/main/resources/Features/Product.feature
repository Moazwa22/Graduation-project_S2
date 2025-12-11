Feature: HTC Touch HD Product Page

  Background:
    Given the user is logged in
    When the user searches for "HTC Touch HD"
    And the user opens the HTC Touch HD product page

  Scenario: Verify the HTC Touch HD product page loads correctly
    Then the product title should be displayed as "HTC Touch HD"
    And the product price should be visible
    And the Add to Cart button should be displayed

  Scenario: Verify product is added to cart
    When the user clicks on the Add to Cart button
    Then the product should be added to the cart successfully

  Scenario: Verify product is added to wishlist
    When the user clicks the Add to Wishlist button
    Then the product should be added to the wishlist successfully

  Scenario: Verify product is added to comparison list
    When the user clicks the Add to Compare button
    Then the product should be added to the comparison list successfully