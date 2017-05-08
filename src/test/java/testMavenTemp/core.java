package testMavenTemp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.WTypes.LPSTR.ByReference;

public class core {
	ReadExcel objExcelFile = new ReadExcel();
	WebDriver driver;
	@BeforeSuite
	public void bsuite() throws IOException {
		  
		  driver=new FirefoxDriver();
			driver.get("https://www.google.co.in");
			  String filePath = "C:\\ToolsQA\\testMavenTemp\\testdata";

			  objExcelFile.readExcel1(filePath,"data.xls","objectrep");	 
	  }
	
	/*@BeforeTest
    public void beforeTest() throws IOException {
		 WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.co.in");
		  String filePath = "C:\\ToolsQA\\testMavenTemp\\testdata";

		  objExcelFile.readExcel1(filePath,"data.xls","objectrep");	 
	}*/

  }
