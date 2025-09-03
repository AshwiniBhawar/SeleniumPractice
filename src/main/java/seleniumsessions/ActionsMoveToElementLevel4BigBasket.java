package seleniumsessions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsMoveToElementLevel4BigBasket {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		By menuLevel1 = By.xpath("(//span[text()='Shop by'])[2]");
		By menuLevel2 = By.linkText("Beverages");
		By menuLevel3 = By.linkText("Tea");
		By menuLevel4 = By.linkText("Green Tea");
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(5000));
//		WebElement menuLevelOne=wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel1));	
//		WebElement menuLevelTwo=wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel2));
//		WebElement menuLevelThree=wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel3));
//		WebElement menuLevelFour=wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel4));
		
		driver.findElement(menuLevel1).click();
		Thread.sleep(4000);
		Actions act= new Actions(driver);			//not working	
		act.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel2)))
			.pause(4000)
			.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel3)))
			.pause(4000)
			.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(menuLevel4)))
			.pause(4000)
			.click()
			.build()
			.perform();
		
//		act.moveToElement(driver.findElement(menuLevel1)).click().perform();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(menuLevel2)).perform();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(menuLevel3)).perform();
//		Thread.sleep(2000);
//		act.moveToElement(driver.findElement(menuLevel4)).click().perform();
		
		//menuSubMenuHandlingLevel(menuLevel1,menuLevel2, menuLevel3,menuLevel4);
		
		By menulevel1 = By.xpath("(//span[text()='Shop by'])[2]");
		By menulevel2 = By.linkText("Fruits & Vegetables");
		By menulevel3 = By.linkText("Fresh Fruits");
		By menulevel4 = By.linkText("Mangoes");
		
//		menuSubMenuHandlingLevel(menulevel1, menulevel2, menulevel3, menulevel4);
//		ElementUtil util= new ElementUtil(driver);
//		util.menuSubMenuHandlingLevel4("click", menulevel1, menulevel2, menulevel3, menulevel4);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void menuSubMenuHandlingLevel(By menuLevel1, By menuLevel2, By menuLevel3, By menuLevel4) throws InterruptedException {
		Actions action= new Actions(driver);
		doClick(menuLevel1);
		Thread.sleep(1000);
		action.moveToElement(getElement(menuLevel2)).perform();
		Thread.sleep(1000);
		action.moveToElement(getElement(menuLevel3)).perform();
		Thread.sleep(1000);
		doClick(menuLevel1);
	}
}
