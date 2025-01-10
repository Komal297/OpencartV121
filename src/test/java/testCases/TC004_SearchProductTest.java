package testCases;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass 
{
	public void verify_productSearch() {
		logger.info("Starting TC004_SearchProductTest...");
		
		try 
		{
		     HomePage hp=new HomePage(driver);	
		     
		     hp.enterProductName("mac");
		     hp.clickSearch();
		     
		     SearchPage sp=new SearchPage(driver);
		     sp.isProductExist("MacBook");
		     
		     Assert.assertEquals(sp.isProductExist("MacBook"),true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC004_SearchProductTest...");
	}

}
