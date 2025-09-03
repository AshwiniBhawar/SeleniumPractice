package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			driver = new ChromeDriver();
			driver.get("https://www.google.com/");

			By searchLocator = By.name("q");
			By suggestionsLocator = By.xpath("//ul[@class='G43f7e']//div[@class='wM6W7d']/span");

			boolean result=doSearch(searchLocator, "cypress testing", suggestionsLocator, "jobs", "cypress testing jobs");
			if(result) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Fail");
			}
		}

				
		public static boolean doSearch(By searchLocator, String searchKey, By suggestionsLocator, String suggestionValue, String expectedPageTitle) throws InterruptedException {
			
			driver.findElement(searchLocator).sendKeys(searchKey);
			Thread.sleep(4000);//wait for 4 secs

			List<WebElement> suggList = driver.findElements(suggestionsLocator);
			System.out.println("total number of suggestions: " + suggList.size());

			for (WebElement e : suggList) {
				String text = e.getText();
				System.out.println(text);
				if (text.contains(suggestionValue)) {
					e.click();
					//break;
					if(driver.getTitle().contains(expectedPageTitle)) {
						return true;
					}
				}
			}
			return false;
		}
}
