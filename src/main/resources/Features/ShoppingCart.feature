Feature: Shopping Cart Functionality

  Scenario Outline: Verify that guest user can access shopping cart page
    Given  I'm guest user, I am in home Page and not added any items to my cart
    When   I Go to Shopping Cart page
    And    Verify State indication "<massage>" appears to me
    Then   I press continue button to complete shopping

    Examples:
      | massage |
      | valid   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: Verify that guest user can access cart icon
    Given  I'm guest user, I am in home Page and not added any items to my cart
    When   I press on cart icon
    And    Verify State indication "<massage>" appears to me when I press on cart icon

    Examples:
      | massage |
      | valid   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: Verify that guest user can add items to cart
    Given I'm guest user, I am in home Page and not added any items to my cart
    When  I can add products to my cart
    Then  Verify "<Massage>" appears shows me the action is done in home page

    Examples:
      |                         Massage                         |
      |Success: You have added MacBook to your shopping cart!   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: verify that guest user can update quantity of product
    Given I'm guest user, I am in home Page and not added any items to my cart
    When  I can add products to my cart
    And   I Go to Shopping Cart page
    Then  I can update "<quantity>"
    Then  Verify "<Massage>" appears shows me the action is done in Shopping cart page

    Examples:
      | quantity |                 Massage                       |
      |    3     | Success: You have modified your shopping cart!|
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: verify that guest user can delete product from Shopping cart page
    Given I'm guest user, I am in home Page and not added any items to my cart
    When  I can add products to my cart
    And   I Go to Shopping Cart page
    And   I press remove icon
    Then  Verify State indication "<massage>" appears to me

    Examples:
      | massage |
      | valid   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: verify that guest user can apply coupon code
    Given  I'm guest user, I am in home Page and not added any items to my cart
    When   I can add products to my cart
    And    I Go to Shopping Cart page
    Then   I go to Use Coupon code Drop down list
    And    Enter my "<Coupon code>" I have
    And    press Apply Coupon Botton
    Then   Verify "<Massage>" appears shows me the action is done in Shopping cart page

    Examples:
      | Coupon code |                                 Massage                              |
      |   345ACot   |Warning: Coupon is either invalid, expired or reached its usage limit!|
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: verify that guest user after adding item to cart and go shopping cart page can continue shopping
    Given  I'm guest user, I am in home Page and not added any items to my cart
    When   I can add products to my cart
    And    I Go to Shopping Cart page
    Then   I press continue shopping button to complete shopping
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: verify that guest user after adding item and navigating shopping cart when he press checkout redirects him to checkout page
    Given I'm guest user, I am in home Page and not added any items to my cart
    When  I can add products to my cart
    And   I Go to Shopping Cart page
    Then  I press checkout button redirected to checkout page
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: Verify that guest user when press view cart from cart icon it redirects him to shopping cart page
    Given  I'm guest user, I am in home Page and not added any items to my cart
    When   I can add products to my cart
    And    I press on cart icon
    Then   I press view cart btn
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: Verify that guest user when press Check out from cart icon it redirects him to Check out page
    Given  I'm guest user, I am in home Page and not added any items to my cart
    When   I can add products to my cart
    And    I press on cart icon
    Then   I press check out btn
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#Success: You have removed an item from your shopping cart!
  Scenario Outline: verify that guest user can delete items from cart icon
    Given I'm guest user, I am in home Page and not added any items to my cart
    When  I can add products to my cart
    And   I press on cart icon
    Then  I press delete icon
    Then  Verify "<Massage>" appears shows me the action is done in home page

    Examples:
      |                          Massage                         |
      |Success: You have removed an item from your shopping cart!|
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#  Scenario Outline: Verify that logged in user can access shopping cart page
#    Given I'm logged in user
#    When  I Go to Shopping Cart page
#    And   Verify State indication "<massage>" appears to me
#    Then  I press home icon to continue shopping
#
#    Examples:
#      | massage |
#      | valid   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#  Scenario Outline: Verify that logged in user can access cart icon
#    Given  I'm logged in user
#    When   I press on cart icon
#    And    Verify State indication "<massage>" appears to me
#
#    Examples:
#      | massage |
#      | valid   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#  Scenario: Verify that logged in user can add items to cart
#    Given I'm logged in user
#    When  I can add products to my cart
#    Then Verify Success Massage appears
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
