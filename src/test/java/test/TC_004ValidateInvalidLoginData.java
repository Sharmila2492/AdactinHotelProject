package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.LoginPage;

public class TC_004ValidateInvalidLoginData extends ProjectSpecificationMethods{

	
	@BeforeTest
	public void setup() {
		
		SheetName="InvalidLoginData";
		testName="ValidateLogin test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Login test with Negative scenarios ";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void ValidateInvalidLogin(String Un, String pass, String Testtype, String Expectedresult)
	{
		LoginPage obj = new LoginPage(driver);
		
		         obj.EnterLUn(Un)
		             .EnterLPass(pass)
		             .ClickLoginInvalid()
		              .validateLoginDetails(Testtype, Expectedresult)
		             .validateForgotSubmissionForm(Testtype, Expectedresult);
	}
	
}
