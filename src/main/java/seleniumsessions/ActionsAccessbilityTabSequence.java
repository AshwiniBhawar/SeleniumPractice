package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAccessbilityTabSequence {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		
		Actions act = new Actions(driver);
		
		act.sendKeys(firstName,"Ash")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("B")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("abc@gmail.com")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("2123456785")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("Test1234")
		.pause(500)
		.sendKeys(Keys.TAB)
		.sendKeys("Test1234")
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.SPACE)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.SPACE)
		.pause(500)
		.sendKeys(Keys.ENTER)
		.perform();
	}

}
