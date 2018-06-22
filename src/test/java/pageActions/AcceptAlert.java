package pageActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcceptAlert {

	public static void Execute(WebDriver driver) {
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert accepted!");
			System.out.println("--------------------------------");
			//ParentWindowSync.Sync(driver, parentWindowHandle);
		}
		catch (Exception e)
		{
			System.out.println("No alert found!");
			System.out.println("--------------------------------");
		}

	}

}
