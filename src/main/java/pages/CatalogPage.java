package pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
    @FindBy(xpath = "//button[contains(@class,'kitt-cookie-warning__close')]")
    public WebElement cookieWarningCloseButton;
    @FindBy(xpath = "//div[contains(@class,'product-catalog__carousel_row')]")
    WebElement productCarusel;

    public CatalogPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
        public void selectProductCarusel(String menuItem) {
            productCarusel.findElement(By.xpath("./div[contains(@data-product,'"+menuItem+"')]")).click();
        }
    }




