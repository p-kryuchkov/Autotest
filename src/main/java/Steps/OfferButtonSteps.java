package Steps;

import pages.OfferButtonPage;
import ru.yandex.qatools.allure.annotations.Step;

public class OfferButtonSteps extends BaseSteps{
    @Step("Нажатие на кнопку \"Оформить на сайте\"")
    public void stepOfferButton () {
        new OfferButtonPage(driver).offerButton.click();
    }
}
