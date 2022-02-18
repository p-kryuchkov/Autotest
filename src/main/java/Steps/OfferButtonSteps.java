package Steps;

import io.qameta.allure.Step;
import pages.OfferButtonPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OfferButtonSteps {
    @Step("Нажатие на кнопку \"Оформить на сайте\"")
    public void stepOfferButton () {
        new OfferButtonPage().offerButton.click();
    }
}
