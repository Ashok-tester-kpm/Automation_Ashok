package AllMightyPull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class allpush extends Base
{
	public XSSFWorkbook wb ;
	public XSSFSheet sh ;
	
	@Test(priority = 4)
	public void typeisdropdown() throws Exception
	{
		try 
			{
				ArrayList<String> dlinks = new ArrayList<String>();
				List<WebElement> dbx = driver.findElements(By.xpath("//div[@class='col-md-6']//select"));
				for(int j = 0; j < dbx.size(); j++ )
							{
								dlinks.add(dbx.get(j).getAttribute("id"));
								Thread.sleep(500);
							}
				
				for(int d = 0 ; d< dlinks.size();d++)
							{
								Select dpdwn = new Select(driver.findElement(By.id(dlinks.get(d))));
								dpdwn.selectByIndex(1);
								Thread.sleep(3000);
							}
				
				List<WebElement> dpname = driver.findElements(By.xpath("//span[@class='select2-selection__rendered']/ancestor::div[@class='col-md-6']/preceding-sibling::div//label[@data-html='true']"));
		  		List<WebElement> dpvalue = driver.findElements(By.xpath("//span[@class='select2-selection__rendered']"));
				
				//Array list to collect all the drop down Fields with Name and value.
				//Accessing File from local drive.
		  		File file = new File ("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Excel Report\\QuickAddFeedData(lbl).xlsx");
	  			FileInputStream fis = new FileInputStream(file);
	  			wb = new XSSFWorkbook(fis);
	  			sh = wb.getSheetAt(0);
	  			
	  			//Accessing the value  
	  			for(int dp1 = 0 ; dp1 < dpname.size() ; dp1++)
	  				{
	  					//Automation filled fields - fetched data 
	  					sh.getRow(dp1 + 1).createCell(0).setCellValue(dpname.get(dp1).getText());
	  					Thread.sleep(250);
	  				}
	  			Thread.sleep(500);
	  			
	  			for(int dp2 = 0 ; dp2 < dpvalue.size() ; dp2 ++)
		  			{
			  			//Automation filled fields - fetched data 
		  				sh.getRow(dp2 + 1).createCell(1).setCellValue(dpvalue.get(dp2).getAttribute("title"));
		  				Thread.sleep(250);
		  			}
	  			
	  			FileOutputStream fos = new FileOutputStream(file);
	  			wb.write(fos);
	  			wb.close();
			}
		
		catch(Exception d) 
			{
				System.out.println(d);
			}
	}
	
	@Test(priority = 5)
	public void typeistextbox()
		{
			try
			{
				//collect all text boxes
				ArrayList<String> tlinks = new ArrayList<String>();
				List<WebElement> tbx = driver.findElements(By.xpath("//input[@type='text']"));
				
				for(int i =0; i<tbx.size(); i++ )
	    				{
									//add all field id to text box array tlinks.
			    					tlinks.add(tbx.get(i).getAttribute("id"));
			    					
			    					//Verify whether the text box is loaded as per the requirement
			    					String tbxofform =  tbx.get(i).getAttribute("id");
			    					
			    					boolean req = tbx.get(i).getAttribute("required") != null;
			    					
			    					if(req == true)
			    							{
			    								System.out.println("The Field id "+ tbxofform + " is loaded sucessfully in form"+  ". The Field id "+ tbxofform + " is required");
			    							}
			    					else if(req == false)
			    							{
			    								System.out.println("The Field id "+ tbxofform + " is not displayed in page. But Loaded in form.");
			    							}
								}
			System.out.println("*Note - If field not displayed, Required or not wont appear as per script");
			
			
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
			
			for(int t = 0 ; t<tlinks.size(); t++ )
					{
						if(tlinks.get(t).equals("14")) 
								{
									driver.findElement(By.id(tlinks.get(t))).sendKeys("Dhileep");
								}
						else if(tlinks.get(t).equals("15"))
								{
									driver.findElement(By.id(tlinks.get(t))).sendKeys("dhileep@eccma.org");
								}
						else if(tlinks.get(t).equals("16"))
								{
									driver.findElement(By.id(tlinks.get(t))).sendKeys("123456789");
								}
						else if(tlinks.get(t).equals("19_other") || tlinks.get(t).equals("5_other") || tlinks.get(t).equals("4_other") || tlinks.get(t).equals("1_other"))
								{
									Boolean check = driver.findElement(By.id("19_other")).isDisplayed();
									if(check == true)
									{
										driver.findElement(By.id("19_other")).sendKeys("TestingData");
									}
									else
									{
										continue;
									}
								}
						else if(tlinks.get(t).equals("6"))
								{
										driver.findElement(By.id(tlinks.get(t))).sendKeys("TEST123456");
								}
						else if(tlinks.get(t).equals("search_supplier"))
								{
									Boolean check1 = driver.findElement(By.id("search_supplier")).isDisplayed();
									if(check1 == true)
									{
										driver.findElement(By.id("search_supplier")).sendKeys("TestingData");
									}
									else
									{
										continue;
									}
								}
						else 
								{	
									driver.findElement(By.id(tlinks.get(t))).sendKeys("TestingData");
								}
						
						
						List<WebElement> tbname = driver.findElements(By.xpath("//input[@type='text']/parent::div[@class='col-md-5' or @class='col-md-6']/preceding-sibling::div//label[@title]"));
						
						boolean txtexst = tbx.get(t).getText() != null;
						
						//Array list to collect all the drop down Fields with Name and value.
						//Accessing File from local drive.
				  		File file = new File ("E:\\Testing\\Projects Undertaken\\eMDV_CORASIA\\Excel Report\\QuickAddFeedData(lbl).xlsx");
			  			FileInputStream fis = new FileInputStream(file);
			  			wb = new XSSFWorkbook(fis);
			  			sh = wb.getSheetAt(0);
			  			
			  			//Accessing the value  
			  			for(int tb1 = 0 ; tb1 < tbx.size() ; tb1++)
			  				{
			  					//Automation filled fields - fetched data 
			  					sh.getRow(tb1 + 1).createCell(0).setCellValue(tbx.get(tb1).getText());
			  					Thread.sleep(250);
			  				}
			  			Thread.sleep(500);
			  			
			  			for(int tb2 = 0 ; tb2 < tbx.size() ; tb2 ++)
				  			{
					  			//Automation filled fields - fetched data 
				  				sh.getRow(tb2 + 1).createCell(1).setCellValue(tbx.get(tb2).getText());
				  				Thread.sleep(250);
				  			}
			  			
			  			FileOutputStream fos = new FileOutputStream(file);
			  			wb.write(fos);
			  			wb.close();
					}
			}
			catch(Exception E)
			{
				System.out.println(E);
			}
		}

}