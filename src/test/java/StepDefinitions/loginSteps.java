package StepDefinitions;


import Pages.LoginPage;
import Utilities.DriverSetProperty;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.log.LoggingOptions;


public class loginSteps {

WebDriver driver = DriverSetProperty.getDriver();
LoginPage loginPageObj = new LoginPage();

    @Given("I navigate to portal Login page")
    public void i_navigate_to_portal_login_page() throws InterruptedException {
        driver .get("http://10.250.1.100");
        Thread.sleep(1000*3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
    }

    @When("i enter valid {string} username")
    public void i_enter_valid_username(String username) {
        loginPageObj.UsernameTextBox.sendKeys(username);
    }
    @Then("i enter valid {string} password")
    public void i_enter_valid_password(String password) {
        loginPageObj.PasswordTextBox.sendKeys(password);
    }


    @Then("i click to Login button")
    public void i_click_to_login_button() throws InterruptedException {
        loginPageObj.loginButton.click();
        Thread.sleep(1000*3);
    }
    @Then("login should be successfully land on Portal homepage")
    public void login_should_be_successfully_land_on_portal_homepage() throws InterruptedException {
        loginPageObj.confirmButton.click();
        Thread.sleep(1000*3);
    }
    @Then("I should able successfully send Fax with cover page")
    public void i_should_able_successfully_send_fax_with_cover_page() throws InterruptedException {
        Thread.sleep(1000*3);
        loginPageObj.FaxingButton.click();
        Thread.sleep(1000*3);
        loginPageObj.ClickDropDown.click();
        Thread.sleep(1000*3);
        loginPageObj.ChooseOrgName.click();
        Thread.sleep(1000*10);
        loginPageObj.FaxingButton2.click();
        Thread.sleep(1000*3);
        loginPageObj.sendFaxButton.click();
        Thread.sleep(1000*3);
        loginPageObj.faxNumber.sendKeys(String.valueOf(2222222222l));
        Thread.sleep(1000*3);
        loginPageObj.coverPage.click();
        Thread.sleep(1000*3);
        loginPageObj.selectCoverPage.click();
        Thread.sleep(1000*3);
        loginPageObj.ClickSendButton.click();
        Thread.sleep(1000*3);
        loginPageObj.confirmationButton.click();

    }





    @When("i enter invalid {string} username")
    public void i_enter_invalid_username(String InvalidUsername) {
      loginPageObj.UsernameTextBox.sendKeys(InvalidUsername);
    }
    @Then("i enter invalid {string} password")
    public void i_enter_invalid_password(String InvalidPassword) {
        loginPageObj.PasswordTextBox.sendKeys(InvalidPassword);
    }
    @Then("I should verify {string} error message")
    public void i_should_verify_error_message(String ErrorMessage) {
       String actualErrorMessage=loginPageObj.ErrorMessage.getText();
       String expectedErrorMessage= ErrorMessage;

       Assert.assertEquals("there is not a error message",expectedErrorMessage,actualErrorMessage);


    }

    @When("user enter {string} username and {string} password")
    public void userEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        loginPageObj.UsernameTextBox.sendKeys(username);
        Thread.sleep(1000*3);
        loginPageObj.PasswordTextBox.sendKeys(password);

    }

    @Given("^Given I navigate to portal Login page$")
    public void givenINavigateToPortalLoginPage() throws InterruptedException {
        driver .get("http://10.250.1.100");
        Thread.sleep(1000*3);
        /*This operation will maximize window*/
        driver.manage().window().maximize();
    }
}
