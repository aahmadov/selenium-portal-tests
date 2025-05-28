package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class SSO extends TestBase {
    @Test(priority = 1, testName = "SSO for a Fax Server ", groups = {"Regression84123"})
    public void SSO_User() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("https://regression.rpxqa.com/SSO/auto1");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);
//        Thread.sleep(1000 * 3);
//        loginPageObj.AnotherAccountBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.SSOUSerNameBox.sendKeys(data.get("Username"));
        Thread.sleep(1000 * 2);
        loginPageObj.microsoftNextBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SSOPasswordBox.sendKeys(data.get("password"));
        Thread.sleep(1000 * 3);
        loginPageObj.microSoftSignInBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.dontSignIncheckBox.click();
        Thread.sleep(1000 * 3);
        loginPageObj.dontShowMeagainBox.click();
        Thread.sleep(1000 * 5);
        loginPageObj.dropdownlink.click();
        Thread.sleep(1000 * 5);
        loginPageObj.loginLogoutBTN.click();
        Thread.sleep(1000 * 5);
}
    @Test(priority = 1, testName = "SSO for a Fax Server ", groups = {"Regression46"})
    public void SSO_User46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;

        driver.get("https://regression.rpxqa.com/SSO/auto1");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);
//        Thread.sleep(1000 * 3);
//        loginPageObj.AnotherAccountBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.SSOUSerNameBox.sendKeys(data.get("Username"));
        Thread.sleep(1000 * 2);
        loginPageObj.microsoftNextBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SSOPasswordBox.sendKeys(data.get("password"));
        Thread.sleep(1000 * 3);
        loginPageObj.microSoftSignInBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.dontSignIncheckBox.click();
        Thread.sleep(1000 * 3);
        loginPageObj.dontShowMeagainBox.click();
        Thread.sleep(1000 * 5);
        loginPageObj.dropdownlink.click();
        Thread.sleep(1000 * 5);
        loginPageObj.loginLogoutBTN.click();
        Thread.sleep(1000 * 5);
    }
}