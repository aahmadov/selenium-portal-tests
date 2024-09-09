package testng;

import Pages.WelcomeMail;
import UtilsTesNG.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WelcomeMailSteps_1_100 extends TestBase {
    String from = "no-reply@rpxqa.com";

    @Test(priority = 2, testName = "Send Welcome Mail", groups = {"Regression100"})
    public void SendingWelcomeMail() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.100");

        /*This operation will maximize window*/
        driver.manage().window().maximize();

        WelcomeMail Oj = new WelcomeMail(driver);

        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("Password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.SubMenuManage.click();

        Oj.Users.click();
        Oj.OptionButton.click();
        Oj.OptionDropdown.click();
        Oj.WlcMailRadioBtn.click();
        String Username = data.get("Name");
        String number = FileReader.randomNumberFor_TSI_forPortal();
        String NewGeneratedUsername = Username + number;
        System.out.println(Username + number);
        Oj.USerIDBtn.sendKeys(NewGeneratedUsername);
        Oj.USerNameBtn.sendKeys(NewGeneratedUsername);
        Oj.paswGenerationBtn.click();
        Oj.EmailUserbox.sendKeys(data.get("Email"));
        Oj.UserFaxNumber.sendKeys(data.get("FaxNumber"));
        Thread.sleep(1000*3);
        Oj.SaveBtn.click();
        Thread.sleep(1000 * 5);
        String statement = Oj.passCode.getText();//"User added with password ;
        Oj.confirmButton2.click();
        Thread.sleep(1000 * 3);
        Oj.faxAdminDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        String regex = "'.*?'";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(statement);

        String contentInsideQuotes = null;

        if (matcher.find()) {
            contentInsideQuotes = matcher.group(0);
            // Remove the single quotes
            contentInsideQuotes = contentInsideQuotes.substring(1, contentInsideQuotes.length() - 1);
        }
        Pattern pattern1 = Pattern.compile("admin");
        Matcher matcher1 = pattern1.matcher(data.get("UserName"));

        // Replace all occurrences of "admin" with an empty string
        String result2 = matcher1.replaceAll("");
        System.out.println("Result: " + result2);

        String UserId = NewGeneratedUsername + result2;
        // Print the content outside of the if statement
        System.out.println(contentInsideQuotes);
        Thread.sleep(1000 * 5);

        Date startTime = Calendar.getInstance().getTime();
        String emailSubject = ConfigReader.getProperty("subject");

        Boolean result = ReceiveMail.receiveEmail(from, emailSubject);
        if (!result) {
            // System.out.println("*** after 5 min iteration, there is not a expected notification");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTimeString = formatter.format(startTime);
            Date endTime = Calendar.getInstance().getTime();
            String endTimeString = formatter.format(endTime);

            System.out.println("Start time message: " + startTimeString);
            System.out.println("End time message: " + endTimeString);
        }
        Thread.sleep(1000 * 10);
        driver.get("http://10.250.1.100");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        Thread.sleep(1000 * 3);
        Oj.UsernameTextBox.sendKeys(UserId);
        Oj.PasswordTextBox.sendKeys(contentInsideQuotes);
        Thread.sleep(1000 * 5);
        Oj.loginButton.click();
        Thread.sleep(1000 * 5);
    }
}
