/*
package Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CatalogPage {
    WebDriver driver;

    By products = By.cssSelector(".product-thumb");
    By productName = By.cssSelector(".caption h4 a");
    By productPrice = By.cssSelector(".caption .price");
    By discountedPrice = By.cssSelector(".price-new");
    By addToCartButton = By.id("button-cart");
    By addToWishlistButton = By.cssSelector("button[data-bs-original-title='Add to Wish List']");
    By addToCompareButton = By.cssSelector("button[data-original-title='Compare this Product']");



    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkProductsDisplayed() {
        List<WebElement> list = driver.findElements(products);
        Assert.assertTrue(list.size() > 0, "No products found in catalog!");
    }

    public void verifyProductsHaveNameAndPrice() {
        List<WebElement> names = driver.findElements(productName);
        List<WebElement> prices = driver.findElements(productPrice);
        Assert.assertTrue(names.size() > 0, "No product names found!");
        Assert.assertTrue(prices.size() > 0, "No product prices found!");
    }



    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

    public void clickAddToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

    public void clickAddToCompare() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCompareButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }
}
*/

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CatalogPage {
    WebDriver driver;


    By products = By.cssSelector(".product-thumb");
    By productName = By.cssSelector(".caption h4 a");
    By productPrice = By.cssSelector(".caption .price");
    //By discountedPrice = By.cssSelector(".price-new");
    By addToCartButton = By.cssSelector("button[data-bs-original-title='Add to Cart']");
    By addToWishlistButton = By.cssSelector("button[data-bs-original-title='Add to Wish List']");
    By addToCompareButton = By.cssSelector("button[data-bs-original-title='Compare this Product']");


    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }


    public void checkProductsDisplayed() {
        List<WebElement> list = driver.findElements(products);
        Assert.assertTrue(list.size() > 0, "No products found in catalog!");
    }

    public void verifyProductsHaveNameAndPrice() {
        List<WebElement> names = driver.findElements(productName);
        List<WebElement> prices = driver.findElements(productPrice);
        Assert.assertFalse(names.isEmpty() );
        Assert.assertFalse(prices.isEmpty());
    }

    // Add To Cart
    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

    // Add To Wishlist
    public void clickAddToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

    // Add To Compare
    public void clickAddToCompare() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCompareButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

}
