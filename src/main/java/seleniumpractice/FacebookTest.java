package seleniumpractice;

public class FacebookTest extends BrowserUtility{ 

	public static void main(String[] args) {

		FacebookTest fb = new FacebookTest();
		fb.launchBrowser("Chrome");
		// fb.driver.close();

		fb.launchURL("https://www.facebook.com/");

		String actTitle = fb.getPageTitle();
		if (actTitle.equals("Facebook – log in or sign up")) {
			System.out.println("title is correct -- PASS");
		} else {
			System.out.println("title is incorrect -- FAIL");
		}

		boolean b = fb.getPageURL();
		System.out.println(b);

		fb.getPageSource();

		fb.close();

		

	}

}
