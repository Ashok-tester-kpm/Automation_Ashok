package Publications;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Publications_Mainpage 
{
	//Setting up capabilities to run our test script
	public WebDriver driver = new ChromeDriver();
	
	@Test(priority = 1 , description = "Browser Setup")
	public void browser_setup()
	  {
		  driver.manage().window().maximize();
		  Reporter.log("Selenium runs Automation in chrome for SDM");
		  System.out.println("Automation on Chrome begins");
	  }

	@Test(priority = 2 , description = "url load")
	public void url_run()
	  {
			driver.get("https://eccma.org/forms_demo/Publicationsdemo/"); 
			Reporter.log("The Title of the page is "+ driver.getTitle()+" ");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			String urlactual = driver.getCurrentUrl();
			String urlexpect = "https://eccma.org/forms_demo/Publicationsdemo/";
			Assert.assertEquals(urlactual,urlexpect);
	  }
	
	@Test(priority = 3, description="Category Drop-down check")
	public void category_drpdown() throws InterruptedException
	{
		Select category = new Select(driver.findElement(By.xpath("//select[@id='category']")));
		List<WebElement> cat = category.getOptions();
		ArrayList<String> dropcont = new ArrayList<>();
		
		for(int i = 0 ; i < cat.size() ; i ++)
			{
				dropcont.add(cat.get(i).getAttribute("value"));
			}
		
		ArrayList<String> catdrop = new ArrayList<String>(); 
		catdrop.addAll(Arrays.asList("Whitepaper",
				"All",
				"eCDM Brochure",
				"eOTD Downloads",
				"eGOR Explanatory Guide",
				"Case Studies",
				"Standards",
				"Newsletter",
				"Press Releases",
				"Presentation-12",
				"Presentation-11",
				"Presentation-10",
				"Presentation-9",
				"Presentation-8",
				"Presentation-1",
				"Presentation-2",
				"Presentation-3",
				"Presentation-4",
				"Presentation-5",
				"Presentation-7"));
		
		if(catdrop.equals(dropcont))
			{
				System.out.println("The drop down values are as per required list - pass");
			}
		else
			{
				catdrop.removeAll(dropcont);
				for(int c = 0 ; c < catdrop.size() ; c ++)
				{
					if(catdrop.get(c) != null)
					{
						System.out.println("The drop down content did not match the required list is "+catdrop.get(c));
					}
					else
					{
						System.out.println("The Un-Matched content found is "+catdrop.get(c));
					}
				}
			}
		
		//Check for By default-drop down value 
		String catval = driver.findElement(By.xpath("//span[@id='select2-category-container']")).getAttribute("title");
		if(catval.contentEquals("Whitepaper"))
			{
				System.out.println("The default value in dropdown is set to "+catval);
			}
		else
			{
				System.out.println("Check code default value is set to "+catval);
			}
			
		//Select Category drop-down Value - /***/ Test for Drop-Down /***/
		category.selectByValue("All");
		String catval1 = driver.findElement(By.xpath("//span[@id='select2-category-container']")).getText();
		if(catdrop.contains(catval1))
			{
				System.out.println("The Value selected matches category drop-down list");
			}
		else
			{
				System.out.println("The value selected does not match drop-down list");
			}
		Thread.sleep(700);
		reset();
	}
	
	@Test(priority = 4, description = "Sends text, collects and verify text")
	public void search_author() throws InterruptedException
	{
		 //Search Files using Search Author
		 driver.findElement(By.id("author_inputs")).sendKeys("Peter");

		 //Submit
		 driver.findElement(By.xpath("//button[@id='btnsearch']")).click();
		
		 //Check with alpha-numeric
		 String searchauthortext = driver.findElement(By.xpath("//div//input[@id='author_inputs']")).getAttribute("value");		
		 
		 System.out.println("The Author name searched is "+searchauthortext);
		 
		 String alphanum = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
		 
		 Pattern p = Pattern.compile(alphanum);
		 
		 if(searchauthortext == null)
		 	{
			 	System.out.println("The Search Author field is empty");
		 	}
		 
		 Matcher m = p.matcher(alphanum);
		 
		 if(m.matches() == true)
		 	{
			 	System.out.println("Alhpanum characters are given in text field");
		 	}
		 
		 else
		 {
				if( driver.getPageSource().contains(searchauthortext))
						{
							if(driver.getPageSource().contains("No Records Found...")) 
							{
								System.out.println("search is working - No files are found on name "+searchauthortext);
							}
							System.out.println("Records matched with author name - search is working");
						}
				else if(driver.getPageSource().contains("No Records Found...")) 
						{
							System.out.println("search is working - No files are found on name "+searchauthortext);
						}
				else
						{
							System.out.println("search fail");
						}
		  }
		 reset();
	}
	
	@Test(priority = 5, description = "Search - Title")
	public void searchtitle() throws InterruptedException
	{
		//Search Files using Search Author
		 driver.findElement(By.id("title_inputs")).sendKeys("Peter");

		 //Submit
		 driver.findElement(By.xpath("//button[@id='btnsearch']")).click();
		
		 //Check with alpha-numeric
		 String searchtitletext = driver.findElement(By.xpath("//div//input[@id='title_inputs']")).getAttribute("value");		
		 
		 System.out.println("The Title name searched is "+searchtitletext);
		 
		 String alphanum = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
		 
		 Pattern p = Pattern.compile(alphanum);
		 
		 if(searchtitletext == null)
		 	{
			 	System.out.println("The Search Author field is empty");
		 	}
		 
		 Matcher m = p.matcher(alphanum);
		 
		 if(m.matches() == true)
		 	{
			 	System.out.println("Alhpanum characters are given in text field");
		 	}
		 
		 else
		 {
				if( driver.getPageSource().contains(searchtitletext))
						{
							if(driver.getPageSource().contains("No Records Found...")) 
							{
								System.out.println("search is working - No files are found on name "+searchtitletext);
							}
							System.out.println("Records matched with Title name - search is working");
						}
				else if(driver.getPageSource().contains("No Records Found...")) 
						{
							System.out.println("search is working - No files are found on name "+searchtitletext);
						}
				else
						{
							System.out.println("search fail");
						}
		  }
		 reset();
		 Thread.sleep(1000);
	}
	
	@Test(priority = 6)
	public void keyword() throws InterruptedException
	{
		//Search Files using Search Author
		 driver.findElement(By.id("keyword_inputs")).sendKeys("ISO");

		 //Submit
		 driver.findElement(By.xpath("//button[@id='btnsearch']")).click();
		
		 //Check with alpha-numeric
		 String searchkeywordtext = driver.findElement(By.xpath("//div//input[@id='keyword_inputs']")).getAttribute("value");		
		 
		 System.out.println("The Title name searched is "+searchkeywordtext);
		 
		 String alphanum = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
		 
		 Pattern p = Pattern.compile(alphanum);
		 
		 if(searchkeywordtext == null)
		 	{
			 	System.out.println("The Search Keyword field is empty");
		 	}
		 
		 Matcher m = p.matcher(alphanum);
		 
		 if(m.matches() == true)
		 	{
			 if(driver.getPageSource().contains("No Records Found...")) 
				{
					System.out.println("Alhpanum characters are given in text field"+searchkeywordtext);
				}
			 else if(driver.getPageSource().contains("PHP ERROR"))
				 {
					 System.out.println("PHP error found in page at field - Search keyword");
				 }
			}
		 
		 else
		 {
				if( driver.getPageSource().contains(searchkeywordtext))
						{
							if(driver.getPageSource().contains("No Records Found...")) 
							{
								System.out.println("Keyword search is working - No files are found on name "+searchkeywordtext);
							}
							System.out.println("Records matched with Keyword name - Keyword search is working");
						}
				else if(driver.getPageSource().contains("No Records Found...")) 
						{
							System.out.println("Keyword search is working - No files are found on name "+searchkeywordtext);
						}
				else
						{
							System.out.println("search fail");
						}
		  }
		 reset();
		 Thread.sleep(1000);
	}
	
	@Test(priority = 7)
	public void pagination() throws InterruptedException
	{
		String pagedetails = driver.findElement(By.xpath("//div[@id='pagination']//span")).getText();
		System.out.println(pagedetails);
		int noofpages = Integer.valueOf(pagedetails.substring(pagedetails.indexOf("f")+2, pagedetails.indexOf("|")-1));
		System.out.println(noofpages);
		
		for(int p = 1 ; p <= noofpages ; p++)
		{
			
				WebElement activepage = driver.findElement(By.xpath("//div[@id='pagination']//a[@class='btn btn-info paginaion']//b"));
				System.out.println("The Current Page is "+ activepage.getText());
				activepage.click();
				
				int rows = driver.findElements(By.xpath("//div[@id='download_container']//div[contains(@class,'entry col-12')]")).size();
				System.out.println("The no of rows in page is "+rows);
				
				driver.findElement(By.xpath("//div[@id='pagination']//a[text()='"+(p+1)+"']")).click();
				Thread.sleep(1000);
				
				List<WebElement> lelements = driver.findElements(By.xpath("//div[@class='entry-title title-sm']//h3"));
				for(int r = 1 ; r < lelements.size() ; r++ )
					{
						String dataofrow = driver.findElement(By.xpath("(//div[@class='entry-title title-sm']//h3)["+r+"]")).getText();
						System.out.println("The row "+r+" has title "+dataofrow);
					}
		}
	}
	
	public void reset() throws InterruptedException
		{
			driver.findElement(By.xpath("//button[@id='btnclear']")).click();
			Thread.sleep(1000);
			
			
			
		}
	
	@AfterTest(description = "Close the browser")
	public void exit() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
}
