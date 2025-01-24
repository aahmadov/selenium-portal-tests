package testng;

import Pages.WelcomeMail;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

public class SpecifyToandCompanyName extends TestBase {


    @Test(priority = 1, testName = "Portal:allow user to specify recipient name when sending a fax ", groups = {"Regression84"})
    public void optionally_specify_to_and_company_when_s_ending_a_fax() throws InterruptedException, AWTException, SQLException {
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
        Thread.sleep(1000 * 3);
        Oj.sendFaxOptionField.click();
        Thread.sleep(1000 * 3);
        Oj.faxNumber.click();
        Oj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 2);
        Oj.ToRecipientName.click();
        Oj.ToRecipientName.sendKeys("ToName1");
        Thread.sleep(1000 * 2);
        Oj.ToRecipientCompany.click();
        Oj.ToRecipientCompany.sendKeys("toCompany1");
        Thread.sleep(1000 * 3);
        Oj.coverPage.click();

        Oj.ChoseCoverpage.click();
        Thread.sleep(1000 * 3);


        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        // Wait until the form is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropzone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));

        // Path to your file
        File fileToUpload = new File(pagesSize.getAbsolutePath());

        // Execute JavaScript to add the file to Dropzone
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                "dropzone.emit('addedfile', mockFile);" +
                "dropzone.emit('complete', mockFile);");

        Oj.SendBTN.click();
        Thread.sleep(1000 * 2);
        Oj.confirmationSendButton.click();
        Thread.sleep(1000 * 5);

    }
}