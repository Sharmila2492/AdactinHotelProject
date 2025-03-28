package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.LoginPage;

public class TC_005SearchHoteltest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		
		SheetName="SelectHotelsData";
		testName="Search Hotel test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Search Hotel test with Positive scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void SearchHotelsTest(String Un, String pass, String checkIn, String Checkout)
	{
		LoginPage obj=new LoginPage(driver);
		          obj.EnterLUn(Un)
		          .EnterLPass(pass)
		          .ClickLogin()
		          .SelectLocation()
		          .SelectHotels()
		          .SelectRoomType()
		          .SelectNumOfRooms()
		          .CheckIn(checkIn)
		          .CheckOut(Checkout)
		          .AdultsPerRoom()
		          .ChildPerRoom()
		          .ClickSearch()
		          .WelcomeMenu();
	}

}
