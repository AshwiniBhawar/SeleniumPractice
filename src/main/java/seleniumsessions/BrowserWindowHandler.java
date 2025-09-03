package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandler {

	// multiple windows/tabs
	// target=_blank
	// window handler apis
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");   //parent window
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("About Us")).click();
		
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.linkText("OrangeHRM"))).click().perform();
		//act.click(driver.findElement(By.linkText("OrangeHRM"))).perform();

		//1. get the window ids:
		Set<String> windowsIds = driver.getWindowHandles();
		Iterator<String> it = windowsIds.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id : "+ parentWindowId);
		String childWindowId = it.next();
		System.out.println("child window id : "+ childWindowId);

		Thread.sleep(2000);
		  
		//2. switching work:
		
		driver.switchTo().window(childWindowId);
		System.out.println("child window page title: "+driver.getTitle());
		
		driver.close();
		
		//driver is lost
		
		//come back to parent window:
		driver.switchTo().window(parentWindowId);
		System.out.println("parent window page title: "+driver.getTitle());

		Thread.sleep(2000);

		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("Ash B");
		
		driver.quit();
	}

}
