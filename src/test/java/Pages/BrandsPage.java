package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandsPage {

    WebDriver driver;
    By homePageLocator = By.id("carousel-banner-0");
    By brandsTextLink = By.linkText("Brands");
    By brandsPage = By.xpath("//h1[text() = 'Find Your Favorite Brand']");
    By brandName = By.xpath("//a[text() = 'Apple']");
    By alphabetLetter = By.xpath("//a[text() = 'A']");

    public BrandsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean userIsOnHomePage(){
        return driver.findElement(homePageLocator).isDisplayed();
    }

    public void clickOnBrandsLink() {
        driver.findElement(brandsTextLink).click();
    }

    public boolean isBrandsPageDisplayed() {
        return driver.findElement(brandsPage).isDisplayed();
    }


    public void clickOnAlphabetLetter(String letter) {
        driver.findElement(alphabetLetter).click();
    }

    public boolean hasScrolledToLetter(String letter) {
        List<WebElement> brands = driver.findElements(brandName);
        return brands.stream().anyMatch(e -> e.getText().startsWith(letter));
    }

    public void clickOnBrand() {
        driver.findElement(brandName).click();
    }

    public boolean isBrandProductsPage(String brandName) {
        return driver.getTitle().toLowerCase().contains(brandName.toLowerCase());
    }
}