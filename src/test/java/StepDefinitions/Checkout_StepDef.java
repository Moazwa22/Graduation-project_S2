package StepDefinitions;

import Pages.CheckOut.CheckoutPage;
import Pages.HomePage.HomePage;
import Pages.LoginPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class Checkout_StepDef {

    CheckoutPage checkoutPage;
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
    public void userPressesContinueButton() {
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

    @Then("a validation message should appear for {string}")
    public void validationMessageShouldAppear(int cases) throws InterruptedException {
        Thread.sleep(1500);
        switch (cases) {

            case 1:
                Assert.assertEquals(checkoutPage.getActualFirstNameErrorMessage(), checkoutPage.getExpectedFirstNameErrorMessage(), "First name error is incorrect"
                );
                break;

            case 2:
                Assert.assertEquals(checkoutPage.getActualLastNameErrorMessage(), checkoutPage.getExpectedLastNameErrorMessage(), "Last name error is incorrect"
                );
                break;

            case 3:
                Assert.assertEquals(checkoutPage.getActualAddressOneErrorMessage(), checkoutPage.getExpectedAddressOneErrorMessage(), "Address Line 1 error is incorrect");
                break;

            case 4:
                Assert.assertEquals(checkoutPage.getActualCityErrorMessage(), checkoutPage.getExpectedCityErrorMessage(), "City error is incorrect");
                break;

            case 5:
                Assert.assertEquals(checkoutPage.getActualPostcodeErrorMessage(), checkoutPage.getExpectedPostcodeErrorMessage(), "Postcode error is incorrect");
                break;

            case 6:
                Assert.assertEquals(checkoutPage.getActualCountryErrorMessage(), checkoutPage.getExpectedCountryErrorMessage(), "Country error is incorrect");
                break;

            case 7:
                Assert.assertEquals(checkoutPage.getActualRegionErrorMessage(), checkoutPage.getExpectedRegionErrorMessage(), "Region/State error is incorrect");
                break;
            case 8:
                Assert.assertEquals(checkoutPage.getActualShippingErrorMessage(),checkoutPage.getExpectedShippingErrorMessage(),"Shipping error is incorrect");
                break;

                default:
                throw new IllegalArgumentException("Unknown field: " + cases);
        /*Assert.assertEquals(checkoutPage.getActualFirstNameErrorMessage(),checkoutPage.getExpectedFirstNameErrorMessage(),"Error message is incorrectly displayed");
        Assert.assertEquals(checkoutPage.getActualLastNameErrorMessage(), checkoutPage.getExpectedLastNameErrorMessage(), "Error message is incorrectly displayed for Last Name");
        Assert.assertEquals(checkoutPage.getActualAddressOneErrorMessage(), checkoutPage.getExpectedAddressOneErrorMessage(), "Error message is incorrectly displayed for Address Line 1");
        Assert.assertEquals(checkoutPage.getActualCountryErrorMessage(), checkoutPage.getExpectedCountryErrorMessage(), "Error message is incorrectly displayed for Country");
        Assert.assertEquals(checkoutPage.getActualCityErrorMessage(), checkoutPage.getExpectedCityErrorMessage(), "Error message is incorrectly displayed for City");
        Assert.assertEquals(checkoutPage.getActualRegionErrorMessage(), checkoutPage.getExpectedRegionErrorMessage(), "Error message is incorrectly displayed for Region/State");
        Assert.assertEquals(checkoutPage.getActualPostcodeErrorMessage(), checkoutPage.getExpectedPostcodeErrorMessage(), "Error message is incorrectly displayed for Postcode");*/
        }
    }

    @When("the user enters the following address data:")
    public void theUserEntersAddressData(io.cucumber.datatable.DataTable dataTable) throws Exception {

        Map<String, String> data = dataTable.asMap(String.class, String.class);

        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String address1 = data.get("address1");
        String city = data.get("city");
        String postcode = data.get("postcode");
        String country = data.get("country");
        String region = data.get("region");
        String shipping = data.get("shipping");
        String payment = data.get("payment");

        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterAddressOne(address1);
        checkoutPage.enterCity(city);
        checkoutPage.enterPostCode(postcode);

        if (!country.isEmpty()) {
            checkoutPage.selectCountry(country);
        }

        if (!region.isEmpty()) {
            checkoutPage.selectRegion(region);
        }

        if (!shipping.isEmpty()) {

            if (shipping.equals("Flat Shipping Rate")) {
                checkoutPage.selectFlatShippingRate();
            } else {
                checkoutPage.selectFreeShipping();
            }

            Assert.assertTrue(
                    checkoutPage.alertMessage()
                            .contains(checkoutPage.getShippingConfirmationAlertMessage())
            );
        }

        if (!payment.isEmpty()) {
            checkoutPage.payCashOnDelivery();
        }

    }
}
