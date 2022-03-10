package stepdefinitations;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginSteps extends Base {

	LoginPage loginPage;
	AccountPage ap;
	LandingPage lp;

	@Given("Open any Browser")
	public void open_any_browser() throws IOException {
		Base.initializeDriver();
	}

	@Given("Navigate to Login page")
	public void navigate_to_login_page() throws InterruptedException {

		driver.get(prop.getProperty("url"));

		Thread.sleep(3000);

		lp = new LandingPage(driver);
		lp.MyAccount().click();

		lp.Login().click();

	}

	@When("User enters username as {string} and password as {string} into the fields")
	public void user_enters_username_as_and_password_as_into_the_fields(String email, String password)
			throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.Email().sendKeys(email);

		loginPage.Password().sendKeys(password);

	
		Thread.sleep(3000);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {

		Thread.sleep(3000);

		loginPage.Loginbtn().click();

	}

	@Then("Verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {
		ap = new AccountPage(driver);
		Assert.assertTrue(ap.editAccountinfo().isDisplayed());
	}

	@After
	public void closure() {
		driver.close();
	}
}
