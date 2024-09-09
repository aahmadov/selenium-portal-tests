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

    @FindBy(xpath = "//*[@id='coverpageTemplate']/option[3]")
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

    //*[@id="1309_pdfbtn"]
    @FindBy(xpath = "//*[@id=\"faxing\"]/div/ul/li[2]/a")
    public WebElement FaxesBTN;

    @FindBy(xpath = "//*[@id=\"SearchForFaxes\"]")
    public WebElement searchBTN;

    @FindBy(xpath = "//*[@id=\"FilterFaxTypeInbound\"]")
    public WebElement InboundBtn;

    @FindBy(xpath = "//*[@id=\"successmessage\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"administration-heading\"]/h6")
    public WebElement AdministrationHeading;

    @FindBy(xpath = "//*[@id=\"service-administration\"]/div/ul/li/a")
    public WebElement AdministrationfilterFaxstatus;

    @FindBy(xpath = "//*[@id=\"collapseFilter\"]/div[1]/div/div/div[1]/label")
    public WebElement OutboundRadiobox;

    @FindBy(xpath = "//*[@id=\"collapseFilter\"]/div[1]/div/div/div[2]/label")
    public WebElement InboundRadiobox;


    @FindBy(xpath = "//*[@id='i0116']")
    public WebElement SSOUSerNameBox;

    @FindBy(xpath = "//*[@id='idSIButton9']")
    public WebElement microsoftNextBTN;

    @FindBy(xpath = "//*[@id='i0118']")
    public WebElement SSOPasswordBox;

    @FindBy(xpath = "//*[@id='idSIButton9']")
    public WebElement microSoftSignInBTN;

    @FindBy(xpath = "//*[@id='KmsiCheckboxField']")
    public WebElement dontSignIncheckBox;

    @FindBy(xpath = "//*[@id='idBtn_Back']")
    public WebElement dontShowMeagainBox;

    @FindBy(xpath = "//*[@id=\"otherTile\"]/div/div[1]/img")
    public WebElement AnotherAccountBTN;

    //@FindBy(xpath = "//div[@class='dropdown']//a[contains(@class, 'nav-link dropdown-toggle')]")
    @FindBy(xpath = "/html/body/nav/div[3]/ul/li[1]/div/a/strong")
    public WebElement dropdownlink;
    @FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-right pt-0 pb-0 show']//a[contains(@class, 'nav-link') and contains(text(),'Logout')]")
    public WebElement loginLogoutBTN;
    //div[@class='dropdown-menu dropdown-menu-right pt-0 pb-0 show']//a[contains(@class, 'nav-link') and contains(text(),'Logout')]
    @FindBy(xpath = "//*[@id='SearchForFaxes']")
    public WebElement SearchAfterradioBtn;

    @FindBy(xpath = "//*[@id=\"outboundFaxes\"]/tbody/tr[1]/td[5]")
    public WebElement TableBody;

    @FindBy(xpath = "//div[@class='modal-dialog modal-md']//input[@id='portTollFreeNumbers']")
    public WebElement TollFreeNumberBTN;

    @FindBy(xpath = "//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")
    public WebElement InfoButton;

    @FindBy(xpath = " //*[@id=\"myNumbers\"]/tbody/tr[last()]/td[8]//button [@class='btnList'][1]")
    public WebElement InfoButtonOfFaxNumberTabel;

    @FindBy(xpath = " //*[@id=\"requestDetailDialog\"]/div/div/div[3]/button")
    public WebElement closeBTNofInfoBtn;

    @FindBy(xpath = "//*[@id=\"faxDetailOutbound\"]/div/div/div[3]/button[2]")
    public WebElement closeInfoBtn;

    @FindBy(xpath = "//*[@id='faxDetailInbound']/div/div/div[3]/button")
    public WebElement closeInfoBtnAfterRecv;
    @FindBy(xpath = "//*[@id='FromDatetimepicker']/div/div")
    public WebElement calanderDropBox;
    @FindBy(xpath = "//*[@id='FilterStatus']")
    public WebElement FilteStatus;

    @FindBy(xpath = "//*[@id='FilterStart']")
    public WebElement CalendarFilteStart;

    @FindBy(xpath = "//*[@id='out_detail_faxid']")
    public WebElement InfoButtonFaxIdVerification;
    @FindBy(xpath = "//*[@id='out_detail_status']")
    public WebElement InfoButtonFaxStatusVerification;
    @FindBy(xpath = "//div[@id='login_message']")
    public WebElement ErrorMessage;


    @FindBy(xpath = "//*[@id='manage-adm-submenu']")
    public WebElement manageDropdown;
    @FindBy(xpath = "//*[@id='manage-adm-submenu-items']/li[1]/a")
    public WebElement FaxNumberfromManageDropdown;


    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-right show']//*[@class='dropdown-item'][1]")
    public WebElement FaxNumberOption;

    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-right show']//*[@class='dropdown-item'][2]")
    public WebElement FaxNumberOptionPortFaxNumber;

    @FindBy(xpath = "//*[@class='btn btn-orange dropdown-toggle btn-sm mr-4']")
    public WebElement FaxNumberOptionDropdownButton;


    @FindBy(xpath = "//*[@id=\"addRequestState\"]")
    public WebElement stateChose;
    @FindBy(xpath = "//*[@id=\"addCity\"]")
    public WebElement cityChoose;
    @FindBy(xpath = "//input[@type=\"text\" and @id=\"notifyEmailPort\" and @name=\"notifyEmail\" and @class=\"form-control\"]")
    public WebElement emailRequired;
    @FindBy(xpath = "//*[@id='notifyEmail']")
    public WebElement notifyEmail;

    @FindBy(xpath = "//*[@id='commentPort']")
    public WebElement commentSection;

    @FindBy(xpath = "//*[@id='comment']")
    public WebElement commentfeild;

    @FindBy(xpath = "//*[@id=\"portRequestCountry\"]")

    public WebElement selectCountry;

    @FindBy(xpath = "//*[@id=\"restrict_to_dept_port\"]")
    public WebElement selectDepartments;
    @FindBy(xpath = "//div[@class='modal fade show' and @id='port-dialog']//button[@id='addRequestPortSubmit']")
    public WebElement submit;

    @FindBy(xpath = "//*[@id='addRequestSubmit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//button[@class='btn btn-orange btn-sm dialogBtn']")
    public WebElement submitConfirmBTN;
    @FindBy(xpath = "//div[@class='modal fade show']//div[@class='modal-footer']//button[contains(text(),'No')]")
    public WebElement anotherRequestConfirmBTN;
    @FindBy(xpath = "//ul[@class='pagination']/li/a[text()='2']")
    public WebElement clickingSecondPage;

    @FindBy(xpath = "//table[@id='myNumbers']/tbody/tr[last()]")
    public WebElement findLastRowintheTabledPage;

    @FindBy(xpath = "//div[@class='modal fade show']//button[@class='close' and @aria-label='Close']")
    public WebElement anotherRequestConfirmBTN2;
    //div[@class='modal fade show']//button[@class='close' and @aria-label='Close']
    @FindBy(xpath = "//*[@id=\"AddRequestFieldset\"]/div[1]/div/div[1]/div[2]/label")
    public WebElement tollFreeNumberBTN;

    @FindBy(xpath = "//*[@id=\"AddRequestPortFieldset\"]/div/div/div[1]/div[2]/div/label")
    public WebElement tollFreeNumberBTNPortFaxNumberBTN;

    @FindBy(xpath = "//*[@id=\"portTollFreeNumbers\"]")
    public WebElement tollFreeNumberBTNPortFaxNumberBTN2;

    @FindBy(xpath = "//*[@id='number_to_port']")
    public WebElement faxNumbertoPort;

    @FindBy(xpath = " //*[@id='addRequestPortSubmit']")
    public WebElement submitBTN;
    @FindBy(xpath = "//div[@class='form-group required']//input[@type='file' and @class='custom-file-input' and @id='carrierFormFile']")
    public WebElement LetterOfAgencyBTN;
    @FindBy(xpath = "//*[@id=\"AddRequestPortFieldset\"]/div/div/div[7]/div/div[2]/div/div/label")
    public WebElement LetterOfAgencyBTN2;

    @FindBy(xpath = "//*[@id=\"port-dialog\"]")
    public WebElement portSecondPageScroll;

    @FindBy(xpath = "//*[@id=\"port_form2\"]/div/div/label")
    public WebElement MostRecentPhoneBill;

    @FindBy(xpath = "//*[@id=\"bntBuildForm\"]")
    public WebElement buildFormBTN;
    @FindBy(xpath = "//*[@id='inputCompany']")
    public WebElement companyNameField;
    @FindBy(xpath = "//*[@id='inputAddress']")
    public WebElement addressNameField;
    @FindBy(xpath = "//*[@id='inputCity']")
    public WebElement cityNameField;
    @FindBy(xpath = "//*[@id='inputState']")
    public WebElement stateNameField;
    @FindBy(xpath = "//*[@id='inputZip']")
    public WebElement zipNameField;
    @FindBy(xpath = "//*[@id=\"inputCarrierName\"]")
    public WebElement CarrierNameField;
    @FindBy(xpath = "//*[@id='inputCarrierAccount']")
    public WebElement CarrierAccountNameField;

    @FindBy(xpath = "//*[@id=\"inputBTN\"]")
    public WebElement inputBTN;
    @FindBy(xpath = "//*[@id=\"inputPortType\"]")
    public WebElement inputPortBTN;
    @FindBy(xpath = "//*[@id=\"inputDesiredDueDate\"]")
    public WebElement dateField;;
    @FindBy(xpath = "//*[@id=\"inputName\"]")
    public WebElement nameField;
    @FindBy(xpath = "//*[@id=\"inputTitle\"]")
    public WebElement titleField;
    @FindBy(xpath = "//*[@id=\"GenerateLOASubmit\"]")
    public WebElement createField;


    @FindBy(xpath = "//*[@id='assigned_to_user_port']")
    public WebElement assignToUserBTn;
    @FindBy(xpath = "//*[@id='restrict_to_dept']")
    public WebElement RestrictToDepart;

    @FindBy(xpath = "//*[@id='assigned_to_user']")
    public WebElement assignToUserbtn;

    @FindBy(xpath = "//*[@id='faxing']/div/ul/li[4]/a")
    public WebElement TriageQueueBox;

    @FindBy(xpath = "//*[@id='filterQueue']")
    public WebElement SelectQueue;

    @FindBy(xpath = "//*[@id='filterQueue']/option[2]")
    public WebElement SelectQueueBox;

    @FindBy(xpath = "//*[@id='Search']")
    public WebElement ClickSearchBtn;


    @FindBy(xpath = "//*[@id='btn-save']")
    public WebElement Savebtn;

    @FindBy(xpath = "//*[@id='btn-cancel']")
    public WebElement Cancelbtn;

    @FindBy(xpath = "//*[@id='btn-delfax']")
    public WebElement DeleteFaxlbtn;

    @FindBy(xpath = "//*[@id='btn-delfax-confirm-yes']")
    public WebElement DeleteFaxconfirmbtn;
