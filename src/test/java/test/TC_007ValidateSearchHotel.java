package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.LoginPage;

public class TC_007ValidateSearchHotel extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void setup() {
		
		SheetName="InvalidSelectHotel";
		testName="Search Hotel test with InvalidData";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Search Hotel test with negative scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void SearchHotelsTest(String Un, String pass, String checkIn, String Checkout)
	{
		LoginPage obj=new LoginPage(driver);
		          obj.EnterLUn(Un)
		             .EnterLPass(pass)
		             .ClickLogin()
		             .InSelectLocation()
		             .InSelectNumOfRooms()
		             .CheckIn(checkIn)
		             .CheckOut(Checkout)
		             .InAdultsPerRoom()
		             .InvalidHotelSearch()
		             .LocationErrorText()
		             .NumOfRoomsErrorText()
		             .InAdultsPerRoom()
		             .CheckReset();

}
}

