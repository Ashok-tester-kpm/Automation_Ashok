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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Publications_Mainpage 
{
	public WebDriver driver; 
	@BeforeClass
	public void browser_setup()
	  {
		  //Setting up capabilities to run our test script
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  Reporter.log("Selenium runs Automation in chrome for SDM");
		  System.out.println("Automation on Chrome begins");
	  }
	
	@BeforeTest
	public void url_run()
	  {
			driver.get("https://eccma.org/forms_demo/Publicationsdemo/"); 
			Reporter.log("The Title of the page is "+ driver.getTitle()+" ");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String urlactual = driver.getCurrentUrl();
			String urlexpect = "https://eccma.org/forms_demo/Publicationsdemo/";
			Assert.assertEquals(urlactual,urlexpect);
	  }
	
	@Test(priority = 1, description="Category Drop-down check")
	public void category_drpdown()
	{
		Select category = new Select(driver.findElement(By.xpath("//select[@id='category']")));
		List<WebElement> cat = category.getOptions();
		ArrayList<String> dropcont = new ArrayList<>();
		
		for(int i = 0 ; i < cat.size() ; i ++)
			{
				System.out.println(cat.get(i).getAttribute("value"));
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
		
		System.out.println(dropcont.size());
		
		if(catdrop.equals(dropcont))
		{
			System.out.println("pass");
		}
		else
		{
			catdrop.removeAll(dropcont);
			for(int c = 0 ; c < catdrop.size() ; c ++)
			{
				System.out.println("The drop down content did not match the required list ");
				System.out.println("The Un-Matched content found is "+catdrop.get(c));
			}
		}
		
		//Check for By default-drop down value 
		String catval = driver.findElement(By.xpath("//select[@id='category']")).getText();
		if(catval == "Whitepaper")
			{
				System.out.println("The default value in dropdown is Whitepaper");
			}
		else
			{
				System.out.println("The default value in dropdown is Whitepaper"+catval);
			}
			
		//Select Category drop-down Value
		category.selectByValue("All");
		String catval1 = driver.findElement(By.xpath("//select[@id='category']")).getText();
		if(catdrop.contains(catval1))
			{
				System.out.println("The Value selected is in the category drop-down");
			}
	}
	
	@Test(priority = 2)
	public void search_author() throws InterruptedException
	{
		//Search Files using Search Author
		driver.findElement(By.id("author_inputs")).sendKeys("Peter$#");

		//Submit
		driver.findElement(By.xpath("//button[@id='btnsearch']")).click();
		Thread.sleep(1000);
		
				if( driver.getPageSource().contains("rick"))
						{
							System.out.println("search is working");
						}
				else if(driver.getPageSource().contains("No Records Found...")) 
						{
							System.out.println("search is working - No files are found");
						}
				else
						{
							System.out.println("search fail");
						}
				
		 String searchauthortext = driver.findElement(By.id("author_inputs")).getText();		
		 String alphanum = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
		 Pattern p = Pattern.compile(alphanum);
		 if(searchauthortext == null)
		 	{
			 	System.out.println("The Search Author field is empty");
		 	}
		Matcher m = p.matcher(alphanum);
		System.out.println("The Search Author field text enterd is alhpanum "+m.matches());
		 
	}
}
