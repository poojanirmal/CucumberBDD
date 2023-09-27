package com.qa.automation.stepdefs;



import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepdefs {
	
	
	
	WebDriver driver;
	String baseURL = "https://www.amazon.in/";
	Scenario scn;
	
	@Before
	public void setUp(Scenario scn)
	{
		this.scn = scn;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\Selenium\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\LENOVO\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(opt);
		scn.log("browser get launch");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@After
	public void cleanUp()
	{
		driver.quit();
		scn.log("browser get closed");
	}

	

	@Given("user navigate to the Home Application URl")
	public void user_navigate_to_the_home_application_u_rl() 
	{
	    driver.get(baseURL);
	    scn.log("navigate to the url -> "+ baseURL);
	    String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	    String actualTitle = driver.getTitle();
	    Assert.assertEquals("The title of home page is get naot matched",expectedTitle, actualTitle);
	}

	@When("user search for product {string}")
	public void user_search_for_product(String productName)
	{
	    WebElement searchBoxEle = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	    
	    WebDriverWait wait = new WebDriverWait(driver,15);
	    wait.until(ExpectedConditions.elementToBeClickable(searchBoxEle));
	    searchBoxEle.sendKeys(productName);
	    scn.log("searching for a product -> "+ productName);
	    
	    WebElement searchBtnEle = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
	    searchBtnEle.click();
	}
	
	@Then("search result page is displayed with page title keywored contains {string}")
	public void search_result_page_is_displayed_with_page_title_keywored_contains(String titleProdNameKeyword) 
	{
		String expectedTitle = "Amazon.in : "+titleProdNameKeyword;
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		    wait.until(ExpectedConditions.titleContains(titleProdNameKeyword));
		    Assert.assertEquals(expectedTitle, driver.getTitle());
		
	}

	


	
}
