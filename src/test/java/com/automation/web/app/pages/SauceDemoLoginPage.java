package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.automation.web.helpers.WaitHelper;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoLoginPage extends BasePage {

    @Inject
    private WaitHelper waitHelper;
    @Inject
    public SauceDemoLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login;

    public void login(String usernameValue, String passwordValue)
    {
        waitHelper.waitForVisibilityOfElement(userName, 10);
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        login.click();
    }

    public void navigate() {
        driver.navigate().to("https://saucedemo.com/");
    }
}
