package Pages;

import Pages.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RightListButton {
    WebDriver driver;

    public RightListButton(WebDriver driver)
    {
        this.driver = driver;
    }


    By MyAccountLinkLocator = By.xpath("//a[@class='list-group-item' and text()='My Account']");
    By PaymentMethodsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Payment Methods']");
    By AddressBookLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Address Book']");
    By WishListLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Wish List']");
    By OrderHistoryLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Order History']");
    By DownloadsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Downloads']");
    By SubscriptionsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Subscriptions']");
    By RewardPointsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Reward Points']");
    By ReturnsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Returns']");
    By TransactionsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Transactions']");
    By NewsletterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Newsletter']");



    public void clickOnMyAccountLinkFromRegisterPage(){driver.findElement(MyAccountLinkLocator).click();}
    public void clickOnPaymentMethodsLink() {
        driver.findElement(PaymentMethodsLinkLocator).click();
    }
    public void clickOnAddressBookLink() {
        driver.findElement(AddressBookLinkLocator).click();
    }
    public void clickOnWishListLink() {
        driver.findElement(WishListLinkLocator).click();
    }
    public void clickOnOrderHistoryLink() {
        driver.findElement(OrderHistoryLinkLocator).click();
    }
    public void clickOnDownloadsLink() {
        driver.findElement(DownloadsLinkLocator).click();
    }
    public void clickOnSubscribtionsLink() {driver.findElement(SubscriptionsLinkLocator).click();}
    public void clickOnRewardPointsLink(){driver.findElement(RewardPointsLinkLocator).click();}
    public void clickOnReturnsLink(){driver.findElement(ReturnsLinkLocator).click();}
    public void clickOnTransactionsLink(){driver.findElement(TransactionsLinkLocator).click();}
    public void clickOnNewslettersLink(){driver.findElement(NewsletterLinkLocator).click();}

}