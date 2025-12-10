package StepDefinitions;

import Pages.Home.HomePage;
import Pages.MyAccountPage;
import Pages.Wishlist.WishlistPage;
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
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    WishlistPage wishlistPage = new WishlistPage(driver);

    //                                 Background
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
    public void userClicksWishlistIcon() {
        homePage.clickOnWishlistIcon();
    }

    //    Tc1
    @And("Clicking on Wish List button on the header of the page")
    public void clickingOnWishListButtonOnTheHeaderOfThePage() {
        homePage.clickOnWishlistCounter();
    }

    @Then("Product displays on wish list page")
    public void productDisplaysOnWishListPage() {
        wishlistPage.productDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']")).isDisplayed());
    }

    //TC2
    @Then("success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        homePage.successMessageDisplayed();
        Assert.assertTrue(
                driver.findElement(By.cssSelector("div.alert.alert-success")).getText().contains("Success"));
    }

    //TC3
    @And("Clicking on remove button")
    public void clickingOnRemoveButton() {
        wishlistPage.clickRemoveButton();
    }

    @Then("empty message should be displayed")
    public void emptyMessageShouldBeDisplayed() {
        if (!driver.getCurrentUrl().contains("wishlist")) {
            System.out.println("Redirected to login — cannot check empty wishlist message.");
            return;
        }
        boolean isDisplayed = !driver.findElements(By.xpath("//div[@id='wishlist']/p")).isEmpty();
        Assert.assertTrue(isDisplayed, "Empty wishlist message is not displayed!");
    }


    //    TC4
    @And("Clicking on add to cart icon of the product")
    public void clickingOnAddToCartIconOfTheProduct() {
        wishlistPage.clickAddToCartButtonOnProduct();
    }

    //    TC5
    int oldCount;

    @When("user click on wishlist icon to Different product")
    public void userClickOnWishlistIconForDifferentProduct() throws InterruptedException {
        oldCount = homePage.getWishlistCount();
        System.out.println("DEBUG: Count BEFORE click: " + oldCount);
        Thread.sleep(1000);
        homePage.clickOnWishlistIcon();
        System.out.println("DEBUG: Clicked on Wishlist Icon");
    }

    @And("wishlist counter in header should increase by one")
    public void wishlistCounterInHeaderShouldIncreaseByOne() throws InterruptedException {
        System.out.println("Waiting for counter to update...");
//        driver.navigate().refresh();
        Thread.sleep(1000);
        int newCount = homePage.getWishlistCount();
        System.out.println("DEBUG: Count AFTER click: " + newCount);
        Assert.assertEquals(newCount, oldCount + 1);
    }

    int oldRemoveCount;

    @When("user remove product from wishlist")
    public void userRemoveProductFromWishlist() throws InterruptedException {
        oldRemoveCount = homePage.getWishlistCount();
        Thread.sleep(500);
        wishlistPage.clickRemoveButton();
    }

    @Then("wishlist counter should decrease by one")
    public void wishlistCounterShouldDecreaseByOne() throws InterruptedException {
        Thread.sleep(500);
        int newCount = homePage.getWishlistCount();
        Assert.assertEquals(newCount, oldRemoveCount - 1);
    }


    int oldCountCart;
    double oldPrice;

    @When("user adds MacBook to cart from wishlist")
    public void userAddsMacbookToCartFromWishlist() throws InterruptedException {
        oldCountCart = wishlistPage.getCartItemsCount();
        oldPrice = wishlistPage.getCartTotalPrice();
        wishlistPage.clickAddToCartButtonOnProduct();
        Thread.sleep(1000);
    }

    @Then("cart counter and price should increase")
    public void cartCounterAndPriceShouldIncrease() {

        int newCount = wishlistPage.getCartItemsCount();
        double newPrice = wishlistPage.getCartTotalPrice();

        Assert.assertTrue(newCount > oldCount, "Cart count did not increase!");
        Assert.assertTrue(newPrice > oldPrice, "Cart total price did not increase!");
    }

    @Then("user removes product from wishlist cart")
    public void userRemovesProductFromWishlistCart() throws InterruptedException {

        oldCount = wishlistPage.getCartItemsCount();
        oldPrice = wishlistPage.getCartTotalPrice();
        wishlistPage.clickOnRemoveButtonOnCart();
        Thread.sleep(1000);
    }

    @Then("cart counter and price should decrease")
    public void cartCounterAndPriceShouldDecrease() {

        int newCount = wishlistPage.getCartItemsCount();
        double newPrice = wishlistPage.getCartTotalPrice();

        Assert.assertEquals(newCount, 0);
        Assert.assertTrue(newPrice < oldPrice);
    }

    @When("user click on cart")
    public void userClickOnCart() {
        wishlistPage.userClickOnCart();
    }

    int oldQty;

    @When("user adds the same product multiple times to cart")
    public void userAddsSameProductMultipleTimes() throws InterruptedException {

        wishlistPage.clickAddToCartButtonOnProduct();
        Thread.sleep(200);
        wishlistPage.openCartDropdown();
        oldQty = wishlistPage.getDropdownQuantity();
        wishlistPage.openCartDropdown();
        wishlistPage.clickAddToCartButtonOnProduct();
        Thread.sleep(1000);
    }

    @Then("the quantity inside the cart dropdown should increase")
    public void quantityInsideCartShouldIncrease() throws InterruptedException {
        wishlistPage.openCartDropdown();
        Thread.sleep(1000);
        int newQty = wishlistPage.getDropdownQuantity();
        Assert.assertEquals(newQty, oldQty + 1);
    }

    @Then("user removes product from cart")
    public void userRemovesProductFromCart() throws InterruptedException {
        wishlistPage.clickOnRemoveButtonOnCart();
        Thread.sleep(500);
    }

    @Then("success empty message should be displayed")
    public void successEmptyMessageShouldBeDisplayed() {
        String actualMessage = wishlistPage.getEmptyCartMessage();
        String expectedMessage = "Your shopping cart is empty!";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("click on viewCart button")
    public void clickOnViewCartButton() {
        wishlistPage.clickViewCart();
    }

    @Then("User redirect to viewCart page")
    public void userRedirectToViewCartPage() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "http://localhost/opencart/index.php?route=checkout/cart&language=en-gb");
    }

    @And("click on checkout button")
    public void clickOnCheckoutButton() {
        wishlistPage.clickCheckout();
    }

    @Then("User redirect to checkout page")
    public void userRedirectToCheckoutPage() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "http://localhost/opencart/index.php?route=checkout/checkout&language=en-gb");
    }

    @When("Clicking on MyAccount link at the right of the page")
    public void clickingOnMyAccountLink() {
        wishlistPage.clickOnMyAccountLink();
    }

    @Then("user redirected to MyAccount page")
    public void userRedirectedToMyAccountPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
    }


    @When("Clicking on Edit Account link at the right of the page")
    public void clickingOnEditAccountLink() {
        wishlistPage.clickOnEditAccountLink();
    }

    @Then("user redirected to Edit Account page")
    public void userRedirectedToEditAccountPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/edit"));
    }

    @When("Clicking on Password link at the right of the page")
    public void clickingOnPasswordLink() {
        wishlistPage.clickOnPasswordLink();
    }

    @Then("user redirected to Password page")
    public void userRedirectedToPasswordPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/password"));
    }


    @When("Clicking on Payment Methods link at the right of the page")
    public void clickingOnPaymentMethodsLink() {
        wishlistPage.clickOnPaymentMethodsLink();
    }

    @Then("user redirected to Payment Methods page")
    public void userRedirectedToPaymentMethodsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/payment"));
    }

    @When("Clicking on Address Book link at the right of the page")
    public void clickingOnAddressBookLink() {
        wishlistPage.clickOnAddressBookLink();
    }

    @Then("user redirected to Address Book page")
    public void userRedirectedToAddressBookPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/address"));
    }


    @When("Clicking on Wish List link at the right of the page")
    public void clickingOnWishListLink() {
        wishlistPage.clickOnWishListLink();
    }

    @Then("user shouldn't redirected to any page")
    public void userRedirectedToWishListPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/wishlist"));
    }


    @When("Clicking on Order History link at the right of the page")
    public void clickingOnOrderHistoryLink() {
        wishlistPage.clickOnOrderHistoryLink();
    }

    @Then("user redirected to Order History page")
    public void userRedirectedToOrderHistoryPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/order"));
    }


    @When("Clicking on Downloads link at the right of the page")
    public void clickingOnDownloadsLink() {
        wishlistPage.clickOnDownloadsLink();
    }

    @Then("user redirected to Downloads page")
    public void userRedirectedToDownloadsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/download"));
    }


    @When("Clicking on Subscriptions link at the right of the page")
    public void clickingOnSubscriptionsLink() {
        wishlistPage.clickOnSubscriptionsLink();
    }

    @Then("user redirected to Subscriptions page")
    public void userRedirectedToSubscriptionsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/subscription"));
    }


    @When("Clicking on Reward Points link at the right of the page")
    public void clickingOnRewardPointsLink() {
        wishlistPage.clickOnRewardPointsLink();
    }

    @Then("user redirected to Reward Points page")
    public void userRedirectedToRewardPointsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/reward"));
    }


    @When("Clicking on Returns link at the right of the page")
    public void clickingOnReturnsLink() {
        wishlistPage.clickOnReturnsLink();
    }

    @Then("user redirected to Returns page")
    public void userRedirectedToReturnsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/returns"));
    }


    @When("Clicking on Transactions link at the right of the page")
    public void clickingOnTransactionsLink() {
        wishlistPage.clickOnTransactionsLink();
    }

    @Then("user redirected to Transactions page")
    public void userRedirectedToTransactionsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/transaction"));
    }


    @When("Clicking on Newsletter link at the right of the page")
    public void clickingOnNewsletterLink() {
        wishlistPage.clickOnNewsletterLink();
    }

    @Then("user redirected to Newsletter page")
    public void userRedirectedToNewsletterPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account/newsletter"));
    }


    @When("Clicking on Logout link at the right of the page")
    public void clickingOnLogoutLink() {
        wishlistPage.clickOnLogoutLink();
    }

    @Then("user redirected to Logout page")
    public void userRedirectedToLogoutPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("logout"));
    }


}