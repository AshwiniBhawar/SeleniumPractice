package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement radioOptionYes = driver.findElement(By.xpath("//label[normalize-space()='Yes']"));
		
		driver.findElement(RelativeLocator.with(By.xpath("(//input[@name='newsletter'])[1]")).near(radioOptionYes)).click();
		
		driver.findElement(RelativeLocator.with(By.xpath("(//input[@name='newsletter'])[2]")).toRightOf(radioOptionYes)).click();
		
	}
}
