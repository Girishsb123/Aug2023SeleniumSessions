package Streams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLabsStreams {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> pricesList = driver.findElements(By.cssSelector("div.inventory_item_price"));
		
		//
		//pricesList.stream().forEach(e -> System.out.println(e.getText()));
		
		//$29.99 --> "29.99" --> 29.99
		
//	List<Double> sorted_prices =	pricesList.stream()
//											.map(e -> Double.parseDouble(e.getText().substring(1)))
//													.sorted()
//															.collect(Collectors.toList());
//
//		
//		System.out.println(sorted_prices);
		
		
//		List<Double> sorted_prices_desc =	pricesList.stream()
//												.map(e -> Double.parseDouble(e.getText().substring(1)))
//															.sorted(Comparator.reverseOrder())
//																	.collect(Collectors.toList());
//
//
//				System.out.println(sorted_prices_desc);
		
		
//		double firstPrice = pricesList.stream()
//									.map(e -> Double.parseDouble(e.getText().substring(1)))
//											.findFirst().get();
//		
//		System.out.println(firstPrice);
		
		
//		double lastPrice = pricesList.stream()
//				.map(e -> Double.parseDouble(e.getText().substring(1)))
//						.reduce((first, second) -> second).get();
//
//									System.out.println(lastPrice);
		
		
		
		double maxPrice = pricesList.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
							.max(Double::compareTo).get();
		
		
		System.out.println(maxPrice);
		
		
		double minPrice = pricesList.stream()
				.map(e -> Double.parseDouble(e.getText().substring(1)))
							.min(Double::compareTo).get();
		
		
		System.out.println(minPrice);
		
	}

}
