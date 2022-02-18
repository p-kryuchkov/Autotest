package pages;

import Steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage {
    @FindBy(xpath = "//h1[contains(text(),'Страхование путешественников')]")
    public WebElement title;
    @FindBy(xpath = "//*[contains(text(),'Оформить онлайн')]")
    public WebElement offerButton;


    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),5,1000);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

}
