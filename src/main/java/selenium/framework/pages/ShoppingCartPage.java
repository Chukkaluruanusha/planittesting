package selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import selenium.framework.common.PageControls;

public class ShoppingCartPage extends PageControls{
	
	private static final By SHOPPING_CART= By.xpath("//li[@id='topcartlink']/a");
	private static final By CART_ITEMS=By.xpath("//a[@class='items']");
	private static final By QUANTITY=By.xpath("//input[@class='qty-input']");
	private static final By UPDATE_SHOPPING_CART_BUTTON=By.xpath("//input[@name='updatecart']");
	private static final By CART_QUANTITY=By.xpath("//span[@class='cart-qty']");
	private static final By SHOPPING_CART_SUMMARY=By.xpath("//div[@class='order-summary-content']");
	private static final By EMPTY_CART=By.xpath("//div[@class='count']");
	private static final By NON_EMPTY_CART=By.xpath("//input[@value='Go to cart']");
	
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);	
	}
	public void clearShoppingCart()
	{		moveToElement(SHOPPING_CART);
	int sizeOfElement=getElementSize(NON_EMPTY_CART);
	if(sizeOfElement>0)
	{
		click(SHOPPING_CART);
		clear(QUANTITY);
		type(QUANTITY,"0");
		click(UPDATE_SHOPPING_CART_BUTTON);
		String expectedSummary="Your Shopping Cart is empty!";
		String actualSummary=getText(SHOPPING_CART_SUMMARY);
		if(actualSummary.contains(expectedSummary))
		{
			System.out.println("Cart is empty now");
		}
	}
	else
	{
		System.out.println("Cart is already empty");
	}
	
		
	}
	
	
	}

