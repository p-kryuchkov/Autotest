package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "//label[contains(text(), 'Женский')]")
    public WebElement female;
    @FindBy(xpath = "//label[contains(text(), 'Мужской')]")
    public WebElement male;


    public ArrangeInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    public void selectTypesOfInsurance(String menuItem) {
        typesOfInsurance.findElement(By.xpath(".//*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void fillField(Object fieldName, Object value) throws InterruptedException {
        if ("Фамилия".equals(fieldName)) {
            fillField(lastName, value);
        } else if ("Имя".equals(fieldName)) {
            fillField(firstName, value);
        } else if ("Отчество".equals(fieldName)) {
            fillField(middleName, value);
        } else if ("Серия".equals(fieldName)) {
            fillField(passportSeries, value);
        } else if ("Номер".equals(fieldName)) {
            fillField(passportNumber, value);
        } else if ("Дата выдачи".equals(fieldName)) {
            fillField(documentDate, value);
        } else if ("Кем выдан".equals(fieldName)) {
            fillField(documentIssue, value);

            fillField(birthDate, value);
        } else if ("Дата рождения".equals(fieldName)) {
            fillField(birthDate, value);
        }
    }


    public static void fillField(WebElement element, String value) throws InterruptedException {
        element.clear();
        element.sendKeys(value);
    }
}
