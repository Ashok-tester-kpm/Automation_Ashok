package Play;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class Demojackbaseclass 
{

	  public static WebDriver driver;
	
	  public Demojackbaseclass(String drivername) throws InterruptedException
	  {
		  
			  //Creating Chrome-browser as instance  
		  	  if(drivername == "chrome")
		  	  {
		  		  driver = new ChromeDriver();
		  	  }
		  	  
		  	  if(drivername == "edge")
		  	  {	
		  		  
		  	  }
		  	  
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			  driver.get("https://www.eotd.org/");
			  			  
			  //Login Page verification & Validation
			  String acttitle = driver.getTitle();
			  String exptitle = "eOTD | ECCMA Open Technical Dictionary";
			  Assert.assertEquals(acttitle, exptitle);
			  Reporter.log("The Logged-in Page title is "+acttitle);
			  
			  //MARK THE TEST CASE HERE BEFORE RUN
			  System.out.println("Running Test Case 1");	
					  
			  //Search-Box
			  driver.findElement(By.xpath("//input[@id='term_inputs']")).sendKeys("cable");
			  		  
			  //Search-type Drop-Down box
			  Select s =  new Select(driver.findElement(By.xpath("//select[@id='search_type']")));
			  s.selectByValue("related"); //Drop-Down values(exact, related, Start-with)
			  Thread.sleep(3000);
			  
			  //Search button
			  driver.findElement(By.xpath("//button[@id='search_btn']")).click();	    	  
	  }	  
}
