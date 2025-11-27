Feature: Home Page Functionality - OpenCart
  As a user
  I want to verify all homepage functionality
  So that I can ensure the website works as expected

  @TC_HomePage_1
  Scenario: Verify that user is redirected to the Homepage when using URL
    Given The website is available and working without problems
    When User opens the website URL
    Then User should be redirected to the Homepage

  @TC_HomePage_2
  Scenario: Verify that all products are clearly visible with details on Homepage
    Given User is on the Homepage
    When Homepage is loaded successfully
    Then All products should be displayed with their details

  @TC_HomePage_3
  Scenario: Verify that user can interact with the main banner
    Given User is on Homepage
    When User clicks on each banner button such as "Desktops"
    Then User should be redirected to the selected banner section page

  @TC_HomePage_4
  Scenario: Verify currency conversion from currency button
    Given User is on the Homepage
    When User selects a currency from the currency button
    Then Prices across the site are updated according to the selected currency

  @TC_HomePage_5
  Scenario: Verify correct price calculation when currency is changed
    Given User is on the Homepage
    When User changes the currency to "Euro"
    Then Product prices should be correctly recalculated according to the selected currency "Euro"

  @TC_HomePage_7
  Scenario: Verify user is redirected to the product page when clicking a product
    Given User is on Homepage and Products are clearly visible
    When User clicks on a product
    Then User should be redirected to the product detail page

  @TC_HomePage_8
  Scenario: Verify search bar becomes active when clicking on it
    Given User is on the Homepage
    When User clicks on the search bar
    Then Search bar should become active and ready for input

  @TC_HomePage_9
  Scenario: Verify that user is redirected to correct product using search
    Given User is on the Homepage
    When User searches for a product by name "MacBook"
    Then Search results page should display matching products "MacBook"

  @TC_HomePage_10
  Scenario: Verify that user is redirected to Contact Us page from top contact number
    Given User is on the Homepage
    When User clicks on the top contact number
    Then User should be redirected to the Contact Us page

  @TC_HomePage_11
  Scenario: Verify My Account dropdown contains two options
    Given User is on the Homepage
    When User clicks on My Account icon
    Then Two options Register and Login should appear

  @TC_HomePage_12
  Scenario: Verify user redirected to Register page
    Given User is on the Homepage
    When User clicks on My Account icon
    And User selects Register option
    Then User should be redirected to Register page

  @TC_HomePage_13
  Scenario: Verify user redirected to Login page
    Given User is on the Homepage
    When User clicks on My Account icon
    And User selects Login option
    Then User should be redirected to Login page

  @TC_HomePage_14
  Scenario: Verify product added to cart
    Given User is on the Homepage
    When User clicks Add to Cart icon for first product
    Then Product should be added to cart

  @TC_HomePage_15
  Scenario: Verify success message after adding to cart
    Given User is on the Homepage
    When User clicks Add to Cart icon for first product
    Then Success message should be displayed

  @TC_HomePage_16
  Scenario: Verify user redirected to cart page
    Given User is on the Homepage
    When User clicks on Shopping Cart icon
    Then User should be redirected to Cart page

  @TC_HomePage_17
  Scenario: Verify product added to wishlist
    Given User is on the Homepage
    And User is logged in
    When User clicks on Wishlist icon for first product
    Then Product should be added to Wishlist

  @TC_HomePage_18
  Scenario: Verify user redirected to Wishlist page
    Given User is on the Homepage
    When User clicks on Wishlist icon at top
    Then User should be redirected to Wishlist page

  @TC_HomePage_19
  Scenario: Verify product added to comparison list
    Given User is on the Homepage
    When User clicks on Compare icon for first product
    Then Product should be added to comparison page

  @TC_HomePage_20
  Scenario: Verify footer links are clickable
    Given User is on the Homepage
    When User clicks on each footer link
    Then User should be redirected to the correct page
