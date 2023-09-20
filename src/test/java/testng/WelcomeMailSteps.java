package testng;

import UtilsTesNG.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

public class WelcomeMailSteps extends TestBase {
    String from = "no-reply@rpxqa.com";
    WebDriver driver = SetProperty.getDriverTesTNG();
    WelcomeMail Oj = new WelcomeMail();

    @Test(testName = "Send Welcome Mail", groups = {"RegressionEmail"})
    public void SendingWelcomeMail() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.100");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();

        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Thread.sleep(1000 * 3);
        Oj.loginButton.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Oj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        Oj.SubMenuManage.click();

        Thread.sleep(1000 * 3);
        Oj.Users.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Oj.OptionButton.click();
        Oj.OptionDropdown.click();
        Oj.WlcMailRadioBtn.click();
        String Username = data.get("UserName");
        String number = FileReader.randomNumberFor_TSI_forPortal();
        String NewGeneratedUsername = Username + number;
        System.out.println(Username + number);

        Oj.USerIDBtn.sendKeys(NewGeneratedUsername);
        Oj.USerNameBtn.sendKeys(NewGeneratedUsername);
        Oj.paswGenerationBtn.click();
        Thread.sleep(1000 * 3);
        Oj.EmailUserbox.sendKeys(data.get("Email"));
        Thread.sleep(1000 * 3);
        Oj.UserFaxNumber.sendKeys(data.get("FaxNumber"));
        Thread.sleep(1000 * 3);
        Oj.SaveBtn.click();
        Thread.sleep(1000 * 3);


        String statement = Oj.passCode.getText();//"User added with password ;

        String regex = "'.*?'";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(statement);

        String contentInsideQuotes = null;

        if (matcher.find()) {
            contentInsideQuotes = matcher.group(0);
            // Remove the single quotes
            contentInsideQuotes = contentInsideQuotes.substring(1, contentInsideQuotes.length() - 1);
        }

        // Print the content outside of the if statement
            System.out.println(contentInsideQuotes);



        String UserId = NewGeneratedUsername + data.get(Username).split("@")[0];

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
            Thread.sleep(1000*10);
            driver.get("http://10.250.1.100");
            Thread.sleep(1000 * 3);
            /*This operation will maximize window*/
            driver.manage().window().maximize();

            Oj.UsernameTextBox.sendKeys(UserId);
            Oj.PasswordTextBox.sendKeys(contentInsideQuotes);
            Thread.sleep(1000 * 3);
            Oj.loginButton.click();

            SetProperty.closeDriverTestNG();
        }
    }
