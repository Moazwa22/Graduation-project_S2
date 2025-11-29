Feature: Catalog Page Verification

  Background:
    Given the user is on the home page

  Scenario: Verify products when user clicks Show All Desktops
    When the user navigates to Show All Desktops
    Then the catalog page should display all desktops with their name and price

  Scenario: Verify products in Desktops → Mac category
    When the user navigates to the Desktops category
    And the user selects the Mac subcategory
    Then the catalog page should display the available products
    And each product should be visible with its name and price

  Scenario: Add first Mac product to cart
    When the user navigates to the Desktops category
    And the user selects the Mac subcategory
    And the user adds the first product to the cart
    Then the product should be successfully added to the cart

  Scenario: Add first Mac product to wishlist
    When the user navigates to the Desktops category
    And the user selects the Mac subcategory
    And the user adds the first product to the wishlist
    Then the product should be successfully added to the wishlist

  Scenario: Add first Mac product to comparison list
    When the user navigates to the Desktops category
    And the user selects the Mac subcategory
    And the user adds the first product to the comparison list
    Then the product should be successfully added to the comparison list
