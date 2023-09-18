package UtilsTesNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetProperty {

    private static WebDriver driver;

    public static WebDriver getDriverTesTNG (){
        //WebDriverManager.chromedriver().setup();

        if (driver == null){
//            System.setProperty("webdriver.chrome.driver","src/test/resources/OldDriver/chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//            driver = new ChromeDriver(options);
            System.setProperty("webdriver.gecko.driver","src/test/resources/geckoDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void closeDriverTestNG() {
        if(driver!=null) {
            driver.quit();
            driver= null;
        }


    }
}
