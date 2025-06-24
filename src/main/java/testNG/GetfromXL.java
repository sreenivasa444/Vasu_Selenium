package testNG;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
    import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.ExtentTest;
    import com.aventstack.extentreports.Status;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


	       public class GetfromXL {

	       static ExtentReports extent = new ExtentReports();
	       static ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
		   static WebDriver driver;
	       static String R;     
	       public static void Sk(int a,int b,String c) throws IOException {
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(a).getCell(b);
	       String username = cell.toString();   
	       driver.findElement(By.id(username)).sendKeys(c);  	    	   
	       }       
	       public static void ce() {   	   
	    	   driver.close(); 	   
	       }
	       public static void Wb(int R, int C,int I,int x1) throws IOException {
			   
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell1 = sheet.getRow(R).getCell(C);
	       String username1 = cell1.toString();
	       XSSFCell cell = sheet.getRow(I).getCell(x1);
	       String username = cell.toString();
	       Skkeysid(username1,username);
		   }	  
	       public static void cl(int r,int c) throws IOException {
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(r).getCell(c);
	       String username = cell.toString();
	       clear(username);
	       }   	     
	       public static void Lc(int L, int A) throws IOException {
	       WebDriverManager.firefoxdriver().setup();
	       driver=new FirefoxDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(L).getCell(A);
	       String username = cell.toString();
	       driver.get(username);          
	       }     
	       public static void xp(int x,int z) throws IOException {
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(x).getCell(z);
	       String username = cell.toString();
	       driver.findElement(By.xpath(username)).click();                 
	       }
	       public static void id(int x,int z) throws IOException {
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(x).getCell(z);
	       String username = cell.toString();
	       driver.findElement(By.id(username)).click();               	           	   
	       }              
	       public static void Skkeys(String xpath,String Skkeys) {
	       driver.findElement(By.xpath(xpath)).sendKeys(Skkeys);
	       }                
	       public static void click(String xpath) {
	       driver.findElement(By.xpath(xpath)).click();
	       }      
	       public static void Skkeysid(String id,String Skkeys) {
	       driver.findElement(By.id(id)).sendKeys(Skkeys);
	       }
	       public static void clickid(String id) {
	       driver.findElement(By.id(id)).click();
	       }
	       public static void clear(String id) {
	       driver.findElement(By.id(id)).clear();
	       }
	       public static void rs(int a,int b) throws IOException {
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(a).getCell(b);
	       String username = cell.toString();   	  	   
	       String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	       String B = "abcdefghijklmnopqrstuvwxyz";
	       int length = 5; 
	       String values = A+B;
	       Random randomGenerator = new Random();        
	       StringBuilder sb = new StringBuilder();
	       for(int i = 0; i < length; i++) {
	       int index = randomGenerator.nextInt(values.length());
	       char randomChar = values.charAt(index);
	       sb.append(randomChar);
	       }               
	       System.out.println(sb.toString());
	       Skkeys(username,sb.toString());    
	       }
	      
	       public static void Rn(int a,int b) throws IOException {
	       File src=new File("C:\\eclipseework\\eclipse\\testNG\\VASU@.xlsx");
	       FileInputStream finput = new FileInputStream(src);
	       XSSFWorkbook workbook = new XSSFWorkbook(finput);
	       XSSFSheet sheet = workbook.getSheetAt(0);
	       XSSFCell cell = sheet.getRow(a).getCell(b);
	       String username = cell.toString();   	         	   
		  
	       
	       
	       String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	       String C = "0123456789";
	       int length = 5; 
	       String values = A+C;
	       Random randomGenerator = new Random();        
	       StringBuilder sb = new StringBuilder();
	       for(int i = 0; i < length; i++) {
	       int index = randomGenerator.nextInt(values.length());
	       char randomChar = values.charAt(index);
	       
	       sb.append(randomChar);
	       
	       R=sb.toString(); 
	       }
	       Skkeys(username,sb.toString());  
	       }         	    
	       @BeforeMethod      
	       public static void orghrm() throws IOException {
	       extent.attachReporter(spark);
	       Lc(1,0); 
	       Wb(12,0,2,0);
		   Wb(12,1,2,1);
		   id(3,0);	   	   	  	           
	       }
	       @Test(priority = 1)
	       public static void CreateEmployee() throws IOException {   	      
	       ExtentTest test =extent.createTest("Create Employee");
	       test.log(Status.PASS,"Created Employee");
	       test.pass("Created Employee");
	       id(3,1);   
	       id( 4,0);  
	       rs(16,0);
	       rs(16,1);      
	       cl(9,1);                      
	       Rn(17,0);
	       id( 4,1);       
	       id(5,0);  
	       Sk(18,0,R);       
	       id( 5,1);     
	       }       
	       @Test(priority = 2)
	       public static void EditEmployee() throws IOException  {
	       ExtentTest test =extent.createTest("Edited Employee");
	       test.log(Status.PASS,"Edited Employee");
	       test.pass("Edited Employee");
	       id(3,1); 
	       id(5,0);        
	       Sk(18,1,R);       
	       id(6,0);     
	       xp(14,1);
	       id(6,1);   
	       cl(15,0);               
	       Sk(19,0,"SQA"+R);  
	       id(7,0);       
	       id(5,0);                  
	       Sk(20,0,R);
	       id(7,1);     
	       
	       }
	       @Test(priority = 3)
	       public static void DeleteEmployee() throws IOException  {   	   
	       ExtentTest test =extent.createTest("Deleted Employee");
	       test.log(Status.PASS,"Deleted Employee");
	       test.pass("Deleted Employee");
	       id(3,1);   
	       id(5,0);    	   
	       Sk(20,1,"SQA"+R);
	       id(7,1);                   
	       xp(13,0);         
	       id(8,0);      
	       id(8,1);            
	       }         
	       @AfterMethod
	       public static void Logout() throws IOException {   	
	       ExtentTest test =extent.createTest("Logout");
	       test.log(Status.PASS,"Logout Employee");
	       test.pass("Logout");
	       id(9,0);        
	       xp(11,0);  
	       ce();   
	       extent.flush();
	       }
	       }



