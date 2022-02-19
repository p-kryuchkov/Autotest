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
import pages.ArrangeInsurancePage;
import pages.TravelInsurancePage;
import util.TestProperties;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ScenarioSteps {
    HomeSteps homeSteps = new HomeSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
    OfferButtonSteps offerButtonSteps = new OfferButtonSteps();
    ArrangeInsuranceSteps arrangeInsuranceSteps = new ArrangeInsuranceSteps(BaseSteps.getDriver());

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
    public void stepOfferButtonIns() throws InterruptedException {
        Thread.sleep(1000);
        arrangeInsuranceSteps.stepOfferButton();

    }

    @When("^выполнен выбор пола Мужской$")
    public void stepMaleButton() {
        arrangeInsuranceSteps.stepMaleButton();

    }

    @When("заполняются поля:")
    public void stepFillFields(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> {
                    try {
                        arrangeInsuranceSteps.stepFillField(field, value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }


    @When("^выполнено нажатие на кнопку Далее$")
    public void stepNextButton() {
        arrangeInsuranceSteps.stepNextButton();
    }

    @When("^переходит на другую вкладку$")
    public void stepNextTab() {
        for (String winHandle : BaseSteps.getDriver().getWindowHandles()) {
            BaseSteps.getDriver().switchTo().window(winHandle);
        }
    }

    @Then("^заговолок страницы после выбора страхования в каталоге: \"(.+)\"$")
    public void checkPageTitle(String title) {
        travelInsuranceSteps.checkTitle(title);
    }

    @Then("^заговолок страницы в новой вкладке: \"(.+)\"$")
    public void checkNewPageTitle(String title) {
        arrangeInsuranceSteps.checkTitle(title);
    }

    @Then("^проверяет значения полей :$")
    public void checkFillForm(DataTable fields) {
        fields.<String, String>asMap(String.class, String.class)
                .forEach((field, value) -> arrangeInsuranceSteps.checkFillField(field, value));
    }
    @Then("^в поле \"(.+)\" сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage) {
        arrangeInsuranceSteps.checkErrorMessage(field, errorMessage);
    }
}






