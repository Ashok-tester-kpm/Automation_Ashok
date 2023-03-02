package Play;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demojack extends Demojackbaseclass
{		
	  public demojack(String drivername) throws InterruptedException 
	  {
		super(drivername);		
	  }

	  //main method runs to execute program
	  public static void main(String args[]) throws InterruptedException 
	  {	  
		  Demojackbaseclass db = new Demojackbaseclass("chrome");
		  urlcollect();
	  }
	  
	  public static  void urlcollect()
	  {
		  //Collect 
		  ArrayList<String> links = new ArrayList<String>();
		  List<WebElement> a = driver.findElements(By.xpath("//div[@class='media-body']//div[@class='company-name']//h6//a"));
		  
		  //Page Selector
		  List<WebElement> pnation = driver.findElements(By.xpath("//div[@id='pagination']//li//a[@onclick]"));
		  
		
		  //Scroll over all pages and collect links
		  for(int pg = 1 ; pg<pnation.size(); pg++ )
		    	  {
			  			try 
			  			{		 		
			  			 			WebElement ele = driver.findElement(By.xpath("//a[@onclick='searchTerm('"+pg+"')]"));
			  			 			ele.click();
			  			 			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			  			 			wait.until(ExpectedConditions.elementToBeClickable(ele));
			  			 			
			  			 			System.out.println("Run page "+pg);
			  			}
			  			
			  			catch(Exception e) 
			  					{
			  				   	}
			  			 		
			  		 /*
			  		 //To add all the HREF links to Array links
		    		 for(int i =0; i<a.size(); i++ )
		    		 {
		    		 	 links.add(a.get(i).getAttribute("href"));
		    		 }	*/	    				    	  
		    	  }

					 	//To send links to verify URL is working. 
		  				// for(int j=0; j<links.size();j++)
			    	  		//{
			    		 // 	String url= links.get(j);
			    		//  	verifyLinks(url);
			    	  		//}    			    	  		    		
	  }
	
	  public  static void verifyLinks(String linksUrl)
	    {
	        try
	        {
	            URL url = new URL(linksUrl);

	            //Now we will be creating URL connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	            
	            if(httpURLConnect.getResponseCode()>=400)
	            {
	            	System.out.println("Broken Link - "+linksUrl+"---> Message "+httpURLConnect.getResponseMessage()+" is a broken link --> "+ "The response code = " + 	httpURLConnect.getResponseCode());
	            	
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else
	            {
	                System.out.println(linksUrl+" - "+httpURLConnect.getResponseMessage() + " The response code = " + httpURLConnect.getResponseCode());
	            }
	        }
	        catch (Exception e) 
	        {
	        }
	   }
}