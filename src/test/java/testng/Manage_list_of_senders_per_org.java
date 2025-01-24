package testng;

import Pages.WelcomeMail;
import UtilsTesNG.FileReaderTestNG;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class Manage_list_of_senders_per_org extends TestBase {


    @Test(priority = 1, testName = "Portal:allow user to specify recipient name when sending a fax ", groups = {"Regression8413"})
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



    }
}