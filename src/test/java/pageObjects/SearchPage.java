package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{
	   //Constructor
	 public SearchPage(WebDriver driver)
	 {
		 super(driver);
	 }
	 
	 
	 //Locators)
	 @FindBy(xpath="//*[@id='content']/div[3]//img")
	 List<WebElement> searchProducts;
	 
	 @FindBy(name="quantity")
	 WebElement txtquantity;
	 
	 @FindBy(xpath="//button[@id='button-cart']")
	 WebElement btnaddToCart;
	  
	 @FindBy(xpath="//div[contains(text(),'Success: You have added')]")
	 WebElement cnfMsg;
	 
	 
	 
	 //Action Method 
	 public boolean isProductExist(String ProductName)
	 {
		 boolean flag=false;
		 
		 for(WebElement product:searchProducts)
		 {
			 if(product.getAttribute("title").equals(ProductName))
			 {
				 flag=true;
			       break;	 
			 }
			 
		 }
		 return flag;

	 }
	 
	 public void selectProduct(String ProductName)
	 {
		 for(WebElement product:searchProducts)
		 {
			    if(product.getAttribute("title").equals(ProductName))
			    {
			    	product.click();
			    }
		 }
	 }
	 
	 public void setQuantity(String qty)
	 {
		 txtquantity.clear();
		 txtquantity.sendKeys(qty);
	 }
	 
	 
	 public void addToCart()
	 {
		  btnaddToCart.click();
	 }
	 
	 public boolean checkconfMsg()
	 {
	   try {
      	    return cnfMsg.isDisplayed();
	      }
	 catch(Exception e)
	 {
		return false; 
	 }
    }
}
