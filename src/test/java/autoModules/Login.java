package autoModules;

import org.openqa.selenium.WebDriver;

import pageActions.SelectFromDropdownList;
import pageObjects.LoginPage;

public class Login {

	public static void Execute(WebDriver driver, String sUser, String sPass, String sCompany) {
		LoginPage.txt_UserCode(driver).sendKeys(sUser);
		System.out.println("User Code entered");
		
		LoginPage.txt_Password(driver).sendKeys(sPass);
		System.out.println("Password entered");
		
		SelectFromDropdownList.Company(driver, sCompany);
		System.out.println("Company selected");
		
		LoginPage.btn_Login(driver).click();
		System.out.println("Login button clicked");

	}

}
