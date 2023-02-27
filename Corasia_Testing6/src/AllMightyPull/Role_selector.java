package AllMightyPull;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
 
public class Role_selector extends Base
{
	
	  //Select User	
	  @Test
	  public void selectuserbutton() throws InterruptedException, Exception 
	  {
			 driver.findElement(By.xpath(("//b[contains(@class,'btn btn-sm btn-success')]"))).click();
			 driver.findElement(By.xpath("//a[@href='https://emdvcorasia.com/testing6/login/changerole/581/1']")).click();
	
			 //Select Requester Form Type
			 driver.findElement(By.id("select_form_btn")).click();
			 Select drpdownform1 = new Select(driver.findElement(By.id("form_name")));
			 drpdownform1.selectByVisibleText("Quick Add (Ariba) Form");
			 driver.findElement(By.xpath("//button[contains(text(),'CONFIRM')]")).click();
	  }
	
}
