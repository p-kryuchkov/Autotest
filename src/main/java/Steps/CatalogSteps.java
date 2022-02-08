package Steps;

import pages.CatalogPage;
import pages.OfferButtonPage;
import ru.yandex.qatools.allure.annotations.Step;

import static Steps.BaseSteps.driver;

public class CatalogSteps extends HomeSteps{
    @Step("Выбор вида страхования")
    public void stepSelectProductCarusel (String menuItem) {
        new CatalogPage(driver).selectProductCarusel(menuItem);
    }
    @Step("Закрытие предупреждения о использовании куки")
    public void stepCookieWarningCloseButton () {
        new CatalogPage(driver).cookieWarningCloseButton.click();
    }
}
