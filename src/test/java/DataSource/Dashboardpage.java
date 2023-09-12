package DataSource;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Driver;

public class Dashboardpage {
public Dashboardpage() {
	PageFactory.initElements(Driver.getDriver(),this);
}
@FindBy (linkText = " Dashboard")
public WebElement  dashboard_tab;

@FindBy (xpath =   "//a[text()=' Items']")
public WebElement dash_page_Items_tab;

@FindBy (xpath =   "//a[text()=' Customers']")
public WebElement dash_page_Customers_tab;

@FindBy (xpath =   "//p[text()='Logged in successfully.']")
public WebElement login_page_successfully_massage;

}
