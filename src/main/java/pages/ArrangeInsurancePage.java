package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArrangeInsurancePage {
    @FindBy(xpath = "//fieldset[contains(@class, 'no-offset non-border')]")
    WebElement typesOfInsurance;
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

    public void fillField(String fieldName, String value) throws InterruptedException {
        switch (fieldName) {
            case "Фамилия":
                fillField(lastName, value);
                break;
            case "Имя":
                fillField(firstName, value);
                break;
            case "Отчество":
                fillField(middleName, value);
                break;
            case "Серия":
                fillField(passportSeries, value);
                break;
            case "Номер":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
            case "Дата рождения":
                fillField(birthDate, value);
                break;
        }
    }


    public static void fillField(WebElement element, String value) throws InterruptedException {
        element.clear();
        element.sendKeys(value);
    }
}
