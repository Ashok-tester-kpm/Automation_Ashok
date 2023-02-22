package Requestor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class QuickAdd extends BrowserClass
{
 	  @Test(priority = 4)
	  //Case 1 - in-valid value Select
	  public void error() throws InterruptedException, IOException
	  {
 		System.out.println("");
				  
		driver.findElement(By.xpath("//button[contains(@id,'submit')]")).click();	
		
		//Reqregion-Unit
		driver.findElement(By.id("18-error")).getText();
		Reporter.log(driver.findElement(By.id("18-error")).getText()+"-Reqregion-Unit");
		
		//Reqoperating-Unit
		driver.findElement(By.id("19-error")).getText();
		Reporter.log(driver.findElement(By.id("19-error")).getText()+"-Reqoperating-Unit");
		
		//Supplier Legal Name
		driver.findElement(By.id("42-error")).getText();
		Reporter.log(driver.findElement(By.id("42-error")).getText()+"-Supplier Legal Name");
		
		//Legal Address
		driver.findElement(By.id("2-error")).getText();
		Reporter.log(driver.findElement(By.id("2-error")).getText()+"-Legal Address");
		
		//Legal Country
		driver.findElement(By.id("5-error")).getText();
		Reporter.log(driver.findElement(By.id("5-error")).getText()+"-Legal Country");
		
		//Legal State
		driver.findElement(By.id("4-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("4-error")).getText()+"-Legal State");
		
		//Legal City
		driver.findElement(By.id("1-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("1-error")).getText()+"-Legal City");
		
		//Legal Postal code
		driver.findElement(By.id("6-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("6-error")).getText()+"-Legal Postal code");
		
		//Region where the supplier is located
		driver.findElement(By.id("193-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("193-error")).getText()+"-Region where the supplier is located");
		
		//Supplier Contact Name - For portal maintenance
		driver.findElement(By.id("14-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("14-error")).getText()+"-Supplier Contact Name - For portal maintenance");
		
		//Supplier Contact Email - For portal maintenance
		driver.findElement(By.id("15-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("15-error")).getText()+"-Supplier Contact Email - For portal maintenance");
		
		//Supplier Contact Business Telephone (include country code, only include numbers - no special characters)
		driver.findElement(By.id("16-error")).getText();
		Reporter.log(" " + driver.findElement(By.id("16-error")).getText()+"-Supplier Contact Business Telephone");	
		
		System.out.println("");
	  }
	  
	  @Test(priority = 5)
	  //Test Case - valid data feed Scenario
	  // This is a Requester Information part Starts
	  //Requestor-Region
	  public void reqregion() throws InterruptedException, IOException 
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

	 @Test(priority = 6)
	 // Requester operating unit
	 public void reopunit() throws Exception  
		{  
		 	  Reporter.log("This is Requestor information Part");
		 	  System.out.println("");
			  WebDriverWait reopunit = new WebDriverWait(driver, Duration.ofSeconds(10));
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
			  driver.findElement(By.id("19-error")).getText();
			  Reporter.log(driver.findElement(By.id("19-error")).getText()+"-Reqregion-Unit");
			  System.out.println("");
			  Thread.sleep(1500);
		}

	 @Test(priority = 7)	
	 //Choose File section under requestor region
	 public void choosefile() throws Exception 
	  	{
		  WebElement choosefile = driver.findElement(By.xpath("//input[contains(@class,'form-control h-auto  ')]"));
		  System.out.println("The Files are now attached");
		  Reporter.log("The files are attached as below");
		  
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\2.docx");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\3.xlsx");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\4.pptx");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\5.jpg");
		  choosefile.sendKeys("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Documents sample test formats\\6.jpg");
		  Thread.sleep(1500);
		  Reporter.log(driver.findElement(By.xpath("//div[contains(@id,'preview_1459')]")).getText());	  	
	  	}
	 
	 @Test(priority = 8)	
	 //Supplier information 
	 public void suplrinfo() throws InterruptedException, IOException 
		{
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
	  	
	 //Supplier - ContactInfo
	 @Test(priority = 9)
	 public void contactinfo()
	  	{
	  		WebDriverWait ele1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	  		WebElement txt = driver.findElement(By.xpath("//input[@id='14']"));
	  		ele1.until(ExpectedConditions.elementToBeClickable(txt));	
	  		driver.findElement(By.xpath("//input[@id='14']")).sendKeys("DHILEEP KUMAR");
	  		driver.findElement(By.xpath("//input[contains(@id,'15')]")).sendKeys("dhileep@eccma.org");
	  		driver.findElement(By.xpath("//input[contains(@id,'16')]")).sendKeys("8870769513");
	  		driver.findElement(By.xpath("//textarea[contains(@id,'59')]")).sendKeys("This is a Automation test Form");
	  	}		
	 
	 //additional info
	 @Test(priority = 7)
	 public void additionalinfo() throws Exception
	  	{
	  		driver.findElement(By.xpath("//input[contains(@id,'58')]")).sendKeys("No");
	  		driver.findElement(By.xpath("//textarea[contains(@id,'24')]")).sendKeys("This is a Automation _ Quick Add ariba form");
	  		Thread.sleep(1000);
	  	}
	  	
  	@Test(priority = 8)
  	public void feedexcel() throws Exception
	  	{
	  		
	  		XSSFWorkbook wb = null ;
	  		XSSFSheet sh = null ;
	  		
	  		File file = new File ("E:\\Testing\\QuickAddFeedData.xlsx");
  			//FileInputStream fis = new FileInputStream(file);
  			wb = new XSSFWorkbook();
  			sh = wb.getSheetAt(0);
  			
  			//Automation filled fields - fetched data 
  			String RR = driver.findElement(By.xpath("//div//span[contains(@id,'select2-18-container')]")).getText();
			String ROU = driver.findElement(By.xpath("//div//span[contains(@id,'select2-19-container')]")).getText();
			WebElement SLN = driver.findElement(By.xpath("//div//input[contains(@id,'42')]"));
			WebElement SLA = driver.findElement(By.xpath("//div//input[contains(@placeholder,'Legal Address')]"));
  			String SLCNT = driver.findElement(By.xpath("//div//span[contains(@id,'select2-4-container')]")).getText();
  			
  			String SLS1 = driver.findElement(By.xpath("//span[contains(@id,'select2-4-container')]")).getText();
  			WebElement SLS2 = driver.findElement(By.xpath("//div//input[contains(@id,'4_other')]"));
  			
  			String SLC1 = driver.findElement(By.xpath("//div//span[contains(@id,'select2-1-container')]")).getText();
  			WebElement SLC2 = driver.findElement(By.xpath("//div//input[contains(@id,'1_other')]"));

  			WebElement SLP = driver.findElement(By.xpath("//div//input[contains(@id,'6')]"));
  			WebElement SLCNY = driver.findElement(By.xpath("//input[@id='7']"));
  			String RWSL = driver.findElement(By.xpath("//div//span[contains(@id,'select2-193-container')]")).getText();
  			WebElement SCN = driver.findElement(By.xpath("//input[@id='14']"));
  			WebElement SCE = driver.findElement(By.xpath("//input[@id='15']"));
  			WebElement SBT = driver.findElement(By.xpath("//input[@id='16']"));
  			WebElement DSC = driver.findElement(By.xpath("//textarea[@id='59']"));
  			WebElement ACE = driver.findElement(By.xpath("//input[contains(@aria-invalid,'false')]"));
  			WebElement COM = driver.findElement(By.xpath("//textarea[contains(@aria-invalid,'false')]"));
  			
  			System.out.println("Data will be fed excel");
	  		Reporter.log("Automation testing completed, Now Feeding data to Excel - Kindly pls wait for Feed data complete");	
  			
	  		//Automation filled fields - fetched data 
	  		sh.getRow(0).getCell(1).setCellValue(RR);		  		
	  		sh.getRow(1).getCell(1).setCellValue(ROU);
	  		sh.getRow(2).getCell(1).setCellValue(SLN.getAttribute("value"));
	  		sh.getRow(3).getCell(1).setCellValue(SLA.getAttribute("value"));
	  		sh.getRow(4).getCell(1).setCellValue(SLCNT);
	  		sh.getRow(5).getCell(1).setCellValue(SLS1);
	  		sh.getRow(6).getCell(1).setCellValue(SLS2.getAttribute("value"));
	  		sh.getRow(7).getCell(1).setCellValue(SLC1);
	  		sh.getRow(8).getCell(1).setCellValue(SLC2.getAttribute("value"));
	  		sh.getRow(9).getCell(1).setCellValue(SLP.getAttribute("value"));
	  		sh.getRow(10).getCell(1).setCellValue(SLCNY.getAttribute("value"));
	  		sh.getRow(11).getCell(1).setCellValue(RWSL);
	  		sh.getRow(12).getCell(1).setCellValue(SCN.getAttribute("value"));
	  		sh.getRow(13).getCell(1).setCellValue(SCE.getAttribute("value"));
	  		sh.getRow(14).getCell(1).setCellValue(SBT.getAttribute("value"));
	  		sh.getRow(15).getCell(1).setCellValue(DSC.getAttribute("value"));
	  		sh.getRow(16).getCell(1).setCellValue(ACE.getAttribute("value"));
	  		sh.getRow(17).getCell(1).setCellValue(COM.getAttribute("value"));
				  
	  		Thread.sleep(2);
	  		
  			//Field error fed to excel 
			//Reqregion-Unit
			String RRE = driver.findElement(By.id("18-error")).getText();
						
			//Reqoperating-Unit
			String ROUE = driver.findElement(By.id("19-error")).getText();
			
			//Supplier Legal Name
			String SLNE = driver.findElement(By.id("42-error")).getText();
				
			//Legal Address
			String SLAE = driver.findElement(By.id("2-error")).getText();

			//Legal Country
			String SLCNTE = driver.findElement(By.id("5-error")).getText();
							
			//Legal State
			String SLS1E = driver.findElement(By.id("4-error")).getText();
				
			//Legal State - other
			String SLS2E = driver.findElement(By.id("4_other-error")).getText();
		
			//Legal City
			String SLC1E = driver.findElement(By.id("1-error")).getText();
					
			//legal City - other
			String SLC2E = driver.findElement(By.id("1-error")).getText();
						
			//Legal Postal code
			String SLPE = driver.findElement(By.id("6-error")).getText();
						
			//Supplier Legal county - if applicable 
			String SLCNYE = driver.findElement(By.id("7-error")).getText();
						
			//Region where the supplier is located
			String RWSLE = driver.findElement(By.id("193-error")).getText();
					
			//Supplier Contact Name - For portal maintenance
			String SCNE = driver.findElement(By.id("14-error")).getText();
			
			//Supplier Contact Email - For portal maintenance
			String SCEE = driver.findElement(By.id("15-error")).getText();
			
			//Supplier Contact Business Telephone (include country code, only include numbers - no special characters)
			String SBTE = driver.findElement(By.id("16-error")).getText();

			//ADDIOTNAL corning email address field text box error 
			String ACEE = driver.findElement(By.xpath("(//div[contains(.,'Please enter valid Additional email address in \"Additional Corning email address(es) for people who need to be copied on the status of the request\"')])[14]")).getText();
			
			sh.getRow(0).createCell(2).setCellValue(RRE);		  		
	  		sh.getRow(1).createCell(2).setCellValue(ROUE);
	  		sh.getRow(2).createCell(2).setCellValue(SLNE);
	  		sh.getRow(3).createCell(2).setCellValue(SLAE);
	  		sh.getRow(4).createCell(2).setCellValue(SLCNTE);
	  		sh.getRow(5).createCell(2).setCellValue(SLS1E);
	  		sh.getRow(6).createCell(2).setCellValue(SLS2E);
	  		sh.getRow(7).createCell(2).setCellValue(SLC1E);
	  		sh.getRow(8).createCell(2).setCellValue(SLC2E);
	  		sh.getRow(9).createCell(2).setCellValue(SLPE);
	  		sh.getRow(10).createCell(2).setCellValue(SLCNYE);
	  		sh.getRow(11).createCell(2).setCellValue(RWSLE);
	  		sh.getRow(12).createCell(2).setCellValue(SCNE);
	  		sh.getRow(13).createCell(2).setCellValue(SCEE);
	  		sh.getRow(14).createCell(2).setCellValue(SBTE);
	  		sh.getRow(16).createCell(2).setCellValue(ACEE);
	  		
	  		try
	  			{
		  		System.out.println("Data feeding to excel complete- Please wait for browser to close");
		  		Reporter.log("Data feeding to excel complete - Please wait for browser to close");	
		  		FileOutputStream fos = new FileOutputStream(file);
	  			wb.write(fos);
	  			wb.close();
		  	}
	  		
	  		catch( Exception e1)
	  		{
	  			e1.printStackTrace();
	  		}
	  	
	  	Reporter.log("All of automation is done now");
	  	driver.close();
	  	}	
	 }