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

public class PaymentTerm extends BrowserClass
{
	  
	  @Test(priority=4)
	  //This is a Requester Information part 	
	  public void reqregion() throws Exception 
	  {  
		  Reporter.log("This is Requestor information section");
		  System.out.println("");
		  WebDriverWait drp1 = new WebDriverWait(driver, Duration.ofSeconds(10));
 		  WebElement drpdwn1 = driver.findElement(By.xpath("//span[contains(@id,'select2-18-container')]"));
 		  drp1.until(ExpectedConditions.elementToBeClickable(drpdwn1));
 		  System.out.println("The Requester regions available are");
 		  Reporter.log("The Requester regions available are");
		  Select s = new Select(driver.findElement(By.name("18")));
		  List<WebElement> reqregion = s.getOptions();
		  for(int i =0 ; i<reqregion.size(); i++)
		  {
			  System.out.println(reqregion.get(i).getText());
			  Reporter.log(reqregion.get(i).getText()); 
		  }	  
		  System.out.println("");
		  s.selectByIndex(1);
		  System.out.println("The Required region input is "+driver.findElement(By.xpath("//span[contains(@id,'select2-18-container')]")).getText());
		  System.out.println("");
		  Thread.sleep(1500);		 
	  }
	  
	  @Test(priority=5)
	  //Requester operating unit
	  public void reopunit() throws Exception  
		{  
		 	  Reporter.log("This is Requestor information Part");
		 	  System.out.println("");
			  WebDriverWait reopunit = new WebDriverWait(driver, Duration.ofSeconds(20));
			  WebElement drpdwn2 = driver.findElement(By.xpath("//span[contains(@id,'select2-19-container')]"));
			  reopunit.until(ExpectedConditions.elementToBeClickable(drpdwn2));
			  
			  System.out.println("The Supplier region list availble are");
			  Reporter.log("The Supplier region list availble are");
			  
			  Select o = new Select(driver.findElement(By.name("19")));
			  List<WebElement> opunit= o.getOptions();
			  for(int j =0 ; j<opunit.size(); j++)
			  {
				  System.out.println(opunit.get(j).getText());
				  Reporter.log(opunit.get(j).getText()); 
			  }
			  System.out.println("");
			  o.selectByIndex(2);
			  System.out.println("The Requestor operating unit input is "+driver.findElement(By.xpath("//span[contains(@id,'select2-19-container')]")).getText());
			  //driver.findElement(By.id("19-error")).getText();
			  //Reporter.log(driver.findElement(By.id("19-error")).getText()+"-Reqregion-Unit");
			  //System.out.println("");
			  Thread.sleep(1000);	
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
		    Thread.sleep(1500);
		    //Case1- Select a supplier form form 1
		 	driver.findElement(By.xpath("(//input[contains(@name,'supplier')])[1]")).click();
			driver.findElement(By.xpath("//input[@type='radio'][contains(@id,'supplier0')]")).click();			
			Thread.sleep(1500); 
			
			//Scroll by function used 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,550)", "");
			
			//Supplier Legal county
			driver.findElement(By.xpath("//div//input[contains(@id,'7')]")).sendKeys("test");
			
			Select rr = new Select(driver.findElement(By.name("193")));
			List<WebElement> reqregion = rr.getOptions();
			  for(int k =0 ; k<reqregion.size(); k++)
			  {
				  System.out.println("The regions available are "+ reqregion.get(k).getText());
				  Reporter.log(reqregion.get(k).getText()); 
			  }  
			rr.selectByIndex(2);			
			Thread.sleep(1000);
			
		}
	  
	  @Test(priority=8)
	  //Additional information - Payment Term form 
	  public void additonalinfo() throws InterruptedException 
	  {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  //Additional Corning email address(es) for people who need to be copied on the status of the request (separate email addresses by comma (,)) - 1.1.13
		  driver.findElement(By.xpath("//div//input[contains(@id,'58')]")).sendKeys("DHILEEP@ECCMA.ORG");
		  
		  //Additional Corning email address(es) for people who need to be copied on the status of the request (separate email addresses by comma (,)) - 1.1.13.1
		  driver.findElement(By.xpath("//div//input[contains(@id,'26')]")).sendKeys("DID NOT CONTACT GSM");
		  
		  //Purchase type (if Purchase Orders will be used, "GSM PO" must be selected) - 1.1.16
		  driver.findElement(By.xpath("//span//span[contains(@id,'select2-23-container')]")).click();
		  Select purchasedrpdwn = new Select (driver.findElement(By.xpath("//div//select[contains(@id,'23')]")));
		  
		  //Verification and validation of all drop down values - 1.1.16
		  purchasedrpdwn.selectByVisibleText("FINANCE");
		  purchasedrpdwn.selectByVisibleText("GSM NON-PO (GSM ENGAGED FOR CONTRACT/NEGOTIATIONS)");
		  purchasedrpdwn.selectByVisibleText("SELECT");
		  purchasedrpdwn.selectByVisibleText("GSM PO");
		  
		  //Purchase drop down value as FINANCE  
		  purchasedrpdwn.selectByVisibleText("FINANCE");		  
	  
		  //Email address of the Global Supply Management Supplier Owner - 1.1.20
		  driver.findElement(By.xpath("//div//input[contains(@id,'27')]")).click();
		  driver.findElement(By.xpath("//div//input[contains(@id,'27')]")).sendKeys("DHILEEP@ECCMA.ORG");
		  
		  //Scroll by function used 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,550)", "");
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
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
		  
		  //scroll down
		  JavascriptExecutor js2 = (JavascriptExecutor) driver;
		  js2.executeScript("window.scrollBy(0,450)", "");
		  
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_S4__HANA__private')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_S4-HANA__public')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_SAP__B1')]")).sendKeys("678910");
		  driver.findElement(By.xpath("//div//input[contains(@id,'50_Sorensen')]")).sendKeys("678910");
		  
