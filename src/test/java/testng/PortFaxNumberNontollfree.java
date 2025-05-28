package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.DataBaseUTIL;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

public class PortFaxNumberNontollfree extends TestBase {
    @Test(priority = 1, testName = "Port Fax Number Request toll free from portal ", groups = {"Regression84"})
    public void portFaxNumberRequest() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("https://regression.rpxqa.com/");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);

//        loginPageObj.AdministrationHeading.click();
//        Thread.sleep(1000 * 3);

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement inputField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.AdministrationHeading));
        inputField3.click();
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberfromManageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionDropdownButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionPortFaxNumber.click();
        Thread.sleep(1000 * 3);
//        loginPageObj.TollFreeNumberBTN.click();
//        Thread.sleep(1000 * 3);
        loginPageObj.selectCountry.click();
        WebElement selectCountry = loginPageObj.selectCountry;
        Select selectCountryBTN = new Select(selectCountry);
        selectCountryBTN.selectByIndex(1);
        Thread.sleep(1000 * 3);
        loginPageObj.selectDepartments.click();
        WebElement selectDepartment =loginPageObj.selectDepartments;
        Select selectDepartBTN = new Select (selectDepartment);
        selectDepartBTN.selectByIndex(0);
        Thread.sleep(1000 * 3);
        loginPageObj.faxNumbertoPort.click();
        Thread.sleep(1000 * 3);
        loginPageObj.faxNumbertoPort.sendKeys(FileReader.randomFaxNumber());
        Thread.sleep(1000 * 3);
        loginPageObj.assignToUserBTn.click();
        WebElement userToassign = loginPageObj.assignToUserBTn;
        Select selectUser = new Select(userToassign);
        selectUser.selectByVisibleText("Unassigned");
        Thread.sleep(1000 * 3);
        loginPageObj.emailRequired.click();
        loginPageObj.emailRequired.clear();
        Thread.sleep(1000*2);
        loginPageObj.emailRequired.sendKeys(data.get("email"));
        Thread.sleep(1000*2);
        loginPageObj.commentSection.click();
        Thread.sleep(1000*2);
        loginPageObj.commentSection.sendKeys("Hello World!");
        Thread.sleep(1000*3);
        if (Boolean.parseBoolean(data.get("buildForm").toString())){


            loginPageObj.buildFormBTN.click();
            Thread.sleep(1000 * 2);
            loginPageObj.companyNameField.click();
            loginPageObj.companyNameField.sendKeys("Softlinx");
            Thread.sleep(1000 * 2);
            loginPageObj.addressNameField.click();
            loginPageObj.addressNameField.sendKeys("13130 FRY RD");
            Thread.sleep(1000 * 2);
            loginPageObj.cityNameField.click();

            loginPageObj.cityNameField.sendKeys("Cypress");
            Thread.sleep(1000 * 2);
            loginPageObj.stateNameField.click();
            WebElement stateChoose = loginPageObj.stateNameField;
            Select state = new Select(stateChoose);
            state.selectByVisibleText("Texas");
            Thread.sleep(1000 * 2);
            loginPageObj.zipNameField.click();
            loginPageObj.zipNameField.sendKeys("77433");
            Thread.sleep(1000 * 2);
            loginPageObj.CarrierNameField.click();
            loginPageObj.CarrierNameField.sendKeys("Test company");

            loginPageObj.CarrierAccountNameField.click();
            loginPageObj.CarrierAccountNameField.sendKeys("Test company");
            Thread.sleep(1000 * 2);
            loginPageObj.inputBTN.click();
            Thread.sleep(1000 * 2);
            loginPageObj.inputBTN.sendKeys("713");
            loginPageObj.inputPortBTN.click();
            Thread.sleep(1000 * 2);
            WebElement portType = loginPageObj.inputPortBTN;
            Select portTypechoose = new Select(portType);
            portTypechoose.selectByIndex(0);
            Thread.sleep(1000 * 2);
            loginPageObj.dateField.clear();
            Thread.sleep(1000 * 2);
            loginPageObj.dateField.sendKeys("06/17/2024");
            Thread.sleep(1000 * 2);
            loginPageObj.nameField.click();
            loginPageObj.nameField.sendKeys("Maple leaf Enterprises LLC");
            Thread.sleep(1000 * 2);
            loginPageObj.titleField.click();
            Thread.sleep(1000 * 2);
            loginPageObj.titleField.sendKeys("Business");
            Thread.sleep(1000 * 2);
            loginPageObj.createField.click();
            Thread.sleep(1000 * 10);

        }else {
          //C:\Users\faxes\2page.pdf

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Scroll down the page to ensure the element is in view
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", loginPageObj.portSecondPageScroll);
            // Wait for the input field to be present and visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement inputField = wait.until(ExpectedConditions.visibilityOf(loginPageObj.LetterOfAgencyBTN2));


            // Click the element using JavaScript
            js.executeScript("arguments[0].scrollIntoView(true);", inputField);
//            js.executeScript("arguments[0].click();", inputField);

            // Use the Robot class to handle the file upload
            Thread.sleep(3000); // Ensure the file dialog is open before performing actions
            File pagesSize1 = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
//            Robot rb1 = new Robot();
//            rb1.delay(2000);

            // Put the path to the file in clipboard
            StringSelection Filepath = new StringSelection(pagesSize1.getAbsolutePath());
            System.out.println("File Name: " + pagesSize1.getAbsolutePath());
            WebElement ele1 = driver.findElement(By.id("carrierFormFile"));
            ele1.sendKeys(pagesSize1.getAbsolutePath());
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
//
//            rb1.delay(2000);
//
//            // Press Enter to focus the file dialog
//            rb1.keyPress(KeyEvent.VK_ENTER);
//            rb1.keyRelease(KeyEvent.VK_ENTER);
//            rb1.delay(1000);
//
//            // Paste the file path
//            rb1.keyPress(KeyEvent.VK_CONTROL);
//            rb1.keyPress(KeyEvent.VK_V);
//            rb1.delay(1000);
//            rb1.keyRelease(KeyEvent.VK_CONTROL);
//            rb1.keyRelease(KeyEvent.VK_V);
//            rb1.delay(300);
//
//            // Press Enter to confirm the file selection
//            rb1.keyPress(KeyEvent.VK_ENTER);
//            rb1.keyRelease(KeyEvent.VK_ENTER);
//            rb1.delay(5000);
            // Scroll down the page to ensure the element is in view
            Thread.sleep(2000);
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[0].scrollIntoView(true);", loginPageObj.portSecondPageScroll);
            // Wait for the input field to be present and visible
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement inputField2 = wait2.until(ExpectedConditions.visibilityOf(loginPageObj.MostRecentPhoneBill));

            // Click the element using JavaScript
//            js2.executeScript("arguments[0].click();", inputField2);

            File pagesSize2 = FileReader.getFileUsingPageSize(data.get("pageSize2"), data.get("fileType2"));
//            Robot rb2 = new Robot();
//            rb2.delay(1000 * 2);
            //put the path to file in clipboard
            StringSelection Filepath2 = new StringSelection(pagesSize2.toString());
            System.out.println("File Name: " + pagesSize2.toString());
            WebElement ele2 = driver.findElement(By.id("phoneBill"));
            ele2.sendKeys(pagesSize2.getAbsolutePath());
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath2, null);
//            Thread.sleep(1000 * 3);
//            rb2.keyPress(KeyEvent.VK_ENTER);
//            rb2.keyRelease(KeyEvent.VK_ENTER);
//            rb2.delay(1000);
//            rb2.keyPress(KeyEvent.VK_CONTROL);
//            rb2.keyPress(KeyEvent.VK_V);
//            rb2.delay(1000);
//            rb2.keyRelease(KeyEvent.VK_CONTROL);
//            rb2.keyRelease(KeyEvent.VK_V);
//            rb2.delay(300);
//            rb2.keyPress(KeyEvent.VK_ENTER);
//            rb2.keyRelease(KeyEvent.VK_ENTER);
//            rb2.delay(1000 * 5);
            Thread.sleep(2000);
            loginPageObj.submit.click();
            Thread.sleep(1000*5);
            loginPageObj.submitConfirmBTN.click();
            Thread.sleep(1000*25);
            //Wait for the modal to be visible
            WebDriverWait waitCancelBTn = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement CancelBTN = waitCancelBTn.until(ExpectedConditions.visibilityOf(loginPageObj.anotherRequestConfirmBTN));

            // Click the element using JavaScript
            js.executeScript("arguments[0].click();", CancelBTN);
            Thread.sleep(1000 * 5);

            loginPageObj.clickingSecondPage.click();
            Thread.sleep(1000 * 5);
            loginPageObj.findLastRowintheTabledPage.click();
            Thread.sleep(1000 * 5);
            WebDriverWait waitConfirmBTn = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement ConfirBTN = waitCancelBTn.until(ExpectedConditions.visibilityOf(loginPageObj.InfoButtonOfFaxNumberTabel));
            // Click the element using JavaScript
            js.executeScript("arguments[0].click();", ConfirBTN);
