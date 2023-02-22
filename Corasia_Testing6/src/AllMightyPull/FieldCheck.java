package AllMightyPull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
Target
------
	1. Check all the fields are loaded.   
	2. Compare all the fields are loaded using a default list.
	3. Show fields that are not loaded as per the required list.

Path to reach Target
--------------
	1. Use a Main array-list to load all the fields.
	2. Use list arrays to store text-box fields, drop-down fields & text-area.
	3. collect and pass all the list arrays to main array
	4. Use a Secondary array-list and manually store default values to it. 
	5. Clone the main array.
	6. Use the clone array to compare with secondary array and remove all the unmatched values. Display the clone array values --> They are unmatched or not loaded arrays.
*/

public class FieldCheck extends Base
{
	@Test (priority = 4)
	public void devapathapull() throws InterruptedException
	{
		ArrayList<String> tlinks = new ArrayList<String>();
		List<WebElement> alt = driver.findElements(By.xpath("//input[@type='text']"));
		Thread.sleep(500);
		for(int tb = 0 ; tb < alt.size() ; tb++)
			{
				tlinks.add(alt.get(tb).getAttribute("id"));
			}
		
		List<WebElement> aldpdwn = driver.findElements(By.xpath("//div[@class='col-md-6']//select"));
		Thread.sleep(500);
		for(int dpdw = 0 ; dpdw < aldpdwn.size() ; dpdw++)
			{
				tlinks.add(alt.get(dpdw).getAttribute("id"));
			}
		
		List<WebElement> textarea = driver.findElements(By.xpath("//textarea"));
		Thread.sleep(500);
		for(int ttr = 0 ; ttr < textarea.size() ; ttr++)
			{
				tlinks.add(textarea.get(ttr).getAttribute("id"));
			}
		
		ArrayList<String> tbxrequired = new ArrayList<String>();
		tbxrequired.addAll(Arrays.asList("19_other" , "42" , "2" ,  "5_other" , "4_other" , "1_other" , "6" , "100" , "98 " , "100002 " ,  "7" , "14" , "15" , "16" , "58" , "search_supplier"));
		
		if(tlinks.equals(tbxrequired))
			{
				System.out.println("The Field matches the required list");
			}
		else
			{
				tbxrequired.removeAll(tlinks);
				for(int p = 0 ; p< tbxrequired.size(); p++)
				{
						System.out.println("The Field does not match the required list "+ tbxrequired.get(p));
				}
			}
	}
}
