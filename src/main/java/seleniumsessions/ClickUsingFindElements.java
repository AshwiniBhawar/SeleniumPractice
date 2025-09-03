package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickUsingFindElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		List<WebElement> footerList = driver.findElements(By.xpath("//footer//a"));
//		
//		System.out.println("total footer links: "+ footerList.size());
//		
//		for(WebElement e : footerList) {
//			String text = e.getText();
//			System.out.println(text);
//				if(text.equals("Contact Us")) {
//					e.click();
//					break;
//				}
//		}

//		By rightPanelLinks = By.className("list-group-item");
//		boolean result=clickElement(rightPanelLinks, "Forgotten Password", "Forgot Your Password?");
//		if(result) {
//			System.out.println("Navigation is successful");
//		}
//		else {
//			System.out.println("Navigation is not successful");
//		}

		By footerLinks = By.xpath("//footer//a");
		boolean result = clickElement(footerLinks, "Privacy Policy", "Privacyy Policy");

		if (result) {
			System.out.println("Navigation is successful");
		} else {
			System.out.println("Navigation is not successful");
		}

	}

	public static boolean clickElement(By locator, String eleText, String expectedPageTitle)
			throws InterruptedException {
		List<WebElement> eleList = driver.findElements(locator);
		System.out.println("total number of elements: " + eleList.size());

		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(eleText)) {
				e.click();

				Thread.sleep(4000);

				String actualPageTitle = driver.getTitle();
				System.out.println("The page title is: " + actualPageTitle);

				if (actualPageTitle.contains(expectedPageTitle)) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}
}
