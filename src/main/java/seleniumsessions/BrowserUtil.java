package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {
	
	WebDriver driver;
	
	public WebDriver initDriver(String browserName) {
		
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;
			
		case "safari":
			driver=new SafariDriver();
			break;

		default:
			throw new BrowserException("=========Invalid Browser-->"+browserName+"=============");
		}
		
		return driver;
		
	}
	
	public void launchUrl(String url) {
		System.out.println("==========Launch Url-->"+url+"=============");
		
		if(url==null) {
			throw new BrowserException("=========Invalid url; url can not be null=============");
		}
		
		if(!url.startsWith("http")) {
			throw new BrowserException("=========Invalid url; http(s) is missing=============");
		}
		
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
