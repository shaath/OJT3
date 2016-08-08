package com.stockAccounting.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class calandar {

	public static void main(String[] args) 
	{
		String date="30/may/2018";
		String[] datesplit=date.split("/");
		String day=datesplit[0];
		String month=datesplit[1];
		String year=datesplit[2];
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.cleartrip.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("DepartDate")).click();
		
		
		String calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
		
		while (!calyear.equals(year))
		{
			driver.findElement(By.className("nextMonth ")).click();
			calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		
		String calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
		
		while (!calmonth.equalsIgnoreCase(month))
		{
			driver.findElement(By.className("nextMonth ")).click();
			calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
		}
		
		List<WebElement> cols=driver.findElements(By.xpath(".//div[@class='monthBlock first']/table/tbody/tr/td"));
		
		for (int i = 0; i < cols.size(); i++) 
		{
			String calday=cols.get(i).getText();
			if (calday.equals(day)) 
			{
				cols.get(i).click();
				break;
				
			}
			
		}

	}

}
