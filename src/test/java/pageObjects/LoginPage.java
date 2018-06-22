package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private static WebElement element = null;
	
	public static WebElement txt_UserCode(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CoyOrg']"));
		
		return element;
	}
	
	public static WebElement txt_Password(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Password']"));
		
		return element;
	}
	
	public static WebElement ddown_Company(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='Company']"));
		
		return element;
	}
	
	public static WebElement btn_Login(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='submit1']"));
		
		return element;
	}

}
