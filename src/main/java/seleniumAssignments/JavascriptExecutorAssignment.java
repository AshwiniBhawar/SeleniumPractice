package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String title=js.executeScript("return document.title").toString();
		System.out.println("Page title is : "+title);							//title
		
		String url=js.executeScript("return document.URL").toString();
		System.out.println("Page url is : "+url);								//url
		
//		Thread.sleep(2000);
//		js.executeScript("history.go(0)");		//refresh
//		driver.navigate().to("https://www.amazon.com");
//		js.executeScript("history.go(-1)");		//backward
//		Thread.sleep(2000);
//		js.executeScript("history.go(1)");		//forward
//		Thread.sleep(2000);
		
//		js.executeScript("alert('Hi, This is a alert')");
//		driver.switchTo().alert().accept();									//if not return- UnhandledAlertException
//		Thread.sleep(2000);
//		js.executeScript("confirm('Hi, is a confirmation alert')");
//		driver.switchTo().alert().accept();	
//		Thread.sleep(2000);
//		js.executeScript("prompt('Hi, This is a prompt alert')");
//		driver.switchTo().alert().sendKeys("accepted");
//		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
//		js.executeScript("document.getElementById('input-email').value='AutomationTest@gmail.com'");		//sendkeys
//		js.executeScript("document.getElementById('input-password').value='Tester1234'");
//		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@value='Login']")));	//click
		
		
//		String message=js.executeScript("return document.documentElement.innerText").toString();			//innerText of each and every items
//		System.out.println(message);
		
		WebElement we=driver.findElement(By.linkText("Contact Us"));
		String backgroundColor= we.getCssValue("backgroundColor");
		js.executeScript("arguments[0].scrollIntoView(true)", we);											//scroll to specific element		
//		js.executeScript("arguments[0].style.border='3px solid red'", we);									//draw a border around an element
//		js.executeScript("arguments[0].style.backgroundColor='rgb(0,200,0)'", we);							//change a bgcolor of an element
		
		for(int i=0;i<=100;i++) {																			//flash an element 100 times
			js.executeScript("arguments[0].style.backgroundColor='rgb(0,200,0)'", we);		
			js.executeScript("arguments[0].style.backgroundColor='"+backgroundColor+"'", we);		
		}
		
//		js.executeScript("window.scrollTo(0,500)");															//scroll down to the particular pixel
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");									//scroll to the end of the page
//		Thread.sleep(2000);
//		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");									//scroll to the start of the page
		
		js.executeScript("document.body.style.zoom = '120%'");												//Zoom
	}

}
