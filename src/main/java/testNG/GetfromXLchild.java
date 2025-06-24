package testNG;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class GetfromXLchild extends GetfromXL{
	@BeforeMethod
    public static void orghrm() throws IOException {
    Lc(1,0); 
    Wb(12,0,2,0);
	Wb(12,1,2,1);
	id(3,0);	   	   	  	           
    }
    @Test(priority = 1)
    public static void CreateEmployee() throws IOException {   	      	   
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
    id(9,0);        
    xp(11,0);  
    ce();   
    }
    }

