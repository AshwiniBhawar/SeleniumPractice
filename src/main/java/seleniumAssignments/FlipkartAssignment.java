package seleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartAssignment {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.findElement(By.xpath("//a[@aria-label='Grocery']")).click();
		// driver.findElement(By.xpath("//a[@title='CMF by Nothing Phone 1']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Electronics']/following-sibling::span")).click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));

		for (WebElement e : list) {
			System.out.println(e.getText());
			//Thread.sleep(4000);
			if (e.getText().contains("Gaming")) {
				Actions action= new Actions(driver);
				action.moveToElement(e).perform();
				List<WebElement> listSearchedElements = driver.findElements(By.xpath("//div[@class='_31z7R_']//a"));
				
				for (WebElement l : listSearchedElements) {
					System.out.println(l.getText());
					if (l.getText().contains("Games")) {
						l.click();
						break;
					} 
				}
				
				break;
			} 
		}
		
			
		driver.findElement(By.xpath("//div[@class='zg-M3Z' and contains(text(),'High to Low')]")).click();
				
		//List<WebElement> items=driver.findElements(By.xpath("//div[@class='_75nlfW']/div"));
		Thread.sleep(5000);
		
		for(int i=1;i<=5;i++) {
			Thread.sleep(2000);
			String productText= driver.findElement(By.xpath("(//div[@class='slAVV4']//a[@class='wjcEIp'])["+i+"]")).getText();
			String	productStars=  driver.findElement(By.xpath("(//div[@class='slAVV4']//div[@class='XQDdHH'])["+i+"]")).getText();
			String productPrice=  driver.findElement(By.xpath("(//div[@class='slAVV4']//div[@class='Nx9bqj'])["+i+"]")).getText();
			
			System.out.println("Product name is: "+productText+"===="+"Product stars are: "+productStars+"===="+"Product price is: "+productPrice);
		}
		
	}
}
