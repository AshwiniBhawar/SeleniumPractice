package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptPopUpAlertHandle {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
        //driver.switchTo().alert();//NoAlertPresentException: no such alert

		//js pop up: alert, prompt, confirm
		//Alert API
		
		//1. alert:
//		driver.findElement(By.xpath("//button[@onClick='jsAlert()']")).click();
//		Thread.sleep(2000);
//		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().accept();								//click on ok button
//		String msg=driver.findElement(By.id("result")).getText();
//		if(msg.contains("You successfully clicked an alert")) {
//			System.out.println("Alert is successfully handled");
//		}
		
//		driver.findElement(By.xpath("//button[@onClick='jsConfirm()']")).click();
//		Thread.sleep(2000);
//		Alert alert= driver.switchTo().alert();
//		System.out.println(driver.switchTo().alert().getText());
//		alert.accept();
//		String msg=driver.findElement(By.id("result")).getText();
//		if(msg.contains("You clicked: Ok")) {
//			System.out.println("Alert is successfully handled");
//		}
		
//		driver.findElement(By.xpath("//button[@onClick='jsConfirm()']")).click();
//		Thread.sleep(2000);
//		Alert alert= driver.switchTo().alert();
//		System.out.println(driver.switchTo().alert().getText());
//		alert.dismiss();												//click on cancel button
//		String msg=driver.findElement(By.id("result")).getText();
//		if(msg.contains("You clicked: Cancel")) {
//			System.out.println("Alert is successfully handled");
//		}
		
//		driver.findElement(By.xpath("//button[@onClick='jsPrompt()']")).click();
//		Thread.sleep(2000);
//		Alert alert= driver.switchTo().alert();
//		System.out.println(driver.switchTo().alert().getText());
//		String sendMsg="Hi, This is an alert window";
//		alert.sendKeys(sendMsg);
//		alert.accept();
//		String msg=driver.findElement(By.id("result")).getText();
//		if(msg.contains("You entered: "+sendMsg)) {
//			System.out.println(msg);
//			System.out.println("Alert is successfully handled");
//		}
		
		driver.findElement(By.xpath("//button[@onClick='jsPrompt()']")).click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		String sendMsg="Hi, This is an alert window";
		alert.sendKeys(sendMsg);
		alert.dismiss();
		String msg=driver.findElement(By.id("result")).getText();
		if(msg.contains("You entered: null")) {
			System.out.println(msg);
			System.out.println("Alert is successfully handled");
		}
		
		
	}

}
