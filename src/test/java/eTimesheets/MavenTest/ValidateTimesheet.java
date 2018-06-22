package eTimesheets.MavenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autoModules.Login;
import autoModules.ValidateLineHours;
import pageActions.AcceptAlert;
import pageActions.LookupAndClickFromLeftMenuBar;
import pageActions.SearchResultsLookupByWeekEndDate;
import pageActions.SelectFromDropdownList;
import pageObjects.Menus;
import pageObjects.VerifyHoursPages;
import testData.Constant;
import testData.DataRowCheck;
import testData.ExcelUtils;

public class ValidateTimesheet {
	
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("--------------------------------");
		System.out.println("Validate Timesheet Start");
		System.out.println("--------------------------------");
		
		System.setProperty("webdriver.gecko.driver", Constant.Path_FirefoxDriver);
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
		
		System.out.println("--------------------------------");
		System.out.println("Validate Timesheet End");
		System.out.println("--------------------------------");
	}
	
	
	@Test
	public void ValidateTimesheet() throws Exception {
  
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "testData");
		String sUser = ExcelUtils.getCellData(1, 0);
		String sPass = ExcelUtils.getCellData(1, 1);
		String sCompany = ExcelUtils.getCellData(1, 2);
		String sBranch = ExcelUtils.getCellData(1, 3);
		String sWeekEndDate = ExcelUtils.getCellData(1, 4);
		String sJobCode = "";
		String sActivityCode = "";
		String sWorkCentre = "";
		int currDataRow = 1;
		int setDataRows = DataRowCheck.setDataRows();	//checks for number of available data rows via Job Code
		
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jvillapando\\Documents\\Selenium\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		*/
		
		//System.setProperty("webdriver.gecko.driver", Constant.Path_FirefoxDriver);
		//driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\jvillapando\\Documents\\Selenium\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Set URL
		driver.get(Constant.URL);
		//String parentWindowHandle = driver.getWindowHandle().toString();	//capture parent window handle to sync purposes
		
		//Login Start
		Login.Execute(driver, sUser, sPass, sCompany);
		//System.out.println("--------------------------------");
		System.out.println("Login Successful!");
		System.out.println("--------------------------------");
		//Login End
		
		//Navigate to Timesheets Start
		LookupAndClickFromLeftMenuBar.Execute(driver, "Timesheets");
		//System.out.println("--------------------------------");
		System.out.println("Clicked Timesheets Successfully!");
		System.out.println("--------------------------------");
		//Navigate to Timesheets End
		
		//Input Week End Date Start
		VerifyHoursPages.txt_WeekEndDate(driver).clear();
		VerifyHoursPages.txt_WeekEndDate(driver).sendKeys(sWeekEndDate);;
		System.out.println("Week End Date Entered Successfully!");
		System.out.println("--------------------------------");
		//Input Week End Date End
		
		//Select ALL from Status Dropdown Start
		SelectFromDropdownList.Status(driver, "ALL");
		System.out.println("Selected ALL from Status dropdown list Successfully!");
		System.out.println("--------------------------------");
		//Select ALL from Status Dropdown End
		
		//Click Search Now button Start
		VerifyHoursPages.btn_SearchNow(driver).click();
		System.out.println("Clicked on Search Now button Successfully!");
		System.out.println("--------------------------------");
		//Click Search Now button End
		
		//Select Week End Date from Search Results Start
		SearchResultsLookupByWeekEndDate.Execute(driver, sWeekEndDate);
		System.out.println("Selected "+sWeekEndDate+" from results Successfully!");
		System.out.println("--------------------------------");
		//Select Week End Date from Search Results End
		
		//Alert Check Start
		AcceptAlert.Execute(driver);
		//Alert Check End
		
		//Verify Hours Start
		System.out.println(+setDataRows+" Data Row/s Found!");
		for (currDataRow = 1; currDataRow <= setDataRows; currDataRow++)
		{
			System.out.println("Begin verifying for Data Row "+currDataRow+"...");
			sJobCode = ExcelUtils.getCellData(currDataRow, 5);
			sActivityCode = ExcelUtils.getCellData(currDataRow, 6);
			sWorkCentre = ExcelUtils.getCellData(currDataRow, 7);
			
			ValidateLineHours.Execute(driver, sBranch, sJobCode, sActivityCode, sWorkCentre, currDataRow);
		}
		System.out.println("Line Hours Verification Done!");
		System.out.println("--------------------------------");
		//Verify Hours End
		
		//Logout Start
		Menus.link_Logout(driver).click();
		System.out.println("Logging out...");
		System.out.println("Logged out Successfully!");
		//driver.quit();
		//Logout End
  
}
}