package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

   // By HomePage = By.xpath()
    By products = By.cssSelector(".product-thumb");
    By bannerButtons = By.cssSelector("#menu .nav > li > a");
    By currencyButton = By.cssSelector(".btn-group > button.dropdown-toggle");
    By euroCurrency = By.name("EUR");
    By poundStrCurrency = By.name("GBP");
    By usDollarCurrency = By.name("USD");
    By productPrices = By.cssSelector(".price .price-new");
    public By searchBar = By.name("search");
    By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
    By contactNumber = By.cssSelector("ul.list-inline li a[href*='contact']");
    By searchPageTitle = By.cssSelector("div#content h1");
    By contactPageTitle = By.cssSelector("#content h1");
    By myAccount = By.xpath("//span[text()='My Account']");
    By accountOptions = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a");
    By addToCartButtons = By.xpath("//button[@data-bs-original-title='Add to Cart']");
    By wishlistButtons = By.xpath("//button[@data-bs-original-title='Add to Wish List']");
    By compareButtons = By.xpath("//button[@data-bs-original-title='Compare this Product']");
    By successAlert = By.cssSelector(".alert-success");
    By shoppingCartIcon = By.cssSelector("a[title='Shopping Cart']");
    By wishlistTopIcon = By.cssSelector("a[title='Wish List']");
    By footerLinks = By.cssSelector("footer a");


    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("Your Store");
    }

    public int getNumberOfDisplayedProducts() {
        return driver.findElements(products).size();
    }

    public void clickBannerButton(String buttonName) {
        List<WebElement> buttons = driver.findElements(bannerButtons);
        for (WebElement button : buttons) {
            button.click();
        }
    }

    public void clickOnProductsOnHomePage(){
        List<WebElement> productList = driver.findElements(products);
        for (WebElement product : productList) {
            driver.findElement(products).click();
        }
    }

    public void clickOnCurrencyButton() {
        driver.findElement(currencyButton).click();
    }

    public void clickOnEuroCurrency() {
        driver.findElement(euroCurrency).click();
    }

    public void clickOnPoundStrCurrency() {
        driver.findElement(poundStrCurrency).click();
    }

    public void clickOnUsDollarCurrency() {
        driver.findElement(usDollarCurrency).click();
    }

    public boolean arePricesUpdated(String expectedSymbol) {
        List<WebElement> productPricesList = driver.findElements(productPrices);
        if (productPricesList.isEmpty()){
            return false;
        }

        for (WebElement price : productPricesList) {
            String text = price.getText().trim();
            if (!text.contains(expectedSymbol)) {
                System.out.println("Price not updated correctly: " + text);
                return false;
            }
        }
        return true;
    }

    public boolean correctPriceConversion(String targetCurrency) {
        List<WebElement> productPricesList = driver.findElements(productPrices);
        Assert.assertFalse(productPricesList.isEmpty(), "No product prices found!");

        double[] basePricesUSD = {602.00, 123.20, 122.00};
        double exchangeRate = 1.0;
        String symbol = "$";

        switch (targetCurrency.toLowerCase()) {
            case "euro" -> { exchangeRate = 1.15; symbol = "€"; }
            case "pound sterling" -> { exchangeRate = 0.85; symbol = "£"; }
            case "usd" -> { exchangeRate = 1.0; symbol = "$"; }
        }

        boolean allPricesCorrect = true;

        for (int i = 0; i < productPricesList.size(); i++) {
            WebElement priceElement = productPricesList.get(i);
            String priceText = priceElement.getText().replace(symbol, "").replace(",", "").trim();

            if (priceText.isEmpty()) {
                allPricesCorrect = false;
                continue;
            }

            double actualPrice = Double.parseDouble(priceText);
            double expectedPrice = basePricesUSD[i] * exchangeRate;

            if (Math.abs(actualPrice - expectedPrice) > 0.01) {
                allPricesCorrect = false;
                System.out.println("Price mismatch for product " + (i + 1) +
                        ": expected " + expectedPrice + ", found " + actualPrice);
            }
        }
        return allPricesCorrect;
    }


    public void clickOnProduct(int index) {
        driver.findElements(products).get(index).click();
    }


    public void activateSearchBar() {
        driver.findElement(searchBar).click();
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getSearchPageTitleText() {
        return driver.findElement(searchPageTitle).getText();
    }


    public void clickContactNumber() {
        driver.findElement(contactNumber).click();
    }

    public boolean isOnContactUsPage() {
        return driver.findElement(contactPageTitle).isDisplayed();
    }


    public void clickMyAccount() {
        driver.findElement(myAccount).click();
    }

    public List<String> getAccountOptions() {
        return driver.findElements(accountOptions).stream().map(WebElement::getText).toList();
    }

    public void clickRegister() {
        driver.findElements(accountOptions).get(0).click();
    }

    public void clickLogin() {
        driver.findElements(accountOptions).get(1).click();
    }

    public void clickAddToCartForProduct(int index) {
        driver.findElements(addToCartButtons).get(index).click();
    }

    public boolean successMessageDisplayed() {
        return !driver.findElements(successAlert).isEmpty();
    }

    public boolean cartHasProducts() {
        return successMessageDisplayed();
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCartIcon).click();
    }

    public void clickWishlist(int index) {
        driver.findElements(wishlistButtons).get(index).click();
    }

    public boolean wishlistHasProducts() {
        return successMessageDisplayed();
    }

    public void clickTopWishlist() {
        driver.findElement(wishlistTopIcon).click();
    }

    public void clickCompare(int index) {
        driver.findElements(compareButtons).get(index).click();
    }

    public boolean compareListHasProducts() {
        return successMessageDisplayed();
    }

    // Footer
    public void clickAllFooterLinks() {
        List<WebElement> links = driver.findElements(footerLinks);
        for (WebElement link : links) {
            link.click();
            driver.navigate().back();
        }
    }
}
