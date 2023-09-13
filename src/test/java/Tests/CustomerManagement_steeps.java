package Tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import DataSource.LoginPage;
import DataSource.CustomerPage;
import Utils.BrowserUtils;
import Utils.Driver;
import DataSource.Dashboardpage;

public class CustomerManagement_steeps {
	Dashboardpage dash_page = new Dashboardpage();
	BrowserUtils utils = new BrowserUtils();
	LoginPage loginpage = new LoginPage();
	CustomerPage CustPage = new CustomerPage();
	
	//@NewCustomerBtn Test Start 
@When("i navigate to the customers tab")
public void i_navigate_to_the_customers_tab() {
	dash_page.dash_page_Customers_tab.click();
	utils.waitForElementToBeVisible(CustPage.customers_page_customers_headerText);
	Assert.assertTrue(CustPage.customers_page_customers_headerText.isDisplayed());
	
}


@Then("I should see the New Customer button displayed")
public void i_should_see_the_new_customer_button_displayed() {
	utils.waitForElementToBeVisible(CustPage.customers_page_newcustomers_button);
    Assert.assertTrue(CustPage.customers_page_newcustomers_button.isDisplayed());
	
}
//@NewCustomerBtn Test end 

//@NewCustomerBasicInfoField Test Start 
@Then("I Click on New Customer button")
public void i_click_on_new_customer_button() {
	CustPage.customers_page_newcustomers_button.click();
	utils.waitForElementToBeVisible(CustPage.customers_page_Basic_Info_Text);
}

@Then("customer should see that a Basic info form label is present")
public void customer_should_see_that_a_basic_info_form_label_is_present() {
	Assert.assertTrue(CustPage.customers_page_Basic_Info_Text.isDisplayed());
}
@Then("I should see the Fields Display Name,  Primary Contact Name, Email, Primary Currency, Website, and Prefix")
public void i_should_see_the_fields_display_name_primary_contact_name_email_primary_currency_website_and_prefix() {
	
	utils.waitForElementToBeVisible(CustPage.customer_page_BasicInfo_DisplayName_Field);
	Assert.assertTrue(CustPage.customer_page_BasicInfo_DisplayName_Field.isDisplayed());
	
	Assert.assertTrue(CustPage.customer_page_BasicInfo_PrimaryContactName_Field.isDisplayed());
	
	Assert.assertTrue(CustPage.customer_page_BasicInfo_Phone_Field.isDisplayed());
	
	Assert.assertTrue(CustPage.customer_page_BasicInfo_PrimaryCurrency_Field.isDisplayed());
	
	Assert.assertTrue(CustPage.customer_page_BasicInfo_Email_Field.isDisplayed());
	
	Assert.assertTrue(CustPage.customer_page_BasicInfo_Website_Field.isDisplayed());
	
	Assert.assertTrue(CustPage.customer_page_BasicInfo_Prefix_Field.isDisplayed());
	
	}
//@NewCustomerBasicInfoField Test End

//@newCustomerTableListTest Start 

@Then("I should see the  list of the customer name as a list table")
public void i_should_see_the_list_of_the_customer_name_as_a_list_table() throws InterruptedException {
Thread.sleep(1500);
	if (CustPage.customer_page_NoCustomersYet_text.isDisplayed()) {
		CustPage.customers_page_newcustomers_button.click();
		utils.waitForElementToBeVisible(CustPage.customer_page_BasicInfo_DisplayName_Field);
		CustPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Sam here");
		CustPage.customer_page_NewCustomerSubmit_BTN.click();
		utils.waitForElementToBeVisible(dash_page.dash_page_Customers_tab);
		Thread.sleep(500);

		dash_page.dash_page_Customers_tab.click();
		Thread.sleep(500);

		Assert.assertTrue(CustPage.customer_page_Customer_List_Table.isDisplayed());
 
	
}else { 
	System.out.println("Customer List Table is Visible");
	Assert.assertTrue(CustPage.customer_page_Customer_List_Table.isDisplayed());
}
}
	@Then("I should see the Customer List Table")
	public void i_should_see_the_customer_list_table() throws InterruptedException {
		Thread.sleep(2000);
		
		if (CustPage.customer_page_NoCustomersYet_text.isDisplayed()) {
			CustPage.customer_page_NewCustomerSubmit_BTN.click();
			utils.waitForElementToBeVisible(CustPage.customer_page_BasicInfo_DisplayName_Field);
			CustPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Student");
			CustPage.customer_page_NewCustomerSubmit_BTN.click();
			Thread.sleep(1000);
			dash_page.dash_page_Customers_tab.click();
//			Thread.sleep(1000);
			utils.waitForElementToBeVisible(CustPage.customers_page_customers_headerText);
			Assert.assertTrue(CustPage.customers_page_customers_headerText.isDisplayed());
		} else {
			Assert.assertTrue(CustPage.customers_page_customers_headerText.isDisplayed());
		}
	//@newCustomerTableListTest End 
	}
		// @newCustomerCreatedMessage Start 
		@Then("I Enter a display Name")
		public void i_enter_a_display_name() {
			CustPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Samer");
			
		}

