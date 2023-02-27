package AllMightyPull;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_page extends Base
{
	@Test
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
}
