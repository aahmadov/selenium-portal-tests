package testng;

import Pages.WelcomeMail;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

public class Check_all_of_DeptAmin_departments extends TestBase {


    @Test(priority = 2, testName = "Portal needs to check all of DeptAmin's departments", groups = {"Regression84"})
    public void Portal_needs_to_check_all_of_DeptAmin_departments() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

        driver.get("https://regression.rpxqa.com/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.manageDropdown.click();
        Oj.departmentField.click();
        Oj.createDepartment.click();
        Oj.writeDepartment.click();
        Oj.writeDepartment.sendKeys(data.get("departmentName"));
        Thread.sleep(1000 * 2);
        Oj.deptSaveBTN.click();
        Thread.sleep(1000 * 2);
        Oj.departmentField.click();
        Oj.createDepartment.click();
        Oj.writeDepartment.click();
        Oj.writeDepartment.sendKeys(data.get("departmentName2"));
        Thread.sleep(1000 * 2);
        Oj.deptSaveBTN.click();
        Thread.sleep(1000 * 2);
        Oj.UserBTN.click();
        Oj.optionDropdownBTN.click();
        Oj.CreateUserBtn.click();
        //loginPageObj.CountryCode.click();
        Select CountryCode =new Select(Oj.CountryCode);
        CountryCode.selectByVisibleText("United States");
        Oj.userIDfeild.click();
        Oj.userIDfeild.sendKeys(data.get("UserID"));
        Oj.userNamefeild.click();
        Oj.userNamefeild.sendKeys(data.get("UserName"));
        Oj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userEmailfeild.click();
        Oj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Select selectDep = new Select(Oj.depSelectDropdown);
        selectDep.selectByVisibleText(data.get("departmentName"));
        Oj.SaveBTNfeild.click();
        Thread.sleep(1000 * 8);

        Oj.jsmith2EditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.userPermissionfeild.click();
        Oj.portalAdministrationBTN.click();
        Oj.allPermissionBTN.click();
        Oj.SaveBTNfeild.click();
        Thread.sleep(1000 * 8);

//        Oj.jsmith2EditBTN.click();
//        Oj.userPermissionfeild.click();
//        Thread.sleep(1000 * 3);
//        Oj.SaveBTNfeild.click();
//        Thread.sleep(1000 * 3);

        Oj.UserBTN.click();
        Oj.optionDropdownBTN.click();
        Thread.sleep(1000*3);
        Oj.CreateUserBtn.click();
        Select CountryCode2 =new Select(Oj.CountryCode);
        CountryCode2.selectByVisibleText("United States");
        Oj.userIDfeild.click();
        Oj.userIDfeild.sendKeys(data.get("UserID2"));
        Oj.userNamefeild.click();
        Oj.userNamefeild.sendKeys(data.get("UserName2"));
        Oj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userEmailfeild.click();
        Oj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Oj.faxNumberBTN.click();
        Thread.sleep(1000 * 2);
        Select selectNumber = new Select (Oj.selectNumber);
        selectNumber.selectByIndex(0);
        String selectedOption = selectNumber.getFirstSelectedOption().getText();
        System.out.println("Selected Option at Index 0: " + selectedOption);
        Oj.assignBtn.click();
        Thread.sleep(1000 * 2);
        Select selectDep2 = new Select(Oj.depSelectDropdown);
        selectDep2.selectByVisibleText(data.get("departmentName2"));
        Oj.SaveBTNfeild.click();
        Thread.sleep(1000 * 8);
        Oj.faxAdminDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        driver.get("https://regression.rpxqa.com/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();

        Oj.UsernameTextBox.sendKeys(data.get("Username2"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.UserBTN.click();
        Oj.jdoe3EditBTN.click();
        Thread.sleep(1000*3);
        //Assert.assertEquals("Expected number is on the row:"+selectedOption,"13433434347 (Assigned)");
        Oj.SaveBTNfeild.click();

        Thread.sleep(1000 * 5);
        Oj.jsmith2Dropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        Thread.sleep(1000 * 2);
        driver.get("https://regression.rpxqa.com/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.manageDropdown.click();
        Oj.UserBTN.click();
        Oj.deleteafterCreatejdoe3.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
        Oj.deleteafterCreatejsmith2.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
        Oj.departmentField.click();
        Thread.sleep(1000 * 2);
        Oj.deleteafterCreateIT2.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
        Oj.deleteafterCreateACCT3.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 4);
}


    @Test(priority = 2, testName = "Portal needs to check all of DeptAmin's departments", groups = {"Regression46"})
    public void Portal_needs_to_check_all_of_DeptAmin_departments46() throws InterruptedException, AWTException, SQLException {
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;

        driver.get("http://10.250.1.46:8585/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        WelcomeMail Oj = new WelcomeMail(driver);
        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.manageDropdown.click();
        Oj.departmentField.click();
        Oj.createDepartment.click();
        Oj.writeDepartment.click();
        Oj.writeDepartment.sendKeys(data.get("departmentName"));
        Thread.sleep(1000 * 2);
        Oj.deptSaveBTN.click();
        Oj.createDepartment.click();
        Thread.sleep(1000 * 2);
        Oj.writeDepartment.click();
        Oj.writeDepartment.sendKeys(data.get("departmentName2"));
        Thread.sleep(1000 * 2);
        Oj.deptSaveBTN.click();
        Thread.sleep(1000 * 2);
        Oj.UserBTN.click();
        Oj.optionDropdownBTN.click();
        Oj.CreateUserBtn.click();
        //loginPageObj.CountryCode.click();
        Select CountryCode =new Select(Oj.CountryCode);
        CountryCode.selectByVisibleText("United States");
        Oj.userIDfeild.click();
        Oj.userIDfeild.sendKeys(data.get("UserID"));
        Oj.userNamefeild.click();
        Oj.userNamefeild.sendKeys(data.get("UserName"));
        Oj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userEmailfeild.click();
        Oj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Select selectDep = new Select(Oj.depSelectDropdown);
        selectDep.selectByVisibleText(data.get("departmentName"));
        Oj.SaveBTNfeild.click();
        Thread.sleep(1000 * 8);

        Oj.jsmith2EditBTN.click();
        Thread.sleep(1000 * 2);
        Oj.userPermissionfeild.click();
        Oj.portalAdministrationBTN.click();
        Oj.allPermissionBTN.click();
        Oj.SaveBTNfeild.click();
        Thread.sleep(1000 * 8);

//        Oj.jsmith2EditBTN.click();
//        Oj.userPermissionfeild.click();
//        Thread.sleep(1000 * 3);
//        Oj.SaveBTNfeild.click();
//        Thread.sleep(1000 * 3);

        Oj.UserBTN.click();
        Oj.optionDropdownBTN.click();
        Thread.sleep(1000*3);
        Oj.CreateUserBtn.click();
        Select CountryCode2 =new Select(Oj.CountryCode);
        CountryCode2.selectByVisibleText("United States");
        Oj.userIDfeild.click();
        Oj.userIDfeild.sendKeys(data.get("UserID2"));
        Oj.userNamefeild.click();
        Oj.userNamefeild.sendKeys(data.get("UserName2"));
        Oj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Oj.userEmailfeild.click();
        Oj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Oj.faxNumberBTN.click();
        Thread.sleep(1000 * 2);
        Select selectNumber = new Select (Oj.selectNumber);
        selectNumber.selectByIndex(0);
        String selectedOption = selectNumber.getFirstSelectedOption().getText();
        System.out.println("Selected Option at Index 0: " + selectedOption);
        Oj.assignBtn.click();
        Thread.sleep(1000 * 2);
        Select selectDep2 = new Select(Oj.depSelectDropdown);
        selectDep2.selectByVisibleText(data.get("departmentName2"));
        Oj.SaveBTNfeild.click();
        Thread.sleep(1000 * 8);
        Oj.faxAdminDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        driver.get("http://10.250.1.46:8585/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();

        Oj.UsernameTextBox.sendKeys(data.get("Username2"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.manageDropdown.click();
        Thread.sleep(1000 * 3);
        Oj.UserBTN.click();
        Oj.jdoe3EditBTN.click();
        Thread.sleep(1000*3);
        //Assert.assertEquals("Expected number is on the row:"+selectedOption,"13433434347 (Assigned)");
        Oj.SaveBTNfeild.click();

        Thread.sleep(1000 * 5);
        Oj.jsmith2Dropdown.click();
        Thread.sleep(1000 * 3);
        Oj.Logout.click();
        Thread.sleep(1000 * 2);
        driver.get("http://10.250.1.46:8585/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        Oj.UsernameTextBox.sendKeys(data.get("Username"));
        Oj.PasswordTextBox.sendKeys(data.get("password"));
        Oj.loginButton.click();
        Oj.AdministrationHeading.click();
        Oj.manageDropdown.click();
        Oj.UserBTN.click();
        Oj.deleteafterCreatejdoe3.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
        Oj.deleteafterCreatejsmith2.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
        Oj.departmentField.click();
        Thread.sleep(1000 * 2);
        Oj.deleteafterCreateIT2.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 2);
        Oj.deleteafterCreateACCT3.click();
        Oj.deleteconfirmBTN.click();
        Thread.sleep(1000 * 4);
    }
}