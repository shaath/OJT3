package com.stockAccounting.Tests;

import com.stockAccounting.Master.stockMaster;

public class stockAccsupcreaTest {

	public static void main(String[] args) 
	{
		stockMaster sm=new stockMaster();
		
		String res=sm.stockAcc_Launch(sm.url);
		System.out.println(res);
		
		res=sm.stockAcc_Login(sm.uname, sm.pwd);
		System.out.println(res);
		
		res=sm.stockAcc_SupplierCreation("Notes1", "SRnagar", "Hyderabad", "INDIA", "Sandeep G", "04022558877", "sandeep@gmail.com", "9887755887", "This supplier deliver the Notes");
		System.out.println(res);
		
		res=sm.stockAcc_Logout();
		System.out.println(res);
		
		sm.stockAcc_Close();

	}

}
