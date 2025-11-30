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
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    By websiteIsAvailable = By.xpath("//a[@href = 'https://demo.opencart.com/']");
    By homePageLocator = By.id("carousel-banner-0");
    By products = By.cssSelector(".product-thumb");
    By bannerButtons = By.cssSelector("#menu .nav > li > a");
    By currencyButton = By.xpath("//span[@class = 'd-none d-md-inline']");
    By euroCurrency = By.xpath("//a[@href = 'EUR']");
    By poundStrCurrency = By.xpath("//a[@href = 'GBP']");
    By usDollarCurrency = By.xpath("//a[@href = 'USD']");
    public By P_Prices = By.className("price-new"); // بسبب ال wait في ال currency changing
    public By searchBar = By.name("search");
    By searchButton = By.xpath("//i[@class = 'fa-solid fa-magnifying-glass']");
    By contactNumber = By.xpath("//span[@class = 'd-none d-lg-inline']");
    By searchPageTitle_P = By.xpath("//h1[contains(text(), 'MacBook')]");
    By contactPageTitle = By.xpath("//h1[text()='Contact Us']");
    By myAccount = By.xpath("//span[text()='My Account']");
    By myAccountDropDown = By.xpath("//a[text()='My Account']");
    By accountOption1 = By.xpath("//a[text()='Register']");
    By accountOption2 = By.xpath("(//a[text()='Login'])");
    public By addToCartButtons = By.xpath("//i[@class='fa-solid fa-shopping-cart']");
    By registerPage = By.xpath("//h1[text()='Register Account']");
    By loginPage = By.xpath("//h2[text()='Returning Customer']");
    By wishlistButtonAtTheTop = By.xpath("//span[text() = 'Wish List (0)']");
    By wishListAtProduct = By.xpath("//button[@title='Add to Wish List']");
    By compareButtons = By.xpath("//button[@data-bs-original-title='Compare this Product']");
    By successAlert = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartIcon = By.xpath("//a[@title='Shopping Cart']");
    By footerLinks = By.cssSelector("footer a");

   // public boolean websiteIsAvailable_HP(){
     //   driver.get("https://www.opencart.com/index.php?route=cms/demo");
      //  return driver.findElement(websiteIsAvailable).isDisplayed();
    //}

    public boolean isHomePageLoaded_HP(){
      return driver.findElement(homePageLocator).isDisplayed();
    }

    public void scrollDownSmall() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }

    public int getNumberOfDisplayedProducts(){
        return driver.findElements(products).size();

    }

    public void clickBannerButton(String buttonName){
        List<WebElement> buttons = driver.findElements(bannerButtons);
        for (WebElement button : buttons){
            if(button.getText().equalsIgnoreCase(buttonName)) {
                button.click();
                break;
            }
        }
    }

   // public void clickOnProductsOnHomePage(){
      //  List<WebElement> productList = driver.findElements(products);
       // for (WebElement product : productList) {
         //   product.click();
        //}
    //}

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
        if (productPrices.isEmpty()) return false;

        for (WebElement price : productPrices) {
            String text = price.getText().trim();
            if (!text.contains(expectedSymbol)) return false;
        }
        return true;
    }


        public double[] getPrices() {
            List<WebElement> productPrices = driver.findElements(P_Prices);
            double[] prices = new double[productPrices.size()];

            for (int i = 0; i < productPrices.size(); i++) {
                String text = productPrices.get(i).getText().replaceAll("[^0-9.]", "").trim();
                prices[i] = Double.parseDouble(text);
            }
            return prices;

        }

        public boolean findProducts() {
        return driver.findElement(products).isDisplayed();
        }

    public void clickOnProduct(int index){
        driver.findElements(products).get(index).click();
    }

    public void userIsRedirectedToProductPage(){

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

    public void clickMyAccount(){
        driver.findElement(myAccount).click();
    }
    // searched I want to revise it to
    public boolean RegisterOptionIsVisible() {
        return driver.findElement(accountOption1).isDisplayed();
    }


    public boolean LoginOptionIsVisible() {
        return driver.findElement(accountOption2).isDisplayed();
    }

    public void clickRegister(){
        driver.findElement(accountOption1).click();
    }

    public void clickLogin(){
        driver.findElement(accountOption2).click();
    }

    public boolean userIsOnRegisterPage(){
        return driver.findElement(registerPage).isDisplayed();
    }

    public boolean userIsOnLogInPage(){
        return driver.findElement(loginPage).isDisplayed();
    }

    public boolean successMessageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
       return driver.findElement(successAlert).isDisplayed();
    }

    public void clickShoppingCart(){
        driver.findElement(shoppingCartIcon).click();
    }

    public void clickWishlistAtTheTop(){
        driver.findElement(wishlistButtonAtTheTop).click();
    }

    public boolean verifyUserIsLoggedIn(){
        driver.findElement(myAccount).click();
        return driver.findElement(myAccountDropDown).isDisplayed();
    }
    public void clickWishListButtonAtProduct(){
        driver.findElement(wishListAtProduct).click();
    }

    public boolean wishlistHasProducts() {
        return successMessageDisplayed();
    }

    public void clickCompare(int index){
        driver.findElements(compareButtons).get(index).click();
    }

    public boolean compareListHasProducts(){
        return successMessageDisplayed();
    }

    public void clickAllFooterLinks(){
        for(WebElement link : driver.findElements(footerLinks)){
            link.click();
            driver.navigate().back();
        }
    }
}
