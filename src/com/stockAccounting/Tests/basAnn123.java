package com.stockAccounting.Tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class basAnn123 
{
	@Test(priority=0)
	public void function1()
	{
		System.out.println("This is function1");
	}
	@Test(priority=1)
	public void function2()
	{
//		throw new SkipException("This code coming soon");
		System.out.println("This is function2");
	}
	@Test(priority=2)
	public void a()
	{
		System.out.println("This is a function");
	}
	

}
