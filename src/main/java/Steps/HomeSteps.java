package Steps;

import io.qameta.allure.Step;
import pages.HomePage;


import static Steps.BaseSteps.driver;

public class HomeSteps {
    @Step("Выбор пункта меню")
    public void stepSelectTopMenu (String menuItem) {
     new HomePage(driver).selectTopMenu(menuItem);
    }
    @Step("Выбор подпункта меню")
    public void stepSelectSubMenu (String menuItem) {
        new HomePage(driver).selectTopMenu(menuItem);
    }

}
