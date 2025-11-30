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
    Then  Verify "<Massage>" appears shows me the action is done

    Examples:
      |                         Massage                         |
      |Success: You have added MacBook to your shopping cart!   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: verify that guest user can update quantity of product
  Given I'm guest user, I am in home Page and not added any items to my cart
  When  I can add products to my cart
  And   I Go to Shopping Cart page
  Then  I can update "<quantity>"
  Then  Verify "<Massage>" appears shows me the action is done

    Examples:
      | quantity |                 Massage                       |
      |    3     | Success: You have modified your shopping cart!|
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: verify that guest user can delete product from Shopping cart page
  Given I'm guest user, I am in home Page and not added any items to my cart
  When  I can add products to my cart
  And   I Go to Shopping Cart page
  And   I press remove icon
  Then  Verify "<Massage>" appears shows me the action is done

    Examples:
      |                         Massage                         |
      |Success: You have added MacBook to your shopping cart!   |
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
