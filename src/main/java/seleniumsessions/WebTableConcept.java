package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();

		Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		// driver.findElement(By.xpath("//a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

		//selectUser("Garry.White");
		//selectUser("Kevin.Mathews");

		//List<WebElement> userInfoList= driver.findElements(By.xpath("//a[text()='John.Smith']/parent::td/following-sibling::td"));
		//System.out.println(userInfoList.size());
		//for(WebElement e: userInfoList) {
		//System.out.println(e.getText());
		//}

		List<String> result = getInfoUserList("Garry.White");
		System.out.println(result);
	}

	public static void selectUser(String userName) {
		driver.findElement(
				By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static ArrayList<String> getInfoUserList(String userName) {
		List<WebElement> userInfoList = driver
				.findElements(By.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td"));
		System.out.println(userInfoList.size());
		
		ArrayList<String> infoList = new ArrayList<String>();	//pc=0
		
		for (WebElement e : userInfoList) {
			String text = e.getText();
			infoList.add(text);
			System.out.println(text);
		}
		return infoList;
	}
}
