package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
	               	logger.info("***********Starting TC002_LoginTest************");
                       try {
		           // HomePage
	            	HomePage hp = new HomePage(driver);
	             	hp.clickMyAccount();
	            	hp.clickLogin();

		          // LoginPage
		          LoginPage lp = new LoginPage(driver);
	                lp.SetEmail(p.getProperty("email"));
         	    	lp.SetPassword(p.getProperty("password"));
         	    	lp.clickLogin();
         	    	
         	   //MyAccount
         	    	MyAccountPage macc=new MyAccountPage(driver);
         	    	boolean targetpage=macc.isMyAccountPageExists();
                   Assert.assertTrue(targetpage); // Assert.assertEquals(targetpage,true,"Login Failed");
                  logger.info("*********Finished TC002_LoginTest*********");
	}
                       catch(Exception e)
                       {
                    	   Assert.fail();
                       }
}
}
