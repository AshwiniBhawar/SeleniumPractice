package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowserHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");   //parent window
		driver.manage().window().maximize();
		
		String parentWindowID=driver.getWindowHandle();
		Thread.sleep(2000);
		
		WebElement fbLogo=driver.findElement(By.xpath("//img[@alt='facebook']"));
		WebElement linkedInLogo=driver.findElement(By.xpath("//img[@alt='linkedin']"));
		WebElement youtubeLogo=driver.findElement(By.xpath("//img[@alt='youtube']"));
		
		fbLogo.click();
		linkedInLogo.click();
		youtubeLogo.click();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		
		System.out.println(handles.size());
		
		while(it.hasNext()) {
			String windowId=it.next();
			Thread.sleep(2000);
			driver.switchTo().window(windowId);
			String pageTitle=driver.getTitle();
			System.out.println(pageTitle);
			if(pageTitle.equals("OrangeHRM (@orangehrm) / X")) {
				System.out.println(driver.getCurrentUrl()+" :"+driver.getTitle());
				//break;
			}
			Thread.sleep(2000);
			if(!windowId.equals(parentWindowID)) {
			driver.close();
			}
		}
		
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
		
	}

}
