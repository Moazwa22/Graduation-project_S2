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
    By productName = By.cssSelector(".product-thumb h4 a");
    By productPrice = By.cssSelector(".product-thumb .price");
    //By discountedPrice = By.cssSelector(".product-thumb .price-new");
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

        Assert.assertTrue(names.size() > 0, "No product names found!");
        Assert.assertTrue(prices.size() > 0, "No product prices found!");
    }

    // Add To Cart
    public void clickAddToCart() {

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[title='Add to Cart']"));
        WebElement first = buttons.get(0);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", first);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(first)).click();
    }


    // Add To Wishlist
    public void clickAddToWishlist() {

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[title='Add to Wish List']"));
        WebElement first = buttons.get(0);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", first);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(first)).click();
    }


    // Add To Compare
    public void clickAddToCompare() {

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[title='Compare this Product']"));
        WebElement first = buttons.get(0);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", first);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(first)).click();
    }



}