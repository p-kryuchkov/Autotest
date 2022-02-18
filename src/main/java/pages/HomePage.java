package pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy (xpath = "//ul[contains(@class,'kitt-top-menu')]")
    WebElement topMenu;

    public HomePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public void selectTopMenu(String menuItem){
        topMenu.findElement(By.xpath(".//li/*[contains(text(),'"+menuItem+"')]")).click();
    }


}
