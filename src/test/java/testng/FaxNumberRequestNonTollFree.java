package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

public class FaxNumberRequestNonTollFree extends TestBase {


    @Test(priority = 1, testName = "Fax Number Request Non toll free from portal ", groups = {"Regression84"})
    public void New_Fax_Number_request_Non_toll_free() throws InterruptedException, AWTException, SQLException {
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

        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberfromManageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionDropdownButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOption.click();

//
//        // Locate the dropdown options using the page object method
//        List<WebElement> options = (List<WebElement>) loginPageObj.FaxNumberOption;
//
//        String newFaxNumber = "New fax Number";
//        String portFaxNumber = "Port Fax Number";
//
//        // Iterate through options and click the desired one
//        for (WebElement option : options) {
//            if (option.getText().equals(newFaxNumber)) {
//                option.click();
//                break;
//            }
//        }
        Thread.sleep(1000 * 10);
        loginPageObj.stateChose.click();
        WebElement stateChhoseDropBox =loginPageObj.stateChose;
        Select selectState = new Select(stateChhoseDropBox);
        selectState.selectByVisibleText("Texas");
        Thread.sleep(1000 * 3);
        loginPageObj.cityChoose.click();
       WebElement cityOption = loginPageObj.cityChoose;
       Select selectCity = new Select(cityOption);
       selectCity.selectByVisibleText("Houston");
        loginPageObj.cityChoose.click();
       Thread.sleep(1000*3);
        loginPageObj.RestrictToDepart.click();
        WebElement restrictToDepart =  loginPageObj.RestrictToDepart;
        Select selectDepart = new Select(restrictToDepart);
        selectDepart.selectByVisibleText("Global (all Departments)");
        loginPageObj.RestrictToDepart.click();
        Thread.sleep(1000 * 3);
        // Use WebDriverWait to wait until the dropdown options are visible
//        loginPageObj.assignToUserBTn.click();
//        WebElement userToassign = loginPageObj.assignToUserBTn;
//        Select selectUser = new Select(userToassign);
//        selectUser.selectByVisibleText("Unassigned");
//        loginPageObj.assignToUserBTn.click();
//        Thread.sleep(1000 * 3);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 500)");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.notifyEmail));
        emailField3.click();
        loginPageObj.notifyEmail.clear();
        Thread.sleep(1000*2);
        loginPageObj.notifyEmail.sendKeys("abbas@softlinx.com");
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.click();
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.sendKeys("Hello World!");
        Thread.sleep(1000*3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(100, 500)");
        loginPageObj.submitBtn.click();
        Thread.sleep(1000*5);
        loginPageObj.submitConfirmBTN.click();
        Thread.sleep(1000*25);
        loginPageObj.anotherRequestConfirmBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.InfoButtonOfFaxNumberTabel.click();
        Thread.sleep(1000*5);
        loginPageObj.closeBTNofInfoBtn.click();

    }
    @Test(priority = 1, testName = "Fax Number Request Non toll free from portal ", groups = {"Regression46"})
    public void New_Fax_Number_request_Non_toll_free46() throws InterruptedException, AWTException, SQLException {
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

        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberfromManageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionDropdownButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOption.click();

//
//        // Locate the dropdown options using the page object method
//        List<WebElement> options = (List<WebElement>) loginPageObj.FaxNumberOption;
//
//        String newFaxNumber = "New fax Number";
//        String portFaxNumber = "Port Fax Number";
//
//        // Iterate through options and click the desired one
//        for (WebElement option : options) {
//            if (option.getText().equals(newFaxNumber)) {
//                option.click();
//                break;
//            }
//        }
        Thread.sleep(1000 * 10);
        loginPageObj.stateChose.click();
        WebElement stateChhoseDropBox =loginPageObj.stateChose;
        Select selectState = new Select(stateChhoseDropBox);
        selectState.selectByVisibleText("Texas");
        Thread.sleep(1000 * 3);
        loginPageObj.cityChoose.click();
        WebElement cityOption = loginPageObj.cityChoose;
        Select selectCity = new Select(cityOption);
        selectCity.selectByVisibleText("Houston");
        loginPageObj.cityChoose.click();
        Thread.sleep(1000*3);
        loginPageObj.RestrictToDepart.click();
        WebElement restrictToDepart =  loginPageObj.RestrictToDepart;
        Select selectDepart = new Select(restrictToDepart);
        selectDepart.selectByVisibleText("Global (all Departments)");
        loginPageObj.RestrictToDepart.click();
        Thread.sleep(1000 * 3);
        // Use WebDriverWait to wait until the dropdown options are visible
//        loginPageObj.assignToUserBTn.click();
//        WebElement userToassign = loginPageObj.assignToUserBTn;
//        Select selectUser = new Select(userToassign);
//        selectUser.selectByVisibleText("Unassigned");
//        loginPageObj.assignToUserBTn.click();
//        Thread.sleep(1000 * 3);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 500)");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.notifyEmail));
        emailField3.click();
        loginPageObj.notifyEmail.clear();
        Thread.sleep(1000*2);
        loginPageObj.notifyEmail.sendKeys("abbas@softlinx.com");
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.click();
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.sendKeys("Hello World!");
        Thread.sleep(1000*3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(100, 500)");
        loginPageObj.submitBtn.click();
        Thread.sleep(1000*5);
        loginPageObj.submitConfirmBTN.click();
        Thread.sleep(1000*25);
        loginPageObj.anotherRequestConfirmBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.InfoButtonOfFaxNumberTabel.click();
        Thread.sleep(1000*5);
        loginPageObj.closeBTNofInfoBtn.click();

    }
    @Test(priority = 2, testName = "Fax Number request toll free ", groups = {"Regression84"})
    public void New_Fax_Number_request_toll_free() throws InterruptedException, AWTException, SQLException {
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
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberfromManageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionDropdownButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOption.click();
        Thread.sleep(1000*3);
        loginPageObj.tollFreeNumberBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.assignToUserbtn.click();
        Thread.sleep(1000*3);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 500)");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.notifyEmail));
        emailField3.click();
        loginPageObj.notifyEmail.clear();
        Thread.sleep(1000*2);
        loginPageObj.notifyEmail.sendKeys("abbas@softlinx.com");
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.click();
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.sendKeys("Hello World!");
        Thread.sleep(1000*3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(100, 500)");
        loginPageObj.submitBtn.click();
        Thread.sleep(1000*5);
        loginPageObj.submitConfirmBTN.click();
        Thread.sleep(1000*25);
        loginPageObj.anotherRequestConfirmBTN.click();
        Thread.sleep(1000*3);

        loginPageObj.InfoButtonOfFaxNumberTabel.click();
        Thread.sleep(1000*5);
        loginPageObj.closeBTNofInfoBtn.click();
    }
    @Test(priority = 2, testName = "Fax Number request toll free ", groups = {"Regression46"})
    public void New_Fax_Number_request_toll_free46() throws InterruptedException, AWTException, SQLException {
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
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberfromManageDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOptionDropdownButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.FaxNumberOption.click();
        Thread.sleep(1000*3);
        loginPageObj.tollFreeNumberBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.assignToUserbtn.click();
        Thread.sleep(1000*3);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js1.executeScript("window.scrollBy(100, 500)");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField3 = wait3.until(ExpectedConditions.visibilityOf(loginPageObj.notifyEmail));
        emailField3.click();
        loginPageObj.notifyEmail.clear();
        Thread.sleep(1000*2);
        loginPageObj.notifyEmail.sendKeys("abbas@softlinx.com");
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.click();
        Thread.sleep(1000*2);
        loginPageObj.commentfeild.sendKeys("Hello World!");
        Thread.sleep(1000*3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by pixel (e.g., 500 pixels)
        js.executeScript("window.scrollBy(100, 500)");
        loginPageObj.submitBtn.click();
        Thread.sleep(1000*5);
        loginPageObj.submitConfirmBTN.click();
        Thread.sleep(1000*25);
        loginPageObj.anotherRequestConfirmBTN.click();
        Thread.sleep(1000*3);

        loginPageObj.InfoButtonOfFaxNumberTabel.click();
        Thread.sleep(1000*5);
        loginPageObj.closeBTNofInfoBtn.click();
    }


}


