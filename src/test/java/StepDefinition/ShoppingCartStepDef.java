package StepDefinition;

import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.MyAccount.MyAccountPage;
import Pages.ShoppingCart.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ShoppingCartStepDef {
    HomePage homePage = new HomePage(Hooks.driver);
    ShoppingCartPage shoppingCartPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;


    @Given("I'm guest user, I am in home Page and not added any items to my cart")
    public void iMGuestUserIAmInHomePageAndNotAddedAnyItemsToMyCart() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"http://localhost/opencart/");
    }

    @When("I Go to Shopping Cart page")
    public void iGoToShoppingCartPage() {
        shoppingCartPage = homePage.clickShoppingCart();
        Assert.assertEquals(shoppingCartPage.getPageTitle(),"Shopping Cart");
    }

    @And("Verify State indication {string} appears to me")
    public void verifyStateIndicationAppearsToMe(String massage) {

        if (massage.equalsIgnoreCase("valid")) {
            Assert.assertTrue(
                    shoppingCartPage.getEmptyMassage().contains(shoppingCartPage.getExpectedEmptyMassage()),
                    "Empty message is not correct!"
            );
        } else {
            Assert.fail("Invalid example parameter: " + massage);
        }
    }

    @And("Verify State indication {string} appears to me when I press on cart icon")
    public void verifyStateIndicationAppearsToMeWhenIPressOnCartIcon(String massage) {
        if (massage.equalsIgnoreCase("valid")) {
            Assert.assertTrue(
                    homePage.getMassageLocator().contains(homePage.getExpectedEmptyMassage()),
                    "Empty message is not correct!"
            );
        } else {
            Assert.fail("Invalid example parameter: " + massage);
        }
    }


    @Then("I press continue button to complete shopping")
    public void iPressContinueButtonToCompleteShopping() {
        homePage = shoppingCartPage.clickContinueButton();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"http://localhost/opencart/index.php?route=common/home&language=en-gb");
    }

/*
    @Given("I'm logged in user")
    public void iMLoggedInUser() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "http://localhost/opencart/");
        homePage.clickMyAccountButton();
        loginPage = homePage.selectLoginDropdownText();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "http://localhost/opencart/index.php?route=account/login&language=en-gb");
        Hooks.driver.navigate().refresh();
        loginPage.enterValidEmail("esraahamdy@test.com");
        loginPage.enterValidPassword("123456789");
        myAccountPage = loginPage.clickLoginButton();
        homePage = myAccountPage.clickHomePageIcon();
    }
*/

    @Then("I press home icon to continue shopping")
    public void iPressHomeIconToContinueShopping() {
        homePage = shoppingCartPage.clickHomePageIcon();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"http://localhost/opencart/index.php?route=common/home&language=en-gb");
    }

    @And("I'm at home page")
    public void iMAtHomePage() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"http://localhost/opencart/index.php?route=account/home&language=en-gb");
    }

    @When("I press on cart icon")
    public void iPressOnCartIcon() {
        homePage.clickCarticon();
    }

    @When("I can add products to my cart")
    public void iCanAddProductsToMyCart() {
        homePage.addMackBookToCart();
    }

    @Then("Verify {string} appears shows me the action is done")
    public void verifyAppearsShowsMeTheActionIsDone(String Massage) {
        Assert.assertEquals(homePage.getActualText(),(Massage.trim()));
    }

    @Then("I can update {string}")
    public void iCanUpdate(String quantity) {
    }
}
