package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public  Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(id="user-name"),@FindBy(name="user-name")})
	private  WebElement UN;
	
	@FindBy(id="password")
	private WebElement PW;
	
	@FindBy(id="login-button")
	private WebElement Login;
	
	public void logintoapp(String Username,String Password )
	{
		UN.sendKeys(Username);
		PW.sendKeys(Password);
		Login.click();
	}
	
	
	}


