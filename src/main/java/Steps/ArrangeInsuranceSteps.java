package Steps;

import io.qameta.allure.Step;
import pages.ArrangeInsurancePage;

import java.util.HashMap;

public class ArrangeInsuranceSteps extends BaseSteps{
    @Step("Выбор срахования")
    public void stepSelectTypesOfInsurance(String menuItem) {
        new ArrangeInsurancePage(driver).selectTypesOfInsurance(menuItem);
    }
    @Step("Нажатие на кнопку \"Оформить\"")
    public void stepOfferButton () {
        new ArrangeInsurancePage(driver).offerButton.click();
    }
    @Step("Нажатие на кнопку \"Мужской\"")
    public void stepMaleButton () {
        new ArrangeInsurancePage(driver).male.click();
    }
    @Step("Нажатие на кнопку \"Далее\"")
    public void stepNextButton () {
        new ArrangeInsurancePage(driver).nextButton.click();
    }
    @Step("Нажатие на поле с вводом даты рождения")
    public void stepClickBD () {
        new ArrangeInsurancePage(driver).birthDate.click();
    }
    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(Object field, Object value) throws InterruptedException {
        new ArrangeInsurancePage(driver).fillField(field, value);
    }
   @Step
    public void stepFillFields(HashMap<String,String> fields){
        fields.forEach((field, value) -> {
            try {
                stepFillField(field, value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
   }
}

