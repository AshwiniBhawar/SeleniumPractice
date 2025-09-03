package seleniumsessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownValueSelection {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// 1. select tag drop down
		// 2. select the value from the drop down without using select class methods
		// byIndex, byVisibleText, byValue -- not allowed

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
		driver.manage().window().maximize();
		
		By country = By.id("Form_getForm_Country");
		By employee = By.id("Form_getForm_NoOfEmployees");
		
		ElementUtil util= new ElementUtil(driver);
		List<String> dropDownValuesList = util.getDropDownValuesList(employee);
		System.out.println(dropDownValuesList);
		
		By countryList= By.cssSelector("#Form_getForm_Country>option");
		util.selectDropDownValue(countryList,"India");

//		WebElement countryEle = driver.findElement(country);
//		Select select = new Select(countryEle);
//		List<WebElement> countryOptionsList = select.getOptions();
//		for (WebElement e : countryOptionsList) {
//			String text = e.getText();
//			if (text.contains("India")) {
//				e.click();
//				break;
//			}
//		}

	}

}