package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDiplayed {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
	driver = new ChromeDriver();// browser
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	
//	boolean flag=driver.findElement(By.id("input-email11")).isDisplayed();
//	System.out.println(flag);
	
	By email = By.id("input-email");
	By password = By.name("password11");
	
	boolean flag1=elementIsDisplayed(email);
	System.out.println(flag1);
	
	boolean flag2=elementIsDisplayed(password);
	System.out.println(flag2);
	
	System.out.println(driver.getTitle());
	
	}
	
	public static boolean elementIsDisplayed(By locator){
		try {
			return getElement(locator).isDisplayed();
		}
		catch(NoSuchElementException e) {
			System.out.println("Element is not displayed on the page: "+ locator);
			return false;	
		}
		
		}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
