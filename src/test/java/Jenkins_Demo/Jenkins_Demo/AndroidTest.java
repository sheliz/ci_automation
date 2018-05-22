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
        driver = new AndroidDriver<>(new URL("http://jaharon-lt.experitest.local:9192/wd/hub"), dc);
    }

    @Test
    public void quickStartAndroidNativeDemo() {
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