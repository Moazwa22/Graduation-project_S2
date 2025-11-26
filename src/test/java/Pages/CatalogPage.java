package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CatalogPage {
    WebDriver driver;

    By products = By.cssSelector(".product-thumb");
    By productName = By.cssSelector(".caption h4 a");
    By productPrice = By.cssSelector(".caption .price");
    By discountedPrice = By.cssSelector(".price-new");

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

    public void verifyDiscountsDisplayed() {
        List<WebElement> specials = driver.findElements(discountedPrice);
        Assert.assertTrue(specials.size() > 0, "No discounted prices found!");
    }

    public void verifyDiscountPriceFormat() {
        List<WebElement> specials = driver.findElements(products);
        for (WebElement product : specials) {
            String text = product.getText();
            Assert.assertTrue(text.contains("Ex Tax") || text.contains("Price"), "Discount format not found for product: " + text);
        }
    }
}
