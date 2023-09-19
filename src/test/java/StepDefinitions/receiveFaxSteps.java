package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverSetProperty;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class receiveFaxSteps {

    WebDriver driver = DriverSetProperty.getDriver();
    HomePage homepageObj = new HomePage();


    @Given("validation of Status fax")
    public void validation_of_inbound_fax() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        homepageObj.FaxeButton.click();
        homepageObj.OutboundButton.click();
        homepageObj.SearchButton.click();
        homepageObj.SearchButton.click();
        Thread.sleep(1000*30);
        homepageObj.SearchButton.click();
        Thread.sleep(1000*30);
        homepageObj.SearchButton.click();
        Thread.sleep(1000*3);
        homepageObj.Table.getText();
        Thread.sleep(1000*3);
        homepageObj.InfoButton.click();
        Thread.sleep(1000*3);
//        Actions actions = new Actions(driver);
//        WebElement status = driver.findElement(By.xpath("//*[@id='out_detail_status']"));
//        actions.moveToElement(status).click().build().perform();
//        Thread.sleep(1000*5);
        homepageObj.closeInfoPage.click();
        assertEquals("Sent",homepageObj.Table.getText());

        DriverSetProperty.closeDriver();

    }


}
