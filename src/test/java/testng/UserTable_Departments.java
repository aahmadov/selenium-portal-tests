package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Map;

public class UserTable_Departments extends TestBase {


    @Test(priority = 1, testName = "Create user and assign user to department", groups = {"Regression84"})
    public void DepartmentAdminUserTable() throws InterruptedException {

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
        loginPageObj.AdministrationHeading.click();
        loginPageObj.manageDropdown.click();
        loginPageObj.UserBTN.click();
        loginPageObj.optionDropdownBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.CreateUserBtn.click();

        Thread.sleep(1000 * 3);
        //loginPageObj.CountryCode.click();
        Select Countrycode = new Select(loginPageObj.CountryCode);
        Countrycode.selectByVisibleText("United States");

        loginPageObj.userIDfeild.click();
        loginPageObj.userIDfeild.sendKeys(data.get("UserID"));
        Thread.sleep(1000 * 3);
        loginPageObj.userNamefeild.click();
        loginPageObj.userNamefeild.sendKeys(data.get("UserName"));
        Thread.sleep(1000 * 2);
        loginPageObj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Thread.sleep(1000 * 2);
        loginPageObj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Thread.sleep(1000 * 2);
        loginPageObj.userEmailfeild.click();
        loginPageObj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Thread.sleep(1000 * 2);
        loginPageObj.department.click();
        Select selectDepartment = new Select(loginPageObj.department);
        selectDepartment.selectByVisibleText(data.get("department"));
        Thread.sleep(1000 * 3);
        loginPageObj.SavebtnafterCreateUser.click();
        Thread.sleep(1000 * 5);
        loginPageObj.infoBTNUser.click();
        Thread.sleep(1000 * 5);
        loginPageObj.permisionBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.departmentAdminBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.APIPermissionRadioBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.SavebtnafterCreateUser.click();
        Thread.sleep(1000 * 5);
        loginPageObj.faxAdminDropdown.click();
        Thread.sleep(1000 * 3);
        loginPageObj.logoutBTN.click();
        Thread.sleep(1000 * 3);
        driver.get("http://10.250.1.84:80/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        loginPageObj.UsernameTextBox.sendKeys(data.get("NewUsername"));
        Thread.sleep(1000 * 3);
        loginPageObj.PasswordTextBox.sendKeys(data.get("Newpassword"));
        Thread.sleep(1000 * 2);
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 5);
        loginPageObj.selectDepartmentfrom2Page.click();
        Thread.sleep(1000 * 3);
        loginPageObj.user2ndPage.click();
        Thread.sleep(1000 * 5);
        loginPageObj.Baku52Dropdown.click();
        Thread.sleep(1000 * 5);
        loginPageObj.logoutBTN2ndpage.click();
        Thread.sleep(1000 * 3);
        driver.get("http://10.250.1.84:80/");
        Thread.sleep(1000 * 3);
        driver.manage().window().maximize();
        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        loginPageObj.AdministrationHeading.click();
        loginPageObj.manageDropdown.click();
        loginPageObj.UserBTN.click();
        loginPageObj.deleteUserBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.confirmButton.click();
        Thread.sleep(1000 * 5);
    }
}