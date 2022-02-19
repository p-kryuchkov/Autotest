package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ArrangeInsurancePage;
import pages.TravelInsurancePage;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class ArrangeInsuranceSteps {
    public ArrangeInsuranceSteps(WebDriver driver) {
    }

    @Step("Выбор срахования")
    public void stepSelectTypesOfInsurance(String menuItem) {
        new ArrangeInsurancePage(BaseSteps.getDriver()).selectTypesOfInsurance(menuItem);
    }
    @Step("Нажатие на кнопку \"Оформить\"")
    public void stepOfferButton () {
        new ArrangeInsurancePage(BaseSteps.getDriver()).offerButton.click();
    }
    @Step("Нажатие на кнопку \"Мужской\"")
    public void stepMaleButton () {
        new ArrangeInsurancePage(BaseSteps.getDriver()).male.click();
    }
    @Step("Нажатие на кнопку \"Далее\"")
    public void stepNextButton () {
        new ArrangeInsurancePage(BaseSteps.getDriver()).nextButton.click();
    }
    @Step("Нажатие на поле с вводом даты рождения")
    public void stepClickBD () {
        new ArrangeInsurancePage(BaseSteps.getDriver()).birthDate.click();
    }
    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) throws InterruptedException {
        new ArrangeInsurancePage(BaseSteps.getDriver()).fillField(field, value);
    }
    @Step
    public void checkErrorMessage(String field,  String value){
        new ArrangeInsurancePage(BaseSteps.getDriver()).checkErrorMessage(field, value);
    }
    @Step()
    public void checkFillField(String field, String value) {
        String actual = new ArrangeInsurancePage(BaseSteps.getDriver()).checkFillField(field);
        assertTrue(String.format("Значение поля |[%s]| равно - [%s]. Ожидалось - [%s]", field, actual, value), actual.equals(value));
    }
   @Step
   public void stepFillFields(HashMap<String, String> fields) {
       fields.forEach((key, value) -> {
           try {
               stepFillField(key, value);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
   }



    @Step("Проверка полей")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((key, value) -> checkFillField(key, value));
    }

   @Step("Проверка заголовка страницы -  равен {0}")
   public void checkTitle(String expectedTitle){
       String actualTitle = new ArrangeInsurancePage(BaseSteps.getDriver()).title.getText();
       String expectedTitle2 = "Страхование путешественников";
       assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
   }
}

