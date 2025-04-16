package testng;

import Pages.LoginPageTestNG;
import Pages.WelcomeMail;
import UtilsTesNG.ConfigReader;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.ReceiveMailOutlook;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Email_when_sftp_changes extends TestBase {
    String from = "no-reply@rpxqa.com";


    @Test(priority = 1, testName = "Email when sftp changes are made", groups = {"Regression46"})
    public void SFTP_push_Host_Name_change_email_notify46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;
        driver.get("http://10.250.1.46:8585/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);

        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Thread.sleep(1000 * 3);
        Oj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        Oj.manageDropdown.click();
        Thread.sleep(1000 * 2);
        Oj.settingsField.click();
        Thread.sleep(1000 * 2);
        Oj.OrgDropdownBTN.click();
        Thread.sleep(1000 * 2);
        Oj.selectORG3.click();
        Thread.sleep(1000 * 2);
        Oj.settingsField.click();
        Thread.sleep(1000 * 2);
        Oj.SFTP_For_replixdb.click();
        Thread.sleep(1000 * 2);
        Oj.SFTP_field.clear();
        Oj.SFTP_field.sendKeys("api.rpxtest.com");
        Thread.sleep(1000 * 2);
        Oj.SFTPtestlink.click();
        Thread.sleep(1000 * 2);
        Oj.SFTPtestlinkConfimOk.click();
        Thread.sleep(1000 * 2);
        Oj.SaveBTNFaxOption.click();
        Thread.sleep(1000 * 2);
        Oj.SFTPtestlinkConfimOk.click();

        Date startTime = Calendar.getInstance().getTime();
        String emailSubject = ConfigReader.getProperty("subject2");

        Boolean result = ReceiveMailOutlook.receiveEmail2(from, emailSubject);
        if (!result) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTimeString = formatter.format(startTime);
            Date endTime = Calendar.getInstance().getTime();
            String endTimeString = formatter.format(endTime);

            System.out.println("Start time message: " + startTimeString);
            System.out.println("End time message: " + endTimeString);
            System.out.println("*** No expected notification received. Negative scenario triggered. ***");

        }
        Thread.sleep(1000 * 10);
        Oj.SFTP_field.clear();
        Thread.sleep(1000 * 2);
        Oj.SFTP_field.sendKeys("sftp.softlinx.test");
        Thread.sleep(1000 * 2);
        Oj.SaveBTNFaxOption.click();
        Oj.SFTPtestlinkConfimOk.click();

        Boolean result2 = ReceiveMailOutlook.receiveEmail2(from, emailSubject);
        if (!result2) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTimeString = formatter.format(startTime);
            Date endTime = Calendar.getInstance().getTime();
            String endTimeString = formatter.format(endTime);

            System.out.println("Start time message: " + startTimeString);
            System.out.println("End time message: " + endTimeString);
            System.out.println("*** No expected notification received. Negative scenario triggered. ***");

        }
    }
}