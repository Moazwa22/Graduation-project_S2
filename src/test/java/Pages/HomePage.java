package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By searchInput = By.name("search");
    By searchButton = By.cssSelector(".btn.btn-light.btn-lg");
    By specialsLink = By.linkText("Specials");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
    }

    public void clickSubCategory(String subCategoryName) {
        driver.findElement(By.linkText(subCategoryName)).click();
    }

    public void search(String keyword) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public void openProductFromResults(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void openSpecialsPage() {
        driver.findElement(specialsLink).click();
    }
}

