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
    @FindBy(xpath = "//*[@id='coverpageTemplate']/option[1]")
    public WebElement ChoseCoverpage46;
    @FindBy(xpath = "//*[@id='dropzone']/div/button")
    public WebElement uploadPage;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadPageCopy;
    @FindBy(xpath = "//select[@id='realmListForSystem']")
    public WebElement selectORG1;
    @FindBy(xpath = "//*[@id=\"top-org-menu-grp\"]/div/div[2]/button")
    public WebElement selectORG;
    @FindBy(xpath = "//*[@id=\"top-org-menu-grp\"]/div/div[2]/div/div[2]/ul/li[4]/a")
    public WebElement selectAuto1;
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


    @FindBy(xpath = "//div[@class='modal-footer']//button[text()='OK']")
    public WebElement confirmationButton;

    @FindBy(xpath = "//*[@id='alertmessage']")
    public WebElement DateErrorMessage;

    @FindBy(xpath = "//*[@id=\"faxing\"]/div/ul/li[2]/a")
    public WebElement FaxesBTN;

    @FindBy(xpath = "//*[@id=\"SearchForFaxes\"]")
    public WebElement searchBTN;

    @FindBy(xpath = "//*[@id=\"FilterFaxTypeInbound\"]")
    public WebElement InboundBtn;

    @FindBy(xpath = "//*[@id=\"successmessage\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@id=\"administration-heading\"]/h6")
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
    @FindBy(xpath = "//a[@id='SearchForFaxes']")
    public WebElement SearchAfterradioBtn;

    @FindBy(xpath = "//table[@id='inboundFaxes']/tbody/tr[1]//button[5")
    public WebElement InboundInfoBtn;

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
    @FindBy(xpath = "//*[@id='UserSaveBtn']")
    public WebElement SavebtnafterCreateUser;

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
            System.out.println(": No action specified in JSON data (JsonData.json).");
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

    @FindBy(xpath = "//*[@id='accordionExample']/div[1]/div/table/tbody/tr[1]/td[2]/input")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='accordionExample']/div[1]/div/table/tbody/tr[3]/td[2]/input")
    public WebElement lastName2;
    @FindBy(xpath = "//*[@id='real_date_6']")
    public WebElement DOB;


    @FindBy(xpath = "//select[@id='opt_1_2']")
    public WebElement Gender;

    @FindBy(xpath = "//*[@id='accordionExample']/div[1]/div/table/tbody/tr[6]/td[2]/input")
    public WebElement PhoneNumber;

