package com.automation.web.helpers;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    private final int DEFAULT_WAIT_TIMEOUT_SECS = 20;
    private final int DEFAULT_TIMEOUT = 30000;
    private final String WEBDRIVER_FAILED = "Webdriver failed.....";

    @Inject
    private WebDriver driver;

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     */
    public void waitForElementToBeClickable(WebElement element, long seconds) {
        explicitWait(seconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     */
    public void waitForVisibilityOfElement(WebElement element, long seconds) {
        explicitWait(seconds).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method wait for In visibility Of element
     *
     * @param by This is web locator
     * @return boolean
     * @throws AssertionError Assertion error
     */
    public boolean waitForElementByInvisibility(By by) {
        try {
            return explicitWait(DEFAULT_WAIT_TIMEOUT_SECS).until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method wait for visibility Of element located
     *
     * @param by This is web locator
     * @return WebElement This is web element
     * @throws AssertionError Assertion error
     */
    public WebElement waitForVisibilityOfElementByPolling(final By by) {
        try {
            return explicitWait(DEFAULT_WAIT_TIMEOUT_SECS).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * This method wait for visibility Of all elements located
     *
     * @param by This is web locator
     * @return WebElement This is List of web element
     * @throws AssertionError Assertion error
     */
    public List<WebElement> waitForElementsByPolling(final By by) {
        try {
            return explicitWait(DEFAULT_WAIT_TIMEOUT_SECS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception ex) {
            throw new AssertionError(WEBDRIVER_FAILED + ex.getLocalizedMessage());
        }
    }

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     *                Syntax: WaitHelper.invisibilityOf(element, WaitType.ExplicitWait, TimeDuration.defaultWait.inSeconds)
     */
    public void waitForInvisibilityOfElement(WebElement element, long seconds) {
        explicitWait(seconds).until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     */
    public void waitForAlertToPresent(long seconds) {
        explicitWait(seconds).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     */
    public void waitForElementToBeSelected(WebElement element, long seconds) {
        explicitWait(seconds).until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param value   - true to false
     */
    public void waitForTextToBePresentInElement(WebElement element, long seconds, String value) {
        explicitWait(seconds).until(ExpectedConditions.textToBePresentInElement(element, value));
    }

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param flag    - true to false
     */
    public void waitForElementSelectionStateToBe(WebElement element, long seconds, boolean flag) {
        explicitWait(seconds).until(ExpectedConditions.elementSelectionStateToBe(element, flag));
    }

    /**
     * @param element - WebElement
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param value   - Text Value
     */
    public void waitForTextToBePresentInElementValue(WebElement element, long seconds, String value) {
        explicitWait(seconds).until(ExpectedConditions.textToBePresentInElementValue(element, value));
    }

    /**
     * @param element   - WebElement
     * @param seconds   - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param attribute - Attribute locator value
     * @param value     - Assigned value for that particular attribute
     */
    public void waitForElementAttributeContainsValue(WebElement element, long seconds, String attribute, String value) {
        explicitWait(seconds).until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    /**
     * @param element   - WebElement
     * @param seconds   - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param attribute - Attribute locator value
     * @param value     - Assigned value for that particular attribute
     */
    public void waitForElementAttributeToBe(WebElement element, long seconds, String attribute, String value) {
        explicitWait(seconds).until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    /**
     * Verifies if attribute value is empty or not
     *
     * @param element   - WebElement
     * @param seconds   - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @param attribute - Attribute value
     */
    public void waitForElementAttributeToBeNotEmpty(WebElement element, long seconds, String attribute) {
        explicitWait(seconds).until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    /**
     * Wait until element is gone.
     *
     * @param element the element
     */
    public void waitUntilElementIsGone(WebElement element) {
        if (element.isDisplayed()) {
            explicitWait(30).until(ExpectedConditions.invisibilityOf(element));
        }
    }

    /**
     * This method waits for element to get enabled with the help of web driver. This puts element in to cache which
     * resolves StaleElementReferenceException issue for page elements
     *
     * @param element This is web element, where enable check happens for this page element
     * @param seconds This is time unit integer value which considers value in seconds
     */
    public void waitForElementToBecomeEnabled(WebElement element, int seconds) {
        explicitWait(seconds).until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForInvisibility(WebElement webElement, int maxSeconds) {
        long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && webElement.isDisplayed()) {
            }
        } catch (StaleElementReferenceException ignored) {
        }
    }

    /**
     * @param seconds - GenericWait(3), CommonWait(5), DefaultWait(10), ExtendedWait(20), LongWait(60)
     * @return WebDriverWait
     */
    private WebDriverWait explicitWait(long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofMillis(500));
        return wait;
    }
}
