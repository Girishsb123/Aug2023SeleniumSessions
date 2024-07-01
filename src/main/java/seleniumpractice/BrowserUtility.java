package seleniumpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author HP this BrowserUtility class contains generic methods used to handle
 *         various browser actions
 */
public class BrowserUtility {

	private WebDriver driver;

	/**
	 * @author Girish this method is used to launch the browser on the basis of
	 *         given browserName
	 * 
	 * @param browserName
	 * @return this returns driver instance
	 */

	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser name  : " + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Pla pass the right browser...." + browserName);
			throw new AutomationException("INVALID BROWSER : " + browserName);
		}

		return driver;
	}

	/**
	 * @author Girish this method is used to launch url
	 * @param url
	 */

	public void launchURL(String url) {
		if (url == null) {
			System.out.println("URL IS NULL");
			throw new AutomationException("NULL URL");
		}

		// https://www.facebook.com
		if (url.indexOf("http") == 0) {
			driver.get(url);
		} else {
			throw new AutomationException("HTTP IS MISSING");
		}
	}

	/**
	 * @author Girish this method is used to get the page title
	 * @return this returns page title
	 */

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		return title;
	}

	/**
	 * @author Girish this method returns boolean value
	 * @return
	 */
	public boolean getPageURL() {
		String url = driver.getCurrentUrl();
		if (url.contains("facebook")) {
			return true;
		}
		return false;
	}

	/**
	 * @author Girish this method is used to get page source
	 * @return
	 */

	public String getPageSource() {
		String value = driver.getPageSource();
		if (value.contains("facebook")) {
			System.out.println("value is there -- PASS");
		} else {
			System.out.println("value is not there -- FAIL");
		}

		return value;
	}

	/**
	 * @author Girish this method is used to close the current browser
	 */

	public void close() {
		driver.close();
		System.out.println("browser is closed");
	}

	/**
	 * @author Girish this method is used to close all the active browser instances
	 */

	public void quit() {
		driver.quit();
		System.out.println("browser is closed");

	}

}
