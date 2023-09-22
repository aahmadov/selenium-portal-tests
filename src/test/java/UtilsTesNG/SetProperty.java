package UtilsTesNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SetProperty {

    private static WebDriver driver;

    public static WebDriver getDriverTesTNG (){


        if (driver == null){
//            System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver114_TestNG/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//            System.setProperty("webdriver.gecko.driver","src/test/resources/geckoDriver/geckodriver.exe");
//            driver = new FirefoxDriver();
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
