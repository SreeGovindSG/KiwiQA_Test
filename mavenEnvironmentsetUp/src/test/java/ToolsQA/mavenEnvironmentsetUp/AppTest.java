package ToolsQA.mavenEnvironmentsetUp;

import pages.jabaTalkPages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {
	
	WebDriver driver;
	jabaTalkPages jabpage;

	@BeforeTest
	public void launchApp(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91956\\Desktop\\KiwiQA\\CodeTest\\KiwiQA_Test\\mavenEnvironmentsetUp\\server\\chromedriver.exe"); 
		driver= new ChromeDriver(); 
		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

	}


	@Test(dataProvider="webSiteData")
	public void maincode(HashMap<String,String> hashMapValue) throws InterruptedException {

		jabpage= new jabaTalkPages(driver);
		jabpage.validateLanguage(hashMapValue.get("lang1"),hashMapValue.get("lang2"));
		jabpage.fillDetails(hashMapValue.get("name"),hashMapValue.get("org"),hashMapValue.get("email"));
		jabpage.validateEmailStatus();
	}



	@DataProvider
	public Object[][] webSiteData()
	{
		List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hashMapItems = new HashMap<String, String>();

		hashMapItems.put("lang1", "English");
		hashMapItems.put("lang2", "Dutch");
		hashMapItems.put("name", "abc");
		hashMapItems.put("org", "xyz Ltd");
		hashMapItems.put("email", "qwerty@gmail.com");
		
		arrayMapList.add(hashMapItems);

		Object [][] hashMapObj = new Object [arrayMapList.size()][1];

		for(int i=0; i<arrayMapList.size() ; i++) {
			hashMapObj[i][0] = arrayMapList.get(i);
		}

		return hashMapObj;
	}

	@AfterTest
	public void close() {
		driver.close();
	}


}
