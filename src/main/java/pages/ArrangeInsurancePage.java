package pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ArrangeInsurancePage {
    @FindBy(xpath = "//fieldset[contains(@class, 'no-offset non-border')]")
    public WebElement typesOfInsurance;
    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement offerButton;
    @FindBy(xpath = "//*[contains(text(), 'Продолжить')]")
    public WebElement nextButton;
    @FindBy(id = "person_lastName")
    WebElement lastName;
    @FindBy(id = "person_firstName")
    WebElement firstName;
    @FindBy(id = "person_middleName")
    WebElement middleName;
    @FindBy(id = "passportSeries")
    WebElement passportSeries;
    @FindBy(id = "passportNumber")
    WebElement passportNumber;
    @FindBy(id = "person_birthDate")
    public WebElement birthDate;
    @FindBy(id = "documentIssue")
    WebElement documentIssue;
    @FindBy(id = "documentDate")
    WebElement documentDate;
    @FindBy(xpath = "//*[@class='page container']")
    WebElement pageContainer;
    @FindBy(xpath = "//label[contains(text(), 'Женский')]")
    public WebElement female;
    @FindBy(xpath = "//label[contains(text(), 'Мужской')]")
    public WebElement male;
    @FindBy(xpath = "//h2[contains(text(),'Страхование путешественников')]")
    public WebElement title;


    public ArrangeInsurancePage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void selectTypesOfInsurance(String menuItem) {
        typesOfInsurance.findElement(By.xpath(".//*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void fillField(String fieldName, String value){
        try {
            if ("Фамилия".equals(fieldName)) { fillField(lastName, value); }
            if ("Имя".equals(fieldName)) { fillField(firstName, value); }
            if ("Дата рождения".equals(fieldName)) { fillField(birthDate, value); pageContainer.click();}
            if ("Отчество".equals(fieldName)) { fillField(middleName, value); }
            if ("Серия".equals(fieldName)) { fillField(passportSeries, value); }
            if ("Номер".equals(fieldName)) { fillField(passportNumber, value); }
            if ("Дата выдачи".equals(fieldName)) { fillField(documentDate, value); pageContainer.click();}
            if ("Кем выдан".equals(fieldName)) { fillField(documentIssue, value); }
        } catch (Exception e) {
            new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }
    public String checkFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия":
                return lastName.getAttribute("value");
            case "Имя":
                return firstName.getAttribute("value");
            case "Отчество":
                return middleName.getAttribute("value");
            case "Серия":
                return passportSeries.getAttribute("value");
            case "Номер":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return documentDate.getAttribute("value");
            case "Кем выдан":
                return documentIssue.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
        }
        throw new AssertionError("Поле "+fieldName+" не найдено");
    }


    public static void fillField(WebElement element, String value) throws InterruptedException {
        element.clear();
        element.sendKeys(value);
    }
    public void checkErrorMessage(String field, String errorMessage){
        if (field.equals("Мобильный телефон") || field.equals("Электронная почта")||field.equals( "Повтор электронной почты")) {
            String xpath = "//*[contains(@title, '" + field + "')]//*[contains(text(), 'Поле не заполнено')]";
            String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
            assertEquals(errorMessage, actualValue);
        } else {
            String xpath = "//*[@class='alert-form alert-form-error']";
            String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();
            assertEquals(errorMessage, actualValue);
        }

    }

}
