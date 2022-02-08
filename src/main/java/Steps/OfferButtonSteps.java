package Steps;

import io.qameta.allure.Step;
import pages.OfferButtonPage;


public class OfferButtonSteps extends BaseSteps{
    @Step("Нажатие на кнопку \"Оформить на сайте\"")
    public void stepOfferButton () {
        new OfferButtonPage(driver).offerButton.click();
    }
}
