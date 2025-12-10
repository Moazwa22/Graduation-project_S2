package Pages.GiftCertificate;

import StepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiftCertificatePage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public GiftCertificatePage(WebDriver driver) {
        this.driver = driver;
    }



}
