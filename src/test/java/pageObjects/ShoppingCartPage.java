package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
{
	//Constructor
public ShoppingCartPage(WebDriver driver)
{
	super(driver);
}

    //Locators
  @FindBy(xpath="//div[@id='cart']")
  WebElement btnItems;

  @FindBy(xpath="//strong[normalize-space()='View Cart']")
  WebElement lnkViewCart;
  


  @FindBy(xpath="//*[@id='content']/div[2]/div/table//Strong[text()='Total:']//following::td")
  WebElement lblTotalPrice;
 
  @FindBy(xpath="//a[text()='Checkout']")
  WebElement btnCheckout;
  
  //Action Method
  
  public void clickItemstoNavigatetoCart()
  {
	  btnItems.click();
  }
 
  public void clickViewCart()
  {
	  lnkViewCart.click();
  }
  
  public String getTotalPrice()
  { 
	 return lblTotalPrice.getText();  
  }
  
  public void clickOnCheckout()
  {
	  btnCheckout.click();
  }
}
