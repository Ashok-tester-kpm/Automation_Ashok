package Publications;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
	  
	  @Test(priority = 1)
	  public void URL()
	  {
		  	driver.manage().window().maximize();
			driver.get("https://eccma.org/forms_demo/Publicationsdemo/"); 
			Reporter.log("The Title of the page is "+ driver.getTitle()+" ");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String urlactual = driver.getCurrentUrl();
			String urlexpect = "https://eccma.org/forms_demo/Publicationsdemo/";
			Assert.assertEquals(urlactual,urlexpect);
	  }
}
