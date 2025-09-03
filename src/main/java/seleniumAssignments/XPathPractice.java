package seleniumAssignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class XPathPractice {

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
		
//		Thread.sleep(5000);
//		WebElement minDropdown=driver.findElement(By.xpath("//div[@class='suthUA']//select"));
//		minDropdown.click();
//		String minValue="₹1000";
//		Select minDrop=new Select(minDropdown);
//		minDrop.selectByVisibleText(minValue);
//		Thread.sleep(5000);
//		WebElement maxDropdown=driver.findElement(By.xpath("//div[@class='tKgS7w']//select"));
//		maxDropdown.click();
//		String maxValue="₹2500";
//		Select maxDrop=new Select(maxDropdown);
//		maxDrop.selectByVisibleText(maxValue);
		
		Thread.sleep(3000);
		
//		String urlBefore=driver.getCurrentUrl();
//		System.out.println(urlBefore);
//		System.out.println(minValue.split("₹")[1]);
//		System.out.println(maxValue.split("₹")[1]);
//		String urlAfter=urlBefore.replace(minValue.split("₹")[1], "1200").replace(maxValue.split("₹")[1], "5000");	
//		driver.get(urlAfter);
//		String url=driver.getCurrentUrl();
//		System.out.println(url);
		
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//div[@class='KalC6f iE4xEP'])[1]")));
		//System.out.println(driver.findElement(By.xpath("(//div[@class='KalC6f iE4xEP'])[1]")).getText());
		
		System.out.println("======================================================================");
		
		Thread.sleep(2000);
		List<WebElement> actualMailAddress=driver.findElements(By.xpath("(//div[@class='KalC6f iE4xEP'])[1]/p"));
		List<String> expectedMailAddress=Arrays.asList("Flipkart Internet Private Limited,","Buildings Alyssa, Begonia &" ,"Clove Embassy Tech Village,","Outer Ring Road, Devarabeesanahalli Village,",
				"Bengaluru, 560103,","Karnataka, India");
		int i=0;
		for(WebElement e:actualMailAddress) {
		if(e.getText().equals(expectedMailAddress.get(i))) {
			System.out.println(e.getText()+ " matches with "+expectedMailAddress.get(i));
			i++;
		}
		else {
			System.out.println(e.getText()+ " does not matches with "+expectedMailAddress.get(i));
			i++;
		}
		}
		
		System.out.println("======================================================================");
		Thread.sleep(2000);
		List<WebElement> actualOfficeAddress=driver.findElements(By.xpath("(//div[@class='KalC6f iE4xEP'])[2]/p"));
		List<String> expectedOfficeAddress=Arrays.asList("Flipkart Internet Private Limited,","Buildings Alyssa, Begonia &" ,"Clove Embassy Tech Village,","Outer Ring Road, Devarabeesanahalli Village,",
				"Bengaluru, 560103,","Karnataka, India","CIN : U51109KA2012PTC066107","Telephone: 044-45614700 / 044-67415800");
		int j=0;
		for(WebElement e:actualOfficeAddress) {
		if(e.getText().equals(expectedOfficeAddress.get(j))) {
			System.out.println(e.getText()+ " matches with "+expectedOfficeAddress.get(j));
			j++;
		}
		else {
			System.out.println(e.getText()+ " does not matches with "+expectedOfficeAddress.get(j));
			j++;
		}
		}
		Thread.sleep(2000);
		
//		List<WebElement> socialMedia=driver.findElements(By.xpath("//div[@class='_8W+7ID']//span[@class='RbqUpy']//a"));
//		int i=0;
//		for(WebElement e:socialMedia) {
//			List<String> expectedData=Arrays.asList("facebook","twitter","youtube","instagram");
//			if(e.getDomAttribute("href").contains(expectedData.get(i))) {
//				System.out.println(e.getDomAttribute("href") +" contains " +expectedData.get(i));
//				i=i+1;
//			}
//			else {
//				System.out.println(e.getDomAttribute("href") +" doesn't contains " +expectedData.get(i));
//				i=i+1;
//			}
//		}
		}
}
