package StepDefinitions;

import Pages.HomePage.HomePage;
import Pages.LoginPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDef {

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
    }

    @And("user adds item to cart")
    public void userAddsItemToCart() {
        loginPage.addItem();
    }
}
