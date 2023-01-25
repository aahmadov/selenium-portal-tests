package com.automation.web.app.steps;

import com.automation.web.app.pages.Authentication;
import com.automation.web.app.pages.HomePage;
import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStepDef {

    private final HomePage homePage;

    private final Authentication authentication;

    @Inject
    public HomePageStepDef(HomePage homePage, Authentication authentication) {
        this.homePage = homePage;
        this.authentication = authentication;
    }

    @Given("^customer opened homepage$")
    public void launchHomePage() {
        homePage.navigate();
    }

    @And("^customer accept cookies by clicking on Ok I understand$")
    public void acceptCookie() {
        homePage.clickOnIUnderstandToAcceptCookie();
    }

    @And("^customer selects (.*) and (.*) from All products menu$")
    public void selectSubMenuFromAllProducts(String mainProduct, String subProduct) {
        homePage.clickOnAllProducts();
        homePage.moveOnToMainProductTypeFromAllProductsMenuAndSelectSubProduct(mainProduct, subProduct);
    }

    @And("^customer will login with username (.*) and password (.*)$")
    public void login(String username, String password) {
        homePage.clickLogin();
        authentication.login(username, password);
    }

    @And("^verify customer is logged in by checking customers name which should be displayed As (.*)$")
    public void verifyGreeting(String customerName) {
        homePage.verifyGreeting(customerName);
    }

    @And("^customer selects (.*) from Our Brands$")
    public void selectBrand(String brandName) {
        homePage.clickOnSpecificBrandFromOurBrands(brandName.trim());
    }

    @When("^customer search for (.*) and click search icon$")
    public void searchForGivenTermAndClickSearchIcon(String searchTerm) {
        homePage.enterSearchTermAndClickOnSearchIcon(searchTerm);
    }

    @When("^customer search for (.*) and do NOT click on search Icon$")
    public void searchForGivenTermOnly(String searchTerm) {
        homePage.enterSearchTermOnly(searchTerm);
    }

    @And("^customer selects search hint category (.*)$")
    public void selectSearchResultsFromHintCategory(String category) {
        homePage.selectHintResultCategory(category);
    }

}
