package testng;


import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.junit.rules.TestName;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Map;

public class Create_User extends TestBase {

 @Test(priority =1,testName ="Create user", groups = {"Regression84"})
 public void Create_User_portal() throws InterruptedException {

     System.out.println("Test case name" + testName);
     Map<String,String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
     assert data != null;
     driver.get("https://regression.rpxqa.com/");
     Thread.sleep(1000*3);
     driver.manage().window().maximize();
     LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

     loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
     loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
     loginPageObj.loginButton.click();
     loginPageObj.AdministrationHeading.click();
     loginPageObj.manageDropdown.click();
     loginPageObj.UserBTN.click();
     loginPageObj.optionDropdownBTN.click();
     Thread.sleep(1000*3);
     loginPageObj.CreateUserBtn.click();

     Thread.sleep(1000 * 3);
     //loginPageObj.CountryCode.click();
     Select Countrycode =new Select(loginPageObj.CountryCode);
     Countrycode.selectByVisibleText("United States");

     loginPageObj.userIDfeild.click();
     loginPageObj.userIDfeild.sendKeys(data.get("UserID"));
     Thread.sleep(1000 * 3);
     loginPageObj.userNamefeild.click();
     loginPageObj.userNamefeild.sendKeys(data.get("UserName"));
     Thread.sleep(1000 * 3);
     loginPageObj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
     Thread.sleep(1000 * 3);
     loginPageObj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
     Thread.sleep(1000 * 3);
     loginPageObj.userEmailfeild.click();
     loginPageObj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
     Thread.sleep(1000 * 3);
     loginPageObj.userPermissionfeild.click();
     Thread.sleep(1000 * 3);
     loginPageObj.SaveBTNfeild.click();
     Thread.sleep(1000 * 10);
     loginPageObj.deleteafterCreate.click();
     Thread.sleep(1000 * 3);
     loginPageObj.deleteconfirmBTN.click();
 }
    @Test(priority =1,testName ="Create user", groups = {"Regression46"})
    public void Create_User_portal46() throws InterruptedException {

        System.out.println("Test case name" + testName);
        Map<String,String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;
        driver.get("http://10.250.1.46:8585/");
        Thread.sleep(1000*3);
        driver.manage().window().maximize();
        LoginPageTestNG loginPageObj = new LoginPageTestNG(driver);

        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        loginPageObj.AdministrationHeading.click();
        loginPageObj.manageDropdown.click();
        loginPageObj.UserBTN.click();
        loginPageObj.optionDropdownBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.CreateUserBtn.click();

        Thread.sleep(1000 * 3);
        //loginPageObj.CountryCode.click();
        Select Countrycode =new Select(loginPageObj.CountryCode);
        Countrycode.selectByVisibleText("United States");

        loginPageObj.userIDfeild.click();
        loginPageObj.userIDfeild.sendKeys(data.get("UserID"));
        Thread.sleep(1000 * 3);
        loginPageObj.userNamefeild.click();
        loginPageObj.userNamefeild.sendKeys(data.get("UserName"));
        Thread.sleep(1000 * 3);
        loginPageObj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Thread.sleep(1000 * 3);
        loginPageObj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField")));
        Thread.sleep(1000 * 3);
        loginPageObj.userEmailfeild.click();
        loginPageObj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Thread.sleep(1000 * 3);
        loginPageObj.userPermissionfeild.click();
        Thread.sleep(1000 * 3);
        loginPageObj.SaveBTNfeild.click();
        Thread.sleep(1000 * 10);
        loginPageObj.deleteafterCreate.click();
        Thread.sleep(1000 * 3);
        loginPageObj.deleteconfirmBTN.click();
    }

}
