package testng;

import Utilities.FileReaderCucumber;
import UtilsTesNG.DriverFactory;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import Pages.LoginPageTestNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginTestStepsTestNG extends TestBase {

    @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression100"})
    public void sendFaxDataFromPortal() throws InterruptedException, AWTException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.100");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        Thread.sleep(1000 * 3);
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        //loginPageObj.confirmButton.click();

        //loginPageObj.FaxingButton.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement inputField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.FaxingButton));
        inputField3.click();
//       loginPageObj.ClickDropDown.click();
//       loginPageObj.ChooseOrgName.click();
//       loginPageObj.FaxingButton2.click();

        loginPageObj.sendFaxButton.click();
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        loginPageObj.coverPage.click();
        loginPageObj.ChoseCoverpage.click();
        Thread.sleep(1000 * 3);
        loginPageObj.uploadPage.click();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display = 'block';", loginPageObj.uploadPage); // Make the element visible
//        loginPageObj.uploadPage.sendKeys(" C:\\Users\\Administrator\\workspace\\com-selenium-test\\src\\test\\resources\\requestBody\\2page.pdf");
        //driver.findElement(By.xpath("//input[@type=\"file\"]"));
                //find_element_by_xpath('//input[@type="file"]').get_attribute('outerHTML')
        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        Robot rb = new Robot();
        rb.delay(1000 * 2);
        //put the path to file in clipboard
        StringSelection Filepath = new StringSelection(pagesSize.toString());
        System.out.println("File Name: " + pagesSize.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
        Thread.sleep(1000*3);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(1000);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(300);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000 * 5);

        loginPageObj.ClickSendButton.click();
        loginPageObj.confirmationButton.click();
        DriverFactory.closeDriver();
    }

        @Test(testName = "Send Fax from portal with valid credentials", groups = {"RegressionPDF"})
        public void sendFaxForPDFScale() throws InterruptedException, AWTException {
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Test case name: " + testName);
            Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
            assert data != null;

            driver.get("http://10.250.1.100");
            Thread.sleep(1000 * 3);
            /*This operation will maximize window*/
            driver.manage().window().maximize();
            LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

            loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
            loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
            Thread.sleep(1000 * 3);
            loginPageObj.loginButton.click();
            Thread.sleep(1000 * 3);
            //loginPageObj.confirmButton.click();
            loginPageObj.FaxingButton.click();
//       loginPageObj.ClickDropDown.click();
//       loginPageObj.ChooseOrgName.click();
//       loginPageObj.FaxingButton2.click();

            loginPageObj.sendFaxButton.click();
            loginPageObj.faxNumber.click();
            loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));

            Thread.sleep(1000 * 3);
            loginPageObj.uploadPage.click();
            Thread.sleep(1000 * 5);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].style.display = 'block';", loginPageObj.uploadPage); // Make the element visible
//        loginPageObj.uploadPage.sendKeys(" C:\\Users\\Administrator\\workspace\\com-selenium-test\\src\\test\\resources\\requestBody\\2page.pdf");
            //driver.findElement(By.xpath("//input[@type=\"file\"]"));
            //find_element_by_xpath('//input[@type="file"]').get_attribute('outerHTML')
            //File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));

            File pagesSize = FileReader.readfile("8-5by5-5");
            Robot rb = new Robot();
            rb.delay(1000 * 2);
            //put the path to file in clipboard
            StringSelection Filepath = new StringSelection(pagesSize.toString());
            System.out.println("File Name: " + pagesSize.toString());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
            Thread.sleep(1000*3);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            rb.delay(1000);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.delay(1000);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            rb.delay(300);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            rb.delay(1000 * 5);

            loginPageObj.ClickSendButton.click();
            loginPageObj.confirmationButton.click();
            Thread.sleep(1000 * 3);
            loginPageObj.OutboundRadiobox.click();
            Thread.sleep(1000 * 3);


            DriverFactory.closeDriver();
        }


}
