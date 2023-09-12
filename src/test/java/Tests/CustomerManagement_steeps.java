package Tests;

import org.junit.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import DataSource.LoginPage;
import DataSource.CustomerPage;
import Utils.BrowserUtils;
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


	

	}





    
