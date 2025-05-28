package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.ConfigReader;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class Single_sing_ON_Portal extends TestBase {

    @Test(priority = 1, testName = "Portal:Single Sing On", groups = {"Regression84"})
    public void SingleSing_ON() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("https://regression.rpxqa.com/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 2);
        loginPageObj.settingsField.click();
        Thread.sleep(1000 * 2);

        loginPageObj.Single_sign_BTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EnableSSONo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EnableSSOYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SP_name.click();
        loginPageObj.SP_name.clear();
        loginPageObj.SP_name.sendKeys("https://5regression.rpxqa.com");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SP_name.click();
        loginPageObj.SP_name.clear();
        loginPageObj.SP_name.sendKeys("https://regression.rpxqa.com");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Idp_name.click();
        loginPageObj.Idp_name.clear();
        loginPageObj.Idp_name.sendKeys("https://HTM5sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Idp_name.click();
        loginPageObj.Idp_name.clear();
        loginPageObj.Idp_name.sendKeys("https://sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.IDP_URL.click();
        loginPageObj.IDP_URL.clear();
        loginPageObj.IDP_URL.sendKeys("https://HTM5sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.IDP_URL.click();
        loginPageObj.IDP_URL.clear();
        loginPageObj.IDP_URL.sendKeys("https://sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Single_Sign_on_Service_URL.click();
        loginPageObj.Single_Sign_on_Service_URL.clear();
        loginPageObj.Single_Sign_on_Service_URL.sendKeys("https://login.microsoftonlineTSD5.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Single_Sign_on_Service_URL.click();
        loginPageObj.Single_Sign_on_Service_URL.clear();
        loginPageObj.Single_Sign_on_Service_URL.sendKeys("https://login.microsoftonline.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Single_Logoff_Service_URL.click();
        loginPageObj.Single_Logoff_Service_URL.clear();
        loginPageObj.Single_Logoff_Service_URL.sendKeys("https://login.microsoftonlineTSD5.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Single_Logoff_Service_URL.click();
        loginPageObj.Single_Logoff_Service_URL.clear();
        loginPageObj.Single_Logoff_Service_URL.sendKeys("https://login.microsoftonline.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Certificate.click();
        loginPageObj.Certificate.clear();
        loginPageObj.Certificate.sendKeys(ConfigReader.getProperty("certificateFake"));
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Certificate.click();
        loginPageObj.Certificate.clear();
        loginPageObj.Certificate.sendKeys(ConfigReader.getProperty("certificate"));
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
        loginPageObj.Sing_Logout_requestYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Sing_Logout_requestNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Want_Logout_Response_SignedYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Want_Logout_Response_SignedNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Sign_Authn_RequestYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Sign_Authn_RequestNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.SSO_ID_is_Email_AddressNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SSO_ID_is_Email_AddressYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.IdP_Assertion_is_using_ACSNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.IdP_Assertion_is_using_ACSYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Set_Permissions_at_LoginYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Set_Permissions_at_LoginNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 10);
    }
    @Test(priority = 1, testName = "Portal:Single Sing On", groups = {"Regression46"})
    public void SingleSing_ON46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;
        driver.get("http://10.250.1.46:8585/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 2);
        loginPageObj.settingsField.click();
        Thread.sleep(1000 * 2);

        loginPageObj.Single_sign_BTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EnableSSONo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EnableSSOYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SP_name.click();
        loginPageObj.SP_name.clear();
        loginPageObj.SP_name.sendKeys("https://5regression.rpxqa.com");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SP_name.click();
        loginPageObj.SP_name.clear();
        loginPageObj.SP_name.sendKeys("https://regression.rpxqa.com");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Idp_name.click();
        loginPageObj.Idp_name.clear();
        loginPageObj.Idp_name.sendKeys("https://HTM5sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Idp_name.click();
        loginPageObj.Idp_name.clear();
        loginPageObj.Idp_name.sendKeys("https://sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.IDP_URL.click();
        loginPageObj.IDP_URL.clear();
        loginPageObj.IDP_URL.sendKeys("https://HTM5sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.IDP_URL.click();
        loginPageObj.IDP_URL.clear();
        loginPageObj.IDP_URL.sendKeys("https://sts.windows.net/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Single_Sign_on_Service_URL.click();
        loginPageObj.Single_Sign_on_Service_URL.clear();
        loginPageObj.Single_Sign_on_Service_URL.sendKeys("https://login.microsoftonlineTSD5.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Single_Sign_on_Service_URL.click();
        loginPageObj.Single_Sign_on_Service_URL.clear();
        loginPageObj.Single_Sign_on_Service_URL.sendKeys("https://login.microsoftonline.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Single_Logoff_Service_URL.click();
        loginPageObj.Single_Logoff_Service_URL.clear();
        loginPageObj.Single_Logoff_Service_URL.sendKeys("https://login.microsoftonlineTSD5.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Single_Logoff_Service_URL.click();
        loginPageObj.Single_Logoff_Service_URL.clear();
        loginPageObj.Single_Logoff_Service_URL.sendKeys("https://login.microsoftonline.com/c6c7e2f4-317e-4bf9-b447-e0ba24bbab4e/saml2");
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Certificate.click();
        loginPageObj.Certificate.clear();
        loginPageObj.Certificate.sendKeys(ConfigReader.getProperty("certificateFake"));
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Certificate.click();
        loginPageObj.Certificate.clear();
        loginPageObj.Certificate.sendKeys(ConfigReader.getProperty("certificate"));
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
        loginPageObj.Sing_Logout_requestYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Sing_Logout_requestNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Want_Logout_Response_SignedYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Want_Logout_Response_SignedNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Sign_Authn_RequestYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Sign_Authn_RequestNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.SSO_ID_is_Email_AddressNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SSO_ID_is_Email_AddressYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.IdP_Assertion_is_using_ACSNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.IdP_Assertion_is_using_ACSYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();

        Thread.sleep(1000 * 2);
        loginPageObj.Set_Permissions_at_LoginYes.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Set_Permissions_at_LoginNo.click();
        loginPageObj.SaveBTN.click();
        loginPageObj.SaveConfirmationBTn.click();
        Thread.sleep(1000 * 10);
    }

}
