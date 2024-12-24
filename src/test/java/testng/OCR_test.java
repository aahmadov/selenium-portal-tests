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
import org.openqa.selenium.TimeoutException;
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

    @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression8412"})
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

            loginPageObj.ClickSendButton.click();
            loginPageObj.confirmationButton.click();

            Thread.sleep(1000 * 2);
            loginPageObj.TriageQueueBox.click();
            Thread.sleep(1000 * 2);
            loginPageObj.SelectQueue.click();
            Thread.sleep(1000 * 2);
            loginPageObj.SelectQueueBox.click();
            Thread.sleep(1000 * 3);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 3);
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            // Scroll down the page by pixel (e.g., 500 pixels)
            js1.executeScript("window.scrollBy(100, 3000)");
            Thread.sleep(1000 * 15);
            loginPageObj.ClickSearchBtn.click();
        Thread.sleep(1000 * 3);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js3.executeScript("window.scrollBy(100, 3000)");

        // Define the timeout duration in seconds
        int timeoutInSeconds = 300; // Adjust the timeout as needed
        long startTime = System.currentTimeMillis();
        boolean lockAndEditButtonFound = false;

        while (!lockAndEditButtonFound && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 1000) {
            try {
                // Click the search button
                WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='Search']"));
                clickSearchBtn.click();
                Thread.sleep(1000 * 3);
                JavascriptExecutor js4 = (JavascriptExecutor) driver;
                // Scroll down the page by pixel (e.g., 500 pixels)
                js4.executeScript("window.scrollBy(100, 3000)");
                Thread.sleep(1000 * 3);
//             // Locate the scrollable div and scroll to the bottom
//                WebElement scrollableDiv = driver.findElement(By.xpath("//div[@class='dt-scroll-body']"));
//                JavascriptExecutor js2 = (JavascriptExecutor) driver;
//                js2.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);



                // Wait for the 'WAITING_OCR' status in the last row
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement latestButton1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//table[@id='triageList']/tbody//tr[last()]/td[contains(text(),'WAITING_OCR')]"
                )));

                // If 'WAITING_OCR' is found, click the search button again to refresh the view
                if (latestButton1 != null && latestButton1.isDisplayed()) {
                    System.out.println("WAITING_OCR status found, refreshing search to reveal the latest button...");
                    // Wait for 60 seconds before refreshing the search
                    Thread.sleep(80000);
                    // Refresh the search to load the latest button
                    clickSearchBtn.click();
                    JavascriptExecutor js6 = (JavascriptExecutor) driver;
                    // Scroll down the page by pixel (e.g., 500 pixels)
                    js6.executeScript("window.scrollBy(100, 3000)");
                    Thread.sleep(60000);
                    clickSearchBtn.click();
                    // Scroll down again to ensure the new button becomes visible
                   JavascriptExecutor js5 = (JavascriptExecutor) driver;
                    // Scroll down the page by pixel (e.g., 500 pixels)
                    js5.executeScript("window.scrollBy(100, 3000)");

                    // Wait for the latest 'Lock and Edit Fax' button
                    WebElement latestButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                            "(//button[contains(@class, 'btnList') and contains(@title, 'Lock and Edit Fax')])[last()]"
                    )));

                    // If the button is found and visible, click it
                    if (latestButton != null && latestButton.isDisplayed()) {
                        lockAndEditButtonFound = true;
                        latestButton.click();
                        System.out.println("Clicked on the latest Lock and Edit button.");
                    }
                }
            } catch (TimeoutException e) {
                // Handle timeout, retry by continuing the loop
                System.out.println("Retrying... Waiting for elements to load.");
            }
        }

           // Final timeout message
        if (!lockAndEditButtonFound) {
            System.out.println("Timeout: Lock and Edit button not found within " + timeoutInSeconds + " seconds.");
        }

        Thread.sleep(1000 * 5);

        WebElement DocumentTypeBox1 = driver.findElement(By.xpath("//select[@id='doc1_type']"));
        Select docTypeDropdown = new Select(DocumentTypeBox1);
        docTypeDropdown.selectByIndex(1);

        Thread.sleep(1000 * 3);
        loginPageObj.firstName.sendKeys(data.get("firstName"));
        Thread.sleep(1000 * 5);

            Thread.sleep(1000 * 3);
            loginPageObj.lastName2.sendKeys(data.get("lastName"));
            Thread.sleep(1000 * 5);

            WebElement Genderbox = loginPageObj.Gender;
            Select selectfirstGender = new Select(Genderbox);
            selectfirstGender.selectByIndex(1);


                Thread.sleep(1000 * 3);
                loginPageObj.DOB.click();
                Thread.sleep(1000 * 3);
                loginPageObj.DOB.sendKeys("07/03/2015");
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
                JavascriptExecutor js2 = (JavascriptExecutor) driver;
                // Scroll down the page by pixel (e.g., 500 pixels)
                js2.executeScript("window.scrollBy(100, 3000)");
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
            Thread.sleep(1000*20);
            String query1 = "SELECT metadata, status ,faxid FROM replixdb.realm_triage_jobs order by ID desc limit 1;";
            DataBaseUTIL.executeSQLQueryOCRNew1(query1);

        } else {
            // Execute the other function
                Thread.sleep(1000 * 3);
                loginPageObj.Submitbtn.click();
                Thread.sleep(1000 * 3);
                loginPageObj.Closebtn.click();
                Thread.sleep(1000*40);

                String query1 = "SELECT metadata, status ,faxid FROM replixdb.realm_triage_jobs order by ID desc limit 1;";
               DataBaseUTIL.executeSQLQueryOCRNew1(query1);
                DriverFactory.closeDriver();
            }
        }
}