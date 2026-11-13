package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class Baseclass {
	public WebDriver driver;
	@Parameters("Browser")
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("Chrome")String browser) {

	    if (browser.equalsIgnoreCase("Chrome")) {
	        driver = new ChromeDriver();
	    }
	    else if (browser.equalsIgnoreCase("Edge")) {
	        driver = new EdgeDriver();
	    }

	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	}
	@AfterMethod(alwaysRun = true)
	public void teardown()
	{
		driver.quit();
	}

}
