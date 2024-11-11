package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class CreateDepartment extends TestBase {

    @Test(priority = 1, testName = "Portal:Create Department ", groups = {"Regression84"})
    public void Create_Department() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("http://10.250.1.84:80/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);
        loginPageObj.AdministrationHeading.click();
        Thread.sleep(1000 * 3);
        loginPageObj.manageDropdown.click();
        Thread.sleep(1000 * 2);
        loginPageObj.departmentField.click();
        Thread.sleep(1000 * 2);
        loginPageObj.createDepartment.click();
        Thread.sleep(1000 * 2);
        loginPageObj.writeDepartment.click();
        Thread.sleep(1000 * 2);
        loginPageObj.writeDepartment.sendKeys(data.get("departmentName"));
        Thread.sleep(1000 * 2);
        loginPageObj.deptSaveBTN.click();
        Thread.sleep(1000 * 5);
        loginPageObj.deleteDepartmentAfterCreate.click();
        Thread.sleep(1000 * 2);
        loginPageObj.deleteDepartmentAfterCreateConfirmationBTN.click();
        Thread.sleep(1000 * 2);
    }
}
