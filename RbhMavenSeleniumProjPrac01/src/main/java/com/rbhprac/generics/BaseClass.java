package com.rbhprac.generics;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver.exe");
	}
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	@BeforeClass
	public void openBrowser() {
		Reporter.log("openBrowser",true);
		driver.set(new ChromeDriver());
		
	}
	@BeforeMethod
	public void login(Method method) throws IOException, InterruptedException {
		
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		FileLib f=new FileLib();
		String URL = f.getPropertyValue("url");
		String UN = f.getPropertyValue("username");
		String PW = f.getPropertyValue("password");
		Reporter.log("login",true);
		

		driver.get().get(URL);
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get().manage().window().maximize();
		
		wlib.waitForElement(driver.get(), driver.get().findElement(By.id("usernameField")));
		driver.get().findElement(By.id("usernameField")).sendKeys(UN);
		driver.get().findElement(By.id("passwordField")).sendKeys(PW);
		Thread.sleep(2000);
		driver.get().findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Method exection is started where method name is = "+method.getName());
		
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("logout",true);
		Thread.sleep(8000);
		driver.get().findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
		Thread.sleep(5000);
		driver.get().findElement(By.xpath("//a[@title=\"Logout\"]")).click();
				
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.get().quit();
	}
} 
