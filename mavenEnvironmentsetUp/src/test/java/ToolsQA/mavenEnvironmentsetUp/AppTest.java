package ToolsQA.mavenEnvironmentsetUp;

import pages.login;
import pages.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	login log;
	mobile mob;
	WebDriverWait wait;
	@BeforeTest
	public void launchApp(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91956\\Desktop\\KiwiQA\\CodeTest\\KiwiQA_Test\\mavenEnvironmentsetUp\\server\\chromedriver.exe"); 
		driver= new ChromeDriver(); 
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		wait=new WebDriverWait(driver, 20);
	}
	
    
       @Test
       public void maincode() {
    	   log= new login(driver);
    	   mob = new mobile(driver);
    	   
    	   log.setUserName("9496149968");
    	   log.setPassword("Achan123");
    	   log.clickSubmit();
    	   WebElement search;
    	   search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title,'Search')]")));
    	   search.click();
    	   mob.search("mobile");
    	   mob.dragAnddrop();
    	   mob.selectMobile();
    	   mob.addToCart();
    	   
       }
       
       @AfterTest
       public void close() {
    	   driver.close();
       }
       
     
       
     
    
}
