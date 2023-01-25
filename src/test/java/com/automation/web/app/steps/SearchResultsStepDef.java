package com.automation.web.app.steps;

import com.automation.web.app.pages.SearchResults;
import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchResultsStepDef {

    private final SearchResults searchResults;

    @Inject
    public SearchResultsStepDef(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    @And("^customer selects top category (.*)$")
    public void selectGivenTopCategoryFromSearchResults(String searchResultTopCategory) {
        searchResults.clickOnGivenTopCategoryInSearchResults(searchResultTopCategory);
    }

    @And("^customer applies main filter (.*) and sub filter (.*) and close sub filter popup$")
    public void selectMainFilterAndSubFilterAndCloseFilterPopUp(String mainFilter, String subFilter) {
        selectMainFilterAndSubFilter(mainFilter, subFilter);
        searchResults.closeSubFilterPopUp();
    }

    @And("^customer clicks on Apply Filters on sub category filter pop-up$")
    public void applyFilterFromFilterPopUp() {
        searchResults.applyFilterFromFilterPopUp();
    }

    @And("^customer clicks on Apply Filters on main screen$")
    public void applyFiltersOnMainScreen() {
        searchResults.clickApplyFiltersOnMainScreen();
    }

    @Then("^print search results$")
    public void printResults() {
        searchResults.printResultsMessage();
    }

    @And("^customer applies main filter (.*) and sub filter (.*) and do NOT Close filter pop-up$")
    public void selectMainFilterAndSubFilter(String mainFilter, String subFilter) {
        searchResults.applyGivenMainFilterCategory(mainFilter);
        searchResults.applyGivenFilterSubCategory(subFilter);
    }

    @And("^customer selects product category (.*) from side menu of search results$")
    public void selectProductCategoryFromSideMenu(String prodCategory) {
        searchResults.selectProductCategoryFromSideMenuSearchResults(prodCategory);
    }

}
