package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


import utitilities.DataReader;
import utitilities.ReadFromExcelFile;

public class LoginPage extends Page{
	//public WebDriver ldriver;
	public ReadFromExcelFile readFromExcelFile;
	public LoginPage(WebDriver rdriver) {
		//ldriver = rdriver;
		//PageFactory.initElements(rdriver, this);
		super(rdriver);
	}

	@FindBy(xpath = "//*[@id=\"consent-page\"]/div/div/div/form/div[2]/div[2]/button")
	@CacheLookup
	WebElement acceptCookiesButton;
	
	@FindBy(xpath = "//*[@id=\"ybar-inner-wrap\"]/div[3]/div/div[3]/div[1]/div/a")
	@CacheLookup
	WebElement signInforLogin;

	@FindBy(xpath = "//*[@id=\"login-username\"]")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(xpath = "//*[@id=\"login-signin\"]")
	@CacheLookup
	WebElement next;
	
	@FindBy(xpath = "//*[@id=\"login-passwd\"]")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login-signin\"]")
	@CacheLookup
	WebElement signIn;
	
	
	public void acceptCookies() {
		this.acceptCookiesButton.click();
		this.signInforLogin.click();
	}
	 
	  public void enterLoginCredentials() throws Exception {
		  DataReader xlreader = new DataReader(
					"C:\\projects\\workspace\\seleniumBDDCucumber\\Drivers\\utilities\\Credentials.xlsx");
		xlreader.getRowCount("Credentials");
// Test data from Excel using Parameterization
			String userName = xlreader.getCellData("Credentials", "username", 2);
			System.out.println(userName);
			String password = xlreader.getCellData("Credentials", "password", 2);
			System.out.println("=======");
//Send data in elements
			this.emailId.sendKeys(userName);
			this.next.click();
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
			this.password.sendKeys(password);
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
			this.signIn.click();
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
		}
	  
 }
