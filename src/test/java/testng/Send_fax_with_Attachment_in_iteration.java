package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;

public class Send_fax_with_Attachment_in_iteration extends TestBase {

    @Test(priority = 1, testName = "Portal:Send Fax with Attachment ", groups = {"Regression84test"}) //it's not for regression ,it just required for one time test!
    public void SendFaxWithAttachments() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("https://portal.rpxtest.com/");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);
        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        loginPageObj.FaxingButton.click();
        Thread.sleep(1000 * 3);

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000 * 2);
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        Thread.sleep(1000 * 4);
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 2);
        loginPageObj.uploadPage.click();
        Thread.sleep(1000 * 5);
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
            loginPageObj.ClickSendButton.click();
            Thread.sleep(1000 * 3);
            loginPageObj.confirmationButton.click();
            Thread.sleep(1000 * 2);
//            loginPageObj.FaxesBTN.click();
//            Thread.sleep(1000 * 3);
//            loginPageObj.OutboundRadiobox.click();
//            Thread.sleep(1000 * 15);
//            loginPageObj.searchBTN.click();
//            Thread.sleep(1000 * 5);
//            loginPageObj.searchBTN.click();

//            JavascriptExecutor js1 = (JavascriptExecutor) driver;
//            // Scroll down the page by pixel (e.g., 500 pixels)
//            js1.executeScript("window.scrollBy(100, 3000)");
//            // Define the timeout duration in seconds
//            int timeoutInSeconds = 180; // Adjust the timeout as needed
//
//            // Loop until the info button is visible or timeout occurs
//            long startTime = System.currentTimeMillis();
//            boolean InfoButton = false;
//
//            while (!InfoButton && (System.currentTimeMillis() - startTime) < timeoutInSeconds * 1000) {
//                //Click the search button
//                WebElement clickSearchBtn = driver.findElement(By.xpath("//a[@id='SearchForFaxes']"));
//                clickSearchBtn.click();
//
//                // Wait for info btn to be visible
//                try {
//                    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 20 seconds for the info btn to appear
//                    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")));
//                    InfoButton = true; // Exit the loop if Info btn is found
//                } catch (org.openqa.selenium.TimeoutException e) {
//                    // info btn is not found yet, continue the loop
//                }
//            }
//            // Click on info btn if found
//            if (InfoButton) {
//                WebElement infoBtn = driver.findElement(By.xpath("//table[@id='outboundFaxes']/tbody/tr[1]//button[5]"));
//                infoBtn.click();
//            } else {
//                System.out.println("Timeout: Info button not found within " + timeoutInSeconds + " seconds.");
//            }
            Thread.sleep(1000 * 2);
        }
        }
}
