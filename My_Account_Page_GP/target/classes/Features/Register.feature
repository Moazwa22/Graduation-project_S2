Feature: Register functionality
#TC_Register_01 (done)
  Scenario: verify that when user click on register the website direct user to registeration page.
    Given user in home page
    When user click on my account drop down
     And click on register
    Then user redirect to register page
#TC_Register_02 (done)
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
    Then warning  message appear tells user
 #TC_Register_04
  Scenario: verify faild registeration when user enter all credentials correct but the email is empty.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When user enter valid credentials except email keep it empty
    And enable privacy police toggle
    And click on register button

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
  Scenario: verify faild registeration when user enter invaild first name syntax.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except first name enter invalid
    And enable privacy police toggle
    And click on register button

   #TC_Register_10
    Scenario: verify faild registeration when user enter invaild Last name syntax.
      Given user in home page
      When user click on my account drop down
      And click on register
      Then user redirect to register page
      When enter valid credentials except last name enter invalid
      And enable privacy police toggle
      And click on register button

   #TC_Register_11
  Scenario: verify faild registeration when user enter invaild email name syntax.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except email enter invalid
    And enable privacy police toggle
    And click on register button

#TC_Register_12
  Scenario: verify faild registeration when user enter invaild password name syntax.
    Given user in home page
    When user click on my account drop down
    And click on register
    Then user redirect to register page
    When enter valid credentials except password enter invalid
    And enable privacy police toggle
    And click on register button

