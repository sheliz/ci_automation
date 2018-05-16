package Jenkins_Demo.Jenkins_Demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.experitest.client.Client;
import com.experitest.client.GridClient;

public class AppTest {

	protected Client client = null;
	protected GridClient grid = null;
	private String testName = "Jenkins Demo - Android";
	private String accessKey = System.getenv("accessKey");

	@BeforeMethod
	public void setUp(){
		grid = new GridClient(accessKey, "192.168.2.1", 9192, false);
		client = grid.lockDeviceForExecution(testName,"@os='android'", 10, 5);
		client.setReporter("xml", "reports", testName);
	}

	@Test
	public void test(){
		client.install("cloud:uniqueName=testApp", true, true);
		client.deviceAction("Unlock");
		client.launch("cloud:com.experitest.ExperiBank/.LoginActivity", true, false);
		client.elementSendText("NATIVE", "id=usernameTextField", 0, "company");
		client.elementSendText("NATIVE", "id=passwordTextField", 0, "company");
		client.click("NATIVE", "id=loginButton", 0, 1);
	}

	@AfterMethod
	public void tearDown(){
		client.generateReport(false);
		client.releaseClient();
	}
}
