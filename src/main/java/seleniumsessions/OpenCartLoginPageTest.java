package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLoginPageTest {
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil= new BrowserUtil();
		WebDriver driver=brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		String loginPageTitle=brUtil.getPageTitle();
		
		VerificationUtil.verifyEquals(loginPageTitle,"Account Login");
		
		String loginPageUrl=brUtil.getPageUrl();
		
		VerificationUtil.verifyContains(loginPageUrl,"route=account/login");
		
		By emailLocator=By.id("input-email");
		By passLocator=By.id("input-password");
		
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendkeys(emailLocator, "automationframework@gmail.com");
		eleUtil.doSendkeys(passLocator, "automationframework");
		
		brUtil.closeBrowser();
		
	}

}
