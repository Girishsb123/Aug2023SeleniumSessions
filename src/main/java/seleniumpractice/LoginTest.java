package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// By locator -> String locator
		String email_id = "email";
		String pass_id = "pass";
		String loginBtn_xpath = "//*[@id=\"loginbutton\"]";

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendkeys("id", "email_Id", "tom123@gmail.com");
		eleUtil.doSendkeys("id", "pass_Id", "test@123");
		eleUtil.doClick("xpath", loginBtn_xpath);

	}

}
