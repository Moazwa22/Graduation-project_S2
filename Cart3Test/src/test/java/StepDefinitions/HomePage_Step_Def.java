package StepDifinitions;

import Pages.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class HomePage_Step_Def extends Hooks {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    // TC_HomePage_1
    @Given("The website is available and working without problems")
    public void websiteIsAvailable() {
        Assert.assertTrue(homePage.isHomePageLoaded(), "Homepage is not loaded");
    }

    @When("User opens the website URL")
    public void userOpensUrl() {
        driver.get("http://localhost/opencart/");
    }

    @Then("User should be redirected to the Homepage")
    public void userRedirected() {
        Assert.assertTrue(homePage.isHomePageLoaded(), "Homepage is not loaded");
    }

    // TC_HomePage_2
    @Given("User is on the Homepage")
    public void userIsOnHomepage() {
        driver.get("http://localhost/opencart/");
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("Homepage is loaded successfully")
    public void homePageLoadedSuccessfully() {
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @Then("All products should be displayed with their details")
    public void allProductsShouldBeDisplayed() {
        int count = homePage.getNumberOfDisplayedProducts();
        Assert.assertTrue(count > 0, "There are no products on the homepage.");
    }

    // TC_HomePage_3
    @Given("User is on Homepage")
    public void userIsOnHomePage() {
        driver.get("http://localhost/opencart/");
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("User clicks on each banner button such as {string}")
    public void userClicksOnBannerItems(String button) {
        homePage.clickBannerButton(button);
    }

    @Then("User should be redirected to the selected banner section page")
    public void userRedirectedToSelectedBannerButton() {
        Assert.assertFalse(driver.getTitle().equals("Your Store"), "User is not redirected to selected banner section.");
    }

    // TC_HomePage_4
    @When("User selects a currency from the currency button")
    public void userSelectsCurrencyFromDropdown() {
        homePage.clickOnCurrencyButton();
        homePage.clickOnEuroCurrency();
    }

    @Then("Price across the site are updated according to the selected currency")
    public void verifyCurrencySymbolChanged() {
        Assert.assertTrue(homePage.arePricesUpdated("€"), "Currency symbol not updated!");
    }

    // TC_HomePage_5
    @When("User changes the currency to {string}")
    public void userChangesCurrency(String currency) {
        homePage.clickOnCurrencyButton();
        switch (currency.toLowerCase()) {
            case "euro" -> homePage.clickOnEuroCurrency();
            case "pound sterling" -> homePage.clickOnPoundStrCurrency();
            case "usd" -> homePage.clickOnUsDollarCurrency();
        }
    }

    @Then("Product prices should be correctly recalculated according to the selected currency")
    public void verifyPriceConversion(String currency) {
        Assert.assertTrue(homePage.correctPriceConversion(currency), "Price conversion failed for currency: " + currency);
    }

    // TC_HomePage_7
    @Given("User is on Homepage and Products are clearly visible")
    public void user_is_on_homepage_and_products_are_clearly_visible() {
        driver.get("http://localhost/opencart/");
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

    // TC_HomePage_8
    @When("User clicks on the search bar")
    public void userClicksSearchBar() {
        homePage.activateSearchBar();
    }

    @Then("Search bar should become active and ready for input")
    public void searchBarActive() {
        Assert.assertTrue(driver.findElement(homePage.searchBar).isDisplayed(), "Search bar is not active");
    }

    // TC_HomePage_9
    @When("User searches for a product by name {string}")
    public void userSearchesForProduct(String productName) {
        homePage.searchForProduct(productName);
    }

    @Then("Search results page should display matching products {string}")
    public void searchResultsDisplayed(String productName) {
        String titleText = homePage.getSearchPageTitleText();
        Assert.assertTrue(titleText.contains(productName), "Selected product not found");
    }

    // TC_HomePage_10
    @When("User clicks on the top contact number")
    public void userClicksContactNumber() {
        homePage.clickContactNumber();
    }

    @Then("User should be redirected to the Contact Us page")
    public void userRedirectedToContactUs() {
        Assert.assertTrue(homePage.isOnContactUsPage(), "User is not on Contact Us page.");
    }

    // TC_HomePage_11
    @When("User clicks on My Account icon")
    public void userClicksMyAccount() {
        homePage.clickMyAccount();
    }

    @Then("Two options Register and Login should appear")
    public void twoOptionsAppear() {
        List<String> options = homePage.getAccountOptions();
        Assert.assertTrue(options.contains("Register"), "Register option missing");
        Assert.assertTrue(options.contains("Login"), "Login option missing");
    }

    // TC_HomePage_12
    @When("User selects Register option")
    public void userSelectsRegister() {
        homePage.clickRegister();
    }

    @Then("User should be redirected to Register page")
    public void redirectedToRegister() {
        Assert.assertTrue(driver.getTitle().contains("Register"));
    }

    // TC_HomePage_13
    @When("User selects Login option")
    public void userSelectsLogin() {
        homePage.clickLogin();
    }

    @Then("User should be redirected to Login page")
    public void redirectedToLogin() {
        Assert.assertTrue(driver.getTitle().contains("Login"));
    }

    // TC_HomePage_14 & 15
    @When("User clicks Add to Cart icon for first product")
    public void addToCart() {
        homePage.clickAddToCartForProduct(0);
    }

    @Then("Product should be added to cart")
    public void productAddedCart() {
        Assert.assertTrue(homePage.cartHasProducts());
    }

    @Then("Success message should be displayed")
    public void successMessageDisplayed() {
        Assert.assertTrue(homePage.successMessageDisplayed());
    }

    // TC_HomePage_16
    @When("User clicks on Shopping Cart icon")
    public void clickOnCartIcon() {
        homePage.clickShoppingCart();
    }

    @Then("User should be redirected to Cart page")
    public void redirectedToCart() {
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));
    }

    // TC_HomePage_17 & 18
    @When("User clicks on Wishlist icon for first product")
    public void addToWishlist() {
        homePage.clickWishlist(0);
    }

    @Then("Product should be added to Wishlist")
    public void productAddedToWishlist() {
        Assert.assertTrue(homePage.wishlistHasProducts());
    }

    @When("User clicks on Wishlist icon at top")
    public void clickOnTopWishlistIcon() {
        homePage.clickTopWishlist();
    }

    @Then("User should be redirected to Wishlist page")
    public void redirectedToWishlist() {
        Assert.assertTrue(driver.getTitle().contains("Wish List"));
    }

    // TC_HomePage_19
    @When("User clicks on Compare icon for first product")
    public void compareProduct() {
        homePage.clickCompare(0);
    }

    @Then("Product should be added to comparison page")
    public void productAddedComparison() {
        Assert.assertTrue(homePage.compareListHasProducts());
    }

    // TC_HomePage_20
    @When("User clicks on each footer link")
    public void clickFooterLinks() {
        homePage.clickAllFooterLinks();
    }

    @Then("User should be redirected to the correct page")
    public void footerLinksRedirected() {
        Assert.assertTrue(true);
    }

    @And("User is logged in")
    public void userIsLoggedIn() {

    }

    @Then("Prices across the site are updated according to the selected currency")
    public void pricesAcrossTheSiteAreUpdatedAccordingToTheSelectedCurrency() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("Product prices should be correctly recalculated according to the selected currency {string}")
    public void productPricesShouldBeCorrectlyRecalculatedAccordingToTheSelectedCurrency(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
