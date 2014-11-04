package cdp.epam.homework9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class EmailPage extends MailboxHomePage {
	
	public EmailPage (WebDriver driver) {
		super(driver);
	}
	
	public void newEmail (String to, String subject, String body) {
		driver.findElement(By.id("to-field")).sendKeys(to);
		driver.findElement(By.id("subject-field")).sendKeys(subject);
		driver.findElement(By.id("rtetext")).sendKeys(body);
		driver.findElement(By.xpath("//a[@class='icon icon-close']")).click();
		driver.findElement(By.id("SaveDraftModalOverlay")).click();
	}
	
	public void sendEmail() {
		driver.findElement(By.xpath("//div[@class='tab-content']//div[@class='bottomToolbar']//a[text()='Send']")).click();
		
	}
	
	
}
////span[@class='btn default']
//a[@title='Send this email [Ctrl+Enter]']
//div[@class='bottomNotification']
////td[@class='footer-separator']//a[@title='Send this email [Ctrl+Enter]']