  Feature: Home Page Functionality - OpenCart
  As a user
  I want to verify all homepage functionality
  So that I can ensure the website works as expected

  @TC_HomePage_1
  Scenario: Verify that user redirected to the Homepage when using URL
    Given The website is available and working without problems
    When User opnes the website URL
    Then User should be redirected to the Homepage

    @TC_HomePage_2
    Scenario: Verify that all products are clearly visible with details on Homepage
      Given User is on the Homepage
      When Homepage is loaded successfully
      Then All products should be displayed with their details

      @TC_HomePage_3
      Scenario: Verify that user can interact with the main banner
        Given User is on Homepage
        When User clciks on each banner button such as "Desktop", "Components
        Then User should be redirected to the selected banner section page

        @TC_Homepage_4
        Scenario: Verify currency conversion from currency button
          Given User is on the Homepage
          When User selects a currency from the currency button
          Then Price accross the site are updated according to the selected currency

          @TC_HomePage_5
          Scenario: Verify correct price calculation when currency is changed
            Given User is on Homepage
            When User changes the currency to Euro,US Dollar, Pound Sterling
            Then Product prices should be correctly recalculated according to the selected currnecy

            @TC_HomePage_6 //// لسه هشوف هعملها ولا لأ
            Scenario: Verify product rating and stock availability
              Given User is on the Homepage
              When Homepage products are displayed
              Then Each product shpuld show rating and stock availability

              @TC_HomePage_7
              Scenario: Verify that user is redirected to the product page when clicking on any product
                Given User is on Homepage and Products are clearly visible
                When User clicks on a product
                Then User should be redirected to the product detail page

                @TC_HomePage_8
                Scenario: Verify search bar becomes active when clicking on it //be sure is this can be automated or not.
                  Given User is on the Homepage
                  When User clicks on the search bar
                  Then Search bar should become active and ready for input

                  @TC_HomePage_9
                  Scenario: Verify that user is redirected to correct product using search
                    Given User is on The Homepage
                    When User searches for a product by name
                    Then Search results page should display matching products

                    @TC_HomePage_10
                    Scenario: Verify that user is redirected to Contact Us page from top contact number
                      Given User is on the Homepage
                      When User clicks on the top contact number
                      Then User should be redirected to the Contact Us page
