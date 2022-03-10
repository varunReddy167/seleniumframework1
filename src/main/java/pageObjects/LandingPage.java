package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LandingPage extends Base {

	WebDriver driver;
	
	public  LandingPage(WebDriver driver)
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
 
  private 	@FindBy(xpath="//span[text()='My Account']")
  WebElement Account;
  
  private @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[1]")
  WebElement Register;
	
  private @FindBy(linkText="Login") WebElement Login;
	public WebElement MyAccount() {
		return Account;
	}
	
	public WebElement Register()
	{
		return Register;
	}
	
	public WebElement Login()
	{
		return Login;
	}
}
