package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorWithWebTable {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		Thread.sleep(2000);
		WebElement username=driver.findElement(By.linkText("Joe.Root"));
		//driver.findElement(RelativeLocator.with(By.name("chkSelectRow[]")).toLeftOf(username)).click();
		//selectUserName("Joe.Root");
		
		String abovePlyaer = driver.findElement(with(By.tagName("a")).above(username)).getText();
		System.out.println(abovePlyaer);
		
		String belowPlyaer = driver.findElement(with(By.tagName("a")).below(username)).getText();
		System.out.println(belowPlyaer);

		String rightUserRole = driver.findElement(with(By.tagName("td")).toRightOf(username)).getText();
		System.out.println(rightUserRole);
		
		List<WebElement> belowLinks = driver.findElements(with(By.tagName("a")).below(username));
		
		System.out.println(belowLinks.size());
		
			for(WebElement e : belowLinks) {
				System.out.println(e.getText());
			}		
	}
	
	public static void selectUserName(String username) {
		WebElement usernameEle = driver.findElement(By.linkText(username));
		driver.findElement(with(By.name("chkSelectRow[]")).toLeftOf(usernameEle)).click();

	}

}
