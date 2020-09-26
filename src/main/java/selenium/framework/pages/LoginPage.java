package selenium.framework.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import selenium.framework.common.PageControls;

public class LoginPage extends PageControls {
	
	
	public static final String username = "atest@gmail.com";
	public static final String password = "123456";
	
	

	private static final By SEARCH_INPUT=By.xpath("//input[@id='small-searchterms']");
	private static final By LOGIN = By.xpath("//a[@class='ico-login']");
	private static final By WELCOME_MSG= By.xpath("//div[@class='page-title']/h1");
	private static final By EMAID_INPUT = By.xpath("//input[@id='Email']");
	private static final By PASSWORD_INPUT = By.xpath("//input[@id='Password']");
	private static final By LOGIN_BUTTON = By.xpath("//input[contains(@class, 'login')]");
	private static final By EMAIL_ID=By.xpath("//div[@class='header-links']/ul/li/a");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	/**
	 * homePageLoaded()
		 * Description: This method wait until search is displayed
	 * @return Boolean
	 */
		public  boolean homePageLoaded(){
			System.out.println("Page loaded successfully after passing URL");
		return waitForElement(SEARCH_INPUT).isDisplayed();
		
		}
		
			public void clickOnLogin(){
				System.out.println("Page loaded successfully after passing URL");
				click(LOGIN); 
				
			}
			public void verifyWelcomeText(){
				System.out.println(getText(WELCOME_MSG));
				String expected_WelcomeText="Welcome, Please Sign In!";
				String actual_WelcomeText=getText(WELCOME_MSG);
				System.out.println(expected_WelcomeText);
				System.out.println(actual_WelcomeText);
				if(expected_WelcomeText.equals(actual_WelcomeText))
				{
					System.out.println("Welcome text matching as expected");
				}
				else
				{
					System.out.println("Welcome text is not matching as expected");
				}
				//Assert.assertEquals(expected_WelcomeText,actual_WelcomeText,"Welcome text is not matching as expected");
				
			}
			
	public void login(){
		type(EMAID_INPUT, username);
		type(PASSWORD_INPUT, password);
		click(LOGIN_BUTTON); 
		//return new HomePage(driver).getInstance();
	}
	public void verifyAccountID(){
		//System.out.println(getText(EMAIL_ID));
		if(username.equals(getText(EMAIL_ID)))
		{
			System.out.println("Account id is matching as expected :"+ username);
		}
		else
		{
			System.out.println("Account id is not matching as expected");
		}
	//	Assert.assertEquals(username, getText(EMAIL_ID),"Logged in id is not matching as expected");
		
	}

	public void clickOnShoppingCart(){
		System.out.println("Page loaded successfully after passing URL");
		click(LOGIN); 
		
	}
	
}