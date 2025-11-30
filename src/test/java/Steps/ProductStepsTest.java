package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.testng.Assert;

import java.time.Duration;

import static Steps.Hooks.driver;

public class ProductStepsTest {


    HomePage home = new HomePage(driver);
    ProductPage product = new ProductPage(driver);
    LoginPage loginPage = new LoginPage(driver);


   /* @Given("the user is on the home page")
    public void the_user_is_on_home_page() {
        driver.get("http://localhost/opencartproject/index.php?route=common/home&language=en-gb");
    }*/

    @Given("the user is logged in")
    public void ensureUserIsLoggedIn() {
        if (!loginPage.isUserLoggedIn()) {

            // Go to login page manually (you had no method in HomePage)
            driver.get("http://localhost/opencartproject/index.php?route=account/login&language=en-gb");

            loginPage.enterEmail("test@test.com");
            loginPage.enterPassword("123456");
            loginPage.clickLogin();

            // LoginPage.clickLogin() already waits for login success
        }
    }

    /*@Given("the user is logged in")
    public void ensureUserIsLoggedIn() {
        loginPage.openLoginPage();

        String username = "test00@test.com";
        String password = "test00";

        loginPage.loginIfNotAlready(username, password);
    }*/

    @When("the user searches for {string}")
    public void theUserSearchesFor(String productName) {
        home.search(productName);
    }

    @When("the user opens the HTC Touch HD product page")
    public void theUserOpensHtcTouchHdPage() {
        home.search("HTC Touch HD");
        home.openProductFromResults("HTC Touch HD");
        //waitForVisibility(product.getProductTitleElement());
    }


    @Then("the product title should be displayed as {string}")
    public void theProductTitleShouldBeDisplayed(String expectedTitle) {
        product.verifyProductTitle(expectedTitle);
    }

    @Then("the product price should be visible")
    public void theProductPriceShouldBeVisible() {
        product.verifyProductPrice();
    }

    @Then("the Add to Cart button should be displayed")
    public void theAddToCartButtonShouldBeDisplayed() {
        product.clickAddToCart();
    }


    @When("the user clicks on the Add to Cart button")
    public void theUserClicksAddToCart() {
        product.clickAddToCart();
    }

    @Then("the product should be added to the cart successfully")
    public void theProductShouldBeAddedToCart() {
        Assert.assertTrue(product.isCartSuccessMessageDisplayed(), "Product not added to cart!");
    }

    @Then("a success message should appear confirming the add to cart action")
    public void aSuccessMessageShouldAppear() {
        Assert.assertTrue(product.isCartSuccessMessageDisplayed(), "Success message not displayed!");
    }


    @When("the user clicks the Add to Wishlist button")
    public void clickAddToWishlist() {
        //ensureUserIsLoggedIn();
        product.clickAddToWishlist();
    }

    @Then("the product should be added to the wishlist successfully")
    public void verifyWishlistSuccess() {
        Assert.assertTrue(product.isWishlistSuccessMessageDisplayed(), "Product was NOT added to wishlist!");
    }

    @Then("a success message should appear confirming the add to wishlist action")
    public void aSuccessMessageShouldAppearConfirmingTheAddToWishlistAction() {
        Assert.assertTrue(product.isWishlistSuccessMessageDisplayed(), "Wishlist success message not displayed!");
    }


    // Add to Compare
    @When("the user clicks the Add to Compare button")
    public void clickAddToCompare() {
        //ensureUserIsLoggedIn();
        product.clickAddToCompare();
    }

    @Then("the product should be added to the comparison list successfully")
    public void verifyCompareSuccess() {
        Assert.assertTrue(product.isCompareSuccessMessageDisplayed(), "Product was NOT added to comparison list!");
    }

    @Then("a success message should appear confirming the add to compare action")
    public void aSuccessMessageShouldAppearConfirmingTheAddToCompareAction() {
        Assert.assertTrue(product.isCompareSuccessMessageDisplayed(), "Compare success message not displayed!");
    }



}
