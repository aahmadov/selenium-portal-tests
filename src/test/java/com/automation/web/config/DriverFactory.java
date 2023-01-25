package com.automation.web.config;

import com.automation.web.exceptions.StopTestException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * PageFactory provides functions to create WebDriver instance, handle cookies,
 * define browser capabilities for different browsers
 */
public class DriverFactory {
    private static WebDriver driver = null;

    public static Object getPage(String pageClassName)
            throws StopTestException {

        // removed until all pages have been split, can then be brought back
        // with the if statement below being removed
        // else {
        // pageClassName = pageClassName + "Web";
        // }
        Object page;
        try {
            Class<?> pageClass = Class.forName(pageClassName);
            // if statement below is to allow non split pages to work until all
            // pages have been split
            if (pageClass.isInterface()) {
                pageClassName = pageClassName + "Web";
                pageClass = Class.forName(pageClassName);
            }
//            LoggingHelper.printDebug("Loading page: " + pageClassName);
            Constructor<?> constructor = pageClass
                    .getConstructor(WebDriver.class);
            page = constructor.newInstance(getDriver());
        } catch (Exception ex) {
            throw new StopTestException(
                    "could not get page : " + pageClassName);
        }
        return page;
    }

    /**
     * Method tp switch to an iframe on a page - elements inside an iFrame cannot be accessed unless
     * the driver switches to inside the iFrame
     *
     * @param element element to which the Webdriver switch to
     */
    public static void switchToIframe(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    /**
     * Create WebDriver instance if it doesn't exist yet
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        driver.getTitle();
        return driver;
    }

    /**
     * Get currently used driver instance and don't create new one if it doesn't
     * exists
     *
     * @return current driver
     */
    public static WebDriver getCurrentDriver() {
        return driver;
    }

    /**
     * Kills WebDriver instance if it exists
     */
    public static void tearDown() {
        if (driver != null) {

            try {
                TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
            } catch (Exception e1) {
                // Ignore
            }
            try {
                driver.manage().deleteAllCookies();
            } catch (Exception e) {
                // Ignore
            }

            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println(
                        "In tearDown() - Exception thrown when attempting driver.quit() " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    /**
     * Creates WebDriver instance and opens ie browser
     */
    public static void setUp() {
        // changing default browser to Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("geo.enabled", false);
        options.addPreference("geo.prompt.testing", false);
        options.addPreference("geo.prompt.testing.allow", false);
        options.setAcceptInsecureCerts(true);
    }

    public static void deleteAllCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    public static void deleteNamedCookie(String cookieName) {
        if (driver != null) {
            driver.manage().deleteCookieNamed(cookieName);
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Ignore
            }
        }
    }

    public static void refocusDriver() {
        if (driver != null) {
            try {
                driver.switchTo().defaultContent();
            } catch (Exception e) {
                // Ignore
            }
        }
    }

    public static void addCookie(String key, String value) {
        WebDriver driver = DriverFactory.getCurrentDriver();
        Cookie newCookie = new Cookie(key, value);
        driver.manage().addCookie(newCookie);
        System.out.println(key + "Cookie Added: " + driver.manage().getCookieNamed(key).toString());
    }

    /**
     * Adding Cookie wherein we specify the domain as well
     *
     * @param key    key value of the cookie
     * @param value  cookie value
     * @param domain domain name
     */
    public static void addCookie(String key, String value, String domain) {
        WebDriver driver = DriverFactory.getCurrentDriver();
        Cookie newCookie = new Cookie(key, value, domain, null, null);
        driver.manage().addCookie(newCookie);
    }

    /**
     * This method returns the value of the name cookie
     *
     * @param cookieName cookie name for which the value to be returned
     * @return cookie value
     */
    public static String readCookieValue(String cookieName) {
        Cookie cookie;
        WebDriver driver = DriverFactory.getCurrentDriver();

        cookie = driver.manage().getCookieNamed(cookieName);
        if (cookie != null)
            return cookie.getValue();

        return null;
    }

    /**
     * Create Chrome WebDriver instance after closing other driver instances
     *
     * @return chrome driver
     * @throws MalformedURLException if any exception occurs
     * @throws StopTestException     if any exception occurs
     */
    public static WebDriver getChromeWebDriver() throws MalformedURLException,
            StopTestException {
        if (driver != null) {
            if (!(driver instanceof ChromeDriver)) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    // Ignore
                }
            }
        }

        try {
            Objects.requireNonNull(driver).getTitle();
            return driver;
        } catch (Exception e) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static WebDriver getSafariWebDriver() throws MalformedURLException,
            StopTestException, JSONException {
        if (driver != null) {
            if (!(driver instanceof SafariDriver)) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    // Ignore
                }
            }
        }

        try {
            Objects.requireNonNull(driver).getTitle();
            return driver;
        } catch (Exception e) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver(getSafariOptions());
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static WebDriver getIEWebDriver() throws MalformedURLException,
            StopTestException, JSONException {
        // Check to see if internet explorer is the current driver quit if not
        if (driver != null) {
            if (!(driver instanceof InternetExplorerDriver)) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    // Ignore
                }
            }
        }

