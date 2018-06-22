package autoModules;

import org.openqa.selenium.WebDriver;

import pageActions.SelectFromDropdownList;
import pageObjects.AddTimesheetPage;

public class AddTimesheet {

	public static void Execute(WebDriver driver, String sBranch, String sWeekEndDate) {
		SelectFromDropdownList.Branch(driver, sBranch);
		
		AddTimesheetPage.txt_WeekendDate(driver).clear();
		AddTimesheetPage.txt_WeekendDate(driver).sendKeys(sWeekEndDate);
		
		AddTimesheetPage.btn_SaveTimesheet(driver).click();
		System.out.println("Timesheet for "+sWeekEndDate+" created");

	}

}
