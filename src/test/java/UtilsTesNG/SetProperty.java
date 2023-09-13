package UtilsTesNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetProperty {

    private static WebDriver driver;


    public static WebDriver getDriverTesTNG (){

        if (driver == null){
            System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver114_TestNG/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
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
