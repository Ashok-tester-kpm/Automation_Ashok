package AllMightyPull;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


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
	  
	  //URL 
	  @Test(priority = 1)
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
	  
	  //Login credentials 
	  @Test(priority = 2)
	  public void login()
	  {
		  	String loginpage = "Supplier Onboarding - LOGIN";
		  	String actualpage = driver.getTitle();
		  	Assert.assertEquals(loginpage,actualpage);
		  	
		  	//Login User-name field 
			driver.findElement(By.id("email")).sendKeys("dhileep@eccma.org");  
			String username = driver.findElement(By.id("email")).getAttribute("value");
			
			//login Password field
			driver.findElement(By.id("password")).sendKeys("Dhileep_123#"); 
			String password = driver.findElement(By.id("password")).getAttribute("value");
			
			//Login
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).submit();
			
			//Login verification
			String acttitle = driver.getTitle();
			String exptitle = "ECCMA - Supplier Onboarding";
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(acttitle, exptitle);
			
			try 
				{
					if(driver.findElement(By.xpath("//span[contains(text(),'Invalid Login')]")).getText().equals(driver.findElement(By.xpath("//span[contains(text(),'Invalid Login')]")).getText()))
							{
								Reporter.log("Login Failed, The message reaceived is "+ driver.findElement(By.xpath("//span[contains(text(),'Invalid Login')]")).getText() + " " + "The Login Credentials are "+ "User-Name " + username +" & "+"Password "+ password);
								System.out.println("Login Failed, The message reaceived is "+ driver.findElement(By.xpath("//span[contains(text(),'Invalid Login')]")).getText() + " " + "The Login Credentials are "+ "User-Name" + username +" & "+"Password"+ password);
							}
					else
							{
								String LoginPageURL = driver.getCurrentUrl();
								String LoginPageActualURL = "https://emdvcorasia.com/testing6/dashboard";
								String Dashboardtitle = driver.getTitle();
								SoftAssert softassert1 = new SoftAssert();
								softassert1.assertEquals(LoginPageURL, LoginPageActualURL);
								Reporter.log("The login page is reached");
								Reporter.log("The Log-in is Successfull "+Dashboardtitle+"is reached");
							}
				}
			catch(Exception e){
				}
	  }

	  //Select User	
	  @Test(priority = 3)
	  public void selectuserbutton() throws InterruptedException, Exception 
	  {
			 driver.findElement(By.xpath(("//b[contains(@class,'btn btn-sm btn-success')]"))).click();
			 driver.findElement(By.xpath("//a[@href='https://emdvcorasia.com/testing6/login/changerole/581/1']")).click();
	
			 //Select Requester Form Type
			 driver.findElement(By.id("select_form_btn")).click();
			 Select drpdownform1 = new Select(driver.findElement(By.id("form_name")));
			 drpdownform1.selectByVisibleText("Quick Add (Ariba) Form");
			 driver.findElement(By.xpath("//button[contains(text(),'CONFIRM')]")).click();
	  }
}
