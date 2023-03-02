package Play;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo 
{
	public static WebDriver driver;
	
	public static void main(String []args) 
	{
	
		String homePage = "https://e-pns.org/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode;

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(homePage);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while(it.hasNext())
		{

		url = it.next().getAttribute("href");

		System.out.println(url);

		if(url == null || url.isEmpty())
		{
		System.out.println("URL is either not configured for anchor tag or it is empty");
		continue;
		}
		
		/*
		if(!url.startsWith(homePage)){
		System.out.println("URL belongs to another domain, skipping it.");
		continue;
		}*/

		try 
		{
		huc = (HttpURLConnection)(new URL(url).openConnection());

		huc.setRequestMethod("HEAD");

		huc.connect();

		respCode = huc.getResponseCode();

		if(respCode == 200)
		{
			System.out.println(url+" is a valid link" + ". The response code " + respCode);
		}
		else{
			System.out.println(url+" is a broken link"+ respCode);
		
		}

		} catch (MalformedURLException e) {
		
		e.printStackTrace();
		System.out.println(e);
		} 
		
		catch (IOException e)
		{
		e.printStackTrace();
		System.out.println(e);
		}
		}

		driver.quit();
	}
	}

	