package cdp.epam.homework9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void doLogin (String login, String password) {
		driver.findElement(By.id("username")).sendKeys(login);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id(".save")).click();
	}

}