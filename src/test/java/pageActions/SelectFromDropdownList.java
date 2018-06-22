package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.AddTimesheetPage;
import pageObjects.LoginPage;
import pageObjects.VerifyHoursPages;

public class SelectFromDropdownList {

	public static void Company(WebDriver driver, String value)
	{
		Select ddown = new Select(LoginPage.ddown_Company(driver));
		ddown.selectByValue(value);
	}

	public static void Branch(WebDriver driver, String value)
	{
		Select ddown = new Select(AddTimesheetPage.ddown_Branch(driver));
		ddown.selectByValue(value);
	}
	
	public static void Status(WebDriver driver, String value)
	{
		Select ddown = new Select(VerifyHoursPages.ddown_Status(driver));
		ddown.selectByValue(value);
	}
}
