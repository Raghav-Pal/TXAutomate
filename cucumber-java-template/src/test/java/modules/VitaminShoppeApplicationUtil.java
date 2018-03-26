package modules;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class VitaminShoppeApplicationUtil {

	/** The address. */
	static By shopByDeptTab = By.partialLinkText("SHOP BY DEPARTMENT");

	static By homeAndLifestyleLink = By.xpath("//li[@id='leftNavShop8']/a[contains(text(), 'Home & Lifestyle')]");

	static By himalayanSaltLampsLink = By.xpath("//div[@class='category-item']/a[contains(text(), 'Himalayan Salt Lamps')]");

	//static By himalayanSaltLampsProduct = By.xpath("//div[@class='product-info hidden-xs hidden-sm']//span[contains(text(), 'Himalayan Natural Salt Lamp (1 Lamp) ')]/../..");
	//static By himalayanSaltLampsProduct = By.xpath("(//span[contains(text(), 'Himalayan Natural Salt Lamp (1 Lamp) ')])[1]");
	static By himalayanSaltLampsProduct = By.xpath("//*[@id='product1']/div/div[1]/a/div[1]/vshoppe-lazy-load/img");

	
	
	static By noThanks = By.xpath("//a[@title='No, thanks']");

	static By stayInDark = By.partialLinkText("No thanks, I prefer to stay in the dark.");
		
	static By shiptToHome = By.xpath("//label [text() = 'SHIP TO HOME']");

	//static By addToCartButton = By.xpath("(//div[@class='clearfix']//button[text()='ADD TO CART'])[1]");
	
	static By addToCartButton = By.xpath("//*[@id='product1']/div/div[4]/div/a/span");
	
	
	//static By cartBtnPopUp = By.xpath("//button[@class='cartbtn' and text()='View Cart & Check Out']");
	static By cartBtnPopUp = By.xpath("(//button[text()='View Cart & Check Out'])[2]");
		
	static By checkOutNow = By.xpath("(//input[@type='submit' and @value='Check Out Now'])[1]");

	//Sign In section	
	static By emailField = By.xpath("//input[@id='vs_registerLoginEmailAddress' and @type='email']");
		
	//static By checkOutAsAGuest = By.xpath("//input[@id='account-guest' and @type='radio']");
		
	static By continueBtn = By.xpath("//input[@id='guest-checkout-submit']");
		
	//Shipping Information 
	static By firstNameTxtBox = By.xpath("//input[@id='atg_store_firstNameInput' and @type='text']");
		
	static By lastNameTxtBox = By.xpath("//input[@id='atg_store_lastNameInput' and @type='text']");

	static By streetAddress = By.xpath("//input[@id='atg_store_streetAddressInput' and @type='text']");

	static By cityTxtBox = By.xpath("//input[@id='atg_store_localityInput' and @type='text']");

	static By stateProvince = By.xpath("//input[@id='atg_store_stateSelect' and @type='text']");	

	static By postalCode = By.xpath("//input[@id='atg_store_postalCodeInput' and @type='text']");
	
	static By phoneTxtBox = By.xpath("(//input[@id='atg_store_telephoneInput'])[2]");
	
	static By continueShipping = By.xpath("//input[@type='submit' and @value='Continue']");

	static By freeShippingOption = By.xpath("//input[@id='atg_store_shipping1' and @type='radio']");
	
	//Card details
	static By cardNumber = By.xpath("//input[@data-label='Card Number' and @inputmode='numeric' and @autocomplete='cc-number']");
	
	static By cardHolderName = By.xpath("//input[@id='gatewayCardHolderName']");

	static By expiryYearSelectBox = By.xpath("//span[@id='expiryYearSelectBoxItText']");
	
	static By year2018 = By.linkText("2018");
	
	static By securityCode = By.xpath("//input[@id='securityCode']");
	
	static By submitOrder = By.xpath("//input[@id='orderConfirmationButton' and @value='Submit Order']");
	
	static By orderPlacedText = By.xpath("//div[contains(@class,'title big-title')]");

	//	
	//	static By  = By.xpath("");
	//	
	//	static By  = By.xpath("");
	//	
	//	static By  = By.xpath("");
	//	
	//	static By  = By.xpath("");


	public static void selectCategory() throws Throwable {
		try {
			Thread.sleep(5000);
			if(KeywordUtil.isWebElementPresent(noThanks))
				KeywordUtil.click(noThanks);
			KeywordUtil.click(shopByDeptTab);
			Thread.sleep(1000);
			if(KeywordUtil.isWebElementPresent(noThanks))
				KeywordUtil.click(noThanks);
			KeywordUtil.hoverOnElement(homeAndLifestyleLink);
			Thread.sleep(1000);
			if(KeywordUtil.isWebElementPresent(noThanks))
				KeywordUtil.click(noThanks);
			KeywordUtil.click(himalayanSaltLampsLink);
			Thread.sleep(2000);
			if(KeywordUtil.isWebElementPresent(stayInDark))
				KeywordUtil.click(stayInDark);
			if(KeywordUtil.isWebElementPresent(noThanks))
				KeywordUtil.click(noThanks);
//			KeywordUtil.click(himalayanSaltLampsProduct);
//			Thread.sleep(1000);
//			if(KeywordUtil.isWebElementPresent(noThanks))
//				KeywordUtil.click(noThanks);


		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

//	public static void selectProduct() throws Throwable {
//		try {
//			Thread.sleep(2000);
//			KeywordUtil.click(himalayanSaltLampsProduct);
//		} catch (Exception e) {
//			GlobalUtil.ErrorMsg = e.getMessage();
//			Assert.fail(e.getMessage());
//		}
//	}

	public static void clickAddToCart() throws Throwable {
		try {
			Thread.sleep(5000);
			//KeywordUtil.click(addToCartButton);
			KeywordUtil.click(cartBtnPopUp);

		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void checkOutNow() throws Throwable {
		try {
			Thread.sleep(2000);
			KeywordUtil.click(checkOutNow);

		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void fillDetailsInSignInSection() throws Throwable {
		try {
			Thread.sleep(2000);
			KeywordUtil.inputText(emailField, "test.Acct@yopmail.com");
			//KeywordUtil.click(checkOutAsAGuest);
			KeywordUtil.click(continueBtn);
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void fillDetailsInShippingInfo() throws Throwable {
		try {
			Thread.sleep(2000);
			KeywordUtil.inputText(firstNameTxtBox, "test");
			KeywordUtil.inputText(lastNameTxtBox, "Acct");
			KeywordUtil.inputText(streetAddress, "225 N Clinton Ave");
			KeywordUtil.inputText(cityTxtBox, "Trenton");
			KeywordUtil.inputText(stateProvince, "NJ");
			KeywordUtil.inputText(postalCode, "08609");
			KeywordUtil.inputText(phoneTxtBox, "9876543210");
			KeywordUtil.click(continueShipping);
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void verifyAddressDetailsPopup() throws Throwable {
		try {
			//
			//
			//
			//
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void chooseShippingOption() throws Throwable {
		try {
			Thread.sleep(2000);
			//KeywordUtil.click(freeShippingOption);
			KeywordUtil.click(continueShipping);
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void enterCardDetails() throws Throwable {
		try {
			Thread.sleep(2000);
			KeywordUtil.inputText(cardNumber, "4112344112344113");
			KeywordUtil.inputText(cardHolderName, "Test");
			KeywordUtil.click(expiryYearSelectBox);
			KeywordUtil.click(year2018);
			KeywordUtil.inputText(securityCode, "123");
			KeywordUtil.click(continueShipping);
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	public static void submitOrder() throws Throwable {
		try {
			Thread.sleep(2000);
			KeywordUtil.click(submitOrder);
			
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}
	
	public static void orderPlacedConfirm() throws Throwable {
		try {
			Thread.sleep(30000);
//			String actual = GlobalUtil.getDriver().findElement(orderPlacedText).getText();
//			String expected = "Your order has been placed!";
//			assertTrue(actual.contains(expected));
			
		} catch (Exception e) {
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}


}
