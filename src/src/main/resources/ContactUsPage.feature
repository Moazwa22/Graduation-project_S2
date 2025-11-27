@ContactUs
Feature: Contact Us Page Validations
  As a user
  I want to use the Contact Us page
  So that I can send messages successfully

  @TC_ContactUs_1
  Scenario: Verify that user is redirected to the Contact Us page when clicking its icon
    Given Homepage is loaded successfully
    When User clicks on the Contact Us icon
    Then Contact Us page should be displayed

  @TC_ContactUs_2
  Scenario: Verify that all required fields are displayed when user enters Contact Us page
    Given Contact Us page is open
    Then All Contact Us form fields should be displayed

  @TC_ContactUs_3
  Scenario: Verify contact form submission with valid data
    Given Contact Us page is open
    When User enters valid contact data
    And User clicks on the Submit button
    Then Success message should be displayed

  @TC_ContactUs_4
  Scenario: Verify error messages when submitting empty contact form
    Given Contact Us page is open
    When User submits an empty contact form
    Then Appropriate error messages should be displayed

  @TC_ContactUs_5
  Scenario: Verify error message when submitting invalid email
    Given Contact Us page is open
    When User enters an invalid email format
    And User clicks on the Submit button
    Then Email-specific error message should be displayed

  @TC_ContactUs_6
  Scenario: Verify name field exceeds character limit
    Given Contact Us page is open
    When User enters more characters than allowed in the name field
    And User clicks on the Submit button
    Then Name-specific error message should be displayed

  @TC_ContactUs_7
  Scenario: Verify enquiry field exceeds character limit
    Given Contact Us page is open
    When User enters more characters than allowed in the enquiry field
    And User clicks on the Submit button
    Then Enquiry-specific error message should be displayed

  @TC_ContactUs_8
  Scenario: Verify user redirected to success page after submitting valid data
    Given Contact Us page is open
    When User enters valid contact data
    And User clicks on the Submit button
    Then Contact Success page should be displayed

  @TC_ContactUs_9
  Scenario: Verify that success message is displayed after valid submission
    Given Contact Us page is open
    When User enters valid contact data
    And User clicks on the Submit button
    Then Success message should appear

  @TC_ContactUs_10
  Scenario: Verify that user is redirected to homepage after clicking Continue button
    Given Contact Success page is displayed
    When User clicks on the Continue button
    Then Homepage should be displayed again
