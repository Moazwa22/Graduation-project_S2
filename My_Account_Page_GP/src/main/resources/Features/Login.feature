Feature: Login Functionality

#  TC_Login_01 (Done)
  Scenario: verify that user can access login page from the home page successfully.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page

#  TC_Login_02 (done)
  Scenario: verify that user can redirect to home page from login page successfully.
    Given  user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user click on home page icon
    Then user redirect to home page

#  TC_Login_03 (done)
  Scenario: verify from "continue" button functionallity in the login page that can direct user to register page if he is a new customer.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user click on Continue button
    Then user redirect to rigester page.

#  TC_Login_04 (done)
  Scenario:verify from successfull login with valid credentials.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user enter valid email and password
    And  click on login button
    Then user redirect to My Account page

#  TC_Login_05 ( done )
  Scenario: verify from unsuccessful login when user enter invalid E-mail.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user enter invalid email and valid password
    And  click on login button
    Then warning massage appear tell user invalid credentials



#  TC_Login_06 ( done )
  Scenario: verify from unsuccessful login when user enter invalid password.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user enter valid email and invalid password
    Then  click on login button
    Then warning massage appear tell user invalid credentials

#  TC_Login_07 (done)
  Scenario: verify from unsuccessful login when user keep the E-mail bar empty
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user keep email bar empty and enter valid password.
    Then click on login button
    Then warning massage appear tell user invalid credentials

#  TC_Login_08 (done)
  Scenario: verify from unsuccessful login when user keep the password bar empty
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user keep password bar empty and enter valid email
    Then click on login button
    Then warning massage appear tell user invalid credentials

#  TC_Login_09
  Scenario: verify from unsuccessful login when user keep both email and password bars empty.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user keep keep both email and passowrd bars empty
    Then click on login button
    Then warning massage appear tell user invalid credentials
##########################################################
##########################################################

#  TC_Login_10 (done)
  Scenario: verify from"Login" button functionality.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And  click on login button
    Then user redirect to My Account page

#  TC_Login_11 (done)
  Scenario: verify from "forgotten passoword " link below password bar.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on forgotten passoword link
    Then user redirect to  forgotten passoword  page
############################################################
  #mn awel hna hnshtghal b3d ma al user y3ml login 3shan nt'ked en koll al pages shaghala sa7 w hn3ml classes b'samy al pages de

#  TC_Login_12 (done)
  Scenario: verify that when click on "login" link at the right of the page the website keep user in the login page
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user Click on Login link in the right list
    Then user redirect to login page

# TC_Login_13 (done)
  Scenario: verify that when click on "Register" link at the right of the page the website direct user to the register page
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user Click on Register link in the right list
    Then user redirect to Register page

# TC_Login_14
  Scenario: verify that when click on "Forgotten password" link at the right of the page the website direct user to the forgotten password page
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on forgotten passoword link
    Then user redirect to  forgotten passoword  page

  # TC_Login_15 (done)
  Scenario: verify that when click on "My Account" link at the right of the page the website direct user to My Account page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on MyAccount Link
    Then user redirect to My Account page

# TC_Login_16
Scenario:  verify that when click on "Address book" link at the right of the page the website direct user to Address book page.
  Given user in home page
  When user click on my account drop down
  And  click on Login
  Then user redirect to login page
  When user click on Adress book Link
  Then user redirect to Adress book page

# TC_Login_17
  Scenario: verify that when click on "Wish list" link at the right of the page the website direct user to Wish list page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Wish list Link
    Then user redirect to Wish list page

# TC_Login_18
  Scenario: verify that when click on "Order History" link at the right of the page the website direct user to rder History page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Order History Link
    Then user redirect to Order History page

# TC_Login_19
  Scenario: verify that when click on "Downloads" link at the right of the page the website direct user to Downloads page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Downloads Link
    Then user redirect to Downloads page


# TC_Login_20
  Scenario: verify that when click on "Subscriptions" link at the right of the page the website direct user to Subscriptions page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Subscriptions Link in List
    Then user redirect to Subscriptions page



  # TC_Login_21
  Scenario: verify that when click on "Reward points" link at the right of the page the website direct user to Reward points page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Reward points Link
    Then user redirect to Reward points page

# TC_Login_22
  Scenario: verify that when click on "Returns" link at the right of the page the website direct user to Returns page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Returns Link
    Then user redirect to Returns page

# TC_Login_23
  Scenario:verify that when click on "Transactions" link at the right of the page the website direct user toTransactions page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Transactions Link
    Then user redirect to Transactions page

# TC_Login_24
  Scenario:verify that when click on "Newsletter" link at the right of the page the website direct user to Newsletter page.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on Newsletter Link
    Then user redirect to Newsletter page

###############################################################################
# TC_Login_25 (done)
    Scenario: verify from "Edit your account information" link  functionality in My account section after user login successfully.
      Given user in home page
      When user click on my account drop down
      And  click on Login
      Then user redirect to login page
      When user enter valid email and password
      Then   click on login button
      When user click on Edit your account information link
      Then user go to Edit your account information page

# TC_Login_26 (done)
  Scenario: verify from "Change your password" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Change your password link
    Then user go to Change your password page


# TC_Login_27 (done)
  Scenario: verify from "Stored payment methods" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Stored payment methods link
    Then user go to Stored payment methods page

# TC_Login_28 (done)
  Scenario: verify from "Modify your address book entries" link  functionality in My account section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Modify your address book entries link
    Then user go to Modify your address book entries page


# TC_Login_29 (done)
  Scenario: verify from "View your order history" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on View your order history link
    Then user go to View your order history page

# TC_Login_30  (done)
  Scenario: verify from "Subscriptions" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Subscriptions link
    Then user go to Subscriptions page


# TC_Login_31
  Scenario: verify from "Downloads" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Downloads link
    Then user go to Downloads page

# TC_Login_32 (done)
  Scenario: verify from "Your Reward Points" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Your Reward Points link
    Then user go to Your Reward Points page

# TC_Login_33 (done)
  Scenario: verify from "View your return requests" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on View your return requests link
    Then user go to View your return requests page

# TC_Login_34
  Scenario: verify from "Your Transactions" link  functionality in My Orders section after user login successfully.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Your Transactions link
    Then user go to Your Your Transactions page


# TC_Login_35
  Scenario:verify from "Register for an affiliate account" link  functionality in My Affiliate Account section after user login successfully
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Register for an affiliate account link
    Then user go to Register for an affiliate account page


# TC_Login_36 (done)
  Scenario: verify from "Subscribe / unsubscribe to newsletter" link  functionality in Newsletter section after user login successfully
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on Subscribe unsubscribe to newsletter link
    Then user go to Subscribe unsubscribe to newsletter page
######################################################################
# TC_Login_37
  Scenario: verify that user can access my account page from the my account page after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on my account drop down in my account page
    Then click on My Account from drop down list
    Then user redirect to My Account page

# TC_Login_38
  Scenario: verify that user can access order history page from the my account page after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on my account drop down in my account page
    Then click on order history from drop down list
    Then user redirect to Order History page


# TC_Login_39
  Scenario: verify that user can access transactions page from the my account page after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on my account drop down in my account page
    Then click on transactions from drop down list
    Then user redirect to Transactions page


    # TC_Login_40
  Scenario: verify that user can access downloads page from the my account page after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on my account drop down in my account page
    Then click on Downloads from drop down list
    Then user redirect to Downloads  page

# TC_Login_41
  Scenario: verify that user can logout from the my account page after successful login
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    Then   click on login button
    When user click on my account drop down in my account page
    Then click on logout from drop down list
    Then user redirect to logout  page

