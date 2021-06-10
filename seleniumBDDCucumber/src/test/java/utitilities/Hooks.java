
 package utitilities;

import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;*/

import pageObjects.Page;
public class Hooks extends Page{
	public Hooks(WebDriver rdriver) {
		//ldriver = rdriver;
		//PageFactory.initElements(rdriver, this);
		super(rdriver);
		}
		
		/*
		 * @BeforeClass(alwaysRun = true) public void init() {
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\browserdrivers\\chromedriver.exe"); WebDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize(); }
		 * 
		 * @AfterClass() public void closeBrowser() { this.ldriver.close(); }
		 */
}