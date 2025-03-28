package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.LoginPage;

public class TC_001RegisterTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		
		SheetName="RegisterData";
		testName="Register test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Register test with positive scenarios";
		
	}
	
	@Test(dataProvider = "readData")
	
	public void ValidRegisterTest(String userName, String pass, String conpass, String fullName, String email ) throws InterruptedException
	{
		LoginPage obj=new LoginPage(driver);
		          obj.ClickRegister()
		          .EnterUN(userName)
		          .EnterPass(pass)
		          .EnterConPass(conpass)
		          .EnterFName(fullName)
		          .EnterEmail(email)
		          .ClickCaptcha()
		          .ClickCheckBox()
		          .ClickRegBtn()
		         // .VerifyRegCode()
		          .LoginLink();
		          
	} 

}
