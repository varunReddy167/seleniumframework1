package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LoginPage extends Base {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	private @FindBy(name="email")
	WebElement Email;
	
	
	private @FindBy(name="password")
	WebElement Password;
	
	private @FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	public WebElement Email() {
		return Email;
	}
	public WebElement Password() {
		return Password;
	}
	
	public WebElement Loginbtn()
	{
		return login;
	}
	
}
