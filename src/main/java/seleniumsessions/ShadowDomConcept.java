package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDomConcept {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();//browser
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");//open
		driver.manage().window().maximize();
		
		//Thread.sleep(5000);
		//Browser --> page --> iframe --> Shadow Dom --> element
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[@id='pact']"))));
		
		//Option 1:
//		SearchContext shadowRootElement1=driver.findElement(By.cssSelector("#snacktime")).getShadowRoot();
//		shadowRootElement1.findElement(By.id("tea")).sendKeys("tea");
//		SearchContext shadowRootElement2=shadowRootElement1.findElement(By.cssSelector("#app2")).getShadowRoot();
//		shadowRootElement2.findElement(By.id("pizza")).sendKeys("pizza");
		
		
		//Option 2: //DOM HTML Element ---> WebElement
		JavascriptExecutor js= (JavascriptExecutor) driver;
//		WebElement we=(WebElement) js.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
//		we.sendKeys("tea");
		
		WebElement we=(WebElement) js.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#app2').shadowRoot.querySelector('#pizza')");
		we.sendKeys("pizza");
		
		driver.switchTo().defaultContent();
	}
}
