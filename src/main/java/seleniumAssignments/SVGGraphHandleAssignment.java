package seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphHandleAssignment {
	public static String inputState="california";
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		List<WebElement> statesList =driver.findElements(By.xpath("//*[name()='svg']//*[name()='g' and @class='region']"));
		System.out.println("Total no of states :"+ statesList.size());// 51
		
		for(WebElement e: statesList) {
			Actions action= new Actions(driver);
			action.moveToElement(e).perform();
			String stateName=e.getAttribute("id");
			//System.out.println(stateName);
			if (stateName.contains(inputState.trim().toLowerCase())) {
				e.click();
				List<WebElement> countyNames=driver.findElements(By.xpath("//*[name()='svg']//*[name()='g' and @id='"+inputState+"']//*[@class='subregion']//*[contains(@name,'County')]"));
				System.out.println("Total number of counties in "+inputState+" is :"+countyNames.size());
				System.out.println("The list of counties in "+inputState+" is :");
				for(WebElement county: countyNames) {
					System.out.println(county.getAttribute("name"));
				}
				break;
			}
		}
		driver.switchTo().defaultContent();
	}

}
