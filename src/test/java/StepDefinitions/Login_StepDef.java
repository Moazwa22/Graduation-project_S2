package StepDefinitions;

import Pages.HomePage.HomePage;
import Pages.LoginPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class Login_StepDef {

    private static final Logger log = LoggerFactory.getLogger(Login_StepDef.class);
    HomePage homePage = new HomePage(Hooks.driver);
    LoginPage loginPage;

    @Given("user in home page")
    public void userInHomePage(){
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
