package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class mobile {

	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[contains(@title,'Search')]")
    WebElement search;
    
    @FindBy(xpath="//div[@class='HQL4QS _28DFQy']/div")
    WebElement dragFromRange;
    
    @FindBy(xpath="//div[@class='HQL4QS WC_zGJ']/div")
    WebElement dragToRange;
    
    @FindBy(xpath="//div[@class='_1YokD2 _3Mn1Gg']//div[contains(@class,'col')]//div[contains(@data-id,'MOBF')]/descendant::div//a//div[contains(@class,'jeq')]")
    List<WebElement> mobileprice;
    
    @FindBy(xpath="//li[contains(@class,'col')]/button")
    WebElement addToCart;
    
    @FindBy(xpath="//div[contains(@class,'_3uDYxP')]/select")
    WebElement filter;
    
    @FindBy(xpath="//div[contains(@class,'_3uDYxP')]/select/option")
    List<WebElement> options;
    
  
    
  
    public mobile(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
    
    public void search(String item) {
    	Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	search.sendKeys(item); 
    	robot.keyPress(KeyEvent.VK_ENTER);
    	
    }
    
    public void dragAnddrop() {
    	Actions builder = new Actions(driver);
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	int xOffset1 = dragFromRange.getLocation().getX();
    	 
    	 xOffset1 =xOffset1+100;
    	 
    	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 builder.dragAndDropBy(dragFromRange, xOffset1, 0).perform();
    	 
    	 filter.click();
    	 for(int i=1;i<4;i++) {
    		if(options.get(i).getText()=="13000") {
    			options.get(i).click();
    			break;
    		}
    	 }
    	 
    	 
    	 try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	
    }
    
    public void selectMobile() {
    	Actions builder = new Actions(driver);
    	String small =mobileprice.get(0).getText();
    	WebElement element = mobileprice.get(0);
    	for(int i=1;i<4;i++) {
    		String str =mobileprice.get(i).getText();
    		if(Integer.valueOf(small.substring(1))>(Integer.valueOf(str.substring(1)))) {
    			element=mobileprice.get(i);
    		}	
    	}
    builder.doubleClick(element);
    }
    
    
    public void addToCart(){

    	addToCart.click();

}
    
  
    

  
   
}
