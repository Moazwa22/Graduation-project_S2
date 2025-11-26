package StepDefinitions;

import Pages.Home.HomePage;
import Pages.MyAccount.RegisterPage;
import Pages.MyAccount.YourAccountHasBeenCreatedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_StepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    RegisterPage registerPage = new RegisterPage(Hooks.driver);
    YourAccountHasBeenCreatedPage yourAccountHasBeenCreatedPage = new YourAccountHasBeenCreatedPage(Hooks.driver);

    @And("click on register")
    public void clickOnRegister() {
        homePage.clickOnRegister();
    }

    @Then("user redirect to register page")
    public void userRedirectToRegisterPage() {
    }
    @When("user enter valid credenials.")
    public void userEnterValidCredenials() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test123@gmail.com");
        registerPage.enterPassword("test12345");
    }
    @And("enable privacy police toggle")
    public void enablePrivacyPoliceToggle() {
        registerPage.enablePrivacyToggle();
    }
    @And("click on register button")
    public void clickOnRegisterButton() {
        registerPage.clickContinueButton();
    }
    @Then("user can register successfully")
    public void userCanRegisterSuccessfully() {

    }


    @Then("warning  message appear tells user")
    public void warningMessageAppearTellsUser() {
    }

    @When("user enter valid credentials except email keep it empty")
    public void userEnterValidCredentialsExceptEmailKeepItEmpty() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterPassword("test12345");
    }

    @When("user enter valid credentials except password keep it empty")
    public void userEnterValidCredentialsExceptPasswordKeepItEmpty() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test123@gmail.com");
    }

    @When("user enter valid credentials except first name keep it empty")
    public void userEnterValidCredentialsExceptFirstNameKeepItEmpty() {
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test123@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("user enter valid credentials except last name keep it empty")
    public void userEnterValidCredentialsExceptLastNameKeepItEmpty() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterEmail("test123@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except first name enter invalid")
    public void enterValidCredentialsExceptFirstNameEnterInvalid() {
        registerPage.enterFirstName("-----");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test123@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except last name enter invalid")
    public void enterValidCredentialsExceptLastNameEnterInvalid() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("#####");
        registerPage.enterEmail("test123@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except email enter invalid")
    public void enterValidCredentialsExceptEmailEnterInvalid() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test-gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except password enter invalid")
    public void enterValidCredentialsExceptPasswordEnterInvalid() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test123@gmail.com");
        registerPage.enterPassword("++++");
    }
}
