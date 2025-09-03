package seleniumAssignments;

import org.openqa.selenium.remote.service.DriverFinder;

import seleniumsessions.BrowserUtil;
import seleniumsessions.VerificationUtil;

public class OrangeHRMLogin {
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil= new BrowserUtil();
		
		brUtil.initDriver("chrome");
		brUtil.launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String orgHRMPageTitle=brUtil.getPageTitle();
		VerificationUtil.verifyEquals(orgHRMPageTitle, "OrangeHRM");
		
		String orgHRMPageUrl=brUtil.getPageUrl();
		VerificationUtil.verifyContains(orgHRMPageUrl, "auth/login");
		
		brUtil.closeBrowser();
	}

}
