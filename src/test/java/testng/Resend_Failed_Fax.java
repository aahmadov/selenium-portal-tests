package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.RestRequestUtils;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class Resend_Failed_Fax extends TestBase {


    @Test(priority = 1, testName = "Portal:Resend Failed Fax ", groups = {"Regression84Yeni"})
    public void ResendFailedFaxPortal() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        Response response = RestRequestUtils.putScenario84Pportal(data.get("put_call_Url"));
        Thread.sleep(1000 * 20);
        Response response2 = RestRequestUtils.reprocessScenario(data.get("post_call_stop/Service"));
        Thread.sleep(1000 * 30);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response2.getStatusCode(), 200);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(response.asPrettyString());
        System.out.println(response2.asPrettyString());
        System.out.println("------------------------------------------------------------------------");
//        driver.get("http://10.250.1.84:80/");
//        Thread.sleep(1000 * 3);
//        /*This operation will maximize window*/
//        driver.manage().window().maximize();
//        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);
//        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
//        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
//        loginPageObj.loginButton.click();
//        Thread.sleep(1000 * 10);
//        Response response3 = RestRequestUtils.reprocessScenario(data.get("post_call_start/Service"));
//        System.out.println(response3);
//        Thread.sleep(1000 * 30);
//        loginPageObj.FaxingButton.click();
//        loginPageObj.sendFaxButton.click();
//        Thread.sleep(1000 * 3);
//        loginPageObj.faxNumber.click();
//        Thread.sleep(1000 * 3);
//        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
//        Thread.sleep(1000 * 3);
//        loginPageObj.coverPage.click();
//        Thread.sleep(1000 * 3);
//        loginPageObj.ChoseCoverpage.click();
//
//        Thread.sleep(1000*3);
//        loginPageObj.ClickSendButton.click();
//        Thread.sleep(1000*3);
//        loginPageObj.confirmationButton.click();
//        Thread.sleep(1000 * 10);
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
        Response response3 = RestRequestUtils.putScenario84Pportal(data.get("put_call_Url2"));
        Thread.sleep(1000 * 30);
//        Thread.sleep(1000 * 5);
//        loginPageObj.advancedActionBTN.click();
//        Thread.sleep(1000 * 2);
//        loginPageObj.ReprocessCoverPandDocConversion.click();
//        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ResendFaxSave']"))) ;
//        WebElement clickSubmitBtn = driver.findElement(By.xpath("//*[@id='ResendFaxSave']"));
//        clickSubmitBtn.click();
////        loginPageObj.submitResendBTN.click();
//        Thread.sleep(1000 * 3);
//        WebDriverWait wait2 =new WebDriverWait(driver,Duration.ofSeconds(20));
//        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-footer']//button[contains(@class, 'btn btn-orange btn-sm dialogBtn') and contains(text(), 'OK')]"))) ;
//        WebElement clickSubmitConfirmationBtn = driver.findElement(By.xpath("//div[@class='modal-footer']//button[contains(@class, 'btn btn-orange btn-sm dialogBtn') and contains(text(), 'OK')]"));
//        clickSubmitConfirmationBtn.click();
////        loginPageObj.confirmationsubmitResendBTN.click();
//        Thread.sleep(1000 * 3);
//        WebElement clickSearchBtn = driver.findElement(By.xpath("//a[@id='SearchForFaxes']"));
//        clickSearchBtn.click();
//        JavascriptExecutor scrollPage2 = (JavascriptExecutor) driver;
//        scrollPage1.executeScript("window.scrollBy(100,3000)");
//        Thread.sleep(1000 * 10);

    }
}