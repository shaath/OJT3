package com.stockAccounting.Tests;

import com.stockAccounting.Master.stockMaster;

public class ltest 
{

	public static void main(String[] args) 
	{
		stockMaster sm=new stockMaster();
		//login test
		String res=sm.stockAcc_Launch("http://webapp.qedgetech.com");
		System.out.println(res);
		
		res=sm.stockAcc_Login("admin", "master");
		System.out.println(res);
		
		res=sm.stockAcc_Logout();
		System.out.println(res);
		
		sm.stockAcc_Close();
		
		
		//supplier creation
		res=sm.stockAcc_Launch("http://webapp.qedgetech.com");
		System.out.println(res);
		
		res=sm.stockAcc_Login("admin", "master");
		System.out.println(res);
		
//		res=sm.stockAcc_SupplierCreation(supname, add, city, cntry, cperson, pno, email, mno, notes)
//		System.out.println(res);
		
		res=sm.stockAcc_Logout();
		System.out.println(res);
		
		sm.stockAcc_Close();
		
	}

}
