package StepDefinitions;

import Pages.Home.HomePage;
import Pages.MyAccount.RegisterPage;
import Pages.MyAccount.RightListButton;
import Pages.MyAccount.YourAccountHasBeenCreatedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Register_StepDef {

    HomePage homePage = new HomePage(Hooks.driver);
    RegisterPage registerPage = new RegisterPage(Hooks.driver);
    YourAccountHasBeenCreatedPage yourAccountHasBeenCreatedPage = new YourAccountHasBeenCreatedPage(Hooks.driver);
    RightListButton rightListButton = new RightListButton(Hooks.driver);


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

    @Then("click on register button")
    public void clickOnRegisterButton() throws InterruptedException {

        registerPage.clickContinueButton();
        Thread.sleep(5000);
    }

    @Then("user can register successfully")
    public void userCanRegisterSuccessfully() {

    }

    @Then("check if the waning message displayed or not")
    public void checkIfTheWaningMessageDisplayedOrNot() {

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
        registerPage.enterEmail("test@gmail.com");
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
        registerPage.enterEmail("test@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except first name enter invalid")
    public void enterValidCredentialsExceptFirstNameEnterInvalid() {
        registerPage.enterFirstName("-----");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("testcase@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except last name enter invalid")
    public void enterValidCredentialsExceptLastNameEnterInvalid() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("#####");
        registerPage.enterEmail("test1@gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except email enter invalid")
    public void enterValidCredentialsExceptEmailEnterInvalid() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test---gmail.com");
        registerPage.enterPassword("test12345");
    }

    @When("enter valid credentials except password enter invalid")
    public void enterValidCredentialsExceptPasswordEnterInvalid() {
        registerPage.enterFirstName("Mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("test12333@gmail.com");
        registerPage.enterPassword("++++");
    }

    @Then("user kept at Register page")
    public void userKeptAtRegisterPage() {

    }

    @When("user click on forgotten password link")
    public void userClickOnForgottenPasswordLink() {
        registerPage.clickOnForgottenPasswordLink();
    }

    @Then("user redirect to  forgotten passoword  page from register page")
    public void userRedirectToForgottenPassowordPageFromRegisterPage() {
    }

    @Then("user redirect to login page from register page")
    public void userRedirectToLoginPageFromRegisterPage() {
    }


    @When("user click on Adress book Link from register page")
    public void userClickOnAdressBookLinkFromRegisterPage() {
        rightListButton.clickOnAddressBookLink();
    }

    @When("user click on MyAccount Link from register page")
    public void userClickOnMyAccountLinkFromRegisterPage() {
    }

    @When("user click on Wish list Link from register page")
    public void userClickOnWishListLinkFromRegisterPage() {
        rightListButton.clickOnWishListLink();
    }

    @When("user click on Order History Link from register page")
    public void userClickOnOrderHistoryLinkFromRegisterPage() {
        rightListButton.clickOnOrderHistoryLink();
    }

    @When("user click on Downloads Link from register page")
    public void userClickOnDownloadsLinkFromRegisterPage() {
        rightListButton.clickOnDownloadsLink();
    }

    @When("user click on Subscriptions Link from register page")
    public void userClickOnSubscriptionsLinkFromRegisterPage() {
        rightListButton.clickOnSubscribtionsLink();
    }

    @When("user click on Reward points Link from register page")
    public void userClickOnRewardPointsLinkFromRegisterPage() {
        rightListButton.clickOnRewardPointsLink();
    }

    @When("user click on Returns Link from register page")
    public void userClickOnReturnsLinkFromRegisterPage() {
        rightListButton.clickOnReturnsLink();
    }

    @When("user click on Transactions Link from register page")
    public void userClickOnTransactionsLinkFromRegisterPage() {
        rightListButton.clickOnTransactionsLink();
    }

    @When("user click on Newsletter Link from register page")
    public void userClickOnNewsletterLinkFromRegisterPage() {
        rightListButton.clickOnNewslettersLink();
    }

    @When("user Click on Login link in the right list")
    public void userClickOnLoginLinkInTheRightList() {
        registerPage.clickOnLoginLinkFromRegisterPage();
    }

    @When("user Click on Register link in the right list")
    public void userClickOnRegisterLinkInTheRightList() {
        registerPage.clickOnRegisterLinkFromRegisterPage();
    }

    @When("user click on already have an account please login at the login page")
    public void userClickOnAlreadyHaveAnAccountPleaseLoginAtTheLoginPage() {
        registerPage.clickOnAlreadyHaveAnAccountLoginLink();
    }


    @When("enter valid credentials except first name enter invalid more than 32 characters")
    public void enterInvalidCredentialsExceptFirstNameEnterMoreThanLimitedCharachters()
    {
        registerPage.enterFirstName("mohabmohabmohabmohabmohabmohabmohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("testcase1@gmail.com");
        registerPage.enterPassword("test12345");
    }
    @Then("user will see an warning message")
    public void userWillSeeAnWarningMessage() {
        Assert.assertEquals(registerPage.getExpectedWarningNameMessage(), registerPage.getExpectedWarningNameMessage());
    }

    @When("enter valid credentials except last name enter invalid more than 32 characters")
    public void enterInvalidCredentialsExceptLastNameEnterMoreThanLimitedCharachters()
    {
        registerPage.enterFirstName("zaher");
        registerPage.enterLastName("mohabmohabmohabmohabmohabmohabmohab");
        registerPage.enterEmail("testcase1@gmail.com");
        registerPage.enterPassword("test12345");
    }
    @When("enter valid credentials except password enter invalid by enter more than 40 charachters")
    public void enterInvalidCredentialsExceptPasswordEnterMoreThanLimitedCharachters()
    {
        registerPage.enterFirstName("mohab");
        registerPage.enterLastName("zaher");
        registerPage.enterEmail("testcase1@gmail.com");
        registerPage.enterPassword("test12345123451234512345123451234512345123451234512345");
    }
    @Then("user will see an warning password message")
    public void userWillSeeAnWarningPasswordMessage() {
        Assert.assertEquals(registerPage.getExpectedWarningNameMessage(), registerPage.getExpectedWarningNameMessage());
    }
}

