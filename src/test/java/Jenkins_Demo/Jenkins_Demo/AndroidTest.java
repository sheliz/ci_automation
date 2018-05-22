package Jenkins_Demo.Jenkins_Demo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.*;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest extends BaseTest{

	private String testName = "Jenkins Demo Android Phone";
	protected AndroidDriver<AndroidElement> driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
		//dc.setCapability("deviceQuery", System.getenv("deviceQuery"));
        dc.setCapability("deviceQuery", "@os='android'");
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("stream", "jenkins_android_phone");
		dc.setCapability("build.number", System.getenv("BUILD_NUMBER"));
		//dc.setCapability("accessKey", System.getenv("accessKey")); 
		dc.setCapability("accessKey", "eyJ4cC51IjoxMjcsInhwLnAiOjIsInhwLm0iOiJNVFV5TXpnM01qRTVNRFl3TnciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NDIzMzk4NTksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.MvprhgWLkF27CEvR1XE0rm9M5_DROY-Bl_597rLiF44");
        driver = new AndroidDriver<AndroidElement>(new URL("https://sales.experitest.com/wd/hub"), dc);
    }

    @Test
    public void test() {
        driver.executeScript("seetest:client.install(\"cloud:uniqueName=testEribankAndroid\", \"true\", \"false\")");
		driver.executeScript("seetest:client.launch(\"cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity\", \"true\", \"true\")");
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}