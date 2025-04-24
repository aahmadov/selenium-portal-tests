package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.ConfigReader;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.ReceiveMailOutlook;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class WelcomeEmailNotification extends TestBase {

    String from = "no-reply@rpxqa.com";
    @Test(priority =1,testName ="Welcome Email notification functionality", groups = {"Regression46"})
    public void Welcome_Email_notification_functionality() throws InterruptedException {
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
        loginPageObj.AdministrationHeading.click();
        loginPageObj.manageDropdown.click();
        loginPageObj.UserBTN.click();
        loginPageObj.optionDropdownBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.CreateUserBtn.click();
        Thread.sleep(1000 * 2);
        Select Countrycode =new Select(loginPageObj.CountryCode);
        Countrycode.selectByVisibleText("United States");
        loginPageObj.userIDfeild.click();
        loginPageObj.userIDfeild.sendKeys(data.get("UserID"));
        Thread.sleep(1000 * 2);
        loginPageObj.userNamefeild.click();
        loginPageObj.userNamefeild.sendKeys(data.get("UserName"));
        Thread.sleep(1000 * 2);
        loginPageObj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Thread.sleep(1000 * 2);
        loginPageObj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Thread.sleep(1000 * 2);
        loginPageObj.userEmailfeild.click();
        loginPageObj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Thread.sleep(1000 * 2);

        WebElement CurrentElement= driver.findElement(By.xpath("//input[@id='UserNotifyCreateYes']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(CurrentElement).click().perform();
        Thread.sleep(1000 * 5);
        loginPageObj.SaveBTNfeild.click();
        Thread.sleep(1000 * 10);
        loginPageObj.deleteafterCreate.click();
        Thread.sleep(1000 * 2);
        loginPageObj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
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

    }}