//          loginPageObj.InfoButtonOfFaxNumberTabel.click();
            Thread.sleep(1000*5);
//            loginPageObj.closeBTNofInfoBtn.click();

            WebDriverWait waitCloseBTn = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement CloseInfoBTN = waitCloseBTn.until(ExpectedConditions.visibilityOf(loginPageObj.closeBTNofInfoBtn));

            // Click the element using JavaScript
            js.executeScript("arguments[0].click();", CloseInfoBTN);
            Thread.sleep(1000 * 5);
            String query = "SELECT id,status,realm,assigned_faxnumber FROM replixdb.faxnumber_requests order by id desc limit 1;";
            DataBaseUTIL.executeSQLQuery84Database(query);

            Thread.sleep(1000 * 10);
        }
    }


    @Test(priority = 1, testName = "Port Fax Number Request toll free from portal ", groups = {"Regression46"})
    public void portFaxNumberRequest46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;

        driver.get("http://10.250.1.46:8585/");
        Thread.sleep(1000 * 3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);

//        loginPageObj.AdministrationHeading.click();
//        Thread.sleep(1000 * 3);

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement inputField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.AdministrationHeading));
        inputField3.click();
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberfromManageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionDropdownButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionPortFaxNumber.click();
        Thread.sleep(1000 * 3);
