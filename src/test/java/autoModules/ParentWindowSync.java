package autoModules;

import org.openqa.selenium.WebDriver;

public class ParentWindowSync {

	public static void Sync(WebDriver driver, String parentWindowHandle) {
		
		System.out.println("Checking for window handles...");
		String currentWindowHandle = driver.getWindowHandle();
		System.out.println("parentWindowHandle is "+parentWindowHandle);
		System.out.println("currentWindowHandle is "+currentWindowHandle);
		
		if (currentWindowHandle.matches(parentWindowHandle))
		{
			//System.out.println("Current Window Handle is Parent Window Handle");
			//System.out.println("--------------------------------");
			System.out.println("currentWindowHandle matches parentWindowHandle");
		}
		else
		{
			driver.switchTo().window(parentWindowHandle);
			System.out.println("switched to parentWindowHandle");
			//System.out.println("Switched to Parent Window Handle");
			//System.out.println("--------------------------------");
		}
		
		System.out.println("Window handle sync done");

	}

}
