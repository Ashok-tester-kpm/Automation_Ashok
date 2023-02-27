package Test_Form;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssociateMember 
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
			  Reporter.log("Selenium runs Automation in chrome for ECCMA associtate memeber form");
			  System.out.println("Automation on Chrome begins for ECCMA associtate memeber form");
		  }
		  else if(browsername.equals("edge"))
		  {
			  driver = new EdgeDriver();  
			  Reporter.log("Selenium runs Automation in Edge for ECCMA associtate memeber form");
			  System.out.println("Automation on edge begins for ECCMA associtate memeber form");
		  }	
	  }
	  
	  //Page Verificaton 
	  @Test(priority = 1)
	  public void Navigate() throws IOException, Exception
	  {		  
		driver.manage().window().maximize();
		driver.get("https://eccma.org/forms_demo/membership/associate"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Page Validation
		String acttitle = driver.getTitle();
		String exptitle = "ECCMA | ASSOCIATE MEMBERSHIP";
		
		//Login Page verification & Validation
		if(acttitle == exptitle )
		{
			System.out.println("The Page title validation is passed");
			Reporter.log("The Page title verification is passed");
		}
		else
		{
			System.out.println("The Page title validation is FAILED");
			Reporter.log("The Page title validation is FAILED");
		}
	  }
	  
	  //Select this method to validate LOGIN credential
	  @Test(priority = 2) 
	  public void logincheck()
	  {
		  	//Login page
		  	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//a[@href='#'][contains(.,'SIGN IN')]"))));
		  	
		  	//Feed User-name and Password
		  	driver.findElement(By.id("login-form-username")).sendKeys("ashok.kumar@eccma.org");  
			driver.findElement(By.name("login-form-password")).sendKeys("ak_8331#"); 
			
			//Use to click on login
			driver.findElement(By.xpath("//div//input[@id='login-form-submit']")).click();
			
			//Use to click on Forgot Password Validation
			driver.findElement(By.xpath("//button[@id='forget_password']")).click();
			
			//Use to close the login page
			driver.findElement(By.xpath("//a[@id='dont_acc']")).click();
	  }
	  
	  //Enter ALEI data 
	  @Test(priority = 3)
	  public void alei() throws InterruptedException
	  {
		    //Select your ALEI 
		    driver.findElement(By.xpath("//a[@href='#'][contains(.,'Select your ALEI')]")).click();
		  
		    //Feed search ALEI text box
		    driver.findElement(By.xpath("")).sendKeys("");
		  
		    //2.1 Register your ALEI 
			driver.findElement(By.xpath("//a[@href='https://ealei.org/findmyalei'][contains(.,'Register your ALEI')]")).click();
			
		    //2.1(o) Use Text box to search ALEI
			driver.findElement(By.xpath("//input[contains(@id,'searchalei')]")).sendKeys("BTL PLASTICS");/*Enter Legal name here completely or Enter ALEI no completely*/
			driver.findElement(By.xpath("//input[contains(@id,'search_class')]")).click();		
			Thread.sleep(5000);
			
			//2.1 Click on the radio button of registered ALEI company 
			driver.findElement(By.xpath("//input[contains(@value,'BTL')]")).click();
			
			//Select your Legal Name using page buttons
			driver.findElement(By.xpath("//a[@id='but5']")).click();//selecting page no:5, 
			driver.findElement(By.xpath("//input[@id='BE.CCD:0476.710.656']")).click();/*Enter ALEI no here*/
			
			//ALEI-Verification & Validation - ********
			String feed = "BE.CCD:0476.710.656"; //*** Always enter data here ***//
			String selected = driver.findElement(By.xpath("//input[@id='alei']")).getAttribute("title");
			System.out.println(selected);
			try
			{
				Assert.assertEquals(feed, selected);
				System.out.println("The ALEI selected is the same as displayed");
			}
			catch(Exception e)
			{
				String result = e.getMessage();
				System.out.println(result);	
			}
			
			//Copy address of ALEI as company Organization Address(Optional)
			driver.findElement (By.xpath("//input[@id='alei_legal_chk']")).click();	  
			
	  }
	  
	 //Enter a company Organization
	 @Test(priority = 4)
	 public void comporg()
	 {
		//Get Organization name selected  
		String org = driver.findElement(By.xpath("//span[@id='select2-organization-container']")).getText();
		
		
		if(org == "Select Organization")
		{
			//Validate Dropdown by checking all options
			Select organization = new Select(driver.findElement(By.xpath("//select[@id='organization']")));
			List<WebElement> odpdw =  organization.getOptions();
			
			//Verify Dropdown is empty 
			if(odpdw.isEmpty())
				{
					System.out.println("The drop dow options are available");
				}
			
			//Print out All drop Down values
			else
				{
					for(int o = 0; o<odpdw.size(); o++)
						{
							System.out.println("The drop Down is loaded with follwoing Options");
							System.out.println(odpdw.get(o).getText());
						}
				}			
		}
		
		else if(org == "Other")
		{
			String orgname = driver.findElement(By.xpath("//input[contains(@id,'organization_name')]")).getText();
			System.out.println("The Selected organization " + orgname);
		}
		
		else if(org == null)
		{
			System.out.println("The Organization dropdown box is null");
		}
		
		else
		{
			//Organization name
			String oname = driver.findElement(By.xpath("//input[@id='organization_name']")).getText();
			System.out.println("The Organization Name Selected is "+ oname);
		}
		
		//DATE OF INCORPORATION
		driver.findElement(By.xpath("//input[@id='date_of_incorporation']")).sendKeys("");
		String doi = driver.findElement(By.xpath("//input[@id='date_of_incorporation']")).getText();
				
					if(doi == null)
						{
							System.out.println("The Date of incorporation field is null");
						}
					
					else
						{
							System.out.println("The Date of incorporation is " + doi);
						}	
		
		//NUMBER OF EMPLOYEES
		driver.findElement(By.xpath("//input[@id='no_of_employees']")).sendKeys("10");			
		String nofe = driver.findElement(By.xpath("//input[@id='no_of_employees']")).getText(); //Read Data from NOE text field.
		if(nofe == null)
		{
			System.out.println("The No of Employee field is empty");
		}
		else
		{
			String actval = nofe;
			String expval = "10"; // always enter value here 
			if(actval == expval) 
			{
				System.out.println("The No Of Employees " + nofe );
			}
			else
			{
				System.out.println("The no of employee field is empty");
			}
		}
		
		//INDUSTRY DROP DOWN
		String indus = driver.findElement(By.xpath("//span[@id='select2-industry-container']")).getText();
		List<WebElement> indusdop = driver.findElements(By.xpath("//select[@id='industry']"));
		if(indus == "Select Industry" )
		{
			System.out.println("The Industry drop down values is not selected ");
		}
		else if(indusdop.isEmpty())
		{
			System.out.println("The Industry drop down is empty");
		}
		else if(indus == "Other")
		{
			String indusother = driver.findElement(By.xpath("//input[@id='other_txtbox']")).getText();
			System.out.println("The name of the Industrt is "+ indusother);
		}
		
		//HOW DID YOU HEAR ABOUT THIS MEMBERSHIP
		//Validation 1 - check for field is empty
		String ADMEM = driver.findElement(By.xpath("//select[@id='source_from']")).getText();     
			if(ADMEM == null)
					{
						System.out.println("HOW DID YOU HEAR ABOUT THIS MEMBERSHIP field is empty, validation passed ");
					}
		
			else 
					{
						System.out.println("The field is not empty, The date present is " + ADMEM);
					}
		
		//Validation 2 - Select or feed drop-down value.	
		Select ADMEM_DRPDWN = new Select(driver.findElement(By.xpath("//span[@id='select2-industry-container']")));
		ADMEM_DRPDWN.selectByValue("Website");	
		
		//To collect all drop-down options 
		List <WebElement> ADMEM_LIST = ADMEM_DRPDWN.getOptions();
		
		//Separate String to collect the drop down value after selecting.
		String ADMEM_DPDN = driver.findElement(By.xpath("//select[@id='source_from']")).getText(); 
		
			//The Drop-Down value check
			if(ADMEM_DPDN == "Select Source")	
					{
						System.out.println("The drop down value is not set");
					}
			if (ADMEM_DPDN == null)
					{
						System.out.println("The drop down value is empty");
					}
			if (ADMEM_DPDN != null)
					{
						//The Drop-Down text field is WAfxc
						WebElement ADMEM_TB = driver.findElement(By.xpath("source_txt"));
						if(ADMEM_TB.isDisplayed())
						{
							System.out.println("The Dependent Text Field of HOW DID YOU HEAR ABOUT THIS MEMBERSHIP is Displayed");
						}
						
						for(int j = 0 ; j < ADMEM_LIST.size() ; j++ )
						{
							System.out.println("The drp down options are "+ ADMEM_LIST.get(j).getText());
						}
					}
			
	 }
	 
	 @Test(priority = 5)
	 public void Companyinfo()
	 {
		//Validation 3 - Company/Organization Address Information	
		//Check the Text field is empty
		//For Street Address 
		String  STREET_ADDRESS = driver.findElement(By.xpath("//input[@id='address']")).getText();
		
			//Company-Organization		
			if(STREET_ADDRESS != null )
						{
								System.out.println("The Street Address text field is not empty at the start");
						}
			if(STREET_ADDRESS == null)
						{
								System.out.println("The Street ");
						}	
			
		//Validation 4 - Company/Organization Address Information	
		String country = driver.findElement(By.xpath("//select[@id='address']")).getText();
			
			//Country-Organization Text Field should be empty at start  
			if(country  ==  null  )
						{
							System.out.println("The value in the test field is empty,Test for Text field empty at start");
						}
			
			//Check the Text field is lower/upper case 	
			//Characters (A-Z, 0-9) And Special Characters (& /. ( ) - , ' # ; :) Are Allowed With Single Space
			//Minimum 3 letters
		 	
	 }	 
}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  