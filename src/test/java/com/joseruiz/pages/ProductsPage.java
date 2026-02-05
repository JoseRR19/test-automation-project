package com.joseruiz.pages;

import com.joseruiz.utils.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    // Locators (Products Page Variables)
    private By pageTitle = By.className("title");
    private By cartContainer = By.id("shopping_cart_container");
    private By cartBadge = By.className("shopping_cart_badge");
    private By firstAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By menuButton = By.id("react-burger-menu-btn");
    private By allItemsLink = By.id("inventory_sidebar_link");
    private By aboutLink = By.id("about_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");

    // Constructor that accepts WebDriver
    private WaitUtility waitUtility;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
    }

    // Methods
    // Product Page
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public boolean isCartDisplayed() {
        return driver.findElement(cartContainer).isDisplayed();
    }

    // Menu
    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickAllItems() {
        waitUtility.waitForClickable(allItemsLink).click();
    }


    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    // Cart
    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartContainer).click();
    }
}
