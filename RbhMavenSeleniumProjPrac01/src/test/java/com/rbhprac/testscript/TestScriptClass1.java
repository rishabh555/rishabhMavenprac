package com.rbhprac.testscript;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rbhprac.generics.BaseClass;

@Listeners(com.rbhprac.generics.ListenersImplementation.class)
public class TestScriptClass1 extends BaseClass {
	
	
	@Test
	public  void doSomethingClass1() throws IOException, InterruptedException {
		
		
        		System.out.println(driver.get().getTitle());
		
        		Assert.assertEquals(true, false);
		
        		
		 
	}
}