package modules;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

public class BarneyApplicationFunctions {

	static Class thisClass = BarneyApplicationFunctions.class;
	static List<WebElement> webElementsList;
	static String refernceNumber;
	static String statusOfAuthorization;

	// Login
	static final String expectedLoginPageText = "LOG IN TO YOUR ACCOUNT";
	static final String expectedloginUsername = "SCHAUHAN";
	// final String expectedloginUsername = "DAMCOTESTUSER";
	static String shoeAddedInCartName = null;
	static final String emptyCartMessage = "Your shopping bag is empty.";

	// Loading Icon
	static final By LoadingIcon = By
			.xpath(".//div[contains(@id,'main-container')]//div[contains(@class,'loader-indicator')]");

	// To be put in code Feedback Popup
	public static final By FeedbackPopup = By.xpath(".//div[@id='fsrOverlay']//div[contains(@class,'fsrFloatingMid')]");
	public static final By NoThanksOnFeedbackPopup = By
			.xpath(".//div[@id='fsrOverlay']//a[contains(text(),'No, thanks')]");

	// Login Scenario Locators
	public static final By LoginHeaderLink = By.xpath("//div[@id='customerInfo']//a[text()='Log In']");
	public static final By LoginVerification = By.xpath(".//div[@id='atg_store_registerIntro']/h1");
	public static final By UserName = By.id("atg_store_registerLoginEmailAddress");
	public static final By Password = By.id("atg_store_registerLoginPassword");
	public static final By Loginbutton = By.xpath("//span[@class='atg_store_basicButton atg_store_chevron']");
	public static final By LoginText = By
			.xpath(".//div[@id='customerInfo']//span[@class='atg_store_loggedInUserName']");

	// Category Scenario Selection
	public static final By Men = By.xpath("//ul[contains(@id,'topnav')]/li/a[contains(.,'Men')]");
	public static final By Shoes = By.xpath(".//ul[contains(@id,'category-level-1')]//a[contains(text(),'Shoes')]");
	public static final By Boots = By.xpath(".//*[contains(@id,'category-level-1')]//a[contains(text(),'Boots')]");

	// Product Scenario Selection
	public static final By SelectShoe = By
			.xpath(".//*[@id='atg_store_prodList']//a[contains(text(),'Santiag Leather Harness Boots')]");

	// Size Scenario Selection
	public static final By SizeSelector = By.xpath(".//div[@id='atg_store_picker']//a[contains(text(),'7 M')]");

	// Quantity Adjustment
	public static final By QuantityBox = By.id("qty_input_id");

	// Add them in Basket scenario
	public static final By AddToBagButton = By.xpath("//input[contains(@value,'add to bag')]");
	public static final By PreOrderButton = By.xpath("//input[contains(@value,'Pre-Order')]");

	// Mini cart that pops up after clicking on Add to Bag
	public static final By MiniCartPopup = By
			.xpath("//footer/div[contains(@style,'display: block;') and contains(@class,'popup mini-cart')]");
	public static final By CartItemsCountInMiniCart = By
			.xpath(".//footer[contains(@id,'footer')]//span[contains(@class,'mini-cart-count')]");
	public static final By ItemInCartName = By.xpath(
			".//table[contains(@id,'atg_store_itemTable')]//div[contains(@class,'itemProperty')]/a[contains(text(),'Santiag Leather Harness Boots')]");
	public static final By CheckoutButton = By.xpath(".//footer[@id='footer']//a[contains(text(),'Checkout')]");

	// Remove item from Cart
	public static final By RemoveItemfromCartAfterClickingCheckOut = By.xpath(
			".//table[contains(@id,'atg_store_itemTable')]//div[contains(@class,'hidden-xs')]//a[contains(text(),'Remove')]");

	// Empty cart text
	public static final By EmptyCartTextAfterClickngRemove = By.xpath(
			".//div[contains(@id,'atg_store_shoppingCart')]/div[contains(@class,'atg_store_generalMessag')]/h3[contains(text(),'Your shopping bag is empty.')]");

