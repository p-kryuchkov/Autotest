package Steps;

import io.qameta.allure.Step;
import pages.CatalogPage;
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

import static Steps.BaseSteps.driver;

public class CatalogSteps extends HomeSteps{
    @Step("Выбор вида страхования")
    public void stepSelectProductCarusel (String menuItem) {
        new CatalogPage(driver).selectProductCarusel(menuItem);
    }
    @Step("Закрытие предупреждения о использовании куки")
    public void stepCookieWarningCloseButton () {
        new CatalogPage(driver).cookieWarningCloseButton.click();
    }
}
