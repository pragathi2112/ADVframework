package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product {
	public  product(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@id=\"add-to-cart-sauce-labs-backpack\"]")
	private WebElement addtocart;
	
	@FindBy(css = "[data-test='shopping-cart-link']")
	private WebElement cartbutton;
	
	public void addproducttocart()
	{
		addtocart.click();
		cartbutton.click();
	}

}
