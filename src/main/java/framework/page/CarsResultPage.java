package framework.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;

public class CarsResultPage {
	By divResul = new By.ByCssSelector("cars-shop-listings.result-listings");
	By divListing = new By.ByCssSelector("div.listing");
	By selectPagination = new By.ByCssSelector("select[ng-model='pagination.selectedPerPage']");
	By spinerInactive = new By.ByCssSelector("div.srp-spinner.inactive");

	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public CarsResultPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public int checkNumberOfResults(){
		wait.until(ExpectedConditions.presenceOfElementLocated(spinerInactive));
		wait.until(ExpectedConditions.presenceOfElementLocated(divResul));
		
		List<WebElement> weDivListing = driver.findElements(divListing);
		int resultCount = weDivListing.size();
		System.out.println("Number of result found: " + resultCount);
		return resultCount;
	}
	
	public void selectPagination(String perPage){
		Select select = new Select(driver.findElement(selectPagination));
		select.selectByVisibleText(perPage);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(spinerInactive));
		wait.until(ExpectedConditions.presenceOfElementLocated(divResul));
		
	}

}
