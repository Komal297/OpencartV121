package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
   {
		logger.info("*********Starting TC001_Account Registration Test***********");
		try 
		{
	   HomePage hp=new HomePage(driver);  
	   hp.clickMyAccount();
	   logger.info("clicked on My Account Link..");
	   hp.clickRegister();
	   logger.info("clicked on Register Link..");
	   AccountRegistrationPage regpage=new AccountRegistrationPage(driver); 
	
	    logger.info("Providing Customer Details....");
	   regpage.setFirstName(randomString().toUpperCase());
	   regpage.setLastName(randomString().toUpperCase());
	   regpage.setEmail(randomString()+"@gmail.com");
	   regpage.setTelephone(randomNumeric());
	  
	   String password=randomAlphanumeric();
	   regpage.setPassword(password);
	   regpage.setConfirmPassword(password);
	   regpage.setPrivacyPolicy();
	   regpage.ClickContinue();
	   logger.info("Validating expected message ...");
	  String confmsg= regpage.getConfirmationMsg();
	  
	  if(confmsg.equals("Your Account Has Been Created!"))
	  {
		  Assert.assertTrue(true);
	  }
	  else 
	  {
	         logger.error("Test Failed");
	         logger.debug("Debug Logs..");
		     Assert.assertTrue(false);
	  }
	  //Assert.assertEquals (confmsg, "Your Account Has Been Created!"); 
   }
	catch(Exception e)
	{
         Assert.fail();
	}
		   logger.info("*********Finished TC001_Account Registration Test***********");
   }
}
