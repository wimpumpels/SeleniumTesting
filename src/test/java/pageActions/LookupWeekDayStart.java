package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.AddLinePage;
import pageObjects.VerifyHoursPages;

public class LookupWeekDayStart {

	public static int dayCheckOffset(WebDriver driver, String Mode, int day, String status) {
		
		int dayColXpath = 0;
		int dayOffset = 1;
		
		if (Mode.matches("Create"))
		{
			dayColXpath = day+1;	//day column header xpath starts at 2 when adding new line
			
			System.out.println("dayCheckOffset Mode set to Create");
			
			String dayHeaderCheck = AddLinePage.txt_DayColumnHeader(driver, dayColXpath).getText().toString();
			
			System.out.println("Checking Day Column Headers...");
			
			if (dayHeaderCheck.contains("Mon"))
			{
				dayOffset = 1;
				System.out.println("First Column is a Monday!");
			}
			else if (dayHeaderCheck.contains("Tue"))
			{
				dayOffset = 7;
				System.out.println("First Column is a Tuesday!");
			}
			else if (dayHeaderCheck.contains("Wed"))
			{
				dayOffset = 6;
				System.out.println("First Column is a Wednesday!");
			}
			else if (dayHeaderCheck.contains("Thu"))
			{
				dayOffset = 5;
				System.out.println("First Column is a Thursday!");
			}
			else if (dayHeaderCheck.contains("Fri"))
			{
				dayOffset = 4;
				System.out.println("First Column is a Friday!");
			}
			else if (dayHeaderCheck.contains("Sat"))
			{
				dayOffset = 3;
				System.out.println("First Column is a Saturday!");
			}
			else if (dayHeaderCheck.contains("Sun"))
			{
				dayOffset = 2;
				System.out.println("First Column is a Sunday!");
			}
									
		}
		else if (Mode.matches("Validate"))
		{
			dayColXpath = day+6;	//day column header xpath starts at 7 when verifying line/s hours
			
			System.out.println("dayCheckOffset Mode set to Validate");
			
			String dayHeaderCheck = VerifyHoursPages.txt_DayColumnHeader(driver, dayColXpath, status).getText().toString();
			
			System.out.println("Checking Day Column Headers...");
			
			if (dayHeaderCheck.contains("Mon"))
			{
				dayOffset = 1;
				System.out.println("First Column is a Monday!");
			}
			else if (dayHeaderCheck.contains("Tue"))
			{
				dayOffset = 7;
				System.out.println("First Column is a Tuesday!");
			}
			else if (dayHeaderCheck.contains("Wed"))
			{
				dayOffset = 6;
				System.out.println("First Column is a Wednesday!");
			}
			else if (dayHeaderCheck.contains("Thu"))
			{
				dayOffset = 5;
				System.out.println("First Column is a Thursday!");
			}
			else if (dayHeaderCheck.contains("Fri"))
			{
				dayOffset = 4;
				System.out.println("First Column is a Friday!");
			}
			else if (dayHeaderCheck.contains("Sat"))
			{
				dayOffset = 3;
				System.out.println("First Column is a Saturday!");
			}
			else if (dayHeaderCheck.contains("Sun"))
			{
				dayOffset = 2;
				System.out.println("First Column is a Sunday!");
			}
									
		}
		
		System.out.println("dayOffset is "+dayOffset);
		return dayOffset;

	}

}