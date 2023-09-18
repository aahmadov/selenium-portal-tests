package UtilsTesNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTestNG {
    WebDriver driver;

    public LoginPageTestNG(){
        driver = SetProperty.getDriverTesTNG();
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
    @FindBy(xpath = "//*[@id='faxing-heading']")
    public WebElement FaxingButton;
    @FindBy(xpath = "//*[@id='faxing']/div/ul/li[1]/a")
    public WebElement sendFaxButton;
    @FindBy(xpath = "//*[@name='fax_num']")
    public WebElement faxNumber;
    @FindBy(xpath = "//*[@id='coverpageTemplate']")
    public WebElement coverPage;

    @FindBy(xpath = "//*[@id='coverpageTemplate']/option[2]")
    public WebElement ChoseCoverpage;
    @FindBy(xpath = "//*[@id='dropzone']/div/button")
    public WebElement uploadPage;

    @FindBy(xpath = "//*[@id='recipientcol']/div[6]")
    public WebElement splitCheckPagebox;


    @FindBy(xpath = "//*[@id='splitfaxID']")
    public WebElement claimNumber;

    @FindBy(xpath = "//*[@id='keyword']")
    public WebElement referenceKeywords;

    @FindBy(xpath = "//*[@id=\"realSendAfter\"]")
    public WebElement Send_After;

    @FindBy(xpath = "//*[@id=\"sendAfter\"]/div/div")
    public WebElement Send_AfterCalendar;


    @FindBy(xpath = "//*[@id='send_fax_btn']")
    public WebElement ClickSendButton;
    @FindBy(xpath = "/html/body/div[17]/div/div/div[3]/button")
    public WebElement confirmationButtonForError;


    @FindBy(xpath = "/html/body/div[16]/div/div/div[3]/button")
    public WebElement confirmationButton;

    @FindBy(xpath = "//*[@id='alertmessage']")
    public WebElement DateErrorMessage;

    @FindBy(xpath = "//*[@id=\"successmessage\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"administration-heading\"]/h6")
    public WebElement AdministrationHeading;

    @FindBy(xpath = "//*[@id=\"service-administration\"]/div/ul/li/a")
    public WebElement AdministrationfilterFaxstatus;

    @FindBy(xpath = "//*[@id=\"collapseFilter\"]/div[1]/div/div/div[1]/label")
    public WebElement OutboundRadiobox;

    @FindBy(xpath = "//*[@id='SearchForFaxes']")
    public WebElement SearchAfterradioBtn;

    @FindBy(xpath="//*[@id=\"outboundFaxes\"]/tbody/tr[1]/td[5]")
    public WebElement TableBody;

    @FindBy(xpath = "//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")
    public WebElement InfoButton;


    @FindBy(xpath = "//div[@id='login_message']")
    public WebElement ErrorMessage;

}

