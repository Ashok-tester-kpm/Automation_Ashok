package Test_Form;
import java.io.IOException;
import java.time.Duration;
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

public class Membership_Form2 
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
			  
			driver.manage().window().maximize();
			driver.get("https://eccma.org/forms_demo/membership/full"); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			//Login Page verification & Validation
			String acttitle = driver.getTitle();
			String exptitle = "ECCMA | FULL MEMBERSHIP";
			Assert.assertEquals(acttitle, exptitle);
			Reporter.log("The Logged-in Page title is "+acttitle);
			System.out.println("");		
			
			/*
			driver.findElement(By.id("email")).sendKeys("dhileep@eccma.org");  
			driver.findElement(By.name("password")).sendKeys("Dhileep_123#"); 
			driver.findElement(By.xpath("//div//input[@id='acceptTerms']")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).submit();
			*/
		  }
		  
		  @Test(priority = 2)
		  public void reqchecktextfield() throws Exception
		  {
			  //Pre-set conditon to achieve required error text fields
			  //Membership Directory click yes 
			  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott active mdl']")).click();
			
			  //WOULD YOU LIKE TO RECEIVE UPDATES BY EMAIL OF NEW PUBLICATIONS AND OFFERS?
			  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott active mpo']")).click();
			  //ENTER NO. OF PEOPLE
			  Select nop = new Select(driver.findElement(By.xpath("//select[@id='no_of_people']")));
			  nop.selectByIndex(5);
			  
			  //WOULD YOU LIKE TO BE CONTACTED ABOUT SUBMITTING AN ARTICLE TO OUR BI-MONTHLY NEWSLETTER?
			  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott mpn'][contains(.,'Yes')]")).click();
			  
			  //ARE YOU INTERESTED IN ALSO OBTAINING YOUR ISO 8000 MASTER DATA QUALITY MANAGER CERTIFICATE OR NEED TO RENEW?
			  driver.findElement(By.xpath("//label[@class='btn btn-outline-success px-3 font-weight-semibold ls0 nott iso8000mdqm']")).click();
			  
			  //YOU CAN REGISTER SOMEONE ELSE (IN ADDITION TO THE PERSON WHO FILLS OUT THE FORM), SELECT THE TOTAL NUMBER OF REGISTRATIONS AND FILL IN THE REQUESTED INFORMATION FOR EACH OF THEM
			  Select ucanreg = new Select (driver.findElement(By.xpath("//select[@id='no_of_people']")));
			  ucanreg.selectByIndex(5);
			  
			  //Clicking for required field Error
			  driver.findElement(By.xpath("//button[@type='submit']")).submit();
			  
			  //Required-field check for Text-box
			  List<WebElement> tbox = driver.findElements(By.xpath("//input[@type='text'][@required]"));
			  System.out.println("The Number of Required Text Boxes are "+ tbox.size());
			  int i;
		
			  for(i = 0; i<tbox.size(); i++)
			  {
				  String tbname = tbox.get(i).getAttribute("id");
				 			  
				  try
				  {
					  if(driver.findElement(By.id(tbname + "-error")).isDisplayed())
					  	{
						  	//driver.findElement(By.id(tbname+"-error")).getText();
						  	System.out.println(tbname + " " + driver.findElement(By.id(tbname + "-error")).getText() );
					  	}
				  }
				  catch(Exception e)
				  		{
				  			System.out.println(tbname + " field " + tbox.get(i).getAttribute("required") + " " + "No Field is required error message displayed");
				  		}
			  }		  
		  }
		  
		  @Test(priority = 3)
		  public void Reqcheckdropdown()
		  {	  
			  //Required-field check for Drop-down 
			  List<WebElement> ddwn = driver.findElements(By.xpath("//span[@role='combobox']/ancestor::div[@class='col-sm-8']//select"));
			  System.out.println("The Number of Drop down Box "+ddwn.size());
			  for(int i = 0; i<ddwn.size(); i++)
			  {
				  String ddname = ddwn.get(i).getAttribute("id");
				  try
				  {
					  if(driver.findElement(By.id(ddname + "-error")).isDisplayed())
					  	{
						  	System.out.println(ddname + " " + driver.findElement(By.id(ddname + "-error")).getText() );
					  	}
				  }
				  catch(Exception e)
				  {
				  	  System.out.println(ddname + "field " + ddwn.get(i).getAttribute("required") + " " + "No Field is required error message displayed");
				  }
			  }
		  }	  
		  
		  @Test(priority= 4)
		  public void signin() throws InterruptedException
		  {
			  //Sign-In with a registered account
			  driver.findElement(By.xpath("//a[@id='autoload']")).click();
			  driver.findElement(By.xpath("//input[@type='text'][@id='login-form-username']")).sendKeys("ashok.kumar@eccma.org");
			  String loginadd = driver.findElement(By.xpath("//input[@type='text'][@id='login-form-username']")).getText();
			  driver.findElement(By.xpath("//input[@type='password'][@id='login-form-password']")).sendKeys("ak_8331#");
			  driver.findElement(By.xpath("//button[@value='login'][@id='login-form-submit']")).click();
			  String loginaddd = driver.findElement(By.xpath("//input[contains(@id,'admin_email')]")).getText();
			  Thread.sleep(5000);
			  if(loginadd== loginaddd)
			  {
				  System.out.println("Login succesful");
				  Reporter.log("Login Sucesfull");
			  }
			  else
			  {
				  System.out.println("Login unsuccesful");
				  Reporter.log("Login unsuccesful");
			  }
			  
			  //Don't have an account
			  //driver.findElement(By.xpath("//a[@id='dont_acc']")).click();
			  //Forgot password use case
			  //driver.findElement(By.xpath("//a[@id='autoload']")).click();
			  //driver.findElement(By.xpath("//input[@type='text'][@id='login-form-username']")).sendKeys("ashok.kumar@eccma.org");
			  //driver.findElement(By.xpath("//a[@id='forget_password']")).click();
			  //driver.findElement(By.xpath("")).click();
			  //driver.findElemnt(By.xpath("//div[contains(@class,'swal-footer')]")).isDisplayed();
			  //Check Email Received
			  //boolean passbox = driver.findElement(By.xpath("//div[@class='swal-footer'][contains(.,'OK')]")).isDisplayed();
			  //if(passbox == true)
			  //{
				//  System.out.println("The Password is sent to email box appears");
			  //}
			  
			  //Check with another email
			  //driver.findElement(By.xpath("//a[@href='https://eccma.org/forms_demo/membership/full')).click();
		  }
		  
		  @Test(priority = 5)
		  public void ALEI() throws InterruptedException
		  {
			Thread.sleep(10000);
			//Select your ALEI form Select your ALEI button 
			//1. Click Select your ALEI button
			driver.findElement(By.xpath("//a[@title='Organization can be made in the list to identify the ALEI']")).click();  

			//2.1 Register your ALEI 
			//driver.findElement(By.xpath("//a[@href='https://ealei.org/findmyalei'][contains(.,'Register your ALEI')]")).click();
			
			//2.1(o) Use Text box to search ALEI
			driver.findElement(By.xpath("//input[contains(@id,'searchalei')]")).sendKeys("BTL PLASTICS");/*Enter Legal name here completely or Enter ALEI no completely*/
			driver.findElement(By.xpath("//input[contains(@id,'search_class')]")).click();		
			Thread.sleep(5000);
			
			//2.1 Click on the radio button of registered ALEI company 
			driver.findElement(By.xpath("//input[contains(@value,'BTL')]")).click();
			
			//Select your Legal Name using page buttons
			//driver.findElement(By.xpath("//a[@id='but5']")).click();//selecting page no:5, 
			//driver.findElement(By.xpath("//input[@id='BE.CCD:0476.710.656']")).click();/*Enter ALEI no here*/
			
			//ALEI-Verification & Validation - ********
			String feed = "BE.CCD:0476.710.656"; /*** Always enter data here ***/
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
			
			//Copy address of ALEI as company Organization Address(Optional) ---- *********
			driver.findElement (By.xpath("//input[@id='alei_legal_chk']")).click();
			
		  }
		  
		  @Test(priority = 6)
		  public void tbx() throws InterruptedException
		  {  	
			  	//Set PRE-CON here		  
			  	//Oganization Name Others
			  	//driver.findElement(By.xpath("//input[@id='organization_name']")).sendKeys("TestingData");
			  
			  	//Date of Incorporation - Date Picker
				//To directly give date
			  	//driver.findElement(By.xpath("//input[@id='date_of_incorporation']")).sendKeys("16/12/2022");
				
				//Number of Employees 
				driver.findElement(By.xpath("//input[@id='no_of_employees']")).sendKeys("05");
			
			  	//Country 			  
				//Select ctry = new Select(driver.findElement(By.xpath("//div[@class='col-sm-8']//select[@id='country']")));
				//ctry.selectByVisibleText("India");				
				//Thread.sleep(5000);
				
				//State
				//Select state = new Select(driver.findElement(By.xpath("//div[@class='col-sm-8']//select[@id='state']")));
				//state.selectByVisibleText("Other");
				//Thread.sleep(2000);
			
				//City 
				//Select city = new Select(driver.findElement(By.xpath("//div[@class='col-sm-8']//select[@id='state']")));
				//city.selectByVisibleText("Other");		  
				
				//ENTER NO. OF PEOPLE
				Select nop = new Select(driver.findElement(By.xpath("//select[@id='no_of_people']")));
				nop.selectByIndex(5);
				
				//WOULD YOU LIKE TO BE CONTACTED ABOUT SUBMITTING AN ARTICLE TO OUR BI-MONTHLY NEWSLETTER? 
				driver.findElement(By.xpath("//div[@id='mpn']//label[@data-id='Yes']")).click();
				
				//Master Data Quality Manager Certification
				//ARE YOU INTERESTED IN ALSO OBTAINING YOUR ISO 8000 MASTER DATA QUALITY MANAGER CERTIFICATE OR NEED TO RENEW? 
				driver.findElement(By.xpath("//div[@id='iso8000mdqm']//label[@data-id='Yes']")).click();
				
				//YOU CAN REGISTER SOMEONE ELSE (IN ADDITION TO THE PERSON WHO FILLS OUT THE FORM), SELECT THE TOTAL NUMBER OF REGISTRATIONS AND FILL IN THE REQUESTED INFORMATION FOR EACH OF THEM.
				Select drp3 = new Select(driver.findElement(By.xpath("//select[@id='no_of_individual']")));
				drp3.selectByIndex(5);
				
				//for number field
				driver.findElement(By.xpath("//input[@id='admin_telephone']")).sendKeys("1234567989");
				
				//Enter Fax no 
				driver.findElement(By.xpath("//input[@id='admin_fax']")).sendKeys("123458");
				
				//Enter URL 
				driver.findElement(By.xpath("//input[@id='company_url']")).sendKeys("wwww.test.com");
				
				//chooseFile
				WebElement choosefile = driver.findElement(By.xpath("//input[@id='member_directory_logo']"));
				choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\6.jpg");
				
				//for Email 
				List<WebElement> email =  driver.findElements(By.xpath("//input[@type='email']"));
				for(int j = 1; j<email.size(); j++)
				{
					email.get(j).sendKeys("test@test.com");
				}
				
				//Dropdown country 1
				//Select adn1 = new Select (driver.findElement(By.xpath("//select[@id='additional_country1']")));
				//adn1.selectByVisibleText("India");		
				//Thread.sleep(10000);
				
			  	//Dropdown state 1 
				//Select ads1 = new Select (driver.findElement(By.xpath("//select[@id='additional_state[]']")));
				//ads1.selectByIndex(1);		
				//Thread.sleep(10000);
				
				//Dropdown state 1 
				//Select adc1 = new Select (driver.findElement(By.xpath("//select[@id='additional_city1']")));
				//adc1.selectByIndex(1);		
				
				//Text-box date feed test
				List<WebElement> txtbx = driver.findElements(By.xpath("//div[@class='col-sm-8']//input[@type='text']")); 
				int x = txtbx.size();
				for (int i = 1; i<x ; i++)
				{
					try
					{
						if(i == 13 || i == 14 || i == 16)
							{
								System.out.println("Leaving Number Field");
							}
						else
							{
								txtbx.get(i).sendKeys("Testingdata");
								Thread.sleep(2000);
							}
					}
					catch(Exception e)
					{
						continue;
					}
				}
		  }

		  @Test(priority = 7)
		  public void dbx() throws InterruptedException
		  {
		  	  	String dropdown_array[] = { "additional_country1","additional_state1","additional_city1",
		  	  								"additional_country2","additional_state2","additional_city2",
		  	  								"additional_country3","additional_state3","additional_city3",
		  	  								"additional_country4","additional_state4","additional_city4",
		  	  								"additional_country5","additional_state5","additional_city5" };
				int d = 0;
				for (String y : dropdown_array) 
				{
					String field_submit_id = String.valueOf(y);
					if (driver.findElements(By.id(field_submit_id)).isEmpty()) 
					{	
						System.out.println(field_submit_id + " - *value not set");
					} 
					else 
					{			 
							String feedArray[] = {"Romania", "Other", "Other",
												  "Qatar", "Other", "Other",
												  "Scotland", "Other", "Other",
												  "Taiwan", "Other", "Other",
												  "United States", "Other", "Other"};
							
						    Select se = new Select(driver.findElement(By.id(field_submit_id)));
							se.selectByVisibleText(feedArray[d]);
							Thread.sleep(5000);
					}		
				d++;
				} 	
		  	}	
		  
		  @Test(priority = 8)		  
		  public void companyorg()
		  {
			  	//Company_Organization_information 
			  	//With ALEI ***************
			  	String orgothers = driver.findElement(By.xpath("//span[@id='select2-organization-container']")).getText();	
			  	boolean orgo = driver.findElement(By.xpath("//span[@id='select2-organization-container']")).isDisplayed();
			  	System.out.println(orgothers);
			  	//check Organization text-box is displayed
			  	if(orgo == true)
				{
			  		WebElement Organization = driver.findElement(By.xpath("//input[@id='organization_name']"));
			  		String Oname = Organization.getAttribute("value");			  		
			  		if(Oname == "btl plastics")
			  		{
			  			System.out.println("The Organization Name "+ Oname + " is Displayed");
			  		}
			  		else
			  		{
			  			System.out.println("The organization Name is not Displayed");
			  		}
				}
			  	
			  	//Without ALEI **************
			  	//Select Organization within the list as Indiviual
				//Select oz = new Select(driver.findElement(By.xpath("//select[@id='organization']")));
				//oz.selectByVisibleText("ETesters");
				//for others in Organization name
				//String orgothers2 = driver.findElement(By.xpath("//span[@id='select2-organization-container']")).getText();
				//if(orgothers2 == "Other")
				//{
				//	driver.findElement(By.xpath("//input[@id='organization_name']")).sendKeys("test");
				//	String Organization2 = driver.findElement(By.xpath("//input[@id='organization_name']")).getText();
			  	//	Reporter.log(Organization2);
				//}
				
				//Date of Incorporation - Date Picker
				driver.findElement(By.xpath("//input[@id='date_of_incorporation']")).sendKeys("16/12/2022");
				WebElement date = driver.findElement(By.xpath("//input[@id='date_of_incorporation']"));
				String datetime = date.getAttribute("value");
				System.out.println("The Entered datae is " +datetime);
				Reporter.log(datetime);
				
				//Number of Employees 
				driver.findElement(By.xpath("//input[@id='no_of_employees']")).sendKeys("05");
				String noe = driver.findElement(By.xpath("//input[@id='no_of_employees']")).getText();
				Reporter.log(noe);
				
				//Industry
				Select industry = new Select(driver.findElement(By.xpath("//select[@id='industry']")));
				industry.selectByVisibleText("Government");
				
				String indothr = driver.findElement(By.xpath("//select[@id='industry']")).getText();
				if(indothr == "Other")
				{
					driver.findElement(By.xpath("//input[@id='other_txtbox']")).sendKeys("test");
				}				
				//HOW DID YOU HEAR ABOUT THIS MEMBERSHIP?
				Select membership =  new Select(driver.findElement(By.xpath("//select[@id='source_from']")));
				membership.selectByVisibleText("Facebook");/*select value*/
				Reporter.log(driver.findElement(By.xpath("//select[@id='source_from']")).getText());
			
				String memother = driver.findElement(By.xpath("//select[@id='source_from']")).getText();
				if(memother == "Others")
				{
					driver.findElement(By.xpath("//input[@id='source_txt']")).sendKeys("Facebook");
					Reporter.log(driver.findElement(By.xpath("//input[@id='source_txt']")).getText());
				}
		  }
		  
		  @Test(priority = 9)
		  public void report()
		  {
			  	//Reporter for Text Fields
			  	List<WebElement> txtbx = driver.findElements(By.xpath("//input[@type='text']")); 
				int x = txtbx.size();	
				for (int i = 1; i<x ; i++)
				{
					try 
					{
						String address = txtbx.get(i).getAttribute("name");
						String text = txtbx.get(i).getAttribute("value");
						System.out.println(address+text);						
						Reporter.log("The Field "+ address + "data is" + text);
					}
					catch(Exception e)
					{
						System.out.println("no message");
					}
				}	
		  }

		@Test(priority = 8) 
		public void submit()
		{
			  //Apply for certificate under cost
			  driver.findElement(By.xpath("//input[@id='mdqm_chk']")).click();
			  
			  //Submit form here
			  driver.findElement(By.xpath("//button[@id='submit_button']")).submit();

		  }
		
		public void paypal()
		{
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dhileep-buyer@eccma.org");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dhileep@123");
			driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
			
		}
}