//        loginPageObj.TollFreeNumberBTN.click();
//        Thread.sleep(1000 * 3);
        loginPageObj.selectCountry.click();
        WebElement selectCountry = loginPageObj.selectCountry;
        Select selectCountryBTN = new Select(selectCountry);
        selectCountryBTN.selectByIndex(1);
        Thread.sleep(1000 * 3);
        loginPageObj.selectDepartments.click();
        WebElement selectDepartment =loginPageObj.selectDepartments;
        Select selectDepartBTN = new Select (selectDepartment);
        selectDepartBTN.selectByIndex(0);
        Thread.sleep(1000 * 3);
        loginPageObj.faxNumbertoPort.click();
        Thread.sleep(1000 * 3);
        loginPageObj.faxNumbertoPort.sendKeys(FileReader.randomFaxNumber());
        Thread.sleep(1000 * 3);
        loginPageObj.assignToUserBTn.click();
        WebElement userToassign = loginPageObj.assignToUserBTn;
        Select selectUser = new Select(userToassign);
        selectUser.selectByVisibleText("Unassigned");
        Thread.sleep(1000 * 3);
        loginPageObj.emailRequired.click();
        loginPageObj.emailRequired.clear();
        Thread.sleep(1000*2);
        loginPageObj.emailRequired.sendKeys(data.get("email"));
        Thread.sleep(1000*2);
        loginPageObj.commentSection.click();
        Thread.sleep(1000*2);
        loginPageObj.commentSection.sendKeys("Hello World!");
        Thread.sleep(1000*3);
        if (Boolean.parseBoolean(data.get("buildForm").toString())){


            loginPageObj.buildFormBTN.click();
            Thread.sleep(1000 * 2);
            loginPageObj.companyNameField.click();
            loginPageObj.companyNameField.sendKeys("Softlinx");
            Thread.sleep(1000 * 2);
            loginPageObj.addressNameField.click();
            loginPageObj.addressNameField.sendKeys("13130 FRY RD");
            Thread.sleep(1000 * 2);
            loginPageObj.cityNameField.click();

            loginPageObj.cityNameField.sendKeys("Cypress");
            Thread.sleep(1000 * 2);
            loginPageObj.stateNameField.click();
            WebElement stateChoose = loginPageObj.stateNameField;
            Select state = new Select(stateChoose);
            state.selectByVisibleText("Texas");
            Thread.sleep(1000 * 2);
            loginPageObj.zipNameField.click();
            loginPageObj.zipNameField.sendKeys("77433");
            Thread.sleep(1000 * 2);
            loginPageObj.CarrierNameField.click();
            loginPageObj.CarrierNameField.sendKeys("Test company");

            loginPageObj.CarrierAccountNameField.click();
            loginPageObj.CarrierAccountNameField.sendKeys("Test company");
            Thread.sleep(1000 * 2);
            loginPageObj.inputBTN.click();
            Thread.sleep(1000 * 2);
            loginPageObj.inputBTN.sendKeys("713");
            loginPageObj.inputPortBTN.click();
            Thread.sleep(1000 * 2);
            WebElement portType = loginPageObj.inputPortBTN;
            Select portTypechoose = new Select(portType);
            portTypechoose.selectByIndex(0);
            Thread.sleep(1000 * 2);
            loginPageObj.dateField.clear();
            Thread.sleep(1000 * 2);
            loginPageObj.dateField.sendKeys("06/17/2024");
            Thread.sleep(1000 * 2);
            loginPageObj.nameField.click();
            loginPageObj.nameField.sendKeys("Maple leaf Enterprises LLC");
            Thread.sleep(1000 * 2);
            loginPageObj.titleField.click();
            Thread.sleep(1000 * 2);
            loginPageObj.titleField.sendKeys("Business");
            Thread.sleep(1000 * 2);
            loginPageObj.createField.click();
            Thread.sleep(1000 * 10);

        }else {
            //C:\Users\faxes\2page.pdf

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Scroll down the page to ensure the element is in view
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", loginPageObj.portSecondPageScroll);
            // Wait for the input field to be present and visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement inputField = wait.until(ExpectedConditions.visibilityOf(loginPageObj.LetterOfAgencyBTN2));


            // Click the element using JavaScript
            js.executeScript("arguments[0].scrollIntoView(true);", inputField);
//            js.executeScript("arguments[0].click();", inputField);

            // Use the Robot class to handle the file upload
            Thread.sleep(3000); // Ensure the file dialog is open before performing actions
            File pagesSize1 = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
//            Robot rb1 = new Robot();
//            rb1.delay(2000);

            // Put the path to the file in clipboard
            StringSelection Filepath = new StringSelection(pagesSize1.getAbsolutePath());
            System.out.println("File Name: " + pagesSize1.getAbsolutePath());
            WebElement ele1 = driver.findElement(By.id("carrierFormFile"));
            ele1.sendKeys(pagesSize1.getAbsolutePath());
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath, null);
//
//            rb1.delay(2000);
//
//            // Press Enter to focus the file dialog
//            rb1.keyPress(KeyEvent.VK_ENTER);
//            rb1.keyRelease(KeyEvent.VK_ENTER);
//            rb1.delay(1000);
//
//            // Paste the file path
//            rb1.keyPress(KeyEvent.VK_CONTROL);
//            rb1.keyPress(KeyEvent.VK_V);
//            rb1.delay(1000);
//            rb1.keyRelease(KeyEvent.VK_CONTROL);
//            rb1.keyRelease(KeyEvent.VK_V);
//            rb1.delay(300);
//
//            // Press Enter to confirm the file selection
//            rb1.keyPress(KeyEvent.VK_ENTER);
//            rb1.keyRelease(KeyEvent.VK_ENTER);
//            rb1.delay(5000);
            // Scroll down the page to ensure the element is in view
            Thread.sleep(2000);
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[0].scrollIntoView(true);", loginPageObj.portSecondPageScroll);
            // Wait for the input field to be present and visible
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement inputField2 = wait2.until(ExpectedConditions.visibilityOf(loginPageObj.MostRecentPhoneBill));

            // Click the element using JavaScript
