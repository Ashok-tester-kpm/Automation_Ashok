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

public class eOTD 
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
		driver.get("https://www.eotd.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String acttitle = driver.getTitle();
		String exptitle = "eOTD | ECCMA Open Technical Dictionary";
		Assert.assertEquals(acttitle, exptitle);
		Reporter.log("The Logged-in Page title is "+acttitle);
		System.out.println("");	
		Testdata();
		
	  }
	  	 
	  public void Testdata() throws InterruptedException
	  {
		  
		  //Searchbox click, feed and search (Searchbox validation)
		  driver.findElement(By.xpath("//input[@id='term_inputs']")).click();
		  driver.findElement(By.xpath("//input[@id='term_inputs']")).sendKeys("cable");
		  
		  //Search button click
		  driver.findElement(By.xpath("//span//button[@id='search_btn']")).click();
		  		  
		  //Select Search type
		  Select searchtype = new Select(driver.findElement(By.xpath("//select[@id='search_type']")));
		  System.out.println("The search type options availble are "+searchtype.getOptions());
		  //Select SearchType
		  searchtype.selectByValue("related");
		  
		  System.out.println("");
		  
		  //Select Show items per page
		  Select showitem = new Select(driver.findElement(By.xpath("//select[@id='term_perrow']")));
		  System.out.println("The Show items options availble are "+searchtype.getOptions());
		  //Select SearchType
		  showitem.selectByValue("100");
		  
		  System.out.println("");
		  
		  Thread.sleep(8000);
		  
		  //Collect all the links
		  ArrayList<String> links = new ArrayList<String>();
		   
		  
		  					 try {	
		  						  
		  						 //Collect Links 
		  						  List<WebElement> a = driver.findElements(By.xpath("//div[@class='media-body']//div[@class='company-name']//h6//a"));
		  						  
		  						  //To add all the HREF links to Array above
								  for(int i = 0; i< a.size(); i++ )
						    		{
						    			links.add(a.get(i).getAttribute("href"));			    			
						    		}								  
								  
								  //Scroll - Over page 
								  driver.findElement(By.xpath("//a[contains(@id,'but2')]")).click();								  							  
								  System.out.println("page clicked succesfully");
								  
								  Thread .sleep(7000);

								  //To add all the page 2 HREF links to Array above
								  for(int k = 0; k< a.size(); k++ )
									{
									  	links.add(a.get(k).getAttribute("href"));
										System.out.println("Links is loaded");
										Thread.sleep(500);
									}									
								  }
								  catch(Exception E) {
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
	
	@Test(priority =  6)  
	//Public void   
	public void checkadvsrch()
	{
		
	} 
	 	  
}