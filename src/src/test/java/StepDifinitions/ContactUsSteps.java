package StepDifinitions;

import Pages.ContactUsPage;
import Pages.HomePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsSteps extends Hooks {

    WebDriver driver = Hooks.driver;
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    HomePage homePage = new HomePage(driver);

    // TC_ContactUs_1
    @Given("Homepage is loaded successfully")
    public void homepageIsLoadedSuccessfully() {
        driver.get("http://localhost/opencart/");
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("User clicks on the Contact Us icon")
    public void userClicksOnContactUsIcon() {
        contactUsPage.clickOnContactUsIcon();
    }

    @Then("Contact Us page should be displayed")
    public void contactUsPageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isOnContactUsPage());
    }

    // TC_ContactUs_2
    @Given("Contact Us page is open")
    public void contactUsPageIsOpen() {
        contactUsPage.clickOnContactUsIcon();
        Assert.assertTrue(contactUsPage.isOnContactUsPage());
    }

    @Then("All Contact Us form fields should be displayed")
    public void allContactUsFieldsShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.areContactUsFieldsDisplayed());
    }

    // TC_ContactUs_3
    @When("User enters valid contact data")
    public void userEntersValidContactData() {
        contactUsPage.enterValidContactData(
                "Moaz Waleed",
                "moaazw84@gmail.com",
                "I want anyone to talk to me and I want something from customer service"
        );
    }

    @When("User clicks on the Submit button")
    public void userClicksOnSubmitButton() {
        contactUsPage.clickSubmitButton();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
    }

    // TC_ContactUs_4
    @When("User submits an empty contact form")
    public void userSubmitsEmptyContactForm() {
        contactUsPage.enterInvalidContactData("", "", "");
        contactUsPage.clickSubmitButton();
    }

    @Then("Appropriate error messages should be displayed")
    public void appropriateErrorMessagesShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isEmailErrorDisplayed());
        Assert.assertTrue(contactUsPage.isNameErrorDisplayed());
        Assert.assertTrue(contactUsPage.isEnquiryErrorDisplayed());
    }

    // TC_ContactUs_5
    @When("User enters an invalid email format")
    public void userEntersInvalidEmail() {
        contactUsPage.enterInvalidContactData("Moaz Waleed", "invalidemail", "Valid enquiry text");
        contactUsPage.clickSubmitButton();
    }

    @Then("Email-specific error message should be displayed")
    public void emailSpecificErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isEmailErrorDisplayed());
    }

    // TC_ContactUs_6
    @When("User enters more characters than allowed in the name field")
    public void userEntersMoreCharactersInName() {
        contactUsPage.enterInvalidContactData("A".repeat(50), "moaazw84@gmail.com", "Valid enquiry");
        contactUsPage.clickSubmitButton();
    }

    @Then("Name-specific error message should be displayed")
    public void nameSpecificErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isNameErrorDisplayed());
    }

    // TC_ContactUs_7
    @When("User enters more characters than allowed in the enquiry field")
    public void userEntersLongEnquiry() {
        contactUsPage.enterInvalidContactData("Moaz Waleed", "moaazw84@gmail.com", "A".repeat(3500));
        contactUsPage.clickSubmitButton();
    }

    @Then("Enquiry-specific error message should be displayed")
    public void enquirySpecificErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isEnquiryErrorDisplayed());
    }

    // TC_ContactUs_8 + 9
    @Then("Contact Success page should be displayed")
    @Then("Success message should appear")
    public void contactSuccessMessageShouldBeDisplayed() {
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
    }

    // TC_ContactUs_10
    @Given("Contact Success page is displayed")
    public void contactSuccessPageIsDisplayed() {
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
    }

    @When("User clicks on the Continue button")
    public void userClicksOnContinueButton() {
        contactUsPage.clickContinueButton();
    }

    @Then("Homepage should be displayed again")
    public void homepageShouldBeDisplayedAgain() {
        Assert.assertTrue(homePage.isHomePageLoaded());
    }
}