//            js2.executeScript("arguments[0].click();", inputField2);

            File pagesSize2 = FileReader.getFileUsingPageSize(data.get("pageSize2"), data.get("fileType2"));
//            Robot rb2 = new Robot();
//            rb2.delay(1000 * 2);
            //put the path to file in clipboard
            StringSelection Filepath2 = new StringSelection(pagesSize2.toString());
            System.out.println("File Name: " + pagesSize2.toString());
            WebElement ele2 = driver.findElement(By.id("phoneBill"));
            ele2.sendKeys(pagesSize2.getAbsolutePath());
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath2, null);
//            Thread.sleep(1000 * 3);
//            rb2.keyPress(KeyEvent.VK_ENTER);
//            rb2.keyRelease(KeyEvent.VK_ENTER);
//            rb2.delay(1000);
//            rb2.keyPress(KeyEvent.VK_CONTROL);
//            rb2.keyPress(KeyEvent.VK_V);
//            rb2.delay(1000);
//            rb2.keyRelease(KeyEvent.VK_CONTROL);
//            rb2.keyRelease(KeyEvent.VK_V);
//            rb2.delay(300);
//            rb2.keyPress(KeyEvent.VK_ENTER);
//            rb2.keyRelease(KeyEvent.VK_ENTER);
//            rb2.delay(1000 * 5);
            Thread.sleep(2000);
            loginPageObj.submit.click();
            Thread.sleep(1000*5);
            loginPageObj.submitConfirmBTN.click();
            Thread.sleep(1000*25);
            //Wait for the modal to be visible
            WebDriverWait waitCancelBTn = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement CancelBTN = waitCancelBTn.until(ExpectedConditions.visibilityOf(loginPageObj.anotherRequestConfirmBTN));

            // Click the element using JavaScript
            js.executeScript("arguments[0].click();", CancelBTN);
            Thread.sleep(1000 * 5);

            loginPageObj.clickingSecondPage.click();
            Thread.sleep(1000 * 5);
            loginPageObj.findLastRowintheTabledPage.click();
            Thread.sleep(1000 * 5);
            WebDriverWait waitConfirmBTn = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement ConfirBTN = waitCancelBTn.until(ExpectedConditions.visibilityOf(loginPageObj.InfoButtonOfFaxNumberTabel));
            // Click the element using JavaScript
            js.executeScript("arguments[0].click();", ConfirBTN);
//          loginPageObj.InfoButtonOfFaxNumberTabel.click();
            Thread.sleep(1000*5);
//            loginPageObj.closeBTNofInfoBtn.click();

            WebDriverWait waitCloseBTn = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement CloseInfoBTN = waitCloseBTn.until(ExpectedConditions.visibilityOf(loginPageObj.closeBTNofInfoBtn));

            // Click the element using JavaScript
            js.executeScript("arguments[0].click();", CloseInfoBTN);
            Thread.sleep(1000 * 5);
            String query = "SELECT id,status,realm,assigned_faxnumber FROM replixdb.faxnumber_requests order by id desc limit 1;";
            DataBaseUTIL.executeSQLQuery46Database(query);

            Thread.sleep(1000 * 10);
        }
    }
}