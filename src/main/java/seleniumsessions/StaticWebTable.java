package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		//table[@id="customers"]/tbody/tr[5]/td[1]
		//table[@id="customers"]/tbody/tr[6]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		Thread.sleep(2000);
		
		//List<String> colResult=getSpecificColumnData(1);
		//System.out.println(colResult);
		//getSpecificColumnData(2);
		//getSpecificColumnData(3);	
		
		getHeaderData();
		getSpecificRowData(2);
		getSpecificRowData(3);
		
		}
		
		//O(n)
		public static ArrayList<String> getSpecificColumnData(int columnNumber) {
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String aferXpath = "]/td["+columnNumber+"]";
				
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();		
		
		ArrayList<String> list= new ArrayList<String>();
		
		for(int row=2; row<=rowCount; row++) {
			String xpath = beforeXpath + row + aferXpath;//table[@id='customers']/tbody/tr[2]/td[1]
			String text = driver.findElement(By.xpath(xpath)).getText();
			list.add(text);
			System.out.println(text);
		}
		return list;
				
	}
		//O(n^2)
		public static ArrayList<String> getSpecificRowData(int rowNum) {
								
			int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();		
			int colCount = driver.findElements(By.xpath("//table[@id='customers']//tr[2]//td")).size();	
	
			ArrayList<String> list= new ArrayList<String>();
			for(int row=2; row<=rowCount; row++) {
				if(row==rowNum) {
	
				for(int col=1; col<=colCount; col++) {
					
					String xpath ="//table[@id='customers']/tbody/tr["+row+"]/td["+col+"]";
					String text = driver.findElement(By.xpath(xpath)).getText();
					list.add(text);
						System.out.print(text+"    ");
					}
				
				break;
				}
			
			}
			System.out.println();
			return list;
			
					
		}
		
		public static void getHeaderData() {
			
			int headerCount = driver.findElements(By.xpath("//table[@id='customers']//tr[1]//th")).size();
			for(int header=1; header<=headerCount; header++) {
				String xpath ="//table[@id='customers']/tbody/tr[1]/th["+header+"]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text+"    ");
			}
			
			System.out.println();
			
		}
	
}
