package Tests;

import java.time.Duration;

import DataSource.LoginPage;
import Utils.BrowserUtils;
import Utils.Driver;
import Utils.TestDataReader;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagement_Steps {
	
	 BrowserUtils utils= new BrowserUtils();
	LoginPage loginpage = new LoginPage();

	// invalid Password login attempt - start
	// Scenario: The User should be Unable to Login with Invalid Credentials.
	@Given("There are Tow {string} Messages Display.")
	public void there_are_tow_messages_display(String fieldMassage) {
	Driver.getDriver().get(TestDataReader.getProperty("appurl"));
	Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Driver.getDriver().manage().window().maximize();
	
	utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	loginpage.login_page_login_btn.click();
	
	utils.waitForAllElementsToBeVisible(loginpage.login_page_fieldRequired_Messages);
	Assert.assertSame(fieldMassage, loginpage.login_page_fieldRequired_Messages);
	//Assert.assertEquals(fieldMassage, loginpage.login_page_fieldRequired_Messages.getText());
	}

	@When("I enter a Valid Email and an Invalid Password.")
	public void i_enter_a_valid_email_and_an_invalid_password() {
		utils.sendkeysWithActionsClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
		utils.sendkeysWithActionsClass(loginpage.login_page_password_box, "primeschool");
		
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
	loginpage.login_page_login_btn.click();
		
	}

	@Then("I can see that an Error Message \\({string}) Displays")
public void i_can_see_that_an_error_message_displays(String errorMassage) {
	utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
	Assert.assertEquals(errorMassage, loginpage.login_page_invalidLogin_message.getText());
	}
	// invalid Password login attempt - end
	
	// invalid email login attempt - start
		@When("I enter invalid username and valid password")
		public void i_enter_invalid_username_and_valid_password() {
			utils.sendkeysWithActionsClass(loginpage.login_page_email_box, "yummy@primetechschool.com");
			utils.sendkeysWithActionsClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
		}

		@Then("I should see an error message {string} displays")
		public void i_should_see_an_error_message_displays(String errorMessage) {
		    utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
		    Assert.assertEquals(errorMessage, loginpage.login_page_invalidLogin_message.getText());
		    
		}

		@Then("I should not be logged in")
		public void i_should_not_be_logged_in() {
		   Assert.assertTrue(loginpage.login_page_login_btn.isDisplayed());
		}
		// invalid email login attempt - end

	}