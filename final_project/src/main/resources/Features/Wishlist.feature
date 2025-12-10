Feature: Wishlist Functionality

  Background:
    Given user on home page
    When user click on My Account dropdown
    And user click on Login link
    And user enter valid email and password
    And user click on login button
    Then user redirect to myAccount page
    When user click on home icon to return to home page
    Then user redirect to home page
    When user click on wishlist icon for MacBook product
    #TC1 passed
  Scenario: Verify that user can add product to wishlist successfully
    And Clicking on Wish List button on the header of the page
    Then Product displays on wish list page
    #TC2 passed
  Scenario:verify that a message displays when adding product
    Then success message should be displayed
    #TC3 Failed
  Scenario: Verify that the product removed when  removing it from wishlist page
    And Clicking on Wish List button on the header of the page
    And Clicking on remove button
    Then empty message should be displayed
    #TC4 passed
  Scenario: Verify that the products moved to the cart when moving it
    And Clicking on Wish List button on the header of the page
    And Clicking on add to cart icon of the product
    Then success message should be displayed
    #TC5 Failed
#    Wishlist must be empty
  Scenario:verify that message displays when the wishlist empty
    And Clicking on Wish List button on the header of the page
    And Clicking on remove button
    Then empty message should be displayed
#    TC6 failed
#  Wishlist must be empty
  Scenario: verify that the wishlist counter increase when adding item without refresh the page
    When user click on wishlist icon to Different product
    And wishlist counter in header should increase by one
#    TC7 Failed
#    Wishlist remove bug
  Scenario: verify that the wishlist counter decrease when adding item without refresh the page
    And Clicking on Wish List button on the header of the page
    When user remove product from wishlist
    Then wishlist counter should decrease by one
#       TC8 Passed
  Scenario:verify that the counter and the price increase on the cart button without refresh the page
    And Clicking on Wish List button on the header of the page
    When user adds MacBook to cart from wishlist
    Then cart counter and price should increase
#      TC9 Passed
  Scenario: verify that the counter and the price decrease on the cart button without refresh the page
    And Clicking on Wish List button on the header of the page
    When user adds MacBook to cart from wishlist
    When user click on cart
    Then user removes product from wishlist cart
    Then cart counter and price should decrease
#     TC10 passed
  Scenario: verify that the quantity of the product in the cart dropdown increases when clicking on add to cart button multiple times from the same product
    And Clicking on Wish List button on the header of the page
    When user adds the same product multiple times to cart
    Then the quantity inside the cart dropdown should increase
#    TC11 passed
  Scenario: verify that products removed from the dropdown when the user remove product
    And Clicking on Wish List button on the header of the page
    When user adds MacBook to cart from wishlist
    When user click on cart
    Then user removes product from cart
    Then success message should be displayed
#    TC12 Passed
  Scenario: verify that message displays when cart dropdown empty
    And Clicking on Wish List button on the header of the page
    When user adds MacBook to cart from wishlist
    When user click on cart
    Then user removes product from cart
    When user click on cart
    Then success empty message should be displayed
#    TC13 Passed
  Scenario: verify that viewCart button open the viewCart page
    And Clicking on Wish List button on the header of the page
    When user adds MacBook to cart from wishlist
    Then user click on cart
    And click on viewCart button
    Then User redirect to viewCart page
#    TC14 Passed
  Scenario: verify that clicking on checkout button open the checkout page
    And Clicking on Wish List button on the header of the page
    When user adds MacBook to cart from wishlist
    Then user click on cart
    And click on checkout button
    Then User redirect to checkout page
#    TC15 Passed
  Scenario: verify that when clicking on "MyAccount" link at the right of the page the user redirected to MyAccount page
    And Clicking on Wish List button on the header of the page
    When Clicking on MyAccount link at the right of the page
    Then user redirected to MyAccount page
#    TC16 Passed
  Scenario: verify that when clicking on "Edit Account" link at the right of the page the user redirected to MyAccount page
    And Clicking on Wish List button on the header of the page
    When Clicking on Edit Account link at the right of the page
    Then user redirected to Edit Account page
#    TC17 Passed
  Scenario: verify that when clicking on "Password" link at the right of the page the user redirected to Password page
    And Clicking on Wish List button on the header of the page
    When Clicking on Password link at the right of the page
    Then user redirected to Password page
#    TC18 Passed
  Scenario: verify that when clicking on "Payment Methods" link at the right of the page the user redirected to Payment Methods page
    And Clicking on Wish List button on the header of the page
    When Clicking on Payment Methods link at the right of the page
    Then user redirected to Payment Methods page
#    TC19 Passed
  Scenario: verify that when clicking on "Address Book" link at the right of the page the user redirected to Address Book page
    And Clicking on Wish List button on the header of the page
    When Clicking on Address Book link at the right of the page
    Then user redirected to Address Book page
#    TC20 Passed
  Scenario: verify that when clicking on "Wish List" link at the right of the page the user redirected to Wish List page
    And Clicking on Wish List button on the header of the page
    When Clicking on Wish List link at the right of the page
    Then user shouldn't redirected to any page
#    TC21 Passed
  Scenario: verify that when clicking on "Order History" link at the right of the page the user redirected to Order History page
    And Clicking on Wish List button on the header of the page
    When Clicking on Order History link at the right of the page
    Then user redirected to Order History page
#    TC22 Passed
  Scenario: verify that when clicking on "Downloads" link at the right of the page the user redirected to Downloads page
    And Clicking on Wish List button on the header of the page
    When Clicking on Downloads link at the right of the page
    Then user redirected to Downloads page
#    TC23 Passed
  Scenario: verify that when clicking on "Subscriptions" link at the right of the page the user redirected to Subscriptions page
    And Clicking on Wish List button on the header of the page
    When Clicking on Subscriptions link at the right of the page
    Then user redirected to Subscriptions page
#    TC24 Passed
  Scenario: verify that when clicking on "Reward Points" link at the right of the page the user redirected to Reward Points page
    And Clicking on Wish List button on the header of the page
    When Clicking on Reward Points link at the right of the page
    Then user redirected to Reward Points page
#    TC25 Passed
  Scenario: verify that when clicking on "Returns" link at the right of the page the user redirected to Returns page
    And Clicking on Wish List button on the header of the page
    When Clicking on Returns link at the right of the page
    Then user redirected to Returns page
#    TC26 Passed
  Scenario: verify that when clicking on "Transactions" link at the right of the page the user redirected to Transactions page
    And Clicking on Wish List button on the header of the page
    When Clicking on Transactions link at the right of the page
    Then user redirected to Transactions page
#    TC27 Passed
  Scenario: verify that when clicking on "Newsletter" link at the right of the page the user redirected to Newsletter page
    And Clicking on Wish List button on the header of the page
    When Clicking on Newsletter link at the right of the page
    Then user redirected to Newsletter page
#    TC28 Passed
  Scenario: verify that when clicking on "Logout" link at the right of the page the user redirected to Logout page
    And Clicking on Wish List button on the header of the page
    When Clicking on Logout link at the right of the page
    Then user redirected to Logout page
