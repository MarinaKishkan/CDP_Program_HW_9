package cdp.epam.homework9;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	

	protected WebDriver driver;
	
	protected AbstractPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addImplicitly() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	public boolean isElementPresent (By locator) {
		driver.findElement(locator);
		return true;
	}
	
	public boolean isTextPresent(By locator, String text) {
		driver.findElement(locator).getText().contains(text);
		return true;
	}
}
