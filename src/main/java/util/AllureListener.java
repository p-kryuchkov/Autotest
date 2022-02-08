package util;

import Steps.BaseSteps;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {
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
