package Brokenlink;

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
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class brokenlinkverify 
{
	  public static  WebDriver driver;
	  public static  ArrayList<String> links ;
	  public static ArrayList<String> passlinks ;
	  public static ArrayList<String> failedlinks;
	   
	  //Multiple-browser Launch
	  @BeforeTest
	  @Parameters({"browsername"})
	  public static void browsers(String browsername)
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
	
	@Test(priority = 1)
	public static void loader() throws InterruptedException, IOException 
    {	
		driver.manage().window().maximize();
		
        String testurl[] = {""}; 	
        
        for(int d = 0; d< testurl.length ; d++)
        {
	        driver.get(testurl[d]);
	        
	      	//Sign-in pattern
	        driver.findElement(By.id("email")).sendKeys("dhileep@eccma.org");  
	        driver.findElement(By.id("password")).sendKeys("Dhileep_123#");
			driver.findElement(By.xpath("//button[@id='submit']")).click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
	        //Storing the links in a list and traversing through the links
	        ArrayList<String> links = new ArrayList<String>();
	        List<WebElement> a = driver.findElements(By.xpath("//a[@href]"));
	        	for(int i =0; i<a.size(); i++ )
	        		{
	        			links.add(a.get(i).getAttribute("href"));
	        		}
	        
	        List<WebElement> b = driver.findElements(By.xpath("//link[@href]"));	        
	        	for(int j = 0 ; j<b.size(); j++)
	        		{
	        			links.add(b.get(j).getAttribute("href"));
	        		}
	        
	        List<WebElement> c = driver.findElements(By.xpath("//img[@src]"));
	        	for(int k = 0 ; k<c.size(); k++)
	        		{
	        			links.add(c.get(k).getAttribute("src"));
	        		}	
	        
	      // This line will print the number of links and the count of links.
	      System.out.println("No of links are "+ links.size());  
	                  
	      //checking the links fetched.
	      for(int m=0; m<links.size(); m++)
	        {
	            String url= links.get(m);
	            verifyLinks(url);
	        }
        }
       
        driver.quit();
    }
    
    public static void verifyLinks(String linkUrl) throws IOException
    {
					        try
					        {
					        	
					        	URL url = new URL(linkUrl);
					        	
					            //Creating URL connection and getting the response code
					            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
					            httpURLConnect.setConnectTimeout(5000);
					            httpURLConnect.connect();
					            
					            //Fetching and Printing the response code obtained
					            if(httpURLConnect.getResponseCode()>=400)
					            	{
					            		System.out.println("Broken Link - "+ linkUrl +"---> Message " + httpURLConnect.getResponseMessage()+" is a broken link --> "+ "The response code = " + 	httpURLConnect.getResponseCode());
					            		
					            		failedlinks.forEach(System.out::println);
					            	}    
					       
					            //Fetching and Printing the response code obtained
					            else
					            	{
					            		System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " The response code = " + httpURLConnect.getResponseCode());
					            		passlinks.forEach(System.out::println);
					                }
					        }
					        catch (Exception e) 
					        	{
					        	}
    }
	
    /*
        @Test(priority = 2)					        
        public static void feeder() throws IOException
        {
		System.out.println("Feeding EXCEL");
    	
    	File file = new File ("E:\\LINKCHECK.xlsx");
  		XSSFWorkbook wb = null;
  		XSSFSheet sh = null;
  		
  		try{	  			
  			System.out.println("Data feeding to excel complete- Please wait for browser to close");		  		
	  		Reporter.log("Data feeding to excel complete - Please wait for browser to close");			  			
	  		
	  		FileInputStream fis = new FileInputStream(file);
	  		wb = new XSSFWorkbook(fis);
  			sh = wb.getSheetAt(0);
  			for(int p = 0 ; p < passlinks.size() ; p++)
  			{
  				passlinks.get(p);
				sh.getRow(6).getCell(p).setCellValue(String.valueOf(p));
  			}
  		}
  		catch(Exception r) {	  		
  		}
	  		FileOutputStream fos = new FileOutputStream(file);
	  		wb.write(fos);
	  		
        }
        */
}
