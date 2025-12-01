package Pages.Wishlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {
    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    By macBook = By.xpath("//div[@id='content']//a[text()='MacBook']");
    By removeBtn = By.cssSelector("a.btn.btn-danger");
    By emptyMessage = By.xpath("//div[@id='wishlist']/p");
    By cartBtn = By.cssSelector("button.btn-dark.dropdown-toggle");
    By addToCartBtn = By.cssSelector("button.btn.btn-primary.mb-1[form='form-product-0']");
    By removeBtnFromCart = By.cssSelector("button.btn-danger i.fa-circle-xmark");
    By emptyCartMessage = By.cssSelector("li.text-center.p-4");
    By viewCart = By.linkText("View Cart");
    By checkout = By.cssSelector("a strong i.fa-share");
    By MyAccountLinkLocator = By.xpath("//a[@class='list-group-item' and text()='My Account']");
    By EditAccountLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Edit Account']");
    By PasswordLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Password']");
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
    By LogoutLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Logout']");

    public void productDisplayed() {
        driver.findElement(macBook).isDisplayed();
    }

    public void clickRemoveButton() {
        driver.findElement(removeBtn).click();
    }

    public void emptyMessageAppear() {
        driver.findElement(emptyMessage).isDisplayed();
    }

    public void clickAddToCartButtonOnProduct() {
        driver.findElement(addToCartBtn).click();
    }

    public String getCartButtonText() {
        return driver.findElement(cartBtn).getText();
    }

    public int getCartItemsCount() {
        String text = getCartButtonText();
        String countPart = text.split(" item")[0].trim();
        return Integer.parseInt(countPart);
    }

    public double getCartTotalPrice() {
        String text = getCartButtonText();
        String pricePart = text.split("-")[1]
                .replace("$", "")
                .replace(",", "")
                .trim();

        return Double.parseDouble(pricePart);
    }

    public void clickOnRemoveButtonOnCart() {
        driver.findElement(removeBtnFromCart).click();
    }

    public void userClickOnCart() {
        driver.findElement(cartBtn).click();
    }

    public int getDropdownQuantity() {
        WebElement qtyCell = driver.findElement(By.xpath("//td[contains(text(),'x')]"));
        String text = qtyCell.getText();
        String number = text.replace("x", "").trim(); // "2"
        return Integer.parseInt(number);
    }

    public void openCartDropdown() {
        driver.findElement(cartBtn).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessage).getText();
    }

    public void clickViewCart() {
        driver.findElement(viewCart).click();
    }

    public void clickCheckout() {
        driver.findElement(checkout).click();
    }

    public void clickOnMyAccountLink() {
        driver.findElement(MyAccountLinkLocator).click();
    }

    public void clickOnEditAccountLink() {
        driver.findElement(EditAccountLinkLocator).click();
    }

    public void clickOnPasswordLink() {
        driver.findElement(PasswordLinkLocator).click();
    }

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

    public void clickOnSubscriptionsLink() {
        driver.findElement(SubscriptionsLinkLocator).click();
    }

    public void clickOnRewardPointsLink() {
        driver.findElement(RewardPointsLinkLocator).click();
    }

    public void clickOnReturnsLink() {
        driver.findElement(ReturnsLinkLocator).click();
    }

    public void clickOnTransactionsLink() {
        driver.findElement(TransactionsLinkLocator).click();
    }

    public void clickOnNewsletterLink() {
        driver.findElement(NewsletterLinkLocator).click();
    }

    public void clickOnLogoutLink() {
        driver.findElement(LogoutLinkLocator).click();
    }

}

