package Steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
public class ScenarioSteps {
    HomeSteps homeSteps = new HomeSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    OfferButtonSteps offerButtonSteps = new OfferButtonSteps();
    ArrangeInsuranceSteps arrangeInsuranceSteps = new ArrangeInsuranceSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectTopMenu(String menuItem) {
        homeSteps.stepSelectTopMenu(menuItem);

    }

    @When("^выбран подпункт меню \"(.+)\"$")
    public void stepSelectSubMenu(String menuItem) {
        homeSteps.stepSelectSubMenu(menuItem);


    }

    @When("^выполнено нажатие на кнопку Закрыть$")
    public void stepCookieWarningCloseButton() {
        catalogSteps.stepCookieWarningCloseButton();

    }

    @When("^выбран вид страхования \"(.+)\"$")
    public void stepSelectProductCarusel(String menuItem) {
        catalogSteps.stepSelectProductCarusel(menuItem);
    }
    @When("^выполнено нажатие на кнопку Оформить онлайн$")
    public void stepOfferButton() {
        travelInsuranceSteps.stepOfferButton();

    }
    @When("^выполнено нажатие на кнопку Оформить на сайте$")
    public void stepOnlineOfferButton() {
        offerButtonSteps.stepOfferButton();

    }
    @When("^выбран тип страхования \"(.+)\"$")
    public void stepSelectTypesOfInsurance(String menuItem) {
        arrangeInsuranceSteps.stepSelectTypesOfInsurance(menuItem);
    }
    @When("^выполнено нажатие на кнопку Оформить$")
    public void stepOfferButtonIns() {
        arrangeInsuranceSteps.stepOfferButton();

    }
    @When("^выполнен выбор пола Мужской$")
    public void stepMaleButton() {
        arrangeInsuranceSteps.stepMaleButton();

    }
    @When("заполняются поля:")
    public void stepFillFields(DataTable fields){
          fields.asMap(String.class, String.class).forEach((key, value) -> {
              try {
                  arrangeInsuranceSteps.stepFillField(key, value);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          });
    }
    @When("^выполнено нажатие на кнопку Далее$")
    public void stepNextButton() {
        arrangeInsuranceSteps.stepNextButton();
}}






