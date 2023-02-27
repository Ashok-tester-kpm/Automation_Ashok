package AllMightyPull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base 
{
	  public WebDriver driver=null;
	  
	  //Multiple-browser Launch
	  @BeforeClass
	  @Parameters({"browsername"})
	  public void browsers(String browsername)
	  {
		  if(browsername.equals("chrome"))
		  {		  
			  //Setting up capabilities to run our test script
			  driver = new ChromeDriver();
			  Reporter.log("Selenium runs Automation in chrome for SDM");
			  System.out.println("Automation on Chrome begins");
		  }
		  
		  else if(browsername.equals("edge"))
		  {
			  driver = new EdgeDriver();  
			  Reporter.log("Selenium runs Automation in Edge for SDM");
			  System.out.println("Automation on edge begins");
		  }	 
	  }
	 
}
