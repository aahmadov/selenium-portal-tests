package testng;

import Pages.LoginPageSecond;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class Client_License_data extends TestBase {

    @Test(priority = 1, testName = "Portal:Data Edit Issue", groups = {"Regression84"})
    public void Client_License_data_edit() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("http://10.250.1.84:80/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        LoginPageSecond LoginPageObj2 = new LoginPageSecond(driver);
        LoginPageObj2.UsernameTextBox.sendKeys(data.get("Username"));
        LoginPageObj2.PasswordTextBox.sendKeys(data.get("password"));
        LoginPageObj2.loginButton.click();
        Thread.sleep(1000 * 3);
        LoginPageObj2.SystemDropdown.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.SystemDropdown.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.ManageBTN.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.LicenseBTN.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.DeletingFieldBTN.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.DeletingConfirmdBTN.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.NewBTN.click();
        Thread.sleep(1000 * 2);

        Select selectOrg = new Select(LoginPageObj2.Organization);
        selectOrg.selectByVisibleText("auto1");

        Thread.sleep(1000 * 2);
        LoginPageObj2.ProductBTN.click();

        Select selectProduct = new Select(LoginPageObj2.ProductBTN);
        selectProduct.selectByIndex(0);
        Thread.sleep(1000 * 2);
        LoginPageObj2.MacAddress.click();
        LoginPageObj2.MacAddress.sendKeys(data.get("macAddress"));
        Thread.sleep(1000 * 2);
        LoginPageObj2.ExpirationData.clear();
        LoginPageObj2.ExpirationData.sendKeys(data.get("ExpirationData"));
        Thread.sleep(1000 * 2);
        LoginPageObj2.Description.click();
        LoginPageObj2.Description.sendKeys("Hello world!");
        Thread.sleep(1000 * 2);
        LoginPageObj2.SaveBTn.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.EditBTN.click();
        Thread.sleep(1000 * 2);
        LoginPageObj2.ExpirationData.clear();
        LoginPageObj2.ExpirationData.sendKeys(data.get("ExpirationDataNew"));
        Thread.sleep(1000 * 2);
        LoginPageObj2.SaveBTn.click();
        Thread.sleep(1000 * 5);
    }
}