package seleniumsessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
	static WebDriver driver;
	public static void main(String[] args) {
		//WebElement to WebElement
		
		driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().window().maximize();
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.COMMAND).sendKeys(Keys.END).perform();
		
	}	
}
