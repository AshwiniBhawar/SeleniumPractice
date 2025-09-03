package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysMethod {
static WebDriver driver;
	
	public static void main(String[] args) {
		
	driver = new ChromeDriver();
//	driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
//	String emailId = "naveen@gmail.com";
//	StringBuilder emailIdBuilder = new StringBuilder("tom@gmail.com");
//	StringBuffer emailIdBuffer = new StringBuffer("test@gmail.com");
//	driver.findElement(By.id("input-email")).sendKeys(emailId,emailIdBuilder,emailIdBuffer);
	
	driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//	String initialName = "Naveen";
//	String middleName = "Automation";
//	String lastName = "Labs";
//	driver.findElement(By.id("input-firstname")).sendKeys(initialName," ",middleName," ",lastName);
	
	//null is not allowed
	//driver.findElement(By.id("input-lastname")).sendKeys(null);
	
	By lastname = By.id("input-lastname");
	ElementUtil eleUtil = new ElementUtil(driver);
	eleUtil.doSendkeys(lastname, null);
	//eleUtil.doSenkeys(lastname, "priya");
	//eleUtil.doSenkeys(lastname, "priya"," ","bapat");
	//eleUtil.doMultipleSendKeys(lastname, "kumar", " ", "priya");
	
	//sendKeys:
	//single value - allowed
	//multiple values -- allowed
	//String, SB, SBF --- allowed
	//null -- not allowed
	
	}
}
