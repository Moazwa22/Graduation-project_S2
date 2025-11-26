package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SpecialsPage {
    WebDriver driver;

    By products = By.cssSelector(".product-thumb");
    By oldPrice = By.cssSelector(".price-old");
    By newPrice = By.cssSelector(".price-new");

    public SpecialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyDiscountedProductsDisplayed() {
        List<WebElement> specialProducts = driver.findElements(products);
        Assert.assertTrue(specialProducts.size() > 0, "No discounted products found on Specials page!");
    }

    public void verifyOldAndNewPrices() {
        List<WebElement> oldPrices = driver.findElements(oldPrice);
        List<WebElement> newPrices = driver.findElements(newPrice);

        Assert.assertTrue(oldPrices.size() > 0, "Old prices not displayed for discounted products!");
        Assert.assertTrue(newPrices.size() > 0, "New prices not displayed for discounted products!");
    }
}

