package _LoginTestcases._LoginTestcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver;
	
	@Given("^WebDriver type$")
	public void webdriver_type() throws Throwable {
		WebDriverManager.chromedriver().setup();
	}

	@When("^Intilialised driver$")
	public void intilialised_driver() throws Throwable {
		driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("https://assignmentbucket123.s3.us-east-2.amazonaws.com/pom/Login.html");
	}
	
	
	String firstName,lastName;
	@Given("^details of username and password$")
	public void details_of_username_and_password(DataTable table) throws Throwable {
		List<List<String>> data=table.raw();
		System.out.println("first name :" +data.get(0).get(0));
		System.out.println("lastname :"+data.get(0).get(1));
		
		firstName=data.get(0).get(0);
		lastName=data.get(0).get(1);
	}

	@When("^clicked on reset button with details$")
	public void clicked_on_reset_button_with_details() throws Throwable {
		driver.findElement(By.name("userid")).sendKeys(firstName);
		driver.findElement(By.name("pwd")).sendKeys(lastName);
	//	driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	//	Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='Reset']")).click();
	}
	
	@When("^clicked on Reset button$")
	public void clicked_on_Reset_button() throws Throwable {
	//	driver.findElement(By.name("userid")).clear();
	//	driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.xpath("//input[@type='Reset']")).click();
	}

		

	@Then("^fields are check for emptiness$")
	public void fields_are_check_for_emptiness() throws Throwable {
		Assert.assertTrue(	driver.findElement(By.name("userid")).getText().isBlank());
		Assert.assertTrue(	driver.findElement(By.name("pwd")).getText().isBlank());
	}

	//to check submit button
	@Given("^\"([^\"]*)\" and \"([^\"]*)\"$")
	public void and(String userName, String password) throws Throwable {
		driver.findElement(By.name("userid")).sendKeys(userName);
		driver.findElement(By.name("pwd")).sendKeys(password);
	    
	}

	@When("^clicked on submit$")
	public void clicked_on_submit() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	String flag;
	@Then("^validation is \"([^\"]*)\"$")
	public void validation_is(String status) throws Throwable {
		//Thread.sleep(3000);
		
		
		WebDriverWait wait =new WebDriverWait(driver,3000);
		if(wait.until(ExpectedConditions.alertIsPresent())==null) {
			flag="false";
		}else flag="true";
		//
	//	System.out.println("Assertion passed ");
		System.out.println(flag);
		driver.switchTo().alert().accept();
		Assert.assertTrue(status.equalsIgnoreCase(flag));
	    
	}




	
	
}
