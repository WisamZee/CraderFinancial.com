package DataSource;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.Driver;

public class CustomerPage {
	public CustomerPage (){
		
		PageFactory.initElements(Driver.getDriver(), this);

	}
	@FindBy (xpath = "//h3[text()='Customers']")
	 public WebElement customers_page_customers_headerText;
	
	@FindBy (xpath = "//button[text()=' New Customer']")
    public WebElement customers_page_newcustomers_button;
	
	@FindBy (xpath = "//h6[text()='Basic Info']")
    public WebElement customers_page_Basic_Info_Text;
	
	@FindBy (xpath = "(//input[@name='name'])[1]")
	public WebElement customer_page_BasicInfo_DisplayName_Field;

	@FindBy (xpath = "(//div[@class='relative rounded-md shadow-sm font-base']/input)[2]")
	public WebElement customer_page_BasicInfo_PrimaryContactName_Field;

	@FindBy (xpath = "(//input[@name='phone'])[1]")
	public WebElement customer_page_BasicInfo_Phone_Field;

	@FindBy (xpath = "(//div//child::input[@type='text'])[6]")
	public WebElement customer_page_BasicInfo_PrimaryCurrency_Field;

	@FindBy (xpath = "//input[@name='email']")
	public WebElement customer_page_BasicInfo_Email_Field;

	@FindBy (xpath = "//input[@type='url']")
	public WebElement customer_page_BasicInfo_Website_Field;

	@FindBy (xpath = "(//input[@name='name'])[2]")
	public WebElement customer_page_BasicInfo_Prefix_Field;
	
	@FindBy (xpath = "//table")
	public WebElement customer_page_Customer_List_Table;
	
	@FindBy (xpath = "//label[text()='No customers yet!']")
	public WebElement customer_page_NoCustomersYet_text;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement customer_page_NewCustomerSubmit_BTN;
	
	@FindBy (xpath = "//th[contains(text(), 'Amount Due')]")
	public WebElement customer_page_customerTable_AmountDue_Column;


	@FindBy (xpath = "//th[contains(text(), 'Added On')]")
	public WebElement customer_page_customerTable_AddedOn_Column;

	@FindBy (xpath = "(//button[contains(@id, 'headlessui')])[3]")
	public WebElement customer_page_customerTable_3dotMoreLink;

	@FindBy (xpath = "//a[text()=' Edit']")
	public WebElement customer_page_customerTable_3dotMoreLink_Edit;

	@FindBy (xpath = "//a[text()=' View']")
	public WebElement customer_page_customerTable_3dotMoreLink_View;

	@FindBy (xpath = "//a[text()=' Delete']")
	public WebElement customer_page_customerTable_3dotMoreLink_Delete;

	@FindBy (xpath = "//p[text()='Customer created successfully']")
	public WebElement customer_page_newCustomer_Success_Message;

	@FindBy (xpath = "(//button[contains(@id, 'headlessui')])[4]")
	public WebElement customer_page_newCustomer_3dotMoreLink;

	@FindBy (xpath = "//button[text()='Ok']")
	public WebElement customer_page_customerTable_3dotMoreLink_Delete_OK_BTN;

	@FindBy (xpath = "//span[text()='Field is required']")
	public WebElement customer_page_newCustomer_FieldIsRequired_Error_Message;
	
	@FindBy (xpath = "(//div[text()='Select Country'])[1]")
	public WebElement customer_page_newCustomer_Billing_CountryField;

	@FindBy (xpath = "(//input[@name='address_name'])[1]")
	public WebElement customer_page_newCustomer_Billing_NameField;

	@FindBy (xpath = "//input[@name='billing.state']")
	public WebElement customer_page_newCustomer_Billing_StateField;

	@FindBy (xpath = "//input[@name=\'billing.city\']")
	public WebElement customer_page_newCustomer_Billing_CityField;

	@FindBy (xpath = "(//input[@name=\"zip\"])[1]")
	public WebElement customer_page_newCustomer_Billing_ZipcodeField;

	@FindBy (xpath = "//button[text()=' Copy from Billing']")
	public WebElement customer_page_newCustomer_CopyFromBillingBTN;

	@FindBy (xpath = "//input[@name='address_name']")
	public WebElement customer_page_newCustomer_Shipping_NameField;

	@FindBy (xpath = "(//input[@type='text']//following-sibling::div[text()='Select Country'])[1]")
	public WebElement customer_page_newCustomer_Billing_CountryDropDown;

	@FindBy (xpath = "(//span[text()='United States'])[1]")
	public WebElement customer_page_newCustomer_Billing_CountryDropDown_UnitedStates;

	@FindBy (xpath = "//h6[text()=' Sales & Expenses']")
	public WebElement customer_page_Sales_and_Expenses_header;

	@FindBy (xpath = "//span[text()='Name must have at least 3 letters.'] | //span[text()='Field is required'] | //span[text()='Incorrect Email.']")
	public List<WebElement> customer_page_NewCustomer_nameEmail_ErrorMessages;
}

