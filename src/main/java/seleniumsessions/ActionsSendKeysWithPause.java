package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysWithPause {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		String name="Welcome to the java!";
		Actions action= new Actions(driver);
		//action.sendKeys(firstName, name).perform();
		//char ch[]=name.toCharArray();
		//for(char c:ch) {
		//action.sendKeys(firstName, String.valueOf(c)).pause(500).perform();
		//}
		
		By firstname = By.id("input-firstname");
		doSendKeysWithPause(firstname,"java",500);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	} 
	
	public static void doSendKeysWithPause(By locator, String value, long pauseTime) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for(char ch : val) {
			act
				.sendKeys(getElement(locator), String.valueOf(ch))
					.pause(pauseTime)
						.perform();
		}	
	}
}
