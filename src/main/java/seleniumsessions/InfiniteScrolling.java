package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfiniteScrolling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
        WebDriver driver = new ChromeDriver();

        driver.get("https://scrollmagic.io/examples/advanced/infinite_scrolling.html");

		
		try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
			long lastHeight = (long) js.executeScript("return document.body.scrollHeight");//200

			while (true) {
				
				List<WebElement> boxesList = driver.findElements(By.cssSelector("div#content div.box1"));
				
				for(WebElement e : boxesList) {
					String color = e.getCssValue("background-color");
					System.out.println(color);
				}
				
				// Scroll down to the bottom of the page
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

				Thread.sleep(2000);

				// Calculate new scroll height and compare with last scroll height
				long newHeight = (long) js.executeScript("return document.body.scrollHeight");//400
				if (newHeight == lastHeight) {
					// Break the loop if the bottom of the page is reached
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}


}
