package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumsessions.ElementUtil;

public class AmazonProductSearch {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);
		ElementUtil eleUtil= new ElementUtil(driver);
		
		By searchTextbox= By.xpath("//input[@id='twotabsearchtextbox']");
		By productsList= By.xpath("//div[contains(@id,'sac-suggestion-row')]//div[@role='button']");
		
		boolean result=eleUtil.doSearch(searchTextbox, "macbook pro" , productsList,"charger", "macbook pro charger");
		if(result) {
			System.out.println("Search is successful");
		}
		else {
			System.out.println("Search is not succesful");
		}
	}
}
