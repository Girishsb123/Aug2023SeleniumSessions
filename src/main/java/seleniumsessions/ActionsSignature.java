package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsSignature {
	
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://signature-generator.com/draw-signature/");
		
		WebElement canvas = driver.findElement(By.id("signature-pad"));
		
		Actions act = new Actions(driver);
		
		Action signature = act.click(canvas)
		        .moveToElement(canvas, 50, 80)
		        .clickAndHold(canvas)
		        .moveToElement(canvas, -300, -80)
		        .moveByOffset(40, 40)
	            .moveByOffset(50, 50)
	            .moveByOffset(67, 30)
	            .release(canvas)
	            .build();
		
		signature.perform();
	}

}
