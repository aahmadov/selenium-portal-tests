package com.automation.web.config;

import com.automation.web.exceptions.StopTestException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main configuration for web automation test framework, which reads driver, browser and
 * other config information from bootstrap.properties and other properties files
 */
public class Configuration {
    private static final Logger LOG = Logger.getLogger(Configuration.class.getName());
    public static final String KEYBASE = "autotest";
    public static final String KEY_SELENIUM_EXCLUDED_PROPERTIES = "excluded_selenium_properties";
    // This is the full key allowing for multiple settings
    public static final String KEY_SETTINGS = ".settings";
    // This is used to ensure the settings are loaded
    public static final String KEY_LOADED = ".loaded";
    // This environment used for testing
    public static final String KEY_ENVIRONMENT = "environment";
    public static final String KEY_GRID_ENVIRONMENT = "selenium.grid.env.";
    public static final String KEY_PAGE_TIMEOUT = "timeout.page_load";
    public static final String KEY_PAGE_TIMING = "timing.page_load";
    public static final String KEY_BROWSER = "browser";
    public static final String KEY_BROWSER_VERSION = "browserversion";
    public static final String KEY_GRID_NODE = "selenium.grid.node";
    public static final String KEY_GRID_RUN = "grid.run";
    public static final String KEY_DEVICE_TYPE = "deviceType";
    public static final String KEY_APPLICATION_TYPE = "applicationtype";
    // remaining parts
    public static final String KEYP_ENV_URL = "url";
    public static final String KEYP_DEBUG_ENABLED = "debug.enabled";
    public static final String USER_AGENT = "user.agent";
    public static final String KEYP_WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String KEYP_WEBDRIVER_FIREFOX_DRIVER = "webdriver.gecko.driver";
    public static final String KEYP_WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";
    public static final String KEYP_WEBDRIVER_EDGE_DRIVER = "webdriver.edge.driver";
    public static final String KEYP_REPORTING_ENABLED = "reporting.enabled";
    public static final String KEYP_RUNNER_NAME = "runner.name";
    public static final String KEYP_RESULTS_LOCATION = "results.location";
    public static final String KEYP_BROWSER_SIZE = "browser.size";
    public static final String KEYP_DIMENSION_WIDTH = "dimensionWidth";
    public static final String KEYP_DIMENSION_HEIGHT = "dimensionHeight";
    public static final String KEY_PROJECT_NAME = "project";
    private static final String KEYP_DEBUG_ERROR_DUMP_ENABLED = "debug.error.dump.enabled";
    public static final String KEY_CUSTOM_CAPABILITIES_FLAG = "custom.capabilities";
    public static final String KEY_CHROME_CUSTOM_CAP = "chrome.custom.cap";
    public static final String KEY_CHROME_SETEXPERIMENTALOPTION = "chrome.setExperimentalOption";
    public static final String KEY_CHROME_SETACCEPTINSECURECERTS = "chrome.setAcceptInsecureCerts";
    public static final String KEY_IE_CUSTOM_CAP = "ie.custom.cap";

    private static final String[] files = new String[]{
            // The reverse order here is due to the fact they are all loaded in
            // this order and so the later ones loaded overwrite the newer ones
            // process.
            //"{user.home}/capuser.properties",
            "./bootstrap.properties"};

    public static String testCaseName = "";
    private static volatile Configuration configuration; // volatile is needed

    // so that multiple thread can reconcile the instance
    private String settings;
    private final Properties myprops;

    public Configuration() throws StopTestException {
        settings = System.getProperty(KEY_SETTINGS, null);
        myprops = new Properties(System.getProperties());
        String userhome = System.getProperty("user.home", "./");
        String loaded = myprops.getProperty(KEY_LOADED);
        if (loaded == null) {
            for (String filename : files) {
                filename = filename.replace("{user.home}", userhome);

                try (InputStream fstream = new FileInputStream(filename)) {
                    myprops.load(fstream);
                } catch (FileNotFoundException fnfe) {
                    throw new StopTestException("properties file not found");
                } catch (IOException ioe) {
                    LOG.log(Level.SEVERE, "ERROR: {0}", ioe.getMessage());
                }
            }
            myprops.putAll(System.getProperties());
        }
        if (settings == null) {
            settings = myprops.getProperty(KEY_SETTINGS, null);
        }
    }

    public static synchronized Configuration getConfiguration() throws StopTestException {
        if (configuration == null)
            configuration = new Configuration();
        return configuration;
    }

