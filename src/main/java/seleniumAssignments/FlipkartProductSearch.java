package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumsessions.ElementUtil;

public class FlipkartProductSearch {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		ElementUtil eleUtil= new ElementUtil(driver);
		
		By searchTextbox= By.name("q");
		By productsList= By.xpath("//ul//li[@class='_3D0G9a']//div[@class='YGcVZO _2VHNef']");
		
		boolean result=eleUtil.doSearch(searchTextbox, "macbook pro" , productsList,"m2 pro", "Macbook Pro M2 Pro");
		if(result) {
			System.out.println("Search is successful");
		}
		else {
			System.out.println("Search is not succesful");
		}
	}

}
