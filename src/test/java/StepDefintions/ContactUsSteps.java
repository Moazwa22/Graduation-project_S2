
package StepDefintions;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsSteps {

    ContactUsPage contactUsPage = new ContactUsPage(Hooks.driver);

    //TC_ContactUs_1
    @Given("Homepage is loaded successfully")
    public void homepageIsLoadedSuccessfully() {
        Assert.assertTrue(contactUsPage.isHomePageLoaded_HP(), "Homepage not loaded!");
    }

    @When("User clicks on Contact Us icon")
    public void userClicksOnContactUsIcon() {
        contactUsPage.clickOnContactUsIcon();
    }

    @Then("Contact Us page should be displayed")
    public void contactUsPageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    //TC_ContactUs_2
    @Given("Contact Us page is opened before check contact us details")
    public void contactUsPageIsOpen() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @Then("Contact Details should be displayed")
    public void contactDetailsShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.contactUsFieldsIsDisplayed(), "Contact Us fields are NOT displayed!");
    }

    // TC_ContactUs_3
    @Given("Contact Us page is opened before user try to enter valid data")
    public void contactUsPageIsOpen3() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User enters valid contact data")
    public void userEntersValidContact_data() {
        contactUsPage.enterValidData();
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
    contactUsPage.userClickOnSubmitButton();
    }

    @Then("Success ContactUs message should be displayed")
    public void successContactUsMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.successMessageIsDisplayed(), "Success Message NOT displayed!");
    }

    //TC_ContactUs_4
    @Given("Contact Us page is open before user submits wrong contact form")
    public void contactUsPageIsOpen4() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User submits empty contact form")
    public void userSubmitsEmptyContactForm() {
        contactUsPage.scrollDownSmall();
        contactUsPage.userClickOnSubmitButton();
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(contactUsPage.E_MailError));
    }

    @Then("Error messages should be displayed")
    public void errorMessagesShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.contactErrorMessageIsDisplayed(),"there is no error message");
    }

    // TC_ContactUs_5
    @Given("Contact Us page is open before user submits wrong email")
    public void contactUsPageIsOpen5() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User enters invalid email format")
    public void userEntersInvalidEmail() {
        contactUsPage.userEntersInvalidEmail();
        contactUsPage.userClickOnSubmitButton();
    }

    @Then("Email error message should be displayed")
    public void emailErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.E_MailErrorMessageIsDisplayed(),"There is no error message");
    }

    // TC_ContactUs_6
    @Given("Contact Us page is opened before user enter exceeded character limitation")
    public void contactUsPageIsOpen6() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User enters more than allowed characters in name field")
    public void user_enters_more_than_allowed_characters_in_name_field() {
        contactUsPage.userEntersInvalidName();
        contactUsPage.userClickOnSubmitButton();
    }

    @Then("Name error message should be displayed")
    public void name_error_message_should_be_displayed() {
        Assert.assertTrue(Hooks.driver.findElement(contactUsPage.nameErrorMessage).isDisplayed());
    }

    //TC_ContactUs_7
    @Given("Contact Us page is opened before user enter invalid enquiry")
    public void contactUsPageIsOpen7() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User enters more than allowed characters in enquiry field")
    public void user_enters_more_than_allowed_characters_in_enquiry_field() {
        contactUsPage.userEnterInvalidEnquiry();
        contactUsPage.userClickOnSubmitButton();
    }

    @Then("Enquiry error message should be displayed")
    public void enquiry_error_message_should_be_displayed() {
        Assert.assertTrue(Hooks.driver.findElement(contactUsPage.enquiryErrorMessage).isDisplayed());
    }

    // TC_ContactUs_8
    @Given("Contact Us page is opened before going to success submit message")
    public void contactUsPageIsOpen8() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User enters valid contact data before click submit")
    public void userEntersValidContact_data8() {
        contactUsPage.enterValidData();
    }

    @And("User clicks on Submit button after filling valid data")
    public void userClicksOnSubmitButtonAfterFillingValidData() {
        contactUsPage.userClickOnSubmitButton();
    }

    @Then("Contact Success page should be displayed")
    public void contact_success_page_should_be_displayed() {
        Assert.assertTrue(contactUsPage.successMessageIsDisplayed(), "Contact Success page NOT displayed!");
    }

    // TC_ContactUs_9
    @Given("Contact Us page is opened before user redirected to success page")
    public void contactUsPageIsOpen9() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.userIsOnContactUs(), "Contact Us page is NOT displayed!");
    }

    @When("User enters valid contact data before redirection")
    public void userEntersValidContact_data9() {
        contactUsPage.enterValidData();
    }

    @And("User clicks on submit button")
    public void userClicksOnSubmitButton9() {
        contactUsPage.userClickOnSubmitButton();
    }

    @Then("Success message should appear")
    public void success_message_should_appear() {
        Assert.assertTrue(contactUsPage.successMessageIsDisplayed(), "Success message did NOT appear!");
    }

    //TC_ContactUs_10
    @Given("Contact Success page is displayed")
    public void contact_success_page_is_displayed() {
        contactUsPage.clickOnContactUsIcon();
        contactUsPage.enterValidData();
        contactUsPage.clickOnSubmitButtonToContinue();
        Assert.assertTrue(contactUsPage.successMessageIsDisplayed(), "Contact success page NOT displayed!");
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        contactUsPage.clickOnContinueButton();
    }

    @Then("Homepage should be displayed again")
    public void homepage_should_be_displayed_again() {
        Assert.assertTrue(contactUsPage.isHomePageLoaded_HP(), "Homepage NOT displayed again!");
    }
}