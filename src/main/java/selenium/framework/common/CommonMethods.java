package selenium.framework.common;



public class CommonMethods{
	
	
public void closeBrowser() {
		WebDriverManager.removeWebDriver();
	}

	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
