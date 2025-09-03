package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsPresent {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		List<WebElement> eleList = driver.findElements(emailId);//size=1;
//		System.out.println(eleList.size());
//		if(eleList.size() == 1) {
//			System.out.println("element is present on the page");
//		}
//		else {
//			System.out.println("element is not present on the page");
//		}
		
		By emailId = By.id("input-email");//---> 1
		By forgotPwdLink = By.linkText("Forgotten Password");//--->2
		
		if(isElementExist(emailId)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		if(isElementExist(forgotPwdLink,2)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
	}

	public static boolean isElementExist(By locator) {
		if(getElements(locator).size()==1) {
			System.out.println("the element : "+ locator +" is present on the page 1 time");
			return true;
		}
		else {
			System.out.println("the element : "+ locator +" is not present on the page one time");
			return false;
		}
	}
	
	public static boolean isElementExist(By locator, int expectedEleCount) {
		if(getElements(locator).size()==expectedEleCount) {
			System.out.println("the element : "+ locator +" is present on the page "+expectedEleCount+ " time");
			return true;
		}
		else {
			System.out.println("the element : "+ locator +" is not present on the page "+expectedEleCount+ " time");
			return false;
		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