//*[@id='doc1_type_fields']/div/div/table/tbody/tr[6]/td[2]/input
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

    @FindBy(xpath = "//*[@id='modalMessage']/div/div/div[3]/button[1]")
    public WebElement Closebtn;

    @FindBy(xpath = "//*[@id=\"manage-adm-submenu-items\"]/li[3]/a")
    public WebElement manageBTn;

    @FindBy(xpath = "//*[@id=\"manage-adm-submenu-items\"]/li[3]//a[contains(text(),Users)]")
    public WebElement UserBTN;

    @FindBy(xpath = "//div[@class='col-auto']//button[@class='btn btn-orange dropdown-toggle btn-sm mr-4']")
    public WebElement optionDropdownBTN;

    @FindBy(xpath = "//a[contains(@href, 'javascript:AddUser()')]")
    public WebElement CreateUserBtn;
    @FindBy(xpath = "//*[@id='UserCountryCode']")
    public WebElement CountryCode;
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
    @FindBy(xpath = "//*[@id='UserDepartment']")
    public WebElement department;
    @FindBy(xpath = "//*[@id='permissions-tab']")
    public WebElement userPermissionfeild;

    @FindBy(xpath = "//*[@id='UserSaveBtn']")
    public WebElement SaveBTNfeild;
    @FindBy(xpath = "//table[@id='users']//tr[1]//button[@title='Delete User']")
    public WebElement deleteafterCreate;
    @FindBy(xpath = "(//div[@class='modal-footer']//button[contains(@class, 'btn-orange') and contains(text(), 'Yes')])[last()]")
    public WebElement deleteconfirmBTN;

    @FindBy(xpath = "//*[@id=\"outboundFaxes\"]/tbody/tr[1]/td[10]/span/div/button[1]")
    public WebElement advancedActionBTN;


    @FindBy(xpath = "//*[@id=\"outboundFaxes\"]/tbody/tr[1]/td[10]/span/div/div/button/i")
    public WebElement ReprocessCoverPandDocConversion;

    @FindBy(xpath = "(//div[@class='modal-footer']//button[contains(@class, 'btn-orange') and contains(text(), 'Yes')])[last()]")
    public WebElement conversionIssuebeenResolvedBTN;

    @FindBy(xpath = "(//*[@id=\"outboundFaxes\"]/tbody/tr[1]/td[10]/span/button[3]")
    public WebElement reprocessingINFOBTN;

    @FindBy(xpath = "(//*[@id=\"user-dialog\"]/div/div/div[3]/button[2]")
    public WebElement closeReprocesingINFOBTN;

    @FindBy(xpath = "//*[@id='ResendFaxSave']")
    public WebElement submitResendBTN;
    @FindBy(xpath = "//div[@class='modal-footer']//button[contains(@class, 'btn btn-orange btn-sm dialogBtn') and contains(text(), 'OK')]")
    public WebElement confirmationsubmitResendBTN;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle' and contains(., 'Fax Administrator')]")
    public WebElement faxAdminDropdown;

    @FindBy(xpath = " //a[@class='nav-link dropdown-toggle' and contains(., 'Baku52')]")
    public WebElement Baku52Dropdown;

    @FindBy(xpath = "(//a[@class='nav-link text-left p-2 text-primary w-100' and contains(., 'Logout')])[2]")
    public WebElement logoutBTN;

    @FindBy(xpath = "//div[@class='card-body p-0 m-0']//a[@class='nav-link text-left p-2 text-primary w-100' and contains(., 'Logout')]")
    public WebElement logoutBTN2ndpage;

    @FindBy(xpath = "//a[@id='permissions-tab']")
    public WebElement permisionBTN;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='TypeDeptAdmin']")
    public WebElement departmentAdminBTN;

    @FindBy(xpath = "//input[@id='deptperm_3']")
    public WebElement chooseDepartmentBtn;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='APIAdmin']")
    public WebElement APIPermissionRadioBTN;
    @FindBy(xpath = "//div[@id='deptadmin-heading']")
    public WebElement departmentAdmisntrationBTN2ndPage;
    @FindBy(xpath = "//div[@id='deptadmin-heading']")
    public WebElement selectDepartmentfrom2Page;
    @FindBy(xpath = "//*[@id='dept-administration']//div/ul/li[2]//a")
    public WebElement user2ndPage;
    @FindBy(xpath = "//*[@id='users']/tbody/tr[1]/td[7]/span/button[3]/i")
    public WebElement deleteUserBTN;

    @FindBy(xpath = "//*[@id='users']/tbody/tr[1]/td[7]/span/button[1]/i")
    public WebElement infoBTNUser;

    @FindBy(xpath = "//button[@title='Create Department']")
    public WebElement createDepartment;

    @FindBy(xpath = "//input[@type='text' and @id='DeptName']")
    public WebElement writeDepartment;

    @FindBy(xpath = "//button[@id='DeptSaveBtn']")
    public WebElement deptSaveBTN;

    @FindBy(xpath = "//*[@id='manage-adm-submenu-items']/li[4]/a")
    public WebElement departmentField;

    @FindBy(xpath = "//table[@id='deptTable']//tbody//tr[last()]/td[5]//button[@title='Delete Department']")
    public WebElement deleteDepartmentAfterCreate;

    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-orange btn-sm dialogBtn' and contains (text(), 'Yes')]")
    public WebElement deleteDepartmentAfterCreateConfirmationBTN;

    @FindBy(xpath = "//*[@id='manage-adm-settings']")
    public WebElement settingsField;
    @FindBy(xpath = "//*[@id='manage-adm-settings-items']/li[2]/a")
    public WebElement portUI;
    @FindBy(xpath = "//ul[@id='manage-adm-settings-items']//li[5]/a")
    public WebElement SFTP;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle' and strong[text()='Fax Administrator']]")
    public WebElement LogoutFaxAdminBox;
    @FindBy(xpath = "(//a[contains(@href,'Logout')])[2]")
    public WebElement Logout2;
    @FindBy(xpath = "(//input[@id='UserMustChangePwdYes' and @type='radio']")
    public WebElement changeUserPassYes;

    @FindBy(xpath = "(//input[@id='password']")
    public WebElement currentPass;

    @FindBy(xpath = "(//input[@id='passwordnew']")
    public WebElement newPass;

    @FindBy(xpath = "(//input[@id='passwordnew2']")
    public WebElement newPassConfirm;

    @FindBy(xpath = "(//a[@id='LoginButton']")
    public WebElement changePassBTN;

    @FindBy(xpath = "//select[@id='field_for_file']")
    public WebElement FileNameFormat;


    @FindBy(xpath = "//input[@id='file_format']")
    public WebElement FileNameFormatField;

    @FindBy(xpath = "//a[@id='add_Field_to_file']")
    public WebElement FileNameFormatplusBTN;


    @FindBy(xpath = "//a[@id='add_Field_to_folder']/i")
    public WebElement FieldplusBTN;
    @FindBy(xpath = "//a[@id='test_sftp']")
    public WebElement SFTPtestlink;
    @FindBy(xpath = "//ul[@id='manage-adm-settings-items']/li[8]/a")
    public WebElement SFTPtestlink2;

    @FindBy(xpath = "//div[@class='modal-footer']//button[@class='btn btn-orange btn-sm dialogBtn' and contains (text(), 'OK')]")
    public WebElement SFTPtestlinkConfimOk;

    @FindBy(xpath = "//a[@id='options-tab']")
    public WebElement OptionTab;

    @FindBy(xpath = "//a[@id='users-tab']")
    public WebElement UsersTab;
    @FindBy(xpath = "//button[@id='saveBtn']")
    public WebElement SaveBTN;

    @FindBy(xpath = "//button[@id='UserSaveBtn']")
    public WebElement UsersRuleSaveBTN;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for= 'globalglobalRestrictRecipientToPBYes']")
    public WebElement globalrecipientYEs;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for= 'globalglobalRestrictRecipientToPBNo' and text()='No']")
    public WebElement globalrecipientNo;

    @FindBy(xpath = "//select[@id='user_to_poll']")
    public WebElement AllUsersDropdown;

    @FindBy(xpath = "//*[@id='field_for_folder']")
    public WebElement Folderformat;

    @FindBy(xpath = "//*[@id='output_folder']")
    public WebElement FoldertypeFeild;

    @FindBy(xpath = "//*[@id='myUsers']/tbody/tr/td[4]/span/button[1]")
    public WebElement EditBtn;

    @FindBy(xpath = "//div[@class='modal-footer']//button[contains(text(), 'OK')]")
    public WebElement SaveConfirmationBTn;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowRecentFaxesYes' ]")
    public WebElement ShowRecentFaxesYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowRecentFaxesNo' ]")
    public WebElement ShowRecentFaxesNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowIDRecentFaxesYes' ]")
    public WebElement ShowIDRecentFaxesYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowIDRecentFaxesNo' ]")
    public WebElement ShowIDRecentFaxesNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowActionsRecentFaxesYes' ]")
    public WebElement ShowActionRecentFaxesYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowActionsRecentFaxesNo' ]")
    public WebElement ShowActionRecentFaxesNO;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSplit1' ]")
    public WebElement globalShowSplit1;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSplit2' ]")
    public WebElement globalShowSplit2;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSplit0' ]")
    public WebElement globalShowSplit0;

    @FindBy(xpath = "//input[@id='globalSplitLabel']")
    public WebElement FaxIdentiferLabel;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendCoverPageYes' ]")
    public WebElement ShowSendCoverPageYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendCoverPageNo' ]")
    public WebElement ShowSendCoverPageNo;



    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendKeywordYes' ]")
    public WebElement ShowSendKeywordYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendKeywordNo' ]")
    public WebElement ShowSendKeywordNo;


    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendAfterYes' ]")
    public WebElement ShowSendAfterYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendAfterNo' ]")
    public WebElement ShowSendAfterNo;


    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendEmailYes' ]")
    public WebElement ShowSendEmailYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalShowSendEmailNo' ]")
    public WebElement ShowSendEmailNo;

    @FindBy(xpath = "//a[@id='faxsearch-tab']")
    public WebElement FaxSearchPage;

    /*
    SecondFaxServicePage
     */
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalShowDMYes']")
    public WebElement ShowDeleveryManagerBTNYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalShowDMNo']")
    public WebElement ShowDeleveryManagerBTNNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowFaxMarkingYes']")
    public WebElement AllowFaxMarketingBTNyes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowFaxMarkingNo']")
    public WebElement AllowFaxMarketingBTNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowFaxDeleteYes']")
    public WebElement AllowfaxDeleteBTNYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowFaxDeleteNo']")
    public WebElement AllowfaxDeleteBTNNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalDownloadOptionall']")
    public WebElement DownloadFaxBothImage;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalDownloadOptionpdf']")
    public WebElement DownloadFaxImagePDF;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalDownloadOptiontiff']")
    public WebElement DownloadFaxImageTiff;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globaloutconfirmPDFnone']")
    public WebElement confirmationPageInPDFNONEbtn;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globaloutconfirmPDFprepend']")
    public WebElement globaloutconfirmPDFprepend;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globaloutconfirmPDFappend']")
    public WebElement DownloadFaxImageAppend;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowInbondKeywordEditYes']")
    public WebElement inboundKeyboardeditYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowInbondKeywordEditNo']")
    public WebElement inboundKeyboardeditNo;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSearchForFaxNumYes']")
    public WebElement SerachforFaxnumberBTNYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSearchForFaxNumNo']")
    public WebElement SerachforFaxnumberBTNNo;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSearchForBatchNameNo']")
    public WebElement SerachforbatchNameBTNNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSearchForBatchNameYes']")
    public WebElement SerachforbatchNameBTNYes;

    /*
    miscellaneous section
    */
    @FindBy(xpath = "//a[@id='misc-tab']")
    public WebElement MiscellaneousTab;

    @FindBy(xpath = "//*[@id='globalSessionTimeoutMinutes']")
    public WebElement SessionTimeout;
    @FindBy(xpath = "//*[@id='globalSessionLoginURL']")
    public WebElement LoginBtnURL;
    @FindBy(xpath = "//*[@id='globalSessionLogoutURL']")
    public WebElement LogoutBtn;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalPreferenceshide']")
    public WebElement UserPreferencesHide;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalPreferencespassword']")
    public WebElement UserPreferencesPass;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalPreferencesall']")
    public WebElement UserPreferencesPassAll;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalShowUserUsageYes']")
    public WebElement UserUsageYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalShowUserUsageNo']")
    public WebElement UserUsageNo;
    @FindBy(xpath = " //select[@id='globalShowPB']")
    public WebElement ShowContactList;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalForcePwdChangeYes']")
    public WebElement PassChangeDefaultYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalForcePwdChangeNo']")
    public WebElement PassChangeDefaultNo;


    /*
    Broadcast/MailMarge
    */

    @FindBy(xpath = "//a[@id='broadcast-tab']")
    public WebElement Broadcast_Mailmerge;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowBroadcastYes']")
    public WebElement allowBroadfaxYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalAllowBroadcastNo']")
    public WebElement allowBroadfaxNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendCoverPageYes']")
    public WebElement showCoverPageYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendCoverPageNo']")
    public WebElement showCoverPageNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendCoverPageMessageYes']")
    public WebElement showCoverPageMessageYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendCoverPageMessageNo']")
    public WebElement showCoverPageMessageNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowNotifyYes']")
    public WebElement showNotifyYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowNotifyNo']")
    public WebElement showNotifyNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendAfterYes']")
    public WebElement showSendAfterYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendAfterNo']")
    public WebElement showSendAfterNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendEmailYes']")
    public WebElement showEmailYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalBroadcastShowSendEmailNo']")
    public WebElement showEmailNo;



    @FindBy(xpath = "//ul[@id='manage-adm-settings-items']//li[4]/a")
    public WebElement Single_sign_BTN;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalSSO_EnableNo' ]")
    public WebElement EnableSSONo;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for='globalglobalSSO_EnableYes' ]")
    public WebElement EnableSSOYes;
    @FindBy(xpath = "//input[@id='SP_Name']")
    public WebElement SP_name;

    @FindBy(xpath = "//input[@id='IDP_Name']")
    public WebElement Idp_name;
    @FindBy(xpath = "//input[@id='IDP_URL']")
    public WebElement IDP_URL;
    @FindBy(xpath = "//input[@id='IDP_SSO_URL']")
    public WebElement Single_Sign_on_Service_URL;

    @FindBy(xpath = "//input[@id='IDP_SLO_URL']")
    public WebElement Single_Logoff_Service_URL;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_SignLogoutRequestYes']")
    public WebElement Sing_Logout_requestYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_SignLogoutRequestNo']")
    public WebElement Sing_Logout_requestNo;



    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_WantLogoutResponseSignedYes']")
    public WebElement Want_Logout_Response_SignedYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_WantLogoutResponseSignedNo']")
    public WebElement Want_Logout_Response_SignedNo;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_SignAuthnRequestYes']")
    public WebElement Sign_Authn_RequestYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_SignAuthnRequestNo']")
    public WebElement Sign_Authn_RequestNo;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_IdIsEmailNo']")
    public WebElement SSO_ID_is_Email_AddressNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_IdIsEmailYes']")
    public WebElement SSO_ID_is_Email_AddressYes;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_RealmInASCNo']")
    public WebElement IdP_Assertion_is_using_ACSNo;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_RealmInASCYes']")
    public WebElement IdP_Assertion_is_using_ACSYes;

    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_SetPermissionsAtLoginYes']")
    public WebElement Set_Permissions_at_LoginYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for ='globalglobalSSO_SetPermissionsAtLoginNo']")
    public WebElement Set_Permissions_at_LoginNo;

    @FindBy(xpath = "//textarea[@id='IDP_Cert']")
    public WebElement Certificate;






}

