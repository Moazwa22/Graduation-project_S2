

Feature: Wishlist Functionality
  Scenario: Verify that user can add product to wishlist successfully
    Given user on home page
    When user click on My Account dropdown
    And user click on Login link
    And user enter valid email and password
    And user click on login button
    Then user redirect to myAccount page
    When user click on home icon to return to home page
    Then user redirect to home page
    When user click on wishlist icon for MacBook product
    Then success message should be displayed
    And wishlist counter in header should increase by one