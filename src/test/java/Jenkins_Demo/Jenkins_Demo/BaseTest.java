package Jenkins_Demo.Jenkins_Demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

	protected DesiredCapabilities dc = new DesiredCapabilities();
	
	public void main() throws Exception {
		
		JUnitCore junit = new JUnitCore();
		String deviceQuery = System.getenv("deviceQuery");
		
		dc.setCapability("deviceQuery", deviceQuery);
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("stream", "jenkins");
		dc.setCapability("build.number", System.getenv("BUILD_NUMBER"));
		dc.setCapability("accessKey", System.getenv("accessKey")); 
        
        if (deviceQuery.equals("web")) {

        }
        else if (deviceQuery.contains("ios")){
        	Result result = junit.run(IOSTest.class);
        	System.out.println(result.toString());
        }
        else if (deviceQuery.contains("android")){
        	Result result = junit.run(AndroidTest.class);
        	System.out.println(result.toString());
        }
	
	}
}
