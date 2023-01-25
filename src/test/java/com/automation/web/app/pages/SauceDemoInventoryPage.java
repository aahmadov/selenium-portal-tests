package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoInventoryPage extends BasePage {

    @Inject
    public SauceDemoInventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(id = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement menuLogout;

    @FindBy(css = ".product_sort_container")
    private WebElement sortDorpdown;

    @FindBy(css = ".inventory_item_price")
    private WebElement itemPrice;

    @FindBy(css = ".inventory_item")
    private List<WebElement> inventoryItem;

    public void Logout()
    {
        menu.click();
        menuLogout.click();
    }

    public void verifyPageLoad()
    {
        Assert.assertTrue(shoppingCart.isDisplayed());
    }

    public void SelectSortOptions(String option)
    {
        selectDropDownByText(option, By.cssSelector(".product_sort_container"));
    }

    public void VerifyProductsSortedByPriceFromLowToHigh()
    {
        List<Double> priceList = new ArrayList<>();

//        var inventoryItems = inventoryItem;
        for (WebElement item : inventoryItem) {
            String text = item.findElement(By.cssSelector(".inventory_item_price")).getText().replace("$", "");
            priceList.add(Double.parseDouble(text));
        }
        assertThat(priceList).isSorted();
    }
}
