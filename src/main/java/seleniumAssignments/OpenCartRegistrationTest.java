package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumsessions.BrowserUtil;
import seleniumsessions.ElementUtil;
import seleniumsessions.VerificationUtil;

public class OpenCartRegistrationTest {
	
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
	BrowserUtil brUtil= new BrowserUtil();
	driver =brUtil.initDriver("chrome");
	brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	String registrationPageTitle=brUtil.getPageTitle();
	
	VerificationUtil.verifyEquals(registrationPageTitle,"Register Account");
	
	String registrationPageUrl=brUtil.getPageUrl();
	
	VerificationUtil.verifyContains(registrationPageUrl,"route=account/register");
	
	By firstName=By.id("input-firstname");
	By lastName=By.id("input-lastname");
	By email= By.cssSelector("input[name='email']");
	By telephone= By.id("input-telephone");
	By password= By.id("input-password");
	By confirmPassword= By.id("input-confirm");
	By newsLetterButton= By.name("newsletter");
	By agreementCheckbox= By.name("agree");
	By loginButton= By.xpath("//input[@type='submit']");
	
	Thread.sleep(2000);
//	ElementUtil util= new ElementUtil(driver);
//	util.isElementDisplayedForMandortyFields(firstName);
	
	doSenkeys(firstName, "test");
	doSenkeys(lastName, "demo");
	doSenkeys(email, generateRandomEmailId());
	doSenkeys(telephone, "1234567890");
	doSenkeys(password, "testdemo");
	doSenkeys(confirmPassword, "testdemo");
	doClick(newsLetterButton);
	doClick(agreementCheckbox);
	doClick(loginButton);
	
	By registrationSuccessfulMsg=By.xpath("//div[@id='content']/h1");
	String actualMessage=doElementGetText(registrationSuccessfulMsg);
	String expectedMessage="Your Account Has Been Created!";
	
	VerificationUtil.verifyEquals(actualMessage,expectedMessage);
	
	brUtil.closeBrowser();
	
	}
	
	public static String generateRandomEmailId() {
		return "automation"+System.currentTimeMillis()+"@opencart.com";
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSenkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
}