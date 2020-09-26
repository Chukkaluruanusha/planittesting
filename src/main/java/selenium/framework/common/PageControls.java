package selenium.framework.common;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * ClassName:PageControls Description:This class extends WebDriverFactory
 * 
 * 
 *
 */
public class PageControls extends WebDriverFactory {

	/**
	 * Description:This is PageControls constructor. It holds all the element
	 * locators in PageControls
	 */
	protected WebDriver driver;

	public PageControls(WebDriver driver) {
		this.driver = driver;
	}

	

	/**
	 * MethodName:loadUrl() Description:This method used to get the current
	 * webPage url
	 * 
	 * @return String
	 */
	public String getCurrentUrl() {
		System.out.println(getDate()+"- Getting current URL."+" "+driver.toString());
		String tmp = driver.getCurrentUrl();
		System.out.println(getDate()+"- Current Url returned : "+tmp+" "+driver.toString());
		return tmp;
	}
	/**
	 * MethodName:getRowSize() Description:This method used to get Table row size 
	 * @return int
	 */
	public int getElementSize(By by){
		  int elementSize = driver.findElements(by).size();
		return elementSize;	 
		}
	public void selectRequiredItemFromList(By by, String testdata){
		 
		 List<WebElement> items=driver.findElements(by);
			 for(int i=0;i<items.size();i++)
			 {
				String value= items.get(i).getText();
				if(value.equals(testdata))
				{
					items.get(i).click();
				}
			 }
		 }
	 
		


	/**
	 * MethodName:closeBrowser() Description:This method used to close the
	 * Browser
	 */
	public void closeBrowser() {
		String tmp = driver.toString();
		System.out.println(getDate()+"- Closing browser.  Thread ID : "+driver);
		driver.quit();
		System.out.println(getDate()+"- Browser Closed.  Thread ID : "+tmp);
		
	}

	/**
	 * MethodName:click() Description:This method used to click on webElement
	 * 
	 * @param by
	 */
	public void click(By by) {

		System.out.println(getDate()+"- Clicking on "+by.toString()+" - "+driver.toString());
		waitForElement(by).click();
		System.out.println(getDate()+"- Clicked on "+by.toString()+" - "+driver.toString());
	}

	/**
	 * MethodName:getText() Description:This method used to get the current
	 * webElement text
	 * 
	 * @param by
	 * @return String
	 */
	public String getText(By by) {
		System.out.println(getDate()+"- Getting Text from : "+by.toString()+" - "+driver.toString());
		String tmp = waitForElement(by).getText();
		System.out.println(getDate()+"- Got Text from : "+by.toString()+" : "+tmp);
		return tmp;
	}

	

	/**
	 * MethodName:type() Description:This method used to enter text to the input
	 * fields
	 * 
	 * @param by
	 * @param testdata
	 */
	public void type(By by, String testdata) {
		
		
		System.out.println(getDate()+"- Entering Data "+testdata+" on "+by.toString()+" - "+driver.toString());
		waitForElement(by).sendKeys(testdata);
		System.out.println(getDate()+"- Entered Data "+testdata+" on "+by.toString()+" - "+driver.toString());
		
	}

	
	/**
	 * MethodName:clear() Description:This method used to clear text in the
	 * input fields
	 * 
	 * @param by
	 */
	public void clear(By by) {
		System.out.println(getDate()+"- Clearing value from "+by.toString()+" - "+driver.toString());
		waitForElement(by).clear();
		System.out.println(getDate()+"- Cleared value from "+by.toString()+" - "+driver.toString());


	}

	/**
	 * MethodName:moveToElement() Description:This method used to move the
	 * mouseOver to WebElement
	 * 
	 * @param by
	 */
	public void moveToElement(By by) {
		System.out.println(getDate()+"- Moving to Element "+by.toString()+" - "+driver.toString());
		
		WebElement e = driver.findElement(by);
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
		System.out.println(getDate()+"- Moved to Element "+by.toString()+" - "+driver.toString());
		
	}

	/**
	 * MethodName:selectDropdown() Description:This method used select the value
	 * from DropDown
	 * 
	 * @param by
	 * @param testData
	 */
	public void selectDropdown(By by, String testData) {
		System.out.println(getDate()+"- Selecting Dropdown "+by.toString()+" - "+driver.toString());
		Select select = new Select(waitForElement(by));
		try {
			select.selectByVisibleText(testData);
			

		} catch (Exception e) {

			select.selectByValue(testData);
		}
		System.out.println(getDate()+"- Selected Dropdown "+by.toString()+" - "+driver.toString());
	}

	

	

	public void pause(int i) {

		try {
			System.out.println(getDate()+"- Pausing Execution for "+i+" MS - "+driver.toString());
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	

	/**
	 * MethodName:waitForElement() Description:This method wait for required
	 * WebElement
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement waitForElement(By by) throws NoSuchElementException {
		System.out.println(getDate()+" Waiting for Element to Load "+by.toString()+" - "+driver.toString());

		for (int i = 1; i < 50; i++) {
			try {
				this.driver.findElement(by).isDisplayed();
				this.driver.findElement(by).isEnabled();
				System.out.println(getDate()+" Element Found "+by.toString()+" - "+driver.toString());
				
				return this.driver.findElement(by);
			} catch (Exception e) {
				System.out.println(getDate()+" Wait for Element Exception "+e.getLocalizedMessage()+" - "+driver.toString());
				System.out.println(getDate()+" Element Not Found Waiting.");
				pause(300);
			}

		}
		System.out.println(getDate()+"- Element not found after waiting "+by.toString()+" - "+driver.toString());
		return this.driver.findElement(by);

	}


	public void waitForPageToLoad(By by, boolean flag) {
		System.out.println(getDate()+" Waiting for Page to Load.  "+by.toString()+" - "+driver.toString());
		if (flag) {
			for (int i = 1; i < 100; i++) {
				try {
					driver.findElement(by).isDisplayed();
					Thread.sleep(10);
				} catch (Exception e) {
					break;
				}
			}
		}
	}

	
	
	private Date getDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	
}