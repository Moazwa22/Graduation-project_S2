package StepDefinitions;

import Pages.MyAccount.RightListButton;
import Pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount_StepDef {
    MyAccountPage myAccountPage = new MyAccountPage(Hooks.driver);
    RightListButton rightListButton = new RightListButton(Hooks.driver);


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
        myAccountPage.clickOnModifyAddressBookLink();
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
    /////////////////////////////////////////////////////////////////////////
    @When("user click on My account button at nav bar")
    public void userClickOnMyAccountButtonAtNavBar() {
        myAccountPage.clickOnUserIconFromMyAccountFromInNavBar();

    }

    @And("click on My Account from drop down list")
    public void clickOnMyAccountFromDropDownList() {
        myAccountPage.clickOnMyAccountFromMyAccountDropDownList();
    }

    @And("click on order history from drop down list")
    public void clickOnOrderHistoryFromDropDownList() {
        myAccountPage.clickOnOrderHistoryFromDropDown();
    }

    @Then("user redirect to Order History page")
    public void userRedirectToOrderHistoryPage() {
    }

    @And("click on Transactions from drop down list")
    public void clickOnTransactionsFromDropDownList() {
        myAccountPage.clickOnTransactionsFromDropDown();
    }

    @Then("user redirect to Transactions page")
    public void userRedirectToTransactionsPage() {
    }

    @And("click on Downloads from drop down list")
    public void clickOnDownloadsFromDropDownList() {
        myAccountPage.clickOnDownloadsFromDropDown();
    }

    @Then("user redirect to Downloads page")
    public void userRedirectToDownloadsPage() {
    }
    @When("user click on logout button at nav bar")
    public void userClickOnLogoutButtonAtNavBar() {
        myAccountPage.clickOnLogoutFromDropDown();
    }

    @When("user Click on My account in the right list")
    public void userClickOnMyAccountInTheRightList() {
        rightListButton.clickOnMyAccountLinkFromRegisterPage();

    }

    @Then("user kept in my account page")
    public void userKeptInMyAccountPage() {
    }

    @When("user Click on edit account in the right list")
    public void userClickOnEditAccountInTheRightList() {
        myAccountPage.ClickEditAccountLinkList();

    }

    @Then("user redirect to edit account page")
    public void userRedirectToEditAccountPage() {
    }

    @When("user click on  password button")
    public void userClickOnPasswordButton() {
        myAccountPage.ClickPasswordLinkList();
    }

    @Then("user redirect to  password page")
    public void userRedirectToPasswordPage() {
    }

    @When("user click on payment methods button")
    public void userClickOnPaymentMethodsButton() {
        rightListButton.clickOnPaymentMethodsLink();
    }

    @Then("user redirect to payment methods page")
    public void userRedirectToPaymentMethodsPage() {
    }

    @When("user click on Address book button")
    public void userClickOnAddressBookButton() {
        rightListButton.clickOnAddressBookLink();
    }

    @Then("user redirect to Address book page")
    public void userRedirectToAddressBookPage() {
    }

    @When("user click on Wish list Link")
    public void userClickOnWishListLink() {
        rightListButton.clickOnWishListLink();
    }

    @Then("user redirect to Wish list page")
    public void userRedirectToWishListPage() {
    }

    @When("user click on Order History Link")
    public void userClickOnOrderHistoryLink() {
        rightListButton.clickOnOrderHistoryLink();
    }

    @When("user click on Downloads button")
    public void userClickOnDownloadsButton() {
        rightListButton.clickOnDownloadsLink();
    }

    @When("user click on Subscriptions button")
    public void userClickOnSubscriptionsButton() {
        rightListButton.clickOnSubscribtionsLink();
    }

    @Then("user redirect to Subscriptions page")
    public void userRedirectToSubscriptionsPage() {
    }

    @When("user click on Reward points button")
    public void userClickOnRewardPointsButton() {
        rightListButton.clickOnRewardPointsLink();
    }

    @Then("user redirect to Reward points page")
    public void userRedirectToRewardPointsPage() {
    }

    @When("user click on Returns button")
    public void userClickOnReturnsButton() {
        rightListButton.clickOnReturnsLink();
    }

    @Then("user redirect to Returns page")
    public void userRedirectToReturnsPage() {
    }

    @When("user click on Transactions button")
    public void userClickOnTransactionsButton() {
        rightListButton.clickOnTransactionsLink();
    }

    @When("user click on Newsletter button")
    public void userClickOnNewsletterButton() {
    }

    @Then("user redirect to Newsletter page")
    public void userRedirectToNewsletterPage() {
        rightListButton.clickOnNewslettersLink();
    }

    @When("user click on logout button")
    public void userClickOnLogoutButton() {
        myAccountPage.clickOnLogoutFromDropDown();
    }

    @Then("user redirect to logout page")
    public void userRedirectToLogoutPage() {
    }



}