		  //scroll down
		  JavascriptExecutor js3 = (JavascriptExecutor) driver;
		  js3.executeScript("window.scrollBy(0,450)", "");
		  
		  //Indicate all Region(s) where this supplier will be used (PS 9.x Set ID)
		  driver.findElement(By.xpath("(//button[@type='button'][contains(.,'None selected')])[1]")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='ASP01']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='EMA01']")).click();
		  driver.findElement(By.xpath("//div//label//input[@value='NFT01']")).click();
		  driver.findElement(By.xpath("(//button[@type='button'][contains(.,'None selected')])[1]")).click();
		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'values-area-48')]")).getText());
		  
		  //Indicate all PeopleSoft 9.x supplier Location code(s) to be updated (separate Location codes by comma (,))
		 
		  driver.findElement(By.xpath("//div//input[contains(@id,'51')]")).sendKeys("123456");
		  
		  //Indicate all SAP supplier Company Code(s)
		  driver.findElement(By.xpath("//input[contains(@value,'0001 - SAP Bilgi Islem Sistemler')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'0053 - Corning OpComm GmbH & Co')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'2100 - Corning Glass LLC')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'7615 - Corning OpComm KG')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AA10 - Corning SMSC 5G')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AA20 - Corning Intl SG')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AU10 - Corning OpComm Pty')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AU20 - Corning Noble Park Pty')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AU30 - Corning Australia Holding')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'BR10 - Corning Brasil Ind E Com')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'BR20 - CorningComunicaçõesÓptics')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CH10 - Corning Switzerland GMBH')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CN15 - Automotive Glass Solutions (52fei) Co., Ltd.')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CN16 - CDT Guangzhou Co.Ltd')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CN17 - CDT Wuhan CO.LTD')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CN31 - AFR-CN')]")).click();
		  
		  driver.findElement(By.xpath("//input[contains(@value,'CN33 - CDT-CN')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CN34 – CPG China JV')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CP22 - Corning CP CH')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DE01 - Country Template DE')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DE10 - Corning OpComm GmbH & Co')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DE20 - Corning OC Verwaltungs')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DE30 - Corning OpComm Vermoegens')]")).click();
		  
		  driver.findElement(By.xpath("//input[contains(@value,'DE40 - Corning OpComm GmbH & Co')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DE50 - Corning OpComm GmbH & Co')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DE60 - Corning Services GmbH; Hannover')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DK10 - Corning Cabelcon A/S')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'DO10 - CCS Dominican Republic')]")).click();
		  	     
		  driver.findElement(By.xpath("//input[contains(@value,'ES01 - Country Template ES')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'ES10 - Corning OpComm S.L.U.')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'FR01 - Country Template FR')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'FR10 - Corning SAS')]")).click();
		  
		  driver.findElement(By.xpath("//input[contains(@value,'FR20 - Pouyet SAS, Pouyet')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'IL10 - COC Wireless Ltd')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'IT01 - Country Template IT')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'IT10 - Corning OpComm S.r.l.')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'LU10 - Corning Telecom LUX SARL')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'MX01 - Country Template MX')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'MX10 - Corning OpComm SA de CV')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'MX20 - Corning Opt Distribuidora')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'MX30 - Corning Opt Comm Sales')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'MX40 - Corning Monterrey S de RL')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'PE01 - Country Template PE')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'PL01 - Country Template PL')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'PL10 - Corning OpComms Polska')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'PL11 - Corning OF Polska')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'SA05 - Corning Saudi Arabia Lim')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'SG10 - Corning Singapore Holding')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'TR10 - Corning Optik Iletisim')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'UA01 - Country Template UA')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'UK10 - Corning Limited UK')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'UK11 - Corning Cable Systems')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'US01 - Country Template US')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'US10 - Corning OpComm LLC')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'US20 - Corning OpComm LLC Arizona')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'US30 - Invenios LLC')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'US58 - Auto Glass Solutions')]")).click();
		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'values-area-52')]")).getText());
		  
		  
		  //Indicate all SAP supplier Purchase Code(s)
		  driver.findElement(By.xpath("(//button[contains(@class,'multiselect dropdown-toggle btn btn-light')])[4]")).click();
		  
		  //scroll down
		  JavascriptExecutor js4 = (JavascriptExecutor) driver;
		  js4.executeScript("window.scrollBy(0,450)", "");
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		  driver.findElement(By.xpath("(//input[contains(@value,'0001 - Satinalma Organizasy')])[1]")).click(); 
		  driver.findElement(By.xpath("(//input[contains(@value,'0001 - Satinalma Organizasy')])[1]")).click(); 
		  
     	  driver.findElement(By.xpath("//input[contains(@value,'0020 - H&E Europe')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'0030 - P&S Europe')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'1001 - CN Purchasing Org')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'1005 - AGS China Purchasing')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'1020 - H&E France')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'1021 - OC Luxembourg')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'1022 - H&E Luxembourg')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'1201 - Fouyet SAS FR')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'2002 - AGS US Purchasing')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'2010 - OC Germany')]")).click();	  
		  driver.findElement(By.xpath("//input[contains(@value,'2020 - H&E Germany')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'2131 - Vineland Plant')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'3201 - OC Italy')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'4010 - OC Poland')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'4020 - H&E Poland')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'4201 - OF Poland')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'5010 - OC Spain')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'5020 - H&E Spain')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'6010 - OC UK')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'7010 - OC Turkey')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'7201 - COC Israel')]")).click();  
		  driver.findElement(By.xpath("//input[contains(@value,'7202 - Saudi Arabia')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8200 - OC US')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8201 - H&E US')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8202 - H&E MX')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8203 - H&E DO')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8204 - OC Brazil')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8205 - Distibuidors MX')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8207 - H&E Arizona')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'8209 - H&E MX – Monterrey')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'9200 - OC Australia')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AA00 - CI Brazil')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'AA10 - Corning SMSC SG')]")).click();		  
		  driver.findElement(By.xpath("(//input[contains(@value,'AA20 - Corning Intl SG')])[2]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'BB10 - Corning SMSC CH')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CN15 - Corning Automotive Glass Solutions (Hefei) Co. Ltd.')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CP22 - Central Purchasing Organization Switzerland')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'CP61 - Central Purchasing Organization Singapore')]")).click();
		  driver.findElement(By.xpath("(//input[contains(@value,'DE60 - Corning Services')])[2]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'FR20 - Corning Pouyet SAS, Pouyet')]")).click();
		  driver.findElement(By.xpath("(//input[contains(@value,'US30 - Invenios LLC')])[2]")).click();
		  driver.findElement(By.xpath("(//input[contains(@value,'US58 - Auto Glass Solutions')])[2]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'US68 - Corning Auto Glass Solutions')]")).click();
		  driver.findElement(By.xpath("//input[contains(@value,'0001 - Satinalma Organizasy')]")).click();		  
		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'values-area-53')]")).getText());
		  
		  
		  //Are you requesting a change to extend/lengthen or shorten the payment terms for this supplier
		  Select id54 = new Select (driver.findElement(By.xpath("//div//select[contains(@id,'54')]")));
		  
		  List<WebElement> select03Options = id54.getOptions();
		  for (WebElement option : select03Options) 
		  {
			  Reporter.log(option.getText());
		  } 
		  id54.selectByIndex(2);
		  		  
		  //Current Payment term
		  Select id55 = new Select (driver.findElement(By.xpath("//div//select[contains(@id,'55')]")));
		  
		  List<WebElement> select23Options = id55.getOptions();
		  for (WebElement option : select23Options) 
		  {
			  Reporter.log(option.getText());
		  }
		  id55.selectByIndex(7);
		  
		  //Requested or New Payment term
		  Select id56 = new Select (driver.findElement(By.xpath("//div//select[contains(@id,'56')]")));
		  
		  List<WebElement> select22Options = id56.getOptions();
		  for (WebElement option : select22Options) 
		  {
			  Reporter.log(option.getText());
		  }
		  id56.selectByIndex(2);
		  
		  //All pay term change requests require approval. 
		  //The GSM Approver requires an explanation for the change in the Comment field and an analysis of the cash impact to the corporation, which must be attached here.
		  //If the Pay-terms are shorter than policy, a completed waiver must also be attached here. Refer to this link for payment term tools and guidelines: 
		  WebElement shorten = driver.findElement(By.xpath("//input[contains(@id,'57')]"));
		  shorten.sendKeys("E:\\\\Testing\\\\Projects Undertaken\\\\eMDV_CORASIA\\\\Documents sample test formats\\\\2.docx");
		  
		  //Comments 
		  driver.findElement(By.id("24")).sendKeys("Test Automation");
		  
		  //SendRequest
		  //driver.findElement(By.xpath("//button[contains(@id,'submit')]")).click();
	  }
	 
}

