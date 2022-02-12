package Steps;

import io.qameta.allure.Step;
import pages.HomePage;

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

public class HomeSteps {
    @Step("Выбор пункта меню")
    public void stepSelectTopMenu (String menuItem) {
     new HomePage(driver).selectTopMenu(menuItem);
    }
    @Step("Выбор подпункта меню")
    public void stepSelectSubMenu (String menuItem) {
        new HomePage(driver).selectTopMenu(menuItem);
    }


}
