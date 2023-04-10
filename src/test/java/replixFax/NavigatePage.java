package replixFax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class NavigatePage {


    public static void main (String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDrive/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        String Url="http://10.250.1.100";
        driver .get(Url);
        Thread.sleep(1000*5);

        /*This operation will maximize window*/
        driver.manage().window().maximize();

        System.out.println("Website title is " +driver.getTitle());

        WebElement Username = driver.findElement(By.id("username"));
        Username.sendKeys("replix");
        Thread.sleep(1000*5);

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("softlinx");
        Thread.sleep(1000*5);

        WebElement loginButton= driver.findElement(By.id("LoginButton"));
        loginButton.click();
        Thread.sleep(1000*3);

        WebElement ConfirmButton= driver.findElement(By.xpath( "//button[@class='btn btn-orange btn-sm dialogBtn'][1]"));
        ConfirmButton.click();
        Thread.sleep(1000*3);


        WebElement FaxingButton= driver.findElement(By.xpath("//*[@id='faxing-heading']/h6"));
        FaxingButton.click();
        Thread.sleep(1000*3);

        WebElement ClickDropDown = driver.findElement(By.xpath("//*[@id='top-org-menu-grp']/div/div[2]"));
        ClickDropDown.click();
        Thread.sleep(1000*5);
        WebElement ChooseOrgName = driver.findElement(By.xpath("//*[@id='top-org-menu-grp']/div/div[2]/div/div[2]/ul/li[4]/a"));
        ChooseOrgName.click();
        Thread.sleep(1000*10);
        WebElement FaxingButton2= driver.findElement(By.xpath("//*[@id='faxing-heading']/h6"));
        FaxingButton2.click();
        Thread.sleep(1000*3);

        WebElement sendFaxButton = driver.findElement(By.xpath("//*[@id='faxing']/div/ul/li[1]/a"));
        sendFaxButton.click();
        Thread.sleep(1000*5);
        /*
         *
         *
         * enter number */
        WebElement faxNumber = driver.findElement(By.xpath("//*[@name='fax_num']"));
        //long number =2222222222L ;
        faxNumber.sendKeys(String.valueOf(2222222222l));
        Thread.sleep(1000*10);

        WebElement coverPage = driver.findElement(By.xpath("//*[@id='coverpageTemplate']"));
        coverPage.click();
        Thread.sleep(1000*3);

        WebElement selectCoverPage = driver.findElement(By.xpath("//*[@id='coverpageTemplate']/option[3]"));
        selectCoverPage.click();
        Thread.sleep(1000*3);

        WebElement ClickSendButton = driver.findElement(By.xpath("//*[@id='send_fax_btn']"));
        ClickSendButton.click();
        Thread.sleep(1000*2);

        WebElement confirmationButton = driver.findElement(By.xpath("//*[@class='btn btn-orange btn-sm dialogBtn']"));
        confirmationButton.click();
        Thread.sleep(1000*2);

        WebElement uploadedElement= driver.findElement(By.xpath("//*[@class='btn btn-outline-orange btn-sm']"));
        uploadedElement.sendKeys("C:\\Users\\faxes\\Pages_2.pdf");


        Robot rb = new Robot();
        rb.delay(1000*2);
        //put the path to file in clipboard
        StringSelection Filepath =new StringSelection("C:\\Users\\faxes\\Pages_2.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filepath,null);


        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);


//        driver.navigate().back();
//        driver.close();
    }
}
//