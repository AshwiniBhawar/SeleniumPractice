package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		driver.manage().window().maximize();
		
		//driver.switchTo().frame(2);			//frame id
		//driver.switchTo().frame("main");		//frame nameorid
		driver.switchTo().frame(driver.findElement(By.name("main")));	//frame WebElement
		String header=driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);

	}

}
