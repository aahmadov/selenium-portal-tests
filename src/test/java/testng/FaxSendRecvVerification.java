package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import org.bouncycastle.jcajce.provider.asymmetric.EC;
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
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

public class FaxSendRecvVerification extends TestBase {

    @Test(priority = 1, testName = "Send Fax from portal ", groups = {"Regression8412"})
    public void OutboundandInboundVerification() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        Thread.sleep(1000 * 3);
        loginPageObj.coverPage.click();
        loginPageObj.ChoseCoverpage.click();
//        Thread.sleep(5000 );
//        loginPageObj.uploadPage.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//       // WebElement dropzone = wait.until(EC.presence_of_element_located((By.ID, "dropzone")))
//        WebElement dropzone = wait.until(ExpectedConditions.visibilityOf(By.id,("dropzone"));
//        dropzone = driver.execute_script("return arguments[0].querySelector('input[type=\"file\"]')", dropzone);
//        JavascriptExecutor jsnew = (JavascriptExecutor) driver;
//        // Click the element using JavaScript
//        jsnew.executeScript("arguments[0].scrollIntoView(true);", dropzone);
        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
//        WebElement ele1 = driver.findElement(By.id("dropzone"));
//        ele1.sendKeys(pagesSize.getAbsolutePath());


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


//        Robot rb = new Robot();
//        rb.delay(1000 * 2);
        //put the path to file in clipboard
//        StringSelection Filepath = new StringSelection(pagesSize.toString());
//        System.out.println("File Name: " + pagesSize.toString());
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
//        rb.keyPress(KeyEvent.VK_ENTER);
//        rb.keyRelease(KeyEvent.VK_ENTER);
//        rb.delay(1000);
//        rb.keyPress(KeyEvent.VK_CONTROL);
//        rb.keyPress(KeyEvent.VK_V);
//        rb.delay(1000);
//        rb.keyRelease(KeyEvent.VK_CONTROL);
//        rb.keyRelease(KeyEvent.VK_V);
//        rb.delay(300);
//        rb.keyPress(KeyEvent.VK_ENTER);
//        rb.keyRelease(KeyEvent.VK_ENTER);
//        rb.delay(1000 * 5);
        Thread.sleep(1000 * 5);
        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000*3);
        loginPageObj.confirmationButton.click();
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000 * 3);
        loginPageObj.OutboundRadiobox.click();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
        // Define the timeout duration in seconds
        int timeoutInSeconds = 180; // Adjust the timeout as needed

        // Loop until the info button is visible or timeout occurs
        long startTime = System.currentTimeMillis();
        boolean InfoButton = false;

        while (!InfoButton && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 1000) {
            // Click the search button
            WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='SearchForFaxes']"));
            clickSearchBtn.click();

            // Wait for info btn to be visible
            try {
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")));
                InfoButton = true; // Exit the loop if Info btn is found
            } catch (org.openqa.selenium.TimeoutException e) {
                // info btn is not found yet, continue the loop
            }
        }
        // Click on info btn if found
        if (InfoButton) {
            WebElement infoBtn = driver.findElement(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]"));
            infoBtn.click();
        } else {
            System.out.println("Timeout: Info button not found within " + timeoutInSeconds + " seconds.");
        }
        Thread.sleep(1000*5);
        loginPageObj.closeInfoBtn.click();
        Thread.sleep(1000 * 5);
        String query = "SELECT JobID,Pages,FaxUserID,JobStatus FROM auto1.sendstatus order by JobID desc limit 1;";
        DataBaseUTIL.executeSQLQuery84Database(query);

        Thread.sleep(1000 * 5);
        loginPageObj.InboundRadiobox.click();
        // Create a JavaScriptExecutor object
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js2.executeScript("window.scrollBy(100, 3000)");
        int timeoutInSecondsInbound = 300; // Adjust the timeout as needed

        // Loop until the info button is visible or timeout occurs
        long startTimeInbound = System.currentTimeMillis();
        boolean InfoButtonInbound = false;

        while (!InfoButtonInbound && (System.currentTimeMillis() - startTimeInbound) < timeoutInSecondsInbound * 1000) {
            // Click the search button
            WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='SearchForFaxes']"));
            clickSearchBtn.click();

            // Wait for info btn to be visible
            try {
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
                wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='inboundFaxes']/tbody/tr[1]//button[5]")));
                InfoButtonInbound = true; // Exit the loop if Info btn is found
            } catch (org.openqa.selenium.TimeoutException e) {
                // info btn is not found yet, continue the loop
            }
        }
        // Click on info btn if found
        if (InfoButtonInbound) {
            WebElement infoBtnInbound = driver.findElement(By.xpath("//table[@id='inboundFaxes']/tbody/tr[1]//button[5]"));
            infoBtnInbound.click();
        } else {
            System.out.println("Timeout: Info button not found within " + timeoutInSecondsInbound + " seconds.");
        }
        Thread.sleep(1000*5);
        loginPageObj.closeInfoBtnAfterRecv.click();
        String queryRecvStatus = "SELECT JobID,Pages,FaxUserID,JobStatus FROM auto1.recvstatus order by JobID desc limit 1";
        DataBaseUTIL.executeSQLQuery84Database(queryRecvStatus);

    }

    @Test(priority = 2, testName = "Send Fax from portal ", groups = {"Regression84"})
    public void Change_the_From_data_and_do_another_search() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000 * 3);
        loginPageObj.OutboundRadiobox.click();
        Thread.sleep(1000 * 3);
        loginPageObj.SearchAfterradioBtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(100, 1000)");
        Thread.sleep(1000*3);
        loginPageObj.CalendarFilteStart.clear();
        Thread.sleep(1000*3);
        loginPageObj.CalendarFilteStart.sendKeys(data.get("fromData"));
        Thread.sleep(1000*5);
        loginPageObj.FilteStatus.click();
        WebElement ChoseStatus = loginPageObj.FilteStatus;
        Select selectfirstGender = new Select(ChoseStatus);
        selectfirstGender.selectByIndex(0);
        Thread.sleep(1000*3);
        // Define the timeout duration in seconds
        int timeoutInSeconds = 180; // Adjust the timeout as needed

        // Loop until the info button is visible or timeout occurs
        long startTime = System.currentTimeMillis();
        boolean InfoButton = false;

        while (!InfoButton && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 1000) {
            // Click the search button
            WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='SearchForFaxes']"));
            clickSearchBtn.click();

            // Wait for info btn to be visible
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")));
                InfoButton = true; // Exit the loop if Info btn is found
            } catch (org.openqa.selenium.TimeoutException e) {
                // info btn is not found yet, continue the loop
            }
        }
        // Click on info btn if found
        if (InfoButton) {
            WebElement infoBtn = driver.findElement(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]"));
            infoBtn.click();
        } else {
            System.out.println("Timeout: Info button not found within " + timeoutInSeconds + " seconds.");
        }
        Thread.sleep(1000*5);
        loginPageObj.closeInfoBtn.click();


    }
    @Test(priority = 3, testName = "Send Fax from portal ", groups = {"Regression84"})
    public void Change_the_From_Inbound_data_and_do_another_search() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationfilterFaxstatus.click();
        Thread.sleep(1000 * 3);

        loginPageObj.InboundRadiobox.click();

        // Create a JavaScriptExecutor object
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js2.executeScript("window.scrollBy(100, 3000)");

        loginPageObj.CalendarFilteStart.clear();
        Thread.sleep(1000*3);
        loginPageObj.CalendarFilteStart.sendKeys(data.get("fromData"));
        Thread.sleep(1000*5);
        loginPageObj.FilteStatus.click();
        WebElement ChoseStatusInbound = loginPageObj.FilteStatus;
        Select selectfirstGender = new Select(ChoseStatusInbound);
        selectfirstGender.selectByIndex(0);
        Thread.sleep(1000*3);
        int timeoutInSecondsInbound = 300; // Adjust the timeout as needed

        // Loop until the info button is visible or timeout occurs
        long startTimeInbound = System.currentTimeMillis();
        boolean InfoButtonInbound = false;

        while (!InfoButtonInbound && (System.currentTimeMillis() - startTimeInbound) < timeoutInSecondsInbound * 1000) {
            // Click the search button
            WebElement clickSearchBtn = driver.findElement(By.xpath("//*[@id='SearchForFaxes']"));
            clickSearchBtn.click();

            // Wait for info btn to be visible
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='inboundFaxes']/tbody/tr[1]//button[5]")));
                InfoButtonInbound = true; // Exit the loop if Info btn is found
            } catch (org.openqa.selenium.TimeoutException e) {
                // info btn is not found yet, continue the loop
            }
        }
        // Click on info btn if found
        if (InfoButtonInbound) {
            WebElement infoBtnInbound = driver.findElement(By.xpath("//table[@id='inboundFaxes']/tbody/tr[1]//button[5]"));
            infoBtnInbound.click();
        } else {
            System.out.println("Timeout: Info button not found within " + timeoutInSecondsInbound + " seconds.");
        }
        Thread.sleep(1000 * 5);
        loginPageObj.closeInfoBtnAfterRecv.click();
    }

}