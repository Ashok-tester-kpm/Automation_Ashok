package Test_Form;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Membership_Form 
{
	  public WebDriver driver;	
	  //Multiple-browser Launch
	  @BeforeTest
	  @Parameters({"browsername"})
	  public void browsers(String browsername)
	  {
		  if(browsername.equals("chrome"))
		  {		  
			  driver = new ChromeDriver();
			  Reporter.log("Selenium runs Automation in chrome for ECCMA");
			  System.out.println("Automation on Chrome begins for ECCMA");
		  }
		  else if(browsername.equals("edge"))
		  {
			  driver = new EdgeDriver();  
			  Reporter.log("Selenium runs Automation in Edge for ECCMA");
			  System.out.println("Automation on edge begins for ECCMA");
		  }	
	  }
	  
	  //Login credentials 
	  @Test(priority = 1)
	  public void Navigate() throws IOException, Exception
	  {		  
		driver.manage().window().maximize();
		driver.get("https://eccma.org/forms_demo/membership/full"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login Page verification & Validation
		String acttitle = driver.getTitle();
		String exptitle = "ECCMA | FULL MEMBERSHIP";
		Assert.assertEquals(acttitle, exptitle);
		Reporter.log("The Logged-in Page title is "+acttitle);
		System.out.println("");		
		
		/*driver.findElement(By.id("email")).sendKeys("dhileep@eccma.org");  
		driver.findElement(By.name("password")).sendKeys("Dhileep_123#"); 
		driver.findElement(By.xpath("//div//input[@id='acceptTerms']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		*/
	  }

	  //dropdown feed
	  @Test(priority = 3 )
	  public void ddfeed()
	  {
		 //ENTER NO. OF PEOPLE
		 Select nop = new Select(driver.findElement(By.xpath("//select[@id='no_of_people']")));
		 nop.selectByIndex(5);
		 List<WebElement> ddf = driver.findElements(By.xpath("//div[@class='col-sm-8']//select"));
		 for(int i = 0; i< ddf.size(); i++ )
		 {
			 String dropdown[] = {ddf.get(i).getAttribute("id")};
				for (int dd = 0 ; dd<dropdown.length; dd++ )
				{
					try{
							System.out.println(dropdown[dd]);
							Select drop = new Select(driver.findElement(By.id(""+dropdown[dd]+"")));
							drop.selectByIndex(2);
							Thread.sleep(5000);					
						}
					catch (Exception e1) {
						}
				 }
		 }
	  }
	  
	  //AllTextboxFeed
	  @Test(priority = 4 )
	  public void textfeed()
	  {
		  //Enter Text-box
		  List <WebElement> ttf = driver.findElements(By.xpath("//div[@class='col-sm-8']//input"));
		  for(int t = 0 ; t< ttf.size() ; t++)
		  {
			  try
			  {
				  ttf.get(t).sendKeys("Testingdata");
			  }
			  catch(Exception e1) {
			  }
		  }
	  }
	   
	  /*@Test(priority = 5) 
		public void submit()
		{
			  //Apply for certificate under cost
			  driver.findElement(By.xpath("//input[@id='mdqm_chk']")).click();	  
			  //Submit form here
			  driver.findElement(By.xpath("//button[@id='submit_button']")).submit();
		}
		
		@Test(priority = 6)
		public void paypal()
		{
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dhileep-buyer@eccma.org");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dhileep@123");
			driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		}*/
}