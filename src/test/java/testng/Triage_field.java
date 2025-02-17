package testng;

import Pages.WelcomeMail;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class Triage_field extends TestBase {


    @Test(priority = 2, testName = "Can't add triage issue testing ", groups = {"Regression84"})
    public void Add_Triage_field() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("http://10.250.1.84:80/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Thread.sleep(1000);
        Oj.AdministrationHeading.click();
        Thread.sleep(1000);
        Oj.manageDropdown.click();
        Thread.sleep(1000);
        Oj.TriageDropdown.click();
        Thread.sleep(1000);;
        Oj.TriageField.click();
        Thread.sleep(1000);
        Oj.manageDropdown.click();
        Thread.sleep(1000);
        Oj.OptionField.click();
        Thread.sleep(1000);
        Oj.CreateField.click();
        Thread.sleep(1000);
//        Oj.NameField.click();
        Oj.NameField.clear();
        Oj.NameField.sendKeys(data.get("name"));
        Thread.sleep(1000);
//        Oj.LabelField.click();
        Oj.LabelField.clear();
        Oj.LabelField.sendKeys(data.get("label"));
        Thread.sleep(1000);
//        Oj.OCRName.click();
        Oj.OCRName.clear();
        Oj.OCRName.sendKeys("OCR");
        Thread.sleep(3000);

        Oj.DataType.click();
        Thread.sleep(1000);
        WebElement dataTypeElement = driver.findElement(By.xpath("//select[@class='custom-select' and @name='datatype' and @id='datatype']"));
        Select dataType = new Select(dataTypeElement);
        dataType.selectByIndex(0);
        Thread.sleep(1000);
        Oj.SaveBTN2.click();

        // Locate the scrollable div
        WebElement scrollableDiv = driver.findElement(By.cssSelector("div.dt-scroll-body"));

        // Use JavascriptExecutor to scroll
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll down by a specific amount (e.g., 500 pixels)
        jsExecutor.executeScript("arguments[0].scrollTop = arguments[1];", scrollableDiv, 500);

        // Optional: Wait for a moment to ensure scrolling is visible
        Thread.sleep(1000);

        // Scroll to the bottom of the div
        jsExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);


        Thread.sleep(3000);
        Oj.deleteAfterFieldCreated.click();
        Thread.sleep(2000);
        Oj.deleteAfterFieldCreatedConfirm.click();
        Thread.sleep(5000);
        // Locate the scrollable div
        WebElement scrollableDiv2 = driver.findElement(By.cssSelector("div.dt-scroll-body"));

        // Use JavascriptExecutor to scroll
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;

        // Scroll down by a specific amount (e.g., 500 pixels)
        jsExecutor.executeScript("arguments[0].scrollTop = arguments[1];", scrollableDiv, 500);

        // Optional: Wait for a moment to ensure scrolling is visible
        Thread.sleep(1000);

        // Scroll to the bottom of the div
        jsExecutor2.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);


    }

    @Test(priority = 2, testName = "Can't add triage issue testing ", groups = {"Regression46"})
    public void Add_Triage_field46() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;

        driver.get("http://10.250.1.46:8585/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("UserName"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Thread.sleep(1000);
        Oj.AdministrationHeading.click();
        Thread.sleep(1000);
        Oj.manageDropdown.click();
        Thread.sleep(1000);
        Oj.TriageDropdown.click();
        Thread.sleep(1000);;
        Oj.TriageField.click();
        Thread.sleep(1000);
        Oj.manageDropdown.click();
        Thread.sleep(1000);
        Oj.OptionField.click();
        Thread.sleep(1000);
        Oj.CreateField.click();
        Thread.sleep(1000);
//        Oj.NameField.click();
        Oj.NameField.clear();
        Oj.NameField.sendKeys(data.get("name"));
        Thread.sleep(1000);
//        Oj.LabelField.click();
        Oj.LabelField.clear();
        Oj.LabelField.sendKeys(data.get("label"));
        Thread.sleep(1000);
//        Oj.OCRName.click();
        Oj.OCRName.clear();
        Oj.OCRName.sendKeys("OCR");
        Thread.sleep(3000);

        Oj.DataType.click();
        Thread.sleep(1000);
        WebElement dataTypeElement = driver.findElement(By.xpath("//select[@class='custom-select' and @name='datatype' and @id='datatype']"));
        Select dataType = new Select(dataTypeElement);
        dataType.selectByIndex(0);
        Thread.sleep(1000);
        Oj.SaveBTN2.click();

        // Locate the scrollable div
        WebElement scrollableDiv = driver.findElement(By.cssSelector("div.dt-scroll-body"));

        // Use JavascriptExecutor to scroll
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll down by a specific amount (e.g., 500 pixels)
        jsExecutor.executeScript("arguments[0].scrollTop = arguments[1];", scrollableDiv, 500);

        // Optional: Wait for a moment to ensure scrolling is visible
        Thread.sleep(1000);

        // Scroll to the bottom of the div
        jsExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);


        Thread.sleep(3000);
        Oj.deleteAfterFieldCreated.click();
        Thread.sleep(2000);
        Oj.deleteAfterFieldCreatedConfirm.click();
        Thread.sleep(5000);
        // Locate the scrollable div
        WebElement scrollableDiv2 = driver.findElement(By.cssSelector("div.dt-scroll-body"));

        // Use JavascriptExecutor to scroll
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;

        // Scroll down by a specific amount (e.g., 500 pixels)
        jsExecutor.executeScript("arguments[0].scrollTop = arguments[1];", scrollableDiv, 500);

        // Optional: Wait for a moment to ensure scrolling is visible
        Thread.sleep(1000);

        // Scroll to the bottom of the div
        jsExecutor2.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableDiv);


    }
}