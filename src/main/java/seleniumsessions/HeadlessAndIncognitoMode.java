package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessAndIncognitoMode {

	public static void main(String[] args) {
		
		//headless: no browser is launched
		//testing is happening behind the scene
		//adv:
			//1. speed
			//2. useful in ci cd pipeline--linux machine/docker 
		
//		ChromeOptions op= new ChromeOptions();
//		op.addArguments("--headless");
//		op.addArguments("--incognito");
//		WebDriver driver= new ChromeDriver(op);
//		driver.manage().window().maximize();
		
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		fo.addArguments("--incognito");
//		WebDriver driver = new FirefoxDriver(fo);
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions eo= new EdgeOptions();
//		eo.addArguments("--headless");
		eo.addArguments("--inprivate");
		WebDriver driver=new EdgeDriver(eo);
		driver.manage().window().maximize();
		
//      Edge -- open in the incognito/mode -- find out the switch for edge: inPrivate
//      safari?? does not support headless mode
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());
	}

}
