package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.ExcelDrivenTest;
import pageObjects.LoginPage;
import pageObjects.Page;
import pageObjects.YahooFinance;
//import utitilities.Hooks;
import utitilities.UtilFunctions;

public class Steps {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public Page page;
	public ExcelDrivenTest excelDrivenTest;
	public UtilFunctions utilFunctions;
	public YahooFinance yahooFinace;

	@Given("^User Launch Browser$")
	public void User_Launch_Browser() {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		 this.driver.manage().window().maximize();
		loginPage=new LoginPage(driver);
		yahooFinace = new YahooFinance(driver);
	}
	@When("^User Open URL \"(.*)\"$")
	public void User_Open_URL(String url) {
		driver.get(url);
	}
	@And("^User accept cookies and click on SignIn button$")
	public void User_accept_cookies_and_click_on_SignIn_button() {
		loginPage.acceptCookies();
	}

	@And("^Enter login credentials$")
	public void Enter_login_credentials() throws Exception {
		loginPage.enterLoginCredentials();
	}
	
	@And("^Click on finance tab$")
	public void Click_on_finance_tab() throws Exception{
		yahooFinace.clickOnFinanceTab();
	}
	@And("^Click on Market tab$")
	public void Click_on_Market_tab() throws Exception {
		yahooFinace.clickOnMarketTab();
	}
	@And("^Click on Celander tab$")
	public void Click_on_Celander_tab() throws Exception {
		yahooFinace.getValuesfromFields();
	}

}
