package selenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.framework.common.PageControls;

public class BooksCategoryPage extends PageControls{
	private static final By BOOKS=By.xpath("//div[@class='header-menu']/ul[@class='top-menu']/li[1]/a");
	private static final By PRODUCT_ITEMS=By.xpath("//div[@class='product-grid']/div");
	private static final By GET_ADDTOCART_TEXT=By.xpath("//div[@class='product-grid']/div/div/div[2]/div[@class='add-info']/div[2]");
	private static final By PRODUCT_PRICE=By.xpath("//span[@itemprop='price']");
	private static final By QUANTITY_INPUT=By.xpath("//input[@class='qty-input']");
	private static final By ADDTOCART=By.xpath("//input[contains(@id, 'add-to-cart-button')]");
	private static final By SUCCESS_MSG=By.xpath("//div[@class='bar-notification success']");
	private static final By SUB_TOTAL=By.xpath("(//span[@class='product-price'])[1]");
	private static final By ACCEPT_CHECKBOX=By.xpath("//input[@id='termsofservice']");
	private static final By CHECKOUT=By.xpath("//button[@id='checkout']");
	private static final By SHOPPING_CART= By.xpath("//li[@id='topcartlink']/a");
	private static final By BILLING_ADDRESS=By.xpath("//select[@id='billing-address-select']");
	private static final By FIRSTNAME=By.xpath("//input[@id='BillingNewAddress_FirstName']");
	private static final By LASTNAME=By.xpath("//input[@id='BillingNewAddress_LastName']");
	private static final By EMAIL=By.xpath("//input[@id='BillingNewAddress_Email']");
	private static final By COUNTRY=By.xpath("//select[@id='BillingNewAddress_CountryId']");
	private static final By CITY=By.xpath("//input[@id='BillingNewAddress_City']");
	private static final By ADDRESS1=By.xpath("(//input[contains(@id, 'BillingNewAddress_Address')])[1]");
	private static final By POSTAL=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	private static final By PHONENUMBER=By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	private static final By CONTINUE=By.xpath("//div[@id='billing-buttons-container']/input");
	public BooksCategoryPage(WebDriver driver) {
		super(driver);
		
	}
public void clickOnBooksCategory()
{
	click(BOOKS);
}
public void selectBook()
{
	List<WebElement> products=driver.findElements(PRODUCT_ITEMS);
	for(int i=1;i<=products.size();i++)
	{
		driver.findElement(By.xpath("(//input[@value='Add to cart']/parent::div/parent::div/parent::div/parent::div//div[@class='picture'])["+i+"]")).click();
		break;
	}
}
public String getPrice()
{
	String price=getText(PRODUCT_PRICE);
	//System.out.println(price);
	
	//int priceAmt=Integer.parseInt(price); 
	//System.out.println(price);
	return price;
}
public void enterQuantity()
{
	clear(QUANTITY_INPUT);
	type(QUANTITY_INPUT, "3");
}
public void clickOnAddToCart()
{
	click(ADDTOCART);
}
public void verifySuccessMsg()
{
	getText(SUCCESS_MSG);
}
public String getSubTotal()
{
	String subTotal=getText(SUB_TOTAL);
	
	return subTotal;
}
public void verifyTotal()
{
	String[] priceAmt=getPrice().split(".");
	String priceAmt1=priceAmt.toString().substring(0);
	System.out.println(priceAmt1.trim());
	int priceAmount=Integer.valueOf(priceAmt1);
	System.out.println(priceAmount);
	int expectedTotal=priceAmount*3;
	String  actualSubTotal=getSubTotal().substring(0);
	int subTotal=Integer.parseInt(actualSubTotal);
	System.out.println(subTotal);
	if(expectedTotal==subTotal)
	{
		System.out.println("Sub total matching");
	}
	else
	{
		System.out.println("Sub total not matching, there may be added few more books by others");
	}
}
public void clickOnAcceptence()
{
	click(ACCEPT_CHECKBOX);
}
public void clickOnCheckout()
{
	click(CHECKOUT);
}
public void clickOnShoppingCart()
{
	click(SHOPPING_CART);
}
public void selectBillingAddress()
{
	selectDropdown(BILLING_ADDRESS, "New Address");
}
}
