package com.stockAccounting.Master;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class testngmaster 
{
	public static WebDriver driver;
	public static String expval,actval;
	public static String url="http://webapp.qedgetech.com";
	public static String u="admin",p="master";
	@BeforeSuite
	public void stock_Launch()
	{
		
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actval=driver.findElement(By.id("btnsubmit")).getAttribute("id");
		Assert.assertEquals(actval, expval,"Launch App Failed");
	}
	
	
	
	

}
