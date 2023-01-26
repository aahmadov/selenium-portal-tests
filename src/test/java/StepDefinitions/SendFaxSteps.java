package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverSetProperty;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SendFaxSteps {

    WebDriver driver = DriverSetProperty.getDriver();

    HomePage homepageObj = new HomePage();


    @Then("landing the HomePage")
    public void landing_the_home_page() throws InterruptedException {
        String print = homepageObj.DropDownHomepage.getText();
        System.out.println(":Verification of HomePage -this is the "+"* "+print+" *");

        Thread.sleep(1000*5);
         homepageObj.DropDownHomepage.click();
        Thread.sleep(1000*3);

    }
    @Then("i add {string},coverPage and {string} to send fax")
    public void i_add_and_to_send_fax(String faxNumber, String attachments) throws InterruptedException, AWTException {
        homepageObj.FaxNumber.click();
        Thread.sleep(1000*2);
        homepageObj.FaxNumber.sendKeys(faxNumber);
        Thread.sleep(1000*3);
        homepageObj.CoverPage.click();
        Thread.sleep(1000*3);
        homepageObj.ChoseCoverpage.click();
        Thread.sleep(1000*3);
        homepageObj.uploadPage.click();
        Thread.sleep(1000*2);

        Robot rb = new Robot();
        rb.delay(1000*2);
        //put the path to file in clipboard
        StringSelection Filepath =new StringSelection(attachments);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath,null);


        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(1000*2);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(1000*2);

        homepageObj.sendButton.click();
        Thread.sleep(1000*3);
        homepageObj.confirmationOKafterSend.click();
    }


}
