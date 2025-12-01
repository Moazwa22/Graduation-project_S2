package Pages.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By myAccountDropdownLocator = By.xpath("//span[text()='My Account']");
    By loginLinkLocator = By.linkText("Login");
    By wishlistIconForProduct = By.cssSelector("button[formaction*='wishlist.add']");
    By wishlistCounterLocator = By.xpath("//span[contains(text(),'Wish List')]");
    By successMessageLocator = By.cssSelector("div.alert.alert-success");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountDropdown() {
        driver.findElement(myAccountDropdownLocator).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLinkLocator).click();
    }

    public void clickOnWishlistIcon() {
        driver.findElement(wishlistIconForProduct).click();
    }

    public void clickOnWishlistCounter() {
        driver.findElement(wishlistCounterLocator).click();
    }

    public void successMessageDisplayed() {

        driver.findElement(successMessageLocator).isDisplayed();
    }

    public String getWishlistCounterText() {
        return driver.findElement(wishlistCounterLocator).getText();
    }

    public int getWishlistCount() {
        String text = getWishlistCounterText();
        String numberOnly = text.replaceAll("[^0-9]", "");
        if (numberOnly.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numberOnly);
    }


}

