public class IOSDriverTemplate {
	private static final String url = null;
	private static final String accessKey = null;
	private static final String deviceSerialNumber = null;

	private io.appium.java_client.ios.IOSDriver driver;

	public void template() throws Exception {
		final org.openqa.selenium.remote.DesiredCapabilities dc = new org.openqa.selenium.remote.DesiredCapabilities();
		dc.setCapability("accessKey", accessKey);
		dc.setCapability("deviceQuery", "@serialnumber='" + deviceSerialNumber + "'");
		dc.setCapability("dontGoHomeOnQuit", true);
		driver = new io.appium.java_client.ios.IOSDriver<>(new java.net.URL(url + "/wd/hub"), dc);
		try {
			/* {user.code} */
		} finally {
			try {
				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
