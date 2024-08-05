package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.DriverFactory;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;

public class RefercKeywords extends TestBase {

    @Test(priority = 1, testName = "Send Fax and split page", groups = {"Regression84"})
    public void Specify_Reference_Keywords() throws InterruptedException, AWTException, SQLException {

        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.84:80/");
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

        Thread.sleep(1000 * 3);
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

//        loginPageObj.splitCheckPagebox.click();
//        loginPageObj.claimNumber.click();
//        loginPageObj.claimNumber.sendKeys(data.get("claimNumber"));
        Thread.sleep(1000 * 2);

        loginPageObj.referenceKeywords.click();
        loginPageObj.referenceKeywords.sendKeys(data.get("ReferenceKeyword"));

        Thread.sleep(1000 * 5);

        loginPageObj.ClickSendButton.click();
        String message = loginPageObj.successMessage.getText();

        if (message.contains("Your fax request has been accepted")) {
            Thread.sleep(1000 * 5);
            loginPageObj.confirmationButton.click();

            String query1 = "SELECT ProjectCode1,JobID FROM auto1.sendstatus order by JobID desc limit 1;";
            DataBaseUTIL.executeSQLQueryOCRNew1(query1);
            DriverFactory.closeDriver();


        } else {
            System.out.println("ErrorMessage:either coverPage attached or date must be later than current date and time ");
        }

        System.out.println("message");


    }

    @Test(priority = 2, testName = "Send Fax and split page", groups = {"Regression84"})
    public void Specify_Send_After() throws InterruptedException, AWTException, SQLException {

        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.84:80/");
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

        Thread.sleep(1000 * 3);
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


//        loginPageObj.splitCheckPagebox.click();
//        loginPageObj.claimNumber.click();
//        loginPageObj.claimNumber.sendKeys(data.get("claimNumber"));
//        Thread.sleep(1000 * 2);


        loginPageObj.Send_After.click();
        loginPageObj.Send_After.sendKeys(data.get("desired_date"));
        Thread.sleep(1000 * 5);

        loginPageObj.ClickSendButton.click();
        String message = loginPageObj.successMessage.getText();

        if (message.contains("Your fax request has been accepted")) {
            Thread.sleep(1000 * 5);
            loginPageObj.confirmationButton.click();
            String query1 = "SELECT TryAfter,JobID FROM auto1.sendstatus order by JobID desc limit 1;";
            DataBaseUTIL.executeSQLQueryOCRNew1(query1);
            DriverFactory.closeDriver();


        } else {
            System.out.println("ErrorMessage:either coverPage attached or date must be later than current date and time ");
        }

        System.out.println("message");
    }

}