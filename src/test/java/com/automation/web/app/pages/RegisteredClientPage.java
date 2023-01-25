package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisteredClientPage extends BasePage {

    @Inject
    public RegisteredClientPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Secondary_Navbar")
    private WebElement userNameToggle;

    public void VerifyUserLoggedInAfterSignup()
    {
        userNameToggle.isDisplayed();
    }
}
