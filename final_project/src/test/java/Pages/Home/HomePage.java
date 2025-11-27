package Pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By myAccountDropdownLocator = By.xpath("//span[text()='My Account']");
    By loginLinkLocator = By.linkText("Login");
    By wishlistIcon = By.xpath("(//button[@data-bs-toggle='tooltip'][@title='Add to Wish List'])[1]");
    //By wishlistCounterLocator = By.id("wishlist-total");
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

    public void clickOnWishlistIcon(){
        driver.findElement(wishlistIcon).click();
    }

//    public void clickWishlistByProductName(String productName) {
//        driver.findElement(By.xpath("//h4/a[text()='" + productName + "']/../../..//button[@title='Add to Wish List']")).click();
//    }

    public void successMessageDisplayed() {
         driver.findElement(successMessageLocator).isDisplayed();
    }
}