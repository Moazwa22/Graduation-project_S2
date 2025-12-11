Feature: My Account functionality
  # TC_Login_01
  Scenario: verify from "Edit your account information" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Edit your account information link
    Then user go to Edit your account information page

# TC_Login_02
  Scenario: verify from "Change your password" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Change your password link
    Then user go to Change your password page


# TC_Login_03
  Scenario: verify from "Stored payment methods" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Stored payment methods link
    Then user go to Stored payment methods page

# TC_Login_04
  Scenario: verify from "Modify your address book entries" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Modify your address book entries link
    Then user go to Modify your address book entries page


# TC_Login_05
  Scenario: verify from "View your order history" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on View your order history link
    Then user go to View your order history page

# TC_Login_06
  Scenario: verify from "Subscriptions" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Subscriptions link
    Then user go to Subscriptions page


# TC_Login_07
  Scenario: verify from "Downloads" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Downloads link
    Then user go to Downloads page

# TC_Login_08
  Scenario: verify from "Your Reward Points" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Your Reward Points link
    Then user go to Your Reward Points page

# TC_Login_09
  Scenario: verify from "View your return requests" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on View your return requests link
    Then user go to View your return requests page

# TC_Login_10
  Scenario: verify from "Your Transactions" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Your Transactions link
    Then user go to Your Your Transactions page


# TC_Login_11
  Scenario:verify from "Register for an affiliate account" link  functionality in My Affiliate Account section after user login successfully
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Register for an affiliate account link
    Then user go to Register for an affiliate account page


# TC_Login_12
  Scenario: verify from "Subscribe / unsubscribe to newsletter" link  functionality in Newsletter section after user login successfully
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Subscribe unsubscribe to newsletter link
    Then user go to Subscribe unsubscribe to newsletter page
################################
  #the my account dropdown
  # TC_Login_13
  Scenario: verify that user can access My Account page form the My Account drop down in the navigation bar after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on My account button at nav bar
    And click on My Account from drop down list
    Then user redirect to My Account page
# TC_Login_14
  Scenario: verify that user can access order history page form the My Account drop down in the navigation bar after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on My account button at nav bar
    And click on order history from drop down list
    Then user redirect to Order History page
# TC_Login_15
  Scenario: verify that user can access Transactions page form the My Account drop down in the navigation bar after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on My account button at nav bar
    And click on Transactions from drop down list
    Then user redirect to Transactions page
# TC_Login_16
  Scenario: verify that user can access downloads page form the My Account drop down in the navigation bar after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on My account button at nav bar
    And click on Downloads from drop down list
    Then user redirect to Downloads page
# TC_Login_17
  Scenario: verify that user can access logout page form the My Account drop down in the navigation bar after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on My account button at nav bar
    When user click on logout button at nav bar
    Then user redirect to logout page

################################
# right links in the home page
#  TC_Login_18
  Scenario: verify that when click on "My Account" button at the right of the page the website keep user in My Account page
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user Click on My account in the right list
    Then user kept in my account page

# TC_Login_19
  Scenario: verify that when click on "edit account" button at the right of the page the website redirect user to edit account page
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user Click on edit account in the right list
    Then user redirect to edit account page

# TC_Login_20
  Scenario: verify that when click on "password" button at the right of the page the website redirect user to  password page
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on  password button
    Then user redirect to  password page

  # TC_Login_21
  Scenario: verify that when click on "payment methods" button at the right of the page the website redirect user payment method page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on payment methods button
    Then user redirect to payment methods page

# TC_Login_22
  Scenario: verify that when click on "Address book" button at the right of the page the website redirect user to Address book page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Address book button
    Then user redirect to Address book page

# TC_Login_23
  Scenario: verify that when click on "Wish list" button at the right of the page the website redirect user to Wish list page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Wish list Link
    Then user redirect to Wish list page

# TC_Login_24
  Scenario: verify that when click on "Order History" button at the right of the page the website redirect user to rder History page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Order History Link
    Then user redirect to Order History page

# TC_Login_25
  Scenario: verify that when click on "Downloads" button at the right of the page the website redirect user to Downloads page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Downloads button
    Then user redirect to Downloads page


# TC_Login_26
  Scenario: verify that when click on "Subscriptions" button at the right of the page the website redirect user to Subscriptions page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Subscriptions button
    Then user redirect to Subscriptions page

  # TC_Login_27
  Scenario: verify that when click on "Reward points" button at the right of the page the website redirect user to Reward points page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Reward points button
    Then user redirect to Reward points page

# TC_Login_28
  Scenario: verify that when click on "Returns" button at the right of the page the website redirect user to Returns page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Returns button
    Then user redirect to Returns page

# TC_Login_29
  Scenario:verify that when click on "Transactions" button at the right of the page the website redirect user toTransactions page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Transactions button
    Then user redirect to Transactions page

# TC_Login_30
  Scenario:verify that when click on "Newsletter" button at the right of the page the website redirect user to Newsletter page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on Newsletter button
    Then user redirect to Newsletter page

# TC_Login_31
  Scenario:verify that when click on "Logout" button at the right of the page the website redirect user to logout page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And click on login button
    Then user redirect to My Account page
    When user click on logout button
    Then user redirect to logout page


