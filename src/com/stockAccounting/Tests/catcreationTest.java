package com.stockAccounting.Tests;

import com.stockAccounting.Master.stockMaster;

public class catcreationTest {

	public static void main(String[] args)
	{
		stockMaster sm=new stockMaster();
		
		String res=sm.stockAcc_Launch(sm.url);
		System.out.println(res);
		
		res=sm.stockAcc_Login(sm.uname, sm.pwd);
		System.out.println(res);
		
		res=sm.stockAcc_stockcatCreation("Selenium");
		System.out.println(res);
		
		res=sm.stockAcc_Logout();
		System.out.println(res);
		
		sm.stockAcc_Close();

	}

}
