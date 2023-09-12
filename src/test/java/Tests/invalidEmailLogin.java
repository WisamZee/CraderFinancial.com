package Tests;

import java.time.Duration;
import Utils.BrowserUtils;
import Utils.Driver;
import Utils.TestDataReader;
import DataSource.LoginPage;

public class invalidEmailLogin{
	
public static void main(String[] args) {
	invalidEmailLoginTest();

}

static BrowserUtils utils;
static LoginPage loginpage;

public static void invalidEmailLoginTest() {
	utils = new BrowserUtils();
	loginpage = new LoginPage();
		
		// go to crater
		Driver.getDriver().get(TestDataReader.getProperty("appurl"));
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.getDriver().manage().window().maximize();
		
		// click on login button without filling out the credential fields 
		utils.waitForElementToBeVisible(loginpage.login_page_email_box);
		loginpage.login_page_login_btn.click();
		
		// then verify there are 2 fields required messages display
		utils.waitForAllElementsToBeVisible(loginpage.login_page_fieldRequired_Messages);
		if (loginpage.login_page_fieldRequired_Messages.size() == 2) {
			System.out.println("There are 2 required field messages displayed");
		}else {
			System.out.println("Something is wrong with required field messages.");
		}
		
		// enter valid email dummy@primetechschool.com and invalid password primeschool
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, "primeschool");
		
		// click login button
		loginpage.login_page_login_btn.click();
		
		// then verify that an error message  "These credentials do not match our records." displays
		utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
		if (loginpage.login_page_invalidLogin_message.isDisplayed()) {
			System.out.println("Credential invalid Error message displayed");
		}else {
			System.out.println("Credential invalid Error message not displayed"); 
		}
	}
public static void invalidPasswordLoginTest() {
	utils = new BrowserUtils();
	loginpage = new LoginPage();
		
//go to crater
	Driver.getDriver().get(TestDataReader.getProperty("appurl"));
	Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Driver.getDriver().manage().window().maximize();
		
//click on login button without filling out the credential fields 
	utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	loginpage.login_page_login_btn.click();
				
//then verify there are 2 fields required messages display
	utils.waitForAllElementsToBeVisible(loginpage.login_page_fieldRequired_Messages);
	if (loginpage.login_page_fieldRequired_Messages.size() == 2) {
		System.out.println("There are 2 required field messages displayed");
	}else {
		System.out.println("Something is wrong with required field messages.");
}
//enter valid email dummy@primetechschool.com and invalid password primeschool
	utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
	utils.sendkeysWithActionsClass(loginpage.login_page_password_box, "primeschool");
		
//click login button
	loginpage.login_page_login_btn.click();
		
//then verify that an error message  "These credentials do not match our records." displays
	utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
	if (loginpage.login_page_invalidLogin_message.isDisplayed()) {
		System.out.println("Credential invalid Error message displayed");
	}else {
		System.out.println("Credential invalid Error message not displayed"); 
}
}
}


