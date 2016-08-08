package com.stockAccounting.Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class webtable {

	public static void main(String[] args)
	{
		int count=0;
		boolean flag=false;
		WebDriver driver=new FirefoxDriver();
		driver.get("http://webapp.qedgetech.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		
		WebElement sitem=driver.findElement(By.linkText("Stock Items"));
		
		Actions act=new Actions(driver);
		act.moveToElement(sitem).build().perform();
		
		driver.findElement(By.linkText("Stock Categories")).click();
		
		String page=driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/span[2]")).getText();
		String[] split=page.split(" ");
		
		int pNo=Integer.parseInt(split[2]);
		
//		List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='tbl_a_stock_categorieslist']/tbody/tr"));
//		for (int i = 0; i < rows.size(); i++)
//		{
//			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
//			String text=cols.get(2).getText();
//			System.out.println(text);
// 		}
		
		while (pNo >= count) 
		{
			List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='tbl_a_stock_categorieslist']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++)
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				String text=cols.get(2).getText();
				System.out.println(text);
				if (text.equalsIgnoreCase("62"))
				{
					flag=true;
					break;
				}
	 		}
			if (flag) 
			{
				break;
			}
			driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
			count++;
		}
	}

}
