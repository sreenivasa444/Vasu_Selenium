package testNG;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MavenProject {
		
		       public static void Launch(String xpath) {
			   driver.get(xpath);
		       }
		       public static void Sendkeys(String xpath,String sendkeys) {
		       driver.findElement(By.xpath(xpath)).sendKeys(sendkeys);
		       }
		       public static void click(String xpath) {
			   driver.findElement(By.xpath(xpath)).click();
		       }
		       public static void Sendkeysid(String id,String sendkeys) {
			   driver.findElement(By.id(id)).sendKeys(sendkeys);
			   }
		       public static void clickid(String id) {
		       driver.findElement(By.id(id)).click();
		       }
		       public static void clear(String id) {
		       driver.findElement(By.id(id)).clear();
		       }
		       static WebDriver driver;
	           static String R;
	           @BeforeMethod
	         
		     public static void orghrm() {     
	         WebDriverManager.firefoxdriver().setup();
	
	         driver=new FirefoxDriver();
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
	         Launch("http://164.52.221.185:9080/");
	         System.out.println("Launch OrangeHRM Applaction Successfully");
	         login("INDUKURIADMIN","#V@su(27)");
		       }	                  
	         public static void login(String username,String password) {        	   
	         Sendkeysid("txtUsername",username);
	         Sendkeysid("txtPassword",password);
		       clickid("btnLogin");
		       System.out.println("Login Successfully");	        
	         } 
	  	    	     
	           @Test(priority = 1)
	         
	           public static void createemp() {
	      	   
	  	       click("//b[text()='PIM']");
		       click("//a[text()='Add Employee']");
		       
		       String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		       String B = "abcdefghijklmnopqrstuvwxyz";
		       String C = "0123456789";
		       String D="!@#$%^&*";
		       int length = 5; 
		       String values = A+B;
		       Random randomGenerator = new Random();        
		       StringBuilder sb = new StringBuilder();
		       for(int i = 0; i < length; i++) {
		       int index = randomGenerator.nextInt(values.length());
		       char randomChar = values.charAt(index);
		       sb.append(randomChar);
		       } 	            
		       Sendkeysid("firstName",sb.toString());	   
		       
		       String values1 = A+B;
		       Random randomGenerator1 = new Random();        
		       StringBuilder s1 = new StringBuilder();
		       for(int i = 0; i < length; i++) {
		       int index1 = randomGenerator1.nextInt(values1.length());
		       char randomChar1 = values1.charAt(index1);
		       s1.append(randomChar1);
		       }            
		       Sendkeysid("lastName",s1.toString());
		       clear("employeeId");	 	          
		       int length2 = 3;
		       String values2 = C+D;
		       Random randomGenerator2 = new Random();  
		       StringBuilder sb2 = new StringBuilder();
		       for(int i = 0; i < length2; i++) {           
		       int index = randomGenerator2.nextInt(values2.length());	            
		       char randomChar2 = values2.charAt(index);
		       sb2.append(randomChar2);
		       R=sb2.toString();
		       }
		       System.out.println("Current empid===S"+R);
		       System.out.println("Successfully created Successfully");
		        	       
		       Sendkeysid("employeeId","S"+sb2.toString());
		       clickid("btnSave");
		       click("//a[text()='Employee List']");
		       Sendkeysid("empsearch_id","S"+R);
		       clickid("searchBtn");
			   }
	           @Test(priority = 2)
	  
	           public static void editemp()  {
	 	
	  	       click("//b[text()='PIM']");
	  	       click("//a[text()='Employee List']");
	  	       Sendkeysid("empsearch_id","S"+R);
		       clickid("searchBtn");
			   click("(//td[@class=\"left\"])[1]"); 		       
		       clickid("btnSave"); 
		       clear("personal_txtEmployeeId");                	      
			   System.out.println("New empid==="+"SS"+R);
			   Sendkeysid("personal_txtEmployeeId","SS"+R);                	       	       
		       clickid("btnSave");               
		       clickid("menu_pim_viewEmployeeList"); 
		       Sendkeysid("empsearch_id","S"+R);
		       clickid("searchBtn");                
		       boolean x = driver.findElement(By.xpath("//td[text()='No Records Found']")).isDisplayed();
		       if(x) {
 	    	 System.out.println("Employee id edited Successfully");  
		       }else {
		    	   System.out.println("Empid not Edited ");  
		       }}
	           @Test(priority = 3)  
	          
	           static void empdelete()  {	       	   
	           click("//b[text()='PIM']");
			   clickid("menu_pim_viewEmployeeList");		      		       
			   Sendkeysid("empsearch_id","SS"+R);		       		   
		       clickid("searchBtn");               		       
		       click("//th[@class=\"checkbox-col\"]");
		       clickid("btnDelete");
		       clickid("dialogDeleteBtn");		       
		       boolean z = driver.findElement(By.xpath("//td[text()='No Records Found']")).isDisplayed();
		       if(z) {
		    	 System.out.println("Deleted Employee id Successfully");  
		       }else {
		    	   System.out.println("Employee id not Deleted  ");  
		       }		
		       }
	           @AfterMethod	         
	           public static void logout() {	      	   
	           click("//a[text()='Welcome INDUKURI']");
	    	   click("//a[text()='Logout']");
		       System.out.println("Logout Succesfully");
		       driver.close();
	           }	   
	      	   }

