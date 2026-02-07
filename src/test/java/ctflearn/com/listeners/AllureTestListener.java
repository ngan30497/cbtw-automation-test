package ctflearn.com.listeners;

import ctflearn.com.base.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;

public class AllureTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).driver;

            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Screenshot on failure",
                        new ByteArrayInputStream(screenshot)
                );
            }
        }
    }
}
