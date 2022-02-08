package Steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsuranceSteps extends BaseSteps{
    @Step("Нажатие на кнопку \"Оформить онлайн\"")
    public void stepOfferButton () {
        new TravelInsurancePage(driver).offerButton.click();
    }
}
