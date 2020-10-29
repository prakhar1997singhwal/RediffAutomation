package com.util.test;
import java.util.ArrayList;

import utils.ExcelReader;

public class TestUtil {
	static ExcelReader reader;
	public static ArrayList<Object[]> getdatafromexcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try
		{
			reader = new ExcelReader("C:\\Users\\KIIT\\eclipse-workspace\\rediff_maven_automation\\src\\main\\java\\redifftestdata\\redifftestdata.xlsx");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowCnt =2;rowCnt<=reader.getRowCount("Sheet1");rowCnt++)
		{
			String fullname = reader.getCellData("Sheet1", "fullname" , rowCnt);
			String Rediffmail_ID = reader.getCellData("Sheet1", "Rediffmail ID", rowCnt);
			String Password = reader.getCellData("Sheet1", "Password", rowCnt);
			String Alternate_email_id= reader.getCellData("Sheet1", "Alternate Emaid-ID", rowCnt);
			String Mobile_no= reader.getCellData("Sheet1", "Mobile no", rowCnt);
			Object obj[] = {fullname,Rediffmail_ID,Password,Alternate_email_id,Mobile_no};
			mydata.add(obj);
		}
		return mydata;
	}

}
