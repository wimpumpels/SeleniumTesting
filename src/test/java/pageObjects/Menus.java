package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menus {
	
	private static WebElement element = null;
	
	public static WebElement icon_MenuIcon(WebDriver driver, int row)
	{
		element = driver.findElement(By.xpath("//*[@id='Table1']/tbody/tr[3]/td[1]/table/tbody/tr["+row+"]"));
		
		return element;
	}
	
	public static WebElement link_Logout(WebDriver driver)
	{
		int col = 6;
		String link_Menu = "";
		System.out.println("Looking for LOGOUT link...");
		for(col = 6; col <= 100; col = col+2)
		{
			link_Menu = driver.findElement(By.xpath("//*[@id='Table1']/tbody/tr[2]/td/table/tbody/tr/td["+col+"]")).getText().toString();
			System.out.println("Column "+col+" points to "+link_Menu);
			
			if(link_Menu.matches("LOGOUT"))
			{
				element = driver.findElement(By.xpath("//*[@id='Table1']/tbody/tr[2]/td/table/tbody/tr/td["+col+"]/nobr/a"));
				System.out.println("LOGOUT link found on column "+col+"!");
				break;
			}
		}
		return element;
	}

}
