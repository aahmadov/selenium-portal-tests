package testng;

import Pages.WelcomeMail;
import UtilsTesNG.ConfigReader;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.ReceiveMail;
import UtilsTesNG.ReceiveMailOutlook;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class User_invalid_Email_password_notification extends TestBase {

    String from = "no-reply@rpxqa.com";

    //
    @Test(priority = 2, testName = "Email notifications when password & Email address is changed", groups = {"Regression843"})
    public void Email_address_change_email_Notification() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.84:80/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("Password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.SubMenuManage.click();
        Oj.Users.click();
        Thread.sleep(1000 * 2);
        Oj.faxsendingEditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.passwordChange.click();
        Thread.sleep(1000 * 2);
        Oj.passwordChange.sendKeys(data.get("userPassword"));
        Thread.sleep(1000 * 2);
        Oj.confirmPassword.click();
        Thread.sleep(1000 * 2);
        Oj.confirmPassword.sendKeys(data.get("userPasswordConfirm"));
//      Oj.Email.click();
        Thread.sleep(1000 * 2);
        if (Boolean.parseBoolean(data.get("withEmail"))) {
            Oj.Email.clear();
            Thread.sleep(1000 * 2);
            Oj.Email.sendKeys(data.get("Email"));
            Thread.sleep(1000 * 2);

            Oj.SaveBTN.click();
            Thread.sleep(1000 * 5);
            Oj.ErrorMessage.getText();
            String expectedErrorMessage = "Cannot change email address and password together";
            if (Oj.ErrorMessage.getText().contains(expectedErrorMessage)) {
                System.out.println(":The system - " + expectedErrorMessage + ":Try Again ");


            } else {

                System.out.println("the actual message: " + Oj.ErrorMessage.getText() + "is not equal: " + expectedErrorMessage);
            }

            Thread.sleep(1000 * 2);
            Oj.ErrorMessageOK.click();

        } else {
            Oj.SaveBTN.click();

            Thread.sleep(1000 * 5);
            Date startTime = Calendar.getInstance().getTime();
            String emailSubject = ConfigReader.getProperty("subject2");

            Boolean result = ReceiveMailOutlook.receiveEmail2(from, emailSubject);
            if (!result) {
                // System.out.println("*** after 5 min iteration, there is not a expected notification");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String startTimeString = formatter.format(startTime);
                Date endTime = Calendar.getInstance().getTime();
                String endTimeString = formatter.format(endTime);

                System.out.println("Start time message: " + startTimeString);
                System.out.println("End time message: " + endTimeString);
            }
        }
    }
}