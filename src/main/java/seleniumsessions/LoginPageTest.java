package seleniumsessions;

public class LoginPageTest {
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil= new BrowserUtil();
	
		brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		String loginPageTitle=brUtil.getPageTitle();
		
		VerificationUtil.verifyEquals(loginPageTitle,"Account Login");
		
		String loginPageUrl=brUtil.getPageUrl();
		
		VerificationUtil.verifyContains(loginPageUrl,"route=account/login");
		
		brUtil.closeBrowser();
	}

}
