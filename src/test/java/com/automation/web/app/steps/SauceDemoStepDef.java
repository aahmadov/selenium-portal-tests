package com.automation.web.app.steps;

import com.automation.web.app.pages.SauceDemoInventoryPage;
import com.automation.web.app.pages.SauceDemoLoginPage;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoStepDef {
    private final SauceDemoLoginPage sauceDemoLoginPage;
    private final SauceDemoInventoryPage sauceDemoInventoryPage;

    @Inject
    public SauceDemoStepDef(SauceDemoLoginPage sauceDemoLoginPage, SauceDemoInventoryPage sauceDemoInventoryPage) {
        this.sauceDemoLoginPage = sauceDemoLoginPage;
        this.sauceDemoInventoryPage = sauceDemoInventoryPage;
    }

    @Given("^I have sauce demo application$")
    public void GivenIHaveSauceDemoApplication() {
        sauceDemoLoginPage.navigate();
    }

    @When("^I login with (.*) and (.*)$")
    public void WhenILoginWithAnd(String username, String password) {
        sauceDemoLoginPage.login(username, password);
    }

    @Then("^login should be successful$")
    public void ThenLoginShouldBeSuccessful() {
        sauceDemoInventoryPage.verifyPageLoad();
    }
}
