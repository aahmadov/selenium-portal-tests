package Pages;

import Utilities.DriverSetProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage (){
        driver = DriverSetProperty.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/nav/div[3]/ul/li[2]/div/a")
    public WebElement DropDownHomepage;

    @FindBy(xpath = "//*[@id='recipientcol']/div[2]/div/div[2]/input")
    public WebElement FaxNumber;

    @FindBy(xpath = "//*[@id='coverpageTemplate']")
    public WebElement CoverPage;
    @FindBy(xpath = "//*[@id='coverpageTemplate']/option[3]")
    public WebElement ChoseCoverpage;
    @FindBy(xpath = "//*[@class='btn btn-outline-orange btn-sm']")
    public WebElement uploadPage;

//  @FindBy(xpath = "//*[@id='dropzone']")
//  public WebElement ClickuploadPage;
    @FindBy(xpath = "//*[@id='send_fax_btn']")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@class='btn btn-orange btn-sm dialogBtn']")
    public WebElement confirmationOKafterSend;

    @FindBy(xpath = "//*[@id=\"faxing\"]/div/ul/li[2]/a")
    public WebElement FaxeButton;

    @FindBy(xpath = "//*[@id=\"collapseFilter\"]/div[1]/div/div/div[1]/label")
    public WebElement OutboundButton;

    @FindBy(xpath = "//*[@id='SearchForFaxes']")
    public WebElement SearchButton;

    @FindBy(xpath="//table[@id='outboundFaxes']/tbody/tr[1]/td[5]")
    public WebElement Table;

    @FindBy(xpath = "//table[@id='outboundFaxes']/tbody/tr[1]//button[5]")
    public WebElement InfoButton;

    @FindBy(xpath = "//*[@id='out_detail_status']")
    public WebElement sendbuttonHighlight;

    @FindBy(xpath = "//*[@id='faxDetailOutbound']/div/div/div[1]/button/span")
    public WebElement closeInfoPage;
}