        try {
            Objects.requireNonNull(driver).getTitle();
            return driver;
        } catch (Exception e) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver(getIEOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
        }

        return driver;
    }

    /**
     * Create Firefox WebDriver instance after closing other driver instances
     *
     * @return firefoxdriver
     * @throws StopTestException if any exception occurs
     */
    public static WebDriver getFireFoxDriver() throws StopTestException, JSONException {
        // Check to see if firefox is the current driver quit if not
        if (driver != null) {
            if (!(driver instanceof FirefoxDriver)) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    // Ignore
                }
            }
        }

        // See if firefox driver is running if not start a firefox driver
        try {
            Objects.requireNonNull(driver).getTitle();
            return driver;
        } catch (Exception e) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(getFirefoxOptions());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }

        return driver;
    }

    /**
     * Create Edge WebDriver instance after closing other driver instances
     *
     * @return edgedriver
     * @throws StopTestException if any exception occurs
     */
    public static WebDriver getEdgeDriver() throws StopTestException, JSONException {
        // Check to see if edge is the current driver quit if not
        if (driver != null) {
            if (!(driver instanceof EdgeDriver)) {
                try {
                    driver.quit();
                } catch (Exception e) {
                    // Ignore
                }
            }
        }

        try {
            Objects.requireNonNull(driver).getTitle();
            return driver;
        } catch (Exception e) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(getEdgeOptions());
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    private static JSONArray getIECapabilities() throws JSONException {
        //Creating default IE capabilities in Json Array
        JSONArray ieDefaultCapabilities = new JSONArray();
        ieDefaultCapabilities.put(new JSONObject()
                .put("platform", "WINDOWS")
                .put("InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", "true")
                .put("InternetExplorerDriver.REQUIRE_WINDOW_FOCUS", "true")
                .put("ie.ensureCleanSession", "true")
                .put("InternetExplorerDriver.IE_SWITCHES", "-private")
                .put("ignoreZoomSetting", "true")
                .put("nativeEvents", "true")
                .put("ignoreProtectedModeSettings", "true")
                .put("disable-popup-blocking", "true")
                .put("enablePersistentHover", "true")
                .put("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", "true")
                .put("ignoreZoomSetting", "true")
                .put("unhandledPromptBehavior", "accept")
                .put("unexpectedAlertBehaviour", "accept"));

        return ieDefaultCapabilities;
    }

    private static ChromeOptions getChromeOptions() throws StopTestException {
        ChromeOptions options = new ChromeOptions();

        List<String> chromeOptions = getChromeCapabilities();

        for (String chromeOption : chromeOptions) {
            options.addArguments(chromeOption);
        }
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true);

        if (Configuration.getConfiguration().getBrowserVersion() != null && !Configuration.getConfiguration().getBrowserVersion().equals(""))
            options.setCapability("version", Configuration.getConfiguration().getBrowserVersion());

        return options;
    }

    private static List<String> getChromeCapabilities() throws StopTestException {
        List<String> ChromeDefaultOptions = new ArrayList<>();
        ChromeDefaultOptions.add("enable-automation");
        ChromeDefaultOptions.add("--disable-infobars");
        ChromeDefaultOptions.add("--start-maximized");
        ChromeDefaultOptions.add("--disable-popup-blocking");
        List<String> ChromeCustomCapabilities = Configuration.getConfiguration().getChromeCustomCapabilities();
        if (ChromeCustomCapabilities != null) {
            for (String chromeCustomCapability : ChromeCustomCapabilities)
                for (int j = 0; j < ChromeDefaultOptions.size(); j++) {
                    if (ChromeDefaultOptions.contains(chromeCustomCapability)) {
                        ChromeDefaultOptions.remove(chromeCustomCapability);
                        ChromeDefaultOptions.add(chromeCustomCapability);
                    } else {
                        ChromeDefaultOptions.add(chromeCustomCapability);
                    }
                }
        }
        return ChromeDefaultOptions;
    }


    private static EdgeOptions getEdgeOptions() throws StopTestException, JSONException {
        EdgeOptions options = new EdgeOptions();

        JSONArray EdgeCapabilities = getEdgeCapabilities();
        for (int i = 0; i < EdgeCapabilities.length(); i++) {
            JSONObject json = EdgeCapabilities.getJSONObject(i);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                options.setCapability(key, json.get(key));
            }
        }
        if (Configuration.getConfiguration().getBrowserVersion() != null && !Configuration.getConfiguration().getBrowserVersion().equals(""))
            options.setCapability("version", Configuration.getConfiguration().getBrowserVersion());
        options.setAcceptInsecureCerts(true);
        return options;
    }

    private static InternetExplorerOptions getIEOptions() throws StopTestException, JSONException {
        InternetExplorerOptions options = new InternetExplorerOptions();
        JSONArray IECapabilities = getIECapabilities();
        for (int i = 0; i < IECapabilities.length(); i++) {
            JSONObject json = IECapabilities.getJSONObject(i);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                options.setCapability(key, json.get(key));
            }
        }
        if (Configuration.getConfiguration().getBrowserVersion() != null && !Configuration.getConfiguration().getBrowserVersion().equals(""))
            options.setCapability("version", Configuration.getConfiguration().getBrowserVersion());

        options.setAcceptInsecureCerts(true);
        return options;
    }


    private static SafariOptions getSafariOptions() throws StopTestException {
        SafariOptions options = new SafariOptions();
        options.setUseTechnologyPreview(false);
        options.setAcceptInsecureCerts(true);
        if (Configuration.getConfiguration().getBrowserVersion() != null && !Configuration.getConfiguration().getBrowserVersion().equals(""))
            options.setCapability("version", Configuration.getConfiguration().getBrowserVersion());

        return options;
    }

    private static FirefoxOptions getFirefoxOptions() throws StopTestException, JSONException {
        FirefoxOptions options = new FirefoxOptions();
        JSONArray FirefoxCapabilities = getFirefoxCapabilities();
        for (int i = 0; i < FirefoxCapabilities.length(); i++) {
            JSONObject json = FirefoxCapabilities.getJSONObject(i);
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                options.setCapability(key, json.get(key));
            }
        }
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        options.setAcceptInsecureCerts(true);
        options.setProfile(profile);
        if (Configuration.getConfiguration().getBrowserVersion() != null && !Configuration.getConfiguration().getBrowserVersion().equals(""))
            options.setCapability("version", Configuration.getConfiguration().getBrowserVersion());

        return options;
    }

    private static JSONArray getFirefoxCapabilities() throws JSONException {
        JSONArray firefoxDefaultCapabilities = new JSONArray();
        firefoxDefaultCapabilities.put(new JSONObject()
                .put("nete.custom.capwork.proxy.type", "5")
                .put("network.http.phishy-userpass-length", "255")
        );

        return firefoxDefaultCapabilities;
    }

    private static JSONArray getEdgeCapabilities() throws JSONException {
        JSONArray EdgeDefaultCapabilities = new JSONArray();
        EdgeDefaultCapabilities.put(new JSONObject()
                .put("CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION", "true")
                .put("CapabilityType.ACCEPT_SSL_CERTS", "true")
        );
        return EdgeDefaultCapabilities;
    }
}
