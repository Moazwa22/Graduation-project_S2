package StepDefinitions;

import Pages.HomePage;
import Pages.SpecialsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static StepDefinitions.Hooks.driver;

public class SpecialsStepsTest {
    HomePage home = new HomePage(driver);
    SpecialsPage specials = new SpecialsPage(driver);

    @When("the user navigates to the Specials page")
    public void theUserNavigatesToSpecialsPage() {
        home.openSpecialsPage();
    }

    /*@Then("the page should display products with special discounted prices")
    public void theSpecialsPageShouldDisplayDiscountedProducts() {
        specials.verifyDiscountedProductsDisplayed();
    }

    @Then("the old price and new price should be clearly shown for discounted items")
    public void theOldAndNewPricesShouldBeVisible() {
        specials.verifyOldAndNewPrices();
    }*/
}