package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {

	public static WebDriver driver;
	
	public String SheetName;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testCategory,testAuthor;
	
	public static void LaunchAndLoadUrl(String url, String browser)
	{
		if(browser.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	public void closeBrowser()
	{
		driver.close();
	}
	public static String[][] readExcelData(String SheetName) throws IOException{
		
		XSSFWorkbook book=new XSSFWorkbook("D:\\JavaWorkspace\\HotelReservation.Project\\src\\test\\resources\\data\\HotelBookingData.xlsx");
		XSSFSheet sheet=book.getSheet(SheetName);
		int rowCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		
		String[][] data= new String[rowCount][columnCount];
		for(int i=1;i<=rowCount;i++)
		{
            XSSFRow row = sheet.getRow(i);
			
			for(int j = 0; j < columnCount; j++) 
			{
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i-1][j]=cell.getStringCellValue();
	        }
		}
		book.close();
		return data;
	}
public static String screenshot(String name) throws IOException {
		
		String path="D:\\JavaWorkspace\\HotelReservation.Project\\Screenshot\\"+name+".png";
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
}

