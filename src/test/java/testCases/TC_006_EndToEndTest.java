package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_EndToEndTest extends BaseClass {
	
	@Test(groups= {"Master"})
	public void endtoendTest() throws InterruptedException
	{
		SoftAssert mysoftassert=new SoftAssert();
		
		
      //Account Registration
       System.out.println("Account Registration................");
		
       HomePage hp=new HomePage(driver);
       hp.clickMyAccount();
       hp.clickRegister();
       
       AccountRegistrationPage accreg=new AccountRegistrationPage(driver);
       accreg.setFirstName(randomString().toUpperCase());
       accreg.setLastName(randomString().toUpperCase());
       
       String email=randomString()+"@gmail.com";
       accreg.setEmail(email);// randomly generated the email
       
       accreg.setTelephone("1234567");
       accreg.setPassword("test123");
       accreg.setConfirmPassword("test123");
       accreg.setPrivacyPolicy();
       accreg.ClickContinue();
       Thread.sleep(2000);
   	
       String confmsg=accreg.getConfirmationMsg();
       System.out.println(confmsg);

       mysoftassert.assertEquals(confmsg, "Your Account Has Been Created!"); //Validation
		
       //MyAccount Page
       MyAccountPage macc=new MyAccountPage(driver);
       macc.clickLogout();
       Thread.sleep(2000);
       
       //Login
       System.out.println("Login to Application");
       
       hp.clickMyAccount();
       hp.clickLogin();
       
       //Login Page
       LoginPage lp=new LoginPage(driver);
       lp.SetEmail(email);
       lp.SetPassword("test123");
       lp.clickLogin();
       
       System.out.println("Going to My Account PAGE ?"+macc.isMyAccountPageExists());
       mysoftassert.assertEquals(macc.isMyAccountPageExists(),true);
	
	
     	//search & add product to cart
       System.out.println("search & add product to cart...............");
	    hp.enterProductName(p.getProperty("searchproductname"));
	    hp.clickSearch();
	
	    //Search Page    
	    SearchPage sp=new SearchPage(driver);
	   if(sp.isProductExist(p.getProperty("searchproductname")))
			   {
		         sp.selectProduct(p.getProperty("searchproductname"));
			     sp.setQuantity("2");
		         sp.addToCart();
			   }
	   Thread.sleep(2000);
	   System.out.println("Added product to cart ? "+ sp.checkconfMsg());
	   
	   mysoftassert.assertEquals(sp.checkconfMsg(),true);
	   
	   //Shopping Cart
	   System.out.println("Shopping cart...............");
	   ShoppingCartPage sc=new ShoppingCartPage(driver);
       sc.clickItemstoNavigatetoCart();
       sc.clickViewCart();
       Thread.sleep(3000);
       
       String totalprice=sc.getTotalPrice();
       System.out.println();
       System.out.println("total price is shopping cart: "+totalprice);
       mysoftassert.assertEquals(totalprice, "$246.40");   //validation
	    
       sc.clickOnCheckout();
       Thread.sleep(3000);
       
     //Checkout Product
   	System.out.println("Checkout Product...............");
   	
   	CheckoutPage ch=new CheckoutPage(driver);
   	ch.setfirstName(randomString().toUpperCase());
   	Thread.sleep(1000);
   	ch.setlastName(randomString().toUpperCase());
   	Thread.sleep(1000);
   	ch.setaddress1("address1");
	Thread.sleep(1000);
	ch.setaddress2("address2");
	Thread.sleep(1000);
	ch.setcity("Delhi");
	Thread.sleep(1000);
	ch.setpin("500070");
	Thread.sleep(1000);
	ch.setCountry("India");
	Thread.sleep(1000);
	ch.setState("Delhi");
	ch.clickOnContinueAfterBillingAddress();
	Thread.sleep(1000);
	ch.clickOnContinueAfterDeliveryAddress();
	Thread.sleep(1000);
	ch.setDeliveryMethodComment("testing...");
	Thread.sleep(1000);
	ch.clickOnContinueAfterDeliveryMethod();
	Thread.sleep(1000);
	ch.selectTermsAndConditions();
	Thread.sleep(1000);
	ch.clickOnContinueAfterPaymentMethod();
	Thread.sleep(2000);
	
	String total_price_inOrderPage=ch.getTotalPriceBeforeConfOrder();
			System.out.println("total price in confirmed order page:"+total_price_inOrderPage);
			mysoftassert.assertEquals(total_price_inOrderPage, "$207.00"); //validation

    //Below code works only if you configure SMTP for emails 
	/*ch.clickOnConfirmOrder();
	Thread.sleep(3000);
				
	boolean orderconf=ch.isOrderPlaced();
    System.out.println("Is Order Placed? "+orderconf);
			mysoftassert.assertEquals(ch.isOrderPlaced(),true);*/
				
		//	mysoftassert.assertAll(); //conclusion

			
	}
	

}
