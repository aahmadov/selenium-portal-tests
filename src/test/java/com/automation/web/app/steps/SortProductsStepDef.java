package com.automation.web.app.steps;

import com.automation.web.app.DataTableInfo;
import com.automation.web.app.pages.SauceDemoInventoryPage;
import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortProductsStepDef {
    private final SauceDemoInventoryPage sauceDemoInventoryPage;

    @Inject
    public SortProductsStepDef(SauceDemoInventoryPage sauceDemoInventoryPage) {
        this.sauceDemoInventoryPage = sauceDemoInventoryPage;
    }

    @When("I select  product sort option")
    public void WhenISelectProductSortOption(DataTable table) {
        DataTableInfo testData = table.asList(DataTableInfo.class).get(0);
        sauceDemoInventoryPage.SelectSortOptions(testData.getSortOption());
    }

    @Then("I verify products are sorted by price from low to high")
    public void ThenIVerifyProductsAreSortedByPriceFromLowToHigh() {
        sauceDemoInventoryPage.VerifyProductsSortedByPriceFromLowToHigh();
    }
}
