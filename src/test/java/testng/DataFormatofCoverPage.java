package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class DataFormatofCoverPage extends TestBase {

    @Test(priority = 1, testName = "Portal:set faxnum and date format for coverpage", groups = {"Regression84"})
    public void set_faxnum_and_date_format_for_coverpage() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("https://regression.rpxqa.com/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 2);
        loginPageObj.settingsField.click();
        Thread.sleep(1000 * 2);
        loginPageObj.FaxOption.click();
        Thread.sleep(1000 * 2);
        loginPageObj.CoverPagechoose.click();
        Thread.sleep(1000 * 2);
        WebElement NumberFormat= loginPageObj.PhoneNumberFormat;
        Select NumFormat = new Select(NumberFormat);
        NumFormat.selectByIndex(2);
        Thread.sleep(1000 * 2);
        WebElement dateFormatting= loginPageObj.DataFormat;
        Select dateFormat = new Select(dateFormatting);
        dateFormat.selectByIndex(3);
        Thread.sleep(1000 * 2);
        loginPageObj.TimeFormat.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SaveConfirmationBTnOriginal.click();
        Thread.sleep(1000*5);
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 3);
        loginPageObj.coverPage.click();
        Thread.sleep(1000 * 2);
        loginPageObj.ChoseCoverpage.click();
        Thread.sleep(1000 * 2);
        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000*3);
        loginPageObj.confirmationButton.click();
        Thread.sleep(1000*10);
        String sql = "SELECT JobID FROM auto1.sendstatus ORDER BY JobID DESC LIMIT 1;";
        String jobId =DataBaseUTIL.executeSQLQuery84Database(sql).toString();
        Thread.sleep(1000*2);
        String coverpageofJob = String.format("SELECT * FROM auto1.coverpage WHERE JobId = '%s'", jobId.replaceAll("[^0-9]", ""));
        DataBaseUTIL.executeSQLQuery84Database(coverpageofJob);

    }
}