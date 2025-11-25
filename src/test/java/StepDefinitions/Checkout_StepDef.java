package StepDefinitions;

import Pages.CheckOut.CheckoutPage;
import Pages.HomePage.HomePage;
import Pages.LoginPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Checkout_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    CheckoutPage checkoutPage;
    LoginPage loginPage = new LoginPage(Hooks.driver);
    String alertMessage;

    @Given("user in checkout page")
    public void goToCheckoutPage(){
        checkoutPage = loginPage.checkout();
/*        Assert.assertEquals(checkoutPage.checkoutPageActualTitle(),checkoutPage.checkoutPageExpectedTitle(),"Checkout page title does not match");*/
    }


    @Then("user selects 'I want to enter a new address'")
    public void userSelects() {
        checkoutPage.useNewAddress();
    }

    @And("enters all information correctly")
    public void entersAllInformationCorrectly(/*String firstName, String lastName, String company, String addressOne, String addressTwo, String City, String postcode, String country, String region*/) throws Exception {
        checkoutPage.enterFirstName("abdo");
        checkoutPage.enterLastName("tebry");
        checkoutPage.enterAddressOne("nasr");
        checkoutPage.enterAddressTwo("nasr 2");
        checkoutPage.enterCompany("depi");
        checkoutPage.enterCity("Cairo");
        checkoutPage.selectCountry("Egypt");
        checkoutPage.selectRegion("Al Qahirah");
        checkoutPage.enterPostCode("12232");
    }

    @When("user presses continue button")
    public void userPressesContinueButton() {
        alertMessage = checkoutPage.continueButton();
    }

    @Then("a successful alert message should appear")
    public void aSuccessfulAlertMessageShouldAppear() {
        Assert.assertEquals(alertMessage,checkoutPage.successfulAddressAdded(),"Alert message does not match");
    }
}
