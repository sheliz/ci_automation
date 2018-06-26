package com.experitest.auto;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;


public class WebTest {

    private WebDriver driver;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browserName) throws Exception {
        dc.setCapability(CapabilityType.BROWSER_NAME, browserName);
        dc.setCapability(CapabilityType.VERSION, "Any");
        dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
		dc.setCapability("stream", "jenkins_web");
//        dc.setCapability("build.number", System.getenv("BUILD_NUMBER"));
        dc.setCapability("accessKey", System.getenv("accessKey"));
        dc.setCapability("testName", "Experitest site");
        driver = new RemoteWebDriver(new URL(System.getenv("url")), dc);
    }


    @Test
    public void testExperitest() throws InterruptedException {
        driver.get("https://www.experitest.com/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/nav/div/button")));
        Thread.sleep(10000);
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}