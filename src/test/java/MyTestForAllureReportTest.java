import Steps.*;
import org.junit.Test;


import java.util.HashMap;

public class MyTestForAllureReportTest extends BaseSteps {
    @Test

    public void testInsurance() throws InterruptedException {
        HomeSteps homeSteps = new HomeSteps();
        CatalogSteps catalogSteps = new CatalogSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        OfferButtonSteps offerButtonSteps = new OfferButtonSteps();
        ArrangeInsuranceSteps arrangeInsuranceSteps = new ArrangeInsuranceSteps();
        HashMap<String, String> testData = new HashMap<>();
        testData.put("Кем выдан", "УФМС");
        testData.put("Фамилия", "Один");
        testData.put("Имя", "Два");
        testData.put("Отчество", "Три");
        testData.put("Серия", "0000");
        testData.put("Номер", "123321");
        testData.put("Дата выдачи", "11.11.2011");
        testData.put("Дата рождения", "10.01.1990");

        homeSteps.stepSelectTopMenu("Страхование");
        homeSteps.stepSelectSubMenu("Все страховые программы");
        Thread.sleep(10000);
        catalogSteps.stepCookieWarningCloseButton();
        catalogSteps.stepSelectProductCarusel("Страхование путешественников");
        travelInsuranceSteps.stepOfferButton();
        offerButtonSteps.stepOfferButton();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(10000);
        arrangeInsuranceSteps.stepSelectTypesOfInsurance("Минимальная");
        Thread.sleep(10000);
        arrangeInsuranceSteps.stepOfferButton();
        arrangeInsuranceSteps.stepMaleButton();
        arrangeInsuranceSteps.stepFillFields(testData);
        arrangeInsuranceSteps.stepNextButton();


    }
}
