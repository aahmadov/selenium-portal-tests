package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSecond {


    WebDriver driver;

    public LoginPageSecond(WebDriver driver) {
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
    @FindBy(xpath = "//div[@id='system-heading']//h6")
    public WebElement SystemDropdown;
    @FindBy(xpath = "//li[@id='manage-sys-submenu']")
    public WebElement ManageBTN;
    @FindBy(xpath = "//ul[@id='manage-sys-submenu-items']//li[1]/a")
    public WebElement LicenseBTN;


    @FindBy(xpath = "//*[@id='license_table']/tbody/tr/td[6]/span/button[last()]")
    public WebElement DeletingFieldBTN;

    @FindBy(xpath = "//div[@class='modal-footer']//button[contains(@class,'btn btn-orange btn-sm dialogBtn') and contains(text(), 'Yes')]")
    public WebElement DeletingConfirmdBTN;

    @FindBy(xpath = "//button[@title='Add License']")
    public WebElement NewBTN;
    @FindBy(xpath = "//select[@id='detailRealm']")
    public WebElement Organization;
    @FindBy(xpath = "//select[@id='detailProduct']")
    public WebElement ProductBTN;
    @FindBy(xpath = "//input[@id='detailPCid']")
    public WebElement MacAddress;
    @FindBy(xpath = "//input[@id='detailExpirationDate']")
    public WebElement ExpirationData;
    @FindBy(xpath = "//input[@id='detailDescription']")
    public WebElement Description;
    @FindBy(xpath = "//button[@id='saveLicense']")
    public WebElement SaveBTn;
    @FindBy(xpath = "//button[contains(@class, 'btnList') and contains(@title, 'Edit')][last()]")
    public WebElement EditBTN;

    @FindBy(xpath = "//select[@id='realmListForSystem']")
    public WebElement selectORG1;



}
