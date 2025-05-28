package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.RestRequestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ReprocessDocConversion extends TestBase {


    @Test(priority = 1, testName = "Portal:ReprocessDOCConversion ", groups = {"Regression84new"}) //it's not in the Jenkins regression cuz of file attachment Robot class/
    public void ReprocessDocConversionPortal() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

//        Response response = RestRequestUtils.putScenario84Pportal(data.get("put_call_Url"));
//        Thread.sleep(1000 * 5);
//        Response response2 = RestRequestUtils.reprocessScenario(data.get("post_call_stop/Service"));
//        Thread.sleep(1000*30);
//        assertEquals(response.getStatusCode(), 200);
//        System.out.println("------------------------------------------------------------------------");
//        System.out.println(response.asPrettyString());
//        System.out.println(response2.asPrettyString());
//        System.out.println("**" + (data.get("put_call_Url")));
//        System.out.println("------------------------------------------------------------------------");
        driver.get("https://regression.rpxqa.com/");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);
        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
//        Thread.sleep(1000*10);
//        Response response3 = RestRequestUtils.reprocessScenario(data.get("post_call_start/Service"));
//        System.out.println(response3);
//        Thread.sleep(1000*30);
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.faxNumber.click();
        Thread.sleep(1000 * 3);
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 3);
        loginPageObj.uploadPage.click();

//        loginPageObj.coverPage.click();
//        loginPageObj.ChoseCoverpage.click();
//        Thread.sleep(1000 * 3);
//        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement dropzone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));
//        dropzone.click();
        Thread.sleep(1000 * 10);
        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        Robot rb = new Robot();
        rb.delay(1000 * 2);
        //put the path to file in clipboard
        StringSelection Filepath = new StringSelection(pagesSize.toString());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(1000 * 2);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000 * 5);

//             Wait until the form is visible
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            WebElement dropzone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));
//
//            // Path to your file
//            File fileToUpload = new File(pagesSize.getAbsolutePath());
//
//            // Execute JavaScript to add the file to Dropzone
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
//                    "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
//                    "dropzone.emit('addedfile', mockFile);" +
//                    "dropzone.emit('complete', mockFile);");

//        // Wait until the form is visible
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement dropzone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));
//
//        // Path to your file
//        String pagesSize ="C:\\Users\\faxes\\2page.pdf";
//        File fileToUpload = new File(pagesSize);
//        String filePath = fileToUpload.getAbsolutePath();
//
//        // Execute JavaScript to add the file to Dropzone
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(
//                "var dropzone = Dropzone.forElement('#dropzone');" +
//                        "var file = new File([''], arguments[0]);" +  // Provide the file name
//                        "dropzone.addFile(file);", filePath
//        );
        Thread.sleep(1000*3);
        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000*3);
        loginPageObj.confirmationButton.click();
        Thread.sleep(1000 * 10);
//        loginPageObj.AdministrationHeading.click();
//        Thread.sleep(1000 * 3);
//        loginPageObj.AdministrationfilterFaxstatus.click();
//        Thread.sleep(1000 * 3);
//        loginPageObj.OutboundRadiobox.click();
//
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        // Scroll down the page by pixel (e.g., 500 pixels)
//        js1.executeScript("window.scrollBy(100, 3000)");
//        // Define the timeout duration in seconds
//        int timeoutInSeconds = 180; // Adjust the timeout as needed
//
//        // Loop until the info button is visible or timeout occurs
//        long startTime = System.currentTimeMillis();
//        boolean InfoButton = false;
//
//        while (!InfoButton && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 1000) {
//            //Click the search button
//            WebElement clickSearchBtn = driver.findElement(By.xpath("//a[@id='SearchForFaxes']"));
//            clickSearchBtn.click();
//
//            // Wait for info btn to be visible
//            try {
//                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
//                wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")));
//                InfoButton = true; // Exit the loop if Info btn is found
//            } catch (org.openqa.selenium.TimeoutException e) {
//                // info btn is not found yet, continue the loop
//            }
//        }
//        // Click on info btn if found
//        if (InfoButton) {
//            WebElement infoBtn = driver.findElement(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]"));
//            infoBtn.click();
//        } else {
//            System.out.println("Timeout: Info button not found within " + timeoutInSeconds + " seconds.");
//        }
//        Thread.sleep(1000 * 5);
//        loginPageObj.closeInfoBtn.click();
//        Thread.sleep(1000 * 3);
//        JavascriptExecutor scrollPage1 = (JavascriptExecutor) driver;
//        scrollPage1.executeScript("window.scrollBy(100,3000)");
//        Thread.sleep(1000 * 2);
//        Response response4 = RestRequestUtils.putScenario84Pportal(data.get("put_call_Url2"));
//        System.out.println(response4);
//        Thread.sleep(1000 * 5);
//        loginPageObj.advancedActionBTN.click();
//        Thread.sleep(1000 * 2);
//        loginPageObj.ReprocessCoverPandDocConversion.click();
//        Thread.sleep(1000 * 3);
//        loginPageObj.conversionIssuebeenResolvedBTN.click();
//        Thread.sleep(1000 * 3);
//        WebElement clickSearchBtn = driver.findElement(By.xpath("//a[@id='SearchForFaxes']"));
//        clickSearchBtn.click();
//        Thread.sleep(1000 * 10);


    }
}