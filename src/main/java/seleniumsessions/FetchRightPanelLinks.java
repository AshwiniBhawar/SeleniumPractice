package seleniumsessions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchRightPanelLinks {
	static WebDriver driver;
	public static void main(String[] args) {
	
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By rightPanelLinks = By.className("list-group-item");
		
//		List<WebElement> rightPanelLinksList=driver.findElements(rightPanelLinks);
//		System.out.println(rightPanelLinksList.size());
//		for(WebElement e : rightPanelLinksList) {
//			System.out.println(e.getText());
//		}
		
		System.out.println("==============================================");
		
		ElementUtil eleUtil= new ElementUtil(driver);
		int actLinksCount =eleUtil.getElementsCount(rightPanelLinks);
		System.out.println(actLinksCount);
		
		//checkpoint
		if(actLinksCount == 13) {
			System.out.println("PASS");
		}
		
		System.out.println("==============================================");
		
		List<String> actListText = eleUtil.getElementsTextList(rightPanelLinks);
		
		//checkpoint
		if(actListText.containsAll(Arrays.asList("Login", "Forgotten Password", "Register"))) {
			System.out.println("all three imp links are present at right panel section...");
		}
	}

}
