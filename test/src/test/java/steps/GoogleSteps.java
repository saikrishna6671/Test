package steps;


import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.GooglePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class GoogleSteps {
 WebDriver driver;
 GooglePage home;
 
 
 @Given("^user is on Google Home Page$")
 public void user_is_on_Home_Page(){
 System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
 driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://www.google.com");
 }
 
 @When("^I search for \"([^\"]*)\"$")
 public void he_search_for(String searchText) throws InterruptedException  {
 home = new GooglePage(driver);
 home.perform_Search(searchText);
 }
 
 @Then("I should see results with \"([^\"]*)\"$")
 public void i_should_see_results_with(String Text) {
	 
	 
   
 }
 
 
 @And("I close the browser")
 public void closeDriver()
 {
 driver.quit();
 }
}