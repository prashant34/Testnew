package testMavenTemp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ReadExcel {
	static WebDriver driver;
	static HashMap<String,String> repositoryMap=new HashMap<String,String>();
	public static HashMap<String, String> readExcel1(String filePath,String fileName,String sheetName) throws IOException{
		
        File file =    new File(filePath+"\\"+fileName);

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook testdatabook = null;

	   testdatabook = new HSSFWorkbook(inputStream);


	    Sheet testdataSheet =testdatabook.getSheet(sheetName);

	    int rowCount = testdataSheet.getLastRowNum()-testdataSheet.getFirstRowNum();

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = testdataSheet.getRow(i);

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	           
	            String data=row.getCell(j).getStringCellValue();
                String[] values= data.split("::");
                String key=values[0];
                String value=values[1];
                repositoryMap.put(key,value); 
                
	        }
	        
	        System.out.println();
	        
	    }
	    testdatabook.close();
	    return repositoryMap;
	    }
	
	public static String getObjectloc(String objetcname){
		 String t=repositoryMap.get(objetcname);
		return t;
		
	}
	public static WebElement methodtest(String key,String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException{
		
		
		//By by = By.xpath(key);
		Method method = By.class.getDeclaredMethod(methodName,String.class);
		By by =  (By)method.invoke(null, key);
		System.out.println(by);
		
		
		/*Class myObjectClass = By.class;
		Object obj=myObjectClass.newInstance();
		 Method[] method = myObjectClass.getMethods();
		 for (Method method2:method)
	            System.out.println(method2.getName());
		 System.out.println("ffffffffffffffffffffffffffffffffffffff");
		 //Here the method takes a string parameter if there is no param, put null.
		 Method method1 = myObjectClass.getMethod("var2", String.class); */
		 WebElement wbb=driver.findElement(by);
      //System.out.println(wbb);
      return wbb;
		
	}
	 
	
	/*public static void main(String[] args) throws IOException{

		   

		 //ReadExcel objExcelFile = new ReadExcel();

		    String filePath = "C:\\ToolsQA\\testMavenTemp\\testdata";

		    ReadExcel.readExcel1(filePath,"data.xls","objectrep");
		 System.out.println(ReadExcel.getObjectloc("company"));
		 
		 
		    }*/

}
