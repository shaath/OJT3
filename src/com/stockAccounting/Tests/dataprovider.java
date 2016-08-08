package com.stockAccounting.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider
{
	public static WebDriver driver;
	@Test(dataProvider="data")
	public void mtest(String br, String u)
	{
		System.out.println(br+"--"+u);
		
		if (br.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\New folder\\stockAccounting\\src\\com\\stockAccounting\\Jars\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\New folder\\stockAccounting\\src\\com\\stockAccounting\\Jars\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.get(u);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
	}
	@DataProvider(parallel=true)
	public Object[][] data()
	{
		Object[][] d=new Object[3][2];
		
		d[0][0]="firefox";
		d[0][1]="http://webapp.qedgetech.com";
		
		d[1][0]="chrome";
		d[1][1]="http://webapp.qedgetech.com";
		
		d[2][0]="ie";
		d[2][1]="http://webapp.qedgetech.com";
		
		return d;
	}
}
