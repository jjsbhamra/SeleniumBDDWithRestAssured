package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import utitilities.Hooks;
import utitilities.ReadFromExcelFile;

public class YahooFinance extends Page{
	
	public Hooks hooks;
	public ReadFromExcelFile readFromExcelFile;
	public YahooFinance(WebDriver rdriver) {
		//ldriver = rdriver;
		//PageFactory.initElements(rdriver, this);
		super(rdriver);
	}

	@FindBy(id = "root_5")
	@CacheLookup
	WebElement financeTab;
	
	@FindBy(xpath = "//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/nav/ul/li[2]/div")
	@CacheLookup
	WebElement marketTab;
	
	@FindBy(xpath = "//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/nav/ul/li[2]/div[2]/ul/li[2]/a")
	@CacheLookup
	WebElement celanderTab;
	
	@FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/a[1]")
	@CacheLookup
	WebElement previousWeek;
	
 
		public void clickOnFinanceTab() throws Exception{
			this.financeTab.click();
			System.out.println("Financial tab selected");
		}
		public void clickOnMarketTab() throws Exception{
			Actions actions = new Actions(ldriver);
			WebElement menuOption = ldriver.findElement(By.xpath(".//div[contains(text(),'Market Data')]"));
	    	actions.moveToElement(menuOption).build().perform();
	    	//ldriver.findElement(By.linkText ("Calendar")).click();
	    	System.out.println("Market Data hover from Menu");
	    	this.celanderTab.click();
	    	try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }

		}
		public void getValuesfromFields() throws Exception{
	    	this.previousWeek.click();
	    	try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
			System.out.println("Third June Earnings: " + ldriver.findElement(By.xpath("//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/a[1]")).getText());
			System.out.println("Third June Stock Split: " + ldriver.findElement(By.xpath("//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/a[2]")).getText());
			System.out.println("Third June IPO Pricing: " + ldriver.findElement(By.xpath("//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/a[3]")).getText());
			System.out.println("Third June Economic Events: " + ldriver.findElement(By.xpath("//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/a[4]")).getText());
			ldriver.close();
			System.out.println("Browser is closed");
		}
		
 }
