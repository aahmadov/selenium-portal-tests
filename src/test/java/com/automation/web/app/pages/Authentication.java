package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authentication extends BasePage {

    @FindBy(name = "username")
    private WebElement userNameEdit;

    @FindBy(name = "j_password")
    private WebElement passwordEdit;

    @FindBy(name = "loginBtn")
    private WebElement loginButton;

    @Inject
    public Authentication(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        userNameEdit.sendKeys(userName);
        passwordEdit.sendKeys(password);
        loginButton.click();
    }
}
