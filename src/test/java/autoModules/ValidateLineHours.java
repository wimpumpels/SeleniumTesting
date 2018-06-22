/*	
 * 	This module will validate the following items as displayed in the UI against the input from the test data sheet:
 * 	-Branch
 * 	-Job Code
 * 	-Activity Code
 * 	-Work Centre
 * 	-Day Hours
 * 	
 * 	Input parameters:
 * 	-WebDriver
 * 	-Branch
 * 	-Job Code
 * 	-Activity Code
 * 	-Work Centre
 * 	-Current Test Data Row
 * 	
 */	

package autoModules;

import org.openqa.selenium.WebDriver;

import pageActions.LookupWeekDayStart;
import pageObjects.VerifyHoursPages;
import testData.ExcelUtils;

public class ValidateLineHours {

	public static void Execute(WebDriver driver, String sBranch, String sJobCode, String sActivityCode, String sWorkCentre, int currDataRow) throws Exception {
		
		int dayColCounter = 1;				//counter used to point which nth day column (in the UI) the code is currently looking at
		int dayIndex = 1;					//index used to point which nth day column (in the datasheet) the code is currently looking at
		int currDataCol = 8;				//points the current cell column (in the datasheet) the code is referencing
		int dayOffset = 0;					//offsets the counter and index depending on the which day is displayed in the UI on the first column
		int dayColXpath = 0;				//day column number xpath to be used to point the WebElement
		String dayColHeader = "";			//day column header as displayed in UI
		String sHours = "";					//day hours from datasheet
		String status = "";					//status of the timesheet under validation
		String verifyBranch = "";			//branch obtained as displayed in UI
		String verifyJobCode = "";			//job code obtained as displayed in UI
		String verifyActivityCode = "";		//activity code obtained as displayed in UI
		String verifyWorkCentre = "";		//work centre obtained as displayed in UI
		String verifyDayHours = "";			//day hours obtained as displayed in UI
		
		status = VerifyHoursPages.txt_TimesheetStatus(driver).getAttribute("value").toString();
		System.out.println("Timesheet Status is "+status);
		
		verifyBranch = VerifyHoursPages.txt_Branch(driver).getAttribute("value").toString();	//get branch from UI
		System.out.println("Found "+verifyBranch+" as Branch!");
		
		if (verifyBranch.contains(sBranch))	//compare branch between UI and test data
		{
			System.out.println("Branch is CORRECT!");
		}
		else
		{
			System.out.println("Branch is INCORRECT! :(");
		}
		
		verifyJobCode = VerifyHoursPages.txt_JobCode(driver, currDataRow, status).getText().toString();	//get job code from UI
		System.out.println("Found "+verifyJobCode+" as Job Code!");
		
		if (verifyJobCode.matches(sJobCode))	//compare job code between UI and test data
		{
			System.out.println("Job Code is CORRECT!");
		}
		else
		{
			System.out.println("Job Code is INCORRECT! :(");
		}
		
		verifyActivityCode = VerifyHoursPages.txt_ActivityCode(driver, currDataRow, status).getText().toString();	//get activity code from UI
		System.out.println("Found "+verifyActivityCode+" as Activity Code!");
		
		if (verifyActivityCode.matches(sActivityCode))	//compare activity code between UI and test data
		{
			System.out.println("Activity Code is CORRECT!");
		}
		else
		{
			System.out.println("Activity Code is INCORRECT! :(");
		}
		
		verifyWorkCentre = VerifyHoursPages.txt_WorkCentre(driver, currDataRow, status).getText().toString();	//get work centre from UI
		System.out.println("Found "+verifyWorkCentre+" as Work Centre!");
		
		if (verifyWorkCentre.matches(sWorkCentre))	//compare work centre between UI and test data
		{
			System.out.println("Work Centre is CORRECT!");
		}
		else
		{
			System.out.println("Work Centre is INCORRECT! :(");
		}
		
		dayOffset = LookupWeekDayStart.dayCheckOffset(driver, "Validate", dayColCounter, status);	//offset day text field xpaths for incomplete weeks, pass mode 'Validate'
		//System.out.println("dayOffset = "+dayOffset);
		
		System.out.println("    Day    |   Actual   |   Expected   |   Status   ");
		
		for (dayColCounter = dayOffset; dayColCounter <=7; dayColCounter++)
		{
			currDataCol = dayIndex+7;	//point day hours to reference correct test data sheet cell column
			sHours = ExcelUtils.getCellDataWithTrailingZeros(currDataRow, currDataCol);	//get day hours from test data sheet
			
			dayColXpath = dayColCounter+6;	//generate day xpath column based on the current day column (in the UI) the code is looking at
			
			//System.out.println("dayOriginal = "+dayOriginal);
			//System.out.println("dayCol = "+dayCol);
			//System.out.println("dayColHeaderIndex = "+dayColHeaderIndex);
			
			verifyDayHours = VerifyHoursPages.txt_DayHours(driver, currDataRow, dayColXpath, status).getText().toString();	//get day hours from UI
			dayColHeader = VerifyHoursPages.txt_DayColumnHeader(driver, dayColXpath, status).getText().toString();	//get day column header from UI
						
			if (verifyDayHours.matches(sHours))	//compare day hours between UI and test data
			{
				System.out.println(" "+dayColHeader+" |    "+verifyDayHours+"    |     "+sHours+"     |   PASSED   ");
			}
			else
			{
				System.out.println(" "+dayColHeader+" |    "+verifyDayHours+"    |     "+sHours+"     |   FAILED   ");
			}
			
			dayIndex++;	//increment index before incrementing column counter
			
		}
		System.out.println("--------------------------------");

	}

}
