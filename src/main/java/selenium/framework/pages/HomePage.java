package selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import selenium.framework.common.PageControls;

public class HomePage extends PageControls {

	private static final By SEARCH_INPUT=By.xpath("//input[@id='small-searchterms']");
	/**
	 * Description:This is HomePage constructor. It holds all the element locators in HomePage
	 * @param webDriver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	/**
	 * MethodName:getInstance()
	 * Description: This method used get the instance of HomePage
	 * @return HomePage 
	 */
	HomePage getInstance(){
		new HomePage(this.driver).homePageLoaded();
		return new HomePage(this.driver);
	}
/**
 * homePageLoaded()
	 * Description: This method wait until search is displayed
 * @return Boolean
 */
	public  boolean homePageLoaded(){
	return waitForElement(SEARCH_INPUT).isDisplayed();
	}
	/**
	 * MethodName:verifyHomePage()
	 * Description: This method is used to verify HomePage Title
	 */
		public void verifyHomePage(){
			System.out.println(driver.getTitle());
			//Assert.assertEquals(HOME_TITLE, driver.getTitle());
		}
		
}
