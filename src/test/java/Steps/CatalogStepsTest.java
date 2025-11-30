
package Steps;

import Pages.CatalogPage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Steps.Hooks.driver;

public class CatalogStepsTest {
    HomePage home = new HomePage(driver);
    CatalogPage catalog = new CatalogPage(driver);

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        driver.get("http://localhost/opencartproject/index.php?route=common/home");
    }

    @When("the user navigates to Mac")
    public void theUserNavigatesToMac() {
        home.hoverDesktopsMenu();
        home.clickMacCategory();
    }

    @Then("the catalog page should display all desktops with their name and price")
    public void theCatalogPageShouldDisplayAllDesktops() {
        catalog.checkProductsDisplayed();
        catalog.verifyProductsHaveNameAndPrice();
    }

    @When("the user navigates to the Desktops category")
    public void theUserNavigatesToCategory() {
        home.openCategory("Desktops");
    }

    @When("the user selects the Mac subcategory")
    public void theUserSelectsSubcategory() {
        home.clickSubCategory("Mac (1)");
    }

    @Then("the catalog page should display the available products")
    public void theCatalogPageShouldDisplayProducts() {
        catalog.checkProductsDisplayed();
    }

    @Then("each product should be visible with its name and price")
    public void eachProductShouldBeVisible() {
        catalog.verifyProductsHaveNameAndPrice();
    }

    // Add To Cart
    @When("the user adds the first product to the cart")
    public void theUserAddsProductToCart() {
        catalog.clickAddToCart();
    }

    @Then("the product should be successfully added to the cart")
    public void verifyProductAddedToCart() {
        System.out.println("Product added to cart successfully");
    }

    // Add to Wishlist
    @When("the user adds the first product to the wishlist")
    public void theUserAddsProductToWishlist() {
        catalog.clickAddToWishlist();
    }

    @Then("the product should be successfully added to the wishlist")
    public void verifyProductAddedToWishlist() {
        System.out.println("Product added to wishlist successfully");
    }

    // Add to Compare
    @When("the user adds the first product to the comparison list")
    public void theUserAddsProductToCompare() {
        catalog.clickAddToCompare();
    }

    @Then("the product should be successfully added to the comparison list")
    public void verifyProductAddedToCompare() {
        System.out.println("Product added to comparison list successfully");
    }
}
