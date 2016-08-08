package com.stockAccounting.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stockAccounting.Master.testngstockAccMaster;

public class stockAccUomCre extends testngstockAccMaster
{
	@Test(dataProvider="data")
	public void UomCrea(String Uid1,String Udesc1)
	{
		WebElement sitem=driver.findElement(By.linkText("Stock Items"));
		
		Actions act=new Actions(driver);
		act.moveToElement(sitem).build().perform();
		
		driver.findElement(By.linkText("Unit of Measurement")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_UOM_ID")).sendKeys(Uid1);
		driver.findElement(By.id("x_UOM_Description")).sendKeys(Udesc1);
		driver.findElement(By.id("btnAction")).click();
		Sleeper.sleepTightInSeconds(10);
		List<WebElement> button=driver.findElements(By.tagName("button"));
		System.out.println(button.size());
		for (int i = 0; i < button.size(); i++) 
		{
			String text=button.get(i).getText();
			
			if (text.equalsIgnoreCase("OK!"))
			{
				button.get(i).click();
				break;
			}
			
		}
		String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
//		System.out.println(actval);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		Sleeper.sleepTightInSeconds(5);
		String count=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[2]/form/div[2]/span[2]")).getText();
		String[] split=count.split(" ");
//		System.out.println(split.length);
		int count1=Integer.parseInt(split[2]);
		int pcount=0;
		boolean flag=false;
		System.out.println(split[0]+"--"+split[1]+"--"+split[2]);
		do 
		{
			List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='tbl_a_unit_of_measurementlist']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) 
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				String acttext=cols.get(2).getText();
//				System.out.println(acttext);
				if (acttext.equalsIgnoreCase(Uid)) 
				{
					System.out.println("category available");
					flag=true;
					break;
				}
			
			}
			if (flag==false) 
			{
				driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
			}
			pcount++;
			
		} 
		while (pcount<=count1);
		Assert.assertEquals(flag, true);
	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] d=new Object[2][2];
		
		
		d[0][0]="Generator123";
		d[0][1]="This is generator";
		
		
		d[1][0]="Generator123456";
		d[1][1]="This is generator";
		
		return d;
	}
}
