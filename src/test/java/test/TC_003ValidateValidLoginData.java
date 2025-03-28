package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.LoginPage;

public class TC_003ValidateValidLoginData extends ProjectSpecificationMethods {

	@BeforeTest
	public void setup() {
		
		SheetName="validLoginData";
		testName="ValidateLogin test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Login test with Positive scenarios ";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void ValidateLogin(String Un, String pass)
	{
		LoginPage obj = new LoginPage(driver);
		          obj.EnterLUn(Un)
		             .EnterLPass(pass)
		             .ClickLogin()
		             .verifyLogin();
}
}
