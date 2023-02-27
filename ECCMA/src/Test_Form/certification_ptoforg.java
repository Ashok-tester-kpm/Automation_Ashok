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

public class certification_ptoforg 
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
		driver.get("https://eccma.org/forms_demo/membership/associate"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login Page verification & Validation
		String acttitle = driver.getTitle();
		String exptitle = "ECCMA | ASSOCIATE MEMBERSHIP";
		Assert.assertEquals(acttitle, exptitle);
		Reporter.log("The Logged-in Page title is "+acttitle);
		System.out.println("");		
		
		/*
		driver.findElement(By.id("email")).sendKeys("dhileep@eccma.org");  
		driver.findElement(By.name("password")).sendKeys("Dhileep_123#"); 
		driver.findElement(By.xpath("//div//input[@id='acceptTerms']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		*/
	  }
	  
	  
	
	
	  @Test(priority = 2)
	  public void reqchecktextfield() throws Exception
	  {
		  //For indiviual Part of organization
		  driver.findElement(By.xpath("https://eccma.org/forms/certification/mdqm#")).click();
		  
		  //Pre-set conditon to achieve required error text fields
		  //Membership Directory click yes 
		  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott active mdl']")).click();
		
		  //WOULD YOU LIKE TO RECEIVE UPDATES BY EMAIL OF NEW PUBLICATIONS AND OFFERS?
		  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott active mpo']")).click();
		  //ENTER NO. OF PEOPLE
		  Select nop = new Select(driver.findElement(By.xpath("//select[@id='no_of_people']")));
		  nop.selectByIndex(5);
		  
		  //WOULD YOU LIKE TO BE CONTACTED ABOUT SUBMITTING AN ARTICLE TO OUR BI-MONTHLY NEWSLETTER?
		  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott mpn'][contains(.,'Yes')]")).click();
		  
		  //ARE YOU INTERESTED IN ALSO OBTAINING YOUR ISO 8000 MASTER DATA QUALITY MANAGER CERTIFICATE OR NEED TO RENEW?
		  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott iso8000mdqm']")).click();
		  
		  //YOU CAN REGISTER SOMEONE ELSE (IN ADDITION TO THE PERSON WHO FILLS OUT THE FORM), SELECT THE TOTAL NUMBER OF REGISTRATIONS AND FILL IN THE REQUESTED INFORMATION FOR EACH OF THEM
		  Select ucanreg = new Select (driver.findElement(By.xpath("//select[@id='no_of_people']")));
		  ucanreg.selectByIndex(5);
		  
		  //Clicking for required field Error
		  driver.findElement(By.xpath("//button[@type='submit']")).submit();
		  
		  //Required-field check for Text-box
		  List<WebElement> tbox = driver.findElements(By.xpath("//input[@type='text'][@required]"));
		  System.out.println("The Number of Required Text Boxes are "+ tbox.size());
		  int i;
	
		  for(i = 0; i<tbox.size(); i++)
		  {
			  String tbname = tbox.get(i).getAttribute("id");
			 			  
			  try
			  {
				  if(driver.findElement(By.id(tbname + "-error")).isDisplayed())
				  	{
					  	//driver.findElement(By.id(tbname+"-error")).getText();
					  	System.out.println(tbname + " " + driver.findElement(By.id(tbname + "-error")).getText() );
				  	}
			  }
			  catch(Exception e)
			  		{
			  			System.out.println(tbname + " field " + tbox.get(i).getAttribute("required") + " " + "No Field is required error message displayed");
			  		}
		  }		  
	  }
	  @Test(priority = 3)
	  public void Reqcheckdropdown()
	  {	  
		  //Required-field check for Drop-down 
		  List<WebElement> ddwn = driver.findElements(By.xpath("//span[@role='combobox']/ancestor::div[@class='col-sm-8']//select"));
		  System.out.println("The Number of Drop down Box "+ddwn.size());
		  for(int i = 0; i<ddwn.size(); i++)
		  {
			  String ddname = ddwn.get(i).getAttribute("id");
			  try
			  {
				  if(driver.findElement(By.id(ddname + "-error")).isDisplayed())
				  	{
					  	System.out.println(ddname + " " + driver.findElement(By.id(ddname + "-error")).getText() );
				  	}
			  }
			  catch(Exception e)
			  {
			  	  System.out.println(ddname + "field " + ddwn.get(i).getAttribute("required") + " " + "No Field is required error message displayed");
			  }
		  }
	  }	  
}
