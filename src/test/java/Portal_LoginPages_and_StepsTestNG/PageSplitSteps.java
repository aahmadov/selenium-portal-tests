package Portal_LoginPages_and_StepsTestNG;

import Utilities.FileReader;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.SetProperty;
import UtilsTesNG.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PageSplitSteps extends TestBase {


    WebDriver driver = SetProperty.getDriverTesTNG();
    LoginPageTestNG loginPageObj = new LoginPageTestNG();

    @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression"})
    public void splitPageFromPortal() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.100");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();


        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        Thread.sleep(1000*3);
        loginPageObj.loginButton.click();
        Thread.sleep(1000*3);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPageObj.FaxingButton.click();

        loginPageObj.sendFaxButton.click();
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));

        Thread.sleep(1000*5);

        loginPageObj.coverPage.click();


        loginPageObj.uploadPage.click();

        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"),data.get("fileType"));
        Robot rb = new Robot();
        rb.delay(1000*2);
        //put the path to file in clipboard
        StringSelection Filepath = new StringSelection(pagesSize.toString());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath,null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(1000*2);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000*5);
        Thread.sleep(1000*5);
        loginPageObj.splitCheckPagebox.click();
        loginPageObj.claimNumber.click();
        loginPageObj.claimNumber.sendKeys(data.get("claimNumber"));
        Thread.sleep(1000*5);

        loginPageObj.referenceKeywords.click();
        loginPageObj.referenceKeywords.sendKeys(data.get("ReferenceKeyword"));
        loginPageObj.Send_After.click();
        loginPageObj.Send_After.sendKeys(data.get("desired_date"));
        Thread.sleep(1000*5);
         //Send After date must be later than current date and time.
        //Your fax request has been accepted. It should be sent shortly.
        //Total page count of attachment(s) was small, so the fax was not split.
        //The fax ID is: 755

        loginPageObj.ClickSendButton.click();
        String message=loginPageObj.successMessage.getText();

        if(message.contains("Your fax request has been accepted")){
            Thread.sleep(1000*5);
            loginPageObj.confirmationButton.click();
        }else{
            System.out.println("ErrorMessage:either coverPage attached or date must be later than current date and time ");
        }

        System.out.println("message");

        Thread.sleep(1000*5);
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000*3);
        loginPageObj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000*5);
        loginPageObj.OutboundRadiobox.click();
        Thread.sleep(1000*5);
        loginPageObj.SearchAfterradioBtn.click();
        Thread.sleep(1000*10);
        loginPageObj.SearchAfterradioBtn.click();
        // Create a JavaScriptExecutor object


        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(80, 3000)");


        Thread.sleep(1000*5);
        loginPageObj.InfoButton.click();

        String query="SELECT JobID,Pages,FaxUserID,JobStatus FROM auto1.sendstatus order by JobID desc limit 5;";
        DataBaseUTIL.executeSQLQueryRecvD(query);

        Thread.sleep(1000*10);
        SetProperty.closeDriverTestNG();

    }
}