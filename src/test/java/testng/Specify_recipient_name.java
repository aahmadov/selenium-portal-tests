package testng;

import Pages.LoginPageTestNG;
import Pages.WelcomeMail;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class Specify_recipient_name extends TestBase {

    @Test(priority = 1, testName = "Portal:allow user to specify recipient name when sending a fax ", groups = {"Regression84"})
    public void Allow_User_to_specify_recipient_name() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.84:80/");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);

        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        Oj.settingsField.click();
        Thread.sleep(1000 * 3);
        Oj.FaxOption_Field.click();
        Thread.sleep(1000 * 3);
        Oj.DeleteFaxAfterSendNo.click();
        Thread.sleep(1000 * 3);
        Oj.SaveBTNFaxOption.click();
        Oj.confirmButton.click();
        Thread.sleep(1000 * 2);
        Oj.sendFaxOptionField.click();
        Thread.sleep(1000 * 3);
        Oj.faxNumber.click();
        Oj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 2);
        Oj.ToRecipientName.click();
        Oj.ToRecipientName.sendKeys("ToName1");
        Thread.sleep(1000 * 2);
        Oj.ToRecipientCompany.click();
        Oj.ToRecipientCompany.sendKeys("toCompany1");
        Thread.sleep(1000 * 3);
        Oj.coverPage.click();
        Thread.sleep(1000 * 2);
        Oj.ChoseCoverpage.click();
        Thread.sleep(1000 * 2);
        Oj.SendBTN.click();
        Thread.sleep(1000 * 2);
        Oj.confirmationSendButton.click();
        Thread.sleep(1000 * 2);
        Oj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        Oj.settingsField.click();
        Thread.sleep(1000 * 3);
        Oj.FaxOption_Field.click();
        Thread.sleep(1000 * 3);
        Oj.DeleteFaxAfterSendYes.click();
        Thread.sleep(1000 * 3);
        Oj.SaveBTNFaxOption.click();
        Oj.confirmButton.click();
        Thread.sleep(1000 * 3);
        Oj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000 * 2);
        Oj.OutboundRadiobox.click();
        Thread.sleep(1000 * 2);
        Oj.SearchBTn.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
        Thread.sleep(1000 * 5);
        String query = "SELECT RecipientInfo,JobID,JobStatus,Pages FROM auto1.sendstatus where FaxUserID = 'admin' order by JobID desc Limit 1;";
        DataBaseUTIL.executeSQLQuery84Database(query);
        Thread.sleep(1000 * 5);
    }

    @Test(priority = 1, testName = "Portal:allow user to specify recipient name when sending a fax ", groups = {"Regression46"})
    public void Allow_User_to_specify_recipient_name46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;

        driver.get("http://10.250.1.46:8585/");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);

        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        Oj.settingsField.click();
        Thread.sleep(1000 * 3);
        Oj.FaxOption_Field.click();
        Thread.sleep(1000 * 3);
        Oj.DeleteFaxAfterSendNo.click();
        Thread.sleep(1000 * 3);
        Oj.SaveBTNFaxOption.click();
        Oj.confirmButton.click();
        Thread.sleep(1000 * 2);
        Oj.sendFaxOptionField.click();
        Thread.sleep(1000 * 3);
        Oj.faxNumber.click();
        Oj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 2);
        Oj.ToRecipientName.click();
        Oj.ToRecipientName.sendKeys("ToName1");
        Thread.sleep(1000 * 2);
        Oj.ToRecipientCompany.click();
        Oj.ToRecipientCompany.sendKeys("toCompany1");
        Thread.sleep(1000 * 3);
        Oj.coverPage.click();
        Thread.sleep(1000 * 2);
        Oj.ChoseCoverpage.click();
        Thread.sleep(1000 * 2);
        Oj.SendBTN.click();
        Thread.sleep(1000 * 2);
        Oj.confirmationSendButton.click();
        Thread.sleep(1000 * 2);
        Oj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        Oj.settingsField.click();
        Thread.sleep(1000 * 3);
        Oj.FaxOption_Field.click();
        Thread.sleep(1000 * 3);
        Oj.DeleteFaxAfterSendYes.click();
        Thread.sleep(1000 * 3);
        Oj.SaveBTNFaxOption.click();
        Oj.confirmButton.click();
        Thread.sleep(1000 * 3);
        Oj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000 * 2);
        Oj.OutboundRadiobox.click();
        Thread.sleep(1000 * 2);
        Oj.SearchBTn.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
        Thread.sleep(1000 * 5);
        String query = "SELECT RecipientInfo,JobID,JobStatus,Pages FROM auto1.sendstatus where FaxUserID = 'admin' order by JobID desc Limit 1;";
        DataBaseUTIL.executeSQLQuery46Database(query);
        Thread.sleep(1000 * 5);
    }

}
