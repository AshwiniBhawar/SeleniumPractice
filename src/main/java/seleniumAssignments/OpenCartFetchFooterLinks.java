package seleniumAssignments;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumsessions.ElementUtil;

public class OpenCartFetchFooterLinks {
	static WebDriver driver;
	public static void main(String[] args) {
	
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		/*List<WebElement> footerHeadersCount=driver.findElements(By.xpath("//footer//div[@class='row']/div/h5"));
		System.out.println("Footer total headers count: "+footerHeadersCount.size());
		
		List<WebElement> footerLinksCount=driver.findElements(By.xpath("//footer//div[@class='row']//a"));
		System.out.println("Footer total links count: "+footerLinksCount.size());
		
		List<WebElement> footer=driver.findElements(By.xpath("//footer//div[@class='row']/div"));
		for(int i=1;i<=footer.size();i++) {
			By footerHeaderText = By.xpath("//footer//div[@class='row']/div["+i+"]/h5");
			String headerText=driver.findElement(footerHeaderText).getText();
			
			System.out.println("************"+headerText+"************");
			
			List<WebElement> footerLinksList=driver.findElements(By.xpath("//footer//div[@class='row']/div["+i+"]//a"));
			
			for(int j=0;j<footerLinksList.size();j++)
				System.out.println(footerLinksList.get(j).getText());
			}

		}*/
	
	ElementUtil eleUtil= new ElementUtil(driver);
	By footerHeadersLocator=By.xpath("//footer//div[@class='row']/div/h5");
	int footerHeadersCount=eleUtil.getElementsCount(footerHeadersLocator);
	System.out.println("Footer total headers count: "+footerHeadersCount);
	
	By footerLinksLocator=By.xpath("//footer//div[@class='row']//a");
	int footerLinksCount=eleUtil.getElementsCount(footerLinksLocator);
	System.out.println("Footer total links count: " + footerLinksCount);
	
	List<WebElement> footer=driver.findElements(By.xpath("//footer//div[@class='row']/div"));
	for(int i=1;i<=footer.size();i++) {
		
		By footerHeaderText = By.xpath("//footer//div[@class='row']/div["+i+"]/h5");
		String headerText=eleUtil.doElementGetText(footerHeaderText);
		
		//System.out.println("************"+headerText+"************");
		
		By footerLinksTextLocator=By.xpath("//footer//div[@class='row']/div["+i+"]//a");
		
		List<WebElement> footerLinksList=eleUtil.getElements(footerLinksTextLocator);
		
		for(int j=0;j<footerLinksList.size();j++) {
			String expectedText=footerLinksList.get(j).getText();
			System.out.println(expectedText);
		}
		}

	}
}