		@Then("Click Save")
		public void click_save() {
			CustPage.customer_page_NewCustomerSubmit_BTN.click();
		}

		@Then("I should see The PopUp Message {string}")
		public void i_should_see_the_pop_up_message(String message) {
			utils.waitForElementToBeVisible(CustPage.customer_page_newCustomer_Success_Message);
			Assert.assertEquals(CustPage.customer_page_newCustomer_Success_Message.getText(), message);
		}

		@Then("Delete The Customer")
		public void delete_the_customer() {
			utils.waitForElementToBeVisible(dash_page.dash_page_Customers_tab);
			dash_page.dash_page_Customers_tab.click();
			utils.waitForElementToBeVisible(CustPage.customer_page_customerTable_3dotMoreLink);
			CustPage.customer_page_customerTable_3dotMoreLink.click();
			utils.waitForElementToBeVisible(CustPage.customer_page_customerTable_3dotMoreLink_Delete);
			CustPage.customer_page_customerTable_3dotMoreLink_Delete.click();
			utils.waitForElementToBeVisible(CustPage.customer_page_customerTable_3dotMoreLink_Delete_OK_BTN);
			CustPage.customer_page_customerTable_3dotMoreLink_Delete_OK_BTN.click();
		}

		@Then("I should see the error massage {string} below the Name Field")
		public void i_should_see_the_error_massage_below_the_name_field(String string) {
			utils.waitForElementToBeVisible(CustPage.customer_page_newCustomer_FieldIsRequired_Error_Message);
			Assert.assertTrue(CustPage.customer_page_newCustomer_FieldIsRequired_Error_Message.isDisplayed());
		}

		// @newCustomerCreatedMessage End 

		@Then("I enter a valid display name {string}, Email {string}, Billing Address {string}, and Shipping Address {string}")
		public void i_enter_a_valid_and(String displayName, String email, String state, String city, String zipcode) throws InterruptedException {
				displayName = displayName;
				
				utils.waitForElementToBeVisible(CustPage.customer_page_BasicInfo_DisplayName_Field);
				CustPage.customer_page_BasicInfo_DisplayName_Field.sendKeys(displayName);
				CustPage.customer_page_BasicInfo_Email_Field.sendKeys(email);
				CustPage.customer_page_newCustomer_Billing_NameField.sendKeys(displayName);
				CustPage.customer_page_newCustomer_Billing_CityField.sendKeys(city);
				CustPage.customer_page_newCustomer_Billing_ZipcodeField.sendKeys(zipcode);
				utils.clickWithActionsClass(CustPage.customer_page_newCustomer_Billing_CountryDropDown);
				utils.waitForElementToBeVisible(CustPage.customer_page_newCustomer_Billing_CountryDropDown_UnitedStates);
				utils.clickWithActionsClass(CustPage.customer_page_newCustomer_Billing_CountryDropDown_UnitedStates);
//				customerPage.customer_page_newCustomer_CopyFromBillingBTN.click();
				utils.clickWithActionsClass(CustPage.customer_page_newCustomer_CopyFromBillingBTN);
//				utils.waitForElementToBeInputed(customerPage.customer_page_newCustomer_Shipping_NameField, name);
//				Thread.sleep(5000);
				utils.moveToWithActionsClass(CustPage.customer_page_NewCustomerSubmit_BTN);
				utils.waitUntilElementClickable(CustPage.customer_page_NewCustomerSubmit_BTN);
				CustPage.customer_page_NewCustomerSubmit_BTN.click();
			}
		

		@Then("I should view the saved customer in the Customers Table")
		public void i_should_view_the_saved_customer_in_the_customers_table() {
			utils.waitForElementToBeVisible(CustPage.customer_page_Sales_and_Expenses_header);
			Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[contains(text()')]")).isDisplayed());
		
		}
		// @newCustomers end - 
		
		
		// @newCustomerFormErrorMessages start -
		@When("I enter invalid informatin: display name {string} and email {string}")
		public void i_enter_invalid_informatin_display_name_and_email(String name, String email) throws InterruptedException {
			utils.waitForElementToBeVisible(CustPage.customers_page_customers_headerText);
			CustPage.customer_page_BasicInfo_DisplayName_Field.sendKeys(name);
			CustPage.customer_page_BasicInfo_Email_Field.sendKeys(email);
			CustPage.customer_page_NewCustomerSubmit_BTN.click();
			Thread.sleep(500);
		}
		@Then("I should see the appropriate error message")
		public void i_should_see_the_appropriate_error_message() {
			boolean isErrorVissible = false;
			for (WebElement errorMessage : CustPage.customer_page_NewCustomer_nameEmail_ErrorMessages) {
				if(errorMessage.isDisplayed()) {
					isErrorVissible = true;
					break;
				}
			}
			Assert.assertTrue(isErrorVissible);
			Driver.quitDriver();
		}
		// @newCustomerFormErrorMessages end -

	}





    
