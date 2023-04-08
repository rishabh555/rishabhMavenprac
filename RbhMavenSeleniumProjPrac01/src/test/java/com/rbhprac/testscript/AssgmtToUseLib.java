package com.rbhprac.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import com.rbhprac.generics.FileLib;

//@Listeners(com.rbhprac.testscript.ListenersImplementation.class)
public class AssgmtToUseLib {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	FileLib f=new FileLib();
	
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get(f.getPropertyValue("url"));
	driver.findElement(By.id("username")).sendKeys(f.getPropertyValue("username"));
	driver.findElement(By.name("pwd")).sendKeys(f.getPropertyValue("password"));
	driver.findElement(By.xpath("//div[.='Login ']")).click();
	
	driver.findElement(By.xpath("//span[.='New']")).click();	
	Thread.sleep(6000);
	//driver.findElement(By.xpath("//div[.='- Select Customer -' and @class='emptySelection']")).click();
	driver.findElement(By.xpath("//tr[@class='selectCustomerRow'][1]//div[@class='dropdownButton'][1]")).click();
	
		
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[.='- New Customer -']")).click();	
	
	FileLib flib = new FileLib();
	
	driver.findElement(By.xpath("//input[@placeholder='Enter Customer Name']")).sendKeys(flib.getExcelValue("Create Customer", 1, 0));
	
	driver.findElement(By.xpath("//input[@placeholder='Enter Project Name']")).sendKeys(flib.getExcelValue("Create Customer", 1, 1));
	
	driver.findElement(By.xpath("//input[@placeholder='Enter task name']"))
	.sendKeys(flib.getExcelValue("Create Customer", 1, 2));
	
	
	driver.findElement(By.xpath("//div[.='Create Tasks']")).click();
	
	}}
	
	//Continuous change in xpth for Enter task name field
	//div[.='Select Customer and Project to Add Tasks for']/../../../div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input
	//div[.='Select Customer and Project to Add Tasks for']/../../div[3]/table/tbody/tr[1]/td[1]/input
