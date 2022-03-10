package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class RegPage extends Base {

	WebDriver driver;

	public RegPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(id = "input-firstname") WebElement FirstName;

	private @FindBy(id = "input-lastname") WebElement LastName;

	private @FindBy(name = "email") WebElement Email;

	private @FindBy(name = "telephone") WebElement Phone;

	private @FindBy(name = "password") WebElement Password;

	private @FindBy(name = "confirm") WebElement conPass;

	private @FindBy(name = "agree") WebElement Agree;

	private @FindBy(xpath = "//input[@type='submit']") WebElement next;

	public WebElement FirstName() {
		return FirstName;
	}

	public WebElement LastName() {
		return LastName;
	}

	public WebElement Email() {
		return Email;
	}

	public WebElement Phoneno() {
		return Phone;
	}

	public WebElement password() {
		return Password;
	}

	public WebElement confirmPass() {
		return conPass;
	}

	public WebElement Iaccept() {
		return Agree;
	}
	
	public WebElement Continue() {
		return next;
	}
}
