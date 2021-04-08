package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
	 
	public class GooglePage {
	 
	 WebDriver driver;
	 
	 	 public GooglePage(WebDriver driver) {
	 this.driver=driver;
	 }
	 
	 	
	 By SearchField = By.xpath("//input[@type='text']");
	 By SearchResult= By.xpath("//*[@id='wp-tabs-container']/div[1]/div[2]/div/div/div/div[2]/h2/span");
	 
	 
	 public void perform_Search(String sSearchText) throws InterruptedException {
	 driver.findElement(SearchField).sendKeys(sSearchText);
	 driver.findElement(SearchField).submit();
	 Thread.sleep(2);
	 }
	 public void ValidateTheTextPresent(String ValidationResult) throws InterruptedException {
		 Assert.assertEquals(ValidationResult, driver.findElement(SearchResult).getText());
		
		 Thread.sleep(2);
		
	 }	 
	}


