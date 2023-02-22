package crackplay;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Page 
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  
	  //Login credentials 
	  @Test(priority = 2)
	  public void login()
	  {
		  	
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
								System.out.println("Login Failed, The message reaceived is "+ driver.findElement(By.xpath("//span[contains(text(),'Invalid Login')]")).getText() + " " + "The Login Credentials are "+ "User-Name" + username +" & "+"Password"+ password);
							}
					else
							{
								String LoginPageURL = driver.getCurrentUrl();
								String LoginPageActualURL = "https://emdvcorasia.com/testing6/dashboard";
								String Dashboardtitle = driver.getTitle();
								SoftAssert softassert1 = new SoftAssert();
								softassert1.assertEquals(LoginPageURL, LoginPageActualURL);
								System.out.println("The Login page is reached");
								Reporter.log("The login page is reached");
								Reporter.log("The Log-in is Successfull "+Dashboardtitle+"is reached");
							}
				}
			catch(Exception e){
				}
	  }
}
