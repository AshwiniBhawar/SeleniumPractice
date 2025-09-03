package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {

	public static void main(String[] args) throws InterruptedException {

			WebDriver driver = new ChromeDriver();

			//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

			driver.get("https://www.bigbasket.com/");
			driver.manage().window().maximize();
			
			Actions act = new Actions(driver);
			//partial scrolling
//			act.sendKeys(Keys.PAGE_DOWN).perform();
//			Thread.sleep(2000);
//			act.sendKeys(Keys.PAGE_UP).perform();
			
			//go to the footer of the page:
			//mac: command+arrow down/up
			//windows: command/control+arrow down/up
//			act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//			Thread.sleep(2000);
//			act.sendKeys(Keys.COMMAND).sendKeys(Keys.HOME).perform();
			
			//scroll to the element: //4.x
			//act.scrollToElement(driver.findElement(By.xpath("//h4[text()='Popular Brands']"))).perform();
			act.scrollToElement(driver.findElement(By.xpath("//h4[text()='Popular Brands']")))
					.click(driver.findElement(By.xpath("//a[text()='Amul']"))).perform();
			
	}

}
