package Publications;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchAuthor extends Base
{
	@Test(priority = 3)
	public void feed() throws InterruptedException
	{
		//Search Files using Search Author
		driver.findElement(By.id("author_inputs")).sendKeys("Rick ");

		//Submit
		driver.findElement(By.xpath("//button[@id='btnsearch']")).click();
		Thread.sleep(1000);
		
				if( driver.getPageSource().contains("rick"))
					{
						System.out.println("search is working");
					}
				else if(driver.getPageSource().contains("No Records Found...")) 
					{
						System.out.println("search is working - No files are found");
					}
				else
					{
						System.out.println("search fail");
					}
	}
}
