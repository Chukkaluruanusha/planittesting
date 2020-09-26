package selenium.framework.common;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverFactory {

	public static Properties CONFIG = null;
	public static URL remoteAddress;
	private static String browser, url;
	
	static WebDriver createInstance() {
		   WebDriver driver = null;
			
        CONFIG = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			CONFIG.load(fs);
			if(CONFIG.getProperty("remoteAddress") != null){
			remoteAddress = new URL(CONFIG.getProperty("remoteAddress"));
			}
		
			browser = CONFIG.getProperty("browser");
			url = CONFIG.getProperty("url");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	//	System.out.println(browser);
		if (browser.equals("chrome")) {
			driver = getChromeDriver();
		}
		else if (browser.equals("firefox")) {
			
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
    }

	/**
	 * Create an instance of ChromeDriver
	 * 
	 * @return
	 */
	private static WebDriver getChromeDriver() {
		System.out.println("Launching Chrome Driver.");
		if (remoteAddress != null) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			return new RemoteWebDriver(remoteAddress, capabilities);
		} else {
			Map<String, Object> prefs = new HashMap<String, Object>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("prefs", prefs);
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			return new ChromeDriver(options);
		}
	}	
}
