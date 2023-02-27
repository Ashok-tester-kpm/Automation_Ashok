package AllMightyPull;

import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Url_run extends Base
{
	  //URL 
	  @Test
	  public void urlrun()
	  {
		  	driver.manage().window().maximize();
			driver.get("https://emdvcorasia.com/testing6/"); 
			Reporter.log("The Title of the page is "+ driver.getTitle()+" ");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String urlactual = driver.getCurrentUrl();
			String urlexpect = "https://emdvcorasia.com/testing6/";
			Assert.assertEquals(urlactual,urlexpect);
	  }
}
