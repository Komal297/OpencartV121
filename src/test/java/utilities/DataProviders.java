package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
           //Data provider 1
	@DataProvider(name="LoginData")
	public String[][]  getData () throws IOException 
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData Folder

		ExcelUtility xlutill=new ExcelUtility(path);         //Creating an Object for XLUtility
		
		int totalrows=xlutill.getRowCount("Sheet1");
		int totalcolumns=xlutill.getCellCount("Sheet1",1);
		
		String loginData[][] =new String [totalrows][totalcolumns]; //Created for two dimension array which can store Excel data in  array
		
		for(int i=1;i<=totalrows;i++)  //1 //Read the data from excel storing in two dimensional Array -row start from 1
		{
			for(int j=0;j<totalcolumns;j++)   // 0         "i" is rows "j" is column       -column start from 0
			{
				loginData[i-1][j]=xlutill.getCellData("Sheet1",i,j); //1,0
			}
		}
		return loginData; // Returning Two Dimensional Array
		
	}
	
	
    //Data provider 2
    //Data provider 3
    //Data provider 4
}
