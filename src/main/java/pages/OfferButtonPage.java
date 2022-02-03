package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferButtonPage {
    @FindBy(xpath = "//*[contains(text(),'Оформить на сайте')]")
    public WebElement offerButton;

    public OfferButtonPage(WebDriver driver){
        PageFactory.initElements(driver, this); }
}
