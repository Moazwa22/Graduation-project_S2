package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver=driver;
    }
    By EditAccountInfoLinkLocator = By.xpath("//a[text()='Edit your account information']");
    By ChangePasswordLinkLocator = By.xpath("//a[text()='Change your password']");
    By StoredPaymentMethodsLinkLocator = By.xpath("//a[text()='Stored payment methods']");
    By ModifyAddressBookLinkLocator = By.xpath("//a[text()='Modify your address book entries']");
    By ModifyWishListLinkLocator = By.xpath("//a[text()='Modify your wish list']");
    By ViewOrderHistoryLinkLocator = By.xpath("//a[text()='View your order history']");
    By SubscriptionsLinkLocator = By.xpath("//a[text()='Subscriptions']");
    By DownloadsLinkLocator = By.xpath("//a[text()='Downloads']");
    By RewardPointsLinkLocator = By.xpath("//a[text()='Your Reward Points']");
    By ViewReturnRequestsLinkLocator = By.xpath("//a[text()='View your return requests']");
    By TransactionsLinkLocator = By.xpath("//a[text()='Your Transactions']");
    By RegisterAffiliateAccountLinkLocator = By.xpath("//a[text()='Register for an affiliate account']");
    By SubscribeNewsletterLinkLocator = By.xpath("//a[text()='Subscribe / unsubscribe to newsletter']");
    By MyAccountDropDownLocator =By.xpath("//a[@class='dropdown-item' and text()='My Account']");
    By MyAccountDropDownListLocator = By.xpath("//a[@class='dropdown-item' and text()='My Account']");
    By OrderHistoryDropDownLocator = By.xpath("//a[@class='dropdown-item' and text()='Order History']");

    //the right list in my account page
    //   By MyAccountLinkLocator = By.xpath("//a[@class='list-group-item' and text()='My Account']");
    //    By EditAccountLinkLocator =By.xpath("//a[@class='list-group-item' and text()='Edit Account']") ;
    //    By PasswordLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Password']");
    //    By PaymentMethodsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Payment Methods']");
    //    By AddressBookLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Address Book']");
    //    By WishListLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Wish List']");
    //    By OrderHistoryLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Order History']");
    //    By DownloadsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Downloads']");
    //    By SubscriptionsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Subscriptions']");
    //    By RewardPointsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Reward Points']");
    //    By ReturnsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Returns']");
    //    By TransactionsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Transactions']");
    //    By NewsletterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Newsletter']");

    public void clickOnEditAccountInfoLink() {
        driver.findElement(EditAccountInfoLinkLocator).click();
    }

    public void clickOnChangePasswordLink() {
        driver.findElement(ChangePasswordLinkLocator).click();
    }

    public void clickOnStoredPaymentMethodsLink() {
        driver.findElement(StoredPaymentMethodsLinkLocator).click();
    }

    public void clickOnModifyAddressBookLink() {
        driver.findElement(ModifyAddressBookLinkLocator).click();
    }

    public void clickOnModifyWishListLink() {
        driver.findElement(ModifyWishListLinkLocator).click();
    }

    public void clickOnViewOrderHistoryLink() {
        driver.findElement(ViewOrderHistoryLinkLocator).click();
    }

    public void clickOnSubscriptionsLink() {
        driver.findElement(SubscriptionsLinkLocator).click();
    }

    public void clickOnDownloadsLink() {
        driver.findElement(DownloadsLinkLocator).click();
    }

    public void clickOnRewardPointsLink() {
        driver.findElement(RewardPointsLinkLocator).click();
    }

    public void clickOnViewReturnRequestsLink() {
        driver.findElement(ViewReturnRequestsLinkLocator).click();
    }

    public void clickOnTransactionsLink() {
        driver.findElement(TransactionsLinkLocator).click();
    }

    public void clickOnRegisterAffiliateAccountLink() {
        driver.findElement(RegisterAffiliateAccountLinkLocator).click();
    }

    public void clickOnSubscribeNewsletterLink() {
        driver.findElement(SubscribeNewsletterLinkLocator).click();
    }
    public void clickOnMyAccountFromDropDownList()
    {
        driver.findElement(MyAccountDropDownListLocator).click();
    }
    public void clickOnOrderHistoryFromDropDownList(){
        driver.findElement(OrderHistoryDropDownLocator).click();
    }
    public void clickOnMyAccountButton(){
        driver.findElement(MyAccountDropDownLocator).click();
    }
}

