/*	
 * 	This module will input the following items to the UI based the input from the test data sheet, before clicking on Save Line button:
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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import pageActions.LookupWeekDayStart;
import pageObjects.AddLinePage;
import testData.ExcelUtils;

public class AddLineHours {

	public static void Execute(WebDriver driver, String sJobCode, String sActivityCode, String sWorkCentre, int currDataRow) throws Exception {
		
		int dayColCounter = 1;		//counter used to point which nth day column (in the UI) the code is currently looking at
		int currDataCol = 8;		//points the current cell column (in the datasheet) the code is referencing
		int dayOffset = 0;			//offsets the counter and index depending on the which day is displayed in the UI on the first column
		int dayIndex = 1;			//index used to point which nth day column (in the datasheet) the code is currently looking at
		int dayColXpath = 2;		//day column number xpath to be used to point the WebElement
		String sHours = "";			//day hours from datasheet
		String dayColHeader = "";	//day column header as displayed in UI
		String parentWindowHandle = driver.getWindowHandle().toString();	//capture parent window handle to sync purposes
		
		AddLinePage.txt_JobCode(driver).clear();			//clear job code text box prior to entering new value
		Thread.sleep(250);									//for sync purposes, IE is too slow :(
		AddLinePage.txt_JobCode(driver).sendKeys(sJobCode);	//input job code as obtained from test data sheet
		Thread.sleep(250);									//for sync purposes, IE is too slow :(
		ParentWindowSync.Sync(driver, parentWindowHandle);	//for sync purposes
		AddLinePage.txt_JobCodeDesc(driver).click();		//to display description on read-only field, tabbing-out does not work :(
		System.out.println("Job Code = "+sJobCode);
				
		AddLinePage.txt_ActivityCode(driver).clear();					//clear activity code text box prior to entering new value
		Thread.sleep(250);												//for sync purposes, IE is too slow :(
		AddLinePage.txt_ActivityCode(driver).sendKeys(sActivityCode);	//input activity code as obtained from test data sheet
		Thread.sleep(250);												//for sync purposes, IE is too slow :(
		ParentWindowSync.Sync(driver, parentWindowHandle);				//for sync purposes
		AddLinePage.txt_ActivityCodeDesc(driver).click();				//to display description on read-only field, tabbing-out does not work :(
		System.out.println("Activity Code = "+sActivityCode);
		
		AddLinePage.txt_WorkCentre(driver).clear();					//clear work centre text box prior to entering new value
		Thread.sleep(250);											//for sync purposes, IE is too slow :(
		AddLinePage.txt_WorkCentre(driver).sendKeys(sWorkCentre);	//input work centre as obtained from test data sheet
		Thread.sleep(250);											//for sync purposes, IE is too slow :(
		ParentWindowSync.Sync(driver, parentWindowHandle);			//for sync purposes
		AddLinePage.txt_WorkCentreDesc(driver).click();				//to display description on read-only field, tabbing-out does not work :(
		System.out.println("Work Centre = "+sWorkCentre);
		
		dayOffset = LookupWeekDayStart.dayCheckOffset(driver, "Create", dayIndex, "");	//offset day text field xpaths for incomplete weeks, pass mode 'Create'
		
		System.out.println("  dayIndex  | currDataCol | dayColCounter | dayColXpath | dayColHeader |  Hours Entered  ");
		
		for (dayColCounter = dayOffset; dayColCounter <=7; dayColCounter++)
		{
			currDataCol = dayIndex+7;	//point day hours to reference correct test data column
			//System.out.println("dayIndex is "+dayIndex);
			//System.out.println("currDataCol is "+currDataCol);
			sHours = ExcelUtils.getCellDataWithTrailingZeros(currDataRow, currDataCol);	//get day hours from test data sheet

			//System.out.println("dayColCounter is "+dayColCounter);
			AddLinePage.txt_DayHoursInput(driver, dayColCounter).clear();	//clear day hours input text box prior to entering new value
			Thread.sleep(250);	//for sync purposes
			AddLinePage.txt_DayHoursInput(driver, dayColCounter).sendKeys(sHours);	//input day hours as obtained from test data sheet
			AddLinePage.txt_DayHoursInput(driver, dayColCounter).sendKeys(Keys.TAB);	//tab-out of text box to isolate current vs next text boxes
			
			dayColXpath = dayIndex+dayOffset;	//re-aligns to correct column header xpath after adjustment
			dayColHeader = AddLinePage.txt_DayColumnHeader(driver, dayColXpath).getText().toString();	//get day column header from UI
			//System.out.println(sHours+" Hours Entered for "+dayColHeader);
			
			System.out.println("     "+dayIndex+"      |      "+currDataCol+"      |       "+dayColCounter+"       |     "+dayColXpath+"      |   "+dayColHeader+"  |   "+sHours+"   ");
			
			dayIndex++;	//increment index to re-align with next test data column
			
		}
		System.out.println("--------------------------------");
		
		AddLinePage.btn_SaveLine(driver).click();	//click on Save Line button
		System.out.println("Clicked on Save Line");

	}

}
