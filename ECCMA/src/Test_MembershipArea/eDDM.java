package Test_MembershipArea;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
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

public class eDDM 
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
		 				
		//Login Page verification & Validation
		driver.manage().window().maximize();
		driver.get("https://ecdmapp.com/eDDM/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String acttitle = driver.getTitle();
		String exptitle = "eDDM | ECCMA Data Dictionary Manager";
		Assert.assertEquals(acttitle, exptitle);
		Reporter.log("The Logged-in Page title is "+acttitle);
		System.out.println("");	
		Testdata();
		Thread.sleep(8000);
	  }
	  
	  @Test(priority = 2)
	  public void Testdata() throws InterruptedException
	  {
		 Thread.sleep(10);
		 //Search-box  
		 driver.findElement(By.xpath("//div//input[@id='term_inputs']")).sendKeys("cable");
		 driver.findElement(By.xpath("//span//button[@id='search_btn']")).click();
		 
		 //Search 
		 Select searchoption = new Select(driver.findElement(By.xpath("//select[@id='search_type']")));		 
		 searchoption.selectByValue("startwith");
		 System.out.println("");
		 
		 //Select eOTD
		 WebElement eotdradio = driver.findElement(By.xpath("//label//input[@id='tabchange'][@value='eotd']"));
		 eotdradio.click();
		 		if(eotdradio.isSelected())
		 					{
		 						System.out.println("The radio button is clicked");
		 					}
		 		else
		 					{
		 						System.out.println("The radio Button is not clicked");
		 					}
		 
		 //Select Corporate
		 WebElement corpradio =  driver.findElement(By.xpath("//label//input[@id='tabchange'][@value='corporate']"));
		 corpradio.click();
		 		if(corpradio.isSelected())
						{
							System.out.println("The radio button is clicked");
						}
		 		else
						{
							System.out.println("The radio Button is not clicked");
						}
		
		//Select no of item to show
		Select no_ofitem = new Select(driver.findElement(By.xpath("//div//select[@id='term_perrow']")));
		no_ofitem.selectByValue("100");
		
		//Collect all the links
		ArrayList<String> links = new ArrayList<String>();
		
		//Select no of ITEM to show
		List<WebElement> sitemshow = driver.findElements(By.xpath("//h6//a[@href]"));
	    
		//Add hREF links to list
		for(int s = 0 ; s < sitemshow.size() ; s++ )
					{
						links.add(sitemshow.get(s).getAttribute("href"));
					}
		
		//To send links to verify URL is working. 
		for(int j=0; j<links.size();j++)
					{
					  	String url= links.get(j);
					  	verifyLinks(url);
				  	}		
	  }
	  
	  //Test all the links 
	  public void verifyLinks(String linkUrl)
		    {
		        try
		        	{
			            URL url = new URL(linkUrl);
	
			            //Now we will be creating URL connection and getting the response code
			            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			            httpURLConnect.setConnectTimeout(5000);
			            httpURLConnect.connect();
			            if(httpURLConnect.getResponseCode()>=400)
			            	{
			            		System.out.println("Broken Link - "+linkUrl+"---> Message "+httpURLConnect.getResponseMessage()+" is a broken link --> "+ "The response code = " + 	httpURLConnect.getResponseCode());	            	
			            	}    
			       
			            //Fetching and Printing the response code obtained
			            else
			            	{
			                	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " The response code = " + httpURLConnect.getResponseCode());
			                }
		        	}
		        
		        catch (Exception e) 
			        {
			        }
		   }
}
