package com.stockAccounting.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stockAccounting.Master.stockMaster;

public class uomdatadrivenxl 
{
	public static void main(String[] args) throws IOException 
	{
		stockMaster sm=new stockMaster();
		String xlpath="E:\\New folder\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\UOMdata.xlsx";
		String xlres="E:\\New folder\\stockAccounting\\src\\com\\stockAccounting\\Results\\uomresult.xlsx";
		FileInputStream fi=new FileInputStream(xlpath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("UOMDATA");
//		XSSFRow R=ws.getRow(3);
//		XSSFCell C=R.getCell(0);
//		
//		System.out.println(C.getStringCellValue());
		
		int RC=ws.getLastRowNum();
		sm.stockAcc_Launch(sm.url);
		sm.stockAcc_Login(sm.uname, sm.pwd);
		for (int i = 1; i <= RC; i++) 
		{
			XSSFRow R=ws.getRow(i);
			XSSFCell C=R.getCell(0);
			XSSFCell C1=R.getCell(1);
			
			XSSFCell C2=R.createCell(2);
			
			String Uid=C.getStringCellValue();
			String Udesc=C1.getStringCellValue();
			
			System.out.println(Uid+"-----"+Udesc);
			String res=sm.stockAcc_UnitofMcreation(Uid, Udesc);
			C2.setCellValue(res);
			
		}
		
		FileOutputStream fo=new FileOutputStream(xlres);
		wb.write(fo);
		wb.close();
		sm.stockAcc_Logout();
		sm.stockAcc_Close();
		
	}

}
