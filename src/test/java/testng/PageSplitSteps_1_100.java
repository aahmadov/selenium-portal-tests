package testng;

import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import Pages.LoginPageTestNG;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;

public class PageSplitSteps_1_100 extends TestBase {

    @Test(priority = 1, testName = "Send Fax and split page", groups = {"Regression100"})
    public void splitPageFromPortal() throws InterruptedException, AWTException, SQLException {

        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.100");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);


        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        Thread.sleep(1000 * 3);
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxingButton.click();

        loginPageObj.sendFaxButton.click();
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        loginPageObj.coverPage.click();

        Thread.sleep(1000*3);
        loginPageObj.uploadPage.click();

        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        Robot rb = new Robot();
        rb.delay(1000 * 2);
        //put the path to file in clipboard
        StringSelection Filepath = new StringSelection(pagesSize.toString());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(1000 * 2);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000 * 5);

        //Thread.sleep(1000*3);
        loginPageObj.splitCheckPagebox.click();
        loginPageObj.claimNumber.click();
        loginPageObj.claimNumber.sendKeys(data.get("claimNumber"));
        Thread.sleep(1000 * 2);

        loginPageObj.referenceKeywords.click();
        loginPageObj.referenceKeywords.sendKeys(data.get("ReferenceKeyword"));
        loginPageObj.Send_After.click();
        loginPageObj.Send_After.sendKeys(data.get("desired_date"));
        Thread.sleep(1000 * 5);

        loginPageObj.ClickSendButton.click();
        String message = loginPageObj.successMessage.getText();

        if (message.contains("Your fax request has been accepted")) {
            Thread.sleep(1000 * 5);
            loginPageObj.confirmationButton.click();
        } else {
            System.out.println("ErrorMessage:either coverPage attached or date must be later than current date and time ");
        }

        System.out.println("message");

        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000 * 3);
        loginPageObj.OutboundRadiobox.click();
        Thread.sleep(1000 * 3);
        loginPageObj.SearchAfterradioBtn.click();
        Thread.sleep(1000 * 10);
        loginPageObj.SearchAfterradioBtn.click();
        // Create a JavaScriptExecutor object

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(100, 3000)");


        Thread.sleep(1000 * 5);
        loginPageObj.InfoButton.click();

        String query = "SELECT JobID,Pages,FaxUserID,JobStatus FROM auto1.sendstatus order by JobID desc limit 5;";
        DataBaseUTIL.executeSQLQueryRecvD(query);

        Thread.sleep(1000 * 10);
    }
}