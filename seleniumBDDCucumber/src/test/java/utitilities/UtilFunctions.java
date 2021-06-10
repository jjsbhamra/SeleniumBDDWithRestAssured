package utitilities;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class UtilFunctions {

	   public void pause(long milliseconds) {
	        try {
	            System.out.println("Started Waiting for :"+ milliseconds+ " milliseconds");
	            Thread.sleep(milliseconds);
	            System.out.println("Ended Waiting for :" + milliseconds + " milliseconds");
	        } catch (InterruptedException e) {
	            System.out.println("Thread Sleep Exception"+e);
	        }
	   }
	   public boolean retryElementToBeClickable(WebElement webElement) {

	        int count = 0;
	        int maxTries = 5;
	        while (true) {
	            try {
	                boolean isClickable = webElement != null && webElement.isEnabled() ? true : false;
	                if (count > 0) {
	                    System.out.println("-----------Element seems to be clickable now : -------:");
	                }
	                return isClickable;
	            } catch (StaleElementReferenceException exception) {
	                System.out.println("----------------Element not clickable , trying again : -----------Attempt:"
	                        + (count + 1));
	                pause();
	                if (++count == maxTries) {
	                    System.out.println("-----------Reached maximum attempts: Exiting---------");
	                    return false;
	                }
	            } catch (NoSuchElementException exception) {
	                System.out.println("----------------No Element found , trying again : ----------------Attempt:"
	                        + (count + 1));
	                pause();
	                if (++count == maxTries) {
	                    System.out.println("-----------Reached maximum attempts: Exiting---------");
	                    return false;
	                }
	            } catch(ElementNotVisibleException exception){
	                System.out.println("----------------Element not visible , trying again : ----------------Attempt:"
	                        + (count + 1));
	                pause();
	                if (++count == maxTries) {
	                    System.out.println("-----------Reached maximum attempts: Exiting---------");
	                    return false;
	                }
	            }

	        }

	    }
	   public void pause() {
	        try {
	            Thread.sleep(120000);
	        } catch (InterruptedException e) {
	            System.out.println("Exception in sleep"+ e);
	        }
	    }
}
