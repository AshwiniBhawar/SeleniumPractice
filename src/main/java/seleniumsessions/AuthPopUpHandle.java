package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUpHandle {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String username = "admin";
		String password = "admin";
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		String authLoginSuccessfulMsg=driver.findElement(By.tagName("p")).getText();
		if(authLoginSuccessfulMsg.contains("Congratulations! You must have the proper credentials.")) {
			System.out.println("Auth login msg is validated");
		}
		else {
			System.out.println("Auth login msg is not validated");
		}
		//selenium 4.x: HasAuthenticate: later
	
	}
}
