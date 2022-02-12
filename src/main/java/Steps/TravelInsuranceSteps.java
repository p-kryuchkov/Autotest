package Steps;

import io.qameta.allure.Step;
import pages.TravelInsurancePage;

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

public class TravelInsuranceSteps extends BaseSteps{
    @Step("Нажатие на кнопку \"Оформить онлайн\"")
    public void stepOfferButton () {
        new TravelInsurancePage(driver).offerButton.click();
    }
}