    public static synchronized void resetConfiguration() {
        configuration = null;
    }

    public void addProperties(String propertyName) {
        try (FileReader fReader = new FileReader("src/test/resources/properties/" + propertyName + ".properties")) {
            myprops.load(fReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String overrideProperty(String keypart, String value) {
        return (String) myprops.setProperty(keypart, value);
    }

    public String getProperty(String keypart) {
        return getProperty(keypart, null);
    }

    protected String getProperty(String keypart, String defaultValue) {
        String value = null;
        if (myprops != null) {

            if (settings != null && settings.length() > 0) {
                value = myprops.getProperty(settings + "."
                        + keypart);
            } else {
                value = myprops.getProperty(keypart);
            }
            if (value == null || value.length() == 0) {
                value = myprops.getProperty("default." + keypart,
                        defaultValue);
            }
        }
        return interpolate(value);
    }

    public String interpolate(String value) {
        if (null == value) {
            return value;
        }

        Pattern pattern = Pattern.compile("\\$\\{[a-zA-Z.]+}");
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            value = value.replaceAll("\\$\\{", "").replaceAll("}", "");
            value = getProperty(value);
        }

        return value;
    }

    public long getPageLoadTimeout() {
        return Long.parseLong(getProperty(KEY_PAGE_TIMEOUT));
    }

    public Boolean getPageLoadTiming() {
        return Boolean.parseBoolean(getProperty(KEY_PAGE_TIMING));
    }

    public String getScreenshotLocation(Class<?> testClass) {
        String screenshotPath = testClass.getName().replace(
                testClass.getSimpleName(), "screenshots");
        screenshotPath = screenshotPath.replaceAll("\\.", "/");
        return screenshotPath;
    }

    public String getGridRun() {
        return getProperty(KEY_GRID_RUN);
    }

    public String getApplicationType() {
        return getProperty(KEY_APPLICATION_TYPE);
    }

    public String getDeviceType() {
        return getProperty(KEY_DEVICE_TYPE);
    }

    public String getGridEnvironment(String envId) {
        return getProperty(KEY_GRID_ENVIRONMENT + envId);

    }

    public String getGridNode() {
        return getProperty(KEY_GRID_NODE);
    }

    public String getSafeBrowser() {
        try {
            return getBrowser();
        } catch (Exception e) {
            return null;
        }
    }

    public String getBrowser() {
        return getProperty(KEY_BROWSER);
    }

    public String getBrowserVersion() {
        return getProperty(KEY_BROWSER_VERSION);
    }

    public String getEnvironment() throws StopTestException {
        // get env from system properties first
        String env = getProperty(KEY_ENVIRONMENT);
        if (env == null) {
            throw new StopTestException("environment not set - please set "
                    + KEY_ENVIRONMENT);
        }
        return env;
    }

    protected String getEnvironmentsProperty(String keypart) {
        return getProperty(keypart);
    }

    public String getEnvironmentUrl() {
        return getEnvironmentsProperty(KEYP_ENV_URL);
    }

    private String addLastSlash(String value) {
        if (value != null && !value.endsWith(File.separator)) {
            value = value + "/";
        }
        return value;
    }

    /**
     * Reads the debug.enabled property
     *
     * @return the value of debug.screenshots.enabled or FALSE if not set.
     */
    public String getDebugProperty() {
        String prop = getProperty(KEYP_DEBUG_ENABLED);
        if (prop == null) {
            prop = "FALSE";
        }
        return prop;
    }

    /**
     * Evaluates the debug flag and returns a boolean.
     *
     * @return true if the autotest.debug.enabled property is set to "true", else false.
     */
    public boolean isDebug() {
        return getDebugProperty().trim().equalsIgnoreCase("true");
    }

    /**
     * @return the value of the autotest.debug.error.dump.enabled property, or FALSE if it is not set.
     */
    public String getDebugErrorDumpProperty() {
        String prop = getProperty(KEYP_DEBUG_ERROR_DUMP_ENABLED);
        if (prop == null) {
            prop = "FALSE";
        }
        return prop;
    }

    /**
     * This method will return the server name and the port number of the
     * selenium grid hub.
     *
     * @return String Server name and port number.
     */
    public URL getGridHubServerDetails() {

        //Get the API endpoint, validate the token, get the hub url from the api
        try {
            //check if there is a configuration for direct grid service
            //if so fetch it from there else continue with TaaS Grid service
            if (myprops.containsKey("direct.grid.service")) {
                String hubURL = myprops.getProperty("direct.grid.service");
                if (!hubURL.isEmpty()) {
                    return new URL(hubURL);
                }
            }
            return null;

        } catch (MalformedURLException me) {
            return null;
        }
    }

    /**
     * This method will return whether reporting has been enabled.
     *
     * @return String Server name and port number.
     */
    public String getReportingEnabled() {
        String reportingEnabled = getProperty(KEYP_REPORTING_ENABLED);

        if (reportingEnabled == null) {
            reportingEnabled = "false";
        }

        return reportingEnabled;
    }

    public String getRunnerName() throws StopTestException {
        String runnerName = getProperty(KEYP_RUNNER_NAME);

        if (runnerName == null) {
            throw new StopTestException(
                    "Unable to retrieve runner name system properties");
        }
        return runnerName;
    }

    /**
     * This method will return the location of the runner xml result files.
     *
     * @return String Server name and port number.
     * @throws StopTestException if any exception occurs
     */
    public String getResultsLocation() throws StopTestException {
        String resultsLocation = getProperty(KEYP_RESULTS_LOCATION);

        if (resultsLocation == null) {
            throw new StopTestException("Unable to retrieve results location");
        }
        return resultsLocation;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        Configuration.testCaseName = testCaseName;
    }

    public Properties getProperties() {
        Properties combinedProperties = new Properties();
        Properties existingProperties = new Properties();
        existingProperties.putAll(myprops);

        for (Object key : new HashSet<>(existingProperties.keySet())) {
            if (key.toString().startsWith(KEY_SETTINGS)) {
                combinedProperties.put(key.toString()
                                .replaceFirst(KEY_SETTINGS,
                                        KEYBASE),
                        existingProperties.get(key));
                existingProperties.remove(key);
            }
        }

        for (Object key : new HashSet<>(existingProperties.keySet())) {
            if (key.toString().startsWith("default.")) {
                combinedProperties.put(key.toString()
                                .replaceFirst("default", "."),
                        existingProperties.get(key));
                existingProperties.remove(key);
            }
        }
        combinedProperties.putAll(existingProperties);
        return combinedProperties;
    }

    public ArrayList<String> getExcludedSeleniumProperties() {
        return new ArrayList<>(Arrays.asList(
                getProperty(KEY_SELENIUM_EXCLUDED_PROPERTIES).split(
                        ",")));
    }

    /**
     * Method to get the browser size from properties if it exists
     *
     * @return the property value
     */
    public String getBrowserSize() {
        return getProperty(KEYP_BROWSER_SIZE);
    }

    public Integer getDimensionWidth() {
        return getDimensions(KEYP_DIMENSION_WIDTH);
    }

    public Integer getDimensionHeight() {
        return getDimensions(KEYP_DIMENSION_HEIGHT);
    }

    private Integer getDimensions(String dimensionType) {
        String dimensionExists = getProperty(dimensionType);
        if (dimensionExists != null) {
            return Integer.valueOf(dimensionExists);
        }
        return null;
    }

    public String getProjectName() throws StopTestException {
        // get project from system properties
        String env = getProperty(KEY_PROJECT_NAME);
        if (env == null) {
            throw new StopTestException("project name not set - please set "
                    + KEY_PROJECT_NAME);
        }
        return env;
    }

    String getUserAgent() {
        String userAgent = getProperty(USER_AGENT);
        if (userAgent != null) {
            return getProperty(USER_AGENT);
        }
        return "Selenium";
    }

    private static boolean isMac() {
        return System.getProperty("os.name").contains("Mac");
    }

    public String getKeyCustomCapabilitiesFlag() {
        return getProperty(KEY_CUSTOM_CAPABILITIES_FLAG);
    }

    public String getSetExperimentalOption() {
        return getProperty(KEY_CHROME_SETEXPERIMENTALOPTION);
    }

    public String getSetAcceptInsecureCerts() {
        return getProperty(KEY_CHROME_SETACCEPTINSECURECERTS);
    }

    public ArrayList<String> getChromeCustomCapabilities() {
        String chromeCustomCapab = getProperty(KEY_CHROME_CUSTOM_CAP);
        if (chromeCustomCapab != null) {

            return new ArrayList<>(Arrays.asList(
                    getProperty(KEY_CHROME_CUSTOM_CAP).split(
                            ";")));
        } else {
            return null;
        }
    }

    public String getIECustomCapabilities() {
        return getProperty(KEY_IE_CUSTOM_CAP);
    }
}
