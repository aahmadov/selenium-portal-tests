package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReader;
import UtilsTesNG.FileReaderTestNG;
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
import java.time.Duration;
import java.util.Map;

public class FaxSentWithandwithoutCoverpage extends TestBase {

    @Test(priority = 1,testName = "Send Fax from portal with valid credentials", groups = {"Regression84"})
    public void FaxSentandRecvVerification() throws InterruptedException, AWTException {
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
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));

            File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        // Wait until the form is visible
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropzone = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));

        // Path to your file
        File fileToUpload = new File(pagesSize.getAbsolutePath());

        // Execute JavaScript to add the file to Dropzone
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                "dropzone.emit('addedfile', mockFile);" +
                "dropzone.emit('complete', mockFile);");
//        Thread.sleep(1000 * 4);
//            loginPageObj.ClickSendButton.click();
//            Thread.sleep(1000 * 2);
//            loginPageObj.confirmationButton.click();
//            Thread.sleep(1000 * 10);
}

    @Test(priority = 1,testName = "Send Fax from portal with valid credentials", groups = {"Regression46"})
    public void FaxSentandRecvVerification46() throws InterruptedException, AWTException {
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
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));

        File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
        // Wait until the form is visible
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropzone = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));

        // Path to your file
        File fileToUpload = new File(pagesSize.getAbsolutePath());

        // Execute JavaScript to add the file to Dropzone
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                "dropzone.emit('addedfile', mockFile);" +
                "dropzone.emit('complete', mockFile);");
//        Thread.sleep(1000 * 4);
//            loginPageObj.ClickSendButton.click();
//            Thread.sleep(1000 * 2);
//            loginPageObj.confirmationButton.click();
//            Thread.sleep(1000 * 10);
    }

    @Test(priority = 2,testName = "Send Fax from portal with coverPage ", groups = {"Regression84"})
    public void FaxSentandRecvVerificationWithCoverPage() throws InterruptedException, AWTException {
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        loginPageObj.FaxingButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 2);
        WebElement coverPageOption = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
        Select CoverPageOption = new Select(coverPageOption);
        CoverPageOption.selectByIndex(2);

        Thread.sleep(1000 * 2);
        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.confirmationButton.click();

    }
    @Test(priority = 2,testName = "Send Fax from portal with coverPage ", groups = {"Regression46"})
    public void FaxSentandRecvVerificationWithCoverPage46() throws InterruptedException, AWTException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        loginPageObj.FaxingButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 2);
        WebElement coverPageOption = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
        Select CoverPageOption = new Select(coverPageOption);
        CoverPageOption.selectByIndex(2);

        Thread.sleep(1000 * 2);
        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.confirmationButton.click();

    }
    @Test(priority = 3,testName = "Send Fax from portal withNo coverPage ", groups = {"Regression84"})
    public void FaxSentandRecvWithandwithoutCoverPage() throws InterruptedException, AWTException {
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
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 3);
        boolean coverPageAttach = Boolean.parseBoolean(data.get("CoverPage"));
        boolean withAttachment = Boolean.parseBoolean(data.get("attachment"));

        if (coverPageAttach && withAttachment) {
            // If both are true, handle both cover page and attachment
            Thread.sleep(1000*3);
//            loginPageObj.coverPage.click();
            WebElement coverPageOption = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
            Select CoverPageOption = new Select(coverPageOption);
            CoverPageOption.selectByIndex(2);
            File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
            // Wait until the form is visible
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement dropzone = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));
            // Path to your file
            File fileToUpload = new File(pagesSize.getAbsolutePath());
            // Execute JavaScript to add the file to Dropzone
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                    "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                    "dropzone.emit('addedfile', mockFile);" +
                    "dropzone.emit('complete', mockFile);");

            loginPageObj.ClickSendButton.click();
            Thread.sleep(1000*3);
            loginPageObj.confirmationButton.click();
        } else if (coverPageAttach) {
            // If only coverPageAttach is true, handle cover page
            WebElement coverPageOption = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
            Select CoverPageOption = new Select(coverPageOption);
            CoverPageOption.selectByIndex(2);
//            loginPageObj.coverPage.click();
//            Thread.sleep(1000*3);
//            loginPageObj.ChoseCoverpage.click();
//            Thread.sleep(1000*3);
            loginPageObj.ClickSendButton.click();
            Thread.sleep(1000*3);
            loginPageObj.confirmationButton.click();
        } else if (withAttachment) {
            // If only withAttachment is true, handle attachment

            File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
            // Wait until the form is visible
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement dropzone = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));

            // Path to your file
            File fileToUpload = new File(pagesSize.getAbsolutePath());

            // Execute JavaScript to add the file to Dropzone
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                    "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                    "dropzone.emit('addedfile', mockFile);" +
                    "dropzone.emit('complete', mockFile);");
        } else {
            // If both are false, no action specified in JSON data
            System.out.println("message :No action specified in JSON data.");
        }
    }
    @Test(priority = 3,testName = "Send Fax from portal withNo coverPage ", groups = {"Regression46"})
    public void FaxSentandRecvWithandwithoutCoverPage46() throws InterruptedException, AWTException {
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
        loginPageObj.FaxingButton.click();
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000 * 2);
        loginPageObj.faxNumber.click();
        loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
        Thread.sleep(1000 * 3);
        boolean coverPageAttach = Boolean.parseBoolean(data.get("CoverPage"));
        boolean withAttachment = Boolean.parseBoolean(data.get("attachment"));

        if (coverPageAttach && withAttachment) {
            // If both are true, handle both cover page and attachment
            Thread.sleep(1000*3);
//            loginPageObj.coverPage.click();
            WebElement coverPageOption = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
            Select CoverPageOption = new Select(coverPageOption);
            CoverPageOption.selectByIndex(2);
            File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
            // Wait until the form is visible
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement dropzone = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));
            // Path to your file
            File fileToUpload = new File(pagesSize.getAbsolutePath());
            // Execute JavaScript to add the file to Dropzone
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                    "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                    "dropzone.emit('addedfile', mockFile);" +
                    "dropzone.emit('complete', mockFile);");

            loginPageObj.ClickSendButton.click();
            Thread.sleep(1000*3);
            loginPageObj.confirmationButton.click();
        } else if (coverPageAttach) {
            // If only coverPageAttach is true, handle cover page
            WebElement coverPageOption = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
            Select CoverPageOption = new Select(coverPageOption);
            CoverPageOption.selectByIndex(2);
//            loginPageObj.coverPage.click();
//            Thread.sleep(1000*3);
//            loginPageObj.ChoseCoverpage.click();
//            Thread.sleep(1000*3);
            loginPageObj.ClickSendButton.click();
            Thread.sleep(1000*3);
            loginPageObj.confirmationButton.click();
        } else if (withAttachment) {
            // If only withAttachment is true, handle attachment

            File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"), data.get("fileType"));
            // Wait until the form is visible
            WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement dropzone = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='dropzone']")));

            // Path to your file
            File fileToUpload = new File(pagesSize.getAbsolutePath());

            // Execute JavaScript to add the file to Dropzone
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("var dropzone = Dropzone.forElement('#dropzone');" +
                    "var mockFile = { name: '" + fileToUpload.getName() + "', size: " + fileToUpload.length() + " };" +
                    "dropzone.emit('addedfile', mockFile);" +
                    "dropzone.emit('complete', mockFile);");
        } else {
            // If both are false, no action specified in JSON data
            System.out.println("message :No action specified in JSON data.");
        }
    }
}