package Steps;

import io.qameta.allure.Step;
import pages.TravelInsurancePage;

import static org.junit.Assert.assertTrue;

public class TravelInsuranceSteps {
    @Step("Нажатие на кнопку \"Оформить онлайн\"")
    public void stepOfferButton () {
        new TravelInsurancePage(BaseSteps.getDriver()).offerButton.click();
    }
    @Step("Проверка заголовка страницы -  равен {0}")
    public void checkTitle(String expectedTitle){
        String actualTitle = new TravelInsurancePage(BaseSteps.getDriver()).title.getText();
        String expectedTitle2 = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), actualTitle.contains(expectedTitle2));
    }
}

