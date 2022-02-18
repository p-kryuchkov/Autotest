package pages;

import Steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferButtonPage {
    @FindBy(xpath = "//*[contains(text(),'Оформить на сайте')]")
    public WebElement offerButton;

    public OfferButtonPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
