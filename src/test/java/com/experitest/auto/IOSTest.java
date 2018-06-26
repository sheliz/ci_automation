package com.experitest.auto;
import java.net.URL;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class IOSTest  {

	private String testName = "Demo iOS";
    protected IOSDriver<IOSElement> driver = null;
    protected DesiredCapabilities dc = new DesiredCapabilities();
    private SeeTestClient client;

	@BeforeTest
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
        dc.setCapability("testName", testName);
		dc.setCapability("deviceQuery", deviceQuery);
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("build", "jenkins_ios_phone");
//		dc.setCapability("build.number", System.getenv("BUILD_NUMBER"));
		dc.setCapability("accessKey", System.getenv("accessKey")); 
        driver = new IOSDriver<IOSElement>(new URL(System.getenv("url")), dc);
        client = new SeeTestClient(driver);
	}

	@Test
	public void test(){
		client.install("cloud:uniqueName=testEribankIOS_" + System.getenv("BUILD_NUMBER"), true, false);
		client.launch("cloud:com.experitest.ExperiBank", true, true);
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
