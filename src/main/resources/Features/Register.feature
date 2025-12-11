Feature: Register functionality
#TC_Register_01
  Scenario: verify that when user click on register the website direct user to registeration page.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
#TC_Register_02
  Scenario: verify that user able to register on the website with valid credentials .
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credenials.
    And enable privacy police toggle
    And click on register button
    Then user can register successfully


#TC_Register_03
  Scenario: verify that user can not register without agree to the privacy policy.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credenials.
    And click on register button


 #TC_Register_04
  Scenario: verify faild registeration when user enter all credentials correct but the email is empty.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credentials except email keep it empty
    And enable privacy police toggle
    Then click on register button


 #TC_Register_05
  Scenario: verify faild registeration when user enter all credentials correct but the password is empty.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credentials except password keep it empty
    And enable privacy police toggle
    And click on register button



 #TC_Register_06
  Scenario: verify faild registeration when user enter all credentials correct but the First name is empty.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credentials except first name keep it empty
    And enable privacy police toggle
    And click on register button


 #TC_Register_07
  Scenario: verify faild registeration when user enter all credentials correct but the Last name is empty.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credentials except last name keep it empty
    And enable privacy police toggle
    And click on register button


   #TC_Register_08
  Scenario: verify that user can redirect to the home page from registeration page.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user click on home page icon
    Then user redirect to home page


   #TC_Register_09
  Scenario: verify failed registration when user enter invalid first name syntax.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except first name enter invalid
    And enable privacy police toggle
    And click on register button

   #TC_Register_10
  Scenario: verify failed registration when user enter invalid Last name syntax.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except last name enter invalid
    And enable privacy police toggle
    And click on register button

   #TC_Register_11
  Scenario: verify failed registration when user enter invalid email syntax.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except email enter invalid
    And enable privacy police toggle
    And click on register button

#TC_Register_12
  Scenario: verify failed registration when user enter invalid password syntax
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except password enter invalid
    And enable privacy police toggle
    And click on register button

    #TC_Register_13
  Scenario: verify that warning message display when user enter first name greater than 32 characters
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except first name enter invalid more than 32 characters
    And enable privacy police toggle
    And click on register button
    Then user will see an warning message
#TC_Register_14
  Scenario: verify that warning message display when user enter last name greater than 32 characters
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except last name enter invalid more than 32 characters
    And enable privacy police toggle
    And click on register button
    Then user will see an warning message
#TC_Register_15
  Scenario: verify that warning message display when user enter password greater than 40 characters
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except password enter invalid by enter more than 40 charachters
    And enable privacy police toggle
    And click on register button
    Then user will see an warning password message
#TC_Register_16
  Scenario: verify that waning message display when user enter password less than 6 characters
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except password enter invalid
    And enable privacy police toggle
    And click on register button
    Then user will see an warning password message
#Tc_Register_17
  Scenario: verify that user can access login page from the top link , already have an account
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user click on already have an account please login at the login page
    Then user redirect to login page
################################################################################################
  ## the right links list

#TC_Register_18
  Scenario: verify that when click on "login" link at the right of the page the website redirect user to the login page
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user Click on Login link in the right list
    Then user redirect to login page

#TC_Register_19
  Scenario: verify that when click on "Register" link at the right of the page the website keep user in the register page
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user Click on Register link in the right list
    Then user kept at Register page

#TC_Register_20
  Scenario: verify that when click on "Forgotten password" link at the right of the page the website redirect user to the forgotten password page
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on forgotten password link
    Then user redirect to  forgotten passoword  page from register page

 #TC_Register_21
  Scenario: verify that when click on "My Account" link at the right of the page the website direct user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on MyAccount Link from register page
    Then user redirect to login page from register page

#TC_Register_22
  Scenario: verify that when click on "Address book" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Adress book Link from register page
    Then user redirect to login page from register page

#TC_Register_23
  Scenario: verify that when click on "Wish list" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Wish list Link from register page
    Then user redirect to login page from register page

#TC_Register_24
  Scenario: verify that when click on "Order History" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Order History Link from register page
    Then user redirect to login page from register page

#TC_Register_25
  Scenario: verify that when click on "Downloads" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Downloads Link from register page
    Then user redirect to login page from register page

#TC_Register_26
  Scenario: verify that when click on "Subscriptions" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Subscriptions Link from register page
    Then user redirect to login page from register page

 #TC_Register_27
  Scenario: verify that when click on "Reward points" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Reward points Link from register page
    Then user redirect to login page from register page

#TC_Register_28
  Scenario: verify that when click on "Returns" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Returns Link from register page
    Then user redirect to login page from register page

#TC_Register_29
  Scenario:verify that when click on "Transactions" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Transactions Link from register page
    Then user redirect to login page from register page

#TC_Register_30
  Scenario:verify that when click on "Newsletter" link at the right of the page the website redirect user to login page.
    Given user in home page
    When user click on my account drop down
    And  click on register
    Then user redirect to register page
    When user click on Newsletter Link from register page
    Then user redirect to login page from register page

