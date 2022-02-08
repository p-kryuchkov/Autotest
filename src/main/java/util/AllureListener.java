package util;

import Steps.BaseSteps;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class AllureListener extends AllureJunit4 {
    @Override
    public void testFailure(Failure failure) {
        takeScreenshot();
        super.testFailure(failure);

    }

    @Attachment(type = "image/png", value = "Скриншот при ошибке")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
