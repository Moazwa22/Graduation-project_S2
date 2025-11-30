package StepDefintions;

import Pages.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage_Step_Def {

// TC_HomePage_1

    // @Given("The website is available")
    //public void websiteIsAvailable_STD(){
    //HomePage homePage = new HomePage(Hooks.driver);
    //   Assert.assertTrue(homePage.websiteIsAvailable_HP(),"Website is not available.");
    //}

    @When("User opens the website URL")
    public void userOpensURL_STD() {
        HomePage homePage = new HomePage(Hooks.driver);
    }

    @Then("User should be redirected to the Homepage")
    public void userIsOnHomePage_STD_TC1() {
        HomePage homePage = new HomePage(Hooks.driver);
        homePage.isHomePageLoaded_HP();
        Assert.assertTrue(homePage.isHomePageLoaded_HP(), "User Is not in homepage.");
    }


    //TC_HomePage_2
    @Given("User is on the Homepage")
    public void userIsOnHomepage2() {
        HomePage homePage2 = new HomePage(Hooks.driver);
        Assert.assertTrue(homePage2.isHomePageLoaded_HP(), "User Is not in homepage.");
    }

    @When("User scrolls down to see products")
    public void user_scrolls_down_a_little() {
        HomePage H2 = new HomePage(Hooks.driver);
        H2.scrollDownSmall();
    }

    @Then("All products should be displayed with their details")
    public void allProductsShouldBeDisplayed() {
        HomePage H2 = new HomePage(Hooks.driver);
        int count = H2.getNumberOfDisplayedProducts();
        Assert.assertTrue(count > 0, "There is no products in homepage.");
    }

    //TC_HomePage_3
    // @Given("User is on Homepage")
    //  public void userIsOnHomePageCR() {
    //      HomePage H3 = new HomePage(Hooks.driver);
    //   Assert.assertTrue(H3.isHomePageLoaded_HP());
    //  }

    @When("User clicks on banner button {string}")
    public void userClicksOnBannerItems(String button) {
        HomePage H3 = new HomePage(Hooks.driver);
        H3.clickBannerButton(button);
    }

    @Then("User should be redirected to the selected banner section page")
    public void userRedirectedToSelectedBannerButton() {
        HomePage H3 = new HomePage(Hooks.driver);
        Assert.assertFalse(H3.isHomePageLoaded_HP(), "User is not redirected to selected banner button.");
    }

    //TC_HomePage_4
    @Given("User is on Homepage")
    public void userIsOnHomePage4() {
        HomePage H4 = new HomePage(Hooks.driver);
        Assert.assertTrue(H4.isHomePageLoaded_HP(), "User is not in Home Page.");
    }

    @When("User selects currency {string}")
    public void userSelectsCurrencyFromDropdown(String currency) {
        HomePage H4 = new HomePage(Hooks.driver);
        H4.clickOnCurrencyButton();
        switch (currency.toLowerCase()) {
            case "euro":
                H4.clickOnEuroCurrency();
                break;
            case "pound sterling":
                H4.clickOnPoundStrCurrency();
                break;
            case "us dollar":
            case "usd":
                H4.clickOnUsDollarCurrency();
                break;
        }
    }

    @Then("Prices across the site are updated according to the selected currency {string}")
    public void verifyCurrencySymbolChanged(String currency) {
        HomePage H4 = new HomePage(Hooks.driver);
        String symbol = "$";
        switch (currency.toLowerCase()) {
            case "euro":
                symbol = "€";
                break;
            case "pound sterling":
                symbol = "£";
                break;
            case "usd":
                symbol = "$";
                break;
        }
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(H4.P_Prices, symbol));
        Assert.assertTrue(H4.arePricesUpdated(symbol), "Currency symbol not updated!");
    }


    //TC_HomePage_5
    double[] basePrices;

    @Given("User is on homepage")
    public void userIsOnHomePage5() {
        HomePage H5 = new HomePage(Hooks.driver);
        Assert.assertTrue(H5.isHomePageLoaded_HP());
        basePrices = H5.getPrices();
    }

    @When("User changes the currency to {string}")
    public void userChangesCurrency(String currency) {
        HomePage H4 = new HomePage(Hooks.driver);
        H4.clickOnCurrencyButton();

        String symbol = "";
        switch (currency.toLowerCase()) {
            case "€ euro":
            case "euro":
                H4.clickOnEuroCurrency();
                symbol = "€";
                break;

            case "£ pound sterling":
            case "pound sterling":
                H4.clickOnPoundStrCurrency();
                symbol = "£";
                break;

            case "$ us dollar":
            case "us dollar":
            case "usd":
                H4.clickOnUsDollarCurrency();
                symbol = "$";
                break;
        }

        H4.scrollDownSmall();
        Assert.assertTrue(H4.waitForCurrencyToUpdate(symbol),
                "Currency did NOT update on the UI! Expected symbol: " + symbol);
    }


    @Then("Product prices should be correctly recalculated according to the selected currency {string}")
    public void verifyConversion(String currency) {

        HomePage H = new HomePage(Hooks.driver);

        double exchangeRate = 1.0;
        if (currency.contains("Euro"))
            exchangeRate = 0.86;
        if (currency.contains("Pound"))
            exchangeRate = 0.85;

        double[] newPrices = H.getPrices();

        for (int i = 0; i < newPrices.length; i++) {
            double expected = basePrices[i] * exchangeRate;

            Assert.assertTrue(Math.abs(newPrices[i] - expected) <= 0.5, "Price mismatch! product " + (i + 1) + " expected = " + expected + " but found = " + newPrices[i]);
        }
    }

    //  TC_HomePage_7
    @Given("User is on Homepage and Products are clearly visible")
    public void userIson_homepage_and_products_are_clearly_visible() {
        HomePage H7 = new HomePage(Hooks.driver);
        Assert.assertTrue(H7.isHomePageLoaded_HP());
        H7.scrollDownSmall();
        Assert.assertTrue(H7.findProducts(), "user can not find products in the homepage.");
    }

    @When("User clicks on a product")
    public void userClicksOnProduct() {
        HomePage H7 = new HomePage(Hooks.driver);
        H7.scrollDownSmall();
        H7.clickOnProduct(0);
    }

    @Then("User should be redirected to the product detail page")
    public void userRedirectedToProductPage() {
        By homePageLocator7 = By.id("carousel-banner-0");
        Assert.assertFalse(Hooks.driver.findElements(homePageLocator7).size() > 0, "User is still on the homepage!");
    }

    // TC_HomePage_8
    @Given("User is on homepage before clicking on search bar")
    public void userIsOnHomePageWhileClickingOnSearchBar() {
        HomePage H8 = new HomePage(Hooks.driver);
        Assert.assertTrue(H8.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on the search bar")
    public void userClicksSearchBar() {
        HomePage H8 = new HomePage(Hooks.driver);
        H8.activeSearchbar();
    }

    @Then("Search bar should become active and ready for input")
    public void searchBarActive() {
        HomePage H8 = new HomePage(Hooks.driver);
        Assert.assertTrue(Hooks.driver.findElement(H8.searchBar).isDisplayed(), "Search bar is not active");
    }

    //TC_HomePage_9
    @Given("User is on the Homepage before searching")
    public void userIsOnHomePage9() {
        HomePage H9 = new HomePage(Hooks.driver);
        Assert.assertTrue(H9.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User searches for a product by {string}")
    public void userSearchesForProduct(String productName) {
        HomePage H9 = new HomePage(Hooks.driver);
        H9.searchForProduct(productName);
    }

    @Then("Search results page should display matching products")
    public void searchResultsDisplayed() {
        HomePage H9 = new HomePage(Hooks.driver);
        String titleText = H9.getSearchPageTitleText();
        Assert.assertTrue(titleText.contains("MacBook"), " Selected product not found");
    }

    //TC_HomePage_10
    @Given("User is on the Homepage before clicking on contact us icon")
    public void userIsOnHomePage10() {
        HomePage H10 = new HomePage(Hooks.driver);
        Assert.assertTrue(H10.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on the top contact number")
    public void userClicksContactNumber() {
        HomePage H10 = new HomePage(Hooks.driver);
        H10.clickContactNumber();
    }

    @Then("User should be redirected to the Contact Us page")
    public void userRedirectedToContactUs() {
        HomePage H10 = new HomePage(Hooks.driver);
        Assert.assertTrue(H10.isOnContactUsPage(), "User is not on Contact Us page.");
    }

    //TC_HomePage_11
    @Given("User is on the Homepage before clicking on my account icon")
    public void userIsOnHomePage11() {
        HomePage H11 = new HomePage(Hooks.driver);
        Assert.assertTrue(H11.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on My Account icon")
    public void user_clicks_my_account() {
        HomePage H11 = new HomePage(Hooks.driver);
        H11.clickMyAccount();
    }

    @Then("Two options Register and Login should appears {string} , {string}")
    public void two_options_appear(String Register, String Login) {
        HomePage H11 = new HomePage(Hooks.driver);
        Assert.assertTrue(H11.RegisterOptionIsVisible(), "Register is not available");
        Assert.assertTrue(H11.LoginOptionIsVisible(), "Login is not available");
    }

    //TC_HomePage_12
    @Given("User is on the Homepage before selects My Account and register")
    public void userIsOnHomePage12() {
        HomePage H12 = new HomePage(Hooks.driver);
        Assert.assertTrue(H12.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @And("User selects Register option")
    public void userSelectsRegister() {
        HomePage H12 = new HomePage(Hooks.driver);
        H12.clickRegister();
    }

    @Then("User should be redirected to Register page")
    public void redirectedToRegister() {
        HomePage H12 = new HomePage(Hooks.driver);
        Assert.assertTrue(H12.userIsOnRegisterPage(), "User is still in homepage.");
    }

    //TC_HomePage_13
    @Given("User is on the Homepage before selects My Account and Login")
    public void userIsOnHomePage13() {
        HomePage H13 = new HomePage(Hooks.driver);
        Assert.assertTrue(H13.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on My Account icon for login")
    public void userClicksOnMyAccount() {
        HomePage H13 = new HomePage(Hooks.driver);
        H13.clickMyAccount();
    }

    @And("User selects Login option")
    public void userSelectsLogin() {
        HomePage H13 = new HomePage(Hooks.driver);
        H13.clickLogin();
    }

    @Then("User should be redirected to Login page")
    public void redirectedToLogInPage() {
        HomePage H13 = new HomePage(Hooks.driver);
        Assert.assertTrue(H13.userIsOnLogInPage(), "User is still in homepage.");
    }

    //TC_HomePage_14

    @Given("User is on the Homepage before clicking on add to cart")
    public void userIsOnHomePage14() {
        HomePage H14 = new HomePage(Hooks.driver);
        Assert.assertTrue(H14.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks Add to Cart icon for first product")
    public void addToCart() {
        HomePage H14 = new HomePage(Hooks.driver);
        H14.scrollDownSmall();

        List<WebElement> buttons = Hooks.driver.findElements(H14.addToCartButtons);

        for (WebElement btn : buttons) {
            WebElement button = Hooks.driver.findElements(H14.addToCartButtons).stream().filter(b -> b.equals(btn)).findFirst().orElseThrow();
            ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
            Assert.assertTrue(H14.successMessageDisplayed(), "No success message displayed for this product");
        }
    }

    @Then("Success message is displayed after click add to cart")
    public void productShouldBeAddedToCart() {
        HomePage H14 = new HomePage(Hooks.driver);
        Assert.assertTrue(H14.successMessageDisplayed(), "No success message for product at index ");
    }

    //TC_HomePage_16
    @Given("User is on the Homepage before user click on cart icon")
    public void userIsOnHomePage16() {
        HomePage H14 = new HomePage(Hooks.driver);
        Assert.assertTrue(H14.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on Shopping Cart icon")
    public void clickOnCartIcon() {
        HomePage H16 = new HomePage(Hooks.driver);
        H16.clickShoppingCart();
    }

    @Then("User should be redirected to Cart page")
    public void userShouldBeRedirectedToCartPage() {
        Assert.assertTrue(Hooks.driver.getTitle().contains("Shopping Cart"));
    }

    //TC_HomePage_17
    @Given("User is on the Homepage before add product to wishlist")
    public void userIsOnHomePage17() {
        HomePage H17 = new HomePage(Hooks.driver);
        Assert.assertTrue(H17.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @And("User is logged in with {string} and {string}")
    public void userIsLoggedIn(String E_MailAddress , String password){
    HomePage H17 = new HomePage(Hooks.driver);
        Assert.assertTrue(H17.verifyUserIsOnLogInPage(),"User is not logged in.");
        Assert.assertTrue(H17.userIsLoggedIn(E_MailAddress,password),"User is not logged in.");
        H17.goToHomePage();
    }

    @When("User clicks on Wishlist icon for first product")
    public void addToWishlist() {
        HomePage H17 = new HomePage(Hooks.driver);
        H17.clickWishListButtonAtProduct();
    }

    @Then("Product should be added to Wishlist")
    public void productAddedToWishlist() {
        HomePage H17 = new HomePage(Hooks.driver);
        Assert.assertTrue(H17.wishlistHasProducts(),"Product is not added to wishlist.");
    }

    //TC_HomePage_18
    @Given("User is on the Homepage before wishlist redirection")
    public void userIsOnHomePage18() {
        HomePage H17 = new HomePage(Hooks.driver);
        Assert.assertTrue(H17.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on Wishlist icon at top")
    public void clickOnTopWishlistIcon() {
        HomePage H18 = new HomePage(Hooks.driver);
        H18.clickWishlistAtTheTop();
    }

    @Then("User should be redirected to Wishlist page")
    public void redirectedToWishlist() {
        HomePage H18 = new HomePage(Hooks.driver);
        Assert.assertTrue(H18.userIsRedirectedToWishlistPage(),"User is not redirected to wishlist page");
    }

    //TC_HomePage_19
    @Given("User is on the Homepage before comparing")
    public void userIsOnHomePage19() {
        HomePage H17 = new HomePage(Hooks.driver);
        Assert.assertTrue(H17.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on Compare icon for first product")
    public void compareProduct() {
        HomePage H17 = new HomePage(Hooks.driver);
        H17.scrollDownSmall();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Hooks.driver.findElements(H17.compareButtons).get(0)));

        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(H17.successAlert));
        Assert.assertTrue(H17.compareListHasProducts(), "No success message displayed for this product");
    }

    @Then("Product should be added to comparison page")
    public void productAddedComparison() {
        HomePage H19 = new HomePage(Hooks.driver);
        Assert.assertTrue(H19.compareListHasProducts());
    }

    @Given("User is on the Homepage before clicking on footer links")
    public void userIsOnHomePage20() {
        HomePage H20 = new HomePage(Hooks.driver);
        Assert.assertTrue(H20.isHomePageLoaded_HP(), "User is not in HomePage");
    }

    @When("User clicks on each footer link")
    public void clickOnAllFooterLinks() {
        HomePage H20 = new HomePage(Hooks.driver);
        H20.clickAllFooterLinks();
    }

    @Then("User should be redirected to the correct page")
    public void redirectedFooterPages() {
        Assert.assertTrue(Hooks.driver.getTitle().length() > 0);
    }

}




/*

    @When("User clicks on each banner button such as {string}")
    public void userClicksOnBannerItems(String button) {
        homePage.clickBannerButton(button);
    }

    @Then("User should be redirected to the selected banner section page")
    public void userRedirectedToSelectedBannerButton() {
        Assert.assertFalse(driver.getTitle().equals("Your store"), "User is not redirected to selected banner button.");
    }

    TC_HomePage_4
     @Given("User is on Homepage")
  public void userIsOnHomePage() {
     driver.get("http://localhost/opencart/");
    homePage = new HomePage(driver);
    Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("User selects a currency from the currency button")
    public void userSelectsCurrencyFromDropdown() {
        homePage.clickOnCurrencyButton();
        homePage.clickOnEuroCurrency();
    }

    @Then("Price across the site are updated according to the selected currency")
    public void verifyCurrencySymbolChanged(String currency) {
        String symbol = "$";
        switch (currency.toLowerCase()) {
            case "euro":
                symbol = "€";
                break;
            case "pound sterling":
                symbol = "£";
                break;
            case "usd":
                symbol = "$";
                break;
        }
        Assert.assertTrue(homePage.arePricesUpdated(symbol), "Currency symbol not updated!");
    }

    //TC_HomePage_5

    // @Given("User is on homepage")
    // public void userIsOnHomePage() {
    // driver.get("http://localhost/opencart/");
    //    homePage = new HomePage(driver);
    //   Assert.assertTrue(homePage.isHomePageLoaded());
    // }

    @When("User changes the currency to {string}")
    public void userChangesCurrency(String currency) {
        homePage.clickOnCurrencyButton();
        switch (currency.toLowerCase()) {
            case "euro":
                homePage.clickOnEuroCurrency();
                break;
            case "pound sterling":
                homePage.clickOnPoundStrCurrency();
                break;
            case "usd":
                homePage.clickOnUsDollarCurrency();
                break;
        }
    }

    @Then("Product prices should be correctly recalculated according to the selected currency {string}")
    public void verifyPriceConversion(String currency) {
        Assert.assertTrue(homePage.correctPriceConversion(currency), "Price conversion failed for currency: " + currency);
    }

    //  TC_HomePage_7
    @Given("User is on Homepage and Products are clearly visible")
    public void user_is_on_homepage_and_products_are_clearly_visible() {
        driver.get("https://example.com");
        Assert.assertTrue(homePage.isHomePageLoaded());
    }
    @When("User clicks on a product")
    public void userClicksOnProduct() {
        homePage.clickOnProduct(0);
    }

    @Then("User should be redirected to the product detail page")
    public void userRedirectedToProductPage() {
        Assert.assertFalse(driver.getTitle().equals("Your Store"), "User is not redirected to product page.");
    }

    //  TC_HomePage_8
    @When("User clicks on the search bar")
    public void userClicksSearchBar() {
        homePage.activeSearchbar();
    }

    @Then("Search bar should become active and ready for input")
    public void searchBarActive() {
        Assert.assertTrue(driver.findElement(homePage.searchBar).isDisplayed(), "Search bar is not active");
    }

    //TC_HomePage_9
    @When("User searches for a product by name")
    public void userSearchesForProduct(String productName) {
        homePage.searchForProduct(productName);
    }

    @Then("Search results page should display matching products")
    public void searchResultsDisplayed() {
        String titleText = homePage.getSearchPageTitleText();
        Assert.assertTrue(titleText.contains("MacBook"), " Selected product not found");
    }

    //TC_HomePage_10
    @When("User clicks on the top contact number")
    public void userClicksContactNumber() {
        homePage.clickContactNumber();
    }

    @Then("User should be redirected to the Contact Us page")
    public void userRedirectedToContactUs() {
        Assert.assertTrue(homePage.isOnContactUsPage(), "User is not on Contact Us page.");
    }

    //TC_HomePage_11
    @When("User clicks on My Account icon")
    public void user_clicks_my_account() {
        homePage.clickMyAccount();
    }

    @Then("Two options Register and Login should appear")
    public void two_options_appear(String register, String login) {
        Assert.assertTrue(homePage.getAccountOptions().contains(register));
        Assert.assertTrue(homePage.getAccountOptions().contains(login));
    }

    //TC_HomePage_12
    @When("User selects Register option")
    public void userSelectsRegister() {
        homePage.clickRegister();
    }

    @Then("User should be redirected to Register page")
    public void redirectedToRegister() {
        Assert.assertTrue(driver.getTitle().contains("Register"));
    }

    //TC_HomePage_13
    @When("User selects Login option")
    public void userSelectsLogin() {
        homePage.clickLogin();
    }

    //TC_HomePage_14
    @Then("User should be redirected to Login page")
    public void redirectedToLogin() {
        Assert.assertTrue(driver.getTitle().contains("Login"));
    }

    @When("User clicks Add to Cart icon for first product")
    public void addToCart() {
        homePage.clickAddToCartForProduct(0);
    }

    //TC_HomePage_15
    @Then("Product should be added to cart")
    public void productAddedCart() {
        Assert.assertTrue(homePage.cartHasProducts());
    }

    @Then("Success message should be displayed")
    public void successMessageDisplayed() {
        Assert.assertTrue(homePage.successMessageDisplayed());
    }

    //TC_HomePage_16
    @When("User clicks on Shopping Cart icon")
    public void clickOnCartIcon() {
        homePage.clickShoppingCart();
    }

    @Then("User should be redirected to Cart page")
    public void redirectedToCart() {
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
    }

    @When("User clicks on Wishlist icon for first product")
    public void addToWishlist() {
        homePage.wishListButtonAtProduct();
    }

    @Then("Product should be added to Wishlist")
    public void productAddedToWishlist() {
        Assert.assertTrue(homePage.wishlistHasProducts());
    }

    @When("User clicks on Wishlist icon at top")
    public void clickOnTopWishlistIcon() {
        homePage.clickWishlistAtTheTop();
    }

    @Then("User should be redirected to Wishlist page")
    public void redirectedToWishlist() {
        Assert.assertTrue(driver.getTitle().contains("Wish List"));
    }

    @When("User clicks on Compare icon for first product")
    public void compareProduct() {
        homePage.clickCompare(0);
    }

    @Then("Product should be added to comparison page")
    public void productAddedComparison() {
        Assert.assertTrue(homePage.compareListHasProducts());
    }

    @When("User clicks on each footer link")
    public void clickOnAllFooterLinks() {
        homePage.clickAllFooterLinks();
    }

    @Then("User should be redirected to the correct page")
    public void redirectedFooterPages() {
        Assert.assertTrue(driver.getTitle().length() > 0);
    }

    @And("User is logged in")
    public void userIsLoggedIn() {
    }*/



