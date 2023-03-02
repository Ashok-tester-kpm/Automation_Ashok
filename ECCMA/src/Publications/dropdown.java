package Publications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropdown extends Base
{
	@Test(priority = 1)
	public void drpdown()
	{
		Select category = new Select(driver.findElement(By.xpath("//select[@id='category']")));
		List<WebElement> cat = category.getOptions();
		ArrayList<String> dropcont = new ArrayList<>();
		
		for(int i = 0 ; i < cat.size() ; i ++)
			{
				System.out.println(cat.get(i).getAttribute("value"));
				dropcont.add(cat.get(i).getAttribute("value"));
			}
		
		ArrayList<String> catdrop = new ArrayList<String>(); 
		catdrop.addAll(Arrays.asList("Whitepaper",
				"All",
				"eCDM Brochure",
				"eOTD Downloads",
				"eGOR Explanatory Guide",
				"Case Studies",
				"Standards",
				"Newsletter",
				"Press Releases",
				"Presentation-12",
				"Presentation-11",
				"Presentation-10",
				"Presentation-9",
				"Presentation-8",
				"Presentation-1",
				"Presentation-2",
				"Presentation-3",
				"Presentation-4",
				"Presentation-5",
				"Presentation-7","treat"));
		
		System.out.println(dropcont.size());
		
		if(catdrop.equals(dropcont))
		{
			System.out.println("pass");
		}
		else
		{
			catdrop.removeAll(dropcont);
			for(int c = 0 ; c < catdrop.size() ; c ++)
			{
				System.out.println("The drop down content did not match the required list ");
				System.out.println("The Un-Matched content found is "+catdrop.get(c));
			}
		}
		
	}
}