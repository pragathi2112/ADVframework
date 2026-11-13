package TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Baseclass;
import Generic_utility.propertyfileutility;
import POM.Login;
import POM.product;


public class Addtocart extends Baseclass {
	@Test(groups={"smoke","regression"})
	public void addtocarttest() throws Throwable
	{
	propertyfileutility putil = new propertyfileutility();
	String UN = putil.toreaddatafrompropertiesfile("Username");
	String PW = putil.toreaddatafrompropertiesfile("Password");
	System.out.println("Addtocart driver: " + driver);
	Login lp = new Login(driver);
	lp.logintoapp(UN,PW);
	Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	
	product p = new product(driver);
	p.addproducttocart();
	Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));

}
}