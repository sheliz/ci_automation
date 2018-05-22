package Jenkins_Demo.Jenkins_Demo;

import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSTablet extends BaseTest {

	private String testName = "Jenkins Demo Android";
	//private String accessKey = System.getenv("accessKey");
	private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVeE5UVTNNekEwT1RJNU1nIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MzMyNTc2NTIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.dlomjSQ3wkmV3uovu5fJtS5-Z7-vnyk7Sw9AOmmE4aA";
	protected AndroidDriver<AndroidElement> driver = null;

	@Before
	public void setUp() throws Exception{
		
		init(System.getenv("deviceQuery"));
		

		//init("@os='android'");
		
		//driver = new AndroidDriver<AndroidElement>(new URL("http://192.168.2.1:9192/wd/hub"), dc);
				//System.getenv("url") + "/wd/hub"), dc);
	}

	@Test
	public void test(){
		

//		dc.setCapability("instrumentApp", true);
//		dc.setCapability(MobileCapabilityType.APP, "cloud:uniqueName=testEribankAndroid");
//		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
//		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
//		
//		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
//        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
//        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
//        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
//        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
//        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
//        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
//        driver.findElement(By.xpath("//*[@text='Switzerland']")).click();
//        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@text='Yes']")).click();
	}

	@After
	public void tearDown(){
		//driver.quit();

	}
}
