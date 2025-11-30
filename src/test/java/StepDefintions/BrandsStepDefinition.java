
package StepDefintions;

import Pages.BrandsPage;
import Pages.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class BrandsStepDefinition {

    BrandsPage brandsPage = new BrandsPage(Hooks.driver);

    //TC_BrandPage_1
    @Given("Homepage is loaded successfully before user redirected to brands page")
    public void homepageIsLoadedSuccessfullyBeforeUserRedirectedToBrandsPage() {
      brandsPage.userIsOnHomePage();
    }
    @When("User clicks on Brands link")
    public void userClicksOnBrandsLink() {
        brandsPage.clickOnBrandsLink();
    }

    @Then("Brands page should be displayed")
    public void brandsPageShouldBeDisplayed() {
        Assert.assertTrue(brandsPage.isBrandsPageDisplayed(), "Brands page is NOT displayed!");
    }

    @Given("Brands page is opened")
    public void brandsPageIsOpened() {
        brandsPage.clickOnBrandsLink();
        Assert.assertTrue(brandsPage.isBrandsPageDisplayed());
    }

    @When("User clicks on alphabet letter {string}")
    public void userClicksOnAlphabetLetter(String letter) {
        brandsPage.clickOnAlphabetLetter(letter);
    }

    @Then("Page should scroll to brands starting with {string}")
    public void pageShouldScrollToBrandsStartingWith(String letter) {
        Assert.assertTrue(brandsPage.hasScrolledToLetter(letter), "Page did not scroll to the correct section!");
    }

    @When("User clicks on brand {string}")
    public void userClicksOnBrand(String brandName) {
        brandsPage.clickOnBrand();
    }

    @Then("User should be redirected to Apple products page")
    public void userShouldBeRedirectedToAppleProductsPage() {
        Assert.assertTrue(brandsPage.isBrandProductsPage("Apple"), "User is NOT on Apple product list page!");
    }

}

