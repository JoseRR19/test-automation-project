package com.joseruiz.tests;

import com.joseruiz.pages.LoginPage;
import com.joseruiz.utils.ConfigReader;
import com.joseruiz.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        driver.get(ConfigReader.getBaseUrl());

        loginPage = new LoginPage(driver);

        System.out.println("Testing on: "
                + ConfigReader.getEnvironment());
    }

    @Test
    public void loginPageLoadsCorrectly() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertTrue(driver.getPageSource().contains("user-name"));
        Assert.assertTrue(driver.getPageSource().contains("password"));
        Assert.assertTrue(driver.getPageSource().contains("login-button"));
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        Assert.assertNotNull(driver.getTitle());
    }

    @Test
    public void invalidLoginShowsErrorMessage() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        String errorText = loginPage.getErrorMessage();

        Assert.assertTrue(errorText.contains("Username and password do not match"),
                "Expected error message not displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}