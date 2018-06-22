package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLinePage {

	private static WebElement element = null;
	
	public static WebElement txt_JobCode(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='JCJobCode']"));
		
		return element;
	}
	
	public static WebElement txt_JobCodeDesc(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='JCJobDescription']"));
		
		return element;
	}
	
	public static WebElement txt_ActivityCode(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='JCActivityCode']"));
		
		return element;
	}
	
	public static WebElement txt_ActivityCodeDesc(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='JCActivityDescription']"));
		
		return element;
	}
	
	public static WebElement txt_WorkCentre(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='JCWorkCentre']"));
		
		return element;
	}
	
	public static WebElement txt_WorkCentreDesc(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='JCWorkDescription']"));
		
		return element;
	}
	
	public static WebElement txt_DayColumnHeader(WebDriver driver, int dayColXpath)
	{
		element = driver.findElement(By.xpath("//*[@id='Table4']/tbody/tr[2]/td["+dayColXpath+"]"));
		
		return element;
	}
	
	public static WebElement txt_DayHoursInput(WebDriver driver, int day)
	{
		element = driver.findElement(By.xpath("//*[@id='Qty"+day+"']"));
		
		return element;
	}
	
	public static WebElement btn_SaveLine(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Button3']"));
		
		return element;
	}
	

}
