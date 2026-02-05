package com.joseruiz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators (Login Variables)
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    private By submitButton = By.id("login-button");


    // Constructor that accepts WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login methods
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickLogin() {
        driver.findElement(submitButton).click();
    }
}