package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.Menus;

public class LookupAndClickFromLeftMenuBar {
	
	public static void Execute(WebDriver driver, String menuIcon)
	{
		int rowLeftMenuBar = 2;
		//String xpath = "";
		System.out.println("Looking for "+menuIcon+" from Left Menu...");
		
		for (rowLeftMenuBar = 2; rowLeftMenuBar <= 100; rowLeftMenuBar = rowLeftMenuBar+2)
		{
			//xpath = "//*[@id=\"Table1\"]/tbody/tr[3]/td[1]/table/tbody/tr["+rowLeftMenuBar+"]";
			//System.out.println("xpath is = "+xpath);
			//String button = driver.findElement(By.xpath(xpath)).getText();
			String button = Menus.icon_MenuIcon(driver, rowLeftMenuBar).getText();
			System.out.println("Row "+rowLeftMenuBar+" points to "+button);
			
			if (button.matches(menuIcon))
			{
				System.out.println("Found "+button+"!");
				//System.out.println("--------------------------------");
				//driver.findElement(By.xpath("//*[@id=\"Table1\"]/tbody/tr[3]/td[1]/table/tbody/tr["+row+"]")).click();
				Menus.icon_MenuIcon(driver, rowLeftMenuBar).click();
				System.out.println("Clicked "+button+" from Left Menu");
				break;
			}	
		}
	}
}
