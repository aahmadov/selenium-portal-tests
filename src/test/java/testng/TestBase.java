package testng;

import UtilsTesNG.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

    protected WebDriver driver;

    protected String testName;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        testName = method.getName();
        driver = DriverFactory.getDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        DriverFactory.closeDriver();
    }
}
