package seleniumpractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatortype, String locatorvalue) {
		By by = null;

		switch (locatortype) {
		case "id":
			by = By.id(locatorvalue);
			break;
		case "name":
			by = By.name(locatorvalue);
			break;
		case "classname":
			by = By.className(locatorvalue);
			break;
		case "xpath":
			by = By.xpath(locatorvalue);
			break;
		case "cssSelector":
			by = By.cssSelector(locatorvalue);
			break;
		case "linktext":
			by = By.linkText(locatorvalue);
			break;
		case "Partiallinktext":
			by = By.partialLinkText(locatorvalue);
			break;

		default:
			System.out.println("Wrong locatortype is passed : " + locatortype);
			throw new AutomationException("WRONG LOCATORTYPE");
		}

		return by;
	}

	public void doSendkeys(String locatortype, String locatorvalue, String value) {
		getElement(locatortype, locatorvalue).sendKeys(value);
	}

	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(String locatortype, String locatorvalue) {
		getElement(locatortype, locatorvalue).click();
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doElementGetText(String locatortype, String locatorvalue) {
		return getElement(locatortype, locatorvalue).getText();
	}

	public String doGetElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public WebElement getElement(String locatortype, String locatorvalue) {
		return driver.findElement(getBy(locatortype, locatorvalue));
	}

	// WAF : capture the text of all the page links and return List<String>.
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();// pc=0 {}
		for (WebElement e : eleList) {
			String text = e.getText();

			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// WAF: capture specific attribute from the list:
	public List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);

		List<String> eleAttrList = new ArrayList<String>();// pc=0 {}

		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrList.add(attrValue);
		}

		return eleAttrList;

	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void Search(By searchField, By suggestions, String searchKey, String suggName) throws InterruptedException {
		doSendkeys(searchField, searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList = getElements(suggestions);

		System.out.println(suggList.size());

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}

}
