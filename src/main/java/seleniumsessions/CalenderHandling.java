package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandling {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.findElement(By.id("datepicker")).click();

		//selectFutureDate("July 2024", 21);
		selectPreviousDate("March 1994", 27);

	}

	public static void selectFutureDate(String expMonthYear, int day) {

		// leap year:feb:29
		// non leap year:feb:28
		// for 30 days month : check (April,june,sep,nov -- 4 months)
		// ArrayList.contains("Apr") && day>30 -- return;

		if (expMonthYear.contains("February") && day > 29) {
			System.out.println("Wrong day is passed...plz pass the right day/date for feb... " + day);
			return;
		}

		if (day > 31) {
			System.out.println("Wrong day is passed...plz pass the right date... " + day);
			return;
		}

		if (day <= 1) {
			System.out.println("Wrong day is passed...plz pass the right date... " + day);
			return;
		}

		String actMonYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(actMonYear);

		while (!actMonYear.equalsIgnoreCase(expMonthYear)) {
			// click on next
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}

		selectDate(day);

	}

	public static void selectPreviousDate(String expMonthYear, int day) {

		// leap year:feb:29
		// non leap year:feb:28
		// for 30 days month : check (April,june,sep,nov -- 4 months)
		// ArrayList.contains("Apr") && day>30 -- return;

		if (expMonthYear.contains("February") && day > 29) {
			System.out.println("Wrong day is passed...plz pass the right day/date for feb... " + day);
			return;
		}

		if (day > 31) {
			System.out.println("Wrong day is passed...plz pass the right date... " + day);
			return;
		}

		if (day <= 1) {
			System.out.println("Wrong day is passed...plz pass the right date... " + day);
			return;
		}

		String actMonYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		System.out.println(actMonYear);

		while (!actMonYear.equalsIgnoreCase(expMonthYear)) {
			// click on next
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actMonYear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		}

		selectDate(day);

	}

	public static void selectDate(int day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
	}

}
