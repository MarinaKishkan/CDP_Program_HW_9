package cdp.epam.homework9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YahooMailTest {
	
	private static final String START_URL = "http://mail.yahoo.com";
	private static final String LOGIN = "marinakishkan";
	private static final String PASSWORD = "theProdigy77";
	private static final String TO = "marina.kishkan@gmail.com";
	private static final String SUBJECT = "Test Email";
	private static final String BODY = "New test email!";
	private WebDriver driver;
	
	@BeforeClass(description = "Start browser")
	public void startBrowser() {
			driver = new FirefoxDriver();
			driver.get(START_URL);
	}

	@Test(description = "Login")
	public void loginToYahoo() {
		
		LoginPage Login = new LoginPage(driver);
		Login.doLogin(LOGIN,PASSWORD);
		Login.addImplicitly();
		Assert.assertTrue(Login.isElementPresent(By.xpath("//b[@title='Hi, Marina']")));
				
	}
	
	@Test(description = "NewEmailCreation",dependsOnMethods = { "loginToYahoo" })
	public void newEmailCreation() {
		
		EmailPage newEmail = new EmailPage(driver);
		newEmail.startNewMailCreation();
		newEmail.addImplicitly();
		newEmail.newEmail(TO, SUBJECT,BODY);
		newEmail.goToDraft();
		Assert.assertTrue(newEmail.isTextPresent(By.id("to-field"), TO));
		Assert.assertTrue(newEmail.isTextPresent(By.id("subject-field"), SUBJECT));
		Assert.assertTrue(newEmail.isTextPresent(By.id("rtetext"), BODY));
	}
	
	@Test(description = "newEmailSent", dependsOnMethods = { "newEmailCreation" })
	public void newEmailSent() {
		
		EmailPage sentEmail = new EmailPage(driver);
		sentEmail.sendEmail();
		sentEmail.addImplicitly();
		Assert.assertTrue(sentEmail.isTextPresent(By.xpath("//p[@class='empty-folder-footer']"), "Your Drafts folder is empty"));
		sentEmail.goToSent();
		sentEmail.addImplicitly();
		Assert.assertTrue(sentEmail.isTextPresent(By.xpath("//div[@class='list-view-items-page']//span[@class='subject ']"), SUBJECT));
		
	}
	/*
	@Test(description = "logOut", dependsOnMethods = { "newEmailSent" })
	public void logOut() {
		
		EmailPage logOut = new EmailPage(driver);
		logOut.logOut();
		logOut.addImplicitly();
		Assert.assertTrue(logOut.isElementPresent(By.xpath("//em[@title='Sign In']")));
	} */
	
	@AfterClass(description = "Stop Browser")
	public void tearDown() {
		driver.close();
	}
	
	




}
