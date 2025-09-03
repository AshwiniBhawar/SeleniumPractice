package seleniumsessions;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowCOncept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		driver.manage().window().maximize();
		
		String parentWindowHandle=driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);//4.x
		driver.get("https://google.com");
		System.out.println("I am on new Window");
		driver.close();
		
		driver.switchTo().window(parentWindowHandle);
		System.out.println("I am on Parent Window");
		
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);//4.x
		driver.get("https://google.com");
		System.out.println("I am on new tab");
		driver.close();
		
		driver.switchTo().window(parentWindowHandle);
		System.out.println("I am on Parent Window");
	}

}