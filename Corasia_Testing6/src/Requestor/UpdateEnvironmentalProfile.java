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

public class UpdateEnvironmentalProfile extends BrowserClass
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
	  
	  @Test(priority=8)
		public void suppliercontactinfo()
		{
			
		  //Supplier Contact Name - For portal maintenance - 1.1.10
		  driver.findElement(By.xpath("//input[@id='14']")).sendKeys("Dhileep vengaskar");
		  
		  //Supplier Contact Email - For portal maintenance - 1.1.11
		  driver.findElement(By.xpath("//input[contains(@id,'15')]")).sendKeys("dhileep@eccma.org");
		  
		  //Supplier Contact Business Telephone (include country code, only include numbers - no special characters) - 1.1.12
		  driver.findElement(By.xpath("//input[contains(@id,'16')]")).sendKeys("8870769513");
		  
		  /*Additional Corning email address(es) for people who need to be copied on the status of the request 
		  (separate email addresses by comma (,)) - 1.1.13 */
		  driver.findElement(By.xpath("//div//input[contains(@id,'58')]")).sendKeys("DHILEEP@ECCMA.ORG");
		  
		  //Email address for Global Supply Management Representative working with you. If not applicable, then type exact words: “Did not contact GSM” - 1.1.13.1
		  driver.findElement(By.xpath("//div//input[contains(@id,'26')]")).sendKeys("DID NOT CONTACT GSM");
		  
		  //Email address of the Global Supply Management Supplier Owner - 1.1.20
		  driver.findElement(By.xpath("//div//input[contains(@id,'27')]")).sendKeys("DHILEEP@ECCMA.ORG");
		  
		  //Comments / Remarks for  the request - 1.1.15.3
		  driver.findElement(By.xpath("//textarea[@id='24']")).sendKeys("Testing 1.1.15.3");
		
		}
}
