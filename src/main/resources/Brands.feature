Feature: Brands Page Validations
  As a user
  I want to use the Brands page
  So that I can browse manufacturers easily

  @TC_Brands_1
  Scenario: Verify that user is redirected to brands page when user clicks on Brands link
    Given Homepage is loaded successfully before user redirected to brands page
    When User clicks on Brands link
    Then Brands page should be displayed

  @TC_Brands_2
  Scenario: Verify that page scrolls to correct section when user clicks on specific alphabet letter
    Given Brands page is opened
    When User clicks on alphabet letter "A"
    Then Page should scroll to brands starting with "A"

  @TC_Brands_3
  Scenario: Verify that user is redirected to manufacturer’s product list when clicking on a brand
    Given Brands page is opened
    When User clicks on brand "Apple"
    Then User should be redirected to Apple products page