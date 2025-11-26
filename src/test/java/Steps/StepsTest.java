package Steps;

import Pages.CatalogPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SpecialsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Steps.Hooks.driver;

public class StepsTest {

    HomePage home = new HomePage(driver);
    CatalogPage catalog = new CatalogPage(driver);
    ProductPage product = new ProductPage(driver);
    SpecialsPage specials = new SpecialsPage(driver);

    // -------- Home Page --------
    @Given("the user is on the home page")
    public void the_user_is_on_home_page() {
        driver.get("https://demo.opencart.com/en-gb?route=common/home");
    }

    // -------- Catalog Page --------
    @When("the user navigates to the Desktops category")
    public void the_user_navigates_to_category() {
        home.openCategory("Desktops");
    }

    @When("the user selects the Mac subcategory")
    public void the_user_selects_subcategory() {
        home.clickSubCategory("Mac");
    }

    @Then("the catalog page should display the available products")
    public void the_catalog_page_should_display_products() {
        catalog.checkProductsDisplayed();
    }

    @Then("each product should be visible with its name and price")
    public void each_product_should_be_visible() {
        catalog.verifyProductsHaveNameAndPrice();
    }

    // -------- HTC Touch HD Product Page --------
    @When("the user searches for {string}")
    public void the_user_searches_for(String productName) {
        home.search(productName);
    }

    @When("the user opens the HTC Touch HD product page")
    public void the_user_opens_htc_touch_hd_page() {
        home.openProductFromResults("HTC Touch HD");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(product.getProductTitleElement()));
    }

    @Then("the product title should be displayed as {string}")
    public void the_product_title_should_be_displayed(String expectedTitle) {
        product.verifyProductTitle(expectedTitle);
    }

    @Then("the product price should be visible")
    public void the_product_price_should_be_visible() {
        product.verifyProductPrice();
    }

    @Then("the Add to Cart button should be displayed")
    public void the_add_to_cart_button_should_be_displayed() {
        product.verifyAddToCartVisible();
    }

    // -------- Add to Cart --------
    @Given("the user is on the HTC Touch HD product page")
    public void the_user_is_on_the_htc_touch_hd_product_page() {
        home.search("HTC Touch HD");
        home.openProductFromResults("HTC Touch HD");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(product.getProductTitleElement()));
    }

    @When("the user clicks on the Add to Cart button")
    public void the_user_clicks_add_to_cart() {
        product.clickAddToCart();
    }

    @Then("the product should be added to the cart successfully")
    public void the_product_should_be_added_to_cart() {
        Assert.assertTrue(product.isCartSuccessMessageDisplayed(), "Product not added to cart!");
    }

    @Then("a success message should appear confirming the add to cart action")
    public void a_success_message_should_appear() {
        Assert.assertTrue(product.isCartSuccessMessageDisplayed(), "Success message not displayed!");
    }

    // -------- Specials Page --------
    @When("the user navigates to the Specials page")
    public void the_user_navigates_to_specials_page() {
        home.openSpecialsPage();
    }

    @Then("the page should display products with special discounted prices")
    public void the_specials_page_should_display_discounted_products() {
        specials.verifyDiscountedProductsDisplayed();
    }

    @Then("the old price and new price should be clearly shown for discounted items")
    public void the_old_and_new_prices_should_be_visible() {
        specials.verifyOldAndNewPrices();
    }
}
