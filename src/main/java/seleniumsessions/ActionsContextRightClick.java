package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsContextRightClick {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver= new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Actions action= new Actions(driver);
		action.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
		
		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul.context-menu-list > li >span"));
		System.out.println(optionsList.size());
		
		for(WebElement e: optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.contains("Copy")) {
					e.click();
					break;
				}
				
			}
		}
}
