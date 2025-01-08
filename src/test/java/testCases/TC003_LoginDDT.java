package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT  extends BaseClass  {
	
	@Test(dataProvider="LoginData", dataProviderClass =DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String exp)	
	{
		logger.info("*************Strating TC_003_LoginDDT*****************");
	   
		try
		{
	        	//Home Page
		     HomePage hp=new HomePage(driver);
		     hp.clickMyAccount();
		     hp.clickLogin();

	       //LoginPage
	        LoginPage lp=new LoginPage(driver);
          	lp.SetEmail(email);
	        lp.SetPassword(pwd);
	        lp.clickLogin();
	
	            //MyAccount
	      MyAccountPage macc=new MyAccountPage(driver);
	      boolean targetpage=macc.isMyAccountPageExists();
	          

/* Data is Valid  - Login Success  - test pass - logout
                          - Login Failed     - test fail
   Data is Invalid - Login Success -  test fail -logout
                           - Login Failed    - test pass       */

	
	          if(exp.equalsIgnoreCase("Valid"))
	          {
	        	  if(targetpage==true)
	        	  {
	        		  macc.clickLogout();
	        		  Assert.assertTrue(true);
	        	  }
	        	  else
	        	  {
	        		  Assert.assertTrue(false);
	        	  }
	          }
	          
	          if(exp.equalsIgnoreCase("InValid"))
	          {
	        	  if(targetpage==true)
	        	  {
	        		  macc.clickLogout();
	        		  Assert.assertTrue(false);
	        	  }
	        	  else
	        	  {
	        		  Assert.assertTrue(true);
	        	  }
	          }

        }
		catch(Exception e)
		{
			Assert.fail();
		}
        logger.info("************Finished TC003_LoginDDT************");
	}
	
}