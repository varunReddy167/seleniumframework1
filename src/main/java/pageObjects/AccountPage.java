package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class AccountPage extends Base {
	
	  WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
  private @FindBy(linkText=	"Edit your account information")
  WebElement EditAccountInfo;
  
  public WebElement editAccountinfo()
  {
	  return EditAccountInfo;
  }
}
