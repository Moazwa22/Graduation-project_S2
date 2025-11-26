package StepDefinitions;

import Pages.Home.HomePage;
import Pages.MyAccount.ForgottenPasswordPage;
import Pages.MyAccount.LoginPage;
import Pages.MyAccount.RegisterPage;
import Pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login_StepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    MyAccountPage myAccountPage = new MyAccountPage(Hooks.driver);
    RegisterPage registerPage = new RegisterPage(Hooks.driver);
    ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(Hooks.driver);

    @Given("user in home page")
    public void userInHomePage() {

    }

    @When("user click on my account drop down")
    public void userClickOnMyAccountDropDown() {
        homePage.ClickOnMyAccountIcon();
    }

    @And("click on Login")
    public void clickOnLogin() {
        homePage.ClickOnLogin();
    }

    @Then("user redirect to login page")
    public LoginPage userRedirectToLoginPage() {

        return new LoginPage(Hooks.driver);
    }

    @When("user enter valid email and password")
    public void userEnterValidEmailAndPassword() {
        loginPage.enterEmail("mohabzaher11@gmail.com");
        loginPage.enterPassword("test12345");
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("user redirect to My Account page")
    public void userRedirectToMyAccountPage() {
    }


    @When("user click on home icon")
    public void userClickOnHomeIcon() {
    }

    @Then("user redirect to home page")
    public void userRedirectToHomePage() {
        loginPage.clickOnHomePageIcon();
    }

    @When("user click on Continue button")
    public void userClickOnContinueButton() {
        loginPage.clickOnContinueButton();
    }

    @Then("user redirect to rigester page.")
    public void userRedirectToRigesterPage() {

    }

    @When("user enter invalid email and valid password")
    public void userEnterInvalidEmailAndValidPassword() {
        loginPage.enterEmail("invalid@gmail.com");
        loginPage.enterPassword("test12345");
    }

    @Then("warning massage appear tell user invalid credentials")
    public void warningMassageAppearTellUserInvalidCredentials() {
        loginPage = new LoginPage(Hooks.driver);

        Assert.assertTrue(loginPage.isWarningMessageDisplayed(), "Warning message should be displayed");

    }


    @When("user enter valid email and invalid password")
    public void userEnterValidEmailAndInvalidPassword() {
        loginPage.enterEmail("mohabzaher11@gmail.com");
        loginPage.enterPassword("invalid");

    }

    @When("user keep email bar empty and enter valid password.")
    public void userKeepEmailBarEmptyAndEnterValidPassword() {
        loginPage.enterPassword("test12345");
    }

    @When("user keep password bar empty and enter valid email")
    public void userKeepPasswordBarEmptyAndEnterValidEmail() {
        loginPage.enterEmail("mohabzaher11@gmail.com");
    }

    @When("user keep keep both email and passowrd bars empty")
    public void userKeepKeepBothEmailAndPassowrdBarsEmpty() {
    }

    @When("user click on forgotten passoword link")
    public void userClickOnForgottenPassowordLink() {
        loginPage.clickOnForgottenPasswordBlueLink();
    }

    @Then("user redirect to  forgotten passoword  page")
    public void userRedirectToForgottenPassowordPage() {
    }


    @When("user click on home page icon")
    public void userClickOnHomePageIcon() {
        loginPage.clickOnHomePageIcon();
    }

    @When("user Click on Login link in the right list")
    public void userClickOnLoginLinkInTheRightList() {
        loginPage.clickOnLoginLink();
    }

    @When("user Click on Register link in the right list")
    public void userClickOnRegisterLinkInTheRightList() {
        loginPage.clickOnRegisterLink();
    }

    @Then("user redirect to Register page")
    public void userRedirectToRegisterPage() {
    }

    @When("user click on MyAccount Link")
    public void userClickOnMyAccountLink() {
    }

    @When("user click on Adress book Link")
    public void userClickOnAdressBookLink() {
        loginPage.clickOnAddressBookLink();
    }

    @Then("user redirect to Adress book page")
    public void userRedirectToAdressBookPage() {
    }

    @When("user click on Wish list Link")
    public void userClickOnWishListLink() {
    }

    @Then("user redirect to Wish list page")
    public void userRedirectToWishListPage() {
    }

    @When("user click on Order History Link")
    public void userClickOnOrderHistoryLink() {
    }

    @Then("user redirect to Order History page")
    public void userRedirectToOrderHistoryPage() {
    }


    @Then("user redirect to Downloads page")
    public void userRedirectToDownloadsPage() {
    }

    @When("user click on Subscriptions Link")
    public void userClickOnSubscriptionsLinkInList() {
    }

    @Then("user redirect to Subscriptions page")
    public void userRedirectToSubscriptionsPage() {
    }

    @When("user click on Reward points Link")
    public void userClickOnRewardPointsLink() {
    }

    @Then("user redirect to Reward points page")
    public void userRedirectToRewardPointsPage() {
    }

    @When("user click on Returns Link")
    public void userClickOnReturnsLink() {
    }

    @Then("user redirect to Returns page")
    public void userRedirectToReturnsPage() {
    }

    @When("user click on Transactions Link")
    public void userClickOnTransactionsLink() {
    }

    @Then("user redirect to Transactions page")
    public void userRedirectToTransactionsPage() {
    }

    @When("user click on Newsletter Link")
    public void userClickOnNewsletterLink() {
    }

    @Then("user redirect to Newsletter page")
    public void userRedirectToNewsletterPage() {
    }

    @When("user click on Edit your account information link")
    public void userClickOnEditYourAccountInformationLink() {
        myAccountPage.clickOnEditAccountInfoLink();
    }

    @Then("user go to Edit your account information page")
    public void userGoToEditYourAccountInformationPage() {
    }

    @When("user click on Change your password link")
    public void userClickOnChangeYourPasswordLink() {
        myAccountPage.clickOnChangePasswordLink();
    }

    @Then("user go to Change your password page")
    public void userGoToChangeYourPasswordPage() {
    }

    @When("user click on Stored payment methods link")
    public void userClickOnStoredPaymentMethodsLink() {
        myAccountPage.clickOnStoredPaymentMethodsLink();
    }

    @Then("user go to Stored payment methods page")
    public void userGoToStoredPaymentMethodsPage() {
    }

    @When("user click on Modify your address book entries link")
    public void userClickOnModifyYourAddressBookEntriesLink() {
        myAccountPage.clickOnModifyWishListLink();
    }

    @Then("user go to Modify your address book entries page")
    public void userGoToModifyYourAddressBookEntriesPage() {

    }

    @When("user click on View your order history link")
    public void userClickOnViewYourOrderHistoryLink() {
        myAccountPage.clickOnViewOrderHistoryLink();
    }

    @Then("user go to View your order history page")
    public void userGoToViewYourOrderHistoryPage() {

    }

    @When("user click on Subscriptions link")
    public void userClickOnSubscriptionsLink() {
        myAccountPage.clickOnSubscriptionsLink();
    }

    @Then("user go to Subscriptions page")
    public void userGoToSubscriptionsPage() {
    }

    @And("return the warning message appear")
    public void returnTheWarningMessageAppear() {
    }

    @When("user click on Downloads link")
    public void userClickOnDownloadsLink() {

        myAccountPage.clickOnDownloadsLink();
    }

    @Then("user go to Downloads page")
    public void userGoToDownloadsPage() {

    }

    @When("user click on Your Reward Points link")
    public void userClickOnYourRewardPointsLink() {
        myAccountPage.clickOnRewardPointsLink();
    }

    @Then("user go to Your Reward Points page")
    public void userGoToYourRewardPointsPage() {

    }

    @When("user click on View your return requests link")
    public void userClickOnViewYourReturnRequestsLink() {
        myAccountPage.clickOnViewReturnRequestsLink();
    }

    @Then("user go to View your return requests page")
    public void userGoToViewYourReturnRequestsPage() {

    }

    @When("user click on Your Transactions link")
    public void userClickOnYourTransactionsLink() {
        myAccountPage.clickOnTransactionsLink();

    }

    @Then("user go to Your Your Transactions page")
    public void userGoToYourYourTransactionsPage() {
    }

    @When("user click on Register for an affiliate account link")
    public void userClickOnRegisterForAnAffiliateAccountLink() {
        myAccountPage.clickOnRegisterAffiliateAccountLink();

    }

    @Then("user go to Register for an affiliate account page")
    public void userGoToRegisterForAnAffiliateAccountPage() {
    }

    @When("user click on Subscribe unsubscribe to newsletter link")
    public void userClickOnSubscribeUnsubscribeToNewsletterLink() {
        myAccountPage.clickOnSubscribeNewsletterLink();

    }

    @Then("user go to Subscribe unsubscribe to newsletter page")
    public void userGoToSubscribeUnsubscribeToNewsletterPage() {
    }

    @Then("click on My Account from drop down list")
    public void clickOnMyAccountFromDropDownList() {
        myAccountPage.clickOnMyAccountFromDropDownList();
    }

    @Then("click on order history from drop down list")
    public void clickOnOrderHistoryFromDropDownList() {
    }

    @When("user click on my account drop down in my account page")
    public void userClickOnMyAccountDropDownInMyAccountPage() {
    myAccountPage.clickOnMyAccountButton();
    }
}



