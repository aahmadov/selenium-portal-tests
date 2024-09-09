package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.DriverFactory;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OCR_test extends TestBase {

    @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression84"})
    public void sendFaxHasOCRdata() throws InterruptedException, AWTException, SQLException, IOException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        loginPageObj.coverPage.click();
        loginPageObj.ChoseCoverpage.click();
            Thread.sleep(1000 * 3);
//            loginPageObj.uploadPage.click();
//            Thread.sleep(1000 * 5);

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
//            Robot rb = new Robot();
//            rb.delay(1000 * 2);
//            //put the path to file in clipboard
//            StringSelection Filepath = new StringSelection(pagesSize.toString());
//            System.out.println("File Name: " + pagesSize.toString());
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
//            Thread.sleep(1000 * 3);
//            rb.keyPress(KeyEvent.VK_ENTER);
//            rb.keyRelease(KeyEvent.VK_ENTER);
//            rb.delay(1000);
//            rb.keyPress(KeyEvent.VK_CONTROL);
//            rb.keyPress(KeyEvent.VK_V);
//            rb.delay(1000);
//            rb.keyRelease(KeyEvent.VK_CONTROL);
//            rb.keyRelease(KeyEvent.VK_V);
//            rb.delay(300);
//
//            rb.keyPress(KeyEvent.VK_ENTER);
//            rb.keyRelease(KeyEvent.VK_ENTER);
//            rb.delay(1000 * 5);
//
            loginPageObj.ClickSendButton.click();
            loginPageObj.confirmationButton.click();

            Thread.sleep(1000 * 3);
            loginPageObj.TriageQueueBox.click();
            Thread.sleep(1000 * 3);
            loginPageObj.SelectQueue.click();
            Thread.sleep(1000 * 3);
            loginPageObj.SelectQueueBox.click();
            Thread.sleep(1000 * 3);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 5);

        // Define the timeout duration in seconds
        int timeoutInSeconds = 300; // Adjust the timeout as needed

     // Loop until the Lock and Edit button is visible or timeout occurs
        long startTime = System.currentTimeMillis();
        boolean lockAndEditButtonFound = false;

        while (!lockAndEditButtonFound && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 3000) {
            // Click the search button
            WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='Search']"));
            clickSearchBtn.click();

            // Wait for LockandEditbox to be visible
            try {
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the LockandEditbox to appear
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@class, 'btnList') and contains(@title, 'Lock and Edit Fax')])[last()]")));
                lockAndEditButtonFound = true; // Exit the loop if LockandEditbox is found
            } catch (org.openqa.selenium.TimeoutException e) {
                // LockandEditbox is not found yet, continue the loop
            }
        }
        // Click on LockandEditbox if found
        if (lockAndEditButtonFound) {
            WebElement lockAndEditbox = driver.findElement(By.xpath("(//button[contains(@class, 'btnList') and contains(@title, 'Lock and Edit Fax')])[last()]"));
            lockAndEditbox.click();
        } else {
            System.out.println("Timeout: Lock and Edit button not found within " + timeoutInSeconds + " seconds.");
        }

            Thread.sleep(1000 * 5);

        WebElement DocumentTypeBox1 = loginPageObj.DocumentTypeBox;
        Select docTypeDropdown = new Select(DocumentTypeBox1);
        docTypeDropdown.selectByIndex(1);



            Thread.sleep(1000 * 3);
            loginPageObj.lastName.sendKeys(data.get("name"));
            Thread.sleep(1000 * 5);

        WebElement Genderbox = loginPageObj.Gender;
        Select selectfirstGender = new Select(Genderbox);
        selectfirstGender.selectByIndex(1);


                Thread.sleep(1000 * 3);
                loginPageObj.PhoneNumber.click();
                Thread.sleep(1000 * 3);
                loginPageObj.PhoneNumber.sendKeys(data.get("FaxNumber"));
                loginPageObj.Physician.click();
                loginPageObj.Physician.sendKeys("ABB");
                loginPageObj.firstSelection.click();
                Thread.sleep(1000 * 3);
                loginPageObj.Exam.click();
                loginPageObj.Exam.sendKeys("77");
                loginPageObj.ExamKey.click();
                Thread.sleep(1000 * 3);
                JavascriptExecutor js1 = (JavascriptExecutor) driver;
                // Scroll down the page by pixel (e.g., 500 pixels)
                js1.executeScript("window.scrollBy(100, 3000)");
                loginPageObj.FaxComments.sendKeys("Hello World!");
                Thread.sleep(1000 * 3);
        WebElement TableScroll1=loginPageObj.Scrollbtn1;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];",TableScroll1, 1000);
        Thread.sleep(1000*3);
        // Parse boolean values from the JSON data
        boolean useSaveBtn = Boolean.parseBoolean(data.get("useSaveBtn"));
        boolean useCancelBtn = Boolean.parseBoolean(data.get("useCancelBtn"));
        boolean useDeleteFaxBtn = Boolean.parseBoolean(data.get("useDeleteFaxBtn"));
        boolean rotateClockwise = Boolean.parseBoolean(data.get("useRotateClockwise"));
        boolean rotateCounterClockwise = Boolean.parseBoolean(data.get("rotateCounterClockwise"));
        boolean removePage = Boolean.parseBoolean(data.get("removePage"));
        boolean saveAsPDF = Boolean.parseBoolean(data.get("saveasPDF"));


       // Now you can use these boolean variables to perform actions
        loginPageObj.performActionBasedOnFlags(useSaveBtn, useCancelBtn, useDeleteFaxBtn, rotateClockwise,
                rotateCounterClockwise, removePage, saveAsPDF);

        if (useSaveBtn || useCancelBtn || useDeleteFaxBtn || rotateClockwise || rotateCounterClockwise || removePage || saveAsPDF) {
            // Close the driver implicitly
            driver.quit();
            Thread.sleep(1000*10);
            String query1 = "SELECT metadata, status ,faxid FROM replixdb.realm_triage_jobs order by faxid desc limit 1;";
            DataBaseUTIL.executeSQLQueryOCRNew1(query1);

        } else {
            // Execute the other function
                Thread.sleep(1000 * 3);
                loginPageObj.Submitbtn.click();
                Thread.sleep(1000 * 3);
                loginPageObj.Closebtn.click();
                Thread.sleep(1000*40);

                String query1 = "SELECT metadata, status ,faxid FROM replixdb.realm_triage_jobs order by faxid desc limit 1;";
               DataBaseUTIL.executeSQLQueryOCRNew1(query1);
                DriverFactory.closeDriver();
            }
        }
}