Feature: Login Functionality

#  TC_Login_01
  Scenario: verify that user can access login page from the home page successfully.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page

#  TC_Login_02
  Scenario: verify that user can redirect to home page from login page successfully.
    Given  user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user click on home page icon
    Then user redirect to home page

#  TC_Login_03
  Scenario: verify from "continue" button functionallity in the login page that can direct user to register page if he is a new customer.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user click on Continue button
    Then user redirect to rigester page.

#  TC_Login_04
  Scenario:verify from successfull login with valid credentials.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user enter valid email and password
    And  click on login button
    Then user redirect to My Account page

#  TC_Login_05
  Scenario: verify from unsuccessful login when user enter invalid E-mail.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user enter invalid email and valid password
    And  click on login button
    Then warning massage appear tell user invalid credentials

#  TC_Login_06
  Scenario: verify from unsuccessful login when user enter invalid password.
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user enter valid email and invalid password
    Then  click on login button
    Then warning massage appear tell user invalid credentials

#  TC_Login_07
  Scenario: verify from unsuccessful login when user keep the E-mail bar empty
    Given user in home page
    When user click on my account drop down
    And click on Login
    Then user redirect to login page
    When user keep email bar empty and enter valid password.
    Then click on login button
    Then warning massage appear tell user invalid credentials

#  TC_Login_08
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

#  TC_Login_10
  Scenario: verify from"Login" button functionality.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user enter valid email and password
    And  click on login button
    Then user redirect to My Account page

#  TC_Login_11
  Scenario: verify from "forgotten passoword " link below password bar.
    Given user in home page
    When user click on my account drop down
    And  click on Login
    Then user redirect to login page
    When user click on forgotten passoword link
    Then user redirect to  forgotten passoword  page

     #-------------tebry--------------#
  Scenario: Verify User can log in
    Given user in home page
    When user clicks login
    When user enters credentials
    And press Login
    Then return to home page
    And user adds item to cart








