package seleniumAssignments;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrowserHandleAssignments {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		driver.manage().window().maximize();

		String parentWindowID = driver.getWindowHandle();
		System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='social-link']//a"));

		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			Thread.sleep(2000);
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
				String windowID = it.next();
				if (!windowID.equals(parentWindowID)) {
				driver.switchTo().window(windowID);
				System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());
				driver.close();
				}
			}
			driver.switchTo().window(parentWindowID);
		}	
	}

}
