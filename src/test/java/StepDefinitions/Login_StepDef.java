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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Login_StepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    MyAccountPage myAccountPage = new MyAccountPage(Hooks.driver);
    RegisterPage registerPage = new RegisterPage(Hooks.driver);
    ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(Hooks.driver);
    private static final Logger log = LoggerFactory.getLogger(Login_StepDef.class);

    @Given("user in home page_M")
    public void userInHomePage() {}

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
    public void userRedirectToMyAccountPage() throws InterruptedException {
        Thread.sleep(2000);
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
    public void userRedirectToForgottenPassowordPage() {}


    @When("user click on home page icon")
    public void userClickOnHomePageIcon() {
        loginPage.clickOnHomePageIcon();
    }

    //--------Tebry---------//
    @Given("user in home page_T")
    public void userInHomePage3(){
        homePage = new HomePage(Hooks.driver);
    }

    @When("user clicks login")
    public void userClicksLogin() {
        loginPage = homePage.login();
    }

    @When("user enters credentials")
    public void userEntersCredentials() {
        loginPage.Login();
    }

    @And("press Login")
    public void pressLogin() {
        loginPage.pressLogin();
        Assert.assertEquals(loginPage.actualTitleOfAccountPage(),loginPage.getExpectedTitleOfMyAccountPage());
    }

    @And("user adds item to cart")
    public void userAddsItemToCart() {
        loginPage.addItem();
    }

    @Then("return to home page")
    public void returnToHomePage() {
        loginPage.returnToHomaPage();
    }
}
