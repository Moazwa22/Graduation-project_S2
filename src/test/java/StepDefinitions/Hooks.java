package StepDefinitions;

import Pages.HomePage.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public HomePage homePage;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
