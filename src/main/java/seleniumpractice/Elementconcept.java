package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elementconcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//driver.get("https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjk3OTQyNDY4LCJjYWxsc2l0ZV9pZCI6MjY5NTQ4NDUzMDcyMDk1MX0%3D");

		// By locator + generic method

		By eId = By.id("email");
		By pwd = By.id("pass");
		By loginBtn = By.xpath("//*[@id=\"loginbutton\"]");

		// By locator -> String locator
		String email = "email";
		String pass = "pass";

		//linttext
		By text = By.linkText("Sign up for Facebook");
		String textLink = doElementGetText(text);
		if(textLink.equals("Sign up for Facebook")) {
			System.out.println("text is correct -- Pass");
			doClick(text);
		}else {
			System.out.println("Fail");
		}
		
//		getElement(eId).sendKeys("tom123@gmail.com");
//		getElement(pwd).sendKeys("test@123");

//		doSendkeys(eId, "tom123@gmail.com");
//		doSendkeys(pwd, "test@123");
//		doClick(loginBtn);

//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendkeys("id", "email", "tom123@gmail.com");
//		eleUtil.doSendkeys("id", "pwd", "test@123");

	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
