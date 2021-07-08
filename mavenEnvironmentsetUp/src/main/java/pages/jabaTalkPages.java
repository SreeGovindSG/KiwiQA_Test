package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

public class jabaTalkPages {


	WebDriver driver;


	@FindBy(xpath="//img[contains(@src,'images/logo')]/ancestor::div[@class='page-signin ng-scope']/descendant::div[@class='ui-select-match ng-scope']/span")
	WebElement languageButton;

	@FindBy(xpath="//img[contains(@src,'images/logo')]/ancestor::div[@class='page-signin ng-scope']/descendant::ul/li/div/a/div")
	List<WebElement> languagedropdown;

	@FindBy(xpath="//input[@id='name']")
	WebElement nameInput;

	@FindBy(xpath="//input[@id='orgName']")
	WebElement orgName;

	@FindBy(xpath="//input[@id='singUpEmail']")
	WebElement email;

	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath="//button[@type='submit']")
	WebElement signUp;

	@FindBy(xpath="//span[contains(text(),'A welcome email has been sent. Please check your email.')]")
	WebElement emailNotify;






	public jabaTalkPages(WebDriver driver){

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void validateLanguage(String lang1,String lang2) throws InterruptedException {
		languageButton.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		for(int i=0;i<languagedropdown.size();) {
			Verify.verify(lang1.contains(languagedropdown.get(i).getText()) && (lang2.contains(languagedropdown.get(i+1).getText())), "English and Dutch is present");
			break;
		}

	}

	public void fillDetails(String name,String orgdetails,String email) throws InterruptedException {
		nameInput.sendKeys(name);
		orgName.sendKeys(orgdetails);
		this.email.sendKeys(email);

		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();", checkbox);
				
		signUp.click();
		
	}

	public void validateEmailStatus() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(emailNotify));
		Verify.verify(emailNotify.getText().equals("A welcome email has been sent. Please check your email."),"Email successfully sent");
	}









}
