package MDQM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class MDQM_Indiviuals 
{
		//Setting up capabilities to run our test script
		public static  WebDriver driver ;
		public static HSSFWorkbook workbook;
		public static HSSFSheet sheet;
		public static Map<String, Object[]> TestNGResults;
		//public static UIMap uimap;
		//public static UIMap datafile;
		
		//Browser loader
		@Test(priority = 1 , description = "Browser Setup")
		public static  void browser_setup()
		  {
			  ChromeOptions option = new ChromeOptions();
	          option.addArguments("--remote-allow-origins=*");
	          driver = new ChromeDriver(option);	
			  driver.manage().window().maximize();
			  Reporter.log("Selenium runs Automation in chrome for SDM");
			  System.out.println("Automation on Chrome begins");
			  
		  }

		//URL Loader
		@Test(priority = 2 , description = "URL Test")
		public static  void url_run() throws IOException, InterruptedException
		  {
				
				driver.get("https://eccma.org/forms_demo/mdqm#"); 
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				String urlactual = driver.getCurrentUrl();
				
				String urlexpect = "https://eccma.org/forms_demo/mdqm#";
				
				//Screenshot of loaded page
				captureScreenshot("MDDQMpage", ".png");
				
				
				if(urlactual.equals(urlexpect))
					{
						TestNGResults.put("2", new Object[] { 1d, "Navigate to "+urlexpect, urlexpect+" url gets Loaded.", "Pass"});
					}
				
				else 
					{
						TestNGResults.put("2", new Object[] { 1d, "Navigation Failed for "+urlexpect, urlexpect+" url did not Load.", "Fail"});
					}
		  }
		
		//Email Loader
		@Test(priority = 3, description = "Select training option")
		public static void registeremail() throws IOException, InterruptedException
			{
				//Select one at a time 
				//To select Online self Study 
				driver.findElement(By.xpath("//div[@class='form-check']//input[@id='online_self_study']")).click();
				
				//To select Online Scheduled Instructor – Led (cost)
				//driver.findElement(By.xpath("//div[@class='form-check']//input[@id='online_instructor']")).click();
				
				//To select COMPANY GROUP INSTRUCTOR – LED (COST)
				//driver.findElement(By.xpath("//div[@class='form-check']//input[@id='company_instructor']")).click();
				
				//Use test Case
				boolean check1 = driver.findElement(By.xpath("//div[@class='form-check']//input[@id='online_self_study']")).isSelected();
				boolean check2 = driver.findElement(By.xpath("//div[@class='form-check']//input[@id='online_instructor']")).isSelected();
				boolean check3 = driver.findElement(By.xpath("//div[@class='form-check']//input[@id='company_instructor']")).isSelected();
				
				String check1val = driver.findElement(By.xpath("//div[@class='form-check']//input[@id='online_self_study']")).getAttribute("value");
				String check2val = driver.findElement(By.xpath("//div[@class='form-check']//input[@id='online_instructor']")).getAttribute("value");
				String check3val = driver.findElement(By.xpath("//div[@class='form-check']//input[@id='company_instructor']")).getAttribute("value");
				
						if(check1 != true & check2 != true & check3 != true)
							{
								TestNGResults.put("3", new Object[] { 2d, "Check All Training options Displayed", "Available", "Pass" });
							}
						else
							{
								TestNGResults.put("3", new Object[] { 2d, "Check All Training options Displayed", "Not Availble", "Pass" });
							}
						
						if (check1 != true & check2 != false & check3 != false)
							{
								TestNGResults.put("4", new Object[] { 3d, "Check Training options selected", ""+check1val+"", "Pass" });
							}
						else if (check1 != false & check2 != true & check3 != false)
							{
								TestNGResults.put("4", new Object[] { 3d, "Check Training options selected", ""+check2val+"", "Pass" });
							}
						else if (check1 != false & check2 != false & check3 != true)
							{
								TestNGResults.put("4", new Object[] { 3d, "Check Training options selected", ""+check3val+"", "Pass" });
							}
						else
							{
								TestNGResults.put("4", new Object[] { 3d, "Check Training options selected", "No option Selected", "Pass" });
							}
				
				//Enter email ID 
				driver.findElement(By.xpath("//input[@id='checkemail']")).sendKeys("ashok.kumar@eccma.org");
				
				//Screenshot to note email registered
				captureScreenshot("RegisteredEmail", ".png");
				
				//Click on confirm 
				driver.findElement(By.xpath("//a[@id='mailconfirmbtn']")).click();
				
				acessemailotp();
			}
		
		//Access email read OTP code and deliver back to the verification TAB
		private static void acessemailotp() throws IOException, InterruptedException
			{
				//Opens a new window and switches to new window
				driver.switchTo().newWindow(WindowType.TAB);
			
				System.out.println("Reading OTP from E-Mail ");
				
				//Opens round-cube mail home-Page in the newly opened tab
				driver.navigate().to("https://server.vni.ayp.mybluehostin.me:2096/?locale=en\\");
				driver.findElement(By.id("user")).sendKeys("ashok.kumar@eccma.org");
				driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Ask_2394#");
				driver.findElement(By.id("login_submit")).click();
				
				//Email with security code
				List<WebElement> securitycode = driver.findElements(By.xpath("//span[@class='subject']//span[@id][@title='Unread ']/following-sibling::a//span"));
				System.out.println("The size are "+securitycode.size());
				
				int otp;
				securitycode.get(0).click();
				
				//Switch to frame, to get OTP id.
				driver.switchTo().frame(driver.findElement(By.id("messagecontframe")));
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				WebElement ele = driver.findElement(By.xpath("//p//b[@style='font-size: 25px; font-family: Arial']"));
				wait.until(ExpectedConditions.visibilityOf(ele)).click();
				
				//Screenshot to note email OTP
				captureScreenshot("OTPreceived", ".png");
				
				String getotp = ele.getText();
				
				otp = Integer.parseInt(getotp);  

				System.out.println("The OTP code is "+ otp);
				driver.switchTo().parentFrame();
				
				//Pass OTP to get the value
				enterotp(getotp);
			}
		
		//Enter OTP in OTP field
		public static void enterotp(String otp) throws IOException, InterruptedException
			{
				//To Get all Tabs in browser and Switch back to window
				ArrayList<String> alltabs = new ArrayList<String> (driver.getWindowHandles());
			    
				driver.switchTo().window(alltabs.get(0));
				
				//To click on cancel
				//driver.findElement(By.xpath("//a[@class='resetBtn btn btn-sm btn-danger']")).click();
				//To click on Ok button
				driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
				
				//Write OTP from email to here
				driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);	
				
				//Verify button
				driver.findElement(By.xpath("//a[@id='otpVerifybtn']")).click();
				
				if((driver.findElement(By.xpath("//div[@class='swal-modal']//div[@class='swal-text']")).isDisplayed()) == true)
					{
						System.out.println("Invalid OTP entered"+otp);
						TestNGResults.put("4", new Object[] { 4d, "OTP verification", "Entered OTP-"+otp+" is wrong", "Fail" });
					}
				else if((driver.findElement(By.xpath("//div[@class='swal-modal']//div[@class='swal-text']")).isDisplayed()) == false)
					{
						System.out.println("Correct OTP entered"+otp);
						TestNGResults.put("4", new Object[] { 4d, "OTP verification", "Entered OTP-"+otp+" is correct", "Pass" });
					}
						
				
				JavascriptExecutor js = (JavascriptExecutor) driver;  
				js.executeScript("scroll(0,450)"); 
				
				//OTP Verified
				captureScreenshot("OTPentered", ".png");
				
				
				if(driver.findElement(By.xpath("//form[@id='mdqmtraining']//div[@id='fieldsBlock']")).isDisplayed() == true)
					{
						System.out.println("MDQM new Filling Form openss");
						TestNGResults.put("5", new Object[] { 5d, "MDQM Form verification", "MDQM new Filling Form opens", "Pass" });
					}
				else
					{
						System.out.println("Invalid OTP entered"+otp);
						TestNGResults.put("5", new Object[] { 5d, "MDQM Form verification", "MDQM new Filling Form not present", "Fail" });
					}
			}
		
		 //Takes take screenshot
	     private static void captureScreenshot(String filename, String extension) throws IOException, InterruptedException
			 {
	    	 	 Thread.sleep(3000);
	    	 	 
				 // Take the screenshot and store as file format
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				 // Open the current date and time
				 String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(new Date());
	
				 //Copy the screenshot on the desire location with different name using current date and time
				 FileUtils.copyFile(scrFile, new File("E:\\Testing\\Projects Undertaken\\ECCMA\\Bug Museum\\screenshots\\"+filename+" "+ timestamp+extension));
			 }
	     
	     
	     //Collect and check text field for validation
	     @Test(priority = 4, description = "Test the Text fields")
	     public static void textfield()
	     {
	    	 System.out.println("printing texts");
	    	 ArrayList<String> textfields = new ArrayList<>();
	    	 List<WebElement> tf = driver.findElements(By.xpath("//input[@type='text']")); 
	    	 
	    	 for(int a = 0 ; a < tf.size() ; a++)
		    	 {
	    		 		if(tf.get(a).isDisplayed() & tf.get(a).getAttribute("id") != "UserCaptchaCode")
		    		 		{
		    		 			textfields.add(tf.get(a).getAttribute("value"));
		    		 			System.out.println(tf.get(a).getAttribute("placeholder")+" : "+tf.get(a).getAttribute("value"));
		    		 		}
		    	 }
	    	 
	    	 for(int b = 0 ; b < textfields.size() ; b++)
		    	 {
		    		 checker(textfields.get(b));
		    	 }
	     }
	     
	     public static void checker(String data)
	     {
		    	String n = ".*[0-9].*";
		    	String a = ".*[A-Z].*"; 
		    	
		    	boolean s = data.contains("@/.");
		    	
		    	if(data.matches(n) == true & data.matches(a) == true )
				 	{
					 	System.out.println("Alhpanum characters are given in "+data);
				 	}
				 
				if(data.matches(n) == true & data.matches(a) == false)
					 {
					 	System.out.println("Number characters only present in "+ data);
					 }
				 
				else if(data.matches(a) == true & data.matches(n) == false)
					 {
						System.out.println("The data contains alphabets only " + data);
					 }
	     }
	     
	    //Check drop down field are existing open
	    @Test(priority = 5)
	    public static void dropdown()
	     {
	    	 //Page Hover
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;  
			 js.executeScript("scroll(0,450)"); 
			 
	    	 //For Individual
	    	 if(driver.findElement(By.xpath("//input[@type='radio'][@id='individual']")).isSelected())
		    	 {
		    		 System.out.println("Indiviual is selected");
					 TestNGResults.put("6", new Object[] { 6d, "Institution Selected", "Indiviual", "Pass" });
		    	 }
	    	 
	    	 //For Student 
	    	 else if(driver.findElement(By.xpath("//input[@type='radio'][@id='student']")).isSelected())
		    	 {
	    		 	 System.out.println("The Student is selected as institution");
	    		 	 TestNGResults.put("6", new Object[] { 6d, "Institution Selected", "Student", "Pass" });
	    		 	 
		    		 boolean sel =  driver.findElement(By.xpath("//span[@id='select2-organization-container']")).isDisplayed();
		    		
		    		 if(sel == true)
			    		 {
			    			 System.out.println("The University or School drop down open for student option");
			    			
			    			 TestNGResults.put("7", new Object[] { 7d, "University drop-dwon Displayed", "Displayed", "Pass" });
			    			 
			    			 WebElement checkofd = driver.findElement(By.xpath("//span[@id='select2-organization-container']"));
			    			 
			    			 String checkotherfd  = checkofd.getAttribute("value");
			    			 
			    			 if(checkotherfd == "other")
			    			 	{
			    				 	System.out.println("The other field is opened for University");
			    				 	
			    				 	TestNGResults.put("8", new Object[] { 8d, "University drop-dwon - other Displayed", "Yes", "Pass" });
			    			 	}
			    			 else
			    			 {
			    				 TestNGResults.put("8", new Object[] { 8d, "University drop-dwon - other Displayed", "Not Selected", "Pass" });
			    			 }
			    		 }
		    		 else
			    		 {
			    			 System.out.println("The University or school dropdown not displayed");
			    			 TestNGResults.put("7", new Object[] { 7d, "Institution Selected", "Student", "Pass" });
			    			 TestNGResults.put("8", new Object[] { 8d, "University drop-dwon - other", "N/a", "Pass" });
			    		 }
		    	 }
	    	 
	    	 
	    	 //For company
			 else if(driver.findElement(By.xpath("//input[@type='radio'][@id='org']")).isSelected())
			    	 {
						 System.out.println("Company is selected");
						 TestNGResults.put("6", new Object[] { 6d, "Institution Selected", "Company", "Pass" });	
				 
			    		 boolean sel =  driver.findElement(By.xpath("//span[@id='select2-organization-container']")).isDisplayed();
				    		
			    		 if(sel == true)
				    		 {
				    			 System.out.println("The Comapny drop down open for student option");
				    			 
				    			 TestNGResults.put("7", new Object[] { 7d, "University drop-dwon Displayed", "Displayed", "Pass" });
				    			 
				    			 WebElement checkofd = driver.findElement(By.xpath("//span[@id='select2-organization-container']"));
				    			 
				    			 String checkotherfd  = checkofd.getAttribute("value");
				    			 
				    			 if(checkotherfd == "other")
				    			 	{
				    				 	System.out.println("The other field is opened for University");
				    				 	TestNGResults.put("8", new Object[] { 8d, "University drop-dwon - other", "Other", "Pass" });
				    			 	}
				    			 else
				    			 {
				    				 TestNGResults.put("8", new Object[] { 8d, "University drop-dwon - other", "DNS", "N/A" });
				    			 }
				    		 }
			    		 else
				    		 {
				    			 System.out.println("The University or school dropdown not displayed");
				    			 TestNGResults.put("7", new Object[] { 7d, "Institution Selected", "Student", "Pass" });
				    			 TestNGResults.put("8", new Object[] { 8d, "University drop-dwon - other", "N/A", "Pass" });
				    		 }
			    	 }
			  
			 else
					 {
						 System.out.println("No Institution is Selected ");
						 TestNGResults.put("6", new Object[] { 6d, "Institution Selected", "DNS", "FAIL" });
						 TestNGResults.put("7", new Object[] { 7d, "Institution Dropdown", "DNS", "FAIL" });
						 TestNGResults.put("8", new Object[] { 8d, "University Dropdwon - other", "DNS", "FAIL" });
					 }
	    	 
	    	 //Page Hover
	    	 JavascriptExecutor js2 = (JavascriptExecutor) driver;  
			 js2.executeScript("scroll(0,450)"); 
	     }
	     
	     //Check dropdown field are 
	     @Test(priority = 6)
	     public static void telephone()
		     {
		    	 JavascriptExecutor js = (JavascriptExecutor) driver;  
				 js.executeScript("scroll(0,900)"); 
				 
				 if(driver.findElement(By.xpath("//div[@class='selected-flag'][@title]")).isDisplayed() == true && driver.findElement(By.xpath("//input[@type='number']")).isDisplayed() == true)
					 {
						 String flagname = driver.findElement(By.xpath("//div[@class='selected-flag'][@title]")).getAttribute("title");
				    	 String phoneno = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
				    	 String n = ".*[0-9].*";
				    	 System.out.println("The telephone country selected is "+ flagname + " The field has only number "+ phoneno.matches(n) +" "+ phoneno);
				    	 TestNGResults.put("9", new Object[] { 9d, "Institution Selected", "None", "Pass" });
					 }
				 
				 else if(driver.findElement(By.xpath("//div[@class='selected-flag'][@title]")).isDisplayed() == false && driver.findElement(By.xpath("//input[@type='number']")).isDisplayed() == false)
					 {
					 	TestNGResults.put("9", new Object[] { 9d, "Telephone Field", "Pass", "Pass" });
					 }
		     }
	     
	    //Check-Boxes to be selected
	    @Test(priority = 7)
	    public static void paymentmethods()
		     {
		      try 
		    	 {
			    	 JavascriptExecutor js = (JavascriptExecutor) driver;  
					 js.executeScript("window.scrollBy(0,350)", ""); 
					 
					 driver.findElement(By.xpath("//input[@id='mdqm_chk']")).click();
					 
			    	 boolean fiftyusd = driver.findElement(By.xpath("//input[@id='mdqm_chk']")).isSelected();
			    	 
			    	 if(fiftyusd == true)
				    	 {
			    			    TestNGResults.put("10", new Object[] { 10d, "Payment Method Selected", "Yes", "Pass" });
			    		 
			    		 		WebElement check1,check2,check3;
			    		 		check1 = driver.findElement(By.xpath("//input[@id='Cheques']"));
			    		 		check2 = driver.findElement(By.xpath("//input[@id='wire_transfer']"));
			    		 		check3 = driver.findElement(By.xpath("//input[@id='credit_card']"));
			    		 		
			    		 		if(check1.isDisplayed() == true & check2.isDisplayed() == true & check3.isDisplayed() == true)
				    		 		{
				    		 			System.out.println("All Payment Mehtods are displyed");
				    		 			TestNGResults.put("11", new Object[] { 11d, "All Payment Methods Present", "Yes", "Pass" });
				    		 		}
			    		 		else
				    		 		{
				    		 			System.out.println("All Payment Mehtods are displyed");
				    		 			TestNGResults.put("11", new Object[] { 11d, "All Payment Methods Present", "No", "Fail" });
				    		 		}
			    		 		
			    		 		if(check1.isEnabled())
				    		 		{
				    		 			System.out.println("The option "+ check1.getAttribute("value"));
				    		 			TestNGResults.put("12", new Object[] { 11d, "Payment Method Selected", "Yes", "Pass" });
				    		 		}
			    		 		else if(check2.isEnabled())
				    		 		{
				    		 			System.out.println("The option "+ check2.getAttribute("value"));
				    		 			TestNGResults.put("12", new Object[] { 11d, "Payment Method Selected", "Yes", "Pass" });
				    		 		}
			    		 		else if(check3.isEnabled())
				    		 		{
				    		 			System.out.println("The option "+ check3.getAttribute("value"));
				    		 			TestNGResults.put("12", new Object[] { 11d, "Payment Method Selected", "Yes", "Pass" });
				    		 		}
				    	 }
		    	 }
		    	 catch(Exception d) 
		      		{
		    		 			TestNGResults.put("10", new Object[] { 10d, "Payment Method Selected", "Not available", "Fail" });
		    		 			TestNGResults.put("11", new Object[] { 11d, "All Payment Methods Present", "Not Availble", "Fail" });
		    		 			TestNGResults.put("12", new Object[] { 12d, "Payment Method Selected", "Not Availble", "Fail" });
		      		}
		     }
	     
	    @BeforeClass(alwaysRun = true)
	 	public void suiteSetUp() 
	     {
	 		// create a new work book
	 		workbook = new HSSFWorkbook();
	 		
	 		// create a new work sheet
	 		sheet = workbook.createSheet("TestNG Result Summary");
	 		TestNGResults = new LinkedHashMap<String, Object[]>();
	 		
	 		// add test result excel file column header
	 		// write the header in the first row
	 		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });

	 	}
	     
	     @AfterClass
	 	public void suiteTearDown() 
	     {
	 		// write excel file and file name is SaveTestNGResultToExcel.xls
	 		Set<String> keyset = TestNGResults.keySet();
	 		int rownum = 0;
	 		for (String key : keyset) {
	 			Row row = sheet.createRow(rownum++);
	 			Object[] objArr = TestNGResults.get(key);
	 			int cellnum = 0;
	 			for (Object obj : objArr) {
	 				Cell cell = row.createCell(cellnum++);
	 				if (obj instanceof Date)
	 					cell.setCellValue((Date) obj);
	 				else if (obj instanceof Boolean)
	 					cell.setCellValue((Boolean) obj);
	 				else if (obj instanceof String)
	 					cell.setCellValue((String) obj);
	 				else if (obj instanceof Double)
	 					cell.setCellValue((Double) obj);
	 			}
	 		}
	 		
	 		try 
		 		{
		 			// Open the current date and time
					String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(new Date());
		 			
					FileOutputStream out = new FileOutputStream(new File("MDQm"+timestamp+".xls"));
		 			
					workbook.write(out);
		 			out.close();
		 			
		 			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");
		 		} 
	 		
	 		catch (FileNotFoundException e) 
		 		{
		 			e.printStackTrace();
		 		} 
	 		catch (IOException e) 
		 		{
		 			e.printStackTrace();
		 		}
	 		
	 		// close the browser
	 		driver.close();
	 		driver.quit();
	 	}
}