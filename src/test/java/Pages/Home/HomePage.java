package Pages.Home;

import Pages.MyAccount.LoginPage;
import Pages.SharedComponents.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Utilities {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //--------Tebry------//
    //By myAccount = By.xpath("//span[contains(text(), 'My Account')]");
    By loginButton = By.linkText("Login");
    //---------Esraa-------//
    By homePageLocator = By.xpath("//h3[text()='Featured']");
    By products = By.cssSelector(".product-thumb");
    By bannerButtons = By.cssSelector("#menu .nav > li > a");
    By showAllDesktops_B = By.xpath("//a[text()='Show All Desktops']");
    By showAllLaptops_B = By.xpath("//a[text()='Show All Laptops & Notebooks']");
    By showAllComponents = By.xpath("//a[text()='Show All Components']");
    By showAllMP3Players = By.xpath("//a[text()='Show All MP3 Players']");
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
    By accountOption1 = By.xpath("//a[text()='Register']");
    By accountOption2 = By.xpath("(//a[text()='Login'])");
    By E_mailFieldLogin = By.id("input-email");
    By passwordLogin = By.id("input-password");
    By logInButton = By.xpath("//button[@class='btn btn-primary']");
    By myAccountLogin = By.xpath("//h1[text() = 'My Account']");
    public By addToCartButtons = By.xpath("//button[@formaction='http://localhost/opencart/index.php?route=checkout/cart.add&language=en-gb']");
    By registerPage = By.xpath("//h1[text()='Register Account']");
    By loginPage = By.xpath("//h2[text()='Returning Customer']");
    By wishlistButtonAtTheTop = By.xpath("//span[text() = 'Wish List (0)']");
    By wishListAtProduct = By.xpath("//button[@title='Add to Wish List']");
    By wishListPageListWishList = By.xpath("//a[text()='Wish List']");
    public By compareButtons = By.xpath("//button[@title='Compare this Product']");
    public By successAlert = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartIcon = By.xpath("//a[@title='Shopping Cart']");
    By footerLinks = By.cssSelector("footer a");
    //------------Esraa-------------------//
    By addToCartIcons = By.xpath("//button[@type='submit']/i");
    By productNames = By.tagName("h4");
    By priceNew = By.className("price-new");
    By priceTax = By.className("price-tax");

    //----------Mohab--------------//
    By MyAccountLocator = By.linkText("My Account");
    By LoginLocator = By.xpath("//a[@class='dropdown-item' and text()='Login']");
    By RegisterLocator = By.xpath("//a[@class='dropdown-item' and text()='Register']");
    //----------Raneem------------//
    By searchInput = By.name("search");
   // By searchButton = By.cssSelector(".btn.btn-light.btn-lg");
    By specialsLink = By.linkText("Specials");
    By desktopsMenu = By.linkText("Desktops");
    // By macSubCategory = By.linkText("Mac");
    // By showAllDesktops = By.linkText("Show All Desktops");
    //------------Amr-------------//
    By myAccountDropdownLocator = By.xpath("//span[text()='My Account']");
    By loginLinkLocator = By.linkText("Login");
    By wishlistIconForProduct = By.cssSelector("button[formaction*='wishlist.add']");
    By wishlistCounterLocator = By.xpath("//span[contains(text(),'Wish List')]");
    By successMessageLocator = By.cssSelector("div.alert.alert-success");
    public boolean isHomePageLoaded_HP() {   //********************//
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement featured = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLocator));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", featured);

            return featured.isDisplayed();
        } catch (Exception homeNotLoaded) {
            return false;
        }
    }

    public void scrollDownSmall() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }

    public int getNumberOfDisplayedProducts() {
        return driver.findElements(products).size();  //********************************//
    }

    public void clickBannerButton(String buttonName) {

        List<WebElement> buttons = driver.findElements(bannerButtons);

        for (WebElement button : buttons) {
            if (button.getText().equalsIgnoreCase(buttonName)) {
                button.click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

                switch (buttonName.toLowerCase()) {

                    case "desktops":
                        wait.until(ExpectedConditions.visibilityOfElementLocated(showAllDesktops_B)).click();
                        break;

                    case "laptops & notebooks":
                        wait.until(ExpectedConditions.visibilityOfElementLocated(showAllLaptops_B)).click();
                        break;

                    case "components":
                        wait.until(ExpectedConditions.visibilityOfElementLocated(showAllComponents)).click();
                        break;

                    case "mp3 players":
                        wait.until(ExpectedConditions.visibilityOfElementLocated(showAllMP3Players)).click();
                        break;

                    default:
                        break;
                }

                break;
            }
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

    public boolean arePricesUpdated(String expectedSymbol) { //******************//
        List<WebElement> productPrices = driver.findElements(P_Prices);
        if (productPrices.isEmpty()) return false;

        for (WebElement price : productPrices) {
            String text = price.getText().trim();
            if (!text.contains(expectedSymbol)) return false;
        }
        return true;
    }


    public double[] getPrices() { //*********************//
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

    public void clickOnProduct(int index) {
        driver.findElements(products).get(index).click();
    }

    public void activeSearchbar() {
        driver.findElement(searchBar).click();
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getSearchPageTitleText() {
        return driver.findElement(searchPageTitle_P).getText();
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

    public boolean RegisterOptionIsVisible() {
        return driver.findElement(accountOption1).isDisplayed();
    }

    public boolean LoginOptionIsVisible() {
        return driver.findElement(accountOption2).isDisplayed();
    }

    public void clickRegister() {
        driver.findElement(accountOption1).click();
    }

    public void clickLogin() {
        driver.findElement(accountOption2).click();
    }

    public boolean userIsOnRegisterPage() {
        return driver.findElement(registerPage).isDisplayed();
    }

    public boolean userIsOnLogInPage() {
        return driver.findElement(loginPage).isDisplayed();
    }

    public boolean successMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return driver.findElement(successAlert).isDisplayed();
    }

    public void clickWishlistAtTheTop() {
        driver.findElement(wishlistButtonAtTheTop).click();
    }

    public boolean userIsRedirectedToWishlistPage() {
        driver.findElement(wishlistButtonAtTheTop).click();
        return driver.findElement(wishListPageListWishList).isDisplayed();
    }

    public boolean verifyUserIsOnLogInPage() {
        driver.findElement(myAccount).click();
        driver.findElement(accountOption2).click();
        return driver.findElement(loginPage).isDisplayed();
    }

    public boolean userIsLoggedIn(String E_MailAddress, String password) {
        driver.findElement(E_mailFieldLogin).sendKeys(E_MailAddress);
        driver.findElement(passwordLogin).sendKeys(password);
        driver.findElement(logInButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountLogin));
        return driver.findElement(myAccountLogin).isDisplayed();
    }

    public void goToHomePage() {
        driver.get("http://localhost/opencart/index.php?route=common/home&language=en-gb");
    }

    public void clickOnAddToProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButtons));
        btn.click();
    }

    public void clickWishListButtonAtProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement wishListButton = wait.until(ExpectedConditions.elementToBeClickable(wishListAtProduct));
        wishListButton.click();
    }

    public boolean wishlistHasProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return alert.isDisplayed();
    }

    public boolean compareListHasProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
        return successMessageDisplayed();
    }

    public void clickAllFooterLinks() {

        List<WebElement> links = driver.findElements(footerLinks);
        List<String> linkTexts = new ArrayList<>();
        for (WebElement link : links) {
            String text = link.getText().trim();
            if (!text.isEmpty()) {
                linkTexts.add(text);
            }
        }

        for (String text : linkTexts) {
            List<WebElement> exists = driver.findElements(By.linkText(text));
            if (exists.isEmpty()) {
                System.out.println("Skipping (not available to guest): " + text);
                continue;
            }
            WebElement link = exists.get(0);
            System.out.println("Clicking on: " + text);
            link.click();
            driver.navigate().back();

            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(footerLinks));
        }
    }

    //--------------------Esraa------------------//
    public void addMackBookToCart() {
        List<WebElement> buttons = driver.findElements(addToCartIcons);
        WebElement element = buttons.get(1);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }


    public String getPName() {
        return driver.findElements(productNames).get(0).getText();
    }


    public String getPriceN() {
        return driver.findElements(priceNew).get(0).getText();
    }


    public String getPriceT() {
        return driver.findElements(priceTax).get(0).getText();
    }

    public String getPriceN(String no) {
        double quantity = Double.parseDouble(no.trim());
        double unitNPrice = Double.parseDouble(getPriceN().replaceAll("[^0-9.]", ""));

        double total = quantity * unitNPrice;
        return String.valueOf(total);
    }

    public String getPriceT(String no) {
        double quantity = Double.parseDouble(no.trim());
        double unitTPrice = Double.parseDouble(getPriceN().replaceAll("[^0-9.]", ""));

        double total = quantity * unitTPrice;
        return String.valueOf(total);
    }
    //-------------Mohab----------------//
    public void  ClickOnMyAccountIcon(){
        driver.findElement(MyAccountLocator).click();
    }

    public LoginPage ClickOnLogin(){
        driver.findElement(LoginLocator).click();
        return new LoginPage(driver);
    }
    public void clickOnRegister()
    {
        driver.findElement(RegisterLocator).click();
    }

    //----------Raneem------------//
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

    public void hoverDesktopsMenu() {
        WebElement menu = driver.findElement(desktopsMenu);
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
    }


    /*public void clickMacCatagory() {
        driver.findElement(macSubCategory).click();
    }*/

    public void clickMacCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mac = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Mac")));
        mac.click();
    }
    //--------Tebry------//
    public LoginPage login(){
        driver.findElement(myAccount).click();
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    //---------AMR abo bakr -----------//
    public void clickMyAccountDropdown() {
        driver.findElement(myAccountDropdownLocator).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLinkLocator).click();
    }

    public void clickOnWishlistIcon() {
        driver.findElement(wishlistIconForProduct).click();
    }

    public void clickOnWishlistCounter() {
        driver.findElement(wishlistCounterLocator).click();
    }

    public String getWishlistCounterText() {
        return driver.findElement(wishlistCounterLocator).getText();
    }

    public int getWishlistCount() {
        String text = getWishlistCounterText();
        String numberOnly = text.replaceAll("[^0-9]", "");
        if (numberOnly.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numberOnly);
    }

}