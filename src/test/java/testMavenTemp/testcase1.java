package testMavenTemp;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

public class testcase1{
	//ReadExcel objExcelFile = new ReadExcel();
	WebDriver driver;
	/*@BeforeSuite
	public void bsuite() throws IOException {
		  
		  driver=new FirefoxDriver();
			driver.get("https://www.google.co.in");
			  String filePath = "C:\\ToolsQA\\testMavenTemp\\testdata";

			  objExcelFile.readExcel1(filePath,"data.xls","objectrep");	 
	  }*/
	
	@BeforeTest
    public void beforeTest() throws IOException {
		 WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.co.in");
		  String filePath = "C:\\ToolsQA\\testMavenTemp\\testdata";

		  ReadExcel.readExcel1(filePath,"data.xls","objectrep");	 
	}

  @Test
  public void f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
	  System.out.println(ReadExcel.getObjectloc("company"));
	  
	  //System.out.println(ReadExcel.getObjectloc("googleSearchbtn"));
	  //String d1=driver.findElement(By.xpath(ReadExcel.getObjectloc("googleSearchbtn"))).getAttribute("value");
	  //System.out.println(d1);
	  //System.out.println(driver.findElement(By.xpath(ReadExcel.getObjectloc("googleSearchbtn"))));
	  
	  System.out.println(ReadExcel.methodtest(
			  
			  
			  
			  
			  ,"xpath").getAttribute("value"));
	  System.out.println("ffffffffffffffffffffffffffff");
  }
  @Test()
  public void f2() {
	  //System.out.println(ReadExcel.getObjectloc("luckybtn"));
	  //String d2=driver.findElement(By.xpath(ReadExcel.getObjectloc("luckybtn"))).getAttribute("value");
	 // System.out.println(d2);
  }
  @Test
  public void f3() {
	  System.out.println(ReadExcel.getObjectloc("firstname1"));
  }
	  
  }

