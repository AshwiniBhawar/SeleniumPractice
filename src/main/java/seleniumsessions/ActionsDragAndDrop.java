package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDragAndDrop {
	static WebDriver driver;
	public static void main(String[] args) {
		//WebElement to WebElement
		
		driver= new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		
		By dragElement= By.id("draggable");
		By dropElement= By.id("droppable");
		
		Actions action= new Actions(driver);
//		action.clickAndHold(driver.findElement(dragElement))
//			.moveToElement(driver.findElement(dropElement))
//				.release()
//					.perform();
		
		
		action.dragAndDrop(driver.findElement(dragElement), driver.findElement(dropElement)).perform();
		
		//return type of build: Action (I) -- creating all the compositie actions, but not performing anything on the page
		//return type of perform: void -- peforms all the compositie actions on the page
		//A1.A2.....B.P: valid
		//A1.A2......P: valid
		//A1...A2...B: not valid: but I can store in some Action and then perform it.
		//A1.A2...: not valid
		
	}
}
