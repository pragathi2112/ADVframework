package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import Base.Baseclass;
import Generic_utility.propertyfileutility;
import POM.Login;


public class Logintest extends Baseclass{
	@Test(groups="smoke")
	public void logintest() throws Throwable
	{
		propertyfileutility putil = new propertyfileutility();
		String UN = putil.toreaddatafrompropertiesfile("Username");
		String PW = putil.toreaddatafrompropertiesfile("Password");
		Login lp = new Login(driver);
		lp.logintoapp(UN,PW);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}



}
