package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Logintest extends Base {
	
	 public WebDriver	driver;
	
   Logger log;
	
	@Test(dataProvider="getloginData")
	public void login(String email,String password,String status) throws IOException {
		
			
		LandingPage lp=new LandingPage(driver);
		lp.MyAccount().click();
		log.debug("Clicked on My Account dropdown");
		lp.Login().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Email().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.Password().sendKeys(password);
		log.debug("Password got entered");
		loginPage.Loginbtn().click();
		log.debug("Clicked on Login Button");
		
		AccountPage ap= new AccountPage(driver);
	 
		String actualresult= null;
		try {
			if(ap.editAccountinfo().isDisplayed())
				log.debug("User got logged in");
			
				actualresult= "success";
			
		}catch(Exception e)
		
		{
		
				actualresult="failure";
				log.debug("User didn't log in");
		}
		Assert.assertEquals(actualresult, status);
		}
		
	@BeforeMethod
	public void setup() throws IOException {
		 log = LogManager.getLogger(Logintest.class.getName());
			
			driver=initializeDriver();
			log.debug("Browser got launched");
			driver.get(prop.getProperty("url"));
			log.debug("Navigated to application URL");
	}
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getloginData()
	{
		Object[][] data= {{"varunreddy1048@gmail.com","Vtu#7975","success"},{"varun@gmail.com","varun","failure"}};
		return data;
	}

}
