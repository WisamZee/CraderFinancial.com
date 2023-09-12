package DataSource;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Driver;

public class CraterCommonPage {
	public CraterCommonPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	// Header
	
	@FindBy (xpath = "//a[@class='float-none']")
	public WebElement cp_header_Carter_Text;
	
	@FindBy (css = ".flex.items-center.justify-center.text-black")
	public WebElement cp_header_menu_Puls_dropdown;

	@FindBy (linkText =  " New Invoice")
	public WebElement cp_header_menu_button_New_Invoice;
	
	@FindBy (linkText =  "  New Estimate")
	public WebElement cp_header_menu_button_New_Estimate;
	
	@FindBy (linkText =  "  New Customer")
	public WebElement cp_header_menu_button_New_Customer;
	
	@FindBy (xpath = "//input[@fdprocessedid='wuxbjxr']")
	public WebElement cp_header_Search_Box;
	

	@FindBy (xpath = "//div[@class='relative rounded']")
public WebElement cp_header_PrimeTech_Financials;

//	@FindBy (xpath = "//a[@class='float-none']")
//	public WebElement cp_header_profile_btn;

	
	//  Dashboard
	
	@FindBy (xpath = "/a[text()=' Dashboard']")
	public WebElement cp_Side_Bar_Dashboard_Page;
	
	@FindBy (linkText =  " Customers")
	public WebElement cp_Side_Bar_Customers_Page;
	
	@FindBy (linkText =  " Items")
	public WebElement cp_Side_Bar_Items_Page;
	
	@FindBy (linkText =  " Estimates")
	public WebElement cp_Side_Bar_Estimates_Page;
	
	@FindBy (linkText =  " Invoices")
	public WebElement cp_Side_Bar_Invoices_Page;
	
	@FindBy (linkText =  " Recurring Invoices")
	public WebElement cp_Side_Bar_Recurring_Invoices_Page;
	
	@FindBy (linkText =  " Payments")
	public WebElement cp_Side_Bar_Payments_Page;
	
	@FindBy (linkText =  " Expenses")
	public WebElement cp_Side_Bar_Expenses_Page;
	
	@FindBy (linkText =  " Reports")
	public WebElement cp_Side_Bar_Reports_Page;
	
	@FindBy (linkText =  " Settings")
	public WebElement cp_Side_Bar_Settings_Page;
}

