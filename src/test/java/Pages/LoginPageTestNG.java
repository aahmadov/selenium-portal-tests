package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTestNG {
    WebDriver driver;

    public LoginPageTestNG(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadPageCopy;
//driver.find_element_by_xpath('//input[@type="file"]').get_attribute('outerHTML')
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
    @FindBy(xpath = "(//button[contains(@class, 'btn btn-orange btn-sm dialogBtn')])")
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

    @FindBy(xpath = "//*[@id=\"outboundFaxes\"]/tbody/tr[1]/td[5]")
    public WebElement TableBody;

    @FindBy(xpath = "//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")
    public WebElement InfoButton;


    @FindBy(xpath = "//div[@id='login_message']")
    public WebElement ErrorMessage;

    @FindBy(xpath = "//*[@id='faxing']/div/ul/li[4]/a")
    public WebElement TriageQueueBox;

    @FindBy(xpath = "//*[@id='filterQueue']")
    public WebElement SelectQueue;

    @FindBy(xpath = "//*[@id='filterQueue']/option[2]")
    public WebElement SelectQueueBox;

    @FindBy(xpath = "//*[@id='Search']")
    public WebElement ClickSearchBtn;

//    @FindBy(xpath = "//*[matches(@id, '\\d+_edit\\w+')]")
//    public WebElement LockandEditboxesas;

   // @FindBy(xpath = "//table[@id='triageList']/tbody/tr[10]/td[9]//span/button")


    @FindBy(xpath = "(//button[contains(@class, 'btnList') and contains(@title, 'Lock and Edit Fax')])[last()]")
    public WebElement LockandEditbox;

    @FindBy(xpath = "//*[@id='opt_1_2']/option[1]")
    public WebElement Female;
    @FindBy(xpath = "//*[@id='opt_1_2']/option[2]")
    public WebElement Male;
    @FindBy(xpath = "//*[@id='opt_1_2']/option[3]")
    public WebElement Other;

    @FindBy(xpath = "//*[@class='dataTables_scrollBody']")
    public WebElement Scrollbtn;
    @FindBy(xpath = "//*[@id='doc1_type_fields']/div/div/table/tbody/tr[3]/td[2]/input")
    public WebElement lastName;

    @FindBy(xpath = "//select[@id='opt_1_2']")
    public WebElement Gender;

    @FindBy(xpath = "//*[@id='doc1_type_fields']/div/div/table/tbody/tr[6]/td[2]/input")
    public WebElement PhoneNumber;


    @FindBy(xpath = "//*[@id='vopt_1_7']")
    public WebElement Physician;

    @FindBy(xpath = "//*[@id='ui-id-3']")
    public WebElement firstSelection;

    @FindBy(xpath = "//*[@id='vopt_1_3_1']")
    public WebElement Exam;

    @FindBy(xpath = "//*[text()='76377P 3D POST PROCESSING IND WORK STATION']")
    public WebElement ExamKey;

    @FindBy(xpath = "//*[@id='fax_comments']")
    public WebElement FaxComments;

    @FindBy(xpath = "//*[@id='btn-submit']")
    public WebElement Submitbtn;

    //
    @FindBy(xpath = "//*[@id='modalMessage']/div/div/div[3]/button[1]")
    public WebElement Closebtn;

}

