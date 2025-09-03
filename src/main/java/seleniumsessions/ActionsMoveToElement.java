package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {

	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		//WebElement addOns=driver.findElement(By.xpath("//div[text()='Add-ons']"));
		//WebElement deals=driver.findElement(By.xpath("//div[text()='Deals']"));
		
		//Actions action= new Actions(driver);
		
		//1.
		//action.moveToElement(addOns).perform();//B-P
		//2.
		//action.moveToElement(addOns).build().perform();
		//driver.findElement(By.xpath("//div[text()='Visa Services']")).click();
		//driver.findElement(By.xpath("//div[text()='Taxi']")).click();
		
		By parentMenu=By.xpath("//div[text()='Add-ons']");
		By childMenu=By.xpath("//div[text()='Taxi']");
		
		menuSubMenuHandlingLevel(parentMenu, childMenu);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void menuSubMenuHandlingLevel(By parentMenu,By childMenu) {
		Actions action= new Actions(driver);
		action.moveToElement(getElement(parentMenu)).perform();
		doClick(childMenu);
	}
}
