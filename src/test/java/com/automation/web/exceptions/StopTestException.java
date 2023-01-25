package com.automation.web.exceptions;

/**
 * Exception which shall be thrown in order to stop execution of current test
 */
public class StopTestException extends Exception {

    private static final long serialVersionUID = 1L;

    private String screenshot;

    private boolean screenshotFlag = false;

    public StopTestException(String message, boolean screenshot) {
        screenshotFlag = screenshot;
        this.initCause(new Throwable(message));
    }

    public StopTestException(String message, Throwable exception) {
        super(message, exception);
    }

    public StopTestException(String message) {
        super(message);
    }

    public StopTestException(String messageFormat, Object... arguments) {
        this(String.format(messageFormat, arguments));
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public boolean isScreenshotFlag() {
        return screenshotFlag;
    }

    public void setScreenshotFlag(boolean screenshotFlag) {
        this.screenshotFlag = screenshotFlag;
    }
}