//
    @FindBy(xpath = "//*[@id='dropdownMenuButton2']")
    public WebElement DropDownbtn;

    @FindBy(xpath = "//*[@id='main']/header/ul/li[4]/a[2]/i")
    public WebElement RotateClockwise;

    @FindBy(xpath = "//*[@id='main']/header/ul/li[4]/a[2]")
    public WebElement RotateCounterClockwise;

    @FindBy(xpath = "//*[@id='main']/header/ul/li[5]/a[2]")
    public WebElement RemovePage;

    @FindBy(xpath = "//*[@id='main']/header/ul/li[5]/a[1]")
    public WebElement SaveasPDF;


    // Method to perform actions based on the boolean flags in JSON data
    public void performActionBasedOnFlags(boolean useSaveBtn, boolean useCancelBtn, boolean useDeleteFaxBtn,
                                          boolean rotateClockwise, boolean rotateCounterClockwise, boolean removePage,
                                          boolean saveAsPDF) throws InterruptedException {
        if (useSaveBtn) {
            Savebtn.click();
        } else if (useCancelBtn) {
            Cancelbtn.click();
        } else if (useDeleteFaxBtn) {
            DeleteFaxlbtn.click();
            Thread.sleep(1000*2);
            DeleteFaxconfirmbtn.click();
        } else if (rotateClockwise) {
            RotateClockwise.click();
            Thread.sleep(1000*5);
            Savebtn.click();
            // Handle rotateClockwise action
        } else if (rotateCounterClockwise) {
            RotateCounterClockwise.click();
            // Handle rotateCounterClockwise action
        } else if (removePage) {
            RemovePage.click();
            // Handle removePage action
        } else if (saveAsPDF) {
            SaveasPDF.click();
            // Handle saveAsPDF action
        } else {
            System.out.println("No action specified in JSON data.");
        }

    }

    @FindBy(xpath = "(//button[contains(@class, 'btnList') and contains(@title, 'Lock and Edit Fax')])[last()]")
    public WebElement LockandEditbox;
    @FindBy(xpath = " //*[@id='89_editbtn']/i")
    public WebElement LockandEditbox1;
    @FindBy(xpath="//*[@id='doc1_type']")
    public WebElement DocumentTypeBox;

    @FindBy(xpath = "//*[@id='opt_1_2']/option[1]")
    public WebElement Female;
    @FindBy(xpath = "//*[@id='opt_1_2']/option[2]")
    public WebElement Male;
    @FindBy(xpath = "//*[@id='opt_1_2']/option[3]")
    public WebElement Other;

    @FindBy(xpath = "(//a[contains(@href,'Logout')])[2]")
    public WebElement Logout;
    @FindBy(xpath = "//*[@id='right-sidebar']/div")
    public WebElement Scrollbtn1;

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

