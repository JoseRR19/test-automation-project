package com.joseruiz.tests;

import com.joseruiz.pages.LoginPage;
import com.joseruiz.pages.ProductsPage;
import com.joseruiz.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductsTest {

    private WebDriver driver;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        productsPage = new ProductsPage(driver);
    }

    @Test
    public void productPageLoadsCorrectly() {
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
        Assert.assertTrue(productsPage.isCartDisplayed());
        Assert.assertNotNull(productsPage);
        productsPage.openMenu();
        Assert.assertTrue(driver.getPageSource().contains("Logout"));
        Assert.assertTrue(driver.getPageSource().contains("Reset App State"));
    }

    @Test
    public void menuNavigationWorksCorrectly() {

        productsPage.openMenu();
        productsPage.clickAllItems();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Did not navigate to All Items page");

        productsPage.clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"),
                "User was not logged out correctly");
    }

    @Test
    public void addToCartAddsProductCorrectly() {

        productsPage.addFirstProductToCart();

        Assert.assertEquals(productsPage.getCartItemCount(), "1",
                "Cart count is incorrect");

        productsPage.openCart();

        Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"),
                "Product not found in cart");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}