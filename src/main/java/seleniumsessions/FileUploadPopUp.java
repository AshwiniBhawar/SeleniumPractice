package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		Thread.sleep(3000);
		
		//tag type=file -- should be there
		String fileName="Abc - Copy.docx";
		driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\ashwi\\OneDrive\\Desktop\\"+fileName);
		Thread.sleep(2000);
		driver.findElement(By.id("fileSubmit")).click();
		String fileUploadedMsg=driver.findElement(By.tagName("h1")).getText();
		String fullFileName=driver.findElement(By.xpath("//div[@id='uploaded-files']/p")).getText();
		String[] fileUploadedName= fullFileName.split("_");
		
		if(fileUploadedMsg.equals("File Uploaded!") && fileUploadedName[1].equals(fileName)) {
			System.out.println("File is uploaded");
		}
		
		//if type = file is not there??
		//ask your dev team to add type = file
		//otherwise we can not automate this use case
		//we can use some 3rd party libs: not at all recommended
			//1. Sikuli
			//2. AutoIt -- 3rd open source -- works only for windows OS
			//3. Robot class -- works only for windows OS
				
	}

}
