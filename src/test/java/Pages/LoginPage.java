package Pages;

import Utilities.DriverSetProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage (){
        driver = DriverSetProperty.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    public WebElement UsernameTextBox;
    @FindBy(name = "password")
    public WebElement PasswordTextBox;
    @FindBy(id = "LoginButton")
    public WebElement loginButton;
    @FindBy(xpath = "//button[@class='btn btn-orange btn-sm dialogBtn'][1]")
    public WebElement confirmButton;
    @FindBy(xpath = "//*[@id='faxing-heading']/h6")
    public WebElement FaxingButton;
    @FindBy(xpath = "//*[@id='top-org-menu-grp']/div/div[2]")
    public WebElement ClickDropDown;
    @FindBy(xpath = "//*[@id='top-org-menu-grp']/div/div[2]/div/div[2]/ul/li[4]/a")
    public WebElement ChooseOrgName;
    @FindBy(xpath = "//*[@id='faxing-heading']/h6")
    public WebElement FaxingButton2;
    @FindBy(xpath = "//*[@id='faxing']/div/ul/li[1]/a")
    public WebElement sendFaxButton;
    @FindBy(xpath = "//*[@name='fax_num']")
    public WebElement faxNumber;
    @FindBy(xpath = "//*[@id='coverpageTemplate']")
    public WebElement coverPage;
    @FindBy(xpath = "//*[@id='coverpageTemplate']/option[3]")
    public WebElement selectCoverPage;
    @FindBy(xpath = "//*[@id='send_fax_btn']")
    public WebElement ClickSendButton;
    @FindBy(xpath = "//*[@class='btn btn-orange btn-sm dialogBtn']")
    public WebElement confirmationButton;
    @FindBy(xpath = "//div[@id='login_message']")
    public WebElement ErrorMessage;

}
////div[@id='login_message']
//