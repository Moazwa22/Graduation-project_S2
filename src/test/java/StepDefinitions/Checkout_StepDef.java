package StepDefinitions;

import Pages.CheckOut.CheckOutPage;
import Pages.MyAccount.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Checkout_StepDef {

    CheckOutPage checkoutPage;
    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("user in checkout page")
    public void goToCheckoutPage(){
        checkoutPage = loginPage.checkout();
        Assert.assertEquals(checkoutPage.checkoutPageActualTitle(),checkoutPage.checkoutPageExpectedTitle(),"Checkout page title does not match");
    }


    @When("user selects 'I want to enter a new address'")
    public void userSelects() {
        if(checkoutPage.oldAddressExists()) {
            checkoutPage.useNewAddress();
        }
    }

    @Then("enters all information correctly")
    public void entersAllInformationCorrectly(/*String firstName, String lastName, String company, String addressOne, String addressTwo, String City, String postcode, String country, String region*/) throws Exception {
        checkoutPage.enterFirstName("abdo");
        checkoutPage.enterLastName("tebry");
        checkoutPage.enterAddressOne("nasr");
        checkoutPage.enterAddressTwo("nasr 2");
        checkoutPage.enterCompany("depi");
        checkoutPage.enterCity("Cairo");
        checkoutPage.selectCountry("Egypt");
        checkoutPage.selectRegion("Asyut");
        checkoutPage.enterPostCode("12232");
    }

    @And("user presses continue button")
    public void userPressesContinueButton() throws InterruptedException {
        checkoutPage.continueButton();
    }

    @Then("a successful alert message should appear")
    public void aSuccessfulAlertMessageShouldAppear() {
        Assert.assertTrue(checkoutPage.successfulAddressAdded().contains(checkoutPage.successfulAddressAdded()),"Alert message does not match");
    }

    @And("a payment method")
    public void aPaymentMethod() {
        checkoutPage.payCashOnDelivery();
        Assert.assertTrue(checkoutPage.alertMessage().contains(checkoutPage.getPaymentMethodConfirmationAlertMessage()));
    }

    @And("{string} if user wants")
    public void commentIfUserWants(String arg0) {
        checkoutPage.enterComment(arg0);
    }

    @Then("Confirm order")
    public void confirmOrder() {
        checkoutPage.confirmCheckout();
        Assert.assertEquals(checkoutPage.getActualSuccessfulOrderPlacedMessage(),checkoutPage.getExpectedSuccessfulOrderPlacedMessage(),"The page title does not match");
    }

    @And("user should choose a {string}")
    public void userShouldChooseShippingRate(String arg0) throws InterruptedException {
        if(arg0.equals("Flat Shipping Rate")) {
            checkoutPage.selectFlatShippingRate();
        }
        else
            checkoutPage.selectFreeShipping();
        Assert.assertTrue(checkoutPage.alertMessage().contains(checkoutPage.getShippingConfirmationAlertMessage()));
    }

    @When("user selects 'I want to use an existing address'")
    public void userSelectsIWantToUseAnExistingAddress() {
        if (checkoutPage.oldAddressExists()) {
            checkoutPage.useOldAddress();
        }
    }

    @Then("address is {string}")
    public void addressIs(String arg0) throws Exception {
        checkoutPage.chooseAnAlreadyExistingAddress(arg0);
        Assert.assertTrue(checkoutPage.alertMessage().contains(checkoutPage.successfulAddressAdded()));
    }

    @Then("the user leaves all required fields empty")
    public void theUserLeavesAllRequiredFieldsEmpty() throws Exception {
        checkoutPage.enterFirstName("");
        checkoutPage.enterLastName("");
        checkoutPage.enterAddressOne("");
        checkoutPage.enterCity("");
        checkoutPage.enterPostCode("");
    }

    @Then("validation error messages should be shown for all required fields")
    public void validationErrorMessagesShouldBeShownForAllRequiredFields() {
        Assert.assertEquals(checkoutPage.getActualFirstNameErrorMessage(),checkoutPage.getExpectedFirstNameErrorMessage(),"Error message is correctly displayed");
        Assert.assertEquals(checkoutPage.getActualLastNameErrorMessage(), checkoutPage.getExpectedLastNameErrorMessage(), "Error message is correctly displayed for Last Name");
        Assert.assertEquals(checkoutPage.getActualAddressOneErrorMessage(), checkoutPage.getExpectedAddressOneErrorMessage(), "Error message is correctly displayed for Address Line 1");
        Assert.assertEquals(checkoutPage.getActualCountryErrorMessage(), checkoutPage.getExpectedCountryErrorMessage(), "Error message is correctly displayed for Country");
        Assert.assertEquals(checkoutPage.getActualCityErrorMessage(), checkoutPage.getExpectedCityErrorMessage(), "Error message is correctly displayed for City");
        Assert.assertEquals(checkoutPage.getActualRegionErrorMessage(), checkoutPage.getExpectedRegionErrorMessage(), "Error message is correctly displayed for Region/State");
        Assert.assertEquals(checkoutPage.getActualPostcodeErrorMessage(), checkoutPage.getExpectedPostcodeErrorMessage(), "Error message is correctly displayed for Postcode");
    }
}