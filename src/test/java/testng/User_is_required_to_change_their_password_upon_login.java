package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class User_is_required_to_change_their_password_upon_login extends TestBase {


    @Test(priority =1,testName ="Forced change password page not accepting password change", groups = {"Regression84"})
    public void User_change_password_upon_login() throws InterruptedException {

        System.out.println("Test case name" + testName);
        Map<String,String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("http://10.250.1.84:80/");
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

        Select Countrycode =new Select(loginPageObj.CountryCode);
        Countrycode.selectByVisibleText("United States");

        loginPageObj.userIDfeild.click();
        loginPageObj.userIDfeild.sendKeys(data.get("UserID"));
        Thread.sleep(1000 * 2);
        loginPageObj.userNamefeild.click();
        loginPageObj.userNamefeild.sendKeys(data.get("UserName"));
        Thread.sleep(1000 * 2);
        loginPageObj.userPasswordfeild.sendKeys(String.valueOf(data.get("passwordField2")));
        Thread.sleep(1000 * 2);
        loginPageObj.userPasswordRetryfeild.sendKeys(String.valueOf(data.get("passwordField2")));

        Thread.sleep(1000 * 2);
        WebElement yesRadio = driver.findElement(By.xpath("//input[@id='UserMustChangePwdYes']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yesRadio).click().perform();

        Thread.sleep(1000 * 2);
        loginPageObj.userEmailfeild.click();
        loginPageObj.userEmailfeild.sendKeys(String.valueOf(data.get("EmailField")));
        Thread.sleep(1000 * 2);
        loginPageObj.SaveBTNfeild.click();
        Thread.sleep(1000 * 5);
        loginPageObj.LogoutFaxAdminBox.click();
        Thread.sleep(1000 * 2);
        loginPageObj.Logout2.click();
        driver.get("http://10.250.1.84:80/");
        /*This operation will maximize window*/
        driver.manage().window().maximize();
        loginPageObj.UsernameTextBox.sendKeys(data.get("Username2"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("passwordField2"));
        loginPageObj.loginButton.click();
        Thread.sleep(1000 * 3);

        WebElement CurrentPassword = driver.findElement(By.xpath("//input[@id='password']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(CurrentPassword).click().perform();

        Thread.sleep(1000 * 2);
        WebElement CurrentPassword2 = driver.findElement(By.xpath("//input[@id='password']"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(CurrentPassword2).click().sendKeys(data.get("passwordField2")).perform();


        Thread.sleep(1000 * 2);
        WebElement NewPassword4 = driver.findElement(By.xpath("//input[@id='passwordnew']"));
        Actions actions4 = new Actions(driver);
        actions4.moveToElement(NewPassword4).click().perform();
        Thread.sleep(1000 * 2);
        WebElement NewPassword3 = driver.findElement(By.xpath("//input[@id='passwordnew']"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(NewPassword3).click().sendKeys(data.get("NewPasswordField")).perform();

        Thread.sleep(1000 * 2);
        WebElement NewPasswordRetry = driver.findElement(By.xpath("//input[@id='passwordnew2']"));
        Actions actions5 = new Actions(driver);
        actions5.moveToElement(NewPasswordRetry).click().perform();
        Thread.sleep(1000 * 2);
        WebElement NewPasswordRetry2 = driver.findElement(By.xpath("//input[@id='passwordnew2']"));
        Actions actions6 = new Actions(driver);
        actions6.moveToElement(NewPasswordRetry2).click().sendKeys(data.get("NewPasswordField")).perform();

        Thread.sleep(1000 * 2);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@id='LoginButton']")
        ));
        submitBtn.click();
        Thread.sleep(1000 * 3);

        loginPageObj.UsernameTextBox.clear();
        loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
        loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
        loginPageObj.loginButton.click();
        loginPageObj.AdministrationHeading.click();
        loginPageObj.manageDropdown.click();
        loginPageObj.UserBTN.click();
        loginPageObj.optionDropdownBTN.click();
        Thread.sleep(1000 * 3);
        loginPageObj.deleteafterCreate.click();
        Thread.sleep(1000 * 3);
        loginPageObj.deleteconfirmBTN.click();

    }
}