	// Log Out Locators
	public static final By UserMenu = By.xpath("//*[@id='customerInfo']/ul[1]/li/span");
	public static final By LogOut = By.xpath("//li[@class='last']/a");

	public static void login(String sUserName, String sPassword) throws InterruptedException {

		// Login
		KeywordUtil.click(LoginHeaderLink);
		KeywordUtil.waitForClickable(UserName);
		assertEquals(GlobalUtil.getDriver().findElement(LoginVerification).getText(), expectedLoginPageText);
		KeywordUtil.inputText(UserName, sUserName);
		KeywordUtil.inputText(Password, sPassword);
		KeywordUtil.click(Loginbutton);
		LogUtil.infoLog(thisClass, "Schauhan logged in Successfully");
	}

	public static void menCategorySelection() throws InterruptedException {

		// Category Selection
		// Thread.sleep(10000);
		KeywordUtil.waitForClickable(LoginText);
		assertEquals(GlobalUtil.getDriver().findElement(LoginText).getText(), expectedloginUsername);
		KeywordUtil.click(Men);
		KeywordUtil.waitForClickable(Shoes);
		KeywordUtil.click(Shoes);
		KeywordUtil.waitForClickable(Boots);
		KeywordUtil.click(Boots);
		LogUtil.infoLog(thisClass, "Category Selection");
	}

	public static void productAndSizeSelection() {

		// Shoe and Size Selection
		KeywordUtil.waitForClickable(SelectShoe);
		shoeAddedInCartName = GlobalUtil.getDriver().findElement(SelectShoe).getText();
		KeywordUtil.click(SelectShoe);
		KeywordUtil.waitForClickable(SizeSelector);
		KeywordUtil.click(SizeSelector);
		// KeywordUtil.waitForClickable(SelectShoe);
		// shoeAddedInCartName =
		// GlobalUtil.getDriver().findElement(SelectShoe).getText();
		// KeywordUtil.click(SelectShoe);
		// KeywordUtil.waitForClickable(SizeSelector);
		// KeywordUtil.click(SizeSelector);
		LogUtil.infoLog(thisClass, "Product Selection");
	}

	public static void quantityAdjustment(String sQuantity) {

		// Clear and Enter quantity
		KeywordUtil.waitForClickable(QuantityBox);
		KeywordUtil.clearInput(QuantityBox);
		KeywordUtil.inputText(QuantityBox, sQuantity);
		LogUtil.infoLog(thisClass, "Quantity Adjustment");
	}

	public static void addToCart() throws InterruptedException {
		// Add to bag
		// Thread.sleep(5000);
		KeywordUtil.waitForInVisibile(LoadingIcon);
		KeywordUtil.waitForClickable(AddToBagButton);
		// KeywordUtil.waitForVisible(AddToBagButton);
		KeywordUtil.click(AddToBagButton);
		LogUtil.infoLog(thisClass, "Add to Cart");

		//KeywordUtil.waitForInVisibile(MiniCartPopup);
		Thread.sleep(6000);
		
		KeywordUtil.waitForClickable(CheckoutButton);
		KeywordUtil.click(CheckoutButton);

		Thread.sleep(10000);
		
		// Verify added to cart
		KeywordUtil.waitForClickable(ItemInCartName);
		assertEquals(GlobalUtil.getDriver().findElement(ItemInCartName).getText(), shoeAddedInCartName);

		KeywordUtil.click(RemoveItemfromCartAfterClickingCheckOut);
		assertEquals(GlobalUtil.getDriver().findElement(EmptyCartTextAfterClickngRemove).getText(), emptyCartMessage);
		LogUtil.infoLog(thisClass, "All items removed from Cart");
	}

	public static void logout() {
		// Logout
		KeywordUtil.click(UserMenu);
		KeywordUtil.click(LogOut);
		LogUtil.infoLog(thisClass, "Schauhan logged out Successfully");
	}

}
