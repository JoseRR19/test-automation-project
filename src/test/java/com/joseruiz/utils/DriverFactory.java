package com.joseruiz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        // Essential flags for GitHub Actions / Linux Runners
        options.addArguments("--headless=new"); // Runs without a GUI
        options.addArguments("--no-sandbox");    // Fixes permission issues in Linux containers
        options.addArguments("--disable-dev-shm-usage"); // Prevents crashes due to limited memory
        options.addArguments("--window-size=1920,1080"); // Ensures elements are visible for clicks

        return new ChromeDriver(options);
    }
}

