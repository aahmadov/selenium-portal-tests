package testng;

import Pages.LoginPageTestNG;
import UtilsTesNG.FileReaderTestNG;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SFT_Push extends TestBase {

    @Test(priority = 1, testName = "Portal:SFTP push check", groups = {"Regression84"})
    public void SFTP_push_Server() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;
        driver.get("https://regression.rpxqa.com/");
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
        loginPageObj.settingsField.click();
        loginPageObj.SFTP.click();
        Thread.sleep(1000 * 2);
        loginPageObj.selectORG.click();
        Thread.sleep(1000 * 2);
        loginPageObj.selectAuto1.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SFTPtestlink2.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SFTPtestlink.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SFTPtestlinkConfimOk.click();
        loginPageObj.SaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SFTPtestlinkConfimOk.click();
        Thread.sleep(1000 * 2);
        loginPageObj.OptionTab.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SaveBTN.click();
        loginPageObj.SFTPtestlinkConfimOk.click();
        Thread.sleep(1000 * 2);
        loginPageObj.UsersTab.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
        /*
        First Select class
         */
        loginPageObj.AllUsersDropdown.click();
        Select select = new Select(loginPageObj.AllUsersDropdown);
        int AllElements = select.getAllSelectedOptions().size();
        // Select option by index
        for (int i = 0; i <AllElements; i++) {
            select.selectByIndex(i);
            // Print selected option text (Optional)
            String elements = select.getFirstSelectedOption().getText();
            System.out.println("Elements :"+elements);
            // Check if this is the last option
            if (i==AllElements-1){
            select.selectByIndex(1);
            System.out.println("Reset to first option: " + select.getFirstSelectedOption().getText());

            break;
            }
        }
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
         /*
        Second Select class
         */
        loginPageObj.Folderformat.click();
        Select selectFolderformatOption = new Select(loginPageObj.Folderformat);
        int ElementsOptions = selectFolderformatOption.getAllSelectedOptions().size();
        // Select option by index
        for (int i = 0; i <ElementsOptions; i++) {
            selectFolderformatOption.selectByIndex(i);
            // Print selected option text (Optional)
            String elements = selectFolderformatOption.getFirstSelectedOption().getText();
            System.out.println("Elements :"+elements);
            // Check if this is the last option
            if (i==ElementsOptions-1){
            selectFolderformatOption.selectByIndex(0);
            System.out.println("Reset to first option: " + selectFolderformatOption.getFirstSelectedOption().getText());

                break;
            }
        }
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*3);

        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.FoldertypeFeild.click();
        Thread.sleep(1000);
        loginPageObj.FoldertypeFeild.clear();
        loginPageObj.FoldertypeFeild.sendKeys("NewFolder");
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.FoldertypeFeild.clear();
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);
        loginPageObj.FieldplusBTN.click();
        loginPageObj.UsersRuleSaveBTN.click();

        /*
        Third Select class
         */
        Thread.sleep(1000*2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);

        loginPageObj.FileNameFormat.click();
        Select selectFolderformatOption2 = new Select(loginPageObj.FileNameFormat);
        int ElementsOptions2 = selectFolderformatOption2.getAllSelectedOptions().size();
        // Select option by index
        for (int i = 0; i <ElementsOptions2; i++) {
            selectFolderformatOption2.selectByIndex(i);
            // Print selected option text (Optional)
            String elements = selectFolderformatOption2.getFirstSelectedOption().getText();
            System.out.println("Elements :"+elements);
            // Check if this is the last option
            if (i==ElementsOptions2-1){
            selectFolderformatOption2.selectByIndex(0);
            System.out.println("Reset to first option: " + selectFolderformatOption2.getFirstSelectedOption().getText());

            break;
            }
        }
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);
        loginPageObj.FileNameFormatField.click();
        Thread.sleep(1000);
        loginPageObj.FileNameFormatField.clear();
        Thread.sleep(1000*2);

        Select FaxStatus = new Select (loginPageObj.FileNameFormat);
        FaxStatus.selectByVisibleText("Fax Status");
        loginPageObj.FileNameFormatplusBTN.click();
        Thread.sleep(1000);
        loginPageObj.UsersRuleSaveBTN.click();

        Thread.sleep(1000*2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);
        loginPageObj.FileNameFormatField.click();
        loginPageObj.FileNameFormatField.clear();
        Thread.sleep(1000*2);
        loginPageObj.FileNameFormat.click();
        Select FaxId = new Select (loginPageObj.FileNameFormat);
        FaxId.selectByVisibleText("Fax Id");
        loginPageObj.FileNameFormatplusBTN.click();
        Thread.sleep(1000);
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*4);
    }
    @Test(priority = 1, testName = "Portal:SFTP push check", groups = {"Regression46"})
    public void SFTP_push_Server46() throws InterruptedException, AWTException, SQLException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name" + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium46(testName);
        assert data != null;
        driver.get("http://10.250.1.46:8585/");
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
        loginPageObj.settingsField.click();
        loginPageObj.SFTP.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SFTPtestlink.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SFTPtestlinkConfimOk.click();
        Thread.sleep(1000 * 2);
        loginPageObj.OptionTab.click();
        Thread.sleep(1000 * 2);
        loginPageObj.SaveBTN.click();
        loginPageObj.SFTPtestlinkConfimOk.click();
        Thread.sleep(1000 * 2);
        loginPageObj.UsersTab.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
        /*
        First Select class
         */
        loginPageObj.AllUsersDropdown.click();
        Select select = new Select(loginPageObj.AllUsersDropdown);
        int AllElements = select.getAllSelectedOptions().size();
        // Select option by index
        for (int i = 0; i <AllElements; i++) {
            select.selectByIndex(i);
            // Print selected option text (Optional)
            String elements = select.getFirstSelectedOption().getText();
            System.out.println("Elements :"+elements);
            // Check if this is the last option
            if (i==AllElements-1){
                select.selectByIndex(1);
                System.out.println("Reset to first option: " + select.getFirstSelectedOption().getText());

                break;
            }
        }
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
         /*
        Second Select class
         */
        loginPageObj.Folderformat.click();
        Select selectFolderformatOption = new Select(loginPageObj.Folderformat);
        int ElementsOptions = selectFolderformatOption.getAllSelectedOptions().size();
        // Select option by index
        for (int i = 0; i <ElementsOptions; i++) {
            selectFolderformatOption.selectByIndex(i);
            // Print selected option text (Optional)
            String elements = selectFolderformatOption.getFirstSelectedOption().getText();
            System.out.println("Elements :"+elements);
            // Check if this is the last option
            if (i==ElementsOptions-1){
                selectFolderformatOption.selectByIndex(0);
                System.out.println("Reset to first option: " + selectFolderformatOption.getFirstSelectedOption().getText());

                break;
            }
        }
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*3);

        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.FoldertypeFeild.click();
        Thread.sleep(1000);
        loginPageObj.FoldertypeFeild.clear();
        loginPageObj.FoldertypeFeild.sendKeys("NewFolder");
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000 * 2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000 * 2);
        loginPageObj.FoldertypeFeild.clear();
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);
        loginPageObj.FieldplusBTN.click();
        loginPageObj.UsersRuleSaveBTN.click();

        /*
        Third Select class
         */
        Thread.sleep(1000*2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);

        loginPageObj.FileNameFormat.click();
        Select selectFolderformatOption2 = new Select(loginPageObj.FileNameFormat);
        int ElementsOptions2 = selectFolderformatOption2.getAllSelectedOptions().size();
        // Select option by index
        for (int i = 0; i <ElementsOptions2; i++) {
            selectFolderformatOption2.selectByIndex(i);
            // Print selected option text (Optional)
            String elements = selectFolderformatOption2.getFirstSelectedOption().getText();
            System.out.println("Elements :"+elements);
            // Check if this is the last option
            if (i==ElementsOptions2-1){
                selectFolderformatOption2.selectByIndex(0);
                System.out.println("Reset to first option: " + selectFolderformatOption2.getFirstSelectedOption().getText());

                break;
            }
        }
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*3);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);
        loginPageObj.FileNameFormatField.click();
        Thread.sleep(1000);
        loginPageObj.FileNameFormatField.clear();
        Thread.sleep(1000*2);

        Select FaxStatus = new Select (loginPageObj.FileNameFormat);
        FaxStatus.selectByVisibleText("Fax Status");
        loginPageObj.FileNameFormatplusBTN.click();
        Thread.sleep(1000);
        loginPageObj.UsersRuleSaveBTN.click();

        Thread.sleep(1000*2);
        loginPageObj.EditBtn.click();
        Thread.sleep(1000*2);
        loginPageObj.FileNameFormatField.click();
        loginPageObj.FileNameFormatField.clear();
        Thread.sleep(1000*2);
        loginPageObj.FileNameFormat.click();
        Select FaxId = new Select (loginPageObj.FileNameFormat);
        FaxId.selectByVisibleText("Fax Id");
        loginPageObj.FileNameFormatplusBTN.click();
        Thread.sleep(1000);
        loginPageObj.UsersRuleSaveBTN.click();
        Thread.sleep(1000*4);
    }
}