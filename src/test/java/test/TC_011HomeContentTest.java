package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import page.LoginPage;

public class TC_011HomeContentTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() {
		
		testName="HomeContent test";
		testAuthor="Sharmila";
		testCategory="Smoketest";
		testDescription="Home Content test with positive scenarios";
		
	}
	
	@Test
	public void HomeContentTest() throws IOException
	{
		LoginPage obj=new LoginPage(driver);
		          obj.LogoScreenshot()
		             .CheckQueryEmail()
		             .checkEmailClickable();
	}
	
	

}
