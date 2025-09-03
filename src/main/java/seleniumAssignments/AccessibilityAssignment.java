package seleniumAssignments;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AccessibilityAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		Actions action= new Actions(driver);
		action.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys("macbook pro")
		.pause(500)
		.sendKeys(Keys.ENTER)
		.perform();

	}

}
