package Steps;

import io.qameta.allure.Step;
import pages.TravelInsurancePage;


public class TravelInsuranceSteps extends BaseSteps{
    @Step("Нажатие на кнопку \"Оформить онлайн\"")
    public void stepOfferButton () {
        new TravelInsurancePage(driver).offerButton.click();
    }
}
