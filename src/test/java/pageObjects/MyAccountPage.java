package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
//Locator
	@FindBy(xpath="//h2[text()='My Account']")     //MyAccount page Heading
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")     //MyAccount page Heading
	WebElement lnklogout;
	
	//Action Method
	public boolean isMyAccountPageExists()
	{
		 try {
		         return (msgHeading.isDisplayed());
	          }
	    catch(Exception e) 
		 {
	           return false;
	     }
	}
		public void clickLogout()
	     {
			lnklogout.click();
		}

}
