package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {

	WebDriver driver;
	@FindBy(xpath="//label/ancestor::div/input[@type='text']")
    WebElement userName;
    
    @FindBy(xpath="//label/ancestor::div/input[@type='password']")
    WebElement passwrd;
    
    @FindBy(xpath="//span/parent::button[@type='submit']")
    WebElement submit;
    
    public login(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
    
    public void setUserName(String strUserName){

    	userName.sendKeys(strUserName);     
    }
    
    public void setPassword(String strPassword){

    	passwrd.sendKeys(strPassword);

        }
    
    public void clickSubmit(){

        submit.click();

}

	

    
    
}
