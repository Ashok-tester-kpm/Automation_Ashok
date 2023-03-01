package Publications;

import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class URL extends Base
{
	  @Test(priority = 1)
	  public void URLrun()
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
