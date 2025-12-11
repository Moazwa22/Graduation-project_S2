package StepDefinitions;

import Pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.opencart.com/index.php?route=cms/demo");
        driver.get("http://localhost/opencart/");

    }


    @After
    public void closeBrowser(){
        driver.quit();
    }
}
