package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.VerifyHoursPages;

public class SearchResultsLookupByWeekEndDate {

	public static void Execute(WebDriver driver, String sWeekEndDate)
	{
		int row = 2;
		System.out.println("Looking for "+sWeekEndDate+" from Search Results...");
		
		for (row = 2; row <= 1000; row = row+2)
		{
			String searchResult = VerifyHoursPages.lnk_SearchResult(driver, row).getText().toString();
			System.out.println("Row "+row+" points to "+searchResult);
			
			if (searchResult.matches(sWeekEndDate))
			{
				System.out.println("Found "+sWeekEndDate+" from results!");
				System.out.println("Click on "+searchResult);
				//System.out.println("--------------------------------");
				VerifyHoursPages.lnk_SearchResult(driver, row).click();
				System.out.println("Clicked "+searchResult+" link");
				break;
			}	
		}
		
	}
	
	/*
	public static String getWeekEndDateStatus (WebDriver driver, String sWeekEndDate)
	{
		int row = 2;
		String status = "";
		System.out.println("Looking for "+sWeekEndDate+" Status from Search Results...\"");
		
		for (row = 2; row <= 1000; row = row+2)
		{
			String searchResult = VerifyHoursPages.txt_SearchResult(driver, row).getText().toString();
			
			if (searchResult.matches(sWeekEndDate))
			{
				status = VerifyHoursPages.txt_SearchResultStatus(driver, row).getText();
				break;
			}						
		}
		
		return status;
		
	}
	*/

}
