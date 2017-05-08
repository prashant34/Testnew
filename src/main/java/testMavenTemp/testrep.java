package testMavenTemp;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class testrep implements ITestListener {
	WebDriver driver=null;
	
	
	static DateFormat df = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss");
	static String filePath = "C:\\SCREENSHOTS1\\Screens_"+df.format(new Date());
	
	public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	
    	takeScreenShot(methodName);
    }
    
    public void takeScreenShot(String methodName) {
    	//get the driver
    	driver=new FirefoxDriver();
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 System.out.println("src file : "+scrFile.getAbsolutePath());
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+"\\"+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("***Placed tydttttttttttttttttttttttttt ***");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("***Placed tydttttttttttttttttttttttttt ***");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("***Placed tydttttttttttttttttttttttttt ***");
		
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("***Placed tydttttttttttttttttttttttttt ***");
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("***Placed tydttttttttttttttttttttttttt ***");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("***Placed tydttttttttttttttttttttttttt ***");
		
	}
}  