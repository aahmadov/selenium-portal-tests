package com.automation.web.helpers;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Slf4j
public class KeyboardActions {

    @Inject
    public WebDriver driver;

    //To generate random alphanumeric characters of specified number of characters
    public static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";

    public String getRandomAlphaNumericValues(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int characterPosition = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(characterPosition));
        }
        return builder.toString();
    }

    //To enter Tab Key specified number of times
    public void enterTabKey(String count) {
        for (int i = 0; i < Integer.parseInt(count); i++) {
            Actions act = new Actions(driver);
            act.sendKeys(Keys.TAB).perform();
        }
    }

    //To use enter key specified number of times
    public void enterKey(String count) {
        for (int i = 0; i < Integer.parseInt(count); i++) {
            Actions act = new Actions(driver);
            act.sendKeys(Keys.ENTER).perform();
        }
    }

    //To enter arrow down key specified number of times
    public void enterArrowDown(String count) {
        for (int i = 0; i < Integer.parseInt(count); i++) {
            Actions act = new Actions(driver);
            act.sendKeys(Keys.ARROW_DOWN).perform();
        }
    }

    //To enter arrow up key specified number of times
    public void enterArrowUp(String count) {
        for (int i = 0; i < Integer.parseInt(count); i++) {
            Actions act = new Actions(driver);
            act.sendKeys(Keys.ARROW_UP).perform();
        }
    }
}
