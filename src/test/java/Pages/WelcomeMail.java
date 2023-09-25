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

    @FindBy(xpath = "//button[@class='btn btn-orange btn-sm dialogBtn'][1]")
    public WebElement confirmButton;
    @FindBy(xpath = "//*[@id=\"administration-heading\"]/h6")
    public WebElement AdministrationHeading;

    @FindBy(xpath = "//*[@id=\"manage-adm-submenu\"]")
    public WebElement SubMenuManage;


    @FindBy(xpath = "//*[@id='manage-adm-submenu-items']/li[3]/a")
    public WebElement Users;


    @FindBy(xpath = "/html/body/div[16]/div[2]/div[1]/div/div[3]/button")
    public WebElement OptionButton;
    @FindBy(xpath = "//html/body/div[16]/div[2]/div[1]/div/div[3]/div/a[1]")
    public WebElement OptionDropdown;

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
    @FindBy(xpath = " /html/body/div[19]/div/div/div[3]/button")
    public WebElement SaveBtnConfirmation;
    @FindBy(xpath = " //*[@id=\"successmessage\"]")
    public WebElement passCode;
    @FindBy(partialLinkText = "Fax Administrator")
    public WebElement faxAdminDropdown;

    @FindBy(xpath = "(//a[contains(@href,'Logout')])[2]")
    public WebElement Logout;

    @FindBy(xpath = "//*[@class='btn btn-orange btn-sm dialogBtn']")
    public WebElement confirmButton2;

//"//a[contains(@href, 'Logout')]"

}
