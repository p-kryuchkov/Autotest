import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SberbankTest {
    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest() {
        baseUrl = "http://www.sberbank.ru/ru/person";
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testSberbank() throws InterruptedException {
        driver.findElement(By.xpath("//ul[contains(@class,'kitt-top-menu')]/li/*[contains(text(),'Страхование')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Все страховые программы')]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[contains(@class,'product-catalog__carousel_row')]/div[contains(@data-product,'Страхование путешественников')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Оформить онлайн')]")))).click();
        driver.findElement(By.xpath("//*[contains(text(),'Оформить на сайте')]")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")))).click();
        driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Оформление')]"))));
        fillField(By.id("person_firstName"), "Один");
        fillField(By.id("person_lastName"), "Два");
        fillField(By.id("person_middleName"), "Три");
        fillField(By.id("person_birthDate"), "10.01.1990");
        fillField(By.id("passportSeries"), "0000");
        fillField(By.id("passportNumber"), "123321");
        fillField(By.id("documentDate"), "11.11.2011");
        fillField(By.id("documentIssue"), "УФМС");
        driver.findElement(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid')][contains(text(),'Мужской')]")).click();
        Assert.assertEquals("Один", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        Assert.assertEquals("Два", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        Assert.assertEquals("Три", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        Assert.assertEquals("10.01.1990", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        Assert.assertEquals("0000", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        Assert.assertEquals("123321", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        Assert.assertEquals("11.11.2011", driver.findElement(By.id("documentDate")).getAttribute("value"));
        Assert.assertEquals("УФМС", driver.findElement(By.id("documentIssue")).getAttribute("value"));
        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[contains(@class,'alert-form alert-form-error')]")).getAttribute("innerText"));
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Мобильный телефон')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Электронная почта')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        Assert.assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Повтор электронной почты')]//span[contains(@class,'message')]")).getAttribute("innerText"));
    }

    private void fillField(By locator, String value) throws InterruptedException {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest() {
        driver.quit();
    }
}
