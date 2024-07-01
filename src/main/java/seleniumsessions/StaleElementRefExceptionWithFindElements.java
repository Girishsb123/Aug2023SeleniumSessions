package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionWithFindElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");// DOM v1

		List<WebElement> footerList = driver.findElements(By.cssSelector("div.row ul.list-unstyled a"));//v1

		System.out.println(footerList.size());//v1
		Thread.sleep(2000);

		
		for(int i=0; i<footerList.size(); i++) {
			//v1
			footerList.get(i).click();//v3
			driver.navigate().back();//v3
			Thread.sleep(1500);
			footerList = driver.findElements(By.cssSelector("div.row ul.list-unstyled a"));
		}
		
		
	}


}
