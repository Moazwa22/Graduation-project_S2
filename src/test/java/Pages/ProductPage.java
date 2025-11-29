package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    By productTitle = By.cssSelector("h1");
    By productPrice = By.cssSelector(".list-unstyled h2");
    By addToCartBtn = By.id("button-cart");
    By successMessage = By.cssSelector(".alert-success");
    By wishlistButton = By.cssSelector("button[data-bs-original-title='Add to Wish List']");
    By compareButton = By.cssSelector("button[data-original-title='Compare this Product']");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }


    public void verifyProductTitle(String expected) {
        String actual = driver.findElement(productTitle).getText().trim();
        if (!actual.equals(expected))
            throw new AssertionError("Expected: " + expected + " but found: " + actual);
    }

    public void verifyProductPrice() {
        driver.findElement(productPrice).isDisplayed();
    }

    /*public void verifyAddToCartVisible() {
        driver.findElement(addToCartBtn).isDisplayed();
    }*/

    /*public void clickAddToCart() {
        driver.findElement(addToCartBtn).isDisplayed();
    }*/

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public boolean isCartSuccessMessageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }



    public void clickAddToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Scroll the button into view
        WebElement button = driver.findElement(wishlistButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        // Wait until the button is visible and clickable
        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        // Click the button
        button.click();
    }

    public boolean isWishlistSuccessMessageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }

    /*public void clickAddToCompare() {
        driver.findElement(compareButton).click();
    }*/

    public void clickAddToCompare() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement button = driver.findElement(compareButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    public boolean isCompareSuccessMessageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
}
