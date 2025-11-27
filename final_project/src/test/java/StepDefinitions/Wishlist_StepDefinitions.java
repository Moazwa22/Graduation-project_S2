package StepDefinitions;

import Pages.Home.HomePage;
import Pages.MyAccountPage;
import Pages.login.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Wishlist_StepDefinitions {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage =new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Given("user on home page")
    public void userOnHomePage() {

    }

    @When("user click on My Account dropdown")
    public void userClickOnMyAccountDropdown() {
        homePage.clickMyAccountDropdown();
    }

    @And("user click on Login link")
    public void userClickOnLoginLink() {
        homePage.clickLoginLink();
    }
    @Then("user redirect to login page")
    public void userRedirectToLoginPage() {
    }

    @And("user enter valid email and password")
    public void userEnterValidEmailAndPassword() {
        loginPage.enterUserName("amrrr@gmail.com");
        loginPage.enterPassword("123456789");
    }

    @Then("user redirect to myAccount page")
    public void userRedirectToMyAccountPage() {
    }

    @And("user click on login button")
    public void userClickOnLoginButton() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(500);
    }


    @When("user click on home icon to return to home page")
    public void userClickOnHomeIconToReturnToHomePage() {
        myAccountPage.clickOnHomePageIcon();
    }

    @Then("user redirect to home page")
    public void userRedirectToHomePage() {
    }

    @When("user click on wishlist icon for MacBook product")
    public void userClickOnWishlistIconForMacBookProduct() {
        homePage.clickOnWishlistIcon();
    }

    @Then("success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        Assert.assertTrue(
                driver.findElement(By.cssSelector("div.alert.alert-success")).getText().contains("Success"));

    }

    @And("wishlist counter in header should increase by one")
    public void wishlistCounterInHeaderShouldIncreaseByOne() {
        homePage.successMessageDisplayed();
        Assert.assertTrue(
                driver.findElement(By.xpath("//span[contains(text(),'Wish List')]")).getText().contains("1"));
        }


}


