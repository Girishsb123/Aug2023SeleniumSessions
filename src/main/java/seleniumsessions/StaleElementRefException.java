package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefException {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//DOM v1
		
		WebElement emailId = driver.findElement(By.id("input-email"));//DOM v1
		
		emailId.sendKeys("naveen@gmail.com");//DOM v1
		
		//driver.navigate().refresh(); //DOM v2 --- new DOM
		//back/fwd
		//click on link/element
		//page is loaded/refreshed 
		
		
		driver.findElement(By.linkText("Register")).click();
		
		driver.navigate().back();//back to login page
		
		emailId = driver.findElement(By.id("input-email"));//DOM v2
		
		emailId.sendKeys("tom@gmail.com");//e1(v2) --> DOM v2

		//1. Reinitialize the web element
		//2. use By locator approach -- avoid WebElement approach
		//3. Explicit Wait with FluentWait -- Ignore Exception - StaleElementRefException
		
		
	}


}
