package AllMightyPull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Error_Cach extends Base
{
	@Test(priority = 4)
	public void submit()
	{
		driver.findElement(By.xpath("//button[contains(@id,'submit')]")).click();
	}
	
	@Test(priority = 5)
	public void collectandcheck()
	{
		try
			{
				ArrayList <String> errnamebox = new ArrayList<String> ();
				List <WebElement> errfield = driver.findElements(By.xpath("//label[@id]"));
				for(int add = 0; add < errfield.size(); add++)
						{
								errnamebox.add(errfield.get(add).getAttribute("for"));
						}
				
				//Check all error fields are loaded
				ArrayList<String> errrequired = new ArrayList<String>();
				errrequired.addAll(Arrays.asList("18", "19", "42", "2",  "5", "4","1000", "1", "6", "193", "14", "15", "16", "2000"));
				
				if(errnamebox.equals(errrequired))
				{
						System.out.println("The Field matches the required list "+errnamebox);
				}
				else
				{
							errrequired.removeAll(errnamebox);
							System.out.println("The Fields that does not match the required list: "+ errrequired);
				}
			}
		 catch(Exception E1) {
		 }
	 }
}
