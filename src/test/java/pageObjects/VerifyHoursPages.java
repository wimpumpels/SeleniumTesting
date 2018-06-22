package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyHoursPages {
	
	private static WebElement element = null;
	
	public static WebElement txt_WeekEndDate(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='DateRange']"));
		
		return element;
	}
	
	public static WebElement ddown_Status(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Status']"));
		
		return element;
	}
	
	public static WebElement btn_SearchNow(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='submit1']"));
		
		return element;
	}
	
	public static WebElement lnk_SearchResult(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//*[@id='Table4']/tbody/tr["+row+"]/td[1]/a/span/nobr"));
		
		return element;
	}
	
	public static WebElement txt_TimesheetStatus(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Table2']/tbody/tr[1]/td/table[2]/tbody/tr/td/table[1]/tbody/tr/td[2]/input"));
		
		return element;
	}
	
	public static WebElement txt_Branch(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Table2']/tbody/tr[1]/td/table[2]/tbody/tr/td/table[1]/tbody/tr/td[4]/input"));
		
		return element;
	}
	
	public static WebElement txt_JobCode(WebDriver driver, int currDataRow, String status)
	{
		int verifyDataRow = currDataRow+1;
		int table = 0;
		
		if (status.matches("Submitted"))
		{
			table = 9;
		}
		else
		{
			table = 6;
		}
		
		element = driver.findElement(By.xpath("//*[@id='Table"+table+"']/tbody/tr["+verifyDataRow+"]/td[2]"));
				
		return element;
	}
	
	public static WebElement txt_ActivityCode(WebDriver driver, int currDataRow, String status)
	{
		int verifyDataRow = currDataRow+1;
		int table = 0;
		
		if (status.matches("Submitted"))
		{
			table = 9;
		}
		else
		{
			table = 6;
		}
		
		element = driver.findElement(By.xpath("//*[@id='Table"+table+"']/tbody/tr["+verifyDataRow+"]/td[4]"));
		
		return element;
	}
	
	public static WebElement txt_WorkCentre(WebDriver driver, int currDataRow, String status)
	{
		int verifyDataRow = currDataRow+1;
		int table = 0;
		
		if (status.matches("Submitted"))
		{
			table = 9;
		}
		else
		{
			table = 6;
		}
		
		element = driver.findElement(By.xpath("//*[@id='Table"+table+"']/tbody/tr["+verifyDataRow+"]/td[6]"));
		
		return element;
	}
	
	public static WebElement txt_DayColumnHeader(WebDriver driver, int dayColXpath, String status)
	{
		int table = 0;
		
		if (status.matches("Submitted"))
		{
			table = 9;
		}
		else
		{
			table = 6;
		}
		
		element = driver.findElement(By.xpath("//*[@id='Table"+table+"']/tbody/tr[1]/td["+dayColXpath+"]"));
		
		return element;
	}
	
	public static WebElement txt_DayHours(WebDriver driver, int currDataRow, int dayColXpath, String status)
	{
		int verifyDataRow = currDataRow+1;
		int table = 0;
		
		if (status.matches("Submitted"))
		{
			table = 9;
		}
		else
		{
			table = 6;
		}
		
		element = driver.findElement(By.xpath("//*[@id='Table"+table+"']/tbody/tr["+verifyDataRow+"]/td["+dayColXpath+"]"));
		
		return element;
	}

}
