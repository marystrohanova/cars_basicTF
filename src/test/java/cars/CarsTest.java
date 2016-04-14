package cars;

import junit.framework.Assert;

import org.testng.annotations.Test;

import framework.FrameworkBase;
import framework.page.CarsFrontPage;
import framework.page.CarsResultPage;

public class CarsTest extends FrameworkBase{
	
  @Test
  public void mcLarenSearchTest() {
	  String carMake = "McLaren";
	  String carModel = "650S";
	  String radius = "All Miles";
	  String zip = "60026";
	  
	  String perPage = "10 Per Page";
	  
	  CarsFrontPage frontPage = new CarsFrontPage();
	  frontPage.open();
	  frontPage.selectCarMake(carMake);
	  frontPage.selectCarModel(carModel);
	  frontPage.selectRadiusl(radius);
	  frontPage.enterZip(zip);
	  frontPage.clickSubmitBtn();
	  
	  CarsResultPage resultPage = new CarsResultPage();
	  int firsResult = resultPage.checkNumberOfResults();
	  resultPage.selectPagination(perPage);
	  int secondResult = resultPage.checkNumberOfResults();
	  Assert.assertNotSame("Count was same", firsResult, secondResult);
	  
  }
}
