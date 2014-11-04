package cdp.epam.homework9;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class MailboxHomePage extends AbstractPage {
	
	public MailboxHomePage (WebDriver driver) {
		super(driver);
	}
	
	public void  startNewMailCreation() {
		driver.findElement(By.id("Compose")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void goToDraft() {
		driver.findElement(By.id("Draft")).click();
		driver.findElement(By.xpath("//div[@class='list-view-items-page']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public void goToSent() {
		driver.findElement(By.id("Sent")).click();
	}
	
	//doesn't work:(
	public void logOut() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//b[@title='Hi, Marina']"))).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='js-Tooltip-Wrapper Pos-r']//a[@id='yucs-signout']")).click();
		
			
	}

}
