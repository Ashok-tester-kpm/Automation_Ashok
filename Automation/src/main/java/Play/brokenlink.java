package Play;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlink 
{
	public static  WebDriver driver;
	public static ArrayList<String> links; 
	
	public static void main(String[] args) throws InterruptedException, IOException 
    {	
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		Thread.sleep(5000);
        
        String testurl[] = { "https://eccma.org/forms_demo/Publicationsdemo/index#"}; 	
        
        for(int d = 0; d< testurl.length ; d++)
        {
	        driver.get(testurl[d]);
	        String wname = driver.getTitle();
	        System.out.println("The Current Title of the webpage is " + wname);
	        
	        /*
	        //Sign-in pattern
	        driver.findElement(By.id("email")).sendKeys("dhileep@eccma.org");  
	        driver.findElement(By.id("password")).sendKeys("Dhileep_123#");
			driver.findElement(By.xpath("//button[@type='submit'][@data-action='submit']")).click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        Thread.sleep(6000);
	        */
	        
	        
	        //Storing the links in a list and traversing through the links
	        ArrayList<String> links = new ArrayList<String>();
	        List<WebElement> a = driver.findElements(By.xpath("//a[@href]"));
	        Thread.sleep(600);
	        	for(int i =0; i<a.size(); i++ )
	        		{
	        			links.add(a.get(i).getAttribute("href"));
	        	 	}
	        
	        List<WebElement> b = driver.findElements(By.xpath("//link[@href]"));
	        Thread.sleep(600);
	        	for(int j = 0 ; j<b.size(); j++)
	        		{
	        			links.add(b.get(j).getAttribute("href"));
	        		}
	        
	        List<WebElement> c = driver.findElements(By.xpath("//img[@src]"));
	        Thread.sleep(600);
	        	for(int k = 0 ; k<c.size(); k++)
	        		{
	        			links.add(c.get(k).getAttribute("src"));
	        		}	
	        
	      // This line will print the number of links and the count of links.
	      System.out.println("No of links are "+ links.size());  
	                  
	      //checking the links fetched.
	      for(int m=0; m<links.size(); m++)
	        {
	            String Url= links.get(m);
	            try
		        {
		        	
		        	URL url = new URL(Url);
		        	
		            //Creating URL connection and getting the response code
		            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		            httpURLConnect.setConnectTimeout(5000);
		            httpURLConnect.connect();
		            
		            //Fetching and Printing the response code obtained
		            if(httpURLConnect.getResponseCode()>=400)
		            	{
		            		System.out.println("Broken Link - "+ Url +"---> Message " + httpURLConnect.getResponseMessage()+" is a broken link --> "+ "The response code = " + 	httpURLConnect.getResponseCode());
		            		ArrayList<String> failedlinks = new ArrayList<String>(Arrays.asList(Url));
		            	}    
		            
		            //Fetching and Printing the response code obtained
		            else
		            	{
		            		System.out.println(Url+" - "+httpURLConnect.getResponseMessage() + " The response code = " + httpURLConnect.getResponseCode());
		            		ArrayList<String> passlinks = new ArrayList<String>(Arrays.asList(Url));
		                }
		           
            	}
		        catch (Exception e) 
		        	{
		        	}    
	        }	      
        }
        driver.quit();
    }
}
