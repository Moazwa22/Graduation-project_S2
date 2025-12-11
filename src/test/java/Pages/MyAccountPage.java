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
    //-----------------Amr-----------------------//
    By HomePageIcon = By.cssSelector("a[href*='route=common/home']");

    public void clickOnHomePageIcon() {
        driver.findElement(HomePageIcon).click();
    }
    public void clickOnEditAccountInfoLink() {driver.findElement(EditAccountInfoLinkLocator).click();}
    public void clickOnChangePasswordLink() {driver.findElement(ChangePasswordLinkLocator).click();}
    public void clickOnStoredPaymentMethodsLink() {driver.findElement(StoredPaymentMethodsLinkLocator).click();}
    public void clickOnModifyAddressBookLink() {driver.findElement(ModifyAddressBookLinkLocator).click();}
    public void clickOnModifyWishListLink() {driver.findElement(ModifyWishListLinkLocator).click();}
    public void clickOnViewOrderHistoryLink() {driver.findElement(ViewOrderHistoryLinkLocator).click();}
    public void clickOnSubscriptionsLink() {driver.findElement(SubscriptionsLinkLocator).click();}
    public void clickOnDownloadsLink(){driver.findElement(DownloadsLinkLocator).click();}
    public void clickOnRewardPointsLink() {driver.findElement(RewardPointsLinkLocator).click();}
    public void clickOnViewReturnRequestsLink() {driver.findElement(ViewReturnRequestsLinkLocator).click();}
    public void clickOnTransactionsLink() {driver.findElement(TransactionsLinkLocator).click();}
    public void clickOnRegisterAffiliateAccountLink() {driver.findElement(RegisterAffiliateAccountLinkLocator).click();}
    public void clickOnSubscribeNewsletterLink() {driver.findElement(SubscribeNewsletterLinkLocator).click();}



    // the locators for My Account dropdown at the nav bar at the top
    By userIcon = By.className("fa-user");
    By MyAccountFromTheTopDropDownLocator=By.cssSelector("a.dropdown-item[href*='route=account/account']");
    By OrderHistoryFromTheTopDropDownLocator = By.cssSelector("a.dropdown-item[href*='route=account/order']");
    By TransactionsFromTheTopDropDownLocator = By.cssSelector("a.dropdown-item[href*='route=account/transaction']");
    By DownloadsFromTheTopDropDownLocator = By.cssSelector("a.dropdown-item[href*='route=account/download']");
    By LogoutFromTheTopDropDownLocator = By.cssSelector("a.dropdown-item[href*='route=account/logout']");
    public void clickOnUserIconFromMyAccountFromInNavBar() {driver.findElement(userIcon).click();}
    public void clickOnMyAccountFromMyAccountDropDownList(){driver.findElement(MyAccountFromTheTopDropDownLocator).click();}
    public void clickOnOrderHistoryFromDropDown() {driver.findElement(OrderHistoryFromTheTopDropDownLocator).click();}
    public void clickOnTransactionsFromDropDown(){driver.findElement(TransactionsFromTheTopDropDownLocator).click();}
    public void clickOnDownloadsFromDropDown() {driver.findElement(DownloadsFromTheTopDropDownLocator).click();}
    public void clickOnLogoutFromDropDown(){driver.findElement(LogoutFromTheTopDropDownLocator).click();}


    //the right list in my account page
    By MyAccountLinkListLocator = By.xpath("//a[@class='list-group-item' and text()='My Account']");
    By EditAccountLinkListLocator =By.xpath("//a[@class='list-group-item' and text()='Edit Account']") ;
    By PasswordLinkListLocator = By.xpath("//a[@class='list-group-item' and text()='Password']");
    public void clickOnMyAccountLinkList(){driver.findElement(MyAccountLinkListLocator).click();}
    public void ClickEditAccountLinkList(){driver.findElement(EditAccountLinkListLocator).click();}
    public void ClickPasswordLinkList(){driver.findElement(PasswordLinkListLocator).click();}







}
