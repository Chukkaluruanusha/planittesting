package planit.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.framework.common.CommonMethods;
import selenium.framework.common.WebDriverManager;
import selenium.framework.pages.BooksCategoryPage;
import selenium.framework.pages.HomePage;
import selenium.framework.pages.LoginPage;
import selenium.framework.pages.ShoppingCartPage;


public class TS_01_ItemBooking extends CommonMethods{
	WebDriver driver;
	
	HomePage homePage = null;
	LoginPage loginPage = null;
	BooksCategoryPage bookpage=null;

	@Test(priority=0,description="This testcase is related to product booking")
	public void TC_01_ValidateCreatingProgramWithAllFields(){
		
		loginPage.verifyAccountID();
		ShoppingCartPage cartPage =new ShoppingCartPage(driver);
		cartPage.clearShoppingCart();
		bookpage=new BooksCategoryPage(driver);
		bookpage.clickOnBooksCategory();
		bookpage.selectBook();
		bookpage.getPrice();
		bookpage.enterQuantity();
		bookpage.clickOnAddToCart();
		bookpage.verifySuccessMsg();
		bookpage.clickOnShoppingCart();
		bookpage.getSubTotal();
		bookpage.clickOnAcceptence();
		bookpage.clickOnCheckout();

}
	@BeforeClass
	public void beforeClass() {
		driver =  WebDriverManager.getWebDriver();
		loginPage = new LoginPage(driver);
		loginPage.homePageLoaded();
	
			}

	@AfterClass(alwaysRun=true)
	public void afterClass(){
		closeBrowser();
	}


	@BeforeMethod
	public void beforeMethod() {
		loginPage.clickOnLogin();
		loginPage.verifyWelcomeText();
		loginPage.login();
	}
	@AfterMethod
	public void afterMethod() {
	}
}
