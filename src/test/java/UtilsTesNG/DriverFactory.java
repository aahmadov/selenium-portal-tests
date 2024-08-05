package UtilsTesNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {


        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver114_TestNG/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
//            options.addArguments("--headless");  // Run in headless mode if needed
            options.addArguments("--disable-gpu");  // Disable GPU hardware acceleration
            options.addArguments("--disable-extensions");  // Disable extensions
            options.addArguments("--remote-allow-origins=*");  // Use this argument if necessary


//            options.setAcceptInsecureCerts(true);
//            options.addArguments("--remote-allow-origins=*");

            if (ConfigReader.getProperty("testLocation").equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            } else {
                try {
                    RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                    remoteWebDriver.setFileDetector(new LocalFileDetector());
                    driver = remoteWebDriver;

                } catch (MalformedURLException e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//            System.setProperty("webdriver.gecko.driver","src/test/resources/geckoDriver/geckodriver.exe");
//            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }
}
