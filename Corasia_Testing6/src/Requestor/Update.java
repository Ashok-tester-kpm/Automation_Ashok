package Requestor;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Update extends BrowserClass
{
	  @Test(priority=4)
	  // This is a Requester Information part 	
	  public void reqregion() throws InterruptedException, IOException 
	  {
		  driver.findElement(By.xpath("//span[contains(@id,'select2-19-container')]")).click();
		  Select s = new Select(driver.findElement(By.name("18")));
		  List<WebElement> reqregion = s.getOptions();
		  for(int i =0 ; i<reqregion.size(); i++)
		  {
			  System.out.println("The regions available are "+reqregion.get(i).getText());
			  Reporter.log(reqregion.get(i).getText()); 
		  }
		  s.selectByIndex(1);
		 
	  }
	
	  @Test(priority=5)
	  // Requester operating unit
	  public void reopunit() throws InterruptedException, IOException 
		{
		  WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(20));
		  WebElement selop = driver.findElement(By.xpath("//span[contains(@id,'select2-19-container')]"));
		  wait1.until(ExpectedConditions.elementToBeClickable(selop)).click();
		  Select o = new Select(driver.findElement(By.id("19")));
		  List<WebElement> opunit= o.getOptions();
		  for(int j =0 ; j<opunit.size(); j++)
		  {
			  System.out.println("The Supplier region is "+opunit.get(j).getText());
			  Reporter.log(opunit.get(j).getText()); 
		  }
		  o.selectByIndex(1);		  
		}
	  
	  @Test(priority=6)
	  //Choose File 
	  public void choosefile() throws Exception 
	  	{
		  System.out.println("The Files are now attached");
		  Reporter.log("The files are attached as below");
		  WebElement choosefile = driver.findElement(By.xpath("//input[contains(@class,'form-control h-auto  ')]"));
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\2.docx");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\3.xlsx");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\4.pptx");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\5.jpg");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\6.jpg");
		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'preview_1459')]")).getText());	  	  	
	  	}
	  
	  @Test(priority=7)
	  //Supplier information 
	  public void suplrinfo() throws InterruptedException, IOException 
		{
		 	driver.findElement(By.xpath("(//input[contains(@name,'supplier')])[1]")).click();
			driver.findElement(By.xpath("//input[@type='radio'][contains(@id,'supplier0')]")).click();
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("scroll(0,450)");		
			Thread.sleep(3000); 
			driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys("phen yong");
			driver.findElement(By.id("6")).sendKeys("220000");
			driver.findElement(By.xpath("//span[@id='select2-193-container']")).click();
			Select rr = new Select(driver.findElement(By.name("193")));
			List<WebElement> reqregion = rr.getOptions();
			  for(int k =0 ; k<reqregion.size(); k++)
			  {
				  System.out.println("The regions available are "+reqregion.get(k).getText());
				  Reporter.log(reqregion.get(k).getText()); 
			  }
			rr.selectByIndex(1);	 	
		}  
	  
	  @Test(priority = 8)
	  public void additionalinfo() throws InterruptedException
	  {
		  //Supplier Contact Name - For portal maintenance - 1.1.10
		  driver.findElement(By.xpath("//input[@id='14']")).sendKeys("Dhileep vengaskar");
		  
		  //Supplier Contact Email - For portal maintenance - 1.1.11
		  driver.findElement(By.xpath("//input[contains(@id,'15')]")).sendKeys("dhileep@eccma.org");
		  
		  //Supplier Contact Business Telephone (include country code, only include numbers - no special characters) - 1.1.12
		  driver.findElement(By.xpath("//input[contains(@id,'16')]")).sendKeys("8870769513");
		  
		  /*If you need different supplier contacts (e.g., for Sourcing or Survey events), 
		  note the name(s) and email address(es) here - 1.1.12.1 */
		  driver.findElement(By.xpath("//input[contains(@id,'59')]")).sendKeys("");
		  
		  /*Additional Corning email address(es) for people who need to be copied on the status of the request 
		  (separate email addresses by comma (,)) - 1.1.13 */
		  driver.findElement(By.xpath("//div//input[contains(@id,'58')]")).sendKeys("DHILEEP@ECCMA.ORG");
		  
		  //Email address for Global Supply Management Representative working with you. If not applicable, then type exact words: “Did not contact GSM” - 1.1.13.1
		  driver.findElement(By.xpath("//div//input[contains(@id,'26')]")).sendKeys("DID NOT CONTACT GSM");
		  
		  //Purchase type (if Purchase Orders will be used, "GSM PO" must be selected) - 1.1.16
		  Select purchasedrpdwn = new Select (driver.findElement(By.xpath("//div//select[contains(@id,'23')]")));  
		  //Purchase drop down value as FINANCE  
		  purchasedrpdwn.selectByIndex(2);
		  
		  //Email address of the Global Supply Management Supplier Owner - 1.1.20
		  driver.findElement(By.xpath("//div//input[contains(@id,'27')]")).sendKeys("DHILEEP@ECCMA.ORG");
		  
		  //Select the Division(s) that will use this Supplier - 1.1.25
		  driver.findElement(By.xpath("//div[@id='302']//button[@title='None selected']")).click();  
		  
		  driver.findElement(By.xpath("//input[contains(@value,'AGS-Auto Glass Solutions')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'BSD-Workplace Services')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CDT-Corning Display Technologies')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CET-Corning Environmental Technologies')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CGM-Corning Glass Microsystems')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CI-Corning Incorporated')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CLS-Corning Life Sciences')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CPM-Corning Precision Materials')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CPT-Corning Pharmaceutical Technologies')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CSM-AO-Corning Specialty Materials - Advanced Optics')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CSM-GG-Corning Specialty Materials - Gorilla Glass')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CSTAFF-Corporate Staff')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'INTL-Corning International')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'IT-Information Technology')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'OCS-Optical Connectivity Solutions')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'OFC-Optical Fiber and Cable')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'S&T-Science & Technology')]")).click();
		  
		  Reporter.log("The Division(s) that will use this Supplier are -"+driver.findElement(By.xpath("//div[contains(@id,'values-area-62')]")).getText());
		  
		  //Scroll by function used 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,550)", "");
		  
		  //Select the primary 4-digit (L2) Category for this Supplier,Refer to the Category Hierarchy to choose the right category - 1.1.25.1
		  Select first = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'63')]")));
		  List<WebElement> drpdwn1 = first.getOptions();
		  for(int k =0 ; k<drpdwn1.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn1.get(k).getText());
			  Reporter.log(drpdwn1.get(k).getText()); 
		  }  
		  first.selectByIndex(2);			
		  Thread.sleep(1000);		
		 
		  //Primary 5-digit Business Unit that will use this supplier - 1.1.26
		  driver.findElement(By.xpath("//input[@id='33']")).sendKeys("85236");
		  
		  //Inter-Company supplier (i.e., is the supplier an entity within Corning Incorporated)? - 1.1.27
		  Select intercompsupp = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'34')]")));
		  intercompsupp.selectByVisibleText("YES");
		  intercompsupp.selectByVisibleText("NO");
		  intercompsupp.selectByVisibleText("SELECT");
		  
		  //Nature of the purchases from this supplier - 1.1.28
		  Select natureofpurchase = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'35')]")));
		  natureofpurchase.selectByVisibleText("BOTH GOODS AND SERVICES");
		  natureofpurchase.selectByVisibleText("INTANGIBLE/SERVICES");
		  natureofpurchase.selectByVisibleText("PHYSICAL GOODS");
		  
		  //For non-PO suppliers, select the most appropriate the ERN # - 1.1.31
		  Select nonposuppliers = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'38')]")));
		  nonposuppliers.selectByIndex(2);
		  Reporter.log(driver.findElement(By.xpath("//div//select[contains(@id,'38')]")).getText());
		  
		  //For non-PO suppliers, select if the supplier needs to be added because it is one or more of the following: - 1.1.31.1
		  Select nonposow = new Select (driver.findElement(By.xpath("//div//select[contains(@id,'227')]")));
		  nonposow.selectByIndex(2);
		  
		  //Select all Corning systems that need to be updated for this request - 1.1.35
		  driver.findElement(By.xpath("(//button[@type='button'][contains(.,'None selected')])[1]")).click();		  //drop-down-list address
		  
		  driver.findElement(By.xpath("//div//label//input[@value='Axygen - MAS 200']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='CLS PeopleSoft (v 8.9)']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='CPT SAP - Vineland']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Edison, NJ - MAS 200']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Fairport (MAX)']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Gosselin']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='IFS']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='IFS']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='Keene Epicor']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='MSD (BC)']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='OC SAP ECC']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='PeopleSoft v9.x']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='S4 HANA private']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='S4-HANA public']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='SAP B1']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='Sorensen']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='IFS']")).click();
		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'values-area-47')]")).getText());
		  
	  
		  //Select all Corning systems that need to be updated for this request - 1.1.35
		  driver.findElement(By.xpath("(//button[@type='button'][contains(.,'None selected')])[1]")).click();		  //drop-down-list address
		  
		  driver.findElement(By.xpath("//div//label//input[@value='Axygen - MAS 200']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='CLS PeopleSoft (v 8.9)']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='CPT SAP - Vineland']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Edison, NJ - MAS 200']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Fairport (MAX)']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Gosselin']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='IFS']")).click();					  //drop-down-list option
		  driver.findElement(By.xpath("//div//label//input[@value='Keene Epicor']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='MSD (BC)']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='OC SAP ECC']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='PeopleSoft v9.x']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='S4 HANA private']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='S4-HANA public']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='SAP B1']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='Sorensen']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='IFS']")).click();

		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'values-area-47')]")).getText());
		  
		  //Indicate the supplier ID to be updated (if multiple values are provided, separate them by a comma - 1.1.36
		  driver.findElement(By.xpath("//span[@class='input-group-text'][contains(.,'PEOPLESOFT V9.X')]")).click();
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_Axygen__-__MAS__200')]")).sendKeys("12345");
		  driver.findElement(By.xpath("//div//input[contains(@id,'CLS__PeopleSoft____v__8__9__')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'CPT__SAP__-__Vineland')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'Edison____NJ__-__MAS__200')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'CPT__SAP__-__Vineland')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'Fairport____MAX__')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'Gosselin')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'IFS')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'Keene__Epicor')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'MSD____BC__')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'OC__SAP__ECC')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'PeopleSoft__v9__x')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_S4__HANA__private')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_S4-HANA__public')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_SAP__B1')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_Sorensen')]")).sendKeys("678910");
		  
		  //Select the applicable Freight Term (Description) - 1.1.42 
		  Select freight = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'67')]")));
		  List<WebElement> drpdwn2 = freight.getOptions();
		  for(int k =0 ; k<drpdwn2.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn2.get(k).getText());
			  Reporter.log(drpdwn2.get(k).getText()); 
		  }  
		  freight.selectByIndex(2);			
		  Thread.sleep(1000);
		   
	      //Select the applicable Shipping / Delivery Method - 1.1.43
		  driver.findElement(By.xpath("//span[contains(@id,'select2-67-container')]")).click();	  
		  Select shipping = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'68')]")));
		  List<WebElement> drpdwn3 = shipping.getOptions();
		  for(int k =0 ; k<drpdwn3.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn3.get(k).getText());
			  Reporter.log(drpdwn3.get(k).getText()); 
		  }  
		  shipping.selectByIndex(2);			
		  Thread.sleep(1000);
		  
		  //Does this supplier need to be set-up for consignment? - 1.1.44
		  Select suppliersetconsignment = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'69')]")));
		  List<WebElement> drpdwn4 = suppliersetconsignment.getOptions();
		  for(int k =0 ; k<drpdwn4.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn4.get(k).getText());
			  Reporter.log(drpdwn4.get(k).getText()); 
		  }  
		  suppliersetconsignment.selectByIndex(2);	
		  
		  //Currency for purchase orders, invoices, payments - 
		  //GSM must make sure the supplier agrees to avoid payment issues - 1.1.50
		  Select currency = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'71')]")));
		  List<WebElement> drpdwn6 = currency.getOptions();
		  for(int k =0 ; k<drpdwn6.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn6.get(k).getText());
			  Reporter.log(drpdwn6.get(k).getText()); 
		  }  
		  currency.selectByIndex(2);	
		  
		  /*Bank Charges Paid By (GSM should be able to confirm if a contract defines this value - 
		  -otherwise, use the default value provided) - 1.1.51  */ 
		  Select bankcharges = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'72')]")));
		  List<WebElement> drpdwn7 = bankcharges.getOptions();
		  for(int k =0 ; k<drpdwn7.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn7.get(k).getText());
			  Reporter.log(drpdwn7.get(k).getText()); 
		  }  
		  bankcharges.selectByIndex(2);	
		  
		  //Will Supplier process Corning personal data? - 1.1.52
		  Select supplierprocess = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'73')]")));
		  List<WebElement> drpdwn8 = supplierprocess.getOptions();
		  for(int k =0 ; k<drpdwn8.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn8.get(k).getText());
			  Reporter.log(drpdwn8.get(k).getText()); 
		  }  
		  supplierprocess.selectByIndex(2);	
		  
		  //Input the country(ies) where personal data originates (Not where the supplier is located) - 1.1.55
		  driver.findElement(By.xpath("//input[contains(@id,'76')]")).sendKeys("Testing 1.1.55");
		  
		  /* The following questions define the role of Corning and the Supplier in the context of data processing. 
		  Select all the roles that apply from the list provided. - 1.1.56 */
		  driver.findElement(By.xpath("//input[contains(@value,'Does Corning decide how long to retain the data, or whether to make non-routine amendments to the data?')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does Corning decide to collect the personal data that will be processed by the Supplier and determine the legal basis for doing so?')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does Corning decide to disclose the data, and if so, who to?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does Corning decide whether data subject requests apply (i.e., data except from data subject requests?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does Corning decide which individuals to collect data about?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does Corning decide which items of personal data to collect and/or process (i.e., the content of the data)?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does the Supplier decide how long to retain the data or whether to make non-routine amendments to the data?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does the Supplier decide to collect the personal data and determine the legal basis for doing  so?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does the Supplier decide to disclose the data, and if so, who to?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does the Supplier decide which individuals to collect data about?']")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'Does the Supplier decide which items of personal data to collect and/or process (i.e., the content of the data)?")).click();
		  
		  //What is the relationship between Corning and the Supplier (refer to the Relationship Guidance document)? - 1.1.57
		  Select relationcorningsupplier = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'78')]")));
		  List<WebElement> drpdwn10 = relationcorningsupplier.getOptions();
		  for(int k =0 ; k<drpdwn10.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn10.get(k).getText());
			  Reporter.log(drpdwn10.get(k).getText()); 
		  }  
		  relationcorningsupplier.selectByIndex(2);
		  
		  //Will the supplier process Corning Intellectual Assets? - 1.1.59
		  Select suppliercorning = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'74')]")));
		  List<WebElement> drpdwn11 = suppliercorning.getOptions();
		  for(int k =0 ; k<drpdwn11.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn11.get(k).getText());
			  Reporter.log(drpdwn11.get(k).getText()); 
		  }  
		  suppliercorning.selectByIndex(2);
		  
		  //Select the appropriate technology type - 1.1.60
		  Select apporpiratetech = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'80')]")));
		  List<WebElement> drpdwn12 = apporpiratetech.getOptions();
		  for(int k =0 ; k<drpdwn12.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn12.get(k).getText());
			  Reporter.log(drpdwn12.get(k).getText()); 
		  }  
		  apporpiratetech.selectByIndex(2);
		  
		  //Will the supplier own Intellectual Property for services that Corning is purchasing from them? - 1.1.61
		  Select intellectual = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'81')]")));
		  List<WebElement> drpdwn13 = intellectual.getOptions();
		  for(int k =0 ; k<drpdwn13.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn13.get(k).getText());
			  Reporter.log(drpdwn13.get(k).getText()); 
		  }  
		  intellectual.selectByIndex(2);
		  
		  //Will maintenance only be provided by the original manufacturer? - 1.1.62
		  Select maintenanceonly = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'82')]")));
		  List<WebElement> drpdwn14 = maintenanceonly.getOptions();
		  for(int k =0 ; k<drpdwn14.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn14.get(k).getText());
			  Reporter.log(drpdwn14.get(k).getText()); 
		  }  
		  maintenanceonly.selectByIndex(2);
		  
		  //Select the appropriate Supplier Criticality - Intellectual Assets setting - 1.1.63
		  Select Criticality = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'84')]")));
		  List<WebElement> drpdwn15 = Criticality.getOptions();
		  for(int k =0 ; k<drpdwn15.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn15.get(k).getText());
			  Reporter.log(drpdwn15.get(k).getText()); 
		  }  
		  Criticality.selectByIndex(2);
		  
		//Will the supplier conduct business with a US entity of Corning? - 1.1.64
		  Select conductbusiness = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'84')]")));
		  List<WebElement> drpdwn16 = conductbusiness.getOptions();
		  for(int k =0 ; k<drpdwn16.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn16.get(k).getText());
			  Reporter.log(drpdwn16.get(k).getText()); 
		  }  
		  conductbusiness.selectByIndex(2);
		  
		  //Is Supplier currently excluded from doing business with the U.S. Government per www.SAM.gov? - 1.1.65
		  Select usgovernment = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'86')]")));
		  List<WebElement> drpdwn17 = usgovernment.getOptions();
		  for(int k =0 ; k<drpdwn17.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn17.get(k).getText());
			  Reporter.log(drpdwn17.get(k).getText()); 
		  }  
		  usgovernment.selectByIndex(2);
		  
		  //Date you (the Requestor) verified the supplier does not appear in www.SAM.gov 1.1.66
		  driver.findElement(By.xpath("//input[@id='87']")).sendKeys("23-10-2022");
		  
		  //Does the supplier need to provide additional information not shown on this form for the change? 
		  //If 'yes', the supplier will be sent an email from support@eccma.org to submit the details in the eMDV supplier portal. 
		  //Please make sure the supplier knows this email is coming and does not treat it as SPAM - 1.1.70
		  Select spam1170 = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'86')]")));
		  List<WebElement> drpdwn18 = spam1170.getOptions();
		  for(int k =0 ; k<drpdwn18.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn18.get(k).getText());
			  Reporter.log(drpdwn18.get(k).getText()); 
		  }  
		  spam1170.selectByIndex(2);
		  
		  //Is this a request to extend an existing supplier to another ERP/location/company code? - 1.1.1.26
		  Select ERPLOCATIONCOMPANY = new Select(driver.findElement(By.xpath("//div//select[contains(@id,'86')]")));
		  List<WebElement> drpdwn19 = ERPLOCATIONCOMPANY.getOptions();
		  for(int k =0 ; k<drpdwn19.size(); k++)
		  {
			  System.out.println("The regions available are "+ drpdwn19.get(k).getText());
			  Reporter.log(drpdwn19.get(k).getText()); 
		  }  
		  ERPLOCATIONCOMPANY.selectByIndex(2);
	  
		  //Comments / Remarks for  the request - 1.1.15.3
		  driver.findElement(By.xpath("//textarea[@id='24']")).sendKeys("Testing 1.1.15.3");
	  }
	  
	  
	  
}
