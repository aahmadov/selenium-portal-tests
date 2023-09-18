package Portal_LoginPages_and_StepsTestNG;

import Utilities.FileReader;
import UtilsTesNG.FileReaderTestNG;
import UtilsTesNG.LoginPageTestNG;
import UtilsTesNG.SetProperty;
import UtilsTesNG.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginTestStepsTestNG extends TestBase {
    WebDriver driver = SetProperty.getDriverTesTNG();
    LoginPageTestNG loginPageObj = new LoginPageTestNG();

   @Test(testName = "Send Fax from portal with valid credentials", groups = {"Regression1"})
    public void sendFaxDataFromPortal() throws InterruptedException, AWTException {
      // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test case name: " + testName);
        Map<String, String> data = FileReaderTestNG.getDataBasedOnTestCaseNameSelenium(testName);
        assert data != null;

       driver.get("http://10.250.1.100");
       Thread.sleep(1000*3);
       /*This operation will maximize window*/
       driver.manage().window().maximize();

       loginPageObj.UsernameTextBox.sendKeys(data.get("Username"));
       loginPageObj.PasswordTextBox.sendKeys(data.get("password"));
       Thread.sleep(1000*3);
       loginPageObj.loginButton.click();
       Thread.sleep(1000*3);
       //loginPageObj.confirmButton.click();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      loginPageObj.FaxingButton.click();
//       loginPageObj.ClickDropDown.click();
//       loginPageObj.ChooseOrgName.click();
//       loginPageObj.FaxingButton2.click();

       loginPageObj.sendFaxButton.click();
       loginPageObj.faxNumber.click();
       loginPageObj.faxNumber.sendKeys(String.valueOf(data.get("FaxNumber")));
       loginPageObj.coverPage.click();

       Thread.sleep(1000*10);
       loginPageObj.ChoseCoverpage.click();

       loginPageObj.uploadPage.click();

       File pagesSize = FileReader.getFileUsingPageSize(data.get("pageSize"),data.get("fileType"));
       Robot rb = new Robot();
       rb.delay(1000*2);
       //put the path to file in clipboard
       StringSelection Filepath = new StringSelection(pagesSize.toString());

       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath,null);
       rb.keyPress(KeyEvent.VK_CONTROL);
       rb.keyPress(KeyEvent.VK_V);
       rb.delay(1000*2);
       rb.keyRelease(KeyEvent.VK_CONTROL);
       rb.keyRelease(KeyEvent.VK_V);

       rb.keyPress(KeyEvent.VK_ENTER);
       rb.keyRelease(KeyEvent.VK_ENTER);
       rb.delay(1000*5);

       loginPageObj.ClickSendButton.click();
       loginPageObj.confirmationButton.click();
       SetProperty.closeDriverTestNG();
   }
}
