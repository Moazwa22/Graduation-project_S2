@ContactUs
Feature: Contact Us Page Validations
  As a user
  I want to use the Contact Us page
  So that I can send messages successfully

  @TC_ContactUs_1
  Scenario: Verify that user is redirected to the Contact us page when user click on its icon
    Given Homepage is loaded successfully
    When User clicks on Contact Us icon
    Then Contact Us page should be displayed

  @TC_ContactUs_2
  Scenario: Verify that all required fields are displayed when user enter contact us page
    Given Contact Us page is opened before check contact us details
    Then Contact Details should be displayed

  @TC_ContactUs_3
  Scenario: Verify contact form submission with valid data
    Given Contact Us page is opened before user try to enter valid data
    When User enters valid contact data
    And User clicks on Submit button
    Then Success ContactUs message should be displayed

  @TC_ContactUs_4
  Scenario: Verify error message when submitting empty form
    Given Contact Us page is open before user submits wrong contact form
    When User submits empty contact form
    Then Error messages should be displayed

  @TC_ContactUs_5
  Scenario: Verify error message when user submits invalid email
    Given Contact Us page is open before user submits wrong email
    When User enters invalid email format
    And User clicks on Submit button
    Then Email error message should be displayed

  @TC_ContactUs_6
  Scenario: Verify name field exceeds character limit
    Given Contact Us page is opened before user enter exceeded character limitation
    When User enters more than allowed characters in name field
    And User clicks on Submit button
    Then Name error message should be displayed

  @TC_ContactUs_7
  Scenario: Verify enquiry field exceeds character limit
    Given Contact Us page is opened before user enter invalid enquiry
    When User enters more than allowed characters in enquiry field
    And User clicks on Submit button
    Then Enquiry error message should be displayed

  @TC_ContactUs_8
  Scenario: Verify user redirected to success page after submitting valid data
    Given Contact Us page is opened before going to success submit message
    When User enters valid contact data before click submit
    And User clicks on Submit button after filling valid data
    Then Contact Success page should be displayed

  @TC_ContactUs_9
  Scenario: Verify that success message is displayed after valid submission
    Given Contact Us page is opened before user redirected to success page
    When User enters valid contact data before redirection
    And User clicks on submit button
    Then Success message should appear

  @TC_ContactUs_10
  Scenario: Verify that user is redirected to homepage after clicking Continue button
    Given Contact Success page is displayed
    When User clicks on Continue button
    Then Homepage should be displayed again