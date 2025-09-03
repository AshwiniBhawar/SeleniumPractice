package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcepts {
	static WebDriver driver;	//null
	
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//page
		
		//Create a WebElement(FE) + perform action(click, sendKeys, getText, isDiplayed)
		
		//1st:
//		driver.findElement(By.id("input-email")).sendKeys("automationframework@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("automationframework");
		
		//2nd:
//		WebElement loginEmail=driver.findElement(By.id("input-email"));
//		WebElement loginPass=driver.findElement(By.id("input-password"));
		
//		loginEmail.sendKeys("automationframework@gmail.com");
//		loginPass.sendKeys("automationframework");
		
//		By emailLocator=By.id("input-email");
//		By passLocator=By.id("input-password");
		
		//3rd: By locator - OR
//		WebElement emailEle=driver.findElement(emailLocator);
//		WebElement passEle=driver.findElement(passLocator);
		
//		emailEle.sendKeys("automationframework@gmail.com");
//		passEle.sendKeys("automationframework");
		
		//4th: By locator + generic util(method)- getElement
		
//		By emailLocator=By.id("input-email");
//		By passLocator=By.id("input-password");
		
//		getElement(emailLocator).sendKeys("automationframework@gmail.com");
//		getElement(passLocator).sendKeys("automationframework");
		
		//5th: By locator + generic util(method)- getElement , doSendKeys()
		
//		By emailLocator=By.id("input-email");
//		By passLocator=By.id("input-password");
		
//		doSenkeys(emailLocator, "automationframework@gmail.com");
//		doSenkeys(passLocator, "automationframework");
	
		//6th: By locator + generic util(method)- getElement , doSendKeys() in ElementUtil class
		
		By emailLocator=By.id("input-email");
		By passLocator=By.id("input-password");
		
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendkeys(emailLocator, "automationframework@gmail.com");
		eleUtil.doSendkeys(passLocator, "automationframework");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSenkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
}
