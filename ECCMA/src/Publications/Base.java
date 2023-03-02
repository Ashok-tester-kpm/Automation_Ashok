package Publications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;


public class Base 
{
			public WebDriver driver; 
			@BeforeClass
			public void testbase()
			  {
				  //Setting up capabilities to run our test script
				  driver = new ChromeDriver();
				  Reporter.log("Selenium runs Automation in chrome for SDM");
				  System.out.println("Automation on Chrome begins");
			  }
			
}
