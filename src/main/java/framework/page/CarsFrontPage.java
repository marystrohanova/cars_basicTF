package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class CarsFrontPage {
	String url = "https://www.cars.com/";
	
	By selectMakeSlct = new By.ByCssSelector("select[ng-model='selections.make']");
	By selectModelSlct = new By.ByCssSelector("select[ng-model='selections.model']");
	By selectRadiusSlct = new By.ByCssSelector("select[ng-model='selections.radius']");
	By inputZip = new By.ByCssSelector("input.zip-field");
	By btnSubmit = new By.ByCssSelector("input[type='submit']");
	
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public CarsFrontPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void open(){
		System.out.println("Loading page: " + url);
		driver.get(url);
		 driver.manage().window().maximize();

	}
	
	public void selectCarMake(String carMake){
		Select select = new Select(driver.findElement(selectMakeSlct));
		select.selectByVisibleText(carMake);
	}
	
	public void selectCarModel(String carModel){
		Select select = new Select(driver.findElement(selectModelSlct));
		select.selectByVisibleText(carModel);
	}
	
	public void selectRadiusl(String radius){
		Select select = new Select(driver.findElement(selectRadiusSlct));
		select.selectByVisibleText(radius);
	}
	
	public void enterZip(String zip){
		WebElement weZiplInput = driver.findElement(inputZip);
		weZiplInput.sendKeys(zip);
	}
	
	public void clickSubmitBtn(){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "document.querySelector('input[type=\"submit\"]').click()";
        jsExecutor.executeScript(script, "");
	}

}
