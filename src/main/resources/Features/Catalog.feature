Feature: Catalog Page Verification
  Verify that products are displayed correctly in catalog

  Scenario: Verify products in Desktops → Mac category
    Given the user is on the home page
    When the user navigates to the Desktops category
    And the user selects the Mac subcategory
    Then the catalog page should display the available products
    And each product should be visible with its name and price
