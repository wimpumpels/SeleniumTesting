package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTimesheetPage {
	
	private static WebElement element = null;
	
	public static WebElement ddown_Branch(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Branch']"));
		
		return element;
	}

	public static WebElement txt_WeekendDate(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='WeekendDate']"));
		
		return element;
	}
	
	public static WebElement btn_SaveTimesheet(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Submit']"));
		
		return element;
	}
	
	public static WebElement btn_Confirm(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Submit']"));
		
		return element;
	}
	
}
