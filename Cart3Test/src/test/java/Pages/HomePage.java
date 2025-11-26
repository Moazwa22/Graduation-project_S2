package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    By products = By.cssSelector(".product-thumb");
    By bannerButtons = By.cssSelector("#menu .nav > li > a");
    By currencyButton = By.className("d-none");
    By euroCurrency = By.xpath("//a[@href = 'EUR']");
    By poundStrCurrency = By.xpath("//a[@href = 'GBP']");
    By usDollarCurrency = By.xpath("//a[@href = 'USD']");
    By P_Prices = By.className("price-new");
   public By searchBar = By.xpath("//input[@class='form-control form-control-lg']");
    By searchButton = By.xpath("//i[@class = 'fa-solid fa-magnifying-glass']");
    By contactNumber = By.xpath("//span[@class = 'd-none d-lg-inline']");
    By searchPageTitle_P = By.xpath("//h1[contains(text(), 'MacBook'");
    By contactPageTitle = By.xpath("//h1[text()='Contact Us']");
   public boolean isHomePageLoaded(){
        return driver.getTitle().contains("Your Store");
    }

    public int getNumberOfDisplayedProducts(){
        return driver.findElements(products).size();

    }

    public void clickBannerButton(String buttonName){
        List<WebElement> buttons = driver.findElements(bannerButtons);
        for (WebElement button : buttons){
            if (button.getText().equalsIgnoreCase(buttonName)){
                button.click();
            }
        }
    }
    public void clickOnCurrencyButton(){
        driver.findElement(currencyButton).click();
    }

    public void clickOnEuroCurrency(){
        driver.findElement(euroCurrency).click();
    }

    public void clickOnPoundStrCurrency(){
        driver.findElement(poundStrCurrency).click();
    }

    public void clickOnUsDollarCurrency(){
        driver.findElement(usDollarCurrency).click();
    }
    public boolean arePricesUpdated(String expectedSymbol) {
        List<WebElement> productPrices = driver.findElements(P_Prices);
        if (productPrices.isEmpty()) {
            return false;
        }

        for (WebElement price : productPrices) {
            String text = price.getText().trim();
            if (!text.contains(expectedSymbol)) {
                System.out.println("Price not updated correctly: " + text);
                return false;
            }else {
                System.out.println("Price successfully updated ");
            }
        }
        return true;
    }
    public boolean correctPriceConversion( String targetCurrency)
    {
        List<WebElement> productPrices = driver.findElements(P_Prices);
        Assert.assertFalse(productPrices.isEmpty(), "No product prices found!");

        double[] basePricesUSD = {602.00, 123.20, 122.00};
        double exchangeRate = 1.0;
        String symbol = "$";
        switch(targetCurrency.toLowerCase()) {
            case "euro":
                exchangeRate = 1.15;
                symbol = "€";
                break;
            case "pound sterling":
                exchangeRate = 0.85;
                symbol = "£";
                break;
            case "usd":
                exchangeRate = 1.0;
                symbol = "$";
                break;
        }

        boolean allPricesCorrect = true;

        for (int i = 0 ; i < productPrices.size(); i++) {
            WebElement pPrice = productPrices.get(i);
            String priceText = pPrice.getText().replace(symbol, "").trim();

            if (priceText.isEmpty()) {
                allPricesCorrect = false;
                continue;
            }

            double actualPrice = Double.parseDouble(priceText);
            double expectedPrice = basePricesUSD[i] * exchangeRate;

            if (Math.abs(actualPrice - expectedPrice) > 0.01) {
                allPricesCorrect = false;
                System.out.println("Price mismatch for product : " + (i + 1) + " , expected : " + expectedPrice + ", found : " + actualPrice);
            }
        }
        return allPricesCorrect;
    }

    public void clickOnProduct(int index){
        List<WebElement> eachProduct = driver.findElements(products);

        for (WebElement productVisible : eachProduct){
            productVisible.click();
        }
    }
// عايز اسأل فيها اعملها ولا ملهاش لازمة
    public void activeSearchbar(){
        driver.findElement(searchBar).click();
    }

    public void searchForProduct(String productName){
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getSearchPageTitleText() {
        return driver.findElement(searchPageTitle_P).getText();
    }

    public void clickContactNumber(){
        driver.findElement(contactNumber).click();
    }

    public boolean isOnContactUsPage() {
        return driver.findElement(contactPageTitle).isDisplayed();
    }

}
