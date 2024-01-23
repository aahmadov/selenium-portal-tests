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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression"})
    public void sendFaxHasOCRdata() throws InterruptedException, AWTException, SQLException, IOException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.81:8585/");
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
            loginPageObj.uploadPage.click();
            Thread.sleep(1000 * 5);
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].style.display = 'block';", loginPageObj.uploadPage); // Make the element visible
////        loginPageObj.uploadPage.sendKeys(" C:\\Users\\Administrator\\workspace\\com-selenium-test\\src\\test\\resources\\requestBody\\2page.pdf");
////        //driver.findElement(By.xpath("//input[@type=\"file\"]"));
////        //find_element_by_xpath('//input[@type="file"]').get_attribute('outerHTML')

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
            File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
            Robot rb = new Robot();
            rb.delay(1000 * 2);
            //put the path to file in clipboard
            StringSelection Filepath = new StringSelection(pagesSize.toString());
            System.out.println("File Name: " + pagesSize.toString());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
            Thread.sleep(1000 * 3);
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
//
//
            Thread.sleep(1000 * 3);
            loginPageObj.TriageQueueBox.click();
            Thread.sleep(1000 * 3);
            loginPageObj.SelectQueue.click();
            Thread.sleep(1000 * 3);
            loginPageObj.SelectQueueBox.click();
            Thread.sleep(1000 * 3);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 3);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 3000)");
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        JavascriptExecutor js2 = (JavascriptExecutor) driver;
//        //js2.executeScript("arguments[0].scrollTop = arguments[1];", tableScroll, "arguments[0].scrollHeight", "");
//        js2.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       WebElement searchBtn = loginPageObj.ClickSearchBtn;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement TableScroll=loginPageObj.Scrollbtn;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];", TableScroll, 1000);

        //Loop until the button appears and click it dynamically
        while (true) {
            try {
                // Wait for the button to be clickable
                WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));

                // Click the button
                searchButton.click();

                // Break out of the loop after clicking
                break;
            } catch (org.openqa.selenium.TimeoutException e) {
                // Continue waiting if the button is not found within the timeout
            }
        }



            Thread.sleep(1000 * 20);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 40);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 40);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 40);
            loginPageObj.ClickSearchBtn.click();
            Thread.sleep(1000 * 20);
            loginPageObj.ClickSearchBtn.click();

        WebElement TableScroll1=loginPageObj.Scrollbtn;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];",TableScroll, 1000);

            Thread.sleep(1000 * 5);
            loginPageObj.LockandEditbox.click();
            Thread.sleep(1000 * 5);
            loginPageObj.lastName.sendKeys(data.get("name"));
            Thread.sleep(1000 * 5);
            loginPageObj.Gender.click();
            Thread.sleep(1000 * 5);
             loginPageObj.Female.click();


//----------------------------------------------------------------------------------------------------------------------------------------

//            WebElement gender = loginPageObj.Gender;
//            Select genderDropdown = new Select(gender);
//            List<WebElement> firstOptionText = genderDropdown.getAllSelectedOptions();
//
//            for (WebElement option : firstOptionText) {
//                // Iterate through selected options
//                String text = option.getText();
//                assertEquals("Expected Text", text);
//                System.out.println("chosen option is: " + text);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
                JavascriptExecutor js = (JavascriptExecutor) driver;
                // Scroll down the page by pixel (e.g., 500 pixels)
                js.executeScript("window.scrollBy(100, 3000)");

                loginPageObj.FaxComments.sendKeys("HelloWorld!");
                Thread.sleep(1000 * 3);
                loginPageObj.Submitbtn.click();
                Thread.sleep(1000 * 3);
                loginPageObj.Closebtn.click();
                Thread.sleep(1000*40);
        WebElement TableScroll2=loginPageObj.Scrollbtn;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];",TableScroll, 1000);

                String query = "SELECT metadata, status ,faxid FROM replixdb.realm_triage_jobs order by faxid desc limit 1;";
               DataBaseUTIL.executeSQLQueryOCRNew(query);

                DriverFactory.closeDriver();
            }
        }