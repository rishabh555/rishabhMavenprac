package com.rbhprac.testscript;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rbhprac.generics.BaseClass;
import com.rbhprac.generics.WebDriverCommonLib;

@Listeners(com.rbhprac.generics.ListenersImplementation.class)
public class TestScriptClass3 extends BaseClass {
	WebDriverCommonLib wlib = new WebDriverCommonLib();
	
	@Test
	public  void doSomethingClass3() throws IOException, InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver.get();
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(2000);
		wlib.waitForElement(driver.get(), driver.get().findElement(By.xpath("//a[text()='About us']")));
		driver.get().findElement(By.xpath("//a[text()='About us']")).click();
		//Thread.sleep(2000);
		
		Assert.assertEquals(true, false);
		/*
		 * Set<String> set = driver.getWindowHandles(); Iterator<String> itr =
		 * set.iterator();
		 * 
		 * driver.switchTo().window(itr.next()); Thread.sleep(5000);
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().window(itr.next()); Thread.sleep(5000);
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().defaultContent();
		 */
		 
	}
}