package StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage_Step_Def extends Hooks {

    HomePage homePage;

    //TC_HomePage_1
    @Given("The website is available and working without problems")
    public void websiteIsAvailable() {
        Assert.assertTrue(homePage.isHomePageLoaded(), "Homepage is not loaded");
    }

    @When("User opens the website URL")
    public void userOpensUrl() {
        driver.get("http://localhost/opencart/");
    }

    @Then("ser should be redirected to the Homepage")
    public void userRedirected() {
        Assert.assertTrue(homePage.isHomePageLoaded(), "Homepage is not loaded");
    }

    //TC_HomePage_2
    @Given("User is on the Homepage")
    public void userIsOnHomepage() {
        driver.get("http://localhost/opencart/");
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("Homepage is loaded successfully")
    public void homePageLoadedSuccessfully() {
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @Then("All products should be displayed with their details")
    public void allProductsShouldBeDisplayed() {
        int count = homePage.getNumberOfDisplayedProducts();
        Assert.assertTrue(count > 0, "There is no products in homepage.");
    }

    //TC_HomePage_3

    @Given("User is on Homepage")
    public void userIsOnHomePage() {
        driver.get("http://localhost/opencart/");
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("User clciks on each banner button such as Desktop, Components")
    public void userClicksOnBannerItems(String button) {
        homePage.clickBannerButton(button);
    }

    @Then("User should be redirected to the selected banner section page")
    public void userRedirectedToSelectedBannerButton() {
        Assert.assertFalse(driver.getTitle().equals("Your store"), "User is not redirected to selected banner button.");
    }

    //TC_HomePage_4
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

    @Then("Price accross the site are updated according to the selected currency {string}")
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
    @Given("User is on homepage")
    public void userIsOnHomePage() {
        driver.get("http://localhost/opencart/");
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("User changes the currency")
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

    @Then("Product prices should be correctly recalculated according to the selected currnecy")
    public void verifyPriceConversion(String currency) {
        Assert.assertTrue(homePage.correctPriceConversion(currency), "Price conversion failed for currency: " + currency);
    }

    //  TC_HomePage_7
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
    @When("User searches for a product by name ")
    public void userSearchesForProduct(String productName) {
        homePage.searchForProduct(productName);
    }

    @Then("Search results page should display matching products")
    public void searchResultsDisplayed() {
        homePage.searchForProduct("MacBook");
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

}

