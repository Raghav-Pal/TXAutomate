package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class AutomationHomePage extends BaseClass{

	public AutomationHomePage(WebDriver driver){
		super(driver);
	}    

	@FindBy(how=How.XPATH, using="//a[@class='login']")
	public static WebElement sign_in;

	@FindBy(how=How.LINK_TEXT, using="Contact us")
	public static WebElement contact_us;

	@FindBy(how=How.XPATH, using="//a[@class='logout'][contains(.,'Sign out')]")
	public static WebElement sign_out;


	@FindBy(how=How.XPATH, using="//input[@id='search_query_top']")
	public static WebElement search_box;


	@FindBy(how=How.XPATH, using="//button[contains(.,'Search')]")
	public static WebElement search_icon;

	@FindBy(how=How.XPATH, using="//p[contains(.,'No results were found for your search')]")
	public static WebElement no_search;

	public static class HeaderPage 
	{
		@FindBy(how=How.LINK_TEXT, using="Women")
		public static WebElement menu_women;

		@FindBy(how=How.XPATH, using="//*a[@title='Dresses']")
		public static WebElement menu_dresses;

		@FindBy(how=How.XPATH, using="//*a[@title='T-shirts']")
		public static WebElement menu_tshirts;


		public static class DressesPage
		{
			@FindBy(how=How.XPATH, using="//*a[@title='Summer Dresses']")
			public static WebElement summer_dresses;

		}

	}

}


















