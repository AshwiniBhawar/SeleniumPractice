package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWIthDeSelect {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		driver.manage().window().maximize();
		
//		Select select = new Select(driver.findElement(By.xpath("//select[@multiple]")));
//		boolean isMultiple = select.isMultiple();
//		System.out.println(isMultiple);
//		if(isMultiple) {
//			select.selectByVisibleText("American flamingo");
//			select.selectByVisibleText("Chilean flamingo");
//			select.selectByVisibleText("Lesser flamingo");
//		}
		
		By dropDownMultiple=By.xpath("//select[@multiple]");
		
		if(isDropDownIsMultiple(dropDownMultiple)){
			doSelectByVisibleText(dropDownMultiple,"Chilean flamingo");
		}
		
		
		Thread.sleep(2000);
		doSelectByVisibleText(dropDownMultiple, "Lesser flamingo");
		
		List<String> selectedOptionsList=doSelectAll(dropDownMultiple);
		System.out.println(selectedOptionsList);
		
		System.out.println(getAllSelectedOptionsCount(dropDownMultiple));
		
//		Thread.sleep(5000);
//		doDeSelectAll(dropDownMultiple);
		
	}
	
	public static boolean isDropDownIsMultiple(By locator) {
		Select select = new Select(getElement(locator));
		boolean isMultiple = select.isMultiple();
		System.out.println(isMultiple);
		return isMultiple;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(eleText);
	}
	
	public static void doDeSelectByVisibleText(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.deselectByVisibleText(eleText);
	}
	public static void doDeSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.deselectByIndex(index);
	}
	
	public static void doDeSelectByValue(By locator, String eleText) {
		Select select = new Select(getElement(locator));
		select.deselectByVisibleText(eleText);
	}
	
	public static void doDeSelectAll(By locator) {
		Select select = new Select(getElement(locator));
		select.deselectAll();
	}
	
	public static List<String> doSelectAll(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> options = select.getAllSelectedOptions();
		System.out.println("total no. of selected values: " +options.size());
		List<String> allSelectedOptions= new ArrayList<String>();
		
		for(WebElement e:options) {
			allSelectedOptions.add(e.getText());
		}
		
		return allSelectedOptions;
	}
	
	public static int getAllSelectedOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getAllSelectedOptions().size();
	}
	
	
}
