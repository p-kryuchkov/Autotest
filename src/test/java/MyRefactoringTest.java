import Steps.BaseSteps;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class MyRefactoringTest extends BaseSteps {
    @Ignore
    @Test
    public void newSberbankTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.selectTopMenu("Страхование");
        homePage.selectTopMenu("Все страховые программы");
        Thread.sleep(10000);

        new CatalogPage(driver).cookieWarningCloseButton.click();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectProductCarusel("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        Assert.assertEquals("Страхование путешественников", travelInsurancePage.title.getText());
        new TravelInsurancePage(driver).offerButton.click();
        new OfferButtonPage(driver).offerButton.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(10000);
        ArrangeInsurancePage arrangeInsurancePage = new ArrangeInsurancePage(driver);
        arrangeInsurancePage.selectTypesOfInsurance("Минимальная");
        Thread.sleep(10000);
        new ArrangeInsurancePage(driver).offerButton.click();
        new ArrangeInsurancePage(driver).male.click();
        arrangeInsurancePage.fillField("Кем выдан", "УФМС");
        arrangeInsurancePage.fillField("Фамилия", "Один");
        arrangeInsurancePage.fillField("Имя", "Два");
        arrangeInsurancePage.fillField("Отчество", "Три");
        arrangeInsurancePage.fillField("Серия", "0000");
        arrangeInsurancePage.fillField("Номер", "123321");
        arrangeInsurancePage.fillField("Дата выдачи", "11.11.2011");
        arrangeInsurancePage.fillField("Дата рождения", "10.01.1990");
        new ArrangeInsurancePage(driver).birthDate.click();
        new ArrangeInsurancePage(driver).nextButton.click();
        Thread.sleep(10000);
        //Реализовал проверки в данном классе
        driver.findElement(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid')][contains(text(),'Мужской')]")).click();
        Assert.assertEquals("Два", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Один", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Три", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("0000", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("123321", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("11.11.2011", driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("УФМС", driver.findElement(By.id("documentIssue")).getAttribute("value"));
        Assert.assertEquals("10.01.1990", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[contains(@class,'alert-form alert-form-error')]")).getAttribute("innerText"));
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Мобильный телефон')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Электронная почта')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Повтор электронной почты')]//span[contains(@class,'message')]")).getAttribute("innerText"));
    }
}
