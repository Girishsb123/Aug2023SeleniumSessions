package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Attributeconcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		By eId = By.id("email");
		By signUpLink = By.linkText("Sign up for Facebook");
		
		String palceholderVal = driver.findElement(eId).getAttribute("placeholder");
		System.out.println(palceholderVal);
		
		String hrefVal = driver.findElement(signUpLink).getAttribute("href");
		System.out.println(hrefVal);
		
	}
	
	
}