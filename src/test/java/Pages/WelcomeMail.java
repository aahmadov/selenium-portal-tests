package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeMail {

    WebDriver driver;

    public WelcomeMail(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement UsernameTextBox;
    @FindBy(name = "password")
    public WebElement PasswordTextBox;
    @FindBy(id = "LoginButton")
    public WebElement loginButton;


    @FindBy(xpath = "//*[@id='faxing-heading']")
    public WebElement FaxingButton;
    @FindBy(xpath = "//*[@id='faxing']/div/ul/li[1]/a")
    public WebElement sendFaxOptionField;
    @FindBy(xpath = "//*[@name='fax_num']")
    public WebElement faxNumber;
    @FindBy(xpath = "//*[@id='coverpageTemplate']")
    public WebElement coverPage;

    @FindBy(xpath = "//*[@id='coverpageTemplate']/option[2]")
    public WebElement ChoseCoverpage;
    @FindBy(xpath = "//*[@id='dropzone']/div/button")
    public WebElement uploadPage;
    @FindBy(xpath = "//button[@class='btn btn-orange btn-sm dialogBtn'][1]")
    public WebElement confirmButton;
    @FindBy(xpath = "//*[@id=\"administration-heading\"]/h6")
    public WebElement AdministrationHeading;
    @FindBy(xpath = "//*[@id='manage-adm-settings']")
    public WebElement settingsField;

    @FindBy(xpath = "//*[@id=\"service-administration\"]/div/ul/li/a")
    public WebElement AdministrationfilterFaxstatus;

    @FindBy(xpath = "//*[@id=\"collapseFilter\"]/div[1]/div/div/div[1]/label")
    public WebElement OutboundRadiobox;
    @FindBy(xpath = "//a[@id='SearchForFaxes']")
    public WebElement SearchBTn;
    @FindBy(xpath = "//*[@id=\"faxDetailOutbound\"]/div/div/div[3]/button[2]")
    public WebElement closeInfoBtn;

    @FindBy(xpath = "//*[@id=\"manage-adm-submenu\"]")
    public WebElement SubMenuManage;


    @FindBy(xpath = "//*[@id='manage-adm-submenu-items']/li[3]/a")
    public WebElement Users;

    @FindBy(xpath = "//a[@id='send_fax_btn']")
    public WebElement SendBTN;
    @FindBy(xpath = "//button[@id='UserSaveBtn']")
    public WebElement SaveBTN;

    @FindBy(xpath = "//div[@class='modal-footer']//button[contains(text(), 'OK')]")
    public WebElement SaveConfirmationBTn;
    @FindBy(xpath = "//div[@class='modal-footer']//button[text()='OK']")
    public WebElement confirmationSendButton;
    @FindBy(xpath = "/html/body/div[16]/div[2]/div[1]/div/div[3]/button")
    public WebElement OptionButton;
    @FindBy(xpath = "//html/body/div[16]/div[2]/div[1]/div/div[3]/div/a[1]")
    public WebElement OptionDropdown;
    @FindBy(xpath = "//li[@id='manage-sys-submenu']")
    public WebElement ManageBTN;
    @FindBy(xpath = "//*[@id=\"manage-adm-submenu-items\"]/li[3]//a[contains(text(),Users)]")
    public WebElement UserBTN;
    @FindBy(xpath = "//div[@class='col-auto']//button[@class='btn btn-orange dropdown-toggle btn-sm mr-4']")
    public WebElement optionDropdownBTN;
    @FindBy(xpath = "//a[contains(@href, 'javascript:AddUser()')]")
    public WebElement CreateUserBtn;
    @FindBy(xpath = "//*[@id='UserUserId']")
    public WebElement userIDfeild;
    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement userNamefeild;
    @FindBy(xpath = "//*[@id='UserPassword']")
    public WebElement userPasswordfeild;
    @FindBy(xpath = "//*[@id='UserPasswordRetype']")
    public WebElement userPasswordRetryfeild;
    @FindBy(xpath = "//*[@id='UserEmail']")
    public WebElement userEmailfeild;
    @FindBy(xpath = "//*[@id='permissions-tab']")
    public WebElement userPermissionfeild;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='TypeAdmin']")
    public WebElement portalAdministrationBTN;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='SelectAll']")
    public WebElement allPermissionBTN;

    @FindBy(xpath = "//*[@id='manage-adm-submenu-items']/li[4]/a")
    public WebElement departmentField;

    @FindBy(xpath = "//input[@type='text' and @id='DeptName']")
    public WebElement writeDepartment;

    @FindBy(xpath = "//button[@id='DeptSaveBtn']")
    public WebElement deptSaveBTN;

    @FindBy(xpath = "//select[@id='UserDepartment']")
    public WebElement depSelectDropdown;

    @FindBy(xpath = "//div[@class='dropdown']/a")
    public WebElement userNameScreen;


    @FindBy(xpath = "//button[@id='FaxNumbersInBtn']")
    public WebElement faxNumberBTN;

    @FindBy(xpath = "//select[@id='faxnumbers_for_realm']")
    public WebElement selectNumber;

    @FindBy(xpath = "//button[@id='selectFaxNumber']")
    public WebElement assignBtn;


    @FindBy(xpath = "//button[@title='Create Department']")
    public WebElement createDepartment;
    @FindBy(xpath = "//button[@id='UserSaveBtn']")
    public WebElement SaveBTNfeild;
    @FindBy(xpath = "//*[@id='UserCountryCode']")
    public WebElement CountryCode;
    @FindBy(xpath = "//*[@id=\"user-pref\"]/div/div[1]/div[1]/div/div[1]/label")
    public WebElement WlcMailRadioBtn;

    @FindBy(xpath = "//*[@id=\"UserUserId\"]")
    public WebElement USerIDBtn;
    @FindBy(xpath = " //*[@id=\"UserName\"]")
    public WebElement USerNameBtn;
    @FindBy(xpath = "//*[@id=\"user-pref\"]/div/div[1]/div[5]/div/label")
    public WebElement paswGenerationBtn;
    @FindBy(xpath = " //*[@id=\"UserEmail\"]")
    public WebElement EmailUserbox;
    @FindBy(xpath = " //*[@id=\"UserVoiceNumber\"]")
    public WebElement UserFaxNumber;
    @FindBy(xpath = " //*[@id=\"UserSaveBtn\"]")
    public WebElement SaveBtn;

    @FindBy(xpath = " //*[@id=\"successmessage\"]")
    public WebElement passCode;
    @FindBy(partialLinkText = "Fax Administrator")
    public WebElement faxAdminDropdown;

    @FindBy(partialLinkText = "jsmith2")
    public WebElement jsmith2Dropdown;
    @FindBy(xpath = "(//a[contains(@href,'Logout')])[2]")
    public WebElement Logout;

    @FindBy(xpath = "//*[@class='btn btn-orange btn-sm dialogBtn']")
    public WebElement confirmButton2;

    @FindBy(xpath = "//select[@id='realmListForSystem']")
    public WebElement selectORG;

    @FindBy(xpath = "//*[@id='users']/tbody/tr[4]/td[7]/span/button[1]")
    public WebElement faxsendingEditBTN;

    @FindBy(xpath = "//*[@id='users']/tbody/tr[td[contains(text(), 'jdoe3')]]//button[@title='Edit User']")
    public WebElement jdoe3EditBTN;

    @FindBy(xpath = "//*[@id='users']/tbody/tr[td[contains(text(), 'jsmith2')]]//button[@title='Edit User']")
    public WebElement jsmith2EditBTN;

    @FindBy(xpath = "//*[@id='users']/tbody/tr[td[contains(text(), 'jdoe3')]]//button[@title='Delete User']")
    public WebElement deleteafterCreatejdoe3;

    @FindBy(xpath = "//*[@id='users']/tbody/tr[td[contains(text(), 'jsmith2')]]//button[@title='Delete User']")
    public WebElement deleteafterCreatejsmith2;

    @FindBy(xpath = "//*[@id='deptTable']/tbody/tr[td[contains(text(), 'IT2')]]//button[@title='Delete Department']")
    public WebElement deleteafterCreateIT2;

    @FindBy(xpath = "//*[@id='deptTable']/tbody/tr[td[contains(text(), 'ACCT3')]]//button[@title='Delete Department']")
    public WebElement deleteafterCreateACCT3;

    @FindBy(xpath = "(//div[@class='modal-footer']//button[contains(@class, 'btn-orange') and contains(text(), 'Yes')])[last()]")
    public WebElement deleteconfirmBTN;

    @FindBy(xpath = "//input[@id='UserPassword']")
    public WebElement passwordChange;

    @FindBy(xpath = "//input[@id='UserPasswordRetype']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='UserEmail']")
    public WebElement Email;



    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-orange btn-sm dialogBtn' and contains (text(), 'OK')]")
    public WebElement ErrorMessageOK;

    @FindBy(xpath = "//div[@class='modal-body']//span[@id='alertmessage' and contains (text(), 'There was an error updating user information. " +
            "Cannot change email address and password together Try again. If problem persists, contact your administrator.')]")
    public WebElement ErrorMessage;

    @FindBy(xpath = "//*[@id='manage-adm-submenu']")
    public WebElement manageDropdown;

    @FindBy(xpath = " //li[@id='manage-adm-t-submenu']/a")
    public WebElement TriageDropdown;

    @FindBy(xpath = " //ul[@id='manage-adm-t-submenu-items']//li[3]/a")
    public WebElement TriageField;

    @FindBy(xpath = "//button[@class='btn btn-orange dropdown-toggle btn-sm mr-4']")
    public WebElement OptionField;

    @FindBy(xpath = "//div[@id='foo']/a")
    public WebElement CreateField;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement NameField;

    @FindBy(xpath = "//input[@id='label']")
    public WebElement LabelField;

    @FindBy(xpath = "//input[@id='ocr_name']")
    public WebElement OCRName;

    @FindBy(xpath = "//select[@id='datatype']")
    public WebElement DataType;

    @FindBy(xpath = "//button[@id='SaveBtn']")
    public WebElement SaveBTN2;
    @FindBy(xpath = " //button[contains(@onclick, \"DeleteField\") and contains(@onclick, \"'10'\")]")
    public WebElement deleteAfterFieldCreated;

    @FindBy(xpath = " //div[@class='modal-footer']//button[@class='btn btn-orange btn-sm dialogBtn' and contains (text(), 'Yes')]")
    public WebElement deleteAfterFieldCreatedConfirm;

    @FindBy(xpath = " //ul[@id='manage-adm-settings-items']/li[3]/a")
    public WebElement FaxOption_Field;

    @FindBy(xpath = " //label[@class='custom-control-label' and @for='globalglobalDeleteAfterSendNo']")
    public WebElement DeleteFaxAfterSendNo;

    @FindBy(xpath = " //label[@class='custom-control-label' and @for='globalglobalDeleteAfterSendYes']")
    public WebElement DeleteFaxAfterSendYes;

    @FindBy(xpath = " //input[@name='fax_to']")
    public WebElement ToRecipientName;

    @FindBy(xpath = " //input[@name='company_to']")
    public WebElement ToRecipientCompany;


}