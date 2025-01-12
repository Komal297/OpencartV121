package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {

	@Test(groups={"Master"})
	public void verify_addtoCart()
	{
		logger.info("Starting TC005_AddToCartPageTest...");
		
		try 
		{
		  HomePage hp=new HomePage(driver);
		  hp.enterProductName("iPhone");
		  hp.clickSearch();
		
		   SearchPage sp=new SearchPage(driver);
		   
		   if(sp.isProductExist("iPhone"))
		   {
		   sp.selectProduct("iPhone");
		   sp.setQuantity("2");
		   sp.addToCart();
		   }
		   
		   Assert.assertEquals(sp.checkconfMsg(),true);      
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC005_AddToCartPageTest...");
	}
}
