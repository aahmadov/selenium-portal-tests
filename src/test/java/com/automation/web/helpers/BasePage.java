package com.automation.web.helpers;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

@Slf4j
public class BasePage {
    protected static final String WEBDRIVER_FAILED = "Webdriver failed.....";
    protected static final int DEFAULT_WAIT_TIMEOUT_SECS = 20;
    protected static final long WAIT_FOR_PAGE_LOADED_DELAY = 20000;
    String parentWindow = null;

    @Inject
    protected WebDriver driver;

    @Inject
    private WaitHelper waitHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearBrowserCache(){
        driver.manage().deleteAllCookies();
    }

    /**
     * Navigate toi frame by seconds boolean.
     *
     * @param seconds    the seconds
     * @param iframeName the iframe name
     * @return the boolean
     */
    public boolean navigateToiFrameBySeconds(long seconds, String iframeName) {
        explicitWait(seconds).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeName));
        return true;
    }

    /**
     * Added to ensure that the elements on the  page are completely stable after loading
     * and therefore clickable at right position
     * before the operations are resumed further
     *
     * @param element element for which Webdriver needs to wait
     * @throws TimeoutException if exception occurs
     */

    public void waitForPageToBecomeStable(WebElement element)
            throws TimeoutException {
//        element.waitUntilVisible();
//        visibilityOfElement(element, DEFAULT_TIMEOUT);
        boolean isStable = false;
        int count = 0;
        Point point = element.getLocation();
        while (!isStable) {
            if (point.getX() == element.getLocation().getX()
                    && point.getY() == element.getLocation().getY()) {
                count++;
            } else {
                count = 0;
                point = element.getLocation();
            }

            if (count == 10) {
                isStable = true;
            }

            try {
                // sleep for 100ms to give page a little time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.warn(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Added to ensure that the Page is completely loaded
     * so that the elements can be used
     */

    public void waitForPageLoaded() {
        final LocalDateTime start = LocalDateTime.now();

        try {
            log.info("waitForPageLoaded on thread: {}", Thread.currentThread());
            explicitWait(DEFAULT_WAIT_TIMEOUT_SECS).until((localDriver) ->
                    //new DateTime().isAfter(start.plus(WAIT_FOR_PAGE_LOADED_DELAY)) &&
                    LocalDateTime.now().isAfter(start.plusSeconds(WAIT_FOR_PAGE_LOADED_DELAY / 1000)) &&
                            ((JavascriptExecutor) localDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception ex) {
            log.info("waitForPageLoaded timeout on thread: {}", Thread.currentThread());
            log.info("Timeout waiting for Page Load Request to complete. {}", ex.getMessage());
        }
    }

    /***
     * Waits until the dropdown gets populated with all the options
     * @param select WebDriver Select element to be sent to this method
     *               which waits till the options in the dropdown are retrieved.
     *
     */
    public void waitForDropdownToBePopulated(Select select) {
        explicitWait(DEFAULT_WAIT_TIMEOUT_SECS).until(wd -> !select.getOptions().isEmpty());
    }

    /***
     *
     * @param webElement WebElement of the dropdown to be sent
     * @return True if there are values displayed in the dropdown otherwise false
     */
    public boolean checkSelectOptionsNotEmpty(WebElement webElement) {
        return new Select(webElement).getOptions().isEmpty();

    }

    /**
     * @param milliseconds the milliseconds
     */
    public void sleep(long milliseconds) {
        long end_time = System.currentTimeMillis() + milliseconds;
        while (System.currentTimeMillis() < end_time) {
        }
    }

    /**
     * @param element the element
     */
    public void hover(WebElement element) {
        Actions action = new Actions(driver);
        // move to the element to hover
        action.moveToElement(element).build().perform();
        sleep(300);
    }

    /**
     * This method return the browser page title
     *
     * @return title This is string text
     */
    public String getPageTitle() {
        return driver.getTitle();
    }


    /**
     * This method checks for element present
     *
     * @param by This is locator
     * @return boolean
     */
    public boolean isElementPresentAndDisplayed(final By by) {
        sleep(500L);
        boolean isPresent = false;

        if (driver.findElements(by).size() > 0) {
            Dimension d = driver.findElement(by).getSize();
            boolean isVisible = d.getHeight() > 0 && d.getWidth() > 0;

            if (isVisible) {
                String elementStyle = driver.findElement(by).getAttribute("style");
                isPresent = !(elementStyle.equals("display: none;") || elementStyle.equals("visibility: hidden;"));
            }
        }

        return isPresent;
    }

    /**
     * This method checks for attribute
     *
     * @param attribute This is string text
     * @param element   This is web element
     * @return boolean
     */
    public boolean isAttributePresent(WebElement element, String attribute) {
        try {
            String value = element.getAttribute(attribute);
            return value != null;
        } catch (Exception e) {
            log.warn("Element not available in 'isAttributePresent' method");
        }

        return false;
    }

    /**
     * This method scroll down of the page
     *
     * @throws AssertionError Assertion error
     */
    public void scrollDown() {
        try {
            getWebDriverJSExecutor().executeScript("window.scrollBy(0, document.body.scrollHeight || document.documentElement.scrollHeight)", "");
            sleep(100);
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method scroll up of the page
     *
     * @throws AssertionError Assertion error
     */
    public void scrollUp() {
        try {
            getWebDriverJSExecutor().executeScript("window.scrollBy(0, -document.body.scrollHeight || -document.documentElement.scrollHeight)", "");
            sleep(100);
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * Click position xin element.
     *
     * @param element the element
     */
    public void clickPositionXinElement(WebElement element) {
        getWebDriverJSExecutor().executeScript("window.scrollTo(0," + element.getLocation().x + ")");
        element.click();
        sleep(200);
    }

    /**
     * Click using javascript.
     *
     * @param element the element
     */
    public void clickUsingJavascript(WebElement element) {
        getWebDriverJSExecutor().executeScript("arguments[0].click()", element);
    }

    /**
     * Type using javascript.
     *
     * @param element the element
     * @param text    the text
     */
    public void typeUsingJavascript(WebElement element, String text) {
        getWebDriverJSExecutor().executeScript("arguments[0].value = '" + text + "'", element);
    }

    /**
     * Scroll view using javascript.
     *
     * @param element the element
     */
    public void scrollViewUsingJavascript(WebElement element) {
        getWebDriverJSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scroll to element with javascript.
     *
     * @param element the element
     */
    public void scrollToElementWithJavascript(WebElement element) {
        getWebDriverJSExecutor().executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Gets element by query js executor.
     *
     * @param cssSelector the css selector
     * @return the element by query js executor
     */
    public String getElementByQueryJSExecutor(String cssSelector) {
        return getWebDriverJSExecutor().executeScript(
                "return window.getComputedStyle(document.querySelector('"
                        + cssSelector + "'))").toString();
    }

    /**
     * Click css element.
     *
     * @param cssLocator the css locator
     */
    public void clickCssElement(String cssLocator) {
        getWebDriverJSExecutor().executeScript("document.querySelector('" + cssLocator + "').click()");
    }


    /**
     * This method refresh the browser
     */
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    /**
     * This method quit the browser
     */
    public void closeBrowseDriver() {
        try {
            driver.quit();
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * @param element - AndroidElement, MobileElement, WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     */
    public void clickElement(WebElement element, long seconds) {
        try {
            explicitWait(seconds).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            log.error("Element not found {}", e.getLocalizedMessage());
            fail("Element not clickable: " + e.getLocalizedMessage());
        }
    }

    /**
     * @param element - WebElement, AndroidElement, MobileElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     *                Syntax: Common.isElementDisplayed(element, WaitType.ExplicitWait, TimeDuration.defaultWait.inSeconds)
     */
    public boolean isElementDisplayed(WebElement element, long seconds) {
        try {
            explicitWait(seconds).until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            log.error("Element not found. Exception: {}", e.getLocalizedMessage());
            return false;
        }
    }

    /**
     * @param element - AndroidElement, MobileElement, WebElement
     * @param value   - Variable - to be typed into Text Fields
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     *                Syntax: Common.sendKeys(element, variable, WaitType.FluentWait, TimeDuration.DefaultWait.inSeconds)
     */
    public void sendKeys(WebElement element, String value, long seconds) {
        try {
            explicitWait(seconds).until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
        } catch (Exception e) {
            log.error("Element not found {}", e.getLocalizedMessage());
            fail("Element not visible: " + e.getLocalizedMessage());
        }
    }

    /**
     * @param element - AndroidElement, MobileElement, WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @return Syntax: getText(element, TimeDuration.DefaultWait.inSeconds());
     */
    public String getText(WebElement element, long seconds) {
        try {
            explicitWait(seconds).until(ExpectedConditions.visibilityOf(element));
            if (element.getText() != null) {
                return element.getText();
            }
            log.info("Text value: {}", element.getText());
        } catch (Exception e) {
            log.error("getText | Element Not Found. Exception: {}", e.getLocalizedMessage());
            fail("getText | Element Not Found" + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * @param element - WebElement, AndroidElement, MobileElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param value   - String value
     * @return - Boolean value
     */
    public boolean verifyText(WebElement element, long seconds, String value) {
        explicitWait(seconds).until(ExpectedConditions.visibilityOf(element));
        return element.getText().contains(value);
    }

    /**
     * Returns list of webelements - text values will be added in Array List
     *
     * @param element - WebElement, AndroidElement, MobileElement
     * @return - list of values (String)
     */
    public List<String> getListOfValues(List<WebElement> element) {
        return element.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * This method select by text
     *
     * @param by   This is web locator
     * @param text This is string text
     */
    public void selectDropDownByText(String text, By by) {
        Select dropdown = new Select(waitHelper.waitForVisibilityOfElementByPolling(by));
        dropdown.selectByVisibleText(text);
    }


    /**
     * This method select by index
     *
     * @param by This is web locator
     * @param id This is index id
     */
    public void selectDropDownByIndex(int id, By by) {
        Select dropdown = new Select(waitHelper.waitForVisibilityOfElementByPolling(by));
        dropdown.selectByIndex(id);
    }

    /**
     * This method return String value
     *
     * @param element This is web element
     * @return Lists of values
     * @throws AssertionError Assertion error
     */
    public <T extends WebElement> String getSelectedValue(T element) {
        try {
            Select select = new Select(element);
            return select.getFirstSelectedOption().getText();
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method return select List
     *
     * @param locator This is web locator
     * @return Lists of values
     * @throws AssertionError Assertion error
     */
    public List<String> getSelectedDropdownItems(By locator) {
        try {
            return driver.findElements(locator).stream().map(this::getSelectedValue).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method return select List
     *
     * @param element This is web element
     * @return Lists of values
     * @throws AssertionError Assertion error
     */
    public List<String> getDropDownValues(WebElement element) {
        try {
            Select select = new Select(element);
            return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method return browser instance using script executor
     *
     * @return JavascriptExecutor This is browser inbuilt script executor
     */
    public JavascriptExecutor getWebDriverJSExecutor() {
        return (JavascriptExecutor) driver;
    }

    /**
     * This method switch to a child window
     */
    public void switchToPopUpWindow() {
        try {
            parentWindow = driver.getWindowHandle();
            int count = 20;
            while (count-- > 0) {
                if (driver.getWindowHandles().size() > 1) {
                    break;
                }
                sleep(500L);
            }
            if (driver.getWindowHandles().size() == 1) {
                closeBrowseDriver();
                throw new AssertionError("Child Popup window is not detected by Selenium");
            } else {
                Set<String> handles = driver.getWindowHandles();
                for (String windowHandle : handles) {
                    if (!windowHandle.equals(parentWindow)) {
                        driver.switchTo().window(windowHandle);
                        log.info("Driver has switched to child window successfully ");
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            closeBrowseDriver();
            throw new AssertionError("WebDriver failed...");
        }
    }

    /**
     * This method will to switch back parent window
     *
     * @throws AssertionError Assertion error
     */
    public void switchBackToParentWindow() {
        if (parentWindow != null) {
            int count = 5;
            while (count-- > 0) {
                driver.switchTo().window(parentWindow);
                sleep(500L);
                if (driver.getWindowHandle().equalsIgnoreCase(parentWindow)) {
                    break;
                }
            }
        } else {
            closeBrowseDriver();
            throw new AssertionError("\nYou are not on a child pop up window\n");
        }
    }

    /**
     * This method switch to a Main window using session id
     *
     * @param sessionId This is string text
     * @throws AssertionError Assertion error
     */
    public void switchToMainWindow(String sessionId) {
        try {
            driver.switchTo().window(sessionId);
            driver.switchTo().defaultContent();
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method switch to a Main window using handles
     */
    public void switchToDefaultWindow() {
        if (driver.getWindowHandles().size() >= 1) {
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
        }
    }

    public void closeSurveyPopUpIfExist(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> closeSurveyPopUp = driver.findElements(By.id("fsrFocusFirst"));
        if (!(closeSurveyPopUp.isEmpty())) {
            sleep(500);
            driver.findElement(By.id("fsrFocusFirst")).click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    /**
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @return WebDriverWait
     */
    public WebDriverWait explicitWait(long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofMillis(500));
        return wait;
    }

    /**
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @return Wait<AppiumDriver>
     */
    public Wait<WebDriver> fluentWait(long seconds) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(WebDriverException.class);
    }
}

