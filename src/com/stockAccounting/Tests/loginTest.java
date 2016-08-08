package com.stockAccounting.Tests;

import com.stockAccounting.Master.stockMaster;

public class loginTest {

	public static void main(String[] args)
	{
		stockMaster sm=new stockMaster();
		
		String res=sm.stockAcc_Launch(sm.url);
		System.out.println(res);
		
		res=sm.stockAcc_Login(sm.uname, sm.pwd);
		System.out.println(res);
		
//		res=sm.stockAcc_SupplierCreation("Bawarchi123", "kachigudda", "Hyderabad", "India", "Venki", "040778899", "w@gmail.com", "9948256256", "This supplier will supply Biryani");
//		System.out.println(res);
		
//		res=sm.stockAcc_stockcatCreation("Biryaniwala123");
//		System.out.println(res);
		
		res=sm.stockAcc_UnitofMcreation("Quintal", "100 kgs");
		System.out.println(res);
		
		res=sm.stockAcc_Logout();
		System.out.println(res);
		
		sm.stockAcc_Close();
	}

}
