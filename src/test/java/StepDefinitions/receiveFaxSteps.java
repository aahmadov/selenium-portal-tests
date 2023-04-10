package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverSetProperty;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class receiveFaxSteps {

    WebDriver driver = DriverSetProperty.getDriver();
    HomePage homepageObj = new HomePage();


    @Given("validation of Status fax")
    public void validation_of_inbound_fax() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homepageObj.FaxeButton.click();
        //Thread.sleep(1000*3);
        homepageObj.OutboundButton.click();
        //Thread.sleep(1000*3);
        homepageObj.SearchButton.click();
        //Thread.sleep(1000*6);
        homepageObj.SearchButton.click();
        //Thread.sleep(1000*10);
        homepageObj.InfoButton.click();

        driver.quit();
    }


}
