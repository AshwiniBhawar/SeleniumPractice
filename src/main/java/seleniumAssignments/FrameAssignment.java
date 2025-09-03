package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import seleniumsessions.ElementUtil;

public class FrameAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		By proposeTitleLocator= By.id("RESULT_TextField-1");
		By locationLocator= By.id("RESULT_TextField-3");
		By proposeDateLocator= By.name("RESULT_TextField-4");
		By descriptionLocator= By.id("RESULT_TextArea-5");
		Thread.sleep(3000);
		By fileUploadLocator= By.xpath("//input[@class='file_upload']");
		By firstNameLocator= By.id("RESULT_TextField-8");
		By lastNameLocator= By.id("RESULT_TextField-9");
		By streetAddLn1Locator= By.id("RESULT_TextField-10");
		By streetAddLn2Locator= By.id("RESULT_TextField-11");
		By cityLocator= By.id("RESULT_TextField-12");
		By stateLocator= By.name("RESULT_RadioButton-13");
		By zipCodeLocator= By.id("RESULT_TextField-14");
		By phoneNumberLocator= By.id("RESULT_TextField-15");
		By emailAddLocator= By.id("RESULT_TextField-16");
		By submitButtonLocator= By.name("Submit");
		By successMsgLocator=By.xpath("//h1[text()='Thank you!']");
		
		ElementUtil util= new ElementUtil(driver);
		util.doSendkeys(proposeTitleLocator, "Automation Test");
		util.doSendkeys(locationLocator, "Orlando");
		util.doSendkeys(proposeDateLocator, "12/10/2025");
		util.doSendkeys(descriptionLocator, "This is a testing assignment");
		util.doSendkeys(fileUploadLocator, "E:\\Abc.docx");
		util.doSendkeys(firstNameLocator, "Ash");
		util.doSendkeys(lastNameLocator, "B");
		util.doSendkeys(streetAddLn1Locator, "abc");
		util.doSendkeys(streetAddLn2Locator, "xyz lane");
		util.doSendkeys(cityLocator, "Orlando");
		
		util.doSelectByVisibleText(stateLocator, "Florida");
		util.doSendkeys(zipCodeLocator, "54321");
		util.doSendkeys(phoneNumberLocator, "5555555555");
		util.doSendkeys(emailAddLocator, "pqr@gmail.com");
		Thread.sleep(2000);
		util.doClick(submitButtonLocator);
		String msg=util.doElementGetText(successMsgLocator);
		
		if(msg.contains("Thank You!")) {
			System.out.println("Form is sumitted successfully");
		}
		else {
			System.out.println("Form is not sumitted successfully");
		}
	
		driver.switchTo().defaultContent();
		
		String text =driver.findElement(By.xpath("//h2[text()='Key Features']")).getText();
		System.out.println(text);

	}

}
