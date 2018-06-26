package com.experitest.auto;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.experitest.appium.SeeTestClient;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {

	private String testName = "Demo Android Phone";
	protected AndroidDriver<AndroidElement> driver = null;
	protected DesiredCapabilities dc = new DesiredCapabilities();
	private SeeTestClient client;

    @BeforeTest
    @Parameters("deviceQuery")
    public void setUp(@Optional("@os='android'") String deviceQuery) throws MalformedURLException {
        dc.setCapability("testName", testName);
		dc.setCapability("deviceQuery", deviceQuery);
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("build", "jenkins_android_phone");
		dc.setCapability("accessKey", System.getenv("accessKey")); 
        driver = new AndroidDriver<AndroidElement>(new URL(System.getenv("url")), dc);
        client = new SeeTestClient(driver);
    }

    @Test
    public void test() {
    	client.install("cloud:uniqueName=testEribankAndroid_" + System.getenv("BUILD_NUMBER"), true, false);
    	client.launch("cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity", true, true);